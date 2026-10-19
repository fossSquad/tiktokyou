package ni.shikatu.okhttp3.internal.platform.android;

import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/BouncyCastleSocketAdapter;", "Lni/shikatu/okhttp3/internal/platform/android/SocketAdapter;", "<init>", "()V", "matchesSocket", _UrlKt.FRAGMENT_ENCODE_SET, "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isSupported", "getSelectedProtocol", _UrlKt.FRAGMENT_ENCODE_SET, "configureTlsExtensions", _UrlKt.FRAGMENT_ENCODE_SET, "hostname", "protocols", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Protocol;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BouncyCastleSocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion(null);
    private static final DeferredSocketAdapter.Factory factory = new DeferredSocketAdapter.Factory() {
        @Override
        public boolean matchesSocket(SSLSocket sslSocket) {
            Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
            return BouncyCastleSocketAdapter.Companion.isSupported() && (sslSocket instanceof BCSSLSocket);
        }

        @Override
        public SocketAdapter create(SSLSocket sslSocket) {
            Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
            return new BouncyCastleSocketAdapter();
        }
    };
    private static final boolean isSupported;

    @Override
    public /* bridge */ boolean matchesSocketFactory(SSLSocketFactory sslSocketFactory) {
        return super.matchesSocketFactory(sslSocketFactory);
    }

    @Override
    public /* bridge */ X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        return super.trustManager(sslSocketFactory);
    }

    @Override
    public boolean matchesSocket(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return sslSocket instanceof BCSSLSocket;
    }

    @Override
    public boolean isSupported() {
        return isSupported;
    }

    @Override
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        BCSSLSocket s = (BCSSLSocket) sslSocket;
        String protocol = s.getApplicationProtocol();
        if (protocol != null && !Intrinsics.areEqual(protocol, _UrlKt.FRAGMENT_ENCODE_SET)) {
            return protocol;
        }
        return null;
    }

    @Override
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        if (matchesSocket(sslSocket)) {
            BCSSLSocket bcSocket = (BCSSLSocket) sslSocket;
            BCSSLParameters sslParameters = bcSocket.getParameters();
            Collection $this$toTypedArray$iv = Platform.Companion.alpnProtocolNames(list);
            sslParameters.setApplicationProtocols((String[]) $this$toTypedArray$iv.toArray(new String[0]));
            bcSocket.setParameters(sslParameters);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/BouncyCastleSocketAdapter$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "factory", "Lni/shikatu/okhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "isSupported", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeferredSocketAdapter.Factory getFactory() {
            return BouncyCastleSocketAdapter.factory;
        }

        public final boolean isSupported() {
            return BouncyCastleSocketAdapter.isSupported;
        }
    }

    static {
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, Companion.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException e) {
        }
        isSupported = z;
    }
}
