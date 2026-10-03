package ni.shikatu.kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.AbstractMutableList;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableList;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableListIterator;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0000\u0018\u0000 R*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003RSTB\u0013\bF\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0086\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0082\u0080\u0004J\n\u0010\u0019\u001a\u00020\u0011H\u0096\u0080\u0004J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\tH\u0096\u0082\u0004¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0082\b¢\u0006\u0002\u0010\u001fJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010!J\u0010\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0082\u0004J\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0096\u0080\u0004J\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u0006\u0010\u001b\u001a\u00020\tH\u0096\u0080\u0004J\u0017\u0010'\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010(J\u001f\u0010'\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0080\bJ \u0010+\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0080\bJ\n\u0010.\u001a\u00020)H\u0096\u0080\u0004J\u001b\u0010/\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\tH\u0097\u0080\bb\u0002\b0¢\u0006\u0002\u0010\u001cJ\u0017\u00101\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010(J\u0018\u00102\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0080\bJ\u0018\u00103\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0080\bJ \u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0096\u0080\u0004J'\u00107\u001a\b\u0012\u0004\u0012\u0002H80\r\"\u0004\b\u0001\u001082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H80\rH\u0016¢\u0006\u0002\u0010:J\u0015\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\rH\u0016¢\u0006\u0002\u0010;J\u0014\u0010<\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010>\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010?\u001a\u00020@H\u0096\u0080\u0004J\n\u0010A\u001a\u00020)H\u0082\u0080\u0004J\n\u0010B\u001a\u00020)H\u0082\u0080\u0004J\u0012\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\tH\u0082\u0080\u0004J\u0012\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020\tH\u0082\u0080\u0004J\u0016\u0010G\u001a\u00020\u00112\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0082\u0080\u0004J\u001a\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020\t2\u0006\u0010D\u001a\u00020\tH\u0082\u0080\u0004J\u001f\u0010J\u001a\u00020)2\u0006\u0010I\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010*J(\u0010K\u001a\u00020)2\u0006\u0010I\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010D\u001a\u00020\tH\u0082\u0080\u0004J\u0017\u0010L\u001a\u00028\u00002\u0006\u0010I\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010\u001cJ\u001a\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004J0\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010Q\u001a\u00020\u0011H\u0082\u0080\u0004R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u000eR\u000f\u0010\u000f\u001a\u00020\tX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0010\u001a\u00020\u0011X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0016\u001a\u00020\t8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006U"}, d2 = {"Lni/shikatu/kotlin/collections/builders/ListBuilder;", "E", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "Lni/shikatu/kotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "initialCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(I)V", "backing", _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/Object;", "length", "isReadOnly", _UrlKt.FRAGMENT_ENCODE_SET, "build", _UrlKt.FRAGMENT_ENCODE_SET, "writeReplace", _UrlKt.FRAGMENT_ENCODE_SET, "size", "getSize", "()I", "isEmpty", "get", "index", "(I)Ljava/lang/Object;", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "listIterator", _UrlKt.FRAGMENT_ENCODE_SET, "add", "(Ljava/lang/Object;)Z", _UrlKt.FRAGMENT_ENCODE_SET, "(ILjava/lang/Object;)V", "addAll", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "clear", "removeAt", "Lni/shikatu/kotlin/IgnorableReturnValue;", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "registerModification", "checkIsMutable", "ensureExtraCapacity", "n", "ensureCapacityInternal", "minCapacity", "contentEquals", "insertAtInternal", "i", "addAtInternal", "addAllInternal", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainOrRemoveAllInternal", "retain", "Companion", "Itr", "BuilderSubList", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    private static final Companion Companion = new Companion(null);
    private static final ListBuilder Empty;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    public ListBuilder() {
        this(0, 1, null);
    }

    public ListBuilder(int i) {
        this.backing = (E[]) ListBuilderKt.arrayOfUninitializedElements(i);
    }

    public  ListBuilder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/collections/builders/ListBuilder$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "Empty", "Lni/shikatu/kotlin/collections/builders/ListBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        ListBuilder it = new ListBuilder(0);
        it.isReadOnly = true;
        Empty = it;
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        return this.length > 0 ? this : Empty;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override
    public int getSize() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public E get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.backing[index];
    }

    @Override
    public E set(int index, E e) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        E e2 = this.backing[index];
        this.backing[index] = e;
        return e2;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.backing[i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.backing[i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        return new Itr(this, index);
    }

    @Override
    public boolean add(E e) {
        checkIsMutable();
        addAtInternal(this.length, e);
        return true;
    }

    @Override
    public void add(int index, E e) {
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        addAtInternal(index, e);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        int n = collection.size();
        addAllInternal(this.length, collection, n);
        return n > 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        int n = collection.size();
        addAllInternal(index, collection, n);
        return n > 0;
    }

    @Override
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @IgnorableReturnValue
    public E removeAt(int index) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return removeAtInternal(index);
    }

    @Override
    public boolean remove(Object element) {
        checkIsMutable();
        int i = indexOf(element);
        if (i >= 0) {
            removeAt(i);
        }
        return i >= 0;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        return (boolean) ((Collection<? extends E>) (retainOrRemoveAllInternal(0, this.length, collection, false) > 0));
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        return (boolean) ((Collection<? extends E>) (retainOrRemoveAllInternal(0, this.length, collection, true) > 0));
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        return new BuilderSubList(this.backing, fromIndex, toIndex - fromIndex, null, this);
    }

    @Override
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (tArr.length < this.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(this.backing, 0, this.length, tArr.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr2, "copyOfRange(...)");
            return tArr2;
        }
        ArraysKt.copyInto(this.backing, tArr, 0, 0, this.length);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, tArr);
    }

    @Override
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }

    @Override
    public boolean equals(Object other) {
        return other == this || ((other instanceof List) && contentEquals((List) other));
    }

    @Override
    public int hashCode() {
        return ListBuilderKt.subarrayContentHashCode(this.backing, 0, this.length);
    }

    @Override
    public String toString() {
        return ListBuilderKt.subarrayContentToString(this.backing, 0, this.length, this);
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final void ensureExtraCapacity(int n) {
        ensureCapacityInternal(this.length + n);
    }

    private final void ensureCapacityInternal(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > this.backing.length) {
            this.backing = (E[]) ListBuilderKt.copyOfUninitializedElements(this.backing, AbstractList.Companion.newCapacity$kotlin_stdlib(this.backing.length, i));
        }
    }

    private final boolean contentEquals(List<?> list) {
        return ListBuilderKt.subarrayContentEquals(this.backing, 0, this.length, list);
    }

    private final void insertAtInternal(int i, int n) {
        ensureExtraCapacity(n);
        ArraysKt.copyInto(this.backing, this.backing, i + n, i, this.length);
        this.length += n;
    }

    public final void addAtInternal(int i, E e) {
        registerModification();
        insertAtInternal(i, 1);
        this.backing[i] = e;
    }

    public final void addAllInternal(int i, Collection<? extends E> collection, int n) {
        registerModification();
        insertAtInternal(i, n);
        Iterator<? extends E> it = collection.iterator();
        for (int j = 0; j < n; j++) {
            this.backing[i + j] = it.next();
        }
    }

    public final E removeAtInternal(int i) {
        registerModification();
        E e = this.backing[i];
        ArraysKt.copyInto(this.backing, this.backing, i, i + 1, this.length);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        this.length--;
        return e;
    }

    public final void removeRangeInternal(int rangeOffset, int rangeLength) {
        if (rangeLength > 0) {
            registerModification();
        }
        ArraysKt.copyInto(this.backing, this.backing, rangeOffset, rangeOffset + rangeLength, this.length);
        ListBuilderKt.resetRange(this.backing, this.length - rangeLength, this.length);
        this.length -= rangeLength;
    }

    public final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> collection, boolean retain) {
        int i = 0;
        int j = 0;
        while (i < rangeLength) {
            if (collection.contains(this.backing[rangeOffset + i]) == retain) {
                this.backing[j + rangeOffset] = this.backing[i + rangeOffset];
                j++;
                i++;
            } else {
                i++;
            }
        }
        int removed = rangeLength - j;
        ArraysKt.copyInto(this.backing, this.backing, rangeOffset + j, rangeOffset + rangeLength, this.length);
        ListBuilderKt.resetRange(this.backing, this.length - removed, this.length);
        if (removed > 0) {
            registerModification();
        }
        this.length -= removed;
        return removed;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\bF\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\fH\u0096\u0082\u0004J\n\u0010\u000e\u001a\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0006H\u0096\u0080\u0004J\u000f\u0010\u0010\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0012\u001a\u00028\u0001H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0016J\n\u0010\u0018\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u0014H\u0082\u0080\u0004R\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lni/shikatu/kotlin/collections/builders/ListBuilder$Itr;", "E", _UrlKt.FRAGMENT_ENCODE_SET, "list", "Lni/shikatu/kotlin/collections/builders/ListBuilder;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "expectedModCount", "hasPrevious", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "set", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Object;)V", "add", "remove", "checkForComodification", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> listBuilder, int index) {
            Intrinsics.checkNotNullParameter(listBuilder, "list");
            this.list = listBuilder;
            this.index = index;
            this.lastIndex = -1;
            this.expectedModCount = this.list.modCount;
        }

        @Override
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < ((ListBuilder) this.list).length;
        }

        @Override
        public int previousIndex() {
            return this.index - 1;
        }

        @Override
        public int nextIndex() {
            return this.index;
        }

        @Override
        public E previous() {
            checkForComodification();
            if (this.index <= 0) {
                throw new NoSuchElementException();
            }
            this.index--;
            this.lastIndex = this.index;
            return (E) ((ListBuilder) this.list).backing[this.lastIndex];
        }

        @Override
        public E next() {
            checkForComodification();
            if (this.index >= ((ListBuilder) this.list).length) {
                throw new NoSuchElementException();
            }
            int i = this.index;
            this.index = i + 1;
            this.lastIndex = i;
            return (E) ((ListBuilder) this.list).backing[this.lastIndex];
        }

        @Override
        public void set(E e) {
            checkForComodification();
            if (!(this.lastIndex != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.list.set(this.lastIndex, e);
        }

        @Override
        public void add(E e) {
            checkForComodification();
            ListBuilder<E> listBuilder = this.list;
            int i = this.index;
            this.index = i + 1;
            listBuilder.add(i, e);
            this.lastIndex = -1;
            this.expectedModCount = this.list.modCount;
        }

        @Override
        public void remove() {
            checkForComodification();
            if (!(this.lastIndex != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.list.removeAt(this.lastIndex);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = this.list.modCount;
        }

        private final void checkForComodification() {
            if (this.list.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001UBE\bF\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0013\u001a\u00020\u0014H\u0082\u0080\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082\u0080\u0004J\n\u0010\u001c\u001a\u00020\u001dH\u0096\u0080\u0004J\u0017\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u000bH\u0096\u0082\u0004¢\u0006\u0002\u0010 J\u001f\u0010!\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0096\u0082\b¢\u0006\u0002\u0010#J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010%J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010%J\u0010\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010(H\u0096\u0082\u0004J\u0010\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010*H\u0096\u0080\u0004J\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010*2\u0006\u0010\u001f\u001a\u00020\u000bH\u0096\u0080\u0004J\u0017\u0010+\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00028\u0001H\u0096\u0080\b¢\u0006\u0002\u0010,J\u001f\u0010+\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0096\u0080\bJ \u0010.\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0096\u0080\bJ\n\u00101\u001a\u00020\u0016H\u0096\u0080\u0004J\u001b\u00102\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u000bH\u0097\u0080\bb\u0002\b3¢\u0006\u0002\u0010 J\u0017\u00104\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00028\u0001H\u0096\u0080\b¢\u0006\u0002\u0010,J\u0018\u00105\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0096\u0080\bJ\u0018\u00106\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0096\u0080\bJ \u00107\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0096\u0080\u0004J'\u0010:\u001a\b\u0012\u0004\u0012\u0002H;0\t\"\u0004\b\u0002\u0010;2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H;0\tH\u0016¢\u0006\u0002\u0010=J\u0015\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\tH\u0016¢\u0006\u0002\u0010>J\u0014\u0010?\u001a\u00020\u001d2\b\u0010@\u001a\u0004\u0018\u00010\u0014H\u0096\u0082\u0004J\n\u0010A\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010B\u001a\u00020CH\u0096\u0080\u0004J\n\u0010D\u001a\u00020\u0016H\u0082\u0080\u0004J\n\u0010E\u001a\u00020\u0016H\u0082\u0080\u0004J\n\u0010F\u001a\u00020\u0016H\u0082\u0080\u0004J\u0016\u0010I\u001a\u00020\u001d2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030JH\u0082\u0080\u0004J\u001f\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0001H\u0082\u0080\u0004¢\u0006\u0002\u0010-J(\u0010M\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u0001002\u0006\u0010N\u001a\u00020\u000bH\u0082\u0080\u0004J\u0017\u0010O\u001a\u00028\u00012\u0006\u0010L\u001a\u00020\u000bH\u0082\u0080\u0004¢\u0006\u0002\u0010 J\u001a\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bH\u0082\u0080\u0004J0\u0010S\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u0001002\u0006\u0010T\u001a\u00020\u001dH\u0082\u0080\u0004R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u0012R\u000f\u0010\n\u001a\u00020\u000bX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\u000bX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0019\u001a\u00020\u000b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010G\u001a\u00020\u001d8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006V"}, d2 = {"Lni/shikatu/kotlin/collections/builders/ListBuilder$BuilderSubList;", "E", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "Lni/shikatu/kotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "backing", _UrlKt.FRAGMENT_ENCODE_SET, "offset", _UrlKt.FRAGMENT_ENCODE_SET, "length", "parent", "root", "Lni/shikatu/kotlin/collections/builders/ListBuilder;", "<init>", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "writeReplace", _UrlKt.FRAGMENT_ENCODE_SET, "readObject", _UrlKt.FRAGMENT_ENCODE_SET, "input", "Ljava/io/ObjectInputStream;", "size", "getSize", "()I", "isEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "get", "index", "(I)Ljava/lang/Object;", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "listIterator", _UrlKt.FRAGMENT_ENCODE_SET, "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "clear", "removeAt", "Lni/shikatu/kotlin/IgnorableReturnValue;", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "registerModification", "checkForComodification", "checkIsMutable", "isReadOnly", "()Z", "contentEquals", _UrlKt.FRAGMENT_ENCODE_SET, "addAtInternal", "i", "addAllInternal", "n", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainOrRemoveAllInternal", "retain", "Itr", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        public BuilderSubList(E[] eArr, int offset, int length, BuilderSubList<E> builderSubList, ListBuilder<E> listBuilder) {
            Intrinsics.checkNotNullParameter(eArr, "backing");
            Intrinsics.checkNotNullParameter(listBuilder, "root");
            this.backing = eArr;
            this.offset = offset;
            this.length = length;
            this.parent = builderSubList;
            this.root = listBuilder;
            this.modCount = this.root.modCount;
        }

        private final Object writeReplace() throws NotSerializableException {
            if (isReadOnly()) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        private final void readObject(ObjectInputStream input) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        @Override
        public int getSize() {
            checkForComodification();
            return this.length;
        }

        @Override
        public boolean isEmpty() {
            checkForComodification();
            return this.length == 0;
        }

        @Override
        public E get(int index) {
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            return this.backing[this.offset + index];
        }

        @Override
        public E set(int index, E e) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            E e2 = this.backing[this.offset + index];
            this.backing[this.offset + index] = e;
            return e2;
        }

        @Override
        public int indexOf(Object element) {
            checkForComodification();
            for (int i = 0; i < this.length; i++) {
                if (Intrinsics.areEqual(this.backing[this.offset + i], element)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object element) {
            checkForComodification();
            for (int i = this.length - 1; i >= 0; i--) {
                if (Intrinsics.areEqual(this.backing[this.offset + i], element)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            return new Itr(this, index);
        }

        @Override
        public boolean add(E e) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, e);
            return true;
        }

        @Override
        public void add(int index, E e) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            addAtInternal(this.offset + index, e);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            checkIsMutable();
            checkForComodification();
            int n = collection.size();
            addAllInternal(this.offset + this.length, collection, n);
            return n > 0;
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            int n = collection.size();
            addAllInternal(this.offset + index, collection, n);
            return n > 0;
        }

        @Override
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @IgnorableReturnValue
        public E removeAt(int index) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            return removeAtInternal(this.offset + index);
        }

        @Override
        public boolean remove(Object element) {
            checkIsMutable();
            checkForComodification();
            int i = indexOf(element);
            if (i >= 0) {
                removeAt(i);
            }
            return i >= 0;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            checkIsMutable();
            checkForComodification();
            return (boolean) ((Collection<? extends E>) (retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0));
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            checkIsMutable();
            checkForComodification();
            return (Collection<? extends E>) (retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0);
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
            return new BuilderSubList(this.backing, this.offset + fromIndex, toIndex - fromIndex, this, this.root);
        }

        @Override
        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            checkForComodification();
            if (tArr.length < this.length) {
                T[] tArr2 = (T[]) Arrays.copyOfRange(this.backing, this.offset, this.offset + this.length, tArr.getClass());
                Intrinsics.checkNotNullExpressionValue(tArr2, "copyOfRange(...)");
                return tArr2;
            }
            ArraysKt.copyInto(this.backing, tArr, 0, this.offset, this.offset + this.length);
            return (T[]) CollectionsKt.terminateCollectionToArray(this.length, tArr);
        }

        @Override
        public Object[] toArray() {
            checkForComodification();
            return ArraysKt.copyOfRange(this.backing, this.offset, this.offset + this.length);
        }

        @Override
        public boolean equals(Object other) {
            checkForComodification();
            return other == this || ((other instanceof List) && contentEquals((List) other));
        }

        @Override
        public int hashCode() {
            checkForComodification();
            return ListBuilderKt.subarrayContentHashCode(this.backing, this.offset, this.length);
        }

        @Override
        public String toString() {
            checkForComodification();
            return ListBuilderKt.subarrayContentToString(this.backing, this.offset, this.length, this);
        }

        private final void registerModification() {
            this.modCount++;
        }

        private final void checkForComodification() {
            if (this.root.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void checkIsMutable() {
            if (isReadOnly()) {
                throw new UnsupportedOperationException();
            }
        }

        private final boolean isReadOnly() {
            return ((ListBuilder) this.root).isReadOnly;
        }

        private final boolean contentEquals(List<?> list) {
            return ListBuilderKt.subarrayContentEquals(this.backing, this.offset, this.length, list);
        }

        private final void addAtInternal(int i, E e) {
            registerModification();
            if (this.parent == null) {
                this.root.addAtInternal(i, e);
            } else {
                this.parent.addAtInternal(i, e);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length++;
        }

        private final void addAllInternal(int i, Collection<? extends E> collection, int i2) {
            registerModification();
            if (this.parent == null) {
                this.root.addAllInternal(i, collection, i2);
            } else {
                this.parent.addAllInternal(i, collection, i2);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length += i2;
        }

        private final E removeAtInternal(int i) {
            E eRemoveAtInternal;
            registerModification();
            if (this.parent == null) {
                eRemoveAtInternal = (E) this.root.removeAtInternal(i);
            } else {
                eRemoveAtInternal = this.parent.removeAtInternal(i);
            }
            this.length--;
            return eRemoveAtInternal;
        }

        private final void removeRangeInternal(int rangeOffset, int rangeLength) {
            if (rangeLength > 0) {
                registerModification();
            }
            if (this.parent == null) {
                this.root.removeRangeInternal(rangeOffset, rangeLength);
            } else {
                this.parent.removeRangeInternal(rangeOffset, rangeLength);
            }
            this.length -= rangeLength;
        }

        private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> collection, boolean retain) {
            int removed;
            if (this.parent == null) {
                removed = this.root.retainOrRemoveAllInternal(rangeOffset, rangeLength, collection, retain);
            } else {
                removed = this.parent.retainOrRemoveAllInternal(rangeOffset, rangeLength, collection, retain);
            }
            if (removed > 0) {
                registerModification();
            }
            this.length -= removed;
            return removed;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\bF\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\fH\u0096\u0082\u0004J\n\u0010\u000e\u001a\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0006H\u0096\u0080\u0004J\u000f\u0010\u0010\u001a\u00028\u0002H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0012\u001a\u00028\u0002H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0002H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0002H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0016J\n\u0010\u0018\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u0014H\u0082\u0080\u0004R\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lni/shikatu/kotlin/collections/builders/ListBuilder$BuilderSubList$Itr;", "E", _UrlKt.FRAGMENT_ENCODE_SET, "list", "Lni/shikatu/kotlin/collections/builders/ListBuilder$BuilderSubList;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/collections/builders/ListBuilder$BuilderSubList;I)V", "lastIndex", "expectedModCount", "hasPrevious", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "set", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Object;)V", "add", "remove", "checkForComodification", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
        private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
            private int expectedModCount;
            private int index;
            private int lastIndex;
            private final BuilderSubList<E> list;

            public Itr(BuilderSubList<E> builderSubList, int index) {
                Intrinsics.checkNotNullParameter(builderSubList, "list");
                this.list = builderSubList;
                this.index = index;
                this.lastIndex = -1;
                this.expectedModCount = this.list.modCount;
            }

            @Override
            public boolean hasPrevious() {
                return this.index > 0;
            }

            @Override
            public boolean hasNext() {
                return this.index < ((BuilderSubList) this.list).length;
            }

            @Override
            public int previousIndex() {
                return this.index - 1;
            }

            @Override
            public int nextIndex() {
                return this.index;
            }

            @Override
            public E previous() {
                checkForComodification();
                if (this.index <= 0) {
                    throw new NoSuchElementException();
                }
                this.index--;
                this.lastIndex = this.index;
                return (E) ((BuilderSubList) this.list).backing[((BuilderSubList) this.list).offset + this.lastIndex];
            }

            @Override
            public E next() {
                checkForComodification();
                if (this.index >= ((BuilderSubList) this.list).length) {
                    throw new NoSuchElementException();
                }
                int i = this.index;
                this.index = i + 1;
                this.lastIndex = i;
                return (E) ((BuilderSubList) this.list).backing[((BuilderSubList) this.list).offset + this.lastIndex];
            }

            @Override
            public void set(E e) {
                checkForComodification();
                if (!(this.lastIndex != -1)) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
                }
                this.list.set(this.lastIndex, e);
            }

            @Override
            public void add(E e) {
                checkForComodification();
                BuilderSubList<E> builderSubList = this.list;
                int i = this.index;
                this.index = i + 1;
                builderSubList.add(i, e);
                this.lastIndex = -1;
                this.expectedModCount = this.list.modCount;
            }

            @Override
            public void remove() {
                checkForComodification();
                if (!(this.lastIndex != -1)) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
                }
                this.list.removeAt(this.lastIndex);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = this.list.modCount;
            }

            private final void checkForComodification() {
                if (((BuilderSubList) this.list).root.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
