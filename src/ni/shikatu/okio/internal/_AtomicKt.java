package ni.shikatu.okio.internal;

import java.util.concurrent.atomic.AtomicInteger;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"setBitsOrZero", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/concurrent/atomic/AtomicInteger;", "bits", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _AtomicKt {
    public static final int setBitsOrZero(AtomicInteger $this$setBitsOrZero, int bits) {
        int current;
        int updated;
        Intrinsics.checkNotNullParameter($this$setBitsOrZero, "<this>");
        do {
            current = $this$setBitsOrZero.get();
            if ((current & bits) != 0) {
                return 0;
            }
            updated = current | bits;
        } while (!$this$setBitsOrZero.compareAndSet(current, updated));
        return updated;
    }
}
