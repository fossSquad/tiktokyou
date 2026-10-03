package ni.shikatu.kotlin.collections;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0017\bF\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u00020\nH\u0086\u0082\u0004J\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0082\u0004R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lni/shikatu/kotlin/collections/IndexingIterator;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/IndexedValue;", "iterator", "<init>", "(Ljava/util/Iterator;)V", "index", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class IndexingIterator<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker {
    private int index;
    private final Iterator<T> iterator;

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public IndexingIterator(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "iterator");
        this.iterator = (Iterator<T>) (it);
    }

    @Override
    public final boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public final IndexedValue<T> next() {
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            CollectionsKt.throwIndexOverflow();
        }
        return new IndexedValue<>(i, this.iterator.next());
    }
}
