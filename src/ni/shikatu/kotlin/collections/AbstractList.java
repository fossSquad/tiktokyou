package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000  *\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001d\u001e\u001f B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0007H¦\u0082\u0004¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0096\u0082\u0004J\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0080\u0004J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0080\u0004J \u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0080\u0004J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0082\u0004J\n\u0010\u001c\u001a\u00020\u0007H\u0096\u0080\u0004R\u0013\u0010\u0006\u001a\u00020\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tÊ\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\b($¨\u0006!"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractList;", "E", "Lni/shikatu/kotlin/collections/AbstractCollection;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "size", _UrlKt.FRAGMENT_ENCODE_SET, "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "indexOf", "element", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", _UrlKt.FRAGMENT_ENCODE_SET, "subList", "fromIndex", "toIndex", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "SubList", "IteratorImpl", "ListIteratorImpl", "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private static final int maxArraySize = 2147483639;

    @Override
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public abstract E get(int i);

    @Override
    public abstract int getSize();

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected AbstractList() {
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public int indexOf(Object element) {
        AbstractList<E> $this$indexOfFirst$iv = this;
        int index$iv = 0;
        for (Object item$iv : $this$indexOfFirst$iv) {
            if (Intrinsics.areEqual(item$iv, element)) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        AbstractList<E> $this$indexOfLast$iv = this;
        ListIterator<E> listIterator = $this$indexOfLast$iv.listIterator($this$indexOfLast$iv.size());
        while (listIterator.hasPrevious()) {
            Object it = listIterator.previous();
            if (Intrinsics.areEqual(it, element)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListIteratorImpl(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return new SubList(this, fromIndex, toIndex);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B'\bF\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00028\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000eJ \u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000f\u001a\u00020\u00078VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractList$SubList;", "E", "Lni/shikatu/kotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "list", "fromIndex", _UrlKt.FRAGMENT_ENCODE_SET, "toIndex", "<init>", "(Lkotlin/collections/AbstractList;II)V", "_size", "get", "index", "(I)Ljava/lang/Object;", "size", "getSize", "()I", "subList", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        private int _size;
        private final int fromIndex;
        private final AbstractList<E> list;

        public SubList(AbstractList<? extends E> abstractList, int fromIndex, int toIndex) {
            Intrinsics.checkNotNullParameter(abstractList, "list");
            this.list = abstractList;
            this.fromIndex = fromIndex;
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(this.fromIndex, toIndex, this.list.size());
            this._size = toIndex - this.fromIndex;
        }

        @Override
        public E get(int index) {
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this._size);
            return this.list.get(this.fromIndex + index);
        }

        @Override
        public int getSize() {
            return this._size;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this._size);
            return new SubList(this.list, this.fromIndex + fromIndex, this.fromIndex + toIndex);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof List) {
            return Companion.orderedEquals$kotlin_stdlib(this, (Collection) other);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Companion.orderedHashCode$kotlin_stdlib(this);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u00020\u000bH\u0096\u0082\u0004J\u000f\u0010\f\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\rR\u001b\u0010\u0004\u001a\u00020\u0005X\u0084\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractList$IteratorImpl;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/collections/AbstractList;)V", "index", _UrlKt.FRAGMENT_ENCODE_SET, "getIndex", "()I", "setIndex", "(I)V", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private class IteratorImpl implements Iterator<E>, KMappedMarker {
        private int index;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public IteratorImpl() {
        }

        protected final int getIndex() {
            return this.index;
        }

        protected final void setIndex(int i) {
            this.index = i;
        }

        @Override
        public boolean hasNext() {
            return this.index < AbstractList.this.size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractList<E> abstractList = AbstractList.this;
            int i = this.index;
            this.index = i + 1;
            return abstractList.get(i);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0092\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\bF\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\n\u001a\u00020\u0005H\u0096\u0080\u0004J\u000f\u0010\u000b\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u00020\u0005H\u0096\u0080\u0004¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractList$ListIteratorImpl;", "Lni/shikatu/kotlin/collections/AbstractList$IteratorImpl;", "Lni/shikatu/kotlin/collections/AbstractList;", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", _UrlKt.FRAGMENT_ENCODE_SET, "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E>, KMappedMarker {
        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public ListIteratorImpl(int index) {
            super();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, AbstractList.this.size());
            setIndex(index);
        }

        @Override
        public boolean hasPrevious() {
            return getIndex() > 0;
        }

        @Override
        public int nextIndex() {
            return getIndex();
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractList<E> abstractList = AbstractList.this;
            setIndex(getIndex() - 1);
            return abstractList.get(getIndex());
        }

        @Override
        public int previousIndex() {
            return getIndex() - 1;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\tJ\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u000bJ'\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u000fJ'\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u0013J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u0018J\u001b\u0010\u0019\u001a\u00020\u00072\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0080\u0080\u0004¢\u0006\u0002\b\u001cJ'\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0080\u0080\u0004¢\u0006\u0002\b R\u000f\u0010\u0014\u001a\u00020\u0007X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractList$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "checkElementIndex", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "size", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "checkBoundsIndexes", "startIndex", "endIndex", "checkBoundsIndexes$kotlin_stdlib", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedHashCode", "c", _UrlKt.FRAGMENT_ENCODE_SET, "orderedHashCode$kotlin_stdlib", "orderedEquals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "orderedEquals$kotlin_stdlib", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void checkElementIndex$kotlin_stdlib(int index, int size) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int index, int size) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int fromIndex, int toIndex, int size) {
            if (fromIndex < 0 || toIndex > size) {
                throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", size: " + size);
            }
            if (fromIndex > toIndex) {
                throw new IllegalArgumentException("fromIndex: " + fromIndex + " > toIndex: " + toIndex);
            }
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int startIndex, int endIndex, int size) {
            if (startIndex < 0 || endIndex > size) {
                throw new IndexOutOfBoundsException("startIndex: " + startIndex + ", endIndex: " + endIndex + ", size: " + size);
            }
            if (startIndex > endIndex) {
                throw new IllegalArgumentException("startIndex: " + startIndex + " > endIndex: " + endIndex);
            }
        }

        public final int newCapacity$kotlin_stdlib(int oldCapacity, int minCapacity) {
            int newCapacity = (oldCapacity >> 1) + oldCapacity;
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            int newCapacity2 = AbstractList.maxArraySize;
            if (newCapacity - AbstractList.maxArraySize > 0) {
                if (minCapacity > AbstractList.maxArraySize) {
                    newCapacity2 = IntCompanionObject.MAX_VALUE;
                }
                return newCapacity2;
            }
            return newCapacity;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> collection) {
            Intrinsics.checkNotNullParameter(collection, "c");
            int hashCode = 1;
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                Object e = it.next();
                hashCode = (hashCode * 31) + (e != null ? e.hashCode() : 0);
            }
            return hashCode;
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> collection, Collection<?> collection2) {
            Intrinsics.checkNotNullParameter(collection, "c");
            Intrinsics.checkNotNullParameter(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            for (Object elem : collection) {
                Object elemOther = it.next();
                if (!Intrinsics.areEqual(elem, elemOther)) {
                    return false;
                }
            }
            return true;
        }
    }
}
