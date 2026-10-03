package ni.shikatu.kotlin.random;

import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.UIntRange;
import ni.shikatu.kotlin.ranges.ULongRange;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0012\u001a+\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0011H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0013\u0010\u0014\u001a3\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0011H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0015\u0010\u0016\u001a)\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0017H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0018\u001a3\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0087\u0080\bb\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001fb\u0002\b ¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001f¢\u0006\u0002\u0010#\u001aG\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0087\u0080\bb\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001fb\u0002\b ¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020)2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0004\b*\u0010+\u001a!\u0010,\u001a\u00020)2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0011H\u0080\u0080\u0004¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"nextUInt", "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/random/Random;", "(Lkotlin/random/Random;)I", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.5", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "from", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lni/shikatu/kotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "Lni/shikatu/kotlin/ULong;", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lni/shikatu/kotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "nextUBytes", "Lni/shikatu/kotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "1.3", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "checkUIntRangeBounds", _UrlKt.FRAGMENT_ENCODE_SET, "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class URandomKt {
    public static final int nextUInt(Random $this$nextUInt) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        return UInt.m101constructorimpl($this$nextUInt.nextInt());
    }

    public static final int m1262nextUIntqCasIEU(Random $this$nextUInt_u2dqCasIEU, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt_u2dqCasIEU, "$this$nextUInt");
        return m1261nextUInta8DCA5k($this$nextUInt_u2dqCasIEU, 0, until);
    }

    public static final int m1261nextUInta8DCA5k(Random $this$nextUInt_u2da8DCA5k, int from, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt_u2da8DCA5k, "$this$nextUInt");
        m1256checkUIntRangeBoundsJ1ME1BU(from, until);
        int signedFrom = from ^ IntCompanionObject.MIN_VALUE;
        int signedUntil = until ^ IntCompanionObject.MIN_VALUE;
        int signedResult = Integer.MIN_VALUE ^ $this$nextUInt_u2da8DCA5k.nextInt(signedFrom, signedUntil);
        return UInt.m101constructorimpl(signedResult);
    }

    public static final int nextUInt(Random $this$nextUInt, UIntRange range) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (Integer.compareUnsigned(range.m1266getLastpVg5ArA(), -1) < 0) {
            return m1261nextUInta8DCA5k($this$nextUInt, range.m1265getFirstpVg5ArA(), UInt.m101constructorimpl(range.m1266getLastpVg5ArA() + 1));
        }
        return Integer.compareUnsigned(range.m1265getFirstpVg5ArA(), 0) > 0 ? UInt.m101constructorimpl(m1261nextUInta8DCA5k($this$nextUInt, UInt.m101constructorimpl(range.m1265getFirstpVg5ArA() - 1), range.m1266getLastpVg5ArA()) + 1) : nextUInt($this$nextUInt);
    }

    public static final long nextULong(Random $this$nextULong) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        return ULong.m180constructorimpl($this$nextULong.nextLong());
    }

    public static final long m1263nextULongV1Xi4fY(Random $this$nextULong_u2dV1Xi4fY, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong_u2dV1Xi4fY, "$this$nextULong");
        return m1264nextULongjmpaWc($this$nextULong_u2dV1Xi4fY, 0L, until);
    }

    public static final long m1264nextULongjmpaWc(Random $this$nextULong_u2djmpaW_u2dc, long from, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong_u2djmpaW_u2dc, "$this$nextULong");
        m1257checkULongRangeBoundseb3DHEI(from, until);
        long signedFrom = from ^ Long.MIN_VALUE;
        long signedUntil = until ^ Long.MIN_VALUE;
        long signedResult = Long.MIN_VALUE ^ $this$nextULong_u2djmpaW_u2dc.nextLong(signedFrom, signedUntil);
        return ULong.m180constructorimpl(signedResult);
    }

    public static final long nextULong(Random $this$nextULong, ULongRange range) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (Long.compareUnsigned(range.m1275getLastsVKNKU(), -1L) < 0) {
            return m1264nextULongjmpaWc($this$nextULong, range.m1274getFirstsVKNKU(), ULong.m180constructorimpl(range.m1275getLastsVKNKU() + ULong.m180constructorimpl(((long) 1) & 4294967295L)));
        }
        if (Long.compareUnsigned(range.m1274getFirstsVKNKU(), 0L) <= 0) {
            return nextULong($this$nextULong);
        }
        long j = ((long) 1) & 4294967295L;
        return ULong.m180constructorimpl(m1264nextULongjmpaWc($this$nextULong, ULong.m180constructorimpl(range.m1274getFirstsVKNKU() - ULong.m180constructorimpl(j)), range.m1275getLastsVKNKU()) + ULong.m180constructorimpl(j));
    }

    @IgnorableReturnValue

    public static final byte[] m1258nextUBytesEVgfTAA(Random $this$nextUBytes_u2dEVgfTAA, byte[] array) {
        Intrinsics.checkNotNullParameter($this$nextUBytes_u2dEVgfTAA, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes_u2dEVgfTAA.nextBytes(array);
        return array;
    }

    public static final byte[] nextUBytes(Random $this$nextUBytes, int size) {
        Intrinsics.checkNotNullParameter($this$nextUBytes, "<this>");
        return UByteArray.m77constructorimpl($this$nextUBytes.nextBytes(size));
    }

    public static  byte[] m1260nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m83getSizeimpl(bArr);
        }
        return m1259nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    @IgnorableReturnValue

    public static final byte[] m1259nextUBytesWvrt4B4(Random $this$nextUBytes_u2dWvrt4B4, byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$nextUBytes_u2dWvrt4B4, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes_u2dWvrt4B4.nextBytes(array, fromIndex, toIndex);
        return array;
    }

    public static final void m1256checkUIntRangeBoundsJ1ME1BU(int from, int until) {
        if (!(Integer.compareUnsigned(until, from) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m95boximpl(from), UInt.m95boximpl(until)).toString());
        }
    }

    public static final void m1257checkULongRangeBoundseb3DHEI(long from, long until) {
        if (!(Long.compareUnsigned(until, from) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m174boximpl(from), ULong.m174boximpl(until)).toString());
        }
    }
}
