package ni.shikatu.okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/DeferredSocketAdapter;", "Lni/shikatu/okhttp3/internal/platform/android/SocketAdapter;", "socketAdapterFactory", "Lni/shikatu/okhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "<init>", "(Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;)V", "delegate", "isSupported", _UrlKt.FRAGMENT_ENCODE_SET, "matchesSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", _UrlKt.FRAGMENT_ENCODE_SET, "hostname", _UrlKt.FRAGMENT_ENCODE_SET, "protocols", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Protocol;", "getSelectedProtocol", "getDelegate", "Factory", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeferredSocketAdapter implements SocketAdapter {
    private SocketAdapter delegate;
    private final Factory socketAdapterFactory;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", _UrlKt.FRAGMENT_ENCODE_SET, "matchesSocket", _UrlKt.FRAGMENT_ENCODE_SET, "sslSocket", "Ljavax/net/ssl/SSLSocket;", "create", "Lni/shikatu/okhttp3/internal/platform/android/SocketAdapter;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        SocketAdapter create(SSLSocket sSLSocket);

        boolean matchesSocket(SSLSocket sSLSocket);
    }

    public DeferredSocketAdapter(Factory socketAdapterFactory) {
        Intrinsics.checkNotNullParameter(socketAdapterFactory, "socketAdapterFactory");
        this.socketAdapterFactory = socketAdapterFactory;
    }

    @Override
    public boolean isSupported() {
        return true;
    }

    @Override
    public boolean matchesSocket(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.socketAdapterFactory.matchesSocket(sslSocket);
    }

    @Override
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        SocketAdapter delegate = getDelegate(sslSocket);
        if (delegate != null) {
            delegate.configureTlsExtensions(sslSocket, hostname, list);
        }
    }

    @Override
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        SocketAdapter delegate = getDelegate(sslSocket);
        if (delegate != null) {
            return delegate.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    private final synchronized SocketAdapter getDelegate(SSLSocket sslSocket) {
        if (this.delegate == null && this.socketAdapterFactory.matchesSocket(sslSocket)) {
            this.delegate = this.socketAdapterFactory.create(sslSocket);
        }
        return this.delegate;
    }
}
