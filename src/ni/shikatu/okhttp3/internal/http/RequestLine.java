package ni.shikatu.okhttp3.internal.http;

import java.net.Proxy;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lni/shikatu/okhttp3/internal/http/RequestLine;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "get", _UrlKt.FRAGMENT_ENCODE_SET, "request", "Lni/shikatu/okhttp3/Request;", "proxyType", "Ljava/net/Proxy$Type;", "includeAuthorityInRequestLine", _UrlKt.FRAGMENT_ENCODE_SET, "requestPath", "url", "Lni/shikatu/okhttp3/HttpUrl;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestLine {
    public static final RequestLine INSTANCE = new RequestLine();

    private RequestLine() {
    }

    public final String get(Request request, Proxy.Type proxyType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder $this$get_u24lambda_u240 = new StringBuilder();
        $this$get_u24lambda_u240.append(request.method());
        $this$get_u24lambda_u240.append(' ');
        if (INSTANCE.includeAuthorityInRequestLine(request, proxyType)) {
            $this$get_u24lambda_u240.append(request.url());
        } else {
            $this$get_u24lambda_u240.append(INSTANCE.requestPath(request.url()));
        }
        $this$get_u24lambda_u240.append(" HTTP/1.1");
        return $this$get_u24lambda_u240.toString();
    }

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type proxyType) {
        return !request.isHttps() && proxyType == Proxy.Type.HTTP;
    }

    public final String requestPath(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String path = url.encodedPath();
        String query = url.encodedQuery();
        return query != null ? path + '?' + query : path;
    }
}
