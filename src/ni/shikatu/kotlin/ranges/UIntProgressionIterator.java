package ni.shikatu.kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000b\u001a\u00020\fH\u0096\u0082\u0004J\u0011\u0010\r\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\r\u001a\u00020\u0002X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\nÊ\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/ranges/UIntProgressionIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UInt;", "first", "last", "step", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "next-pVg5ArA", "()I", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public  UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private UIntProgressionIterator(int first, int last, int step) {
        this.finalElement = last;
        boolean z = true;
        int iCompareUnsigned = Integer.compareUnsigned(first, last);
        if (step <= 0 ? iCompareUnsigned < 0 : iCompareUnsigned > 0) {
            z = false;
        }
        this.hasNext = z;
        this.step = UInt.m101constructorimpl(step);
        this.next = this.hasNext ? first : this.finalElement;
    }

    @Override
    public /* bridge */  UInt next() {
        return UInt.m95boximpl(m1268nextpVg5ArA());
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    public int m1268nextpVg5ArA() {
        int value = this.next;
        if (value == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next = UInt.m101constructorimpl(this.next + this.step);
        }
        return value;
    }
}
