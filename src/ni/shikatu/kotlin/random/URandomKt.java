package ni.shikatu.kotlin.random;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.UIntRange;
import ni.shikatu.kotlin.ranges.ULongRange;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a\u001b\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a/\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001cH\u0007¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010&\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0000¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"nextUInt", "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/random/Random;", "(Lkotlin/random/Random;)I", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "from", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lni/shikatu/kotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "Lni/shikatu/kotlin/ULong;", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lni/shikatu/kotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "nextUBytes", "Lni/shikatu/kotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "size", "", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "checkUIntRangeBounds", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class URandomKt {
    public static final int nextUInt(Random $this$nextUInt) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        return UInt.m99constructorimpl($this$nextUInt.nextInt());
    }

    public static final int m1240nextUIntqCasIEU(Random $this$nextUInt_u2dqCasIEU, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt_u2dqCasIEU, "$this$nextUInt");
        return m1239nextUInta8DCA5k($this$nextUInt_u2dqCasIEU, 0, until);
    }

    public static final int m1239nextUInta8DCA5k(Random $this$nextUInt_u2da8DCA5k, int from, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt_u2da8DCA5k, "$this$nextUInt");
        m1234checkUIntRangeBoundsJ1ME1BU(from, until);
        int signedFrom = from ^ IntCompanionObject.MIN_VALUE;
        int signedUntil = until ^ IntCompanionObject.MIN_VALUE;
        int signedResult = Integer.MIN_VALUE ^ $this$nextUInt_u2da8DCA5k.nextInt(signedFrom, signedUntil);
        return UInt.m99constructorimpl(signedResult);
    }

    public static final int nextUInt(Random $this$nextUInt, UIntRange range) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (Integer.compareUnsigned(range.m1244getLastpVg5ArA(), -1) < 0) {
            return m1239nextUInta8DCA5k($this$nextUInt, range.m1243getFirstpVg5ArA(), UInt.m99constructorimpl(range.m1244getLastpVg5ArA() + 1));
        }
        return Integer.compareUnsigned(range.m1243getFirstpVg5ArA(), 0) > 0 ? UInt.m99constructorimpl(m1239nextUInta8DCA5k($this$nextUInt, UInt.m99constructorimpl(range.m1243getFirstpVg5ArA() - 1), range.m1244getLastpVg5ArA()) + 1) : nextUInt($this$nextUInt);
    }

    public static final long nextULong(Random $this$nextULong) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        return ULong.m178constructorimpl($this$nextULong.nextLong());
    }

    public static final long m1241nextULongV1Xi4fY(Random $this$nextULong_u2dV1Xi4fY, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong_u2dV1Xi4fY, "$this$nextULong");
        return m1242nextULongjmpaWc($this$nextULong_u2dV1Xi4fY, 0L, until);
    }

    public static final long m1242nextULongjmpaWc(Random $this$nextULong_u2djmpaW_u2dc, long from, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong_u2djmpaW_u2dc, "$this$nextULong");
        m1235checkULongRangeBoundseb3DHEI(from, until);
        long signedFrom = from ^ Long.MIN_VALUE;
        long signedUntil = until ^ Long.MIN_VALUE;
        long signedResult = Long.MIN_VALUE ^ $this$nextULong_u2djmpaW_u2dc.nextLong(signedFrom, signedUntil);
        return ULong.m178constructorimpl(signedResult);
    }

    public static final long nextULong(Random $this$nextULong, ULongRange range) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (Long.compareUnsigned(range.m1253getLastsVKNKU(), -1L) < 0) {
            return m1242nextULongjmpaWc($this$nextULong, range.m1252getFirstsVKNKU(), ULong.m178constructorimpl(range.m1253getLastsVKNKU() + ULong.m178constructorimpl(((long) 1) & 4294967295L)));
        }
        if (Long.compareUnsigned(range.m1252getFirstsVKNKU(), 0L) <= 0) {
            return nextULong($this$nextULong);
        }
        long j = ((long) 1) & 4294967295L;
        return ULong.m178constructorimpl(m1242nextULongjmpaWc($this$nextULong, ULong.m178constructorimpl(range.m1252getFirstsVKNKU() - ULong.m178constructorimpl(j)), range.m1253getLastsVKNKU()) + ULong.m178constructorimpl(j));
    }

    public static final byte[] m1236nextUBytesEVgfTAA(Random $this$nextUBytes_u2dEVgfTAA, byte[] array) {
        Intrinsics.checkNotNullParameter($this$nextUBytes_u2dEVgfTAA, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes_u2dEVgfTAA.nextBytes(array);
        return array;
    }

    public static final byte[] nextUBytes(Random $this$nextUBytes, int size) {
        Intrinsics.checkNotNullParameter($this$nextUBytes, "<this>");
        return UByteArray.m75constructorimpl($this$nextUBytes.nextBytes(size));
    }

    public static  byte[] m1238nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m81getSizeimpl(bArr);
        }
        return m1237nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    public static final byte[] m1237nextUBytesWvrt4B4(Random $this$nextUBytes_u2dWvrt4B4, byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$nextUBytes_u2dWvrt4B4, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes_u2dWvrt4B4.nextBytes(array, fromIndex, toIndex);
        return array;
    }

    public static final void m1234checkUIntRangeBoundsJ1ME1BU(int from, int until) {
        if (!(Integer.compareUnsigned(until, from) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m93boximpl(from), UInt.m93boximpl(until)).toString());
        }
    }

    public static final void m1235checkULongRangeBoundseb3DHEI(long from, long until) {
        if (!(Long.compareUnsigned(until, from) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m172boximpl(from), ULong.m172boximpl(until)).toString());
        }
    }
}
