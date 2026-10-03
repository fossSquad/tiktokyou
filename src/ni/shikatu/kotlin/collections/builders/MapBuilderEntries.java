package ni.shikatu.kotlin.collections.builders;
import java.util.Map.Entry;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001d\b@\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\u001e\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u001e\u0010\u0016\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0080\bJ$\u0010\u0017\u001a\u00020\u00102\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0019H\u0096\u0080\bJ\u001e\u0010\u001a\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0080\bJ\u001c\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u001cH\u0096\u0082\u0004J$\u0010\u001d\u001a\u00020\u00102\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0019H\u0096\u0080\u0004J$\u0010\u001e\u001a\u00020\u00102\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0019H\u0096\u0080\bJ$\u0010\u001f\u001a\u00020\u00102\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0019H\u0096\u0080\bR!\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilderEntries;", "K", "V", "Lni/shikatu/kotlin/collections/builders/AbstractMapBuilderEntrySet;", _UrlKt.FRAGMENT_ENCODE_SET, "backing", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "getBacking", "()Lkotlin/collections/builders/MapBuilder;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "getSize", "()I", "isEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "containsEntry", "element", _UrlKt.FRAGMENT_ENCODE_SET, "clear", _UrlKt.FRAGMENT_ENCODE_SET, "add", "addAll", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "remove", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "containsAll", "removeAll", "retainAll", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MapBuilderEntries<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {
    private final MapBuilder<K, V> backing;

    public MapBuilderEntries(MapBuilder<K, V> mapBuilder) {
        Intrinsics.checkNotNullParameter(mapBuilder, "backing");
        this.backing = mapBuilder;
    }

    public final MapBuilder<K, V> getBacking() {
        return this.backing;
    }

    @Override
    public int getSize() {
        return this.backing.size();
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public boolean containsEntry(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        return this.backing.containsEntry$kotlin_stdlib(entry);
    }

    @Override
    public void clear() {
        this.backing.clear();
    }

    @Override
    public boolean add(Map.Entry<K, V> entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Map.Entry<K, V> entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        return this.backing.removeEntry$kotlin_stdlib(entry);
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.backing.entriesIterator$kotlin_stdlib();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.backing.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
