package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ^*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001^B\u0011\bV\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\bV¢\u0006\u0004\b\u0005\u0010\u0007B\u0017\bV\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u0005\u0010\nJ\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0082\u0080\u0004J\u001b\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0004H\u0083\u0088\u0004b\u0002\b\u001c¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082\u0080\u0004J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0083\u0088\u0004b\u0002\b\u001cJ\u0012\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082\u0080\u0004J\n\u0010\"\u001a\u00020#H\u0096\u0080\u0004J\u000f\u0010$\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u0004\u0018\u00018\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010%J\u000f\u0010'\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010%J\u0011\u0010(\u001a\u0004\u0018\u00018\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010%J\u0017\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010+J\u0017\u0010,\u001a\u00020\u00152\u0006\u0010*\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010+J\u0013\u0010-\u001a\u00028\u0000H\u0087\u0080\bb\u0002\b.¢\u0006\u0002\u0010%J\u0015\u0010/\u001a\u0004\u0018\u00018\u0000H\u0087\u0080\bb\u0002\b.¢\u0006\u0002\u0010%J\u0013\u00100\u001a\u00028\u0000H\u0087\u0080\bb\u0002\b.¢\u0006\u0002\u0010%J\u0015\u00101\u001a\u0004\u0018\u00018\u0000H\u0087\u0080\bb\u0002\b.¢\u0006\u0002\u0010%J\u001b\u00102\u001a\u00020#2\u0006\u0010*\u001a\u00028\u0000H\u0097\u0080\bb\u0002\b.¢\u0006\u0002\u00103J\u001f\u00102\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010*\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u00104J \u00105\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0082\u0080\u0004J\u001c\u00106\u001a\u00020#2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bb\u0002\b.J$\u00106\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bb\u0002\b.J\u0017\u00107\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u0004H\u0096\u0082\u0004¢\u0006\u0002\u0010\u001bJ#\u00108\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010*\u001a\u00028\u0000H\u0097\u0082\bb\u0002\b.¢\u0006\u0002\u00109J\u0017\u0010:\u001a\u00020#2\u0006\u0010*\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u00103J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010*\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010<J\u0017\u0010=\u001a\u00020\u00042\u0006\u0010*\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010<J\u001b\u0010>\u001a\u00020#2\u0006\u0010*\u001a\u00028\u0000H\u0097\u0080\bb\u0002\b.¢\u0006\u0002\u00103J\u001b\u0010?\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u0004H\u0097\u0080\bb\u0002\b.¢\u0006\u0002\u0010\u001bJ\u001c\u0010@\u001a\u00020#2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bb\u0002\b.J\u001c\u0010A\u001a\u00020#2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bb\u0002\b.J\u001e\u0010B\u001a\u00020#2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0DH\u0082\u0088\u0004J\n\u0010E\u001a\u00020\u0015H\u0096\u0080\u0004J)\u0010F\u001a\b\u0012\u0004\u0012\u0002HG0\r\"\u0004\b\u0001\u0010G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HG0\rH\u0096\u0080\u0004¢\u0006\u0002\u0010IJ\u0017\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0096\u0080\u0004¢\u0006\u0002\u0010JJ\u001a\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0094\u0080\u0004J\u001a\u0010N\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0082\u0080\u0004J\u001a\u0010O\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0082\u0080\u0004J\u001a\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004H\u0082\u0080\u0004J\n\u0010S\u001a\u00020\u0015H\u0082\u0080\u0004J+\u0010T\u001a\b\u0012\u0004\u0012\u0002HG0\r\"\u0004\b\u0001\u0010G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HG0\rH\u0080\u0080\u0004¢\u0006\u0004\bU\u0010IJ\u0019\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0080\u0080\u0004¢\u0006\u0004\bU\u0010JJ\u001f\u0010V\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\bWJO\u0010X\u001a\u00020\u00152>\u0010Y\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00150ZH\u0080\u0080\u0004¢\u0006\u0002\b]R\u000f\u0010\u000b\u001a\u00020\u0004X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u000fR\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004@RX\u0096\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013Ê\u0001\f\b`\u0012\b\ba\u0012\u0004\b\b(b¨\u0006_"}, d2 = {"Lni/shikatu/kotlin/collections/ArrayDeque;", "E", "Lni/shikatu/kotlin/collections/AbstractMutableList;", "initialCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(I)V", "()V", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Collection;)V", "head", "elementData", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/Object;", "value", "size", "getSize", "()I", "ensureCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "minCapacity", "copyElements", "newCapacity", "internalGet", "internalIndex", "(I)Ljava/lang/Object;", "Lni/shikatu/kotlin/internal/InlineOnly;", "positiveMod", "index", "negativeMod", "incremented", "decremented", "isEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "first", "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "addFirst", "element", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "Lni/shikatu/kotlin/IgnorableReturnValue;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "copyCollectionElements", "addAll", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "filterInPlace", "predicate", "Lni/shikatu/kotlin/Function1;", "clear", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "removeRange", "fromIndex", "toIndex", "removeRangeShiftPreceding", "removeRangeShiftSucceeding", "nullifyNonEmpty", "internalFromIndex", "internalToIndex", "registerModification", "testToArray", "testToArray$kotlin_stdlib", "testRemoveRange", "testRemoveRange$kotlin_stdlib", "internalStructure", "structure", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    private static final int defaultMinCapacity = 10;
    private Object[] elementData;
    private int head;
    private int size;
    public static final Companion Companion = new Companion(null);
    private static final Object[] emptyElementData = new Object[0];

    @Override
    public int getSize() {
        return this.size;
    }

    public ArrayDeque(int initialCapacity) {
        Object[] objArr;
        if (initialCapacity == 0) {
            objArr = emptyElementData;
        } else {
            if (initialCapacity <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
            }
            objArr = new Object[initialCapacity];
        }
        this.elementData = objArr;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        this.elementData = collection.toArray(new Object[0]);
        this.size = this.elementData.length;
        if (this.elementData.length == 0) {
            this.elementData = emptyElementData;
        }
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        if (minCapacity <= this.elementData.length) {
            return;
        }
        if (this.elementData == emptyElementData) {
            this.elementData = new Object[RangesKt.coerceAtLeast(minCapacity, 10)];
        } else {
            int newCapacity = AbstractList.Companion.newCapacity$kotlin_stdlib(this.elementData.length, minCapacity);
            copyElements(newCapacity);
        }
    }

    private final void copyElements(int newCapacity) {
        Object[] newElements = new Object[newCapacity];
        ArraysKt.copyInto(this.elementData, newElements, 0, this.head, this.elementData.length);
        ArraysKt.copyInto(this.elementData, newElements, this.elementData.length - this.head, 0, this.head);
        this.head = 0;
        this.elementData = newElements;
    }

    private final E internalGet(int i) {
        return (E) this.elementData[i];
    }

    private final int positiveMod(int index) {
        return index >= this.elementData.length ? index - this.elementData.length : index;
    }

    private final int negativeMod(int index) {
        return index < 0 ? this.elementData.length + index : index;
    }

    private final int internalIndex(int index) {
        return positiveMod(this.head + index);
    }

    private final int incremented(int index) {
        if (index == ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    private final int decremented(int index) {
        return index == 0 ? ArraysKt.getLastIndex(this.elementData) : index - 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final void addFirst(E e) {
        registerModification();
        ensureCapacity(size() + 1);
        this.head = decremented(this.head);
        this.elementData[this.head] = e;
        this.size = size() + 1;
    }

    public final void addLast(E e) {
        registerModification();
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = e;
        this.size = size() + 1;
    }

    @IgnorableReturnValue
    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        E e = (E) this.elementData[this.head];
        this.elementData[this.head] = null;
        this.head = incremented(this.head);
        this.size = size() - 1;
        return e;
    }

    @IgnorableReturnValue
    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @IgnorableReturnValue
    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        int iPositiveMod = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        E e = (E) this.elementData[iPositiveMod];
        this.elementData[iPositiveMod] = null;
        this.size = size() - 1;
        return e;
    }

    @IgnorableReturnValue
    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override
    @IgnorableReturnValue
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public void add(int index, E e) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(e);
            return;
        }
        if (index == 0) {
            addFirst(e);
            return;
        }
        registerModification();
        ensureCapacity(size() + 1);
        int internalIndex = positiveMod(this.head + index);
        if (index < ((size() + 1) >> 1)) {
            int decrementedInternalIndex = decremented(internalIndex);
            int decrementedHead = decremented(this.head);
            if (decrementedInternalIndex >= this.head) {
                this.elementData[decrementedHead] = this.elementData[this.head];
                ArraysKt.copyInto(this.elementData, this.elementData, this.head, this.head + 1, decrementedInternalIndex + 1);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, this.head - 1, this.head, this.elementData.length);
                this.elementData[this.elementData.length - 1] = this.elementData[0];
                ArraysKt.copyInto(this.elementData, this.elementData, 0, 1, decrementedInternalIndex + 1);
            }
            this.elementData[decrementedInternalIndex] = e;
            this.head = decrementedHead;
        } else {
            int tail = positiveMod(this.head + size());
            if (internalIndex < tail) {
                ArraysKt.copyInto(this.elementData, this.elementData, internalIndex + 1, internalIndex, tail);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, 1, 0, tail);
                this.elementData[0] = this.elementData[this.elementData.length - 1];
                ArraysKt.copyInto(this.elementData, this.elementData, internalIndex + 1, internalIndex, this.elementData.length - 1);
            }
            this.elementData[internalIndex] = e;
        }
        this.size = size() + 1;
    }

    private final void copyCollectionElements(int internalIndex, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.elementData.length;
        for (int index = internalIndex; index < length && it.hasNext(); index++) {
            this.elementData[index] = it.next();
        }
        int i = this.head;
        for (int index2 = 0; index2 < i && it.hasNext(); index2++) {
            this.elementData[index2] = it.next();
        }
        int index3 = size();
        this.size = index3 + collection.size();
    }

    @Override
    @IgnorableReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        registerModification();
        ensureCapacity(size() + collection.size());
        copyCollectionElements(positiveMod(this.head + size()), collection);
        return true;
    }

    @Override
    @IgnorableReturnValue
    public boolean addAll(int index, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(collection);
        }
        registerModification();
        ensureCapacity(size() + collection.size());
        int tail = positiveMod(this.head + size());
        int internalIndex = positiveMod(this.head + index);
        int elementsSize = collection.size();
        if (index < ((size() + 1) >> 1)) {
            int shiftedHead = this.head - elementsSize;
            if (internalIndex >= this.head) {
                if (shiftedHead >= 0) {
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, internalIndex);
                } else {
                    shiftedHead += this.elementData.length;
                    int elementsToShift = internalIndex - this.head;
                    int shiftToBack = this.elementData.length - shiftedHead;
                    if (shiftToBack >= elementsToShift) {
                        ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, internalIndex);
                    } else {
                        ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, this.head + shiftToBack);
                        ArraysKt.copyInto(this.elementData, this.elementData, 0, this.head + shiftToBack, internalIndex);
                    }
                }
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, this.elementData.length);
                if (elementsSize >= internalIndex) {
                    ArraysKt.copyInto(this.elementData, this.elementData, this.elementData.length - elementsSize, 0, internalIndex);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, this.elementData.length - elementsSize, 0, elementsSize);
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, elementsSize, internalIndex);
                }
            }
            this.head = shiftedHead;
            copyCollectionElements(negativeMod(internalIndex - elementsSize), collection);
        } else {
            int shiftedInternalIndex = internalIndex + elementsSize;
            if (internalIndex < tail) {
                if (tail + elementsSize <= this.elementData.length) {
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, tail);
                } else if (shiftedInternalIndex >= this.elementData.length) {
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex - this.elementData.length, internalIndex, tail);
                } else {
                    int shiftToFront = (tail + elementsSize) - this.elementData.length;
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, tail - shiftToFront, tail);
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, tail - shiftToFront);
                }
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, elementsSize, 0, tail);
                if (shiftedInternalIndex >= this.elementData.length) {
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex - this.elementData.length, internalIndex, this.elementData.length);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, 0, this.elementData.length - elementsSize, this.elementData.length);
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, this.elementData.length - elementsSize);
                }
            }
            copyCollectionElements(internalIndex, collection);
        }
        return true;
    }

    @Override
    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return (E) this.elementData[positiveMod(this.head + i)];
    }

    @Override
    @IgnorableReturnValue
    public E set(int i, E e) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        int iPositiveMod = positiveMod(this.head + i);
        E e2 = (E) this.elementData[iPositiveMod];
        this.elementData[iPositiveMod] = e;
        return e2;
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(Object element) {
        int tail = positiveMod(this.head + size());
        if (this.head < tail) {
            for (int index = this.head; index < tail; index++) {
                if (Intrinsics.areEqual(element, this.elementData[index])) {
                    return index - this.head;
                }
            }
            return -1;
        }
        if (!isEmpty() && this.head >= tail) {
            int length = this.elementData.length;
            for (int index2 = this.head; index2 < length; index2++) {
                if (Intrinsics.areEqual(element, this.elementData[index2])) {
                    return index2 - this.head;
                }
            }
            for (int index3 = 0; index3 < tail; index3++) {
                if (Intrinsics.areEqual(element, this.elementData[index3])) {
                    return (this.elementData.length + index3) - this.head;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        int tail = positiveMod(this.head + size());
        if (this.head < tail) {
            int index = tail - 1;
            int i = this.head;
            if (i <= index) {
                while (!Intrinsics.areEqual(element, this.elementData[index])) {
                    if (index != i) {
                        index--;
                    }
                }
                return index - this.head;
            }
        } else if (!isEmpty() && this.head >= tail) {
            for (int index2 = tail - 1; -1 < index2; index2--) {
                if (Intrinsics.areEqual(element, this.elementData[index2])) {
                    return (this.elementData.length + index2) - this.head;
                }
            }
            int index3 = ArraysKt.getLastIndex(this.elementData);
            int i2 = this.head;
            if (i2 <= index3) {
                while (!Intrinsics.areEqual(element, this.elementData[index3])) {
                    if (index3 != i2) {
                        index3--;
                    }
                }
                return index3 - this.head;
            }
        }
        return -1;
    }

    @Override
    @IgnorableReturnValue
    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override
    @IgnorableReturnValue
    public E removeAt(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        if (i == CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        registerModification();
        int iPositiveMod = positiveMod(this.head + i);
        E e = (E) this.elementData[iPositiveMod];
        if (i < (size() >> 1)) {
            if (iPositiveMod >= this.head) {
                ArraysKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, iPositiveMod);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, 1, 0, iPositiveMod);
                this.elementData[0] = this.elementData[this.elementData.length - 1];
                ArraysKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, this.elementData.length - 1);
            }
            this.elementData[this.head] = null;
            this.head = incremented(this.head);
        } else {
            int iPositiveMod2 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
            if (iPositiveMod <= iPositiveMod2) {
                ArraysKt.copyInto(this.elementData, this.elementData, iPositiveMod, iPositiveMod + 1, iPositiveMod2 + 1);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, iPositiveMod, iPositiveMod + 1, this.elementData.length);
                this.elementData[this.elementData.length - 1] = this.elementData[0];
                ArraysKt.copyInto(this.elementData, this.elementData, 0, 1, iPositiveMod2 + 1);
            }
            this.elementData[iPositiveMod2] = null;
        }
        this.size = size() - 1;
        return e;
    }

    @Override
    @IgnorableReturnValue
    public boolean removeAll(Collection<?> collection) {
        int newTail$iv;
        Intrinsics.checkNotNullParameter(collection, "elements");
        boolean modified$iv = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int tail$iv = positiveMod(this.head + size());
                int newTail$iv2 = this.head;
                boolean modified$iv2 = false;
                if (this.head < tail$iv) {
                    for (int index$iv = this.head; index$iv < tail$iv; index$iv++) {
                        Object element$iv = this.elementData[index$iv];
                        if (collection.contains(element$iv)) {
                            modified$iv2 = true;
                        } else {
                            this.elementData[newTail$iv2] = element$iv;
                            newTail$iv2++;
                        }
                    }
                    ArraysKt.fill(this.elementData, (Object) null, newTail$iv2, tail$iv);
                    boolean z = modified$iv2;
                    newTail$iv = newTail$iv2;
                    modified$iv = z;
                } else {
                    int length = this.elementData.length;
                    for (int index$iv2 = this.head; index$iv2 < length; index$iv2++) {
                        Object element$iv2 = this.elementData[index$iv2];
                        this.elementData[index$iv2] = null;
                        if (collection.contains(element$iv2)) {
                            modified$iv2 = true;
                        } else {
                            this.elementData[newTail$iv2] = element$iv2;
                            newTail$iv2++;
                        }
                    }
                    int newTail$iv3 = positiveMod(newTail$iv2);
                    for (int index$iv3 = 0; index$iv3 < tail$iv; index$iv3++) {
                        Object element$iv3 = this.elementData[index$iv3];
                        this.elementData[index$iv3] = null;
                        if (collection.contains(element$iv3)) {
                            modified$iv2 = true;
                        } else {
                            this.elementData[newTail$iv3] = element$iv3;
                            newTail$iv3 = incremented(newTail$iv3);
                        }
                    }
                    boolean z2 = modified$iv2;
                    newTail$iv = newTail$iv3;
                    modified$iv = z2;
                }
                if (modified$iv) {
                    registerModification();
                    this.size = negativeMod(newTail$iv - this.head);
                }
            }
        }
        return modified$iv;
    }

    @Override
    @IgnorableReturnValue
    public boolean retainAll(Collection<?> collection) {
        int newTail$iv;
        Intrinsics.checkNotNullParameter(collection, "elements");
        boolean modified$iv = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int tail$iv = positiveMod(this.head + size());
                int newTail$iv2 = this.head;
                boolean modified$iv2 = false;
                if (this.head < tail$iv) {
                    for (int index$iv = this.head; index$iv < tail$iv; index$iv++) {
                        Object element$iv = this.elementData[index$iv];
                        if (collection.contains(element$iv)) {
                            this.elementData[newTail$iv2] = element$iv;
                            newTail$iv2++;
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    ArraysKt.fill(this.elementData, (Object) null, newTail$iv2, tail$iv);
                    boolean z = modified$iv2;
                    newTail$iv = newTail$iv2;
                    modified$iv = z;
                } else {
                    int length = this.elementData.length;
                    for (int index$iv2 = this.head; index$iv2 < length; index$iv2++) {
                        Object element$iv2 = this.elementData[index$iv2];
                        this.elementData[index$iv2] = null;
                        if (collection.contains(element$iv2)) {
                            this.elementData[newTail$iv2] = element$iv2;
                            newTail$iv2++;
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    int newTail$iv3 = positiveMod(newTail$iv2);
                    for (int index$iv3 = 0; index$iv3 < tail$iv; index$iv3++) {
                        Object element$iv3 = this.elementData[index$iv3];
                        this.elementData[index$iv3] = null;
                        if (collection.contains(element$iv3)) {
                            this.elementData[newTail$iv3] = element$iv3;
                            newTail$iv3 = incremented(newTail$iv3);
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    boolean z2 = modified$iv2;
                    newTail$iv = newTail$iv3;
                    modified$iv = z2;
                }
                if (modified$iv) {
                    registerModification();
                    this.size = negativeMod(newTail$iv - this.head);
                }
            }
        }
        return modified$iv;
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> function1) {
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int tail = positiveMod(this.head + size());
                int newTail = this.head;
                boolean modified = false;
                if (this.head < tail) {
                    for (int index = this.head; index < tail; index++) {
                        Object element = this.elementData[index];
                        if (function1.invoke(element).booleanValue()) {
                            this.elementData[newTail] = element;
                            newTail++;
                        } else {
                            modified = true;
                        }
                    }
                    ArraysKt.fill(this.elementData, (Object) null, newTail, tail);
                } else {
                    int length = this.elementData.length;
                    for (int index2 = this.head; index2 < length; index2++) {
                        Object element2 = this.elementData[index2];
                        this.elementData[index2] = null;
                        if (function1.invoke(element2).booleanValue()) {
                            this.elementData[newTail] = element2;
                            newTail++;
                        } else {
                            modified = true;
                        }
                    }
                    newTail = positiveMod(newTail);
                    for (int index3 = 0; index3 < tail; index3++) {
                        Object element3 = this.elementData[index3];
                        this.elementData[index3] = null;
                        if (function1.invoke(element3).booleanValue()) {
                            this.elementData[newTail] = element3;
                            newTail = incremented(newTail);
                        } else {
                            modified = true;
                        }
                    }
                }
                if (modified) {
                    registerModification();
                    this.size = negativeMod(newTail - this.head);
                }
                return modified;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            registerModification();
            int tail = positiveMod(this.head + size());
            nullifyNonEmpty(this.head, tail);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        Object[] objArrArrayOfNulls = tArr.length >= size() ? tArr : ArraysKt.arrayOfNulls(tArr, size());
        int iPositiveMod = positiveMod(this.head + size());
        if (this.head < iPositiveMod) {
            ArraysKt.copyInto$default(this.elementData, objArrArrayOfNulls, 0, this.head, iPositiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            ArraysKt.copyInto(this.elementData, objArrArrayOfNulls, 0, this.head, this.elementData.length);
            ArraysKt.copyInto(this.elementData, objArrArrayOfNulls, this.elementData.length - this.head, 0, iPositiveMod);
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size(), objArrArrayOfNulls);
    }

    @Override
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, size());
        int length = toIndex - fromIndex;
        if (length == 0) {
            return;
        }
        if (length == size()) {
            clear();
            return;
        }
        if (length == 1) {
            removeAt(fromIndex);
            return;
        }
        registerModification();
        if (fromIndex < size() - toIndex) {
            removeRangeShiftPreceding(fromIndex, toIndex);
            int newHead = positiveMod(this.head + length);
            nullifyNonEmpty(this.head, newHead);
            this.head = newHead;
        } else {
            removeRangeShiftSucceeding(fromIndex, toIndex);
            int tail = positiveMod(this.head + size());
            nullifyNonEmpty(negativeMod(tail - length), tail);
        }
        this.size = size() - length;
    }

    private final void removeRangeShiftPreceding(int fromIndex, int toIndex) {
        int copyFromIndex = positiveMod(this.head + (fromIndex - 1));
        int copyToIndex = positiveMod(this.head + (toIndex - 1));
        int copyCount = fromIndex;
        while (copyCount > 0) {
            int segmentLength = Math.min(copyCount, Math.min(copyFromIndex + 1, copyToIndex + 1));
            ArraysKt.copyInto(this.elementData, this.elementData, (copyToIndex - segmentLength) + 1, (copyFromIndex - segmentLength) + 1, copyFromIndex + 1);
            copyFromIndex = negativeMod(copyFromIndex - segmentLength);
            copyToIndex = negativeMod(copyToIndex - segmentLength);
            copyCount -= segmentLength;
        }
    }

    private final void removeRangeShiftSucceeding(int fromIndex, int toIndex) {
        int copyFromIndex = positiveMod(this.head + toIndex);
        int copyToIndex = positiveMod(this.head + fromIndex);
        int copyCount = size() - toIndex;
        while (copyCount > 0) {
            int segmentLength = Math.min(copyCount, Math.min(this.elementData.length - copyFromIndex, this.elementData.length - copyToIndex));
            ArraysKt.copyInto(this.elementData, this.elementData, copyToIndex, copyFromIndex, copyFromIndex + segmentLength);
            copyFromIndex = positiveMod(copyFromIndex + segmentLength);
            copyToIndex = positiveMod(copyToIndex + segmentLength);
            copyCount -= segmentLength;
        }
    }

    private final void nullifyNonEmpty(int internalFromIndex, int internalToIndex) {
        if (internalFromIndex < internalToIndex) {
            ArraysKt.fill(this.elementData, (Object) null, internalFromIndex, internalToIndex);
        } else {
            ArraysKt.fill(this.elementData, (Object) null, internalFromIndex, this.elementData.length);
            ArraysKt.fill(this.elementData, (Object) null, 0, internalToIndex);
        }
    }

    private final void registerModification() {
        this.modCount++;
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) toArray(tArr);
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    public final void testRemoveRange$kotlin_stdlib(int fromIndex, int toIndex) {
        removeRange(fromIndex, toIndex);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\u0007\u001a\u00020\bX\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/collections/ArrayDeque$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "emptyElementData", _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/Object;", "defaultMinCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "structure");
        int tail = positiveMod(this.head + size());
        int head = (isEmpty() || this.head < tail) ? this.head : this.head - this.elementData.length;
        function2.invoke(Integer.valueOf(head), toArray());
    }
}
