package ni.shikatu.kotlin.collections;
import java.util.Map.Entry;

import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\bF\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0082\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004R\u0017\u0010\u0004\u001a\u00028\u0000X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00028\u0001X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0014"}, d2 = {"Lni/shikatu/kotlin/collections/DetachedMapEntry;", "K", "V", _UrlKt.FRAGMENT_ENCODE_SET, "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class DetachedMapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {
    private final K key;
    private final V value;

    @Override
    public V setValue(V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public DetachedMapEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        return AbstractMap.Companion.entryEquals$kotlin_stdlib(this, other);
    }

    @Override
    public int hashCode() {
        return AbstractMap.Companion.entryHashCode$kotlin_stdlib(this);
    }

    public String toString() {
        return AbstractMap.Companion.entryToString$kotlin_stdlib(this);
    }
}
