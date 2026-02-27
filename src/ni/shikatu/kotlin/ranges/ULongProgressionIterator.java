package ni.shikatu.kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u0010\u0010\r\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0010\u0010\t\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\r\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/ranges/ULongProgressionIterator;", "", "Lni/shikatu/kotlin/ULong;", "first", "last", "step", "", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "next-s-VKNKU", "()J", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ULongProgressionIterator implements Iterator<ULong>, KMappedMarker {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    public  ULongProgressionIterator(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  ULong next() {
        return ULong.m172boximpl(m1255nextsVKNKU());
    }

    private ULongProgressionIterator(long first, long last, long step) {
        this.finalElement = last;
        boolean z = true;
        if (step <= 0 ? Long.compareUnsigned(first, last) < 0 : Long.compareUnsigned(first, last) > 0) {
            z = false;
        }
        this.hasNext = z;
        this.step = ULong.m178constructorimpl(step);
        this.next = this.hasNext ? first : this.finalElement;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    public long m1255nextsVKNKU() {
        long value = this.next;
        if (value == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next = ULong.m178constructorimpl(this.next + this.step);
        }
        return value;
    }
}
