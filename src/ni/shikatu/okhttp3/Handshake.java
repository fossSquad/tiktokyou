package ni.shikatu.okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B;\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0013J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\b\u0019J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\u001aJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\b\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00178G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010$\u001a\u00020#*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lni/shikatu/okhttp3/Handshake;", _UrlKt.FRAGMENT_ENCODE_SET, "tlsVersion", "Lni/shikatu/okhttp3/TlsVersion;", "cipherSuite", "Lni/shikatu/okhttp3/CipherSuite;", "localCertificates", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/security/cert/Certificate;", "peerCertificatesFn", "Lni/shikatu/kotlin/Function0;", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "()Lokhttp3/TlsVersion;", "()Lokhttp3/CipherSuite;", "()Ljava/util/List;", "peerCertificates", "peerCertificates$delegate", "Lni/shikatu/kotlin/Lazy;", "-deprecated_tlsVersion", "-deprecated_cipherSuite", "-deprecated_peerCertificates", "peerPrincipal", "Ljava/security/Principal;", "()Ljava/security/Principal;", "-deprecated_peerPrincipal", "-deprecated_localCertificates", "localPrincipal", "-deprecated_localPrincipal", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "name", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Handshake {
    public static final Companion Companion = new Companion(null);
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final Lazy peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, final Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(list, "localCertificates");
        Intrinsics.checkNotNullParameter(function0, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = LazyKt.lazy(new Function0() {
            @Override
            public final Object invoke() {
                return Handshake.peerCertificates_delegate$lambda$0(function0);
            }
        });
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public static final List peerCertificates_delegate$lambda$0(Function0 $peerCertificatesFn) {
        try {
            return (List) $peerCertificatesFn.invoke();
        } catch (SSLPeerUnverifiedException e) {
            return CollectionsKt.emptyList();
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersion", imports = {}))

    public final TlsVersion m1639deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuite", imports = {}))

    public final CipherSuite m1634deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerCertificates", imports = {}))

    public final List<Certificate> m1637deprecated_peerCertificates() {
        return peerCertificates();
    }

    public final Principal peerPrincipal() {
        Object objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) peerCertificates());
        X509Certificate x509Certificate = objFirstOrNull instanceof X509Certificate ? (X509Certificate) objFirstOrNull : null;
        return x509Certificate != null ? x509Certificate.getSubjectX500Principal() : null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerPrincipal", imports = {}))

    public final Principal m1638deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localCertificates", imports = {}))

    public final List<Certificate> m1635deprecated_localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) this.localCertificates);
        X509Certificate x509Certificate = objFirstOrNull instanceof X509Certificate ? (X509Certificate) objFirstOrNull : null;
        return x509Certificate != null ? x509Certificate.getSubjectX500Principal() : null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localPrincipal", imports = {}))

    public final Principal m1636deprecated_localPrincipal() {
        return localPrincipal();
    }

    public boolean equals(Object other) {
        return (other instanceof Handshake) && ((Handshake) other).tlsVersion == this.tlsVersion && Intrinsics.areEqual(((Handshake) other).cipherSuite, this.cipherSuite) && Intrinsics.areEqual(((Handshake) other).peerCertificates(), peerCertificates()) && Intrinsics.areEqual(((Handshake) other).localCertificates, this.localCertificates);
    }

    public int hashCode() {
        int result = (17 * 31) + this.tlsVersion.hashCode();
        return (((((result * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    public String toString() {
        Iterable $this$map$iv = peerCertificates();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Certificate it = (Certificate) item$iv$iv;
            destination$iv$iv.add(getName(it));
        }
        String peerCertificatesString = ((List) destination$iv$iv).toString();
        StringBuilder sbAppend = new StringBuilder().append("Handshake{tlsVersion=").append(this.tlsVersion).append(" cipherSuite=").append(this.cipherSuite).append(" peerCertificates=").append(peerCertificatesString).append(" localCertificates=");
        Iterable $this$map$iv2 = this.localCertificates;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Certificate it2 = (Certificate) item$iv$iv2;
            destination$iv$iv2.add(getName(it2));
        }
        return sbAppend.append((List) destination$iv$iv2).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    private final String getName(Certificate $this$name) {
        if ($this$name instanceof X509Certificate) {
            return ((X509Certificate) $this$name).getSubjectDN().toString();
        }
        String type = $this$name.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0007¢\u0006\u0002\b\u0007J\u0015\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\tJ4\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/Handshake$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "handshake", "Lni/shikatu/okhttp3/Handshake;", "Ljavax/net/ssl/SSLSession;", "get", "sslSession", "-deprecated_get", "tlsVersion", "Lni/shikatu/okhttp3/TlsVersion;", "cipherSuite", "Lni/shikatu/okhttp3/CipherSuite;", "peerCertificates", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/security/cert/Certificate;", "localCertificates", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Handshake get(SSLSession $this$handshake) throws IOException {
            final List peerCertificatesCopy;
            Intrinsics.checkNotNullParameter($this$handshake, "<this>");
            String cipherSuiteString = $this$handshake.getCipherSuite();
            if (cipherSuiteString == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (Intrinsics.areEqual(cipherSuiteString, "TLS_NULL_WITH_NULL_NULL") || Intrinsics.areEqual(cipherSuiteString, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuiteString);
            }
            CipherSuite cipherSuite = CipherSuite.Companion.forJavaName(cipherSuiteString);
            String tlsVersionString = $this$handshake.getProtocol();
            if (tlsVersionString == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (Intrinsics.areEqual("NONE", tlsVersionString)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersion = TlsVersion.Companion.forJavaName(tlsVersionString);
            try {
                peerCertificatesCopy = _UtilJvmKt.toImmutableList($this$handshake.getPeerCertificates());
            } catch (SSLPeerUnverifiedException e) {
                peerCertificatesCopy = CollectionsKt.emptyList();
            }
            return new Handshake(tlsVersion, cipherSuite, _UtilJvmKt.toImmutableList($this$handshake.getLocalCertificates()), new Function0() {
                @Override
                public final Object invoke() {
                    return Handshake.Companion.handshake$lambda$2(peerCertificatesCopy);
                }
            });
        }

        public static final List handshake$lambda$2(List $peerCertificatesCopy) {
            return $peerCertificatesCopy;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sslSession.handshake()", imports = {}))

        public final Handshake m1641deprecated_get(SSLSession sslSession) throws IOException {
            Intrinsics.checkNotNullParameter(sslSession, "sslSession");
            return get(sslSession);
        }

        @JvmStatic
        public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
            Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
            Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
            Intrinsics.checkNotNullParameter(list, "peerCertificates");
            Intrinsics.checkNotNullParameter(list2, "localCertificates");
            final List peerCertificatesCopy = _UtilJvmKt.toImmutableList(list);
            return new Handshake(tlsVersion, cipherSuite, _UtilJvmKt.toImmutableList(list2), new Function0() {
                @Override
                public final Object invoke() {
                    return Handshake.Companion.get$lambda$0(peerCertificatesCopy);
                }
            });
        }

        public static final List get$lambda$0(List $peerCertificatesCopy) {
            return $peerCertificatesCopy;
        }
    }

    @JvmStatic
    public static final Handshake get(SSLSession $this$get) throws IOException {
        return Companion.get($this$get);
    }

    @JvmStatic
    public static final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }
}
