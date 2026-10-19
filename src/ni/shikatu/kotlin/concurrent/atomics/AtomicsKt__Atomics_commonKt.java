package ni.shikatu.kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0005\u001a-\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0005\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\f\u001a%\u0010\r\u001a\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\f\u001a%\u0010\u000e\u001a\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\f\u001a%\u0010\u000f\u001a\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\f\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0011H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0012\u001a-\u0010\n\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0011H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0012\u001a%\u0010\u000b\u001a\u00020\u0011*\u00020\u0010H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0013\u001a%\u0010\r\u001a\u00020\u0011*\u00020\u0010H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0013\u001a%\u0010\u000e\u001a\u00020\u0011*\u00020\u0010H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0013\u001a%\u0010\u000f\u001a\u00020\u0011*\u00020\u0010H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"plusAssign", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/concurrent/atomics/AtomicInt;", "delta", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/concurrent/atomic/AtomicInteger;I)V", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.1", "Lni/shikatu/kotlin/concurrent/atomics/ExperimentalAtomicApi;", "minusAssign", "fetchAndIncrement", "(Ljava/util/concurrent/atomic/AtomicInteger;)I", "incrementAndFetch", "decrementAndFetch", "fetchAndDecrement", "Lni/shikatu/kotlin/concurrent/atomics/AtomicLong;", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/concurrent/atomic/AtomicLong;J)V", "(Ljava/util/concurrent/atomic/AtomicLong;)J", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/concurrent/atomics/AtomicsKt")
class AtomicsKt__Atomics_commonKt {
    public static final void plusAssign(AtomicInteger $this$plusAssign, int delta) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        $this$plusAssign.addAndGet(delta);
    }

    public static final void minusAssign(AtomicInteger $this$minusAssign, int delta) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        $this$minusAssign.addAndGet(-delta);
    }

    public static final int fetchAndIncrement(AtomicInteger $this$fetchAndIncrement) {
        Intrinsics.checkNotNullParameter($this$fetchAndIncrement, "<this>");
        return $this$fetchAndIncrement.getAndAdd(1);
    }

    public static final int incrementAndFetch(AtomicInteger $this$incrementAndFetch) {
        Intrinsics.checkNotNullParameter($this$incrementAndFetch, "<this>");
        return $this$incrementAndFetch.addAndGet(1);
    }

    public static final int decrementAndFetch(AtomicInteger $this$decrementAndFetch) {
        Intrinsics.checkNotNullParameter($this$decrementAndFetch, "<this>");
        return $this$decrementAndFetch.addAndGet(-1);
    }

    public static final int fetchAndDecrement(AtomicInteger $this$fetchAndDecrement) {
        Intrinsics.checkNotNullParameter($this$fetchAndDecrement, "<this>");
        return $this$fetchAndDecrement.getAndAdd(-1);
    }

    public static final void plusAssign(AtomicLong $this$plusAssign, long delta) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        $this$plusAssign.addAndGet(delta);
    }

    public static final void minusAssign(AtomicLong $this$minusAssign, long delta) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        $this$minusAssign.addAndGet(-delta);
    }

    public static final long fetchAndIncrement(AtomicLong $this$fetchAndIncrement) {
        Intrinsics.checkNotNullParameter($this$fetchAndIncrement, "<this>");
        return $this$fetchAndIncrement.getAndAdd(1L);
    }

    public static final long incrementAndFetch(AtomicLong $this$incrementAndFetch) {
        Intrinsics.checkNotNullParameter($this$incrementAndFetch, "<this>");
        return $this$incrementAndFetch.addAndGet(1L);
    }

    public static final long decrementAndFetch(AtomicLong $this$decrementAndFetch) {
        Intrinsics.checkNotNullParameter($this$decrementAndFetch, "<this>");
        return $this$decrementAndFetch.addAndGet(-1L);
    }

    public static final long fetchAndDecrement(AtomicLong $this$fetchAndDecrement) {
        Intrinsics.checkNotNullParameter($this$fetchAndDecrement, "<this>");
        return $this$fetchAndDecrement.getAndAdd(-1L);
    }
}
