package ni.shikatu.kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.CollectionToArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2 = {"Lni/shikatu/kotlin/UShortArray;", "", "Lni/shikatu/kotlin/UShort;", "storage", "", "constructor-impl", "([S)[S", "size", "", "(I)[S", "getStorage$annotations", "()V", "get", "index", "get-Mh2AYeg", "([SI)S", "set", "", "value", "set-01HTLdE", "([SIS)V", "getSize-impl", "([S)I", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([S)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    private final short[] storage;

    public static final  UShortArray m336boximpl(short[] sArr) {
        return new UShortArray(sArr);
    }

    public static short[] m338constructorimpl(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "storage");
        return sArr;
    }

    public static boolean m341equalsimpl(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual(sArr, ((UShortArray) obj).m352unboximpl());
    }

    public static final boolean m342equalsimpl0(short[] sArr, short[] sArr2) {
        return Intrinsics.areEqual(sArr, sArr2);
    }

    public static  void getStorage$annotations() {
    }

    public static int m345hashCodeimpl(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static String m349toStringimpl(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    @Override
    public /* bridge */  boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean m350addxj2QHRw(short s) {
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
        return m341equalsimpl(this.storage, obj);
    }

    @Override
    public int hashCode() {
        return m345hashCodeimpl(this.storage);
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
        return m349toStringimpl(this.storage);
    }

    public final  short[] m352unboximpl() {
        return this.storage;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof UShort) {
            return m351containsxj2QHRw(((UShort) element).m335unboximpl());
        }
        return false;
    }

    private  UShortArray(short[] storage) {
        this.storage = storage;
    }

    public static short[] m337constructorimpl(int size) {
        return m338constructorimpl(new short[size]);
    }

    public static final short m343getMh2AYeg(short[] arg0, int index) {
        return UShort.m285constructorimpl(arg0[index]);
    }

    public static final void m348set01HTLdE(short[] arg0, int index, short value) {
        arg0[index] = value;
    }

    public static int m344getSizeimpl(short[] arg0) {
        return arg0.length;
    }

    @Override

    public int size() {
        return m344getSizeimpl(this.storage);
    }

    public static java.util.Iterator<UShort> m347iteratorimpl(short[] arg0) {
        return new Iterator(arg0);
    }

    @Override
    public java.util.Iterator<UShort> iterator() {
        return m347iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/UShortArray$Iterator;", "", "Lni/shikatu/kotlin/UShort;", "array", "", "<init>", "([S)V", "index", "", "hasNext", "", "next", "next-Mh2AYeg", "()S", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
            return UShort.m279boximpl(m353nextMh2AYeg());
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public short m353nextMh2AYeg() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            short[] sArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return UShort.m285constructorimpl(sArr[i]);
        }
    }

    public boolean m351containsxj2QHRw(short element) {
        return m339containsxj2QHRw(this.storage, element);
    }

    public static boolean m339containsxj2QHRw(short[] arg0, short element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m340containsAllimpl(this.storage, collection);
    }

    public static boolean m340containsAllimpl(short[] arg0, Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<UShort> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!((element$iv instanceof UShort) && ArraysKt.contains(arg0, ((UShort) element$iv).m335unboximpl()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m346isEmptyimpl(short[] arg0) {
        return arg0.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return m346isEmptyimpl(this.storage);
    }
}
