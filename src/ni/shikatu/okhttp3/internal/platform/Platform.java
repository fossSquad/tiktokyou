package ni.shikatu.okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import ni.shikatu.okhttp3.internal.tls.BasicCertificateChainCleaner;
import ni.shikatu.okhttp3.internal.tls.BasicTrustRootIndex;
import ni.shikatu.okhttp3.internal.tls.CertificateChainCleaner;
import ni.shikatu.okhttp3.internal.tls.TrustRootIndex;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J-\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0011\u0010\u0012\u001a\r\u0012\t\u0012\u00070\u0014¢\u0006\u0002\b\u00150\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J&\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020\u0005H\u0016J\u001a\u0010)\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010/\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0005H\u0016¨\u00062"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/Platform;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "getPrefix", _UrlKt.FRAGMENT_ENCODE_SET, "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "configureTlsExtensions", _UrlKt.FRAGMENT_ENCODE_SET, "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "protocols", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Protocol;", "Lni/shikatu/kotlin/jvm/JvmSuppressWildcards;", "afterHandshake", "getSelectedProtocol", "getHandshakeServerNames", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", _UrlKt.FRAGMENT_ENCODE_SET, "log", "message", "level", "t", _UrlKt.FRAGMENT_ENCODE_SET, "isCleartextTrafficPermitted", _UrlKt.FRAGMENT_ENCODE_SET, "getStackTraceForCloseable", "closer", "logCloseableLeak", "stackTrace", "buildCertificateChainCleaner", "Lni/shikatu/okhttp3/internal/tls/CertificateChainCleaner;", "buildTrustRootIndex", "Lni/shikatu/okhttp3/internal/tls/TrustRootIndex;", "newSslSocketFactory", "toString", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class Platform {
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final Companion Companion = new Companion(null);
    private static volatile Platform platform = Companion.findPlatform();
    private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

    public final String getPrefix() {
        return "OkHttp";
    }

    public SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(...)");
        return sSLContext;
    }

    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        factory.init((KeyStore) null);
        TrustManager[] trustManagers = factory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            StringBuilder sbAppend = new StringBuilder().append("Unexpected default trust managers: ");
            String string = Arrays.toString(trustManagers);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            throw new IllegalStateException(sbAppend.append(string).toString().toString());
        }
        TrustManager trustManager = trustManagers[0];
        Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        return (X509TrustManager) trustManager;
    }

    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        try {
            Class<?> cls = Class.forName("sun.security.ssl.SSLContextImpl");
            Intrinsics.checkNotNull(cls);
            Object context = _UtilJvmKt.readFieldOrNull(sslSocketFactory, cls, "context");
            if (context == null) {
                return null;
            }
            return (X509TrustManager) _UtilJvmKt.readFieldOrNull(context, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e) {
            return null;
        } catch (RuntimeException e2) {
            if (Intrinsics.areEqual(e2.getClass().getName(), "java.lang.reflect.InaccessibleObjectException")) {
                return null;
            }
            throw e2;
        }
    }

    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<Protocol> list) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
    }

    public void afterHandshake(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
    }

    public String getSelectedProtocol(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return null;
    }

    public List<String> getHandshakeServerNames(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        SSLSession session = sslSocket.getSession();
        ExtendedSSLSession extendedSSLSession = session instanceof ExtendedSSLSession ? (ExtendedSSLSession) session : null;
        if (extendedSSLSession == null) {
            return CollectionsKt.emptyList();
        }
        ExtendedSSLSession session2 = extendedSSLSession;
        try {
            Iterable requestedServerNames = session2.getRequestedServerNames();
            Intrinsics.checkNotNullExpressionValue(requestedServerNames, "getRequestedServerNames(...)");
            Iterable $this$mapNotNull$iv = requestedServerNames;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                SNIServerName it = (SNIServerName) element$iv$iv$iv;
                SNIHostName sNIHostName = it instanceof SNIHostName ? (SNIHostName) it : null;
                String asciiName = sNIHostName != null ? sNIHostName.getAsciiName() : null;
                if (asciiName != null) {
                    destination$iv$iv.add(asciiName);
                }
            }
            return (List) destination$iv$iv;
        } catch (UnsupportedOperationException e) {
            return CollectionsKt.emptyList();
        }
    }

    public void connectSocket(Socket socket, InetSocketAddress address, int connectTimeout) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        socket.connect(address, connectTimeout);
    }

    public static  void log$default(Platform platform2, String str, int i, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i2 & 2) != 0) {
            i = 4;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        platform2.log(str, i, th);
    }

    public void log(String message, int level, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        Level logLevel = level == 5 ? Level.WARNING : Level.INFO;
        logger.log(logLevel, message, t);
    }

    public boolean isCleartextTrafficPermitted(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return true;
    }

    public Object getStackTraceForCloseable(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public void logCloseableLeak(String message, Object stackTrace) {
        Intrinsics.checkNotNullParameter(message, "message");
        String logMessage = message;
        if (stackTrace == null) {
            logMessage = logMessage + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(logMessage, 5, (Throwable) stackTrace);
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(trustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            SSLContext $this$newSslSocketFactory_u24lambda_u240 = newSSLContext();
            $this$newSslSocketFactory_u24lambda_u240.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = $this$newSslSocketFactory_u24lambda_u240.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u0005J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u001a"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/Platform$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "platform", "Lni/shikatu/okhttp3/internal/platform/Platform;", "INFO", _UrlKt.FRAGMENT_ENCODE_SET, "WARN", "logger", "Ljava/util/logging/Logger;", "ni.shikatu.kotlin.jvm.PlatformType", "get", "resetForTests", _UrlKt.FRAGMENT_ENCODE_SET, "alpnProtocolNames", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "protocols", "Lni/shikatu/okhttp3/Protocol;", "isAndroid", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "findPlatform", "concatLengthPrefixed", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Platform get() {
            return Platform.platform;
        }

        public static  void resetForTests$default(Companion companion, Platform platform, int i, Object obj) {
            if ((i & 1) != 0) {
                platform = companion.findPlatform();
            }
            companion.resetForTests(platform);
        }

        public final void resetForTests(Platform platform) {
            Intrinsics.checkNotNullParameter(platform, "platform");
            Platform.platform = platform;
            PublicSuffixDatabase.Companion.resetForTests$okhttp();
        }

        public final List<String> alpnProtocolNames(List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "protocols");
            List<? extends Protocol> $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Protocol it = (Protocol) element$iv$iv;
                if (it != Protocol.HTTP_1_0) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Protocol it2 = (Protocol) item$iv$iv;
                destination$iv$iv2.add(it2.toString());
            }
            return (List) destination$iv$iv2;
        }

        public final boolean isAndroid() {
            return PlatformRegistry.INSTANCE.isAndroid();
        }

        public final Platform findPlatform() {
            return PlatformRegistry.INSTANCE.findPlatform();
        }

        public final byte[] concatLengthPrefixed(List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "protocols");
            Buffer result = new Buffer();
            for (String protocol : alpnProtocolNames(list)) {
                result.writeByte(protocol.length());
                result.writeUtf8(protocol);
            }
            return result.readByteArray();
        }
    }

    @JvmStatic
    public static final Platform get() {
        return Companion.get();
    }
}
