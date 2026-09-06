package ni.shikatu.kotlin.concurrent.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.concurrent.atomics.AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import ni.shikatu.kotlin.concurrent.atomics.AtomicsKt__Atomics_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a0\u0010\u0000\u001a\u00020\t*\u00020\n2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a0\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001aA\u0010\u0000\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u0003\u001a\u0002H\r2\u0006\u0010\u0004\u001a\u0002H\rH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u000f\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a8\u0010\u0000\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001aI\u0010\u0000\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00132\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\r2\u0006\u0010\u0004\u001a\u0002H\rH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"compareAndExchange", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/concurrent/atomic/AtomicInteger;", "expected", "newValue", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.1", "Lni/shikatu/kotlin/PublishedApi;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/concurrent/atomic/AtomicLong;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/concurrent/atomic/AtomicBoolean;", "T", "Ljava/util/concurrent/atomic/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", "index", "Ljava/util/concurrent/atomic/AtomicLongArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class AtomicIntrinsicsKt {
    public static final int compareAndExchange(AtomicInteger $this$compareAndExchange, int expected, int newValue) {
        Intrinsics.checkNotNullParameter($this$compareAndExchange, "<this>");
        do {
            int currentValue = $this$compareAndExchange.get();
            if (expected != currentValue) {
                return currentValue;
            }
        } while (!$this$compareAndExchange.compareAndSet(expected, newValue));
        return expected;
    }

    public static final long compareAndExchange(AtomicLong $this$compareAndExchange, long expected, long newValue) {
        Intrinsics.checkNotNullParameter($this$compareAndExchange, "<this>");
        do {
            long currentValue = $this$compareAndExchange.get();
            if (expected != currentValue) {
                return currentValue;
            }
        } while (!$this$compareAndExchange.compareAndSet(expected, newValue));
        return expected;
    }

    public static final boolean compareAndExchange(AtomicBoolean $this$compareAndExchange, boolean expected, boolean newValue) {
        Intrinsics.checkNotNullParameter($this$compareAndExchange, "<this>");
        do {
            boolean currentValue = $this$compareAndExchange.get();
            if (expected != currentValue) {
                return currentValue;
            }
        } while (!$this$compareAndExchange.compareAndSet(expected, newValue));
        return expected;
    }

    public static final <T> T compareAndExchange(AtomicReference<T> atomicReference, T t, T t2) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        do {
            T t3 = atomicReference.get();
            if (t != t3) {
                return t3;
            }
        } while (!AtomicsKt__Atomics_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, t, t2));
        return t;
    }

    public static final int compareAndExchange(AtomicIntegerArray $this$compareAndExchange, int index, int expected, int newValue) {
        Intrinsics.checkNotNullParameter($this$compareAndExchange, "<this>");
        do {
            int currentValue = $this$compareAndExchange.get(index);
            if (expected != currentValue) {
                return currentValue;
            }
        } while (!$this$compareAndExchange.compareAndSet(index, expected, newValue));
        return expected;
    }

    public static final long compareAndExchange(AtomicLongArray $this$compareAndExchange, int index, long expected, long newValue) {
        Intrinsics.checkNotNullParameter($this$compareAndExchange, "<this>");
        do {
            long currentValue = $this$compareAndExchange.get(index);
            if (expected != currentValue) {
                return currentValue;
            }
        } while (!$this$compareAndExchange.compareAndSet(index, expected, newValue));
        return expected;
    }

    public static final <T> T compareAndExchange(AtomicReferenceArray<T> atomicReferenceArray, int index, T t, T t2) {
        Intrinsics.checkNotNullParameter(atomicReferenceArray, "<this>");
        do {
            T t3 = atomicReferenceArray.get(index);
            if (t != t3) {
                return t3;
            }
        } while (!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, index, t, t2));
        return t;
    }
}
