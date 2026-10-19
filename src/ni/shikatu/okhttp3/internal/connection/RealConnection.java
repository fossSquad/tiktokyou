package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.Address;
import ni.shikatu.okhttp3.CertificatePinner;
import ni.shikatu.okhttp3.Connection;
import ni.shikatu.okhttp3.Handshake;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.Route;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.http.ExchangeCodec;
import ni.shikatu.okhttp3.internal.http.RealInterceptorChain;
import ni.shikatu.okhttp3.internal.http1.Http1ExchangeCodec;
import ni.shikatu.okhttp3.internal.http2.ConnectionShutdownException;
import ni.shikatu.okhttp3.internal.http2.ErrorCode;
import ni.shikatu.okhttp3.internal.http2.FlowControlListener;
import ni.shikatu.okhttp3.internal.http2.Http2Connection;
import ni.shikatu.okhttp3.internal.http2.Http2ExchangeCodec;
import ni.shikatu.okhttp3.internal.http2.Http2Stream;
import ni.shikatu.okhttp3.internal.http2.Settings;
import ni.shikatu.okhttp3.internal.http2.StreamResetException;
import ni.shikatu.okhttp3.internal.tls.OkHostnameVerifier;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 r2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001rB[\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010$\u001a\u00020CH\u0016J\r\u0010*\u001a\u00020CH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020CH\u0000¢\u0006\u0002\bFJ\u0006\u0010G\u001a\u00020CJ\b\u0010H\u001a\u00020CH\u0002J%\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020K2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010MH\u0000¢\u0006\u0002\bNJ\u0016\u0010O\u001a\u00020%2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\n0MH\u0002J\u0010\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020SH\u0002J\u0018\u0010T\u001a\u00020%2\u0006\u0010R\u001a\u00020S2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001d\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020CH\u0000¢\u0006\u0002\b]J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010^\u001a\u00020CH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u000e\u0010_\u001a\u00020%2\u0006\u0010`\u001a\u00020%J\u0010\u0010a\u001a\u00020C2\u0006\u0010b\u001a\u00020cH\u0016J\u0018\u0010d\u001a\u00020C2\u0006\u0010e\u001a\u00020#2\u0006\u0010f\u001a\u00020gH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J%\u0010h\u001a\u00020C2\u0006\u0010W\u001a\u00020X2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020kH\u0000¢\u0006\u0002\blJ\u001a\u0010m\u001a\u00020C2\u0006\u0010n\u001a\u0002082\b\u0010o\u001a\u0004\u0018\u00010kH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010p\u001a\u00020qH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0015@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080706¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010'¨\u0006s"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RealConnection;", "Lni/shikatu/okhttp3/internal/http2/Http2Connection$Listener;", "Lni/shikatu/okhttp3/Connection;", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec$Carrier;", "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "connectionPool", "Lni/shikatu/okhttp3/internal/connection/RealConnectionPool;", "route", "Lni/shikatu/okhttp3/Route;", "rawSocket", "Ljava/net/Socket;", "javaNetSocket", "handshake", "Lni/shikatu/okhttp3/Handshake;", "protocol", "Lni/shikatu/okhttp3/Protocol;", "socket", "Lni/shikatu/okhttp3/internal/connection/BufferedSocket;", "pingIntervalMillis", _UrlKt.FRAGMENT_ENCODE_SET, "connectionListener", "Lni/shikatu/okhttp3/internal/connection/ConnectionListener;", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;Ljava/net/Socket;Ljava/net/Socket;Lokhttp3/Handshake;Lokhttp3/Protocol;Lokhttp3/internal/connection/BufferedSocket;ILokhttp3/internal/connection/ConnectionListener;)V", "getTaskRunner", "()Lokhttp3/internal/concurrent/TaskRunner;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "getRoute", "()Lokhttp3/Route;", "getConnectionListener$okhttp", "()Lokhttp3/internal/connection/ConnectionListener;", "http2Connection", "Lni/shikatu/okhttp3/internal/http2/Http2Connection;", "noNewExchanges", _UrlKt.FRAGMENT_ENCODE_SET, "getNoNewExchanges", "()Z", "setNoNewExchanges", "(Z)V", "noCoalescedConnections", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "successCount", "refusedStreamCount", "value", "allocationLimit", "getAllocationLimit$okhttp", "calls", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/ref/Reference;", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "getCalls", "()Ljava/util/List;", "idleAtNs", _UrlKt.FRAGMENT_ENCODE_SET, "getIdleAtNs", "()J", "setIdleAtNs", "(J)V", "isMultiplexed", "isMultiplexed$okhttp", _UrlKt.FRAGMENT_ENCODE_SET, "noCoalescedConnections$okhttp", "incrementSuccessCount", "incrementSuccessCount$okhttp", "start", "startHttp2", "isEligible", "address", "Lni/shikatu/okhttp3/Address;", "routes", _UrlKt.FRAGMENT_ENCODE_SET, "isEligible$okhttp", "routeMatchesAny", "candidates", "supportsUrl", "url", "Lni/shikatu/okhttp3/HttpUrl;", "certificateSupportHost", "newCodec", "Lni/shikatu/okhttp3/internal/http/ExchangeCodec;", "client", "Lni/shikatu/okhttp3/OkHttpClient;", "chain", "Lni/shikatu/okhttp3/internal/http/RealInterceptorChain;", "newCodec$okhttp", "useAsSocket", "useAsSocket$okhttp", "cancel", "isHealthy", "doExtensiveChecks", "onStream", "stream", "Lni/shikatu/okhttp3/internal/http2/Http2Stream;", "onSettings", "connection", "settings", "Lni/shikatu/okhttp3/internal/http2/Settings;", "connectFailed", "failedRoute", "failure", "Ljava/io/IOException;", "connectFailed$okhttp", "trackFailure", "call", "e", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealConnection extends Http2Connection.Listener implements Connection, ExchangeCodec.Carrier, Lockable {
    public static final Companion Companion = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private int allocationLimit;
    private final List<Reference<RealCall>> calls;
    private final ConnectionListener connectionListener;
    private final RealConnectionPool connectionPool;
    private final Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs;
    private final Socket javaNetSocket;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private final int pingIntervalMillis;
    private final Protocol protocol;
    private final Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private final BufferedSocket socket;
    private int successCount;
    private final TaskRunner taskRunner;

    public RealConnection(TaskRunner taskRunner, RealConnectionPool connectionPool, Route route, Socket rawSocket, Socket javaNetSocket, Handshake handshake, Protocol protocol, BufferedSocket socket, int pingIntervalMillis, ConnectionListener connectionListener) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(rawSocket, "rawSocket");
        Intrinsics.checkNotNullParameter(javaNetSocket, "javaNetSocket");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(connectionListener, "connectionListener");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.route = route;
        this.rawSocket = rawSocket;
        this.javaNetSocket = javaNetSocket;
        this.handshake = handshake;
        this.protocol = protocol;
        this.socket = socket;
        this.pingIntervalMillis = pingIntervalMillis;
        this.connectionListener = connectionListener;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = LongCompanionObject.MAX_VALUE;
    }

    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    @Override
    public Route getRoute() {
        return this.route;
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final void setNoNewExchanges(boolean z) {
        this.noNewExchanges = z;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final void setRouteFailureCount$okhttp(int i) {
        this.routeFailureCount = i;
    }

    public final int getAllocationLimit$okhttp() {
        return this.allocationLimit;
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    public final void setIdleAtNs(long j) {
        this.idleAtNs = j;
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    @Override
    public void noNewExchanges() {
        RealConnection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            this.noNewExchanges = true;
            Unit unit = Unit.INSTANCE;
        }
        this.connectionListener.noNewExchanges(this);
    }

    public final void noCoalescedConnections$okhttp() {
        RealConnection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            this.noCoalescedConnections = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void incrementSuccessCount$okhttp() {
        RealConnection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            this.successCount++;
        }
    }

    public final void start() throws IOException {
        this.idleAtNs = System.nanoTime();
        if (this.protocol == Protocol.HTTP_2 || this.protocol == Protocol.H2_PRIOR_KNOWLEDGE) {
            startHttp2();
        }
    }

    private final void startHttp2() throws IOException {
        this.javaNetSocket.setSoTimeout(0);
        Object obj = this.connectionListener;
        FlowControlListener.None flowControlListener = obj instanceof FlowControlListener ? (FlowControlListener) obj : null;
        if (flowControlListener == null) {
            flowControlListener = FlowControlListener.None.INSTANCE;
        }
        Http2Connection http2Connection = new Http2Connection.Builder(true, this.taskRunner).socket(this.socket, getRoute().address().url().host()).listener(this).pingIntervalMillis(this.pingIntervalMillis).flowControlListener(flowControlListener).build();
        this.http2Connection = http2Connection;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(http2Connection, false, 1, null);
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list) {
        Intrinsics.checkNotNullParameter(address, "address");
        RealConnection $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !getRoute().address().equalsNonHost$okhttp(address)) {
                return false;
            }
            if (Intrinsics.areEqual(address.url().host(), route().address().url().host())) {
                return true;
            }
            if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
                return false;
            }
            try {
                CertificatePinner certificatePinner = address.certificatePinner();
                Intrinsics.checkNotNull(certificatePinner);
                String strHost = address.url().host();
                Handshake handshake = handshake();
                Intrinsics.checkNotNull(handshake);
                certificatePinner.check(strHost, handshake.peerCertificates());
                return true;
            } catch (SSLPeerUnverifiedException e) {
                return false;
            }
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    private final boolean routeMatchesAny(List<Route> list) {
        List<Route> $this$any$iv = list;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            Route it = (Route) element$iv;
            if (it.proxy().type() == Proxy.Type.DIRECT && getRoute().proxy().type() == Proxy.Type.DIRECT && Intrinsics.areEqual(getRoute().socketAddress(), it.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final boolean supportsUrl(HttpUrl url) {
        RealConnection $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            HttpUrl routeUrl = getRoute().address().url();
            if (url.port() != routeUrl.port()) {
                return false;
            }
            if (Intrinsics.areEqual(url.host(), routeUrl.host())) {
                return true;
            }
            return (this.noCoalescedConnections || this.handshake == null || !certificateSupportHost(url, this.handshake)) ? false : true;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    private final boolean certificateSupportHost(HttpUrl url, Handshake handshake) {
        List<Certificate> listPeerCertificates = handshake.peerCertificates();
        if (listPeerCertificates.isEmpty()) {
            return false;
        }
        OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
        String strHost = url.host();
        Certificate certificate = listPeerCertificates.get(0);
        Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        return okHostnameVerifier.verify(strHost, (X509Certificate) certificate);
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient client, RealInterceptorChain chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        BufferedSocket okHttpSocket = this.socket;
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        this.javaNetSocket.setSoTimeout(chain.readTimeoutMillis());
        okHttpSocket.getSource().timeout().timeout(chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        okHttpSocket.getSink().timeout().timeout(chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        return new Http1ExchangeCodec(client, this, okHttpSocket);
    }

    public final void useAsSocket$okhttp() throws SocketException {
        this.javaNetSocket.setSoTimeout(0);
        noNewExchanges();
    }

    @Override
    public Route route() {
        return getRoute();
    }

    @Override

    public void mo1740cancel() {
        _UtilJvmKt.closeQuietly(this.rawSocket);
    }

    @Override
    public Socket socket() {
        return this.javaNetSocket;
    }

    public final boolean isHealthy(boolean doExtensiveChecks) {
        long idleDurationNs;
        RealConnection $this$assertLockNotHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            long nowNs = System.nanoTime();
            if (this.rawSocket.isClosed() || this.javaNetSocket.isClosed() || this.javaNetSocket.isInputShutdown() || this.javaNetSocket.isOutputShutdown()) {
                return false;
            }
            Http2Connection http2Connection = this.http2Connection;
            if (http2Connection != null) {
                return http2Connection.isHealthy(nowNs);
            }
            RealConnection $this$withLock$iv = this;
            synchronized ($this$withLock$iv) {
                idleDurationNs = nowNs - this.idleAtNs;
            }
            if (idleDurationNs >= IDLE_CONNECTION_HEALTHY_NS && doExtensiveChecks) {
                return _UtilJvmKt.isHealthy(this.javaNetSocket, this.socket.getSource());
            }
            return true;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    @Override
    public void onStream(Http2Stream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override
    public void onSettings(Http2Connection connection, Settings settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        RealConnection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            this.allocationLimit = settings.getMaxConcurrentStreams();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override
    public Handshake handshake() {
        return this.handshake;
    }

    public final void connectFailed$okhttp(OkHttpClient client, Route failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase$okhttp().failed(failedRoute);
    }

    @Override
    public void trackFailure(RealCall call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        boolean noNewExchangesEvent = false;
        RealConnection $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            if (e instanceof StreamResetException) {
                if (((StreamResetException) e).errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                    if (this.refusedStreamCount > 1) {
                        noNewExchangesEvent = this.noNewExchanges ? false : true;
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (((StreamResetException) e).errorCode != ErrorCode.CANCEL || !call.isCanceled()) {
                    noNewExchangesEvent = this.noNewExchanges ? false : true;
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed$okhttp() || (e instanceof ConnectionShutdownException)) {
                noNewExchangesEvent = this.noNewExchanges ? false : true;
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (e != null) {
                        connectFailed$okhttp(call.getClient(), getRoute(), e);
                    }
                    this.routeFailureCount++;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (noNewExchangesEvent) {
            this.connectionListener.noNewExchanges(this);
        }
    }

    @Override
    public Protocol protocol() {
        return this.protocol;
    }

    public String toString() {
        Object objCipherSuite;
        StringBuilder sbAppend = new StringBuilder().append("Connection{").append(getRoute().address().url().host()).append(AbstractJsonLexerKt.COLON).append(getRoute().address().url().port()).append(", proxy=").append(getRoute().proxy()).append(" hostAddress=").append(getRoute().socketAddress()).append(" cipherSuite=");
        Handshake handshake = this.handshake;
        if (handshake == null || (objCipherSuite = handshake.cipherSuite()) == null) {
            objCipherSuite = "none";
        }
        return sbAppend.append(objCipherSuite).append(" protocol=").append(this.protocol).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RealConnection$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "IDLE_CONNECTION_HEALTHY_NS", _UrlKt.FRAGMENT_ENCODE_SET, "newTestConnection", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "connectionPool", "Lni/shikatu/okhttp3/internal/connection/RealConnectionPool;", "route", "Lni/shikatu/okhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNs", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RealConnection newTestConnection(TaskRunner taskRunner, RealConnectionPool connectionPool, Route route, Socket socket, long idleAtNs) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(socket, "socket");
            RealConnection result = new RealConnection(taskRunner, connectionPool, route, new Socket(), socket, null, Protocol.HTTP_2, new BufferedSocket() {
                private final Buffer sink = new Buffer();
                private final Buffer source = new Buffer();

                @Override
                public Buffer getSink() {
                    return this.sink;
                }

                @Override
                public Buffer getSource() {
                    return this.source;
                }

                @Override
                public void cancel() {
                }
            }, 0, ConnectionListener.Companion.getNONE());
            result.setIdleAtNs(idleAtNs);
            return result;
        }
    }
}
