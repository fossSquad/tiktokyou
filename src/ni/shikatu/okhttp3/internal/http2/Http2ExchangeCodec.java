package ni.shikatu.okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.http.ExchangeCodec;
import ni.shikatu.okhttp3.internal.http.HttpHeaders;
import ni.shikatu.okhttp3.internal.http.RealInterceptorChain;
import ni.shikatu.okhttp3.internal.http.RequestLine;
import ni.shikatu.okhttp3.internal.http.StatusLine;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Socket;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0013H\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)H\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020!H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2ExchangeCodec;", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec;", "client", "Lni/shikatu/okhttp3/OkHttpClient;", "carrier", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec$Carrier;", "chain", "Lni/shikatu/okhttp3/internal/http/RealInterceptorChain;", "http2Connection", "Lni/shikatu/okhttp3/internal/http2/Http2Connection;", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/ExchangeCodec$Carrier;Lokhttp3/internal/http/RealInterceptorChain;Lokhttp3/internal/http2/Http2Connection;)V", "getCarrier", "()Lokhttp3/internal/http/ExchangeCodec$Carrier;", "stream", "Lni/shikatu/okhttp3/internal/http2/Http2Stream;", "protocol", "Lni/shikatu/okhttp3/Protocol;", "canceled", _UrlKt.FRAGMENT_ENCODE_SET, "isResponseComplete", "()Z", "socket", "Lni/shikatu/okio/Socket;", "getSocket", "()Lokio/Socket;", "createRequestBody", "Lni/shikatu/okio/Sink;", "request", "Lni/shikatu/okhttp3/Request;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "writeRequestHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "flushRequest", "finishRequest", "readResponseHeaders", "Lni/shikatu/okhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "response", "Lni/shikatu/okhttp3/Response;", "openResponseBodySource", "Lni/shikatu/okio/Source;", "peekTrailers", "Lni/shikatu/okhttp3/Headers;", "cancel", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Http2ExchangeCodec implements ExchangeCodec {
    private volatile boolean canceled;
    private final ExchangeCodec.Carrier carrier;
    private final RealInterceptorChain chain;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;
    public static final Companion Companion = new Companion(null);
    private static final String CONNECTION = "connection";
    private static final String HOST = "host";
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String ENCODING = "encoding";
    private static final String UPGRADE = "upgrade";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = _UtilJvmKt.immutableListOf(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = _UtilJvmKt.immutableListOf(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    public Http2ExchangeCodec(OkHttpClient client, ExchangeCodec.Carrier carrier, RealInterceptorChain chain, Http2Connection http2Connection) {
        Protocol protocol;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(carrier, "carrier");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.carrier = carrier;
        this.chain = chain;
        this.http2Connection = http2Connection;
        if (client.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.protocol = protocol;
    }

    @Override
    public ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override
    public boolean isResponseComplete() {
        Http2Stream http2Stream = this.stream;
        return http2Stream != null && http2Stream.isSourceComplete();
    }

    @Override
    public Socket getSocket() {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream;
    }

    @Override
    public Sink createRequestBody(Request request, long contentLength) {
        Intrinsics.checkNotNullParameter(request, "request");
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.getSink();
    }

    @Override
    public void writeRequestHeaders(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.stream != null) {
            return;
        }
        boolean hasRequestBody = request.body() != null;
        this.stream = this.http2Connection.newStream(Companion.http2HeadersList(request), hasRequestBody);
        if (this.canceled) {
            Http2Stream http2Stream = this.stream;
            Intrinsics.checkNotNull(http2Stream);
            http2Stream.closeLater(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream2 = this.stream;
        Intrinsics.checkNotNull(http2Stream2);
        http2Stream2.readTimeout().timeout(this.chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        Http2Stream http2Stream3 = this.stream;
        Intrinsics.checkNotNull(http2Stream3);
        http2Stream3.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void flushRequest() throws IOException {
        this.http2Connection.flush();
    }

    @Override
    public void finishRequest() throws IOException {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        http2Stream.getSink().close();
    }

    @Override
    public Response.Builder readResponseHeaders(boolean expectContinue) throws IOException {
        Http2Stream stream = this.stream;
        if (stream == null) {
            throw new IOException("stream wasn't created");
        }
        Headers headers = stream.takeHeaders(expectContinue);
        Response.Builder responseBuilder = Companion.readHttp2HeadersList(headers, this.protocol);
        if (expectContinue && responseBuilder.getCode$okhttp() == 100) {
            return null;
        }
        return responseBuilder;
    }

    @Override
    public long reportedContentLength(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (HttpHeaders.promisesBody(response)) {
            return _UtilJvmKt.headersContentLength(response);
        }
        return 0L;
    }

    @Override
    public Source openResponseBodySource(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.getSource();
    }

    @Override
    public Headers peekTrailers() {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.peekTrailers();
    }

    @Override
    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Http2ExchangeCodec$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "CONNECTION", _UrlKt.FRAGMENT_ENCODE_SET, "HOST", "KEEP_ALIVE", "PROXY_CONNECTION", "TRANSFER_ENCODING", "TE", "ENCODING", "UPGRADE", "HTTP_2_SKIPPED_REQUEST_HEADERS", _UrlKt.FRAGMENT_ENCODE_SET, "HTTP_2_SKIPPED_RESPONSE_HEADERS", "http2HeadersList", "Lni/shikatu/okhttp3/internal/http2/Header;", "request", "Lni/shikatu/okhttp3/Request;", "readHttp2HeadersList", "Lni/shikatu/okhttp3/Response$Builder;", "headerBlock", "Lni/shikatu/okhttp3/Headers;", "protocol", "Lni/shikatu/okhttp3/Protocol;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Header> http2HeadersList(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Headers headers = request.headers();
            ArrayList result = new ArrayList(headers.size() + 4);
            result.add(new Header(Header.TARGET_METHOD, request.method()));
            result.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String host = request.header("Host");
            if (host != null) {
                result.add(new Header(Header.TARGET_AUTHORITY, host));
            }
            result.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String strName = headers.name(i);
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String name = strName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(name, "toLowerCase(...)");
                if (!Http2ExchangeCodec.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(name) || (Intrinsics.areEqual(name, Http2ExchangeCodec.TE) && Intrinsics.areEqual(headers.value(i), "trailers"))) {
                    result.add(new Header(name, headers.value(i)));
                }
            }
            return result;
        }

        public final Response.Builder readHttp2HeadersList(Headers headerBlock, Protocol protocol) throws IOException {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            StatusLine statusLine = null;
            Headers.Builder headersBuilder = new Headers.Builder();
            int size = headerBlock.size();
            for (int i = 0; i < size; i++) {
                String name = headerBlock.name(i);
                String value = headerBlock.value(i);
                if (!Intrinsics.areEqual(name, Header.RESPONSE_STATUS_UTF8)) {
                    if (!Http2ExchangeCodec.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                        headersBuilder.addLenient$okhttp(name, value);
                    }
                } else {
                    statusLine = StatusLine.Companion.parse("HTTP/1.1 " + value);
                }
            }
            if (statusLine == null) {
                throw new ProtocolException("Expected ':status' header not present");
            }
            return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(headersBuilder.build());
        }
    }
}
