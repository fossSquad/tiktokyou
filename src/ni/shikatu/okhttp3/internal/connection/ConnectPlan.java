package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Address;
import ni.shikatu.okhttp3.CertificatePinner;
import ni.shikatu.okhttp3.ConnectionSpec;
import ni.shikatu.okhttp3.Handshake;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.Route;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.http.ExchangeCodec;
import ni.shikatu.okhttp3.internal.http1.Http1ExchangeCodec;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.tls.CertificateChainCleaner;
import ni.shikatu.okhttp3.internal.tls.OkHostnameVerifier;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0093\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dJ2\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u00020<H\u0002J\r\u0010=\u001a\u000209H\u0000¢\u0006\u0002\b>J\u0018\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\n\u0010D\u001a\u0004\u0018\u00010\u0019H\u0002J#\u0010E\u001a\u00020\u00002\f\u0010F\u001a\b\u0012\u0004\u0012\u00020C0\u00162\u0006\u0010@\u001a\u00020AH\u0000¢\u0006\u0002\bGJ%\u0010H\u001a\u0004\u0018\u00010\u00002\f\u0010F\u001a\b\u0012\u0004\u0012\u00020C0\u00162\u0006\u0010@\u001a\u00020AH\u0000¢\u0006\u0002\bIJ\b\u0010J\u001a\u000205H\u0016J\u001a\u0010K\u001a\u00020<2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020<H\u0016J\b\u0010O\u001a\u00020<H\u0016J\b\u0010P\u001a\u00020\u0001H\u0016J\u0006\u0010Q\u001a\u00020<R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u001b\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010%¨\u0006S"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/ConnectPlan;", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$Plan;", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec$Carrier;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "connectionPool", "Lni/shikatu/okhttp3/internal/connection/RealConnectionPool;", "readTimeoutMillis", _UrlKt.FRAGMENT_ENCODE_SET, "writeTimeoutMillis", "socketConnectTimeoutMillis", "socketReadTimeoutMillis", "pingIntervalMillis", "retryOnConnectionFailure", _UrlKt.FRAGMENT_ENCODE_SET, "call", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "routePlanner", "Lni/shikatu/okhttp3/internal/connection/RealRoutePlanner;", "route", "Lni/shikatu/okhttp3/Route;", "routes", _UrlKt.FRAGMENT_ENCODE_SET, "attempt", "tunnelRequest", "Lni/shikatu/okhttp3/Request;", "connectionSpecIndex", "isTlsFallback", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/internal/connection/RealConnectionPool;IIIIIZLokhttp3/internal/connection/RealCall;Lokhttp3/internal/connection/RealRoutePlanner;Lokhttp3/Route;Ljava/util/List;ILokhttp3/Request;IZ)V", "getRoute", "()Lokhttp3/Route;", "getRoutes$okhttp", "()Ljava/util/List;", "getConnectionSpecIndex$okhttp", "()I", "isTlsFallback$okhttp", "()Z", "canceled", "rawSocket", "Ljava/net/Socket;", "javaNetSocket", "getJavaNetSocket$okhttp", "()Ljava/net/Socket;", "setJavaNetSocket$okhttp", "(Ljava/net/Socket;)V", "handshake", "Lni/shikatu/okhttp3/Handshake;", "protocol", "Lni/shikatu/okhttp3/Protocol;", "socket", "Lni/shikatu/okhttp3/internal/connection/BufferedSocket;", "connection", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "isReady", "copy", "connectTcp", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$ConnectResult;", "connectTlsEtc", "connectSocket", _UrlKt.FRAGMENT_ENCODE_SET, "connectTunnel", "connectTunnel$okhttp", "connectTls", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionSpec", "Lni/shikatu/okhttp3/ConnectionSpec;", "createTunnel", "planWithCurrentOrInitialConnectionSpec", "connectionSpecs", "planWithCurrentOrInitialConnectionSpec$okhttp", "nextConnectionSpec", "nextConnectionSpec$okhttp", "handleSuccess", "trackFailure", "e", "Ljava/io/IOException;", "noNewExchanges", "cancel", "retry", "closeQuietly", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConnectPlan implements RoutePlanner.Plan, ExchangeCodec.Carrier {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private final int attempt;
    private final RealCall call;
    private volatile boolean canceled;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final int connectionSpecIndex;
    private Handshake handshake;
    private final boolean isTlsFallback;
    private Socket javaNetSocket;
    private final int pingIntervalMillis;
    private Protocol protocol;
    private Socket rawSocket;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final Route route;
    private final RealRoutePlanner routePlanner;
    private final List<Route> routes;
    private BufferedSocket socket;
    private final int socketConnectTimeoutMillis;
    private final int socketReadTimeoutMillis;
    private final TaskRunner taskRunner;
    private final Request tunnelRequest;
    private final int writeTimeoutMillis;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConnectPlan(TaskRunner taskRunner, RealConnectionPool connectionPool, int readTimeoutMillis, int writeTimeoutMillis, int socketConnectTimeoutMillis, int socketReadTimeoutMillis, int pingIntervalMillis, boolean retryOnConnectionFailure, RealCall call, RealRoutePlanner routePlanner, Route route, List<Route> list, int attempt, Request tunnelRequest, int connectionSpecIndex, boolean isTlsFallback) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(route, "route");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = readTimeoutMillis;
        this.writeTimeoutMillis = writeTimeoutMillis;
        this.socketConnectTimeoutMillis = socketConnectTimeoutMillis;
        this.socketReadTimeoutMillis = socketReadTimeoutMillis;
        this.pingIntervalMillis = pingIntervalMillis;
        this.retryOnConnectionFailure = retryOnConnectionFailure;
        this.call = call;
        this.routePlanner = routePlanner;
        this.route = route;
        this.routes = list;
        this.attempt = attempt;
        this.tunnelRequest = tunnelRequest;
        this.connectionSpecIndex = connectionSpecIndex;
        this.isTlsFallback = isTlsFallback;
    }

    @Override
    public Route getRoute() {
        return this.route;
    }

    public final List<Route> getRoutes$okhttp() {
        return this.routes;
    }

    public final int getConnectionSpecIndex$okhttp() {
        return this.connectionSpecIndex;
    }

    public final boolean isTlsFallback$okhttp() {
        return this.isTlsFallback;
    }

    public final Socket getJavaNetSocket$okhttp() {
        return this.javaNetSocket;
    }

    public final void setJavaNetSocket$okhttp(Socket socket) {
        this.javaNetSocket = socket;
    }

    @Override
    public boolean isReady() {
        return this.protocol != null;
    }

    static  ConnectPlan copy$default(ConnectPlan connectPlan, int i, Request request, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = connectPlan.attempt;
        }
        if ((i3 & 2) != 0) {
            request = connectPlan.tunnelRequest;
        }
        if ((i3 & 4) != 0) {
            i2 = connectPlan.connectionSpecIndex;
        }
        if ((i3 & 8) != 0) {
            z = connectPlan.isTlsFallback;
        }
        return connectPlan.copy(i, request, i2, z);
    }

    private final ConnectPlan copy(int attempt, Request tunnelRequest, int connectionSpecIndex, boolean isTlsFallback) {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this.routePlanner, getRoute(), this.routes, attempt, tunnelRequest, connectionSpecIndex, isTlsFallback);
    }

    @Override

    public RoutePlanner.ConnectResult mo1744connectTcp() {
        Socket socket;
        Socket socket2;
        if (!(this.rawSocket == null)) {
            throw new IllegalStateException("TCP already connected".toString());
        }
        boolean success = false;
        this.call.getPlansToCancel$okhttp().add(this);
        try {
            try {
                this.call.getEventListener$okhttp().connectStart(this.call, getRoute().socketAddress(), getRoute().proxy());
                this.connectionPool.getConnectionListener$okhttp().connectStart(getRoute(), this.call);
                connectSocket();
                success = true;
                RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, null, null, 6, null);
                this.call.getPlansToCancel$okhttp().remove(this);
                return connectResult;
            } catch (IOException e) {
                if (getRoute().address().proxy() == null && getRoute().proxy().type() != Proxy.Type.DIRECT) {
                    getRoute().address().proxySelector().connectFailed(getRoute().address().url().uri(), getRoute().proxy().address(), e);
                }
                this.call.getEventListener$okhttp().connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), null, e);
                this.connectionPool.getConnectionListener$okhttp().connectFailed(getRoute(), this.call, e);
                RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, null, e, 2, null);
                this.call.getPlansToCancel$okhttp().remove(this);
                if (!success && (socket = this.rawSocket) != null) {
                    _UtilJvmKt.closeQuietly(socket);
                }
                return connectResult2;
            }
        } catch (Throwable th) {
            this.call.getPlansToCancel$okhttp().remove(this);
            if (!success && (socket2 = this.rawSocket) != null) {
                _UtilJvmKt.closeQuietly(socket2);
            }
            throw th;
        }
    }

    @Override

    public RoutePlanner.ConnectResult mo1745connectTlsEtc() throws Throwable {
        ConnectPlan retryTlsConnection;
        BufferedSocket bufferedSocket;
        Socket rawSocket = this.rawSocket;
        if (rawSocket == null) {
            throw new IllegalArgumentException("TCP not connected".toString());
        }
        if (isReady()) {
            throw new IllegalStateException("already connected".toString());
        }
        List<ConnectionSpec> listConnectionSpecs = getRoute().address().connectionSpecs();
        ConnectPlan retryTlsConnection2 = null;
        boolean success = false;
        this.call.getPlansToCancel$okhttp().add(this);
        try {
            try {
                if (this.tunnelRequest != null) {
                    RoutePlanner.ConnectResult tunnelResult = connectTunnel$okhttp();
                    if (tunnelResult.getNextPlan() != null || tunnelResult.getThrowable() != null) {
                        this.call.getPlansToCancel$okhttp().remove(this);
                        Socket socket = this.javaNetSocket;
                        if (socket != null) {
                            _UtilJvmKt.closeQuietly(socket);
                        }
                        _UtilJvmKt.closeQuietly(rawSocket);
                        return tunnelResult;
                    }
                }
                if (getRoute().address().sslSocketFactory() != null) {
                    BufferedSocket bufferedSocket2 = this.socket;
                    if (bufferedSocket2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("socket");
                        bufferedSocket2 = null;
                    }
                    if (bufferedSocket2.getSource().getBuffer().exhausted()) {
                        BufferedSocket bufferedSocket3 = this.socket;
                        if (bufferedSocket3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("socket");
                            bufferedSocket3 = null;
                        }
                        if (bufferedSocket3.getSink().getBuffer().exhausted()) {
                            this.call.getEventListener$okhttp().secureConnectStart(this.call);
                            Socket socketCreateSocket = getRoute().address().sslSocketFactory().createSocket(rawSocket, getRoute().address().url().host(), getRoute().address().url().port(), true);
                            Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                            SSLSocket sslSocket = (SSLSocket) socketCreateSocket;
                            ConnectPlan tlsEquipPlan = planWithCurrentOrInitialConnectionSpec$okhttp(listConnectionSpecs, sslSocket);
                            ConnectionSpec connectionSpec = listConnectionSpecs.get(tlsEquipPlan.connectionSpecIndex);
                            ConnectPlan retryTlsConnection3 = tlsEquipPlan.nextConnectionSpec$okhttp(listConnectionSpecs, sslSocket);
                            connectionSpec.apply$okhttp(sslSocket, tlsEquipPlan.isTlsFallback);
                            connectTls(sslSocket, connectionSpec);
                            this.call.getEventListener$okhttp().secureConnectEnd(this.call, this.handshake);
                            retryTlsConnection = retryTlsConnection3;
                        }
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                this.javaNetSocket = rawSocket;
                this.protocol = getRoute().address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_1_1;
                retryTlsConnection = null;
                try {
                    TaskRunner taskRunner = this.taskRunner;
                    RealConnectionPool realConnectionPool = this.connectionPool;
                    Route route = getRoute();
                    Socket socket2 = this.javaNetSocket;
                    Intrinsics.checkNotNull(socket2);
                    Handshake handshake = this.handshake;
                    Protocol protocol = this.protocol;
                    Intrinsics.checkNotNull(protocol);
                    BufferedSocket bufferedSocket4 = this.socket;
                    if (bufferedSocket4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("socket");
                        bufferedSocket = null;
                    } else {
                        bufferedSocket = bufferedSocket4;
                    }
                    RealConnection connection = new RealConnection(taskRunner, realConnectionPool, route, rawSocket, socket2, handshake, protocol, bufferedSocket, this.pingIntervalMillis, this.connectionPool.getConnectionListener$okhttp());
                    this.connection = connection;
                    connection.start();
                    this.call.getEventListener$okhttp().connectEnd(this.call, getRoute().socketAddress(), getRoute().proxy(), this.protocol);
                    success = true;
                    RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, null, null, 6, null);
                    this.call.getPlansToCancel$okhttp().remove(this);
                    return connectResult;
                } catch (IOException e) {
                    e = e;
                    retryTlsConnection2 = retryTlsConnection;
                    IOException e2 = e;
                    this.call.getEventListener$okhttp().connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), null, e2);
                    this.connectionPool.getConnectionListener$okhttp().connectFailed(getRoute(), this.call, e2);
                    if (!this.retryOnConnectionFailure || !RetryTlsHandshakeKt.retryTlsHandshake(e2)) {
                        retryTlsConnection2 = null;
                    }
                    RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, retryTlsConnection2, e2);
                    this.call.getPlansToCancel$okhttp().remove(this);
                    if (!success) {
                        Socket socket3 = this.javaNetSocket;
                        if (socket3 != null) {
                            _UtilJvmKt.closeQuietly(socket3);
                        }
                        _UtilJvmKt.closeQuietly(rawSocket);
                    }
                    return connectResult2;
                } catch (Throwable th) {
                    th = th;
                    this.call.getPlansToCancel$okhttp().remove(this);
                    if (!success) {
                        Socket socket4 = this.javaNetSocket;
                        if (socket4 != null) {
                            _UtilJvmKt.closeQuietly(socket4);
                        }
                        _UtilJvmKt.closeQuietly(rawSocket);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    private final void connectSocket() throws IOException {
        Socket rawSocket;
        Proxy.Type type = getRoute().proxy().type();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
                rawSocket = getRoute().address().socketFactory().createSocket();
                Intrinsics.checkNotNull(rawSocket);
                break;
            default:
                rawSocket = new Socket(getRoute().proxy());
                break;
        }
        this.rawSocket = rawSocket;
        if (this.canceled) {
            throw new IOException("canceled");
        }
        rawSocket.setSoTimeout(this.socketReadTimeoutMillis);
        try {
            Platform.Companion.get().connectSocket(rawSocket, getRoute().socketAddress(), this.socketConnectTimeoutMillis);
            try {
                this.socket = BufferedSocketKt.asBufferedSocket(rawSocket);
            } catch (NullPointerException npe) {
                if (Intrinsics.areEqual(npe.getMessage(), NPE_THROW_WITH_NULL)) {
                    throw new IOException(npe);
                }
            }
        } catch (ConnectException e) {
            ConnectException $this$connectSocket_u24lambda_u240 = new ConnectException("Failed to connect to " + getRoute().socketAddress());
            $this$connectSocket_u24lambda_u240.initCause(e);
            throw $this$connectSocket_u24lambda_u240;
        }
    }

    public final RoutePlanner.ConnectResult connectTunnel$okhttp() throws IOException {
        Request nextTunnelRequest = createTunnel();
        if (nextTunnelRequest == null) {
            return new RoutePlanner.ConnectResult(this, null, null, 6, null);
        }
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
        int nextAttempt = this.attempt + 1;
        if (nextAttempt < MAX_TUNNEL_ATTEMPTS) {
            this.call.getEventListener$okhttp().connectEnd(this.call, getRoute().socketAddress(), getRoute().proxy(), null);
            return new RoutePlanner.ConnectResult(this, copy$default(this, nextAttempt, nextTunnelRequest, 0, false, 12, null), null, 4, null);
        }
        ProtocolException failure = new ProtocolException("Too many tunnel connections attempted: 21");
        this.call.getEventListener$okhttp().connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), null, failure);
        this.connectionPool.getConnectionListener$okhttp().connectFailed(getRoute(), this.call, failure);
        return new RoutePlanner.ConnectResult(this, null, failure, 2, null);
    }

    private final void connectTls(SSLSocket sslSocket, ConnectionSpec connectionSpec) throws IOException {
        final Address address = getRoute().address();
        try {
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.Companion.get().configureTlsExtensions(sslSocket, address.url().host(), address.protocols());
            }
            sslSocket.startHandshake();
            SSLSession sslSocketSession = sslSocket.getSession();
            Handshake.Companion companion = Handshake.Companion;
            Intrinsics.checkNotNull(sslSocketSession);
            final Handshake unverifiedHandshake = companion.get(sslSocketSession);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            Intrinsics.checkNotNull(hostnameVerifier);
            if (!hostnameVerifier.verify(address.url().host(), sslSocketSession)) {
                List<Certificate> listPeerCertificates = unverifiedHandshake.peerCertificates();
                if (listPeerCertificates.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                }
                Certificate certificate = listPeerCertificates.get(0);
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate cert = (X509Certificate) certificate;
                throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n            |Hostname " + address.url().host() + " not verified:\n            |    certificate: " + CertificatePinner.Companion.pin(cert) + "\n            |    DN: " + cert.getSubjectDN().getName() + "\n            |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(cert) + "\n            ", null, 1, null));
            }
            final CertificatePinner certificatePinner = address.certificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            final Handshake handshake = new Handshake(unverifiedHandshake.tlsVersion(), unverifiedHandshake.cipherSuite(), unverifiedHandshake.localCertificates(), new Function0() {
                @Override
                public final Object invoke() {
                    return ConnectPlan.connectTls$lambda$0(certificatePinner, unverifiedHandshake, address);
                }
            });
            this.handshake = handshake;
            certificatePinner.check$okhttp(address.url().host(), new Function0() {
                @Override
                public final Object invoke() {
                    return ConnectPlan.connectTls$lambda$1(handshake);
                }
            });
            String maybeProtocol = connectionSpec.supportsTlsExtensions() ? Platform.Companion.get().getSelectedProtocol(sslSocket) : null;
            this.javaNetSocket = sslSocket;
            this.socket = BufferedSocketKt.asBufferedSocket(sslSocket);
            this.protocol = maybeProtocol != null ? Protocol.Companion.get(maybeProtocol) : Protocol.HTTP_1_1;
            Platform.Companion.get().afterHandshake(sslSocket);
        } catch (Throwable th) {
            Platform.Companion.get().afterHandshake(sslSocket);
            _UtilJvmKt.closeQuietly(sslSocket);
            throw th;
        }
    }

    public static final List connectTls$lambda$0(CertificatePinner $certificatePinner, Handshake $unverifiedHandshake, Address $address) {
        CertificateChainCleaner certificateChainCleaner$okhttp = $certificatePinner.getCertificateChainCleaner$okhttp();
        Intrinsics.checkNotNull(certificateChainCleaner$okhttp);
        return certificateChainCleaner$okhttp.clean($unverifiedHandshake.peerCertificates(), $address.url().host());
    }

    public static final List connectTls$lambda$1(Handshake $handshake) {
        Iterable $this$map$iv = $handshake.peerCertificates();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Certificate it = (Certificate) item$iv$iv;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            destination$iv$iv.add((X509Certificate) it);
        }
        return (List) destination$iv$iv;
    }

    private final Request createTunnel() throws IOException {
        Response response;
        Request nextRequest = this.tunnelRequest;
        Intrinsics.checkNotNull(nextRequest);
        HttpUrl url = getRoute().address().url();
        String requestLine = "CONNECT " + _UtilJvmKt.toHostHeader(url, true) + " HTTP/1.1";
        do {
            ConnectPlan connectPlan = this;
            BufferedSocket bufferedSocket = this.socket;
            if (bufferedSocket == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
                bufferedSocket = null;
            }
            Http1ExchangeCodec tunnelCodec = new Http1ExchangeCodec(null, connectPlan, bufferedSocket);
            BufferedSocket bufferedSocket2 = this.socket;
            if (bufferedSocket2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
                bufferedSocket2 = null;
            }
            bufferedSocket2.getSource().timeout().timeout(this.readTimeoutMillis, TimeUnit.MILLISECONDS);
            BufferedSocket bufferedSocket3 = this.socket;
            if (bufferedSocket3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
                bufferedSocket3 = null;
            }
            bufferedSocket3.getSink().timeout().timeout(this.writeTimeoutMillis, TimeUnit.MILLISECONDS);
            tunnelCodec.writeRequest(nextRequest.headers(), requestLine);
            tunnelCodec.finishRequest();
            Response.Builder responseHeaders = tunnelCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(responseHeaders);
            response = responseHeaders.request(nextRequest).build();
            tunnelCodec.skipConnectBody(response);
            switch (response.code()) {
                case 200:
                    return null;
                case 407:
                    Request requestAuthenticate = getRoute().address().proxyAuthenticator().authenticate(getRoute(), response);
                    if (requestAuthenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                    nextRequest = requestAuthenticate;
                    break;
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + response.code());
            }
        } while (!StringsKt.equals("close", Response.header$default(response, "Connection", null, 2, null), true));
        return nextRequest;
    }

    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(List<ConnectionSpec> list, SSLSocket sslSocket) throws IOException {
        Intrinsics.checkNotNullParameter(list, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan connectPlanNextConnectionSpec$okhttp = nextConnectionSpec$okhttp(list, sslSocket);
        if (connectPlanNextConnectionSpec$okhttp != null) {
            return connectPlanNextConnectionSpec$okhttp;
        }
        StringBuilder sbAppend = new StringBuilder().append("Unable to find acceptable protocols. isFallback=").append(this.isTlsFallback).append(", modes=").append(list).append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        throw new UnknownServiceException(sbAppend.append(string).toString());
    }

    public final ConnectPlan nextConnectionSpec$okhttp(List<ConnectionSpec> list, SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(list, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i = this.connectionSpecIndex + 1;
        int size = list.size();
        for (int i2 = i; i2 < size; i2++) {
            if (list.get(i2).isCompatible(sslSocket)) {
                return copy$default(this, 0, null, i2, this.connectionSpecIndex != -1, 3, null);
            }
        }
        return null;
    }

    @Override

    public RealConnection mo1741handleSuccess() {
        this.call.getClient().getRouteDatabase$okhttp().connected(getRoute());
        RealConnection connection = this.connection;
        Intrinsics.checkNotNull(connection);
        connection.getConnectionListener$okhttp().connectEnd(connection, getRoute(), this.call);
        ReusePlan pooled3 = this.routePlanner.planReusePooledConnection$okhttp(this, this.routes);
        if (pooled3 != null) {
            return pooled3.getConnection();
        }
        RealConnection $this$withLock$iv = connection;
        synchronized ($this$withLock$iv) {
            this.connectionPool.put(connection);
            this.call.acquireConnectionNoEvents(connection);
            Unit unit = Unit.INSTANCE;
        }
        this.call.getEventListener$okhttp().connectionAcquired(this.call, connection);
        connection.getConnectionListener$okhttp().connectionAcquired(connection, this.call);
        return connection;
    }

    @Override
    public void trackFailure(RealCall call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    @Override
    public void noNewExchanges() {
    }

    @Override

    public void mo1740cancel() {
        this.canceled = true;
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    @Override

    public RoutePlanner.Plan mo1742retry() {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this.routePlanner, getRoute(), this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback);
    }

    public final void closeQuietly() {
        Socket socket = this.javaNetSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/ConnectPlan$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "NPE_THROW_WITH_NULL", _UrlKt.FRAGMENT_ENCODE_SET, "MAX_TUNNEL_ATTEMPTS", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
