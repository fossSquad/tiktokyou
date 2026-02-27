package ni.shikatu.kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.CollectionToArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2 = {"Lni/shikatu/kotlin/UIntArray;", "", "Lni/shikatu/kotlin/UInt;", "storage", "", "constructor-impl", "([I)[I", "size", "", "(I)[I", "getStorage$annotations", "()V", "get", "index", "get-pVg5ArA", "([II)I", "set", "", "value", "set-VXSXFK8", "([III)V", "getSize-impl", "([I)I", "iterator", "", "iterator-impl", "([I)Ljava/util/Iterator;", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([I)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    private final int[] storage;

    public static final  UIntArray m152boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    public static int[] m154constructorimpl(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    public static boolean m157equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).m168unboximpl());
    }

    public static final boolean m158equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    public static  void getStorage$annotations() {
    }

    public static int m161hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static String m165toStringimpl(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override
    public /* bridge */  boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean m166addWZ4Q5Ns(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean equals(Object obj) {
        return m157equalsimpl(this.storage, obj);
    }

    @Override
    public int hashCode() {
        return m161hashCodeimpl(this.storage);
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
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

    public String toString() {
        return m165toStringimpl(this.storage);
    }

    public final  int[] m168unboximpl() {
        return this.storage;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof UInt) {
            return m167containsWZ4Q5Ns(((UInt) element).m151unboximpl());
        }
        return false;
    }

    private  UIntArray(int[] storage) {
        this.storage = storage;
    }

    public static int[] m153constructorimpl(int size) {
        return m154constructorimpl(new int[size]);
    }

    public static final int m159getpVg5ArA(int[] arg0, int index) {
        return UInt.m99constructorimpl(arg0[index]);
    }

    public static final void m164setVXSXFK8(int[] arg0, int index, int value) {
        arg0[index] = value;
    }

    public static int m160getSizeimpl(int[] arg0) {
        return arg0.length;
    }

    @Override

    public int size() {
        return m160getSizeimpl(this.storage);
    }

    public static java.util.Iterator<UInt> m163iteratorimpl(int[] arg0) {
        return new Iterator(arg0);
    }

    @Override
    public java.util.Iterator<UInt> iterator() {
        return m163iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/UIntArray$Iterator;", "", "Lni/shikatu/kotlin/UInt;", "array", "", "<init>", "([I)V", "index", "", "hasNext", "", "next", "next-pVg5ArA", "()I", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {
        private final int[] array;
        private int index;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Iterator(int[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override
        public /* bridge */  UInt next() {
            return UInt.m93boximpl(m169nextpVg5ArA());
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public int m169nextpVg5ArA() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            int[] iArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return UInt.m99constructorimpl(iArr[i]);
        }
    }

    public boolean m167containsWZ4Q5Ns(int element) {
        return m155containsWZ4Q5Ns(this.storage, element);
    }

    public static boolean m155containsWZ4Q5Ns(int[] arg0, int element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m156containsAllimpl(this.storage, collection);
    }

    public static boolean m156containsAllimpl(int[] arg0, Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<UInt> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!((element$iv instanceof UInt) && ArraysKt.contains(arg0, ((UInt) element$iv).m151unboximpl()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m162isEmptyimpl(int[] arg0) {
        return arg0.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return m162isEmptyimpl(this.storage);
    }
}
