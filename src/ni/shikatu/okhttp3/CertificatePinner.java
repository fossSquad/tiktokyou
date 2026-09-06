package ni.shikatu.okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.TypeIntrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal._HostnamesCommonKt;
import ni.shikatu.okhttp3.internal.tls.CertificateChainCleaner;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0003\"#$B#\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00120\u0015H\u0000¢\u0006\u0002\b\u0017J)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0018\"\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006%"}, d2 = {"Lni/shikatu/okhttp3/CertificatePinner;", _UrlKt.FRAGMENT_ENCODE_SET, "pins", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lni/shikatu/okhttp3/internal/tls/CertificateChainCleaner;", "<init>", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getPins", "()Ljava/util/Set;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "check", _UrlKt.FRAGMENT_ENCODE_SET, "hostname", _UrlKt.FRAGMENT_ENCODE_SET, "peerCertificates", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/security/cert/Certificate;", "cleanedPeerCertificatesFn", "Lni/shikatu/kotlin/Function0;", "Ljava/security/cert/X509Certificate;", "check$okhttp", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "findMatchingPins", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "Pin", "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public  CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i & 2) != 0 ? null : certificateChainCleaner);
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final void check(final String hostname, final List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(list, "peerCertificates");
        check$okhttp(hostname, new Function0() {
            @Override
            public final Object invoke() {
                return CertificatePinner.check$lambda$0(this.f$0, list, hostname);
            }
        });
    }

    public static final List check$lambda$0(CertificatePinner this$0, List $peerCertificates, String $hostname) {
        Iterable iterableClean;
        CertificateChainCleaner certificateChainCleaner = this$0.certificateChainCleaner;
        if (certificateChainCleaner == null || (iterableClean = certificateChainCleaner.clean($peerCertificates, $hostname)) == null) {
            iterableClean = $peerCertificates;
        }
        Iterable $this$map$iv = iterableClean;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Certificate it = (Certificate) item$iv$iv;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            destination$iv$iv.add((X509Certificate) it);
        }
        return (List) destination$iv$iv;
    }

    public final void check$okhttp(String hostname, Function0<? extends List<? extends X509Certificate>> function0) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(function0, "cleanedPeerCertificatesFn");
        List<Pin> listFindMatchingPins = findMatchingPins(hostname);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = function0.invoke();
        for (X509Certificate peerCertificate : listInvoke) {
            ByteString sha1 = null;
            ByteString sha256 = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (Intrinsics.areEqual(hashAlgorithm, "sha256")) {
                    if (sha256 == null) {
                        sha256 = Companion.sha256Hash(peerCertificate);
                    }
                    if (Intrinsics.areEqual(pin.getHash(), sha256)) {
                        return;
                    }
                } else if (Intrinsics.areEqual(hashAlgorithm, "sha1")) {
                    if (sha1 == null) {
                        sha1 = Companion.sha1Hash(peerCertificate);
                    }
                    if (Intrinsics.areEqual(pin.getHash(), sha1)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                }
            }
        }
        StringBuilder $this$check_u24lambda_u241 = new StringBuilder();
        $this$check_u24lambda_u241.append("Certificate pinning failure!");
        $this$check_u24lambda_u241.append("\n  Peer certificate chain:");
        for (X509Certificate element : listInvoke) {
            $this$check_u24lambda_u241.append("\n    ");
            $this$check_u24lambda_u241.append(Companion.pin(element));
            $this$check_u24lambda_u241.append(": ");
            $this$check_u24lambda_u241.append(element.getSubjectDN().getName());
        }
        $this$check_u24lambda_u241.append("\n  Pinned certificates for ");
        $this$check_u24lambda_u241.append(hostname);
        $this$check_u24lambda_u241.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            $this$check_u24lambda_u241.append("\n    ");
            $this$check_u24lambda_u241.append(pin2);
        }
        String message = $this$check_u24lambda_u241.toString();
        throw new SSLPeerUnverifiedException(message);
    }

    @Deprecated(message = "replaced with {@link #check(String, List)}.", replaceWith = @ReplaceWith(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(String hostname, Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
        check(hostname, ArraysKt.toList(peerCertificates));
    }

    public final List<Pin> findMatchingPins(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Iterable $this$filterList$iv = this.pins;
        List listEmptyList = CollectionsKt.emptyList();
        for (Object i$iv : $this$filterList$iv) {
            Pin $this$findMatchingPins_u24lambda_u240 = (Pin) i$iv;
            if ($this$findMatchingPins_u24lambda_u240.matchesHostname(hostname)) {
                if (listEmptyList.isEmpty()) {
                    List result$iv = new ArrayList();
                    listEmptyList = result$iv;
                }
                Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal._UtilCommonKt.filterList>");
                TypeIntrinsics.asMutableList(listEmptyList).add(i$iv);
            }
        }
        return listEmptyList;
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
        if (Intrinsics.areEqual(this.certificateChainCleaner, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public boolean equals(Object other) {
        return (other instanceof CertificatePinner) && Intrinsics.areEqual(((CertificatePinner) other).pins, this.pins) && Intrinsics.areEqual(((CertificatePinner) other).certificateChainCleaner, this.certificateChainCleaner);
    }

    public int hashCode() {
        int result = (37 * 41) + this.pins.hashCode();
        int result2 = result * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return result2 + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0013\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lni/shikatu/okhttp3/CertificatePinner$Pin;", _UrlKt.FRAGMENT_ENCODE_SET, "pattern", _UrlKt.FRAGMENT_ENCODE_SET, "pin", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPattern", "()Ljava/lang/String;", "hashAlgorithm", "getHashAlgorithm", "hash", "Lni/shikatu/okio/ByteString;", "getHash", "()Lokio/ByteString;", "matchesHostname", _UrlKt.FRAGMENT_ENCODE_SET, "hostname", "matchesCertificate", "certificate", "Ljava/security/cert/X509Certificate;", "toString", "equals", "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String pattern, String pin) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(pin, "pin");
            if (!((StringsKt.startsWith$default(pattern, "*.", false, 2, (Object) null) && StringsKt.indexOf$default((CharSequence) pattern, "*", 1, false, 4, (Object) null) == -1) || (StringsKt.startsWith$default(pattern, "**.", false, 2, (Object) null) && StringsKt.indexOf$default((CharSequence) pattern, "*", 2, false, 4, (Object) null) == -1) || StringsKt.indexOf$default((CharSequence) pattern, "*", 0, false, 6, (Object) null) == -1)) {
                throw new IllegalArgumentException(("Unexpected pattern: " + pattern).toString());
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(pattern);
            if (canonicalHost != null) {
                this.pattern = canonicalHost;
                if (StringsKt.startsWith$default(pin, "sha1/", false, 2, (Object) null)) {
                    this.hashAlgorithm = "sha1";
                    ByteString.Companion companion = ByteString.Companion;
                    String strSubstring = pin.substring(5);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    ByteString byteStringDecodeBase64 = companion.decodeBase64(strSubstring);
                    if (byteStringDecodeBase64 == null) {
                        throw new IllegalArgumentException("Invalid pin hash: " + pin);
                    }
                    this.hash = byteStringDecodeBase64;
                    return;
                }
                if (StringsKt.startsWith$default(pin, "sha256/", false, 2, (Object) null)) {
                    this.hashAlgorithm = "sha256";
                    ByteString.Companion companion2 = ByteString.Companion;
                    String strSubstring2 = pin.substring(7);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    ByteString byteStringDecodeBase65 = companion2.decodeBase64(strSubstring2);
                    if (byteStringDecodeBase65 != null) {
                        this.hash = byteStringDecodeBase65;
                        return;
                    }
                    throw new IllegalArgumentException("Invalid pin hash: " + pin);
                }
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + pin);
            }
            throw new IllegalArgumentException("Invalid pattern: " + pattern);
        }

        public final String getPattern() {
            return this.pattern;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final boolean matchesHostname(String hostname) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            if (StringsKt.startsWith$default(this.pattern, "**.", false, 2, (Object) null)) {
                int suffixLength = this.pattern.length() - 3;
                int prefixLength = hostname.length() - suffixLength;
                if (StringsKt.regionMatches$default(hostname, hostname.length() - suffixLength, this.pattern, 3, suffixLength, false, 16, (Object) null)) {
                    return prefixLength == 0 || hostname.charAt(prefixLength + (-1)) == '.';
                }
                return false;
            }
            if (StringsKt.startsWith$default(this.pattern, "*.", false, 2, (Object) null)) {
                int suffixLength2 = this.pattern.length() - 1;
                return StringsKt.regionMatches$default(hostname, hostname.length() - suffixLength2, this.pattern, 1, suffixLength2, false, 16, (Object) null) && StringsKt.lastIndexOf$default((CharSequence) hostname, '.', (hostname.length() - suffixLength2) + (-1), false, 4, (Object) null) == -1;
            }
            return Intrinsics.areEqual(hostname, this.pattern);
        }

        public final boolean matchesCertificate(X509Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            String str = this.hashAlgorithm;
            if (Intrinsics.areEqual(str, "sha256")) {
                return Intrinsics.areEqual(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
            }
            if (Intrinsics.areEqual(str, "sha1")) {
                return Intrinsics.areEqual(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
            }
            return false;
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Pin) && Intrinsics.areEqual(this.pattern, ((Pin) other).pattern) && Intrinsics.areEqual(this.hashAlgorithm, ((Pin) other).hashAlgorithm) && Intrinsics.areEqual(this.hash, ((Pin) other).hash);
        }

        public int hashCode() {
            int result = this.pattern.hashCode();
            return (((result * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\f\"\u00020\u000b¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/CertificatePinner$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "pins", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", "add", "pattern", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lni/shikatu/okhttp3/CertificatePinner;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final List<Pin> getPins() {
            return this.pins;
        }

        public final Builder add(String pattern, String... pins) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(pins, "pins");
            Builder $this$add_u24lambda_u240 = this;
            for (String pin : pins) {
                $this$add_u24lambda_u240.pins.add(new Pin(pattern, pin));
            }
            return this;
        }

        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt.toSet(this.pins), null, 2, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0007J\f\u0010\t\u001a\u00020\u0007*\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/okhttp3/CertificatePinner$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "DEFAULT", "Lni/shikatu/okhttp3/CertificatePinner;", "sha1Hash", "Lni/shikatu/okio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "pin", _UrlKt.FRAGMENT_ENCODE_SET, "certificate", "Ljava/security/cert/Certificate;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ByteString sha1Hash(X509Certificate $this$sha1Hash) {
            Intrinsics.checkNotNullParameter($this$sha1Hash, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = $this$sha1Hash.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        public final ByteString sha256Hash(X509Certificate $this$sha256Hash) {
            Intrinsics.checkNotNullParameter($this$sha256Hash, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = $this$sha256Hash.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }

        @JvmStatic
        public final String pin(Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }
    }

    @JvmStatic
    public static final ByteString sha1Hash(X509Certificate $this$sha1Hash) {
        return Companion.sha1Hash($this$sha1Hash);
    }

    @JvmStatic
    public static final ByteString sha256Hash(X509Certificate $this$sha256Hash) {
        return Companion.sha256Hash($this$sha256Hash);
    }

    @JvmStatic
    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }
}
