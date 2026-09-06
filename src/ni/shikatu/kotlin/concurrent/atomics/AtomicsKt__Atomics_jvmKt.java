package ni.shikatu.kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0003\u001a%\u0010\b\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0003\u001a%\u0010\u0000\u001a\u00020\t*\u00020\nH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000b\u001a%\u0010\b\u001a\u00020\n*\u00020\tH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000b\u001a%\u0010\u0000\u001a\u00020\f*\u00020\rH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000e\u001a%\u0010\b\u001a\u00020\r*\u00020\fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000e\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u0011H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0012\u001a7\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u000fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u0018\u001aM\u0010\u001b\u001a\u00020\u0017*\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\u0017*\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001c\u001aM\u0010\u0013\u001a\u00020\u0014*\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001f\u001aM\u0010\u001b\u001a\u00020\u001e*\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010 \u001aM\u0010\u001d\u001a\u00020\u001e*\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010 \u001aY\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00100\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010!\u001aY\u0010\u001b\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00100\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\"\u001aY\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00100\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"asJavaAtomic", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lni/shikatu/kotlin/concurrent/atomics/AtomicInt;", "(Ljava/util/concurrent/atomic/AtomicInteger;)Ljava/util/concurrent/atomic/AtomicInteger;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.1", "Lni/shikatu/kotlin/concurrent/atomics/ExperimentalAtomicApi;", "asKotlinAtomic", "Ljava/util/concurrent/atomic/AtomicLong;", "Lni/shikatu/kotlin/concurrent/atomics/AtomicLong;", "(Ljava/util/concurrent/atomic/AtomicLong;)Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lni/shikatu/kotlin/concurrent/atomics/AtomicBoolean;", "(Ljava/util/concurrent/atomic/AtomicBoolean;)Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicReference;", "T", "Lni/shikatu/kotlin/concurrent/atomics/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "update", _UrlKt.FRAGMENT_ENCODE_SET, "transform", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/concurrent/atomic/AtomicInteger;Lkotlin/jvm/functions/Function1;)V", "2.2", "Lni/shikatu/kotlin/internal/InlineOnly;", "fetchAndUpdate", "(Ljava/util/concurrent/atomic/AtomicInteger;Lkotlin/jvm/functions/Function1;)I", "updateAndFetch", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/concurrent/atomic/AtomicLong;Lkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicLong;Lkotlin/jvm/functions/Function1;)J", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/concurrent/atomics/AtomicsKt")
class AtomicsKt__Atomics_jvmKt extends AtomicsKt__Atomics_commonKt {
    public static final AtomicInteger asJavaAtomic(AtomicInteger $this$asJavaAtomic) {
        Intrinsics.checkNotNullParameter($this$asJavaAtomic, "<this>");
        return $this$asJavaAtomic;
    }

    public static final AtomicInteger asKotlinAtomic(AtomicInteger $this$asKotlinAtomic) {
        Intrinsics.checkNotNullParameter($this$asKotlinAtomic, "<this>");
        return $this$asKotlinAtomic;
    }

    public static final AtomicLong asJavaAtomic(AtomicLong $this$asJavaAtomic) {
        Intrinsics.checkNotNullParameter($this$asJavaAtomic, "<this>");
        return $this$asJavaAtomic;
    }

    public static final AtomicLong asKotlinAtomic(AtomicLong $this$asKotlinAtomic) {
        Intrinsics.checkNotNullParameter($this$asKotlinAtomic, "<this>");
        return $this$asKotlinAtomic;
    }

    public static final AtomicBoolean asJavaAtomic(AtomicBoolean $this$asJavaAtomic) {
        Intrinsics.checkNotNullParameter($this$asJavaAtomic, "<this>");
        return $this$asJavaAtomic;
    }

    public static final AtomicBoolean asKotlinAtomic(AtomicBoolean $this$asKotlinAtomic) {
        Intrinsics.checkNotNullParameter($this$asKotlinAtomic, "<this>");
        return $this$asKotlinAtomic;
    }

    public static final <T> AtomicReference<T> asJavaAtomic(AtomicReference<T> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        return atomicReference;
    }

    public static final <T> AtomicReference<T> asKotlinAtomic(AtomicReference<T> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        return atomicReference;
    }

    private static final void update(AtomicInteger $this$update, Function1<? super Integer, Integer> function1) {
        int i;
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            i = $this$update.get();
        } while (!$this$update.compareAndSet(i, function1.invoke(Integer.valueOf(i)).intValue()));
    }

    private static final int fetchAndUpdate(AtomicInteger $this$fetchAndUpdate, Function1<? super Integer, Integer> function1) {
        int old;
        int newValue;
        Intrinsics.checkNotNullParameter($this$fetchAndUpdate, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            old = $this$fetchAndUpdate.get();
            newValue = function1.invoke(Integer.valueOf(old)).intValue();
        } while (!$this$fetchAndUpdate.compareAndSet(old, newValue));
        return old;
    }

    private static final int updateAndFetch(AtomicInteger $this$updateAndFetch, Function1<? super Integer, Integer> function1) {
        int old;
        int newValue;
        Intrinsics.checkNotNullParameter($this$updateAndFetch, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            old = $this$updateAndFetch.get();
            newValue = function1.invoke(Integer.valueOf(old)).intValue();
        } while (!$this$updateAndFetch.compareAndSet(old, newValue));
        return newValue;
    }

    private static final void update(AtomicLong $this$update, Function1<? super Long, Long> function1) {
        long j;
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            j = $this$update.get();
        } while (!$this$update.compareAndSet(j, function1.invoke(Long.valueOf(j)).longValue()));
    }

    private static final long fetchAndUpdate(AtomicLong $this$fetchAndUpdate, Function1<? super Long, Long> function1) {
        long old;
        long newValue;
        Intrinsics.checkNotNullParameter($this$fetchAndUpdate, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            old = $this$fetchAndUpdate.get();
            newValue = function1.invoke(Long.valueOf(old)).longValue();
        } while (!$this$fetchAndUpdate.compareAndSet(old, newValue));
        return old;
    }

    private static final long updateAndFetch(AtomicLong $this$updateAndFetch, Function1<? super Long, Long> function1) {
        long old;
        long newValue;
        Intrinsics.checkNotNullParameter($this$updateAndFetch, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            old = $this$updateAndFetch.get();
            newValue = function1.invoke(Long.valueOf(old)).longValue();
        } while (!$this$updateAndFetch.compareAndSet(old, newValue));
        return newValue;
    }

    private static final <T> void update(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> function1) {
        T t;
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            t = atomicReference.get();
        } while (!AtomicsKt__Atomics_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, t, function1.invoke(t)));
    }

    private static final <T> T fetchAndUpdate(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> function1) {
        T t;
        Object newValue;
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            t = atomicReference.get();
            newValue = function1.invoke(t);
        } while (!AtomicsKt__Atomics_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, t, newValue));
        return t;
    }

    private static final <T> T updateAndFetch(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> function1) {
        Object old;
        T tInvoke;
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        do {
            old = atomicReference.get();
            tInvoke = function1.invoke(old);
        } while (!AtomicsKt__Atomics_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, old, tInvoke));
        return tInvoke;
    }
}
