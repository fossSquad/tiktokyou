package ni.shikatu.okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/Dns;", _UrlKt.FRAGMENT_ENCODE_SET, "lookup", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/net/InetAddress;", "hostname", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Dns {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Dns SYSTEM = new Companion.DnsSystem();

    List<InetAddress> lookup(String str) throws UnknownHostException;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lni/shikatu/okhttp3/Dns$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "SYSTEM", "Lni/shikatu/okhttp3/Dns;", "DnsSystem", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lni/shikatu/okhttp3/Dns$Companion$DnsSystem;", "Lni/shikatu/okhttp3/Dns;", "<init>", "()V", "lookup", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/net/InetAddress;", "hostname", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
        private static final class DnsSystem implements Dns {
            @Override
            public List<InetAddress> lookup(String hostname) throws UnknownHostException {
                Intrinsics.checkNotNullParameter(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(...)");
                    return ArraysKt.toList(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException $this$lookup_u24lambda_u240 = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                    $this$lookup_u24lambda_u240.initCause(e);
                    throw $this$lookup_u24lambda_u240;
                }
            }
        }
    }
}
