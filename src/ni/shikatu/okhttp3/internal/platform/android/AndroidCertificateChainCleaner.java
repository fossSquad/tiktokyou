package ni.shikatu.okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.tls.CertificateChainCleaner;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "Lni/shikatu/okhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManagerExtensions", "Landroid/net/http/X509TrustManagerExtensions;", "<init>", "(Ljavax/net/ssl/X509TrustManager;Landroid/net/http/X509TrustManagerExtensions;)V", "clean", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/security/cert/Certificate;", "chain", "hostname", _UrlKt.FRAGMENT_ENCODE_SET, "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);
    private final X509TrustManager trustManager;
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    public AndroidCertificateChainCleaner(X509TrustManager trustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        Intrinsics.checkNotNullParameter(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.trustManager = trustManager;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions;
    }

    @Override
    public List<Certificate> clean(List<? extends Certificate> list, String hostname) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(list, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        List<? extends Certificate> $this$toTypedArray$iv = list;
        X509Certificate[] certificates = (X509Certificate[]) $this$toTypedArray$iv.toArray(new X509Certificate[0]);
        try {
            List<X509Certificate> listCheckServerTrusted = this.x509TrustManagerExtensions.checkServerTrusted(certificates, "RSA", hostname);
            Intrinsics.checkNotNullExpressionValue(listCheckServerTrusted, "checkServerTrusted(...)");
            return listCheckServerTrusted;
        } catch (CertificateException ce) {
            SSLPeerUnverifiedException $this$clean_u24lambda_u240 = new SSLPeerUnverifiedException(ce.getMessage());
            $this$clean_u24lambda_u240.initCause(ce);
            throw $this$clean_u24lambda_u240;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) other).trustManager == this.trustManager;
    }

    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/AndroidCertificateChainCleaner$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "buildIfSupported", "Lni/shikatu/okhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AndroidCertificateChainCleaner buildIfSupported(X509TrustManager trustManager) {
            X509TrustManagerExtensions extensions;
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            try {
                extensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException e) {
                extensions = null;
            }
            if (extensions != null) {
                return new AndroidCertificateChainCleaner(trustManager, extensions);
            }
            return null;
        }
    }
}
