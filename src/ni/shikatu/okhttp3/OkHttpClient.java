package ni.shikatu.okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.connection.RealCall;
import ni.shikatu.okhttp3.internal.connection.RouteDatabase;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.proxy.NullProxySelector;
import ni.shikatu.okhttp3.internal.tls.CertificateChainCleaner;
import ni.shikatu.okhttp3.internal.tls.OkHostnameVerifier;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okhttp3.internal.ws.RealWebSocket;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u0002:\u0004\u0082\u0001\u0083\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\J\b\u0010]\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0016J\u0018\u0010c\u001a\u00020d2\u0006\u0010a\u001a\u00020b2\u0006\u0010e\u001a\u00020fH\u0016J\b\u0010g\u001a\u00020\u0004H\u0016J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\bhJ\r\u0010V\u001a\u00020WH\u0007¢\u0006\u0002\biJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0002\bjJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0002\bkJ\r\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\blJ\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\bmJ\r\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\bnJ\r\u0010\u001a\u001a\u00020\u0014H\u0007¢\u0006\u0002\boJ\r\u0010\u001b\u001a\u00020\u0014H\u0007¢\u0006\u0002\bpJ\r\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\bqJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0002\brJ\r\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\bsJ\u000f\u0010%\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0002\btJ\r\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\buJ\r\u0010+\u001a\u00020\u0018H\u0007¢\u0006\u0002\bvJ\r\u0010,\u001a\u00020-H\u0007¢\u0006\u0002\bwJ\r\u00101\u001a\u000200H\u0007¢\u0006\u0002\bxJ\u0013\u00106\u001a\b\u0012\u0004\u0012\u0002070\fH\u0007¢\u0006\u0002\byJ\u0013\u00108\u001a\b\u0012\u0004\u0012\u0002090\fH\u0007¢\u0006\u0002\bzJ\r\u0010:\u001a\u00020;H\u0007¢\u0006\u0002\b{J\r\u0010=\u001a\u00020>H\u0007¢\u0006\u0002\b|J\r\u0010C\u001a\u00020DH\u0007¢\u0006\u0002\b}J\r\u0010F\u001a\u00020DH\u0007¢\u0006\u0002\b~J\r\u0010G\u001a\u00020DH\u0007¢\u0006\u0002\b\u007fJ\u000e\u0010H\u001a\u00020DH\u0007¢\u0006\u0003\b\u0080\u0001J\u000e\u0010I\u001a\u00020DH\u0007¢\u0006\u0003\b\u0081\u0001R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000eR\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0010\u001a\u00020\u00118\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0012R\u0013\u0010\u0013\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0013\u0010\u0016\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0017\u001a\u00020\u00188\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u001a\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u001b\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u001c\u001a\u00020\u001d8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001eR\u0015\u0010\u001f\u001a\u0004\u0018\u00010 8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010!R\u0013\u0010\"\u001a\u00020#8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010$R\u0015\u0010%\u001a\u0004\u0018\u00010&8\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010'R\u0013\u0010(\u001a\u00020)8\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010*R\u0013\u0010+\u001a\u00020\u00188\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0013\u0010,\u001a\u00020-8\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00101\u001a\u0002008G¢\u0006\u0006\u001a\u0004\b1\u00102R\u0015\u00103\u001a\u0004\u0018\u0001048\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00105R\u0019\u00106\u001a\b\u0012\u0004\u0012\u0002070\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000eR\u0019\u00108\u001a\b\u0012\u0004\u0012\u0002090\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000eR\u0013\u0010:\u001a\u00020;8\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010<R\u0013\u0010=\u001a\u00020>8\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010?R\u0015\u0010@\u001a\u0004\u0018\u00010A8\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010BR\u0013\u0010C\u001a\u00020D8\u0007¢\u0006\b\n\u0000\u001a\u0004\bC\u0010ER\u0013\u0010F\u001a\u00020D8\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010ER\u0013\u0010G\u001a\u00020D8\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u0010ER\u0013\u0010H\u001a\u00020D8\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u0010ER\u0013\u0010I\u001a\u00020D8\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u0010ER\u0013\u0010J\u001a\u00020D8\u0007¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010ER\u0013\u0010K\u001a\u00020L8\u0007¢\u0006\b\n\u0000\u001a\u0004\bK\u0010MR\u0014\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020SX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010V\u001a\u00020W8\u0007¢\u0006\b\n\u0000\u001a\u0004\bV\u0010X¨\u0006\u0084\u0001"}, d2 = {"Lni/shikatu/okhttp3/OkHttpClient;", "Lni/shikatu/okhttp3/Call$Factory;", "Lni/shikatu/okhttp3/WebSocket$Factory;", "builder", "Lni/shikatu/okhttp3/OkHttpClient$Builder;", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "()V", "dispatcher", "Lni/shikatu/okhttp3/Dispatcher;", "()Lokhttp3/Dispatcher;", "interceptors", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Interceptor;", "()Ljava/util/List;", "networkInterceptors", "eventListenerFactory", "Lni/shikatu/okhttp3/EventListener$Factory;", "()Lokhttp3/EventListener$Factory;", "retryOnConnectionFailure", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "fastFallback", "authenticator", "Lni/shikatu/okhttp3/Authenticator;", "()Lokhttp3/Authenticator;", "followRedirects", "followSslRedirects", "cookieJar", "Lni/shikatu/okhttp3/CookieJar;", "()Lokhttp3/CookieJar;", "cache", "Lni/shikatu/okhttp3/Cache;", "()Lokhttp3/Cache;", "dns", "Lni/shikatu/okhttp3/Dns;", "()Lokhttp3/Dns;", "proxy", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxySelector", "Ljava/net/ProxySelector;", "()Ljava/net/ProxySelector;", "proxyAuthenticator", "socketFactory", "Ljavax/net/SocketFactory;", "()Ljavax/net/SocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "connectionSpecs", "Lni/shikatu/okhttp3/ConnectionSpec;", "protocols", "Lni/shikatu/okhttp3/Protocol;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "certificatePinner", "Lni/shikatu/okhttp3/CertificatePinner;", "()Lokhttp3/CertificatePinner;", "certificateChainCleaner", "Lni/shikatu/okhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "callTimeoutMillis", _UrlKt.FRAGMENT_ENCODE_SET, "()I", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "pingIntervalMillis", "webSocketCloseTimeout", "minWebSocketMessageToCompress", _UrlKt.FRAGMENT_ENCODE_SET, "()J", "routeDatabase", "Lni/shikatu/okhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "connectionPool", "Lni/shikatu/okhttp3/ConnectionPool;", "()Lokhttp3/ConnectionPool;", "address", "Lni/shikatu/okhttp3/Address;", "url", "Lni/shikatu/okhttp3/HttpUrl;", "verifyClientState", _UrlKt.FRAGMENT_ENCODE_SET, "newCall", "Lni/shikatu/okhttp3/Call;", "request", "Lni/shikatu/okhttp3/Request;", "newWebSocket", "Lni/shikatu/okhttp3/WebSocket;", "listener", "Lni/shikatu/okhttp3/WebSocketListener;", "newBuilder", "-deprecated_dispatcher", "-deprecated_connectionPool", "-deprecated_interceptors", "-deprecated_networkInterceptors", "-deprecated_eventListenerFactory", "-deprecated_retryOnConnectionFailure", "-deprecated_authenticator", "-deprecated_followRedirects", "-deprecated_followSslRedirects", "-deprecated_cookieJar", "-deprecated_cache", "-deprecated_dns", "-deprecated_proxy", "-deprecated_proxySelector", "-deprecated_proxyAuthenticator", "-deprecated_socketFactory", "-deprecated_sslSocketFactory", "-deprecated_connectionSpecs", "-deprecated_protocols", "-deprecated_hostnameVerifier", "-deprecated_certificatePinner", "-deprecated_callTimeoutMillis", "-deprecated_connectTimeoutMillis", "-deprecated_readTimeoutMillis", "-deprecated_writeTimeoutMillis", "-deprecated_pingIntervalMillis", "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class OkHttpClient implements Call.Factory, WebSocket.Factory {
    private final Authenticator authenticator;
    private final Cache cache;
    private final int callTimeoutMillis;
    private final CertificateChainCleaner certificateChainCleaner;
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    private final ConnectionPool connectionPool;
    private final List<ConnectionSpec> connectionSpecs;
    private final CookieJar cookieJar;
    private final Dispatcher dispatcher;
    private final Dns dns;
    private final EventListener.Factory eventListenerFactory;
    private final boolean fastFallback;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    private final HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final TaskRunner taskRunner;
    private final int webSocketCloseTimeout;
    private final int writeTimeoutMillis;
    private final X509TrustManager x509TrustManager;
    public static final Companion Companion = new Companion(null);
    private static final List<Protocol> DEFAULT_PROTOCOLS = _UtilJvmKt.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = _UtilJvmKt.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    public OkHttpClient(Builder builder) {
        NullProxySelector proxySelector$okhttp;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.dispatcher = builder.getDispatcher$okhttp();
        this.interceptors = _UtilJvmKt.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = _UtilJvmKt.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.fastFallback = builder.getFastFallback$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            proxySelector$okhttp = NullProxySelector.INSTANCE;
        } else {
            proxySelector$okhttp = builder.getProxySelector$okhttp();
            if (proxySelector$okhttp == null && (proxySelector$okhttp = ProxySelector.getDefault()) == null) {
                proxySelector$okhttp = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector$okhttp;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        this.connectionSpecs = builder.getConnectionSpecs$okhttp();
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        this.webSocketCloseTimeout = builder.getWebSocketCloseTimeout$okhttp();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
        RouteDatabase routeDatabase$okhttp = builder.getRouteDatabase$okhttp();
        this.routeDatabase = routeDatabase$okhttp == null ? new RouteDatabase() : routeDatabase$okhttp;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp == null ? TaskRunner.INSTANCE : taskRunner$okhttp;
        ConnectionPool it = builder.getConnectionPool$okhttp();
        if (it == null) {
            it = new ConnectionPool();
            builder.setConnectionPool$okhttp(it);
        }
        this.connectionPool = it;
        Iterable $this$none$iv = this.connectionSpecs;
        boolean z = true;
        if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
            for (Object element$iv : $this$none$iv) {
                if (((ConnectionSpec) element$iv).isTls()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
        } else if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
            this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
            CertificateChainCleaner certificateChainCleaner$okhttp = builder.getCertificateChainCleaner$okhttp();
            Intrinsics.checkNotNull(certificateChainCleaner$okhttp);
            this.certificateChainCleaner = certificateChainCleaner$okhttp;
            X509TrustManager x509TrustManagerOrNull$okhttp = builder.getX509TrustManagerOrNull$okhttp();
            Intrinsics.checkNotNull(x509TrustManagerOrNull$okhttp);
            this.x509TrustManager = x509TrustManagerOrNull$okhttp;
            this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(this.certificateChainCleaner);
        } else {
            this.x509TrustManager = Platform.Companion.get().platformTrustManager();
            this.sslSocketFactoryOrNull = Platform.Companion.get().newSslSocketFactory(this.x509TrustManager);
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(this.x509TrustManager);
            this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(this.certificateChainCleaner);
        }
        verifyClientState();
    }

    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public final boolean fastFallback() {
        return this.fastFallback;
    }

    public final Authenticator authenticator() {
        return this.authenticator;
    }

    public final boolean followRedirects() {
        return this.followRedirects;
    }

    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    public final Cache cache() {
        return this.cache;
    }

    public final Dns dns() {
        return this.dns;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final int webSocketCloseTimeout() {
        return this.webSocketCloseTimeout;
    }

    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final RouteDatabase getRouteDatabase$okhttp() {
        return this.routeDatabase;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public final Address address(HttpUrl url) {
        SSLSocketFactory useSslSocketFactory;
        HostnameVerifier useHostnameVerifier;
        CertificatePinner useCertificatePinner;
        Intrinsics.checkNotNullParameter(url, "url");
        if (!url.isHttps()) {
            useSslSocketFactory = null;
            useHostnameVerifier = null;
            useCertificatePinner = null;
        } else {
            SSLSocketFactory useSslSocketFactory2 = sslSocketFactory();
            HostnameVerifier useHostnameVerifier2 = this.hostnameVerifier;
            CertificatePinner useCertificatePinner2 = this.certificatePinner;
            useSslSocketFactory = useSslSocketFactory2;
            useHostnameVerifier = useHostnameVerifier2;
            useCertificatePinner = useCertificatePinner2;
        }
        return new Address(url.host(), url.port(), this.dns, this.socketFactory, useSslSocketFactory, useHostnameVerifier, useCertificatePinner, this.proxyAuthenticator, this.proxy, this.protocols, this.connectionSpecs, this.proxySelector);
    }

    private final void verifyClientState() {
        boolean z;
        List<Interceptor> list = this.interceptors;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        List<Interceptor> list2 = this.networkInterceptors;
        Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        Iterable $this$none$iv = this.connectionSpecs;
        if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
            Iterator it = $this$none$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    ConnectionSpec it2 = (ConnectionSpec) element$iv;
                    if (it2.isTls()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            if (!(this.sslSocketFactoryOrNull == null)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!(this.certificateChainCleaner == null)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!(this.x509TrustManager == null)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.INSTANCE;
            return;
        }
        if (this.sslSocketFactoryOrNull == null) {
            throw new IllegalStateException("sslSocketFactory == null".toString());
        }
        if (this.certificateChainCleaner == null) {
            throw new IllegalStateException("certificateChainCleaner == null".toString());
        }
        if (this.x509TrustManager == null) {
            throw new IllegalStateException("x509TrustManager == null".toString());
        }
    }

    @Override
    public Call newCall(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealCall(this, request, false);
    }

    @Override
    public WebSocket newWebSocket(Request request, WebSocketListener listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RealWebSocket webSocket = new RealWebSocket(this.taskRunner, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress, this.webSocketCloseTimeout);
        webSocket.connect(this);
        return webSocket;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dispatcher", imports = {}))

    public final Dispatcher m1686deprecated_dispatcher() {
        return this.dispatcher;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionPool", imports = {}))

    public final ConnectionPool m1683deprecated_connectionPool() {
        return this.connectionPool;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "interceptors", imports = {}))

    public final List<Interceptor> m1692deprecated_interceptors() {
        return this.interceptors;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkInterceptors", imports = {}))

    public final List<Interceptor> m1693deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "eventListenerFactory", imports = {}))

    public final EventListener.Factory m1688deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "retryOnConnectionFailure", imports = {}))

    public final boolean m1700deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authenticator", imports = {}))

    public final Authenticator m1678deprecated_authenticator() {
        return this.authenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "followRedirects", imports = {}))

    public final boolean m1689deprecated_followRedirects() {
        return this.followRedirects;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "followSslRedirects", imports = {}))

    public final boolean m1690deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cookieJar", imports = {}))

    public final CookieJar m1685deprecated_cookieJar() {
        return this.cookieJar;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cache", imports = {}))

    public final Cache m1679deprecated_cache() {
        return this.cache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dns", imports = {}))

    public final Dns m1687deprecated_dns() {
        return this.dns;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))

    public final Proxy m1696deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxySelector", imports = {}))

    public final ProxySelector m1698deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxyAuthenticator", imports = {}))

    public final Authenticator m1697deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketFactory", imports = {}))

    public final SocketFactory m1701deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sslSocketFactory", imports = {}))

    public final SSLSocketFactory m1702deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionSpecs", imports = {}))

    public final List<ConnectionSpec> m1684deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocols", imports = {}))

    public final List<Protocol> m1695deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostnameVerifier", imports = {}))

    public final HostnameVerifier m1691deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "certificatePinner", imports = {}))

    public final CertificatePinner m1681deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "callTimeoutMillis", imports = {}))

    public final int m1680deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectTimeoutMillis", imports = {}))

    public final int m1682deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "readTimeoutMillis", imports = {}))

    public final int m1699deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "writeTimeoutMillis", imports = {}))

    public final int m1703deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pingIntervalMillis", imports = {}))

    public final int m1694deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0010\u0010«\u0001\u001a\u00020\u00002\u0007\u0010¬\u0001\u001a\u00020\u0015J?\u0010«\u0001\u001a\u00020\u00002*\b\u0004\u0010\u00ad\u0001\u001a#\u0012\u0017\u0012\u00150¯\u0001¢\u0006\u000f\b°\u0001\u0012\n\b±\u0001\u0012\u0005\b\b(²\u0001\u0012\u0005\u0012\u00030³\u00010®\u0001H\u0087\bø\u0001\u0000¢\u0006\u0003\b´\u0001J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0010\u0010µ\u0001\u001a\u00020\u00002\u0007\u0010¬\u0001\u001a\u00020\u0015J?\u0010µ\u0001\u001a\u00020\u00002*\b\u0004\u0010\u00ad\u0001\u001a#\u0012\u0017\u0012\u00150¯\u0001¢\u0006\u000f\b°\u0001\u0012\n\b±\u0001\u0012\u0005\b\b(²\u0001\u0012\u0005\u0012\u00030³\u00010®\u0001H\u0087\bø\u0001\u0000¢\u0006\u0003\b¶\u0001J\u0011\u0010·\u0001\u001a\u00020\u00002\b\u0010·\u0001\u001a\u00030¸\u0001J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020!J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020!J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020!J\u000f\u00102\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020!J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u000206J\u0010\u0010;\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010<J\u0019\u0010¥\u0001\u001a\u00020\u00002\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0000¢\u0006\u0003\bº\u0001J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BJ\u0010\u0010G\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010HJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010M\u001a\u00020NJ\u000e\u0010S\u001a\u00020\u00002\u0006\u0010S\u001a\u00020*J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010V\u001a\u00020WJ\u0012\u0010»\u0001\u001a\u00020\u00002\u0007\u0010»\u0001\u001a\u00020]H\u0007J\u0019\u0010»\u0001\u001a\u00020\u00002\u0007\u0010»\u0001\u001a\u00020]2\u0007\u0010¼\u0001\u001a\u00020cJ\u0014\u0010h\u001a\u00020\u00002\f\u0010h\u001a\b\u0012\u0004\u0012\u00020j0iJ\u0014\u0010n\u001a\u00020\u00002\f\u0010n\u001a\b\u0012\u0004\u0012\u00020o0iJ\u000e\u0010r\u001a\u00020\u00002\u0006\u0010r\u001a\u00020sJ\u000e\u0010x\u001a\u00020\u00002\u0006\u0010x\u001a\u00020yJ\u001b\u0010\u0084\u0001\u001a\u00020\u00002\b\u0010½\u0001\u001a\u00030\u009a\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001J\u0013\u0010\u0084\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Á\u0001H\u0007J\u001a\u0010\u0084\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Â\u0001¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u001b\u0010\u008a\u0001\u001a\u00020\u00002\b\u0010½\u0001\u001a\u00030\u009a\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001J\u0013\u0010\u008a\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Á\u0001H\u0007J\u001a\u0010\u008a\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Â\u0001¢\u0006\u0006\bÅ\u0001\u0010Ä\u0001J\u001b\u0010\u008d\u0001\u001a\u00020\u00002\b\u0010½\u0001\u001a\u00030\u009a\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001J\u0013\u0010\u008d\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Á\u0001H\u0007J\u001a\u0010\u008d\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Â\u0001¢\u0006\u0006\bÆ\u0001\u0010Ä\u0001J\u001b\u0010\u0090\u0001\u001a\u00020\u00002\b\u0010½\u0001\u001a\u00030\u009a\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001J\u0013\u0010\u0090\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Á\u0001H\u0007J\u001a\u0010\u0090\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Â\u0001¢\u0006\u0006\bÇ\u0001\u0010Ä\u0001J\u001b\u0010\u0093\u0001\u001a\u00020\u00002\b\u0010È\u0001\u001a\u00030\u009a\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001J\u0013\u0010\u0093\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Á\u0001H\u0007J\u001a\u0010\u0093\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Â\u0001¢\u0006\u0006\bÉ\u0001\u0010Ä\u0001J\u001b\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010½\u0001\u001a\u00030\u009a\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001J\u0013\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Á\u0001H\u0007J\u001a\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010À\u0001\u001a\u00030Â\u0001¢\u0006\u0006\bÊ\u0001\u0010Ä\u0001J\u0011\u0010\u0099\u0001\u001a\u00020\u00002\b\u0010Ë\u0001\u001a\u00030\u009a\u0001J\u0007\u0010Ì\u0001\u001a\u00020\u0005R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001a\u00102\u001a\u00020!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001a\u00105\u001a\u000206X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010,\"\u0004\bU\u0010.R\u001a\u0010V\u001a\u00020WX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR \u0010h\u001a\b\u0012\u0004\u0012\u00020j0iX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0017\"\u0004\bl\u0010mR \u0010n\u001a\b\u0012\u0004\u0012\u00020o0iX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0017\"\u0004\bq\u0010mR\u001a\u0010r\u001a\u00020sX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010x\u001a\u00020yX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R \u0010~\u001a\u0004\u0018\u00010\u007fX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008a\u0001\u001a\u00030\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u0087\u0001\"\u0006\b\u008c\u0001\u0010\u0089\u0001R \u0010\u008d\u0001\u001a\u00030\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u0087\u0001\"\u0006\b\u008f\u0001\u0010\u0089\u0001R \u0010\u0090\u0001\u001a\u00030\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0087\u0001\"\u0006\b\u0092\u0001\u0010\u0089\u0001R \u0010\u0093\u0001\u001a\u00030\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0087\u0001\"\u0006\b\u0095\u0001\u0010\u0089\u0001R \u0010\u0096\u0001\u001a\u00030\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0087\u0001\"\u0006\b\u0098\u0001\u0010\u0089\u0001R \u0010\u0099\u0001\u001a\u00030\u009a\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006Í\u0001"}, d2 = {"Lni/shikatu/okhttp3/OkHttpClient$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "okHttpClient", "Lni/shikatu/okhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "dispatcher", "Lni/shikatu/okhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "connectionPool", "Lni/shikatu/okhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "interceptors", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Interceptor;", "getInterceptors$okhttp", "()Ljava/util/List;", "networkInterceptors", "getNetworkInterceptors$okhttp", "eventListenerFactory", "Lni/shikatu/okhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "retryOnConnectionFailure", _UrlKt.FRAGMENT_ENCODE_SET, "getRetryOnConnectionFailure$okhttp", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "fastFallback", "getFastFallback$okhttp", "setFastFallback$okhttp", "authenticator", "Lni/shikatu/okhttp3/Authenticator;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "followRedirects", "getFollowRedirects$okhttp", "setFollowRedirects$okhttp", "followSslRedirects", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "cookieJar", "Lni/shikatu/okhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "cache", "Lni/shikatu/okhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "dns", "Lni/shikatu/okhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "proxy", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxySelector", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "proxyAuthenticator", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "socketFactory", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "connectionSpecs", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/ConnectionSpec;", "getConnectionSpecs$okhttp", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "protocols", "Lni/shikatu/okhttp3/Protocol;", "getProtocols$okhttp", "setProtocols$okhttp", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "certificatePinner", "Lni/shikatu/okhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "certificateChainCleaner", "Lni/shikatu/okhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "callTimeout", _UrlKt.FRAGMENT_ENCODE_SET, "getCallTimeout$okhttp", "()I", "setCallTimeout$okhttp", "(I)V", "connectTimeout", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", "readTimeout", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "writeTimeout", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "pingInterval", "getPingInterval$okhttp", "setPingInterval$okhttp", "webSocketCloseTimeout", "getWebSocketCloseTimeout$okhttp", "setWebSocketCloseTimeout$okhttp", "minWebSocketMessageToCompress", _UrlKt.FRAGMENT_ENCODE_SET, "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "routeDatabase", "Lni/shikatu/okhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "setTaskRunner$okhttp", "(Lokhttp3/internal/concurrent/TaskRunner;)V", "addInterceptor", "interceptor", "block", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/okhttp3/Interceptor$Chain;", "Lni/shikatu/kotlin/ParameterName;", "name", "chain", "Lni/shikatu/okhttp3/Response;", "-addInterceptor", "addNetworkInterceptor", "-addNetworkInterceptor", "eventListener", "Lni/shikatu/okhttp3/EventListener;", "followProtocolRedirects", "taskRunner$okhttp", "sslSocketFactory", "trustManager", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "duration", "Ljava/time/Duration;", "Lni/shikatu/kotlin/time/Duration;", "callTimeout-LRDsOJo", "(J)Lokhttp3/OkHttpClient$Builder;", "connectTimeout-LRDsOJo", "readTimeout-LRDsOJo", "writeTimeout-LRDsOJo", "interval", "pingInterval-LRDsOJo", "webSocketCloseTimeout-LRDsOJo", "bytes", "build", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private Authenticator authenticator;
        private Cache cache;
        private int callTimeout;
        private CertificateChainCleaner certificateChainCleaner;
        private CertificatePinner certificatePinner;
        private int connectTimeout;
        private ConnectionPool connectionPool;
        private List<ConnectionSpec> connectionSpecs;
        private CookieJar cookieJar;
        private Dispatcher dispatcher;
        private Dns dns;
        private EventListener.Factory eventListenerFactory;
        private boolean fastFallback;
        private boolean followRedirects;
        private boolean followSslRedirects;
        private HostnameVerifier hostnameVerifier;
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;
        private List<? extends Protocol> protocols;
        private Proxy proxy;
        private Authenticator proxyAuthenticator;
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;
        private RouteDatabase routeDatabase;
        private SocketFactory socketFactory;
        private SSLSocketFactory sslSocketFactoryOrNull;
        private TaskRunner taskRunner;
        private int webSocketCloseTimeout;
        private int writeTimeout;
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = _UtilJvmKt.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            this.fastFallback = true;
            this.authenticator = Authenticator.NONE;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = Authenticator.NONE;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault(...)");
            this.socketFactory = socketFactory;
            this.connectionSpecs = OkHttpClient.Companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = OkHttpClient.Companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.webSocketCloseTimeout = 60000;
            this.minWebSocketMessageToCompress = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        }

        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        public final void setDispatcher$okhttp(Dispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        public final void setConnectionPool$okhttp(ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
        }

        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final void setEventListenerFactory$okhttp(EventListener.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final boolean getFastFallback$okhttp() {
            return this.fastFallback;
        }

        public final void setFastFallback$okhttp(boolean z) {
            this.fastFallback = z;
        }

        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        public final void setAuthenticator$okhttp(Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        public final void setCookieJar$okhttp(CookieJar cookieJar) {
            Intrinsics.checkNotNullParameter(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final void setCache$okhttp(Cache cache) {
            this.cache = cache;
        }

        public final Dns getDns$okhttp() {
            return this.dns;
        }

        public final void setDns$okhttp(Dns dns) {
            Intrinsics.checkNotNullParameter(dns, "<set-?>");
            this.dns = dns;
        }

        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        public final void setProxy$okhttp(Proxy proxy) {
            this.proxy = proxy;
        }

        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final void setProxySelector$okhttp(ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        public final void setProxyAuthenticator$okhttp(Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        public final void setSocketFactory$okhttp(SocketFactory socketFactory) {
            Intrinsics.checkNotNullParameter(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final void setSslSocketFactoryOrNull$okhttp(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        public final void setX509TrustManagerOrNull$okhttp(X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        public final void setConnectionSpecs$okhttp(List<ConnectionSpec> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        public final void setProtocols$okhttp(List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.protocols = list;
        }

        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        public final void setHostnameVerifier$okhttp(HostnameVerifier hostnameVerifier) {
            Intrinsics.checkNotNullParameter(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final void setCertificatePinner$okhttp(CertificatePinner certificatePinner) {
            Intrinsics.checkNotNullParameter(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        public final void setCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        public final void setCallTimeout$okhttp(int i) {
            this.callTimeout = i;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        public final void setConnectTimeout$okhttp(int i) {
            this.connectTimeout = i;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final void setReadTimeout$okhttp(int i) {
            this.readTimeout = i;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        public final void setWriteTimeout$okhttp(int i) {
            this.writeTimeout = i;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        public final void setPingInterval$okhttp(int i) {
            this.pingInterval = i;
        }

        public final int getWebSocketCloseTimeout$okhttp() {
            return this.webSocketCloseTimeout;
        }

        public final void setWebSocketCloseTimeout$okhttp(int i) {
            this.webSocketCloseTimeout = i;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j) {
            this.minWebSocketMessageToCompress = j;
        }

        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        public final void setRouteDatabase$okhttp(RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final void setTaskRunner$okhttp(TaskRunner taskRunner) {
            this.taskRunner = taskRunner;
        }

        public Builder(OkHttpClient okHttpClient) {
            this();
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            CollectionsKt.addAll(this.interceptors, okHttpClient.interceptors());
            CollectionsKt.addAll(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.fastFallback = okHttpClient.fastFallback();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.webSocketCloseTimeout = okHttpClient.webSocketCloseTimeout();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase$okhttp();
            this.taskRunner = okHttpClient.getTaskRunner$okhttp();
        }

        public final Builder dispatcher(Dispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Builder $this$dispatcher_u24lambda_u240 = this;
            $this$dispatcher_u24lambda_u240.dispatcher = dispatcher;
            return this;
        }

        public final Builder connectionPool(ConnectionPool connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            Builder $this$connectionPool_u24lambda_u240 = this;
            $this$connectionPool_u24lambda_u240.connectionPool = connectionPool;
            return this;
        }

        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public final Builder addInterceptor(Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            Builder $this$addInterceptor_u24lambda_u240 = this;
            $this$addInterceptor_u24lambda_u240.interceptors.add(interceptor);
            return this;
        }

        public final Builder m1704addInterceptor(final Function1<? super Interceptor.Chain, Response> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return addInterceptor(new Interceptor() {
                @Override
                public final Response intercept(Interceptor.Chain chain) {
                    Intrinsics.checkNotNullParameter(chain, "chain");
                    return function1.invoke(chain);
                }
            });
        }

        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public final Builder addNetworkInterceptor(Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            Builder $this$addNetworkInterceptor_u24lambda_u240 = this;
            $this$addNetworkInterceptor_u24lambda_u240.networkInterceptors.add(interceptor);
            return this;
        }

        public final Builder m1705addNetworkInterceptor(final Function1<? super Interceptor.Chain, Response> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return addNetworkInterceptor(new Interceptor() {
                @Override
                public final Response intercept(Interceptor.Chain chain) {
                    Intrinsics.checkNotNullParameter(chain, "chain");
                    return function1.invoke(chain);
                }
            });
        }

        public final Builder eventListener(EventListener eventListener) {
            Intrinsics.checkNotNullParameter(eventListener, "eventListener");
            Builder $this$eventListener_u24lambda_u240 = this;
            $this$eventListener_u24lambda_u240.eventListenerFactory = _UtilJvmKt.asFactory(eventListener);
            return this;
        }

        public final Builder eventListenerFactory(EventListener.Factory eventListenerFactory) {
            Intrinsics.checkNotNullParameter(eventListenerFactory, "eventListenerFactory");
            Builder $this$eventListenerFactory_u24lambda_u240 = this;
            $this$eventListenerFactory_u24lambda_u240.eventListenerFactory = eventListenerFactory;
            return this;
        }

        public final Builder retryOnConnectionFailure(boolean retryOnConnectionFailure) {
            Builder $this$retryOnConnectionFailure_u24lambda_u240 = this;
            $this$retryOnConnectionFailure_u24lambda_u240.retryOnConnectionFailure = retryOnConnectionFailure;
            return this;
        }

        public final Builder fastFallback(boolean fastFallback) {
            Builder $this$fastFallback_u24lambda_u240 = this;
            $this$fastFallback_u24lambda_u240.fastFallback = fastFallback;
            return this;
        }

        public final Builder authenticator(Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "authenticator");
            Builder $this$authenticator_u24lambda_u240 = this;
            $this$authenticator_u24lambda_u240.authenticator = authenticator;
            return this;
        }

        public final Builder followRedirects(boolean followRedirects) {
            Builder $this$followRedirects_u24lambda_u240 = this;
            $this$followRedirects_u24lambda_u240.followRedirects = followRedirects;
            return this;
        }

        public final Builder followSslRedirects(boolean followProtocolRedirects) {
            Builder $this$followSslRedirects_u24lambda_u240 = this;
            $this$followSslRedirects_u24lambda_u240.followSslRedirects = followProtocolRedirects;
            return this;
        }

        public final Builder cookieJar(CookieJar cookieJar) {
            Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
            Builder $this$cookieJar_u24lambda_u240 = this;
            $this$cookieJar_u24lambda_u240.cookieJar = cookieJar;
            return this;
        }

        public final Builder cache(Cache cache) {
            Builder $this$cache_u24lambda_u240 = this;
            $this$cache_u24lambda_u240.cache = cache;
            return this;
        }

        public final Builder taskRunner$okhttp(TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            Builder $this$taskRunner_u24lambda_u240 = this;
            $this$taskRunner_u24lambda_u240.taskRunner = taskRunner;
            return this;
        }

        public final Builder dns(Dns dns) {
            Intrinsics.checkNotNullParameter(dns, "dns");
            Builder $this$dns_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(dns, $this$dns_u24lambda_u240.dns)) {
                $this$dns_u24lambda_u240.routeDatabase = null;
            }
            $this$dns_u24lambda_u240.dns = dns;
            return this;
        }

        public final Builder proxy(Proxy proxy) {
            Builder $this$proxy_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(proxy, $this$proxy_u24lambda_u240.proxy)) {
                $this$proxy_u24lambda_u240.routeDatabase = null;
            }
            $this$proxy_u24lambda_u240.proxy = proxy;
            return this;
        }

        public final Builder proxySelector(ProxySelector proxySelector) {
            Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
            Builder $this$proxySelector_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(proxySelector, $this$proxySelector_u24lambda_u240.proxySelector)) {
                $this$proxySelector_u24lambda_u240.routeDatabase = null;
            }
            $this$proxySelector_u24lambda_u240.proxySelector = proxySelector;
            return this;
        }

        public final Builder proxyAuthenticator(Authenticator proxyAuthenticator) {
            Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
            Builder $this$proxyAuthenticator_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(proxyAuthenticator, $this$proxyAuthenticator_u24lambda_u240.proxyAuthenticator)) {
                $this$proxyAuthenticator_u24lambda_u240.routeDatabase = null;
            }
            $this$proxyAuthenticator_u24lambda_u240.proxyAuthenticator = proxyAuthenticator;
            return this;
        }

        public final Builder socketFactory(SocketFactory socketFactory) {
            Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
            Builder $this$socketFactory_u24lambda_u240 = this;
            if (socketFactory instanceof SSLSocketFactory) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
            }
            if (!Intrinsics.areEqual(socketFactory, $this$socketFactory_u24lambda_u240.socketFactory)) {
                $this$socketFactory_u24lambda_u240.routeDatabase = null;
            }
            $this$socketFactory_u24lambda_u240.socketFactory = socketFactory;
            return this;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        public final Builder sslSocketFactory(SSLSocketFactory sslSocketFactory) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Builder $this$sslSocketFactory_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(sslSocketFactory, $this$sslSocketFactory_u24lambda_u240.sslSocketFactoryOrNull)) {
                $this$sslSocketFactory_u24lambda_u240.routeDatabase = null;
            }
            $this$sslSocketFactory_u24lambda_u240.sslSocketFactoryOrNull = sslSocketFactory;
            X509TrustManager x509TrustManagerTrustManager = Platform.Companion.get().trustManager(sslSocketFactory);
            if (x509TrustManagerTrustManager != null) {
                $this$sslSocketFactory_u24lambda_u240.x509TrustManagerOrNull = x509TrustManagerTrustManager;
                Platform platform = Platform.Companion.get();
                X509TrustManager x509TrustManager = $this$sslSocketFactory_u24lambda_u240.x509TrustManagerOrNull;
                Intrinsics.checkNotNull(x509TrustManager);
                $this$sslSocketFactory_u24lambda_u240.certificateChainCleaner = platform.buildCertificateChainCleaner(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + Platform.Companion.get() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        public final Builder sslSocketFactory(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Builder $this$sslSocketFactory_u24lambda_u241 = this;
            if (!Intrinsics.areEqual(sslSocketFactory, $this$sslSocketFactory_u24lambda_u241.sslSocketFactoryOrNull) || !Intrinsics.areEqual(trustManager, $this$sslSocketFactory_u24lambda_u241.x509TrustManagerOrNull)) {
                $this$sslSocketFactory_u24lambda_u241.routeDatabase = null;
            }
            $this$sslSocketFactory_u24lambda_u241.sslSocketFactoryOrNull = sslSocketFactory;
            $this$sslSocketFactory_u24lambda_u241.certificateChainCleaner = CertificateChainCleaner.Companion.get(trustManager);
            $this$sslSocketFactory_u24lambda_u241.x509TrustManagerOrNull = trustManager;
            return this;
        }

        public final Builder connectionSpecs(List<ConnectionSpec> list) {
            Intrinsics.checkNotNullParameter(list, "connectionSpecs");
            Builder $this$connectionSpecs_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(list, $this$connectionSpecs_u24lambda_u240.connectionSpecs)) {
                $this$connectionSpecs_u24lambda_u240.routeDatabase = null;
            }
            $this$connectionSpecs_u24lambda_u240.connectionSpecs = _UtilJvmKt.toImmutableList(list);
            return this;
        }

        public final Builder protocols(List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "protocols");
            Builder $this$protocols_u24lambda_u240 = this;
            List protocolsCopy = CollectionsKt.toMutableList((Collection) list);
            if (!(protocolsCopy.contains(Protocol.H2_PRIOR_KNOWLEDGE) || protocolsCopy.contains(Protocol.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + protocolsCopy).toString());
            }
            if (!(!protocolsCopy.contains(Protocol.H2_PRIOR_KNOWLEDGE) || protocolsCopy.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + protocolsCopy).toString());
            }
            if (protocolsCopy.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + protocolsCopy).toString());
            }
            Intrinsics.checkNotNull(protocolsCopy, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
            if (protocolsCopy.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            protocolsCopy.remove(Protocol.SPDY_3);
            if (!Intrinsics.areEqual(protocolsCopy, $this$protocols_u24lambda_u240.protocols)) {
                $this$protocols_u24lambda_u240.routeDatabase = null;
            }
            List<? extends Protocol> listUnmodifiableList = Collections.unmodifiableList(protocolsCopy);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
            $this$protocols_u24lambda_u240.protocols = listUnmodifiableList;
            return this;
        }

        public final Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            Intrinsics.checkNotNullParameter(hostnameVerifier, "hostnameVerifier");
            Builder $this$hostnameVerifier_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(hostnameVerifier, $this$hostnameVerifier_u24lambda_u240.hostnameVerifier)) {
                $this$hostnameVerifier_u24lambda_u240.routeDatabase = null;
            }
            $this$hostnameVerifier_u24lambda_u240.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public final Builder certificatePinner(CertificatePinner certificatePinner) {
            Intrinsics.checkNotNullParameter(certificatePinner, "certificatePinner");
            Builder $this$certificatePinner_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(certificatePinner, $this$certificatePinner_u24lambda_u240.certificatePinner)) {
                $this$certificatePinner_u24lambda_u240.routeDatabase = null;
            }
            $this$certificatePinner_u24lambda_u240.certificatePinner = certificatePinner;
            return this;
        }

        public final Builder callTimeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Builder $this$callTimeout_u24lambda_u240 = this;
            $this$callTimeout_u24lambda_u240.callTimeout = _UtilJvmKt.checkDuration("timeout", timeout, unit);
            return this;
        }

        public final Builder callTimeout(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            Builder $this$callTimeout_u24lambda_u241 = this;
            $this$callTimeout_u24lambda_u241.callTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder m1706callTimeoutLRDsOJo(long j) {
            Builder $this$callTimeout_LRDsOJo_u24lambda_u240 = this;
            $this$callTimeout_LRDsOJo_u24lambda_u240.callTimeout = _UtilJvmKt.m1736checkDurationHG0u8IE("duration", j);
            return this;
        }

        public final Builder connectTimeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Builder $this$connectTimeout_u24lambda_u240 = this;
            $this$connectTimeout_u24lambda_u240.connectTimeout = _UtilJvmKt.checkDuration("timeout", timeout, unit);
            return this;
        }

        public final Builder connectTimeout(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            Builder $this$connectTimeout_u24lambda_u241 = this;
            $this$connectTimeout_u24lambda_u241.connectTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder m1707connectTimeoutLRDsOJo(long j) {
            Builder $this$connectTimeout_LRDsOJo_u24lambda_u240 = this;
            $this$connectTimeout_LRDsOJo_u24lambda_u240.connectTimeout = _UtilJvmKt.m1736checkDurationHG0u8IE("duration", j);
            return this;
        }

        public final Builder readTimeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Builder $this$readTimeout_u24lambda_u240 = this;
            $this$readTimeout_u24lambda_u240.readTimeout = _UtilJvmKt.checkDuration("timeout", timeout, unit);
            return this;
        }

        public final Builder readTimeout(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            Builder $this$readTimeout_u24lambda_u241 = this;
            $this$readTimeout_u24lambda_u241.readTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder m1709readTimeoutLRDsOJo(long j) {
            Builder $this$readTimeout_LRDsOJo_u24lambda_u240 = this;
            $this$readTimeout_LRDsOJo_u24lambda_u240.readTimeout = _UtilJvmKt.m1736checkDurationHG0u8IE("duration", j);
            return this;
        }

        public final Builder writeTimeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Builder $this$writeTimeout_u24lambda_u240 = this;
            $this$writeTimeout_u24lambda_u240.writeTimeout = _UtilJvmKt.checkDuration("timeout", timeout, unit);
            return this;
        }

        public final Builder writeTimeout(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            Builder $this$writeTimeout_u24lambda_u241 = this;
            $this$writeTimeout_u24lambda_u241.writeTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder m1711writeTimeoutLRDsOJo(long j) {
            Builder $this$writeTimeout_LRDsOJo_u24lambda_u240 = this;
            $this$writeTimeout_LRDsOJo_u24lambda_u240.writeTimeout = _UtilJvmKt.m1736checkDurationHG0u8IE("duration", j);
            return this;
        }

        public final Builder pingInterval(long interval, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Builder $this$pingInterval_u24lambda_u240 = this;
            $this$pingInterval_u24lambda_u240.pingInterval = _UtilJvmKt.checkDuration("interval", interval, unit);
            return this;
        }

        public final Builder pingInterval(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            Builder $this$pingInterval_u24lambda_u241 = this;
            $this$pingInterval_u24lambda_u241.pingInterval(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder m1708pingIntervalLRDsOJo(long j) {
            Builder $this$pingInterval_LRDsOJo_u24lambda_u240 = this;
            $this$pingInterval_LRDsOJo_u24lambda_u240.pingInterval = _UtilJvmKt.m1736checkDurationHG0u8IE("duration", j);
            return this;
        }

        public final Builder webSocketCloseTimeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Builder $this$webSocketCloseTimeout_u24lambda_u240 = this;
            $this$webSocketCloseTimeout_u24lambda_u240.webSocketCloseTimeout = _UtilJvmKt.checkDuration("webSocketCloseTimeout", timeout, unit);
            return this;
        }

        public final Builder webSocketCloseTimeout(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            Builder $this$webSocketCloseTimeout_u24lambda_u241 = this;
            $this$webSocketCloseTimeout_u24lambda_u241.webSocketCloseTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder m1710webSocketCloseTimeoutLRDsOJo(long j) {
            Builder $this$webSocketCloseTimeout_LRDsOJo_u24lambda_u240 = this;
            $this$webSocketCloseTimeout_LRDsOJo_u24lambda_u240.webSocketCloseTimeout = _UtilJvmKt.m1736checkDurationHG0u8IE("duration", j);
            return this;
        }

        public final Builder minWebSocketMessageToCompress(long bytes) {
            Builder $this$minWebSocketMessageToCompress_u24lambda_u240 = this;
            if (!(bytes >= 0)) {
                throw new IllegalArgumentException(("minWebSocketMessageToCompress must be positive: " + bytes).toString());
            }
            $this$minWebSocketMessageToCompress_u24lambda_u240.minWebSocketMessageToCompress = bytes;
            return this;
        }

        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lni/shikatu/okhttp3/OkHttpClient$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "DEFAULT_PROTOCOLS", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Protocol;", "getDEFAULT_PROTOCOLS$okhttp", "()Ljava/util/List;", "DEFAULT_CONNECTION_SPECS", "Lni/shikatu/okhttp3/ConnectionSpec;", "getDEFAULT_CONNECTION_SPECS$okhttp", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }

        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }
    }
}
