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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0015\bA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0002\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0082\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0002H\u0086\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0096\u0082\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0096\u0080\u0004¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u00020\u001dH\u0096\u0080\u0004¢\u0006\u0004\b&\u0010'J\u0014\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0083\u0004J\n\u0010+\u001a\u00020\tHÖ\u0081\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004R\u001b\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u00020\t8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0088\u0001\u0003\u0092\u0001\u00020\u0004Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\b(2Ê\u0001\u0002\b3Ê\u0001\u0002\b4¨\u0006/"}, d2 = {"Lni/shikatu/kotlin/UByteArray;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UByte;", "storage", _UrlKt.FRAGMENT_ENCODE_SET, "constructor-impl", "([B)[B", "Lni/shikatu/kotlin/PublishedApi;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "(I)[B", "getStorage$annotations", "()V", "get", "index", "get-w2LRezQ", "([BI)B", "set", _UrlKt.FRAGMENT_ENCODE_SET, "value", "set-VurrAj0", "([BIB)V", "getSize-impl", "([B)I", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "iterator-impl", "([B)Ljava/util/Iterator;", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([B)Z", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Iterator", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    private final byte[] storage;

    public static final  UByteArray m75boximpl(byte[] bArr) {
        return new UByteArray(bArr);
    }

    public static byte[] m77constructorimpl(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "storage");
        return bArr;
    }

    public static boolean m80equalsimpl(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual(bArr, ((UByteArray) obj).m91unboximpl());
    }

    public static final boolean m81equalsimpl0(byte[] bArr, byte[] bArr2) {
        return Intrinsics.areEqual(bArr, bArr2);
    }

    public static  void getStorage$annotations() {
    }

    public static int m84hashCodeimpl(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static String m88toStringimpl(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override
    public /* bridge */  boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean m89add7apg3OU(byte b) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean equals(Object obj) {
        return m80equalsimpl(this.storage, obj);
    }

    @Override
    public int hashCode() {
        return m84hashCodeimpl(this.storage);
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
        return m88toStringimpl(this.storage);
    }

    public final  byte[] m91unboximpl() {
        return this.storage;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof UByte) {
            return m90contains7apg3OU(((UByte) element).m74unboximpl());
        }
        return false;
    }

    private  UByteArray(byte[] storage) {
        this.storage = storage;
    }

    public static byte[] m76constructorimpl(int size) {
        return m77constructorimpl(new byte[size]);
    }

    public static final byte m82getw2LRezQ(byte[] arg0, int index) {
        return UByte.m24constructorimpl(arg0[index]);
    }

    public static final void m87setVurrAj0(byte[] arg0, int index, byte value) {
        arg0[index] = value;
    }

    public static int m83getSizeimpl(byte[] arg0) {
        return arg0.length;
    }

    @Override

    public int size() {
        return m83getSizeimpl(this.storage);
    }

    public static java.util.Iterator<UByte> m86iteratorimpl(byte[] arg0) {
        return new Iterator(arg0);
    }

    @Override
    public java.util.Iterator<UByte> iterator() {
        return m86iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u00020\nH\u0096\u0082\u0004J\u0011\u0010\u000b\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rR\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/UByteArray$Iterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UByte;", "array", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([B)V", "index", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "next-w2LRezQ", "()B", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {
        private final byte[] array;
        private int index;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Iterator(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override
        public /* bridge */  UByte next() {
            return UByte.m18boximpl(m92nextw2LRezQ());
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public byte m92nextw2LRezQ() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            byte[] bArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return UByte.m24constructorimpl(bArr[i]);
        }
    }

    public boolean m90contains7apg3OU(byte element) {
        return m78contains7apg3OU(this.storage, element);
    }

    public static boolean m78contains7apg3OU(byte[] arg0, byte element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m79containsAllimpl(this.storage, (Collection<UByte>) (collection));
    }

    public static boolean m79containsAllimpl(byte[] arg0, Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<UByte> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!((element$iv instanceof UByte) && ArraysKt.contains(arg0, ((UByte) element$iv).m74unboximpl()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m85isEmptyimpl(byte[] arg0) {
        return arg0.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return m85isEmptyimpl(this.storage);
    }
}
