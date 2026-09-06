package ni.shikatu.okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.connection.Exchange;
import ni.shikatu.okhttp3.internal.http.HttpHeaders;
import ni.shikatu.okhttp3.internal.http.HttpStatusCodesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.Socket;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001PB\u008d\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b/J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b0J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b1J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b5J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\b6J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u0007072\u0006\u00108\u001a\u00020\u0007J\u001e\u00109\u001a\u0004\u0018\u00010\u00072\u0006\u00108\u001a\u00020\u00072\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007H\u0007J\r\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\rJ\b\u0010=\u001a\u0004\u0018\u00010\rJ\u000e\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u0016J\r\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b@J\u0006\u0010A\u001a\u00020BJ\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\bDJ\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\bEJ\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\bFJ\f\u0010G\u001a\b\u0012\u0004\u0012\u00020H07J\r\u0010I\u001a\u00020*H\u0007¢\u0006\u0002\bJJ\r\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\bKJ\r\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0002\bLJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u0007H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001eR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001fR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010 R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010!R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\"R\u0013\u0010\f\u001a\u00020\r8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010#R\u0013\u0010\u000e\u001a\u00020\u000f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010$R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010%R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010&R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010&R\u0013\u0010\u0015\u001a\u00020\u00168\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010'R\u0013\u0010\u0017\u001a\u00020\u00168\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010'R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010(R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b2\u00104R\u0011\u0010C\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0011\u0010I\u001a\u00020*8G¢\u0006\u0006\u001a\u0004\bI\u0010,¨\u0006Q"}, d2 = {"Lni/shikatu/okhttp3/Response;", "Ljava/io/Closeable;", "request", "Lni/shikatu/okhttp3/Request;", "protocol", "Lni/shikatu/okhttp3/Protocol;", "message", _UrlKt.FRAGMENT_ENCODE_SET, "code", _UrlKt.FRAGMENT_ENCODE_SET, "handshake", "Lni/shikatu/okhttp3/Handshake;", "headers", "Lni/shikatu/okhttp3/Headers;", "body", "Lni/shikatu/okhttp3/ResponseBody;", "socket", "Lni/shikatu/okio/Socket;", "networkResponse", "cacheResponse", "priorResponse", "sentRequestAtMillis", _UrlKt.FRAGMENT_ENCODE_SET, "receivedResponseAtMillis", "exchange", "Lni/shikatu/okhttp3/internal/connection/Exchange;", "trailersSource", "Lni/shikatu/okhttp3/TrailersSource;", "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokio/Socket;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;Lokhttp3/TrailersSource;)V", "()Lokhttp3/Request;", "()Lokhttp3/Protocol;", "()Ljava/lang/String;", "()I", "()Lokhttp3/Handshake;", "()Lokhttp3/Headers;", "()Lokhttp3/ResponseBody;", "()Lokio/Socket;", "()Lokhttp3/Response;", "()J", "()Lokhttp3/internal/connection/Exchange;", "lazyCacheControl", "Lni/shikatu/okhttp3/CacheControl;", "getLazyCacheControl$okhttp", "()Lokhttp3/CacheControl;", "setLazyCacheControl$okhttp", "(Lokhttp3/CacheControl;)V", "-deprecated_request", "-deprecated_protocol", "-deprecated_code", "isSuccessful", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "-deprecated_message", "-deprecated_handshake", _UrlKt.FRAGMENT_ENCODE_SET, "name", "header", "defaultValue", "-deprecated_headers", "trailers", "peekTrailers", "peekBody", "byteCount", "-deprecated_body", "newBuilder", "Lni/shikatu/okhttp3/Response$Builder;", "isRedirect", "-deprecated_networkResponse", "-deprecated_cacheResponse", "-deprecated_priorResponse", "challenges", "Lni/shikatu/okhttp3/Challenge;", "cacheControl", "-deprecated_cacheControl", "-deprecated_sentRequestAtMillis", "-deprecated_receivedResponseAtMillis", "close", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "Builder", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Response implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private final boolean isRedirect;
    private final boolean isSuccessful;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;
    private final Socket socket;
    private TrailersSource trailersSource;

    public final String header(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return header$default(this, str, null, 2, null);
    }

    public Response(Request request, Protocol protocol, String message, int code, Handshake handshake, Headers headers, ResponseBody body, Socket socket, Response networkResponse, Response cacheResponse, Response priorResponse, long sentRequestAtMillis, long receivedResponseAtMillis, Exchange exchange, TrailersSource trailersSource) {
        boolean z;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(trailersSource, "trailersSource");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = code;
        this.handshake = handshake;
        this.headers = headers;
        this.body = body;
        this.socket = socket;
        this.networkResponse = networkResponse;
        this.cacheResponse = cacheResponse;
        this.priorResponse = priorResponse;
        this.sentRequestAtMillis = sentRequestAtMillis;
        this.receivedResponseAtMillis = receivedResponseAtMillis;
        this.exchange = exchange;
        this.trailersSource = trailersSource;
        int i = this.code;
        this.isSuccessful = 200 <= i && i < 300;
        switch (this.code) {
            case 300:
            case 301:
            case 302:
            case 303:
            case HttpStatusCodesKt.HTTP_TEMP_REDIRECT /* 307 */:
            case HttpStatusCodesKt.HTTP_PERM_REDIRECT /* 308 */:
                z = true;
                break;
            case 304:
            case 305:
            case 306:
            default:
                z = false;
                break;
        }
        this.isRedirect = z;
    }

    public final Request request() {
        return this.request;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final String message() {
        return this.message;
    }

    public final int code() {
        return this.code;
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final Headers headers() {
        return this.headers;
    }

    public final ResponseBody body() {
        return this.body;
    }

    public final Socket socket() {
        return this.socket;
    }

    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final Response priorResponse() {
        return this.priorResponse;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Exchange exchange() {
        return this.exchange;
    }

    public final CacheControl getLazyCacheControl$okhttp() {
        return this.lazyCacheControl;
    }

    public final void setLazyCacheControl$okhttp(CacheControl cacheControl) {
        this.lazyCacheControl = cacheControl;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "request", imports = {}))

    public final Request m1728deprecated_request() {
        return this.request;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocol", imports = {}))

    public final Protocol m1726deprecated_protocol() {
        return this.protocol;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "code", imports = {}))

    public final int m1720deprecated_code() {
        return this.code;
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "message", imports = {}))

    public final String m1723deprecated_message() {
        return this.message;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "handshake", imports = {}))

    public final Handshake m1721deprecated_handshake() {
        return this.handshake;
    }

    public final List<String> headers(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.headers.values(name);
    }

    public static  String header$default(Response response, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    public final String header(String name, String defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = this.headers.get(name);
        return str == null ? defaultValue : str;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))

    public final Headers m1722deprecated_headers() {
        return this.headers;
    }

    public final Headers trailers() throws IOException {
        return this.trailersSource.get();
    }

    public final Headers peekTrailers() throws IOException {
        return this.trailersSource.peek();
    }

    public final ResponseBody peekBody(long byteCount) throws IOException {
        BufferedSource peeked = this.body.source().peek();
        Buffer buffer = new Buffer();
        peeked.request(byteCount);
        buffer.write((Source) peeked, Math.min(byteCount, peeked.getBuffer().size()));
        return ResponseBody.Companion.create(buffer, this.body.contentType(), buffer.size());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))

    public final ResponseBody m1717deprecated_body() {
        return this.body;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final boolean isRedirect() {
        return this.isRedirect;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkResponse", imports = {}))

    public final Response m1724deprecated_networkResponse() {
        return this.networkResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheResponse", imports = {}))

    public final Response m1719deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "priorResponse", imports = {}))

    public final Response m1725deprecated_priorResponse() {
        return this.priorResponse;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        switch (this.code) {
            case 401:
                str = "WWW-Authenticate";
                break;
            case 407:
                str = "Proxy-Authenticate";
                break;
            default:
                return CollectionsKt.emptyList();
        }
        return HttpHeaders.parseChallenges(headers, str);
    }

    public final CacheControl cacheControl() {
        CacheControl result = this.lazyCacheControl;
        if (result == null) {
            CacheControl result2 = CacheControl.Companion.parse(this.headers);
            this.lazyCacheControl = result2;
            return result2;
        }
        return result;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))

    public final CacheControl m1718deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sentRequestAtMillis", imports = {}))

    public final long m1729deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "receivedResponseAtMillis", imports = {}))

    public final long m1727deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Override
    public void close() {
        this.body.close();
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + AbstractJsonLexerKt.END_OBJ;
    }

    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010V\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\u001aH\u0016J\u0018\u0010Y\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\u001aH\u0016J\u0010\u0010Z\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u001aH\u0016J\u0010\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020[H\u0016J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u000202H\u0016J\u0012\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010;\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\\\u001a\u00020]2\u0006\u0010W\u001a\u00020\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010>\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010^\u001a\u00020\u00002\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010A\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010G\u001a\u00020\u00002\u0006\u0010G\u001a\u00020BH\u0016J\u0015\u0010_\u001a\u00020]2\u0006\u0010J\u001a\u00020KH\u0000¢\u0006\u0002\b`J\b\u0010a\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010\u0006R\u001c\u0010;\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010\u0006R\u001c\u0010>\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00109\"\u0004\b@\u0010\u0006R\u001a\u0010A\u001a\u00020BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020QX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006b"}, d2 = {"Lni/shikatu/okhttp3/Response$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "response", "Lni/shikatu/okhttp3/Response;", "(Lokhttp3/Response;)V", "request", "Lni/shikatu/okhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "protocol", "Lni/shikatu/okhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "code", _UrlKt.FRAGMENT_ENCODE_SET, "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "message", _UrlKt.FRAGMENT_ENCODE_SET, "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "handshake", "Lni/shikatu/okhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "headers", "Lni/shikatu/okhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "body", "Lni/shikatu/okhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "socket", "Lni/shikatu/okio/Socket;", "getSocket$okhttp", "()Lokio/Socket;", "setSocket$okhttp", "(Lokio/Socket;)V", "networkResponse", "getNetworkResponse$okhttp", "()Lokhttp3/Response;", "setNetworkResponse$okhttp", "cacheResponse", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "priorResponse", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "sentRequestAtMillis", _UrlKt.FRAGMENT_ENCODE_SET, "getSentRequestAtMillis$okhttp", "()J", "setSentRequestAtMillis$okhttp", "(J)V", "receivedResponseAtMillis", "getReceivedResponseAtMillis$okhttp", "setReceivedResponseAtMillis$okhttp", "exchange", "Lni/shikatu/okhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "trailersSource", "Lni/shikatu/okhttp3/TrailersSource;", "getTrailersSource$okhttp", "()Lokhttp3/TrailersSource;", "setTrailersSource$okhttp", "(Lokhttp3/TrailersSource;)V", "header", "name", "value", "addHeader", "removeHeader", "Lni/shikatu/okhttp3/Headers;", "checkSupportResponse", _UrlKt.FRAGMENT_ENCODE_SET, "trailers", "initExchange", "initExchange$okhttp", "build", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Exchange exchange;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private long receivedResponseAtMillis;
        private Request request;
        private long sentRequestAtMillis;
        private Socket socket;
        private TrailersSource trailersSource;

        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final void setRequest$okhttp(Request request) {
            this.request = request;
        }

        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final void setProtocol$okhttp(Protocol protocol) {
            this.protocol = protocol;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final void setCode$okhttp(int i) {
            this.code = i;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final void setMessage$okhttp(String str) {
            this.message = str;
        }

        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final void setHandshake$okhttp(Handshake handshake) {
            this.handshake = handshake;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.headers = builder;
        }

        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final void setBody$okhttp(ResponseBody responseBody) {
            Intrinsics.checkNotNullParameter(responseBody, "<set-?>");
            this.body = responseBody;
        }

        public final Socket getSocket$okhttp() {
            return this.socket;
        }

        public final void setSocket$okhttp(Socket socket) {
            this.socket = socket;
        }

        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final void setNetworkResponse$okhttp(Response response) {
            this.networkResponse = response;
        }

        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final void setCacheResponse$okhttp(Response response) {
            this.cacheResponse = response;
        }

        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final void setPriorResponse$okhttp(Response response) {
            this.priorResponse = response;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public final void setSentRequestAtMillis$okhttp(long j) {
            this.sentRequestAtMillis = j;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j) {
            this.receivedResponseAtMillis = j;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final void setExchange$okhttp(Exchange exchange) {
            this.exchange = exchange;
        }

        public final TrailersSource getTrailersSource$okhttp() {
            return this.trailersSource;
        }

        public final void setTrailersSource$okhttp(TrailersSource trailersSource) {
            Intrinsics.checkNotNullParameter(trailersSource, "<set-?>");
            this.trailersSource = trailersSource;
        }

        public Builder() {
            this.code = -1;
            this.body = ResponseBody.EMPTY;
            this.trailersSource = TrailersSource.EMPTY;
            this.headers = new Headers.Builder();
        }

        public Builder(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.code = -1;
            this.body = ResponseBody.EMPTY;
            this.trailersSource = TrailersSource.EMPTY;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.socket = response.socket();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
            this.trailersSource = response.trailersSource;
        }

        public Builder request(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Builder $this$request_u24lambda_u240 = this;
            $this$request_u24lambda_u240.request = request;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Builder $this$protocol_u24lambda_u240 = this;
            $this$protocol_u24lambda_u240.protocol = protocol;
            return this;
        }

        public Builder code(int code) {
            Builder $this$code_u24lambda_u240 = this;
            $this$code_u24lambda_u240.code = code;
            return this;
        }

        public Builder message(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            Builder $this$message_u24lambda_u240 = this;
            $this$message_u24lambda_u240.message = message;
            return this;
        }

        public Builder handshake(Handshake handshake) {
            Builder $this$handshake_u24lambda_u240 = this;
            $this$handshake_u24lambda_u240.handshake = handshake;
            return this;
        }

        public Builder header(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$header_u24lambda_u240 = this;
            $this$header_u24lambda_u240.headers.set(name, value);
            return this;
        }

        public Builder addHeader(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$addHeader_u24lambda_u240 = this;
            $this$addHeader_u24lambda_u240.headers.add(name, value);
            return this;
        }

        public Builder removeHeader(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$removeHeader_u24lambda_u240 = this;
            $this$removeHeader_u24lambda_u240.headers.removeAll(name);
            return this;
        }

        public Builder headers(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Builder $this$headers_u24lambda_u240 = this;
            $this$headers_u24lambda_u240.headers = headers.newBuilder();
            return this;
        }

        public Builder body(ResponseBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            Builder $this$body_u24lambda_u240 = this;
            $this$body_u24lambda_u240.body = body;
            return this;
        }

        public Builder socket(Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Builder $this$socket_u24lambda_u240 = this;
            $this$socket_u24lambda_u240.socket = socket;
            return this;
        }

        public Builder networkResponse(Response networkResponse) {
            Builder $this$networkResponse_u24lambda_u240 = this;
            $this$networkResponse_u24lambda_u240.checkSupportResponse("networkResponse", networkResponse);
            $this$networkResponse_u24lambda_u240.networkResponse = networkResponse;
            return this;
        }

        public Builder cacheResponse(Response cacheResponse) {
            Builder $this$cacheResponse_u24lambda_u240 = this;
            $this$cacheResponse_u24lambda_u240.checkSupportResponse("cacheResponse", cacheResponse);
            $this$cacheResponse_u24lambda_u240.cacheResponse = cacheResponse;
            return this;
        }

        private final void checkSupportResponse(String name, Response response) {
            if (response != null) {
                if (!(response.networkResponse() == null)) {
                    throw new IllegalArgumentException((name + ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse() == null)) {
                    throw new IllegalArgumentException((name + ".cacheResponse != null").toString());
                }
                if (!(response.priorResponse() == null)) {
                    throw new IllegalArgumentException((name + ".priorResponse != null").toString());
                }
            }
        }

        public Builder priorResponse(Response priorResponse) {
            Builder $this$priorResponse_u24lambda_u240 = this;
            $this$priorResponse_u24lambda_u240.priorResponse = priorResponse;
            return this;
        }

        public Builder trailers(TrailersSource trailersSource) {
            Intrinsics.checkNotNullParameter(trailersSource, "trailersSource");
            Builder $this$trailers_u24lambda_u240 = this;
            $this$trailers_u24lambda_u240.trailersSource = trailersSource;
            return this;
        }

        public Builder sentRequestAtMillis(long sentRequestAtMillis) {
            Builder $this$sentRequestAtMillis_u24lambda_u240 = this;
            $this$sentRequestAtMillis_u24lambda_u240.sentRequestAtMillis = sentRequestAtMillis;
            return this;
        }

        public Builder receivedResponseAtMillis(long receivedResponseAtMillis) {
            Builder $this$receivedResponseAtMillis_u24lambda_u240 = this;
            $this$receivedResponseAtMillis_u24lambda_u240.receivedResponseAtMillis = receivedResponseAtMillis;
            return this;
        }

        public final void initExchange$okhttp(Exchange exchange) {
            Intrinsics.checkNotNullParameter(exchange, "exchange");
            this.exchange = exchange;
        }

        public Response build() {
            if (!(this.code >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.message;
            if (str != null) {
                return new Response(request, protocol, str, this.code, this.handshake, this.headers.build(), this.body, this.socket, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange, this.trailersSource);
            }
            throw new IllegalStateException("message == null".toString());
        }
    }
}
