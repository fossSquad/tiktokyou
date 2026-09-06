package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0004\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u0006\u001a\u00020\u0003H\u0096\u0082\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"ni/shikatu/kotlin/sequences/SequencesKt__SequencesKt$sequenceOf$1$1", _UrlKt.FRAGMENT_ENCODE_SET, "_hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", "hasNext", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SequencesKt__SequencesKt$sequenceOf$1$1<T> implements Iterator<T>, KMappedMarker {
    final  T $element;
    private boolean _hasNext = true;

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    SequencesKt__SequencesKt$sequenceOf$1$1(T t) {
        this.$element = t;
    }

    @Override
    public T next() {
        if (!this._hasNext) {
            throw new NoSuchElementException();
        }
        this._hasNext = false;
        return this.$element;
    }

    @Override
    public boolean hasNext() {
        return this._hasNext;
    }
}
