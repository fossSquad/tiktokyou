package ni.shikatu.kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.CollectionToArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0015\bA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0002\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0082\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0002H\u0086\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0096\u0082\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0096\u0080\u0004¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u00020\u001dH\u0096\u0080\u0004¢\u0006\u0004\b&\u0010'J\u0014\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0083\u0004J\n\u0010+\u001a\u00020\tHÖ\u0081\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004R\u001b\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u00020\t8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0088\u0001\u0003\u0092\u0001\u00020\u0004Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\b(2Ê\u0001\u0002\b3Ê\u0001\u0002\b4¨\u0006/"}, d2 = {"Lni/shikatu/kotlin/UIntArray;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UInt;", "storage", _UrlKt.FRAGMENT_ENCODE_SET, "constructor-impl", "([I)[I", "Lni/shikatu/kotlin/PublishedApi;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "(I)[I", "getStorage$annotations", "()V", "get", "index", "get-pVg5ArA", "([II)I", "set", _UrlKt.FRAGMENT_ENCODE_SET, "value", "set-VXSXFK8", "([III)V", "getSize-impl", "([I)I", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "iterator-impl", "([I)Ljava/util/Iterator;", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([I)Z", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Iterator", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    private final int[] storage;

    public static final  UIntArray m154boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    public static int[] m156constructorimpl(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    public static boolean m159equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).m170unboximpl());
    }

    public static final boolean m160equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    public static  void getStorage$annotations() {
    }

    public static int m163hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static String m167toStringimpl(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override
    public /* bridge */  boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean m168addWZ4Q5Ns(int i) {
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
        return m159equalsimpl(this.storage, obj);
    }

    @Override
    public int hashCode() {
        return m163hashCodeimpl(this.storage);
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
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
        return m167toStringimpl(this.storage);
    }

    public final  int[] m170unboximpl() {
        return this.storage;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof UInt) {
            return m169containsWZ4Q5Ns(((UInt) element).m153unboximpl());
        }
        return false;
    }

    private  UIntArray(int[] storage) {
        this.storage = storage;
    }

    public static int[] m155constructorimpl(int size) {
        return m156constructorimpl(new int[size]);
    }

    public static final int m161getpVg5ArA(int[] arg0, int index) {
        return UInt.m101constructorimpl(arg0[index]);
    }

    public static final void m166setVXSXFK8(int[] arg0, int index, int value) {
        arg0[index] = value;
    }

    public static int m162getSizeimpl(int[] arg0) {
        return arg0.length;
    }

    @Override

    public int size() {
        return m162getSizeimpl(this.storage);
    }

    public static java.util.Iterator<UInt> m165iteratorimpl(int[] arg0) {
        return new Iterator(arg0);
    }

    @Override
    public java.util.Iterator<UInt> iterator() {
        return m165iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u00020\nH\u0096\u0082\u0004J\u0011\u0010\u000b\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rR\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/UIntArray$Iterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UInt;", "array", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([I)V", "index", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "next-pVg5ArA", "()I", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
            return UInt.m95boximpl(m171nextpVg5ArA());
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public int m171nextpVg5ArA() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            int[] iArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return UInt.m101constructorimpl(iArr[i]);
        }
    }

    public boolean m169containsWZ4Q5Ns(int element) {
        return m157containsWZ4Q5Ns(this.storage, element);
    }

    public static boolean m157containsWZ4Q5Ns(int[] arg0, int element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m158containsAllimpl(this.storage, (Collection<UInt>) (collection));
    }

    public static boolean m158containsAllimpl(int[] arg0, Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<UInt> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!((element$iv instanceof UInt) && ArraysKt.contains(arg0, ((UInt) element$iv).m153unboximpl()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m164isEmptyimpl(int[] arg0) {
        return arg0.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return m164isEmptyimpl(this.storage);
    }
}
