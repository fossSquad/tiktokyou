package ni.shikatu.kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.CollectionToArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\t\bB¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0082\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0016\u001a\u00020\fH\u0096\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0002H\u0096\u0082\u0004J\u0018\u0010\u0019\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0096\u0080\u0004J\u0012\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0096\u0082\u0004J\u0012\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0002H\u0096\u0080\u0004J\u0012\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0002H\u0096\u0080\u0004J\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0096\u0082\u0004J\u0010\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0096\u0080\u0004J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#2\u0006\u0010\u001d\u001a\u00020\u0010H\u0096\u0080\u0004J \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010'\u001a\u00020\u000eH\u0082\u0080\u0004R\u000f\u0010\t\u001a\u00020\nX\u0082Ô\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0013\u001a\u00020\u00108VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lni/shikatu/kotlin/collections/EmptyList;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "size", "getSize", "()I", "isEmpty", "contains", "element", "containsAll", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "get", "index", "indexOf", "lastIndexOf", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "listIterator", _UrlKt.FRAGMENT_ENCODE_SET, "subList", "fromIndex", "toIndex", "readResolve", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class EmptyList implements List, Serializable, RandomAccess, KMappedMarker {
    public static final EmptyList INSTANCE = new EmptyList();
    private static final long serialVersionUID = -7390468764508069838L;

    @Override
    public /* bridge */  void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int i, Void r4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Void remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void set(int i, Void r4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    private EmptyList() {
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof Void) {
            return contains((Void) element);
        }
        return false;
    }

    @Override
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof Void) {
            return indexOf((Void) element);
        }
        return -1;
    }

    @Override
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof Void) {
            return lastIndexOf((Void) element);
        }
        return -1;
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof List) && ((List) other).isEmpty();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    public boolean contains(Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return false;
    }

    @Override
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.isEmpty();
    }

    @Override
    public Void get(int index) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + index + '.');
    }

    public int indexOf(Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return -1;
    }

    public int lastIndexOf(Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return -1;
    }

    @Override
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override
    public ListIterator listIterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override
    public ListIterator listIterator(int index) {
        if (index != 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return EmptyIterator.INSTANCE;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex == 0 && toIndex == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex);
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
