package ni.shikatu.okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.Internal;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002&'B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0007¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0017J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001bJ\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006("}, d2 = {"Lni/shikatu/okhttp3/ConnectionSpec;", _UrlKt.FRAGMENT_ENCODE_SET, "isTls", _UrlKt.FRAGMENT_ENCODE_SET, "supportsTlsExtensions", "cipherSuitesAsString", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "tlsVersionsAsString", "<init>", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "()Z", "getCipherSuitesAsString$okhttp", "()[Ljava/lang/String;", "[Ljava/lang/String;", "cipherSuites", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/CipherSuite;", "()Ljava/util/List;", "-deprecated_cipherSuites", "tlsVersions", "Lni/shikatu/okhttp3/TlsVersion;", "-deprecated_tlsVersions", "-deprecated_supportsTlsExtensions", "apply", _UrlKt.FRAGMENT_ENCODE_SET, "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "apply$okhttp", "supportedSpec", "isCompatible", "socket", "equals", "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    public static final ConnectionSpec RESTRICTED_TLS;
    private final String[] cipherSuitesAsString;
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    private final String[] tlsVersionsAsString;
    public static final Companion Companion = new Companion(null);
    private static final List<CipherSuite> RESTRICTED_CIPHER_SUITES = CollectionsKt.listOf((Object[]) new CipherSuite[]{CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256});
    private static final List<CipherSuite> APPROVED_CIPHER_SUITES = CollectionsKt.listOf((Object[]) new CipherSuite[]{CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA});

    public ConnectionSpec(boolean isTls, boolean supportsTlsExtensions, String[] cipherSuitesAsString, String[] tlsVersionsAsString) {
        this.isTls = isTls;
        this.supportsTlsExtensions = supportsTlsExtensions;
        this.cipherSuitesAsString = cipherSuitesAsString;
        this.tlsVersionsAsString = tlsVersionsAsString;
    }

    public final boolean isTls() {
        return this.isTls;
    }

    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final String[] getCipherSuitesAsString$okhttp() {
        return this.cipherSuitesAsString;
    }

    public final List<CipherSuite> cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr == null) {
            return null;
        }
        Collection destination$iv$iv = new ArrayList(strArr.length);
        for (String str : strArr) {
            destination$iv$iv.add(CipherSuite.Companion.forJavaName(str));
        }
        return (List) destination$iv$iv;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuites", imports = {}))

    public final List<CipherSuite> m1620deprecated_cipherSuites() {
        return cipherSuites();
    }

    public final List<TlsVersion> tlsVersions() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr == null) {
            return null;
        }
        Collection destination$iv$iv = new ArrayList(strArr.length);
        for (String str : strArr) {
            destination$iv$iv.add(TlsVersion.Companion.forJavaName(str));
        }
        return (List) destination$iv$iv;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersions", imports = {}))

    public final List<TlsVersion> m1622deprecated_tlsVersions() {
        return tlsVersions();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "supportsTlsExtensions", imports = {}))

    public final boolean m1621deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final void apply$okhttp(SSLSocket sslSocket, boolean isFallback) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        ConnectionSpec specToApply = supportedSpec(sslSocket, isFallback);
        if (specToApply.tlsVersions() != null) {
            sslSocket.setEnabledProtocols(specToApply.tlsVersionsAsString);
        }
        if (specToApply.cipherSuites() != null) {
            sslSocket.setEnabledCipherSuites(specToApply.cipherSuitesAsString);
        }
    }

    private final ConnectionSpec supportedSpec(SSLSocket sslSocket, boolean isFallback) {
        String[] tlsVersionsIntersection;
        String[] socketEnabledCipherSuites = sslSocket.getEnabledCipherSuites();
        Intrinsics.checkNotNull(socketEnabledCipherSuites);
        String[] cipherSuitesIntersection = Internal.effectiveCipherSuites(this, socketEnabledCipherSuites);
        if (this.tlsVersionsAsString != null) {
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "getEnabledProtocols(...)");
            tlsVersionsIntersection = _UtilCommonKt.intersect(enabledProtocols, this.tlsVersionsAsString, ComparisonsKt.naturalOrder());
        } else {
            tlsVersionsIntersection = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNull(supportedCipherSuites);
        int indexOfFallbackScsv = _UtilCommonKt.indexOf(supportedCipherSuites, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        if (isFallback && indexOfFallbackScsv != -1) {
            String str = supportedCipherSuites[indexOfFallbackScsv];
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            cipherSuitesIntersection = _UtilCommonKt.concat(cipherSuitesIntersection, str);
        }
        return new Builder(this).cipherSuites((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length)).tlsVersions((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).build();
    }

    public final boolean isCompatible(SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.isTls) {
            return false;
        }
        if (this.tlsVersionsAsString == null || _UtilCommonKt.hasIntersection(this.tlsVersionsAsString, socket.getEnabledProtocols(), ComparisonsKt.naturalOrder())) {
            return this.cipherSuitesAsString == null || _UtilCommonKt.hasIntersection(this.cipherSuitesAsString, socket.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        }
        return false;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ConnectionSpec)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (this.isTls != ((ConnectionSpec) other).isTls) {
            return false;
        }
        return !this.isTls || (Arrays.equals(this.cipherSuitesAsString, ((ConnectionSpec) other).cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, ((ConnectionSpec) other).tlsVersionsAsString) && this.supportsTlsExtensions == ((ConnectionSpec) other).supportsTlsExtensions);
    }

    public int hashCode() {
        if (!this.isTls) {
            return 17;
        }
        int i = 17 * 31;
        String[] strArr = this.cipherSuitesAsString;
        int iHashCode = (i + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.tlsVersionsAsString;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    }

    public String toString() {
        return !this.isTls ? "ConnectionSpec()" : "ConnectionSpec(cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u0000J\u001f\u0010\f\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\r\"\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u001f\u0010\f\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0000J\u001f\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\r\"\u00020\u001f¢\u0006\u0002\u0010 J\u001f\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\u0007J\u0006\u0010!\u001a\u00020\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\u0005¨\u0006\""}, d2 = {"Lni/shikatu/okhttp3/ConnectionSpec$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "tls", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Z)V", "connectionSpec", "Lni/shikatu/okhttp3/ConnectionSpec;", "(Lokhttp3/ConnectionSpec;)V", "getTls$okhttp", "()Z", "setTls$okhttp", "cipherSuites", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "tlsVersions", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "supportsTlsExtensions", "getSupportsTlsExtensions$okhttp", "setSupportsTlsExtensions$okhttp", "allEnabledCipherSuites", "Lni/shikatu/okhttp3/CipherSuite;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "allEnabledTlsVersions", "Lni/shikatu/okhttp3/TlsVersion;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "build", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String[] tlsVersions;

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        public final void setTls$okhttp(boolean z) {
            this.tls = z;
        }

        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final void setCipherSuites$okhttp(String[] strArr) {
            this.cipherSuites = strArr;
        }

        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setTlsVersions$okhttp(String[] strArr) {
            this.tlsVersions = strArr;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean z) {
            this.supportsTlsExtensions = z;
        }

        public Builder(boolean tls) {
            this.tls = tls;
        }

        public Builder(ConnectionSpec connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.isTls();
            this.cipherSuites = connectionSpec.getCipherSuitesAsString$okhttp();
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
        }

        public final Builder allEnabledCipherSuites() {
            Builder $this$allEnabledCipherSuites_u24lambda_u240 = this;
            if (!$this$allEnabledCipherSuites_u24lambda_u240.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            $this$allEnabledCipherSuites_u24lambda_u240.cipherSuites = null;
            return this;
        }

        public final Builder cipherSuites(CipherSuite... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            Builder $this$cipherSuites_u24lambda_u240 = this;
            if (!$this$cipherSuites_u24lambda_u240.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            Collection destination$iv$iv = new ArrayList(cipherSuites.length);
            for (CipherSuite cipherSuite : cipherSuites) {
                destination$iv$iv.add(cipherSuite.javaName());
            }
            Collection $this$toTypedArray$iv = (List) destination$iv$iv;
            String[] strings = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            return $this$cipherSuites_u24lambda_u240.cipherSuites((String[]) Arrays.copyOf(strings, strings.length));
        }

        public final Builder cipherSuites(String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            Builder $this$cipherSuites_u24lambda_u241 = this;
            if (!$this$cipherSuites_u24lambda_u241.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (cipherSuites.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object[] objArrCopyOf = Arrays.copyOf(cipherSuites, cipherSuites.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            $this$cipherSuites_u24lambda_u241.cipherSuites = (String[]) objArrCopyOf;
            return this;
        }

        public final Builder allEnabledTlsVersions() {
            Builder $this$allEnabledTlsVersions_u24lambda_u240 = this;
            if (!$this$allEnabledTlsVersions_u24lambda_u240.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            $this$allEnabledTlsVersions_u24lambda_u240.tlsVersions = null;
            return this;
        }

        public final Builder tlsVersions(TlsVersion... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            Builder $this$tlsVersions_u24lambda_u240 = this;
            if (!$this$tlsVersions_u24lambda_u240.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            Collection destination$iv$iv = new ArrayList(tlsVersions.length);
            for (TlsVersion tlsVersion : tlsVersions) {
                destination$iv$iv.add(tlsVersion.javaName());
            }
            Collection $this$toTypedArray$iv = (List) destination$iv$iv;
            String[] strings = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            return $this$tlsVersions_u24lambda_u240.tlsVersions((String[]) Arrays.copyOf(strings, strings.length));
        }

        public final Builder tlsVersions(String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            Builder $this$tlsVersions_u24lambda_u241 = this;
            if (!$this$tlsVersions_u24lambda_u241.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (tlsVersions.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object[] objArrCopyOf = Arrays.copyOf(tlsVersions, tlsVersions.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            $this$tlsVersions_u24lambda_u241.tlsVersions = (String[]) objArrCopyOf;
            return this;
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        public final Builder supportsTlsExtensions(boolean supportsTlsExtensions) {
            Builder $this$supportsTlsExtensions_u24lambda_u240 = this;
            if (!$this$supportsTlsExtensions_u24lambda_u240.tls) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            $this$supportsTlsExtensions_u24lambda_u240.supportsTlsExtensions = supportsTlsExtensions;
            return this;
        }

        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lni/shikatu/okhttp3/ConnectionSpec$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "RESTRICTED_CIPHER_SUITES", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/CipherSuite;", "APPROVED_CIPHER_SUITES", "RESTRICTED_TLS", "Lni/shikatu/okhttp3/ConnectionSpec;", "MODERN_TLS", "COMPATIBLE_TLS", "CLEARTEXT", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Builder builder = new Builder(true);
        Collection $this$toTypedArray$iv = RESTRICTED_CIPHER_SUITES;
        CipherSuite[] cipherSuiteArr = (CipherSuite[]) $this$toTypedArray$iv.toArray(new CipherSuite[0]);
        RESTRICTED_TLS = builder.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
        Builder builder2 = new Builder(true);
        Collection $this$toTypedArray$iv2 = APPROVED_CIPHER_SUITES;
        CipherSuite[] cipherSuiteArr2 = (CipherSuite[]) $this$toTypedArray$iv2.toArray(new CipherSuite[0]);
        MODERN_TLS = builder2.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
        Builder builder3 = new Builder(true);
        Collection $this$toTypedArray$iv3 = APPROVED_CIPHER_SUITES;
        CipherSuite[] cipherSuiteArr3 = (CipherSuite[]) $this$toTypedArray$iv3.toArray(new CipherSuite[0]);
        COMPATIBLE_TLS = builder3.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr3, cipherSuiteArr3.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }
}
