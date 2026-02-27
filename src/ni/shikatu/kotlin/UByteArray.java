package ni.shikatu.kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.CollectionToArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2 = {"Lni/shikatu/kotlin/UByteArray;", "", "Lni/shikatu/kotlin/UByte;", "storage", "", "constructor-impl", "([B)[B", "size", "", "(I)[B", "getStorage$annotations", "()V", "get", "index", "get-w2LRezQ", "([BI)B", "set", "", "value", "set-VurrAj0", "([BIB)V", "getSize-impl", "([B)I", "iterator", "", "iterator-impl", "([B)Ljava/util/Iterator;", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([B)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    private final byte[] storage;

    public static final  UByteArray m73boximpl(byte[] bArr) {
        return new UByteArray(bArr);
    }

    public static byte[] m75constructorimpl(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "storage");
        return bArr;
    }

    public static boolean m78equalsimpl(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual(bArr, ((UByteArray) obj).m89unboximpl());
    }

    public static final boolean m79equalsimpl0(byte[] bArr, byte[] bArr2) {
        return Intrinsics.areEqual(bArr, bArr2);
    }

    public static  void getStorage$annotations() {
    }

    public static int m82hashCodeimpl(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static String m86toStringimpl(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override
    public /* bridge */  boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean m87add7apg3OU(byte b) {
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
        return m78equalsimpl(this.storage, obj);
    }

    @Override
    public int hashCode() {
        return m82hashCodeimpl(this.storage);
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
        return m86toStringimpl(this.storage);
    }

    public final  byte[] m89unboximpl() {
        return this.storage;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof UByte) {
            return m88contains7apg3OU(((UByte) element).m72unboximpl());
        }
        return false;
    }

    private  UByteArray(byte[] storage) {
        this.storage = storage;
    }

    public static byte[] m74constructorimpl(int size) {
        return m75constructorimpl(new byte[size]);
    }

    public static final byte m80getw2LRezQ(byte[] arg0, int index) {
        return UByte.m22constructorimpl(arg0[index]);
    }

    public static final void m85setVurrAj0(byte[] arg0, int index, byte value) {
        arg0[index] = value;
    }

    public static int m81getSizeimpl(byte[] arg0) {
        return arg0.length;
    }

    @Override

    public int size() {
        return m81getSizeimpl(this.storage);
    }

    public static java.util.Iterator<UByte> m84iteratorimpl(byte[] arg0) {
        return new Iterator(arg0);
    }

    @Override
    public java.util.Iterator<UByte> iterator() {
        return m84iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/UByteArray$Iterator;", "", "Lni/shikatu/kotlin/UByte;", "array", "", "<init>", "([B)V", "index", "", "hasNext", "", "next", "next-w2LRezQ", "()B", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
            return UByte.m16boximpl(m90nextw2LRezQ());
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public byte m90nextw2LRezQ() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            byte[] bArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return UByte.m22constructorimpl(bArr[i]);
        }
    }

    public boolean m88contains7apg3OU(byte element) {
        return m76contains7apg3OU(this.storage, element);
    }

    public static boolean m76contains7apg3OU(byte[] arg0, byte element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m77containsAllimpl(this.storage, collection);
    }

    public static boolean m77containsAllimpl(byte[] arg0, Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<UByte> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!((element$iv instanceof UByte) && ArraysKt.contains(arg0, ((UByte) element$iv).m72unboximpl()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m83isEmptyimpl(byte[] arg0) {
        return arg0.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return m83isEmptyimpl(this.storage);
    }
}
