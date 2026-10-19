package ni.shikatu.kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a-\u0010\u000b\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\r\u001a-\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\r\u001a-\u0010\u0010\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\r\u001a@\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0005H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a-\u0010\u000b\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\u0015\u001a-\u0010\u000e\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\u0015\u001a-\u0010\u000f\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\u0015\u001a-\u0010\u0010\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\u0015\u001aN\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0006\b\u0000\u0010\u0018\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00180\u0005H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a9\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00180\u0017\"\u0006\b\u0000\u0010\u0018\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001cb\u0002\b\n¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"AtomicIntArray", "Lni/shikatu/kotlin/concurrent/atomics/AtomicIntArray;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "init", "Lni/shikatu/kotlin/Function1;", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicIntegerArray;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.1", "Lni/shikatu/kotlin/concurrent/atomics/ExperimentalAtomicApi;", "fetchAndIncrementAt", "index", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;I)I", "incrementAndFetchAt", "decrementAndFetchAt", "fetchAndDecrementAt", "AtomicLongArray", "Lni/shikatu/kotlin/concurrent/atomics/AtomicLongArray;", _UrlKt.FRAGMENT_ENCODE_SET, "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicLongArray;", "(Ljava/util/concurrent/atomic/AtomicLongArray;I)J", "AtomicArray", "Lni/shikatu/kotlin/concurrent/atomics/AtomicArray;", "T", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "atomicArrayOfNulls", "(I)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "2.2", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/concurrent/atomics/AtomicArraysKt")
class AtomicArraysKt__AtomicArrays_commonKt {
    public static final AtomicIntegerArray AtomicIntArray(int size, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(i)).intValue();
        }
        return new AtomicIntegerArray(iArr);
    }

    public static final int fetchAndIncrementAt(AtomicIntegerArray $this$fetchAndIncrementAt, int index) {
        Intrinsics.checkNotNullParameter($this$fetchAndIncrementAt, "<this>");
        return $this$fetchAndIncrementAt.getAndAdd(index, 1);
    }

    public static final int incrementAndFetchAt(AtomicIntegerArray $this$incrementAndFetchAt, int index) {
        Intrinsics.checkNotNullParameter($this$incrementAndFetchAt, "<this>");
        return $this$incrementAndFetchAt.addAndGet(index, 1);
    }

    public static final int decrementAndFetchAt(AtomicIntegerArray $this$decrementAndFetchAt, int index) {
        Intrinsics.checkNotNullParameter($this$decrementAndFetchAt, "<this>");
        return $this$decrementAndFetchAt.addAndGet(index, -1);
    }

    public static final int fetchAndDecrementAt(AtomicIntegerArray $this$fetchAndDecrementAt, int index) {
        Intrinsics.checkNotNullParameter($this$fetchAndDecrementAt, "<this>");
        return $this$fetchAndDecrementAt.getAndAdd(index, -1);
    }

    public static final AtomicLongArray AtomicLongArray(int size, Function1<? super Integer, Long> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = function1.invoke(Integer.valueOf(i)).longValue();
        }
        return new AtomicLongArray(jArr);
    }

    public static final long fetchAndIncrementAt(AtomicLongArray $this$fetchAndIncrementAt, int index) {
        Intrinsics.checkNotNullParameter($this$fetchAndIncrementAt, "<this>");
        return $this$fetchAndIncrementAt.getAndAdd(index, 1L);
    }

    public static final long incrementAndFetchAt(AtomicLongArray $this$incrementAndFetchAt, int index) {
        Intrinsics.checkNotNullParameter($this$incrementAndFetchAt, "<this>");
        return $this$incrementAndFetchAt.addAndGet(index, 1L);
    }

    public static final long decrementAndFetchAt(AtomicLongArray $this$decrementAndFetchAt, int index) {
        Intrinsics.checkNotNullParameter($this$decrementAndFetchAt, "<this>");
        return $this$decrementAndFetchAt.addAndGet(index, -1L);
    }

    public static final long fetchAndDecrementAt(AtomicLongArray $this$fetchAndDecrementAt, int index) {
        Intrinsics.checkNotNullParameter($this$fetchAndDecrementAt, "<this>");
        return $this$fetchAndDecrementAt.getAndAdd(index, -1L);
    }

    public static final  <T> AtomicReferenceArray<T> AtomicArray(int size, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            objArr[i] = function1.invoke(Integer.valueOf(i));
        }
        return new AtomicReferenceArray<>(objArr);
    }

    public static final  <T> AtomicReferenceArray<T> atomicArrayOfNulls(int size) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            objArr[i] = null;
        }
        return new AtomicReferenceArray<>(objArr);
    }
}
