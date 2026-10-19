package ni.shikatu.okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Cache;
import ni.shikatu.okhttp3.Call;
import ni.shikatu.okhttp3.EventListener;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.Interceptor;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal.UnreadableResponseBodyKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.connection.RealCall;
import ni.shikatu.okhttp3.internal.http.HttpHeaders;
import ni.shikatu.okhttp3.internal.http.HttpMethod;
import ni.shikatu.okhttp3.internal.http.RealResponseBody;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/CacheInterceptor;", "Lni/shikatu/okhttp3/Interceptor;", "cache", "Lni/shikatu/okhttp3/Cache;", "<init>", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "intercept", "Lni/shikatu/okhttp3/Response;", "chain", "Lni/shikatu/okhttp3/Interceptor$Chain;", "cacheWritingResponse", "cacheRequest", "Lni/shikatu/okhttp3/internal/cache/CacheRequest;", "response", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final Cache cache;

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        EventListener eventListener$okhttp;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        Response cacheCandidate = cache != null ? cache.get$okhttp(CacheInterceptorKt.requestForCache(chain.request())) : null;
        long now = System.currentTimeMillis();
        CacheStrategy strategy = new CacheStrategy.Factory(now, chain.request(), cacheCandidate).compute();
        Request networkRequest = strategy.getNetworkRequest();
        Response cacheResponse = strategy.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(strategy);
        }
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        if (realCall == null || (eventListener$okhttp = realCall.getEventListener$okhttp()) == null) {
            eventListener$okhttp = EventListener.NONE;
        }
        EventListener listener = eventListener$okhttp;
        if (cacheCandidate != null && cacheResponse == null) {
            _UtilCommonKt.closeQuietly(cacheCandidate.body());
        }
        if (networkRequest == null && cacheResponse == null) {
            Response it = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            listener.satisfactionFailure(call, it);
            return it;
        }
        if (networkRequest == null) {
            Intrinsics.checkNotNull(cacheResponse);
            Response it2 = cacheResponse.newBuilder().cacheResponse(UnreadableResponseBodyKt.stripBody(cacheResponse)).build();
            listener.cacheHit(call, it2);
            return it2;
        }
        if (cacheResponse != null) {
            listener.cacheConditionalHit(call, cacheResponse);
        } else if (this.cache != null) {
            listener.cacheMiss(call);
        }
        try {
            Response networkResponse = chain.proceed(networkRequest);
            if (networkResponse == null && cacheCandidate != null) {
                _UtilCommonKt.closeQuietly(cacheCandidate.body());
            }
            if (cacheResponse != null) {
                boolean z = false;
                if (networkResponse != null && networkResponse.code() == 304) {
                    z = true;
                }
                if (z) {
                    Response response = cacheResponse.newBuilder().headers(Companion.combine(cacheResponse.headers(), networkResponse.headers())).sentRequestAtMillis(networkResponse.sentRequestAtMillis()).receivedResponseAtMillis(networkResponse.receivedResponseAtMillis()).cacheResponse(UnreadableResponseBodyKt.stripBody(cacheResponse)).networkResponse(UnreadableResponseBodyKt.stripBody(networkResponse)).build();
                    networkResponse.body().close();
                    Cache cache3 = this.cache;
                    Intrinsics.checkNotNull(cache3);
                    cache3.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, response);
                    listener.cacheHit(call, response);
                    return response;
                }
                _UtilCommonKt.closeQuietly(cacheResponse.body());
            }
            Intrinsics.checkNotNull(networkResponse);
            Response response2 = networkResponse.newBuilder().cacheResponse(cacheResponse != null ? UnreadableResponseBodyKt.stripBody(cacheResponse) : null).networkResponse(UnreadableResponseBodyKt.stripBody(networkResponse)).build();
            if (this.cache != null) {
                Request cacheNetworkRequest = CacheInterceptorKt.requestForCache(networkRequest);
                if (HttpHeaders.promisesBody(response2) && CacheStrategy.Companion.isCacheable(response2, cacheNetworkRequest)) {
                    CacheRequest cacheRequest = this.cache.put$okhttp(response2.newBuilder().request(cacheNetworkRequest).build());
                    Response responseCacheWritingResponse = cacheWritingResponse(cacheRequest, response2);
                    if (cacheResponse != null) {
                        listener.cacheMiss(call);
                    }
                    return responseCacheWritingResponse;
                }
                if (HttpMethod.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException e) {
                    }
                }
            }
            return response2;
        } catch (Throwable th) {
            if (cacheCandidate != null) {
                _UtilCommonKt.closeQuietly(cacheCandidate.body());
            }
            throw th;
        }
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink cacheBodyUnbuffered = cacheRequest.body();
        final BufferedSource source = response.body().source();
        final BufferedSink cacheBody = Okio.buffer(cacheBodyUnbuffered);
        Source source2 = new Source() {
            private boolean cacheRequestClosed;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                try {
                    long bytesRead = source.read(sink, byteCount);
                    if (bytesRead == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            cacheBody.close();
                        }
                        return -1L;
                    }
                    sink.copyTo(cacheBody.getBuffer(), sink.size() - bytesRead, bytesRead);
                    cacheBody.emitCompleteSegments();
                    return bytesRead;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                        throw e;
                    }
                    throw e;
                }
            }

            @Override
            public Timeout timeout() {
                return source.timeout();
            }

            @Override
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        };
        String contentType = Response.header$default(response, "Content-Type", null, 2, null);
        long contentLength = response.body().contentLength();
        return response.newBuilder().body(new RealResponseBody(contentType, contentLength, Okio.buffer(source2))).build();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/CacheInterceptor$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "combine", "Lni/shikatu/okhttp3/Headers;", "cachedHeaders", "networkHeaders", "isEndToEnd", _UrlKt.FRAGMENT_ENCODE_SET, "fieldName", _UrlKt.FRAGMENT_ENCODE_SET, "isContentSpecificHeader", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Headers combine(Headers cachedHeaders, Headers networkHeaders) {
            Headers.Builder result = new Headers.Builder();
            int size = cachedHeaders.size();
            for (int index = 0; index < size; index++) {
                String fieldName = cachedHeaders.name(index);
                String value = cachedHeaders.value(index);
                if ((!StringsKt.equals("Warning", fieldName, true) || !StringsKt.startsWith$default(value, "1", false, 2, (Object) null)) && (isContentSpecificHeader(fieldName) || !isEndToEnd(fieldName) || networkHeaders.get(fieldName) == null)) {
                    result.addLenient$okhttp(fieldName, value);
                }
            }
            int size2 = networkHeaders.size();
            for (int index2 = 0; index2 < size2; index2++) {
                String fieldName2 = networkHeaders.name(index2);
                if (!isContentSpecificHeader(fieldName2) && isEndToEnd(fieldName2)) {
                    result.addLenient$okhttp(fieldName2, networkHeaders.value(index2));
                }
            }
            return result.build();
        }

        private final boolean isEndToEnd(String fieldName) {
            return (StringsKt.equals("Connection", fieldName, true) || StringsKt.equals("Keep-Alive", fieldName, true) || StringsKt.equals("Proxy-Authenticate", fieldName, true) || StringsKt.equals("Proxy-Authorization", fieldName, true) || StringsKt.equals("TE", fieldName, true) || StringsKt.equals("Trailers", fieldName, true) || StringsKt.equals("Transfer-Encoding", fieldName, true) || StringsKt.equals("Upgrade", fieldName, true)) ? false : true;
        }

        private final boolean isContentSpecificHeader(String fieldName) {
            return StringsKt.equals("Content-Length", fieldName, true) || StringsKt.equals("Content-Encoding", fieldName, true) || StringsKt.equals("Content-Type", fieldName, true);
        }
    }
}
