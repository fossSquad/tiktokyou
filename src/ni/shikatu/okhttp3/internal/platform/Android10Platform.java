package ni.shikatu.okhttp3.internal.platform;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.internal.platform.android.Android10SocketAdapter;
import ni.shikatu.okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import ni.shikatu.okhttp3.internal.platform.android.AndroidSocketAdapter;
import ni.shikatu.okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import ni.shikatu.okhttp3.internal.platform.android.ConscryptSocketAdapter;
import ni.shikatu.okhttp3.internal.platform.android.DeferredSocketAdapter;
import ni.shikatu.okhttp3.internal.platform.android.SocketAdapter;
import ni.shikatu.okhttp3.internal.tls.CertificateChainCleaner;
import ni.shikatu.okhttp3.internal.tls.TrustRootIndex;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\fH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010)\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/Android10Platform;", "Lni/shikatu/okhttp3/internal/platform/Platform;", "Lni/shikatu/okhttp3/internal/platform/ContextAwarePlatform;", "<init>", "()V", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "socketAdapters", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/platform/android/SocketAdapter;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "buildTrustRootIndex", "Lni/shikatu/okhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", _UrlKt.FRAGMENT_ENCODE_SET, "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", _UrlKt.FRAGMENT_ENCODE_SET, "protocols", "Lni/shikatu/okhttp3/Protocol;", "getSelectedProtocol", "getStackTraceForCloseable", _UrlKt.FRAGMENT_ENCODE_SET, "closer", "logCloseableLeak", "message", "stackTrace", "isCleartextTrafficPermitted", _UrlKt.FRAGMENT_ENCODE_SET, "buildCertificateChainCleaner", "Lni/shikatu/okhttp3/internal/tls/CertificateChainCleaner;", "log", "level", _UrlKt.FRAGMENT_ENCODE_SET, "t", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Android10Platform extends Platform implements ContextAwarePlatform {
    public static final Companion Companion = new Companion(null);
    private static final boolean isSupported;
    private Context applicationContext;
    private final List<SocketAdapter> socketAdapters;

    public Android10Platform() {
        Iterable $this$filter$iv = CollectionsKt.listOfNotNull((Object[]) new SocketAdapter[]{Android10SocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())});
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            SocketAdapter it = (SocketAdapter) element$iv$iv;
            if (it.isSupported()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        this.socketAdapters = (List) destination$iv$iv;
    }

    @Override
    public Context getApplicationContext() {
        return this.applicationContext;
    }

    @Override
    public void setApplicationContext(Context context) {
        this.applicationContext = context;
    }

    @Override
    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        Object next;
        SocketAdapter it;
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it2 = this.socketAdapters.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            it = (SocketAdapter) next;
        } while (!it.matchesSocketFactory(sslSocketFactory));
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            return socketAdapter.trustManager(sslSocketFactory);
        }
        return null;
    }

    @Override
    public SSLContext newSSLContext() {
        StrictMode.noteSlowCall("newSSLContext");
        return super.newSSLContext();
    }

    @Override
    public TrustRootIndex buildTrustRootIndex(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        StrictMode.noteSlowCall("buildTrustRootIndex");
        return super.buildTrustRootIndex(trustManager);
    }

    @Override
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends Protocol> list) {
        Object next;
        SocketAdapter it;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        Iterator<T> it2 = this.socketAdapters.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                it = (SocketAdapter) next;
            }
        } while (!it.matchesSocket(sslSocket));
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sslSocket, hostname, list);
        }
    }

    @Override
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Object next;
        SocketAdapter it;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator<T> it2 = this.socketAdapters.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            it = (SocketAdapter) next;
        } while (!it.matchesSocket(sslSocket));
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            return socketAdapter.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    @Override
    public Object getStackTraceForCloseable(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        if (Build.VERSION.SDK_INT >= 30) {
            CloseGuard $this$getStackTraceForCloseable_u24lambda_u240 = new CloseGuard();
            $this$getStackTraceForCloseable_u24lambda_u240.open(closer);
            return $this$getStackTraceForCloseable_u24lambda_u240;
        }
        return super.getStackTraceForCloseable(closer);
    }

    @Override
    public void logCloseableLeak(String message, Object stackTrace) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Build.VERSION.SDK_INT >= 30) {
            Intrinsics.checkNotNull(stackTrace, "null cannot be cast to non-null type android.util.CloseGuard");
            ((CloseGuard) stackTrace).warnIfOpen();
        } else {
            super.logCloseableLeak(message, stackTrace);
        }
    }

    @Override
    public boolean isCleartextTrafficPermitted(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        AndroidCertificateChainCleaner androidCertificateChainCleanerBuildIfSupported = AndroidCertificateChainCleaner.Companion.buildIfSupported(trustManager);
        return androidCertificateChainCleanerBuildIfSupported != null ? androidCertificateChainCleanerBuildIfSupported : super.buildCertificateChainCleaner(trustManager);
    }

    @Override
    public void log(String message, int level, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (level == 5) {
            Log.w(AndroidPlatform.Companion.getTag(), message, t);
        } else {
            Log.i(AndroidPlatform.Companion.getTag(), message, t);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\t"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/Android10Platform$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "isSupported", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "buildIfSupported", "Lni/shikatu/okhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isSupported() {
            return Android10Platform.isSupported;
        }

        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new Android10Platform();
            }
            return null;
        }
    }

    static {
        isSupported = Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
    }
}
