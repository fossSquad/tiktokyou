package ni.shikatu.okhttp3;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal._HostnamesCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\rJ\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u000eJ\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\f¨\u0006\u0018"}, d2 = {"Lni/shikatu/okhttp3/Route;", _UrlKt.FRAGMENT_ENCODE_SET, "address", "Lni/shikatu/okhttp3/Address;", "proxy", "Ljava/net/Proxy;", "socketAddress", "Ljava/net/InetSocketAddress;", "<init>", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "()Lokhttp3/Address;", "()Ljava/net/Proxy;", "()Ljava/net/InetSocketAddress;", "-deprecated_address", "-deprecated_proxy", "-deprecated_socketAddress", "requiresTunnel", _UrlKt.FRAGMENT_ENCODE_SET, "equals", "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Route {
    private final Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    public final Address address() {
        return this.address;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "address", imports = {}))

    public final Address m1730deprecated_address() {
        return this.address;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))

    public final Proxy m1731deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketAddress", imports = {}))

    public final InetSocketAddress m1732deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final boolean requiresTunnel() {
        if (this.proxy.type() != Proxy.Type.HTTP) {
            return false;
        }
        return this.address.sslSocketFactory() != null || this.address.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE);
    }

    public boolean equals(Object other) {
        return (other instanceof Route) && Intrinsics.areEqual(((Route) other).address, this.address) && Intrinsics.areEqual(((Route) other).proxy, this.proxy) && Intrinsics.areEqual(((Route) other).socketAddress, this.socketAddress);
    }

    public int hashCode() {
        int result = (17 * 31) + this.address.hashCode();
        return (((result * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    public String toString() {
        String hostAddress;
        StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
        String addressHostname = this.address.url().host();
        InetAddress address = this.socketAddress.getAddress();
        String socketHostname = (address == null || (hostAddress = address.getHostAddress()) == null) ? null : _HostnamesCommonKt.toCanonicalHost(hostAddress);
        if (StringsKt.contains$default((CharSequence) addressHostname, AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
            $this$toString_u24lambda_u240.append("[").append(addressHostname).append("]");
        } else {
            $this$toString_u24lambda_u240.append(addressHostname);
        }
        if (this.address.url().port() != this.socketAddress.getPort() || Intrinsics.areEqual(addressHostname, socketHostname)) {
            $this$toString_u24lambda_u240.append(":");
            $this$toString_u24lambda_u240.append(this.address.url().port());
        }
        if (!Intrinsics.areEqual(addressHostname, socketHostname)) {
            if (Intrinsics.areEqual(this.proxy, Proxy.NO_PROXY)) {
                $this$toString_u24lambda_u240.append(" at ");
            } else {
                $this$toString_u24lambda_u240.append(" via proxy ");
            }
            if (socketHostname == null) {
                $this$toString_u24lambda_u240.append("<unresolved>");
            } else if (StringsKt.contains$default((CharSequence) socketHostname, AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
                $this$toString_u24lambda_u240.append("[").append(socketHostname).append("]");
            } else {
                $this$toString_u24lambda_u240.append(socketHostname);
            }
            $this$toString_u24lambda_u240.append(":");
            $this$toString_u24lambda_u240.append(this.socketAddress.getPort());
        }
        return $this$toString_u24lambda_u240.toString();
    }
}
