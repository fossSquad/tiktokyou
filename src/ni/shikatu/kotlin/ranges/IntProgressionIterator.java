package ni.shikatu.kotlin.ranges;

import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.IntIterator;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000b\u001a\u00020\fH\u0096\u0082\u0004J\n\u0010\u000e\u001a\u00020\u0003H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000f\u0010\n\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\r\u001a\u00020\u0003X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/ranges/IntProgressionIterator;", "Lni/shikatu/kotlin/collections/IntIterator;", "first", _UrlKt.FRAGMENT_ENCODE_SET, "last", "step", "<init>", "(III)V", "getStep", "()I", "finalElement", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "nextInt", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class IntProgressionIterator extends IntIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public IntProgressionIterator(int first, int last, int step) {
        this.step = step;
        this.finalElement = last;
        boolean z = true;
        if (this.step <= 0 ? first < last : first > last) {
            z = false;
        }
        this.hasNext = z;
        this.next = this.hasNext ? first : this.finalElement;
    }

    public final int getStep() {
        return this.step;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public int nextInt() {
        int value = this.next;
        if (value == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next += this.step;
        }
        return value;
    }
}
