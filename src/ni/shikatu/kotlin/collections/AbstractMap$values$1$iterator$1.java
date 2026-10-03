package ni.shikatu.kotlin.collections;
import java.util.Map.Entry;

import java.util.Iterator;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\n\u0010\u0002\u001a\u00020\u0003H\u0096\u0082\u0004J\u000f\u0010\u0004\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"ni/shikatu/kotlin/collections/AbstractMap$values$1$iterator$1", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AbstractMap$values$1$iterator$1<V, K> implements Iterator<V>, KMappedMarker {
    final  Iterator<Map.Entry<K, V>> $entryIterator;

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    AbstractMap$values$1$iterator$1(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        this.$entryIterator = (Iterator<Map.Entry<K, V>>) (it);
    }

    @Override
    public boolean hasNext() {
        return this.$entryIterator.hasNext();
    }

    @Override
    public V next() {
        return (V) ((Map.Entry) this.$entryIterator.next()).getValue();
    }
}
