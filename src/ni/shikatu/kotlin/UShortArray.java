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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0015\bA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0002\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0082\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0002H\u0086\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0096\u0082\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0096\u0080\u0004¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u00020\u001dH\u0096\u0080\u0004¢\u0006\u0004\b&\u0010'J\u0014\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0083\u0004J\n\u0010+\u001a\u00020\tHÖ\u0081\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004R\u001b\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u00020\t8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0088\u0001\u0003\u0092\u0001\u00020\u0004Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\b(2Ê\u0001\u0002\b3Ê\u0001\u0002\b4¨\u0006/"}, d2 = {"Lni/shikatu/kotlin/UShortArray;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UShort;", "storage", _UrlKt.FRAGMENT_ENCODE_SET, "constructor-impl", "([S)[S", "Lni/shikatu/kotlin/PublishedApi;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "(I)[S", "getStorage$annotations", "()V", "get", "index", "get-Mh2AYeg", "([SI)S", "set", _UrlKt.FRAGMENT_ENCODE_SET, "value", "set-01HTLdE", "([SIS)V", "getSize-impl", "([S)I", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "iterator-impl", "([S)Ljava/util/Iterator;", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([S)Z", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Iterator", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    private final short[] storage;

    public static final  UShortArray m338boximpl(short[] sArr) {
        return new UShortArray(sArr);
    }

    public static short[] m340constructorimpl(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "storage");
        return sArr;
    }

    public static boolean m343equalsimpl(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual(sArr, ((UShortArray) obj).m354unboximpl());
    }

    public static final boolean m344equalsimpl0(short[] sArr, short[] sArr2) {
        return Intrinsics.areEqual(sArr, sArr2);
    }

    public static  void getStorage$annotations() {
    }

    public static int m347hashCodeimpl(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static String m351toStringimpl(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    @Override
    public /* bridge */  boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean m352addxj2QHRw(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean equals(Object obj) {
        return m343equalsimpl(this.storage, obj);
    }

    @Override
    public int hashCode() {
        return m347hashCodeimpl(this.storage);
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
        return m351toStringimpl(this.storage);
    }

    public final  short[] m354unboximpl() {
        return this.storage;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof UShort) {
            return m353containsxj2QHRw(((UShort) element).m337unboximpl());
        }
        return false;
    }

    private  UShortArray(short[] storage) {
        this.storage = storage;
    }

    public static short[] m339constructorimpl(int size) {
        return m340constructorimpl(new short[size]);
    }

    public static final short m345getMh2AYeg(short[] arg0, int index) {
        return UShort.m287constructorimpl(arg0[index]);
    }

    public static final void m350set01HTLdE(short[] arg0, int index, short value) {
        arg0[index] = value;
    }

    public static int m346getSizeimpl(short[] arg0) {
        return arg0.length;
    }

    @Override

    public int size() {
        return m346getSizeimpl(this.storage);
    }

    public static java.util.Iterator<UShort> m349iteratorimpl(short[] arg0) {
        return new Iterator(arg0);
    }

    @Override
    public java.util.Iterator<UShort> iterator() {
        return m349iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u00020\nH\u0096\u0082\u0004J\u0011\u0010\u000b\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rR\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/UShortArray$Iterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UShort;", "array", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([S)V", "index", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "next-Mh2AYeg", "()S", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker {
        private final short[] array;
        private int index;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Iterator(short[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override
        public /* bridge */  UShort next() {
            return UShort.m281boximpl(m355nextMh2AYeg());
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public short m355nextMh2AYeg() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            short[] sArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return UShort.m287constructorimpl(sArr[i]);
        }
    }

    public boolean m353containsxj2QHRw(short element) {
        return m341containsxj2QHRw(this.storage, element);
    }

    public static boolean m341containsxj2QHRw(short[] arg0, short element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m342containsAllimpl(this.storage, (Collection<UShort>) (collection));
    }

    public static boolean m342containsAllimpl(short[] arg0, Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<UShort> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!((element$iv instanceof UShort) && ArraysKt.contains(arg0, ((UShort) element$iv).m337unboximpl()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m348isEmptyimpl(short[] arg0) {
        return arg0.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return m348isEmptyimpl(this.storage);
    }
}
