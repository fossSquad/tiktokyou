package ni.shikatu.okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\b)J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b*J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b+J\r\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\b,J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0007¢\u0006\u0002\b-J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\u0007¢\u0006\u0002\b.J\r\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\b/J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\b0J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\b1J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\b2J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b3J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00107\u001a\u00020\u0005H\u0016J\u0015\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u0000H\u0000¢\u0006\u0002\b:J\b\u0010;\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001dR\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001fR\u0015\u0010\f\u001a\u0004\u0018\u00010\r8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010!R\u0013\u0010\u0010\u001a\u00020\u00118\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\"R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010#R\u0013\u0010\u0019\u001a\u00020\u001a8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010$R\u0013\u0010%\u001a\u00020&8\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010'R\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010(R\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00158\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010(¨\u0006<"}, d2 = {"Lni/shikatu/okhttp3/Address;", _UrlKt.FRAGMENT_ENCODE_SET, "uriHost", _UrlKt.FRAGMENT_ENCODE_SET, "uriPort", _UrlKt.FRAGMENT_ENCODE_SET, "dns", "Lni/shikatu/okhttp3/Dns;", "socketFactory", "Ljavax/net/SocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "certificatePinner", "Lni/shikatu/okhttp3/CertificatePinner;", "proxyAuthenticator", "Lni/shikatu/okhttp3/Authenticator;", "proxy", "Ljava/net/Proxy;", "protocols", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Protocol;", "connectionSpecs", "Lni/shikatu/okhttp3/ConnectionSpec;", "proxySelector", "Ljava/net/ProxySelector;", "<init>", "(Ljava/lang/String;ILokhttp3/Dns;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/Authenticator;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "()Lokhttp3/Dns;", "()Ljavax/net/SocketFactory;", "()Ljavax/net/ssl/SSLSocketFactory;", "()Ljavax/net/ssl/HostnameVerifier;", "()Lokhttp3/CertificatePinner;", "()Lokhttp3/Authenticator;", "()Ljava/net/Proxy;", "()Ljava/net/ProxySelector;", "url", "Lni/shikatu/okhttp3/HttpUrl;", "()Lokhttp3/HttpUrl;", "()Ljava/util/List;", "-deprecated_url", "-deprecated_dns", "-deprecated_socketFactory", "-deprecated_proxyAuthenticator", "-deprecated_protocols", "-deprecated_connectionSpecs", "-deprecated_proxySelector", "-deprecated_proxy", "-deprecated_sslSocketFactory", "-deprecated_hostnameVerifier", "-deprecated_certificatePinner", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "hashCode", "equalsNonHost", "that", "equalsNonHost$okhttp", "toString", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Address {
    private final CertificatePinner certificatePinner;
    private final List<ConnectionSpec> connectionSpecs;
    private final Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final HttpUrl url;

    public Address(String uriHost, int uriPort, Dns dns, SocketFactory socketFactory, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator proxyAuthenticator, Proxy proxy, List<? extends Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter(uriHost, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(list, "protocols");
        Intrinsics.checkNotNullParameter(list2, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sslSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(this.sslSocketFactory != null ? "https" : "http").host(uriHost).port(uriPort).build();
        this.protocols = _UtilJvmKt.toImmutableList(list);
        this.connectionSpecs = _UtilJvmKt.toImmutableList(list2);
    }

    public final Dns dns() {
        return this.dns;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))

    public final HttpUrl m1600deprecated_url() {
        return this.url;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dns", imports = {}))

    public final Dns m1592deprecated_dns() {
        return this.dns;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketFactory", imports = {}))

    public final SocketFactory m1598deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxyAuthenticator", imports = {}))

    public final Authenticator m1596deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocols", imports = {}))

    public final List<Protocol> m1594deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionSpecs", imports = {}))

    public final List<ConnectionSpec> m1591deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxySelector", imports = {}))

    public final ProxySelector m1597deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))

    public final Proxy m1595deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sslSocketFactory", imports = {}))

    public final SSLSocketFactory m1599deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostnameVerifier", imports = {}))

    public final HostnameVerifier m1593deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "certificatePinner", imports = {}))

    public final CertificatePinner m1590deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    public boolean equals(Object other) {
        return (other instanceof Address) && Intrinsics.areEqual(this.url, ((Address) other).url) && equalsNonHost$okhttp((Address) other);
    }

    public int hashCode() {
        int result = (17 * 31) + this.url.hashCode();
        return (((((((((((((((((result * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    public final boolean equalsNonHost$okhttp(Address that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return Intrinsics.areEqual(this.dns, that.dns) && Intrinsics.areEqual(this.proxyAuthenticator, that.proxyAuthenticator) && Intrinsics.areEqual(this.protocols, that.protocols) && Intrinsics.areEqual(this.connectionSpecs, that.connectionSpecs) && Intrinsics.areEqual(this.proxySelector, that.proxySelector) && Intrinsics.areEqual(this.proxy, that.proxy) && Intrinsics.areEqual(this.sslSocketFactory, that.sslSocketFactory) && Intrinsics.areEqual(this.hostnameVerifier, that.hostnameVerifier) && Intrinsics.areEqual(this.certificatePinner, that.certificatePinner) && this.url.port() == that.url.port();
    }

    public String toString() {
        StringBuilder sbAppend;
        Object obj;
        StringBuilder sbAppend2 = new StringBuilder().append("Address{").append(this.url.host()).append(AbstractJsonLexerKt.COLON).append(this.url.port()).append(", ");
        if (this.proxy != null) {
            sbAppend = new StringBuilder().append("proxy=");
            obj = this.proxy;
        } else {
            sbAppend = new StringBuilder().append("proxySelector=");
            obj = this.proxySelector;
        }
        return sbAppend2.append(sbAppend.append(obj).toString()).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
