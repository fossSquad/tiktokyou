package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArrayDeque;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Address;
import ni.shikatu.okhttp3.ConnectionSpec;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.Route;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Bq\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020$H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\r\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J-\u0010.\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010,2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020!\u0018\u000101H\u0000¢\u0006\u0002\b2J'\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020!2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020!\u0018\u000101H\u0000¢\u0006\u0002\b5J\u0010\u00106\u001a\u00020\u00162\u0006\u00104\u001a\u00020!H\u0002J\u0012\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010:\u001a\u0004\u0018\u00010!2\u0006\u0010;\u001a\u000209H\u0002J\u0010\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020>H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006?"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RealRoutePlanner;", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "connectionPool", "Lni/shikatu/okhttp3/internal/connection/RealConnectionPool;", "readTimeoutMillis", _UrlKt.FRAGMENT_ENCODE_SET, "writeTimeoutMillis", "socketConnectTimeoutMillis", "socketReadTimeoutMillis", "pingIntervalMillis", "retryOnConnectionFailure", _UrlKt.FRAGMENT_ENCODE_SET, "fastFallback", "address", "Lni/shikatu/okhttp3/Address;", "routeDatabase", "Lni/shikatu/okhttp3/internal/connection/RouteDatabase;", "call", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "request", "Lni/shikatu/okhttp3/Request;", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/internal/connection/RealConnectionPool;IIIIIZZLokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/internal/connection/RealCall;Lokhttp3/Request;)V", "getAddress", "()Lokhttp3/Address;", "doExtensiveHealthChecks", "routeSelection", "Lni/shikatu/okhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lni/shikatu/okhttp3/internal/connection/RouteSelector;", "nextRouteToTry", "Lni/shikatu/okhttp3/Route;", "deferredPlans", "Lni/shikatu/kotlin/collections/ArrayDeque;", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$Plan;", "getDeferredPlans", "()Lkotlin/collections/ArrayDeque;", "isCanceled", "plan", "planReuseCallConnection", "Lni/shikatu/okhttp3/internal/connection/ReusePlan;", "planConnect", "Lni/shikatu/okhttp3/internal/connection/ConnectPlan;", "planConnect$okhttp", "planReusePooledConnection", "planToReplace", "routes", _UrlKt.FRAGMENT_ENCODE_SET, "planReusePooledConnection$okhttp", "planConnectToRoute", "route", "planConnectToRoute$okhttp", "createTunnelRequest", "hasNext", "failedConnection", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "retryRoute", "connection", "sameHostAndPort", "url", "Lni/shikatu/okhttp3/HttpUrl;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealRoutePlanner implements RoutePlanner {
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private final ArrayDeque<RoutePlanner.Plan> deferredPlans;
    private final boolean doExtensiveHealthChecks;
    private final boolean fastFallback;
    private Route nextRouteToTry;
    private final int pingIntervalMillis;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;
    private final int socketConnectTimeoutMillis;
    private final int socketReadTimeoutMillis;
    private final TaskRunner taskRunner;
    private final int writeTimeoutMillis;

    public RealRoutePlanner(TaskRunner taskRunner, RealConnectionPool connectionPool, int readTimeoutMillis, int writeTimeoutMillis, int socketConnectTimeoutMillis, int socketReadTimeoutMillis, int pingIntervalMillis, boolean retryOnConnectionFailure, boolean fastFallback, Address address, RouteDatabase routeDatabase, RealCall call, Request request) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = readTimeoutMillis;
        this.writeTimeoutMillis = writeTimeoutMillis;
        this.socketConnectTimeoutMillis = socketConnectTimeoutMillis;
        this.socketReadTimeoutMillis = socketReadTimeoutMillis;
        this.pingIntervalMillis = pingIntervalMillis;
        this.retryOnConnectionFailure = retryOnConnectionFailure;
        this.fastFallback = fastFallback;
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.doExtensiveHealthChecks = !Intrinsics.areEqual(request.method(), "GET");
        this.deferredPlans = new ArrayDeque<>();
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public ArrayDeque<RoutePlanner.Plan> getDeferredPlans() {
        return this.deferredPlans;
    }

    @Override
    public boolean isCanceled() {
        return this.call.isCanceled();
    }

    @Override
    public RoutePlanner.Plan plan() throws IOException {
        ReusePlan reuseCallConnection = planReuseCallConnection();
        if (reuseCallConnection != null) {
            return reuseCallConnection;
        }
        ReusePlan pooled1 = planReusePooledConnection$okhttp$default(this, null, null, 3, null);
        if (pooled1 != null) {
            return pooled1;
        }
        if (!getDeferredPlans().isEmpty()) {
            return getDeferredPlans().removeFirst();
        }
        ConnectPlan connect = planConnect$okhttp();
        ReusePlan pooled2 = planReusePooledConnection$okhttp(connect, connect.getRoutes$okhttp());
        return pooled2 != null ? pooled2 : connect;
    }

    private final ReusePlan planReuseCallConnection() {
        Socket toClose;
        RealConnection candidate = this.call.getConnection();
        if (candidate == null) {
            return null;
        }
        boolean healthy = candidate.isHealthy(this.doExtensiveHealthChecks);
        boolean noNewExchangesEvent = false;
        RealConnection $this$withLock$iv = candidate;
        synchronized ($this$withLock$iv) {
            try {
                if (!healthy) {
                    noNewExchangesEvent = !candidate.getNoNewExchanges();
                    candidate.setNoNewExchanges(true);
                    toClose = this.call.releaseConnectionNoEvents$okhttp();
                } else if (candidate.getNoNewExchanges() || !sameHostAndPort(candidate.route().address().url())) {
                    toClose = this.call.releaseConnectionNoEvents$okhttp();
                } else {
                    toClose = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.call.getConnection() != null) {
            if (!(toClose == null)) {
                throw new IllegalStateException("Check failed.");
            }
            return new ReusePlan(candidate);
        }
        if (toClose != null) {
            _UtilJvmKt.closeQuietly(toClose);
        }
        this.call.getEventListener$okhttp().connectionReleased(this.call, candidate);
        candidate.getConnectionListener$okhttp().connectionReleased(candidate, this.call);
        if (toClose != null) {
            candidate.getConnectionListener$okhttp().connectionClosed(candidate);
        } else if (noNewExchangesEvent) {
            candidate.getConnectionListener$okhttp().noNewExchanges(candidate);
        }
        return null;
    }

    public final ConnectPlan planConnect$okhttp() throws IOException {
        Route localNextRouteToTry = this.nextRouteToTry;
        if (localNextRouteToTry != null) {
            this.nextRouteToTry = null;
            return planConnectToRoute$okhttp$default(this, localNextRouteToTry, null, 2, null);
        }
        RouteSelector.Selection existingRouteSelection = this.routeSelection;
        if (existingRouteSelection != null && existingRouteSelection.hasNext()) {
            return planConnectToRoute$okhttp$default(this, existingRouteSelection.next(), null, 2, null);
        }
        RouteSelector newRouteSelector = this.routeSelector;
        if (newRouteSelector == null) {
            newRouteSelector = new RouteSelector(getAddress(), this.routeDatabase, this.call, this.fastFallback);
            this.routeSelector = newRouteSelector;
        }
        if (!newRouteSelector.hasNext()) {
            throw new IOException("exhausted all routes");
        }
        RouteSelector.Selection newRouteSelection = newRouteSelector.next();
        this.routeSelection = newRouteSelection;
        if (isCanceled()) {
            throw new IOException("Canceled");
        }
        return planConnectToRoute$okhttp(newRouteSelection.next(), newRouteSelection.getRoutes());
    }

    public static  ReusePlan planReusePooledConnection$okhttp$default(RealRoutePlanner realRoutePlanner, ConnectPlan connectPlan, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            connectPlan = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planReusePooledConnection$okhttp(connectPlan, list);
    }

    public final ReusePlan planReusePooledConnection$okhttp(ConnectPlan planToReplace, List<Route> list) {
        RealConnection result = this.connectionPool.callAcquirePooledConnection$okhttp(this.doExtensiveHealthChecks, getAddress(), this.call, list, planToReplace != null && planToReplace.isReady());
        if (result == null) {
            return null;
        }
        if (planToReplace != null) {
            this.nextRouteToTry = planToReplace.getRoute();
            planToReplace.closeQuietly();
        }
        this.call.getEventListener$okhttp().connectionAcquired(this.call, result);
        result.getConnectionListener$okhttp().connectionAcquired(result, this.call);
        return new ReusePlan(result);
    }

    public static  ConnectPlan planConnectToRoute$okhttp$default(RealRoutePlanner realRoutePlanner, Route route, List list, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planConnectToRoute$okhttp(route, list);
    }

    public final ConnectPlan planConnectToRoute$okhttp(Route route, List<Route> list) throws IOException {
        Intrinsics.checkNotNullParameter(route, "route");
        if (route.address().sslSocketFactory() == null) {
            if (!route.address().connectionSpecs().contains(ConnectionSpec.CLEARTEXT)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String host = route.address().url().host();
            if (!Platform.Companion.get().isCleartextTrafficPermitted(host)) {
                throw new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy");
            }
        } else if (route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        Request tunnelRequest = route.requiresTunnel() ? createTunnelRequest(route) : null;
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this, route, list, 0, tunnelRequest, -1, false);
    }

    private final Request createTunnelRequest(Route route) throws IOException {
        Request proxyConnectRequest = new Request.Builder().url(route.address().url()).method("CONNECT", null).header("Host", _UtilJvmKt.toHostHeader(route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", _UtilCommonKt.USER_AGENT).build();
        Response fakeAuthChallengeResponse = new Response.Builder().request(proxyConnectRequest).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
        Request authenticatedRequest = route.address().proxyAuthenticator().authenticate(route, fakeAuthChallengeResponse);
        return authenticatedRequest == null ? proxyConnectRequest : authenticatedRequest;
    }

    @Override
    public boolean hasNext(RealConnection failedConnection) {
        RouteSelector localRouteSelector;
        Route retryRoute;
        if (!getDeferredPlans().isEmpty() || this.nextRouteToTry != null) {
            return true;
        }
        if (failedConnection != null && (retryRoute = retryRoute(failedConnection)) != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        boolean z = false;
        if (selection != null && selection.hasNext()) {
            z = true;
        }
        if (z || (localRouteSelector = this.routeSelector) == null) {
            return true;
        }
        return localRouteSelector.hasNext();
    }

    private final Route retryRoute(RealConnection connection) {
        Route route;
        RealConnection $this$withLock$iv = connection;
        synchronized ($this$withLock$iv) {
            route = null;
            if (connection.getRouteFailureCount$okhttp() == 0 && connection.getNoNewExchanges() && _UtilJvmKt.canReuseConnectionFor(connection.route().address().url(), getAddress().url())) {
                route = connection.route();
            }
        }
        return route;
    }

    @Override
    public boolean sameHostAndPort(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl routeUrl = getAddress().url();
        return url.port() == routeUrl.port() && Intrinsics.areEqual(url.host(), routeUrl.host());
    }
}
