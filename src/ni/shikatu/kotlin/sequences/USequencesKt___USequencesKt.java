package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\b0\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0004¨\u0006\f"}, d2 = {"sum", "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/sequences/Sequence;", "sumOfUInt", "(Lkotlin/sequences/Sequence;)I", "Lni/shikatu/kotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lni/shikatu/kotlin/UByte;", "sumOfUByte", "Lni/shikatu/kotlin/UShort;", "sumOfUShort", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt {
    public static final int sumOfUInt(Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int sum = 0;
        Iterator<UInt> it = sequence.iterator();
        while (it.hasNext()) {
            int element = it.next().m151unboximpl();
            sum = UInt.m99constructorimpl(sum + element);
        }
        return sum;
    }

    public static final long sumOfULong(Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        long sum = 0;
        Iterator<ULong> it = sequence.iterator();
        while (it.hasNext()) {
            long element = it.next().m230unboximpl();
            sum = ULong.m178constructorimpl(sum + element);
        }
        return sum;
    }

    public static final int sumOfUByte(Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int sum = 0;
        Iterator<UByte> it = sequence.iterator();
        while (it.hasNext()) {
            byte element = it.next().m72unboximpl();
            sum = UInt.m99constructorimpl(UInt.m99constructorimpl(element & UByte.MAX_VALUE) + sum);
        }
        return sum;
    }

    public static final int sumOfUShort(Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int sum = 0;
        Iterator<UShort> it = sequence.iterator();
        while (it.hasNext()) {
            short element = it.next().m335unboximpl();
            sum = UInt.m99constructorimpl(UInt.m99constructorimpl(65535 & element) + sum);
        }
        return sum;
    }
}
