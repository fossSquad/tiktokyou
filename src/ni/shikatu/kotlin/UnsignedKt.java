package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.CharsKt;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001¢\u0006\u0004\b\r\u0010\u000b\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0001\u001a\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0001\u001a\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b¢\u0006\u0002\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b¢\u0006\u0002\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\u001a\u0015\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010\u001d\u001a\u0011\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0001\u001a\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010#\u001a\u0011\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0019\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0018\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0000¨\u0006("}, d2 = {"uintRemainder", "Lni/shikatu/kotlin/UInt;", "v1", "v2", "uintRemainder-J1ME1BU", "(II)I", "uintDivide", "uintDivide-J1ME1BU", "ulongDivide", "Lni/shikatu/kotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "uintCompare", "", "ulongCompare", "", "uintToULong", "value", "(I)J", "uintToLong", "uintToFloat", "", "floatToUInt", "(F)I", "uintToDouble", "", "doubleToUInt", "(D)I", "ulongToFloat", "floatToULong", "(F)J", "ulongToDouble", "doubleToULong", "(D)J", "uintToString", "", "base", "ulongToString", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UnsignedKt {

    public static final int m356uintRemainderJ1ME1BU(int v1, int v2) {
        return UInt.m99constructorimpl((int) ((((long) v1) & 4294967295L) % (4294967295L & ((long) v2))));
    }

    public static final int m355uintDivideJ1ME1BU(int v1, int v2) {
        return UInt.m99constructorimpl((int) ((((long) v1) & 4294967295L) / (4294967295L & ((long) v2))));
    }

    public static final long m357ulongDivideeb3DHEI(long v1, long v2) {
        if (v2 < 0) {
            return ULong.m178constructorimpl(Long.compareUnsigned(v1, v2) >= 0 ? 1L : 0L);
        }
        if (v1 >= 0) {
            return ULong.m178constructorimpl(v1 / v2);
        }
        long quotient = ((v1 >>> 1) / v2) << 1;
        long rem = v1 - (quotient * v2);
        return ULong.m178constructorimpl(((long) (Long.compareUnsigned(ULong.m178constructorimpl(rem), ULong.m178constructorimpl(v2)) < 0 ? 0 : 1)) + quotient);
    }

    public static final long m358ulongRemaindereb3DHEI(long v1, long v2) {
        long j = 0;
        if (v2 < 0) {
            if (Long.compareUnsigned(v1, v2) < 0) {
                return v1;
            }
            return ULong.m178constructorimpl(v1 - v2);
        }
        if (v1 >= 0) {
            return ULong.m178constructorimpl(v1 % v2);
        }
        long quotient = ((v1 >>> 1) / v2) << 1;
        long rem = v1 - (quotient * v2);
        if (Long.compareUnsigned(ULong.m178constructorimpl(rem), ULong.m178constructorimpl(v2)) >= 0) {
            j = v2;
        }
        return ULong.m178constructorimpl(rem - j);
    }

    public static final int uintCompare(int v1, int v2) {
        return Intrinsics.compare(v1 ^ IntCompanionObject.MIN_VALUE, Integer.MIN_VALUE ^ v2);
    }

    public static final int ulongCompare(long v1, long v2) {
        return Intrinsics.compare(v1 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ v2);
    }

    private static final long uintToULong(int value) {
        return ULong.m178constructorimpl(((long) value) & 4294967295L);
    }

    private static final long uintToLong(int value) {
        return ((long) value) & 4294967295L;
    }

    private static final float uintToFloat(int value) {
        return (float) uintToDouble(value);
    }

    private static final int floatToUInt(float value) {
        return doubleToUInt(value);
    }

    public static final double uintToDouble(int value) {
        return ((double) (Integer.MAX_VALUE & value)) + (((double) ((value >>> 31) << 30)) * ((double) 2));
    }

    public static final int doubleToUInt(double value) {
        if (Double.isNaN(value) || value <= uintToDouble(0)) {
            return 0;
        }
        if (value >= uintToDouble(-1)) {
            return -1;
        }
        return value <= 2.147483647E9d ? UInt.m99constructorimpl((int) value) : UInt.m99constructorimpl(UInt.m99constructorimpl((int) (value - ((double) IntCompanionObject.MAX_VALUE))) + UInt.m99constructorimpl(IntCompanionObject.MAX_VALUE));
    }

    private static final float ulongToFloat(long value) {
        return (float) ulongToDouble(value);
    }

    private static final long floatToULong(float value) {
        return doubleToULong(value);
    }

    public static final double ulongToDouble(long value) {
        return ((value >>> 11) * ((double) 2048)) + (2047 & value);
    }

    public static final long doubleToULong(double value) {
        if (Double.isNaN(value) || value <= ulongToDouble(0L)) {
            return 0L;
        }
        if (value >= ulongToDouble(-1L)) {
            return -1L;
        }
        return value < 9.223372036854776E18d ? ULong.m178constructorimpl((long) value) : ULong.m178constructorimpl(ULong.m178constructorimpl((long) (value - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    private static final String uintToString(int value) {
        return String.valueOf(((long) value) & 4294967295L);
    }

    private static final String uintToString(int value, int base) {
        return ulongToString(((long) value) & 4294967295L, base);
    }

    private static final String ulongToString(long value) {
        return ulongToString(value, 10);
    }

    public static final String ulongToString(long value, int base) {
        if (value >= 0) {
            String string = Long.toString(value, CharsKt.checkRadix(base));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        long quotient = ((value >>> 1) / ((long) base)) << 1;
        long rem = value - (((long) base) * quotient);
        if (rem >= base) {
            rem -= (long) base;
            quotient++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(quotient, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        StringBuilder sbAppend = sb.append(string2);
        String string3 = Long.toString(rem, CharsKt.checkRadix(base));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        return sbAppend.append(string3).toString();
    }
}
