package ni.shikatu.okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0013\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lni/shikatu/okhttp3/internal/tls/BasicCertificateChainCleaner;", "Lni/shikatu/okhttp3/internal/tls/CertificateChainCleaner;", "trustRootIndex", "Lni/shikatu/okhttp3/internal/tls/TrustRootIndex;", "<init>", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "clean", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/security/cert/Certificate;", "chain", "hostname", _UrlKt.FRAGMENT_ENCODE_SET, "verifySignature", _UrlKt.FRAGMENT_ENCODE_SET, "toVerify", "Ljava/security/cert/X509Certificate;", "signingCert", "minIntermediates", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        Intrinsics.checkNotNullParameter(trustRootIndex, "trustRootIndex");
        this.trustRootIndex = trustRootIndex;
    }

    @Override
    public List<Certificate> clean(List<? extends Certificate> list, String hostname) throws SSLPeerUnverifiedException {
        X509Certificate signingCert;
        Intrinsics.checkNotNullParameter(list, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Deque queue = new ArrayDeque(list);
        List result = new ArrayList();
        Object objRemoveFirst = queue.removeFirst();
        Intrinsics.checkNotNullExpressionValue(objRemoveFirst, "removeFirst(...)");
        result.add(objRemoveFirst);
        boolean foundTrustedCertificate = false;
        for (int c = 0; c < 9; c++) {
            Object obj = result.get(result.size() - 1);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate toVerify = (X509Certificate) obj;
            X509Certificate trustedCert = this.trustRootIndex.findByIssuerAndSignature(toVerify);
            if (trustedCert != null) {
                if (result.size() > 1 || !Intrinsics.areEqual(toVerify, trustedCert)) {
                    result.add(trustedCert);
                }
                if (verifySignature(trustedCert, trustedCert, result.size() - 2)) {
                    return result;
                }
                foundTrustedCertificate = true;
            } else {
                Iterator i = queue.iterator();
                Intrinsics.checkNotNullExpressionValue(i, "iterator(...)");
                do {
                    if (i.hasNext()) {
                        Object next = i.next();
                        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                        signingCert = (X509Certificate) next;
                    } else {
                        if (foundTrustedCertificate) {
                            return result;
                        }
                        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + toVerify);
                    }
                } while (!verifySignature(toVerify, signingCert, result.size() - 1));
                i.remove();
                result.add(signingCert);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + result);
    }

    private final boolean verifySignature(X509Certificate toVerify, X509Certificate signingCert, int minIntermediates) {
        if (!Intrinsics.areEqual(toVerify.getIssuerDN(), signingCert.getSubjectDN()) || signingCert.getBasicConstraints() < minIntermediates) {
            return false;
        }
        try {
            toVerify.verify(signingCert.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        return (other instanceof BasicCertificateChainCleaner) && Intrinsics.areEqual(((BasicCertificateChainCleaner) other).trustRootIndex, this.trustRootIndex);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/okhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MAX_SIGNERS", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
