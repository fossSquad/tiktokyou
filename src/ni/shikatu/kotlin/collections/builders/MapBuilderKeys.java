package ni.shikatu.kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractMutableSet;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableSet;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\b@\u0012\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0080\bJ\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0082\u0004J\u0018\u0010\u001a\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0080\bJ\u0018\u0010\u001b\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0080\bR\u0019\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u00020\t8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilderKeys;", "E", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/AbstractMutableSet;", "backing", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "size", _UrlKt.FRAGMENT_ENCODE_SET, "getSize", "()I", "isEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "contains", "element", "(Ljava/lang/Object;)Z", "clear", _UrlKt.FRAGMENT_ENCODE_SET, "add", "addAll", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "remove", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "removeAll", "retainAll", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MapBuilderKeys<E> extends AbstractMutableSet<E> implements Set<E>, KMutableSet {
    private final MapBuilder<E, ?> backing;

    public MapBuilderKeys(MapBuilder<E, ?> mapBuilder) {
        Intrinsics.checkNotNullParameter(mapBuilder, "backing");
        this.backing = mapBuilder;
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
    public boolean contains(Object element) {
        return this.backing.containsKey(element);
    }

    @Override
    public void clear() {
        this.backing.clear();
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object element) {
        return this.backing.removeKey$kotlin_stdlib(element);
    }

    @Override
    public Iterator<E> iterator() {
        return this.backing.keysIterator$kotlin_stdlib();
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
