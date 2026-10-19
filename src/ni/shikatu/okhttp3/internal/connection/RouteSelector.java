package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.Address;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.Route;
import ni.shikatu.okhttp3.internal._HostnamesCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002!\"B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\tH\u0086\u0002J\t\u0010\u0017\u001a\u00020\u0018H\u0086\u0002J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RouteSelector;", _UrlKt.FRAGMENT_ENCODE_SET, "address", "Lni/shikatu/okhttp3/Address;", "routeDatabase", "Lni/shikatu/okhttp3/internal/connection/RouteDatabase;", "call", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "fastFallback", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/internal/connection/RealCall;Z)V", "proxies", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/net/Proxy;", "nextProxyIndex", _UrlKt.FRAGMENT_ENCODE_SET, "inetSocketAddresses", "Ljava/net/InetSocketAddress;", "postponedRoutes", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Route;", "hasNext", "next", "Lni/shikatu/okhttp3/internal/connection/RouteSelector$Selection;", "resetNextProxy", _UrlKt.FRAGMENT_ENCODE_SET, "url", "Lni/shikatu/okhttp3/HttpUrl;", "proxy", "hasNextProxy", "nextProxy", "resetNextInetSocketAddress", "Selection", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RouteSelector {
    public static final Companion Companion = new Companion(null);
    private final Address address;
    private final RealCall call;
    private final boolean fastFallback;
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<? extends Proxy> proxies;
    private final RouteDatabase routeDatabase;

    public RouteSelector(Address address, RouteDatabase routeDatabase, RealCall call, boolean fastFallback) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.fastFallback = fastFallback;
        this.proxies = CollectionsKt.emptyList();
        this.inetSocketAddresses = CollectionsKt.emptyList();
        this.postponedRoutes = new ArrayList();
        resetNextProxy(this.address.url(), this.address.proxy());
    }

    public final boolean hasNext() {
        return hasNextProxy() || !this.postponedRoutes.isEmpty();
    }

    public final Selection next() throws IOException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        List routes = new ArrayList();
        while (hasNextProxy()) {
            Proxy proxy = nextProxy();
            for (InetSocketAddress inetSocketAddress : this.inetSocketAddresses) {
                Route route = new Route(this.address, proxy, inetSocketAddress);
                if (this.routeDatabase.shouldPostpone(route)) {
                    this.postponedRoutes.add(route);
                } else {
                    routes.add(route);
                }
            }
            if (!routes.isEmpty()) {
                break;
            }
        }
        if (routes.isEmpty()) {
            CollectionsKt.addAll(routes, this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new Selection(routes);
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy $proxy, HttpUrl $url, RouteSelector this$0) {
        if ($proxy != null) {
            return CollectionsKt.listOf($proxy);
        }
        URI uri = $url.uri();
        if (uri.getHost() == null) {
            return _UtilJvmKt.immutableListOf(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = this$0.address.proxySelector().select(uri);
        List<Proxy> list = listSelect;
        return list == null || list.isEmpty() ? _UtilJvmKt.immutableListOf(Proxy.NO_PROXY) : _UtilJvmKt.toImmutableList(listSelect);
    }

    private final void resetNextProxy(HttpUrl url, Proxy proxy) {
        this.call.getEventListener$okhttp().proxySelectStart(this.call, url);
        this.proxies = resetNextProxy$selectProxies(proxy, url, this);
        this.nextProxyIndex = 0;
        this.call.getEventListener$okhttp().proxySelectEnd(this.call, url, this.proxies);
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy nextProxy() throws IOException {
        if (!hasNextProxy()) {
            throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
        }
        List<? extends Proxy> list = this.proxies;
        int i = this.nextProxyIndex;
        this.nextProxyIndex = i + 1;
        Proxy result = list.get(i);
        resetNextInetSocketAddress(result);
        return result;
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String socketHost;
        int socketPort;
        List<InetAddress> listLookup;
        List mutableInetSocketAddresses = new ArrayList();
        this.inetSocketAddresses = mutableInetSocketAddresses;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            socketHost = this.address.url().host();
            socketPort = this.address.url().port();
        } else {
            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + proxyAddress.getClass()).toString());
            }
            socketHost = Companion.getSocketHost((InetSocketAddress) proxyAddress);
            socketPort = ((InetSocketAddress) proxyAddress).getPort();
        }
        boolean z = false;
        if (1 <= socketPort && socketPort < 65536) {
            z = true;
        }
        if (!z) {
            throw new SocketException("No route to " + socketHost + AbstractJsonLexerKt.COLON + socketPort + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            mutableInetSocketAddresses.add(InetSocketAddress.createUnresolved(socketHost, socketPort));
            return;
        }
        if (_HostnamesCommonKt.canParseAsIpAddress(socketHost)) {
            listLookup = CollectionsKt.listOf(InetAddress.getByName(socketHost));
        } else {
            this.call.getEventListener$okhttp().dnsStart(this.call, socketHost);
            listLookup = this.address.dns().lookup(socketHost);
            if (listLookup.isEmpty()) {
                throw new UnknownHostException(this.address.dns() + " returned no addresses for " + socketHost);
            }
            this.call.getEventListener$okhttp().dnsEnd(this.call, socketHost, listLookup);
        }
        for (InetAddress inetAddress : this.fastFallback ? InetAddressOrderKt.reorderForHappyEyeballs(listLookup) : listLookup) {
            mutableInetSocketAddresses.add(new InetSocketAddress(inetAddress, socketPort));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\fH\u0086\u0002J\t\u0010\r\u001a\u00020\u0004H\u0086\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RouteSelector$Selection;", _UrlKt.FRAGMENT_ENCODE_SET, "routes", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Route;", "<init>", "(Ljava/util/List;)V", "getRoutes", "()Ljava/util/List;", "nextRouteIndex", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Selection {
        private int nextRouteIndex;
        private final List<Route> routes;

        public Selection(List<Route> list) {
            Intrinsics.checkNotNullParameter(list, "routes");
            this.routes = list;
        }

        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public final Route next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            List<Route> list = this.routes;
            int i = this.nextRouteIndex;
            this.nextRouteIndex = i + 1;
            return list.get(i);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/RouteSelector$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "socketHost", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/net/InetSocketAddress;", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getSocketHost(InetSocketAddress $this$socketHost) {
            Intrinsics.checkNotNullParameter($this$socketHost, "<this>");
            InetAddress address = $this$socketHost.getAddress();
            if (address == null) {
                String hostName = $this$socketHost.getHostName();
                Intrinsics.checkNotNullExpressionValue(hostName, "getHostName(...)");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            Intrinsics.checkNotNullExpressionValue(hostAddress, "getHostAddress(...)");
            return hostAddress;
        }
    }
}
