package ni.shikatu.okhttp3.internal.authenticator;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Address;
import ni.shikatu.okhttp3.Authenticator;
import ni.shikatu.okhttp3.Challenge;
import ni.shikatu.okhttp3.Credentials;
import ni.shikatu.okhttp3.Dns;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.Route;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/internal/authenticator/JavaNetAuthenticator;", "Lni/shikatu/okhttp3/Authenticator;", "defaultDns", "Lni/shikatu/okhttp3/Dns;", "<init>", "(Lokhttp3/Dns;)V", "authenticate", "Lni/shikatu/okhttp3/Request;", "route", "Lni/shikatu/okhttp3/Route;", "response", "Lni/shikatu/okhttp3/Response;", "connectToInetAddress", "Ljava/net/InetAddress;", "Ljava/net/Proxy;", "url", "Lni/shikatu/okhttp3/HttpUrl;", "dns", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JavaNetAuthenticator implements Authenticator {
    private final Dns defaultDns;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JavaNetAuthenticator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public JavaNetAuthenticator(Dns defaultDns) {
        Intrinsics.checkNotNullParameter(defaultDns, "defaultDns");
        this.defaultDns = defaultDns;
    }

    public  JavaNetAuthenticator(Dns dns, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dns.SYSTEM : dns);
    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        Proxy proxy;
        Dns dns;
        PasswordAuthentication auth;
        Address address;
        Intrinsics.checkNotNullParameter(response, "response");
        List<Challenge> listChallenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        boolean proxyAuthorization = response.code() == 407;
        if (route == null || (proxy = route.proxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (Challenge challenge : listChallenges) {
            if (StringsKt.equals("Basic", challenge.scheme(), true)) {
                if (route == null || (address = route.address()) == null || (dns = address.dns()) == null) {
                    dns = this.defaultDns;
                }
                if (proxyAuthorization) {
                    SocketAddress socketAddressAddress = proxy.address();
                    Intrinsics.checkNotNull(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress proxyAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = proxyAddress.getHostName();
                    Intrinsics.checkNotNull(proxy);
                    auth = java.net.Authenticator.requestPasswordAuthentication(hostName, connectToInetAddress(proxy, url, dns), proxyAddress.getPort(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), java.net.Authenticator.RequestorType.PROXY);
                } else {
                    String strHost = url.host();
                    Intrinsics.checkNotNull(proxy);
                    auth = java.net.Authenticator.requestPasswordAuthentication(strHost, connectToInetAddress(proxy, url, dns), url.port(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), java.net.Authenticator.RequestorType.SERVER);
                }
                if (auth != null) {
                    String credentialHeader = proxyAuthorization ? "Proxy-Authorization" : "Authorization";
                    String userName = auth.getUserName();
                    Intrinsics.checkNotNullExpressionValue(userName, "getUserName(...)");
                    char[] password = auth.getPassword();
                    Intrinsics.checkNotNullExpressionValue(password, "getPassword(...)");
                    String credential = Credentials.basic(userName, new String(password), challenge.charset());
                    return request.newBuilder().header(credentialHeader, credential).build();
                }
            }
        }
        return null;
    }

    private final InetAddress connectToInetAddress(Proxy $this$connectToInetAddress, HttpUrl url, Dns dns) throws IOException {
        Proxy.Type type = $this$connectToInetAddress.type();
        if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1) {
            return (InetAddress) CollectionsKt.first((List) dns.lookup(url.host()));
        }
        SocketAddress socketAddressAddress = $this$connectToInetAddress.address();
        Intrinsics.checkNotNull(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        return address;
    }
}
