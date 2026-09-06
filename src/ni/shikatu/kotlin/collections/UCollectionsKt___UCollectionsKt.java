package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0004\u001a+\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\f\u001a+\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0017b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u0017\u0010\u0018\u001a7\u0010\u0015\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001cb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001c\u0010\u001d\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001eb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001e\u0010\u0018\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001fb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001f\u0010\u0018¨\u0006 "}, d2 = {"toUByteArray", "Lni/shikatu/kotlin/UByteArray;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UByte;", "(Ljava/util/Collection;)[B", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "toUIntArray", "Lni/shikatu/kotlin/UIntArray;", "Lni/shikatu/kotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lni/shikatu/kotlin/ULongArray;", "Lni/shikatu/kotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lni/shikatu/kotlin/UShortArray;", "Lni/shikatu/kotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", _UrlKt.FRAGMENT_ENCODE_SET, "sumOfUInt", "(Ljava/lang/Iterable;)I", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "1.5", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] result = UByteArray.m76constructorimpl(collection.size());
        int index = 0;
        Iterator<UByte> it = collection.iterator();
        while (it.hasNext()) {
            byte element = it.next().m74unboximpl();
            UByteArray.m87setVurrAj0(result, index, element);
            index++;
        }
        return result;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] result = UIntArray.m155constructorimpl(collection.size());
        int index = 0;
        Iterator<UInt> it = collection.iterator();
        while (it.hasNext()) {
            int element = it.next().m153unboximpl();
            UIntArray.m166setVXSXFK8(result, index, element);
            index++;
        }
        return result;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] result = ULongArray.m234constructorimpl(collection.size());
        int index = 0;
        Iterator<ULong> it = collection.iterator();
        while (it.hasNext()) {
            long element = it.next().m232unboximpl();
            ULongArray.m245setk8EXiF4(result, index, element);
            index++;
        }
        return result;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] result = UShortArray.m339constructorimpl(collection.size());
        int index = 0;
        Iterator<UShort> it = collection.iterator();
        while (it.hasNext()) {
            short element = it.next().m337unboximpl();
            UShortArray.m350set01HTLdE(result, index, element);
            index++;
        }
        return result;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        Iterator<UInt> it = iterable.iterator();
        while (it.hasNext()) {
            int element = it.next().m153unboximpl();
            sum = UInt.m101constructorimpl(sum + element);
        }
        return sum;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        long sum = 0;
        Iterator<ULong> it = iterable.iterator();
        while (it.hasNext()) {
            long element = it.next().m232unboximpl();
            sum = ULong.m180constructorimpl(sum + element);
        }
        return sum;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        Iterator<UByte> it = iterable.iterator();
        while (it.hasNext()) {
            byte element = it.next().m74unboximpl();
            sum = UInt.m101constructorimpl(UInt.m101constructorimpl(element & UByte.MAX_VALUE) + sum);
        }
        return sum;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        Iterator<UShort> it = iterable.iterator();
        while (it.hasNext()) {
            short element = it.next().m337unboximpl();
            sum = UInt.m101constructorimpl(UInt.m101constructorimpl(65535 & element) + sum);
        }
        return sum;
    }
}
