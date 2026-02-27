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

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u0017\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0007¢\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0007¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0011\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"toUByteArray", "Lni/shikatu/kotlin/UByteArray;", "", "Lni/shikatu/kotlin/UByte;", "(Ljava/util/Collection;)[B", "toUIntArray", "Lni/shikatu/kotlin/UIntArray;", "Lni/shikatu/kotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lni/shikatu/kotlin/ULongArray;", "Lni/shikatu/kotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lni/shikatu/kotlin/UShortArray;", "Lni/shikatu/kotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] result = UByteArray.m74constructorimpl(collection.size());
        int index = 0;
        Iterator<UByte> it = collection.iterator();
        while (it.hasNext()) {
            byte element = it.next().m72unboximpl();
            UByteArray.m85setVurrAj0(result, index, element);
            index++;
        }
        return result;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] result = UIntArray.m153constructorimpl(collection.size());
        int index = 0;
        Iterator<UInt> it = collection.iterator();
        while (it.hasNext()) {
            int element = it.next().m151unboximpl();
            UIntArray.m164setVXSXFK8(result, index, element);
            index++;
        }
        return result;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] result = ULongArray.m232constructorimpl(collection.size());
        int index = 0;
        Iterator<ULong> it = collection.iterator();
        while (it.hasNext()) {
            long element = it.next().m230unboximpl();
            ULongArray.m243setk8EXiF4(result, index, element);
            index++;
        }
        return result;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] result = UShortArray.m337constructorimpl(collection.size());
        int index = 0;
        Iterator<UShort> it = collection.iterator();
        while (it.hasNext()) {
            short element = it.next().m335unboximpl();
            UShortArray.m348set01HTLdE(result, index, element);
            index++;
        }
        return result;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        Iterator<UInt> it = iterable.iterator();
        while (it.hasNext()) {
            int element = it.next().m151unboximpl();
            sum = UInt.m99constructorimpl(sum + element);
        }
        return sum;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        long sum = 0;
        Iterator<ULong> it = iterable.iterator();
        while (it.hasNext()) {
            long element = it.next().m230unboximpl();
            sum = ULong.m178constructorimpl(sum + element);
        }
        return sum;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        Iterator<UByte> it = iterable.iterator();
        while (it.hasNext()) {
            byte element = it.next().m72unboximpl();
            sum = UInt.m99constructorimpl(UInt.m99constructorimpl(element & UByte.MAX_VALUE) + sum);
        }
        return sum;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        Iterator<UShort> it = iterable.iterator();
        while (it.hasNext()) {
            short element = it.next().m335unboximpl();
            sum = UInt.m99constructorimpl(UInt.m99constructorimpl(65535 & element) + sum);
        }
        return sum;
    }
}
