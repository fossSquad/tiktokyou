package ni.shikatu.kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000b\u001a\u00020\fH\u0096\u0082\u0004J\u0011\u0010\r\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\r\u001a\u00020\u0002X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\nÊ\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/ranges/ULongProgressionIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ULong;", "first", "last", "step", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "next-s-VKNKU", "()J", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    private ULongProgressionIterator(long first, long last, long step) {
        this.finalElement = last;
        boolean z = true;
        if (step <= 0 ? Long.compareUnsigned(first, last) < 0 : Long.compareUnsigned(first, last) > 0) {
            z = false;
        }
        this.hasNext = z;
        this.step = ULong.m180constructorimpl(step);
        this.next = this.hasNext ? first : this.finalElement;
    }

    @Override
    public /* bridge */  ULong next() {
        return ULong.m174boximpl(m1277nextsVKNKU());
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    public long m1277nextsVKNKU() {
        long value = this.next;
        if (value == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next = ULong.m180constructorimpl(this.next + this.step);
        }
        return value;
    }
}
