package ni.shikatu.okhttp3.internal.connection;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"reorderForHappyEyeballs", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/net/InetAddress;", "addresses", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InetAddressOrderKt {

    public static final List<InetAddress> reorderForHappyEyeballs(List<? extends InetAddress> list) {
        Intrinsics.checkNotNullParameter(list, "addresses");
        if (list.size() < 2) {
            return list;
        }
        List<? extends InetAddress> $this$partition$iv = list;
        ArrayList first$iv = new ArrayList();
        ArrayList second$iv = new ArrayList();
        for (Object element$iv : $this$partition$iv) {
            InetAddress it = (InetAddress) element$iv;
            if (it instanceof Inet6Address) {
                first$iv.add(element$iv);
            } else {
                second$iv.add(element$iv);
            }
        }
        Pair pair = new Pair(first$iv, second$iv);
        List ipv6 = (List) pair.component1();
        List ipv4 = (List) pair.component2();
        if (ipv6.isEmpty() || ipv4.isEmpty()) {
            return list;
        }
        return _UtilCommonKt.interleave(ipv6, ipv4);
    }
}
