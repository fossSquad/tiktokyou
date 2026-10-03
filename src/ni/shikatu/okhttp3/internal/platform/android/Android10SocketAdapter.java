package ni.shikatu.okhttp3.internal.platform.android;

import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0017¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/Android10SocketAdapter;", "Lni/shikatu/okhttp3/internal/platform/android/SocketAdapter;", "<init>", "()V", "matchesSocket", _UrlKt.FRAGMENT_ENCODE_SET, "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isSupported", "getSelectedProtocol", _UrlKt.FRAGMENT_ENCODE_SET, "configureTlsExtensions", _UrlKt.FRAGMENT_ENCODE_SET, "hostname", "protocols", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Protocol;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Android10SocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion(null);

    @Override
    public boolean matchesSocket(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sslSocket);
    }

    @Override
    public boolean isSupported() {
        return Companion.isSupported();
    }

    @Override
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            String protocol = sslSocket.getApplicationProtocol();
            if (protocol == null || Intrinsics.areEqual(protocol, _UrlKt.FRAGMENT_ENCODE_SET)) {
                return null;
            }
            return protocol;
        } catch (UnsupportedOperationException e) {
            return null;
        }
    }

    @Override
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends Protocol> list) throws IOException {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sslSocket, true);
            SSLParameters sslParameters = sslSocket.getSSLParameters();
            Collection $this$toTypedArray$iv = Platform.Companion.alpnProtocolNames(list);
            sslParameters.setApplicationProtocols((String[]) $this$toTypedArray$iv.toArray(new String[0]));
            sslSocket.setSSLParameters(sslParameters);
        } catch (IllegalArgumentException iae) {
            throw new IOException("Android internal error", iae);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/Android10SocketAdapter$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "buildIfSupported", "Lni/shikatu/okhttp3/internal/platform/android/SocketAdapter;", "isSupported", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SocketAdapter buildIfSupported() {
            if (isSupported()) {
                return new Android10SocketAdapter();
            }
            return null;
        }

        public final boolean isSupported() {
            return Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
        }
    }
}
