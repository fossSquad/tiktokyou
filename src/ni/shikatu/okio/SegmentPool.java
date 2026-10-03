package ni.shikatu.okio;

import java.util.concurrent.atomic.AtomicReference;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\tH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0007J\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\rH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0016"}, d2 = {"Lni/shikatu/okio/SegmentPool;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MAX_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "getMAX_SIZE", "()I", "LOCK", "Lni/shikatu/okio/Segment;", "HASH_BUCKET_COUNT", "hashBuckets", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/concurrent/atomic/AtomicReference;", "[Ljava/util/concurrent/atomic/AtomicReference;", "byteCount", "getByteCount", "take", "recycle", _UrlKt.FRAGMENT_ENCODE_SET, "segment", "firstRef", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SegmentPool {
    private static final AtomicReference<Segment>[] hashBuckets;
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = 65536;
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);
    private static final int HASH_BUCKET_COUNT = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);

    private SegmentPool() {
    }

    static {
        int i = HASH_BUCKET_COUNT;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[i];
        for (int i2 = 0; i2 < i; i2++) {
            atomicReferenceArr[i2] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public final int getByteCount() {
        Segment first = firstRef().get();
        if (first == null) {
            return 0;
        }
        return first.limit;
    }

    @JvmStatic
    public static final Segment take() {
        AtomicReference<Segment> atomicReferenceFirstRef = INSTANCE.firstRef();
        Segment first = atomicReferenceFirstRef.getAndSet(LOCK);
        if (first == LOCK) {
            return new Segment();
        }
        if (first == null) {
            atomicReferenceFirstRef.set(null);
            return new Segment();
        }
        atomicReferenceFirstRef.set(first.next);
        first.next = null;
        first.limit = 0;
        return first;
    }

    @JvmStatic
    public static final void recycle(Segment segment) {
        AtomicReference<Segment> atomicReferenceFirstRef;
        Segment first;
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.shared || (first = (atomicReferenceFirstRef = INSTANCE.firstRef()).getAndSet(LOCK)) == LOCK) {
            return;
        }
        int firstLimit = first != null ? first.limit : 0;
        if (firstLimit >= MAX_SIZE) {
            atomicReferenceFirstRef.set(first);
            return;
        }
        segment.next = first;
        segment.pos = 0;
        segment.limit = firstLimit + 8192;
        atomicReferenceFirstRef.set(segment);
    }

    private final AtomicReference<Segment> firstRef() {
        int hashBucket = (int) (Thread.currentThread().getId() & (((long) HASH_BUCKET_COUNT) - 1));
        return hashBuckets[hashBucket];
    }
}
