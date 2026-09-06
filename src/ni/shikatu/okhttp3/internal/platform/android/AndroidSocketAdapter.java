package ni.shikatu.okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.internal.platform.AndroidPlatform;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \n*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/AndroidSocketAdapter;", "Lni/shikatu/okhttp3/internal/platform/android/SocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "<init>", "(Ljava/lang/Class;)V", "setUseSessionTickets", "Ljava/lang/reflect/Method;", "setHostname", "ni.shikatu.kotlin.jvm.PlatformType", "getAlpnSelectedProtocol", "setAlpnProtocols", "isSupported", _UrlKt.FRAGMENT_ENCODE_SET, "matchesSocket", "sslSocket", "configureTlsExtensions", _UrlKt.FRAGMENT_ENCODE_SET, "hostname", _UrlKt.FRAGMENT_ENCODE_SET, "protocols", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Protocol;", "getSelectedProtocol", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion(null);
    private static final DeferredSocketAdapter.Factory playProviderFactory = Companion.factory("com.google.android.gms.org.conscrypt");
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    public AndroidSocketAdapter(Class<? super SSLSocket> cls) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(cls, "sslSocketClass");
        this.sslSocketClass = cls;
        Method declaredMethod = this.sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = this.sslSocketClass.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = this.sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = this.sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override
    public /* bridge */ boolean matchesSocketFactory(SSLSocketFactory sslSocketFactory) {
        return super.matchesSocketFactory(sslSocketFactory);
    }

    @Override
    public /* bridge */ X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        return super.trustManager(sslSocketFactory);
    }

    @Override
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override
    public boolean matchesSocket(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sslSocket);
    }

    @Override
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        if (matchesSocket(sslSocket)) {
            try {
                this.setUseSessionTickets.invoke(sslSocket, true);
                this.setAlpnProtocols.invoke(sslSocket, Platform.Companion.concatLengthPrefixed(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override
    public String getSelectedProtocol(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (!matchesSocket(sslSocket)) {
            return null;
        }
        try {
            byte[] alpnResult = (byte[]) this.getAlpnSelectedProtocol.invoke(sslSocket, new Object[0]);
            if (alpnResult != null) {
                return new String(alpnResult, Charsets.UTF_8);
            }
            return null;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if ((cause instanceof NullPointerException) && Intrinsics.areEqual(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00020\f0\u000bH\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/AndroidSocketAdapter$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "playProviderFactory", "Lni/shikatu/okhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "build", "Lni/shikatu/okhttp3/internal/platform/android/AndroidSocketAdapter;", "actualSSLSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "factory", "packageName", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.playProviderFactory;
        }

        public final AndroidSocketAdapter build(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> superclass = cls;
            while (superclass != null && !Intrinsics.areEqual(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            Intrinsics.checkNotNull(superclass);
            return new AndroidSocketAdapter(superclass);
        }

        public final DeferredSocketAdapter.Factory factory(final String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new DeferredSocketAdapter.Factory() {
                @Override
                public boolean matchesSocket(SSLSocket sslSocket) {
                    Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                    String name = sslSocket.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    return StringsKt.startsWith$default(name, packageName + '.', false, 2, (Object) null);
                }

                @Override
                public SocketAdapter create(SSLSocket sslSocket) {
                    Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                    return AndroidSocketAdapter.Companion.build(sslSocket.getClass());
                }
            };
        }
    }
}
