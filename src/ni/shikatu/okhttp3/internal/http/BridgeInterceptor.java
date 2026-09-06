package ni.shikatu.okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Cookie;
import ni.shikatu.okhttp3.CookieJar;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.Interceptor;
import ni.shikatu.okhttp3.MediaType;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.RequestBody;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.ResponseBody;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.GzipSource;
import ni.shikatu.okio.Okio;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lni/shikatu/okhttp3/internal/http/BridgeInterceptor;", "Lni/shikatu/okhttp3/Interceptor;", "cookieJar", "Lni/shikatu/okhttp3/CookieJar;", "<init>", "(Lokhttp3/CookieJar;)V", "intercept", "Lni/shikatu/okhttp3/Response;", "chain", "Lni/shikatu/okhttp3/Interceptor$Chain;", "cookieHeader", _UrlKt.FRAGMENT_ENCODE_SET, "cookies", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Cookie;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody responseBody;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request userRequest = chain.request();
        Request.Builder requestBuilder = userRequest.newBuilder();
        RequestBody body = userRequest.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                requestBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                requestBuilder.header("Content-Length", String.valueOf(contentLength));
                requestBuilder.removeHeader("Transfer-Encoding");
            } else {
                requestBuilder.header("Transfer-Encoding", "chunked");
                requestBuilder.removeHeader("Content-Length");
            }
        }
        if (userRequest.header("Host") == null) {
            requestBuilder.header("Host", _UtilJvmKt.toHostHeader$default(userRequest.url(), false, 1, null));
        }
        if (userRequest.header("Connection") == null) {
            requestBuilder.header("Connection", "Keep-Alive");
        }
        boolean transparentGzip = false;
        if (userRequest.header("Accept-Encoding") == null && userRequest.header("Range") == null) {
            transparentGzip = true;
            requestBuilder.header("Accept-Encoding", "gzip");
        }
        List<Cookie> listLoadForRequest = this.cookieJar.loadForRequest(userRequest.url());
        if (!listLoadForRequest.isEmpty()) {
            requestBuilder.header("Cookie", cookieHeader(listLoadForRequest));
        }
        if (userRequest.header("User-Agent") == null) {
            requestBuilder.header("User-Agent", _UtilCommonKt.USER_AGENT);
        }
        Request networkRequest = requestBuilder.build();
        Response networkResponse = chain.proceed(networkRequest);
        HttpHeaders.receiveHeaders(this.cookieJar, networkRequest.url(), networkResponse.headers());
        Response.Builder responseBuilder = networkResponse.newBuilder().request(networkRequest);
        if (transparentGzip && StringsKt.equals("gzip", Response.header$default(networkResponse, "Content-Encoding", null, 2, null), true) && HttpHeaders.promisesBody(networkResponse) && (responseBody = networkResponse.body()) != null) {
            GzipSource gzipSource = new GzipSource(responseBody.source());
            Headers strippedHeaders = networkResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
            responseBuilder.headers(strippedHeaders);
            responseBuilder.body(new RealResponseBody(Response.header$default(networkResponse, "Content-Type", null, 2, null), -1L, Okio.buffer(gzipSource)));
        }
        return responseBuilder.build();
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder $this$cookieHeader_u24lambda_u240 = new StringBuilder();
        List<Cookie> $this$forEachIndexed$iv = list;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Cookie cookie = (Cookie) item$iv;
            if (index > 0) {
                $this$cookieHeader_u24lambda_u240.append("; ");
            }
            $this$cookieHeader_u24lambda_u240.append(cookie.name()).append('=').append(cookie.value());
            index = index$iv;
        }
        return $this$cookieHeader_u24lambda_u240.toString();
    }
}
