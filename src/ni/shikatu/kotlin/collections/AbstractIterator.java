package ni.shikatu.kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\t\u001a\u00020\nH\u0096\u0082\u0004J\u000f\u0010\u000b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u00020\nH\u0082\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000fH¤\u0080\u0004J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0084\u0080\u0004¢\u0006\u0002\u0010\u0012J\n\u0010\u0013\u001a\u00020\u000fH\u0084\u0080\u0004R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0014"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractIterator;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "state", _UrlKt.FRAGMENT_ENCODE_SET, "nextValue", "Ljava/lang/Object;", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", "tryToComputeNext", "computeNext", _UrlKt.FRAGMENT_ENCODE_SET, "setNext", "value", "(Ljava/lang/Object;)V", "done", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    private T nextValue;
    private int state;

    protected abstract void computeNext();

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean hasNext() {
        switch (this.state) {
            case 0:
                return tryToComputeNext();
            case 1:
                return true;
            case 2:
                return false;
            default:
                throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
        }
    }

    @Override
    public T next() {
        if (this.state == 1) {
            this.state = 0;
            return this.nextValue;
        }
        if (this.state == 2 || !tryToComputeNext()) {
            throw new NoSuchElementException();
        }
        this.state = 0;
        return this.nextValue;
    }

    private final boolean tryToComputeNext() {
        this.state = 3;
        computeNext();
        return this.state == 1;
    }

    protected final void setNext(T t) {
        this.nextValue = t;
        this.state = 1;
    }

    protected final void done() {
        this.state = 2;
    }
}
