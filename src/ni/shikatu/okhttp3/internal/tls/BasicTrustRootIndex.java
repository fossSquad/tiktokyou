package ni.shikatu.okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/okhttp3/internal/tls/BasicTrustRootIndex;", "Lni/shikatu/okhttp3/internal/tls/TrustRootIndex;", "caCerts", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/security/cert/X509Certificate;", "<init>", "([Ljava/security/cert/X509Certificate;)V", "subjectToCaCerts", _UrlKt.FRAGMENT_ENCODE_SET, "Ljavax/security/auth/x500/X500Principal;", _UrlKt.FRAGMENT_ENCODE_SET, "findByIssuerAndSignature", "cert", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BasicTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(X509Certificate... caCerts) {
        LinkedHashSet answer$iv;
        Intrinsics.checkNotNullParameter(caCerts, "caCerts");
        Map map = new LinkedHashMap();
        for (X509Certificate caCert : caCerts) {
            X500Principal subjectX500Principal = caCert.getSubjectX500Principal();
            Object value$iv = map.get(subjectX500Principal);
            if (value$iv == null) {
                answer$iv = new LinkedHashSet();
                map.put(subjectX500Principal, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            ((Set) answer$iv).add(caCert);
        }
        this.subjectToCaCerts = map;
    }

    @Override
    public X509Certificate findByIssuerAndSignature(X509Certificate cert) {
        boolean z;
        Intrinsics.checkNotNullParameter(cert, "cert");
        X500Principal issuer = cert.getIssuerX500Principal();
        Iterable iterable = (Set) this.subjectToCaCerts.get(issuer);
        Object obj = null;
        if (iterable == null) {
            return null;
        }
        Iterable $this$firstOrNull$iv = iterable;
        for (Object element$iv : $this$firstOrNull$iv) {
            X509Certificate it = (X509Certificate) element$iv;
            try {
                cert.verify(it.getPublicKey());
                z = true;
            } catch (Exception e) {
                z = false;
            }
            if (z) {
                obj = element$iv;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    public boolean equals(Object other) {
        return other == this || ((other instanceof BasicTrustRootIndex) && Intrinsics.areEqual(((BasicTrustRootIndex) other).subjectToCaCerts, this.subjectToCaCerts));
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
