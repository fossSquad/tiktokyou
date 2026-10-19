package ni.shikatu.okhttp3.internal;

import java.nio.charset.Charset;
import javax.net.ssl.SSLSocket;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.okhttp3.Cache;
import ni.shikatu.okhttp3.CipherSuite;
import ni.shikatu.okhttp3.ConnectionPool;
import ni.shikatu.okhttp3.ConnectionSpec;
import ni.shikatu.okhttp3.Cookie;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.MediaType;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.connection.ConnectionListener;
import ni.shikatu.okhttp3.internal.connection.Exchange;
import ni.shikatu.okhttp3.internal.connection.RealConnection;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0000\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0000\u001a\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0000\u001a%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 *\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070 H\u0000¢\u0006\u0002\u0010\"\u001a\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&0$*\u0004\u0018\u00010&H\u0000\u001a\u000e\u0010'\u001a\u00020%*\u0004\u0018\u00010&H\u0000\u001a\u0014\u0010,\u001a\u00020-*\u00020-2\u0006\u0010.\u001a\u00020/H\u0000\u001a\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010.\u001a\u00020/H\u0000\"\u0018\u0010(\u001a\u00020)*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00064"}, d2 = {"parseCookie", "Lni/shikatu/okhttp3/Cookie;", "currentTimeMillis", _UrlKt.FRAGMENT_ENCODE_SET, "url", "Lni/shikatu/okhttp3/HttpUrl;", "setCookie", _UrlKt.FRAGMENT_ENCODE_SET, "cookieToString", "cookie", "forObsoleteRfc2965", _UrlKt.FRAGMENT_ENCODE_SET, "addHeaderLenient", "Lni/shikatu/okhttp3/Headers$Builder;", "builder", "line", "name", "value", "cacheGet", "Lni/shikatu/okhttp3/Response;", "cache", "Lni/shikatu/okhttp3/Cache;", "request", "Lni/shikatu/okhttp3/Request;", "applyConnectionSpec", _UrlKt.FRAGMENT_ENCODE_SET, "connectionSpec", "Lni/shikatu/okhttp3/ConnectionSpec;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "effectiveCipherSuites", _UrlKt.FRAGMENT_ENCODE_SET, "socketEnabledCipherSuites", "(Lokhttp3/ConnectionSpec;[Ljava/lang/String;)[Ljava/lang/String;", "chooseCharset", "Lni/shikatu/kotlin/Pair;", "Ljava/nio/charset/Charset;", "Lni/shikatu/okhttp3/MediaType;", "charsetOrUtf8", "connection", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "getConnection", "(Lokhttp3/Response;)Lokhttp3/internal/connection/RealConnection;", "taskRunnerInternal", "Lni/shikatu/okhttp3/OkHttpClient$Builder;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "buildConnectionPool", "Lni/shikatu/okhttp3/ConnectionPool;", "connectionListener", "Lni/shikatu/okhttp3/internal/connection/ConnectionListener;", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Internal {
    public static final Cookie parseCookie(long currentTimeMillis, HttpUrl url, String setCookie) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(currentTimeMillis, url, setCookie);
    }

    public static final String cookieToString(Cookie cookie, boolean forObsoleteRfc2965) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return cookie.toString$okhttp(forObsoleteRfc2965);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String line) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return builder.addLenient$okhttp(name, value);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(request, "request");
        return cache.get$okhttp(request);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sslSocket, boolean isFallback) {
        Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, isFallback);
    }

    public static final String[] effectiveCipherSuites(ConnectionSpec $this$effectiveCipherSuites, String[] socketEnabledCipherSuites) {
        Intrinsics.checkNotNullParameter($this$effectiveCipherSuites, "<this>");
        Intrinsics.checkNotNullParameter(socketEnabledCipherSuites, "socketEnabledCipherSuites");
        if ($this$effectiveCipherSuites.getCipherSuitesAsString$okhttp() != null) {
            return _UtilCommonKt.intersect($this$effectiveCipherSuites.getCipherSuitesAsString$okhttp(), socketEnabledCipherSuites, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        }
        return socketEnabledCipherSuites;
    }

    public static final Pair<Charset, MediaType> chooseCharset(MediaType $this$chooseCharset) {
        Charset charset = Charsets.UTF_8;
        MediaType finalContentType = $this$chooseCharset;
        if ($this$chooseCharset != null) {
            Charset resolvedCharset = MediaType.charset$default($this$chooseCharset, null, 1, null);
            if (resolvedCharset == null) {
                charset = Charsets.UTF_8;
                finalContentType = MediaType.Companion.parse($this$chooseCharset + "; charset=utf-8");
            } else {
                charset = resolvedCharset;
            }
        }
        return TuplesKt.to(charset, finalContentType);
    }

    public static final Charset charsetOrUtf8(MediaType $this$charsetOrUtf8) {
        Charset charsetCharset$default;
        return ($this$charsetOrUtf8 == null || (charsetCharset$default = MediaType.charset$default($this$charsetOrUtf8, null, 1, null)) == null) ? Charsets.UTF_8 : charsetCharset$default;
    }

    public static final RealConnection getConnection(Response $this$connection) {
        Intrinsics.checkNotNullParameter($this$connection, "<this>");
        Exchange exchange = $this$connection.exchange();
        Intrinsics.checkNotNull(exchange);
        return exchange.getConnection$okhttp();
    }

    public static final OkHttpClient.Builder taskRunnerInternal(OkHttpClient.Builder $this$taskRunnerInternal, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter($this$taskRunnerInternal, "<this>");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        return $this$taskRunnerInternal.taskRunner$okhttp(taskRunner);
    }

    public static final ConnectionPool buildConnectionPool(ConnectionListener connectionListener, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(connectionListener, "connectionListener");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        return new ConnectionPool(0, 0L, null, taskRunner, connectionListener, 7, null);
    }
}
