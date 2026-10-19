package ni.shikatu.kotlin.comparisons;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\r\u0010\u000e\u001a/\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b\u0013\u0010\u0014\u001a;\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b\u0016\u0010\u0017\u001a;\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b\u001a\u0010\u001b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u001c\u001a\u00020\u001d\"\u00020\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b\u001e\u0010\u001f\u001a7\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u001c\u001a\u00020\"\"\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b#\u0010$\u001a7\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u001c\u001a\u00020%\"\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b&\u0010'\u001a7\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\n\u0010\u001c\u001a\u00020(\"\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b)\u0010*\u001a/\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b,\u0010\u0005\u001a/\u0010+\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b-\u0010\u000b\u001a/\u0010+\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b.\u0010\u000e\u001a/\u0010+\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b/\u0010\u0011\u001a;\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b0\u0010\u0014\u001a;\u0010+\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b1\u0010\u0017\u001a;\u0010+\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b2\u0010\u0019\u001a;\u0010+\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b3\u0010\u001b\u001a7\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u001c\u001a\u00020\u001d\"\u00020\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b4\u0010\u001f\u001a7\u0010+\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u001c\u001a\u00020\"\"\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b5\u0010$\u001a7\u0010+\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u001c\u001a\u00020%\"\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b6\u0010'\u001a7\u0010+\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\n\u0010\u001c\u001a\u00020(\"\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b7\u0010*¨\u00068"}, d2 = {"maxOf", "Lni/shikatu/kotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.5", "Lni/shikatu/kotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lni/shikatu/kotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lni/shikatu/kotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "Lni/shikatu/kotlin/internal/InlineOnly;", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lni/shikatu/kotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "1.4", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "Lni/shikatu/kotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lni/shikatu/kotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lni/shikatu/kotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/comparisons/UComparisonsKt")
public class UComparisonsKt___UComparisonsKt {

    public static final int m1216maxOfJ1ME1BU(int a, int b) {
        return Integer.compareUnsigned(a, b) >= 0 ? a : b;
    }

    public static final long m1224maxOfeb3DHEI(long a, long b) {
        return Long.compareUnsigned(a, b) >= 0 ? a : b;
    }

    public static final byte m1217maxOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare(a & UByte.MAX_VALUE, b & UByte.MAX_VALUE) >= 0 ? a : b;
    }

    public static final short m1215maxOf5PvTz6A(short a, short b) {
        return Intrinsics.compare(a & UShort.MAX_VALUE, 65535 & b) >= 0 ? a : b;
    }

    private static final int m1221maxOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m1216maxOfJ1ME1BU(a, UComparisonsKt.m1216maxOfJ1ME1BU(b, c));
    }

    private static final long m1225maxOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m1224maxOfeb3DHEI(a, UComparisonsKt.m1224maxOfeb3DHEI(b, c));
    }

    private static final byte m1223maxOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m1217maxOfKr8caGY(a, UComparisonsKt.m1217maxOfKr8caGY(b, c));
    }

    private static final short m1220maxOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m1215maxOf5PvTz6A(a, UComparisonsKt.m1215maxOf5PvTz6A(b, c));
    }

    public static final int m1218maxOfMd2H83M(int a, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int max = a;
        int iM162getSizeimpl = UIntArray.m162getSizeimpl(other);
        for (int i = 0; i < iM162getSizeimpl; i++) {
            int e = UIntArray.m161getpVg5ArA(other, i);
            max = UComparisonsKt.m1216maxOfJ1ME1BU(max, e);
        }
        return max;
    }

    public static final long m1219maxOfR03FKyM(long a, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long max = a;
        int iM241getSizeimpl = ULongArray.m241getSizeimpl(other);
        for (int i = 0; i < iM241getSizeimpl; i++) {
            long e = ULongArray.m240getsVKNKU(other, i);
            max = UComparisonsKt.m1224maxOfeb3DHEI(max, e);
        }
        return max;
    }

    public static final byte m1222maxOfWr6uiD8(byte a, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte max = a;
        int iM83getSizeimpl = UByteArray.m83getSizeimpl(other);
        for (int i = 0; i < iM83getSizeimpl; i++) {
            byte e = UByteArray.m82getw2LRezQ(other, i);
            max = UComparisonsKt.m1217maxOfKr8caGY(max, e);
        }
        return max;
    }

    public static final short m1226maxOft1qELG4(short a, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short max = a;
        int iM346getSizeimpl = UShortArray.m346getSizeimpl(other);
        for (int i = 0; i < iM346getSizeimpl; i++) {
            short e = UShortArray.m345getMh2AYeg(other, i);
            max = UComparisonsKt.m1215maxOf5PvTz6A(max, e);
        }
        return max;
    }

    public static final int m1228minOfJ1ME1BU(int a, int b) {
        return Integer.compareUnsigned(a, b) <= 0 ? a : b;
    }

    public static final long m1236minOfeb3DHEI(long a, long b) {
        return Long.compareUnsigned(a, b) <= 0 ? a : b;
    }

    public static final byte m1229minOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare(a & UByte.MAX_VALUE, b & UByte.MAX_VALUE) <= 0 ? a : b;
    }

    public static final short m1227minOf5PvTz6A(short a, short b) {
        return Intrinsics.compare(a & UShort.MAX_VALUE, 65535 & b) <= 0 ? a : b;
    }

    private static final int m1233minOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m1228minOfJ1ME1BU(a, UComparisonsKt.m1228minOfJ1ME1BU(b, c));
    }

    private static final long m1237minOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m1236minOfeb3DHEI(a, UComparisonsKt.m1236minOfeb3DHEI(b, c));
    }

    private static final byte m1235minOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m1229minOfKr8caGY(a, UComparisonsKt.m1229minOfKr8caGY(b, c));
    }

    private static final short m1232minOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m1227minOf5PvTz6A(a, UComparisonsKt.m1227minOf5PvTz6A(b, c));
    }

    public static final int m1230minOfMd2H83M(int a, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = a;
        int iM162getSizeimpl = UIntArray.m162getSizeimpl(other);
        for (int i = 0; i < iM162getSizeimpl; i++) {
            int e = UIntArray.m161getpVg5ArA(other, i);
            min = UComparisonsKt.m1228minOfJ1ME1BU(min, e);
        }
        return min;
    }

    public static final long m1231minOfR03FKyM(long a, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long min = a;
        int iM241getSizeimpl = ULongArray.m241getSizeimpl(other);
        for (int i = 0; i < iM241getSizeimpl; i++) {
            long e = ULongArray.m240getsVKNKU(other, i);
            min = UComparisonsKt.m1236minOfeb3DHEI(min, e);
        }
        return min;
    }

    public static final byte m1234minOfWr6uiD8(byte a, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte min = a;
        int iM83getSizeimpl = UByteArray.m83getSizeimpl(other);
        for (int i = 0; i < iM83getSizeimpl; i++) {
            byte e = UByteArray.m82getw2LRezQ(other, i);
            min = UComparisonsKt.m1229minOfKr8caGY(min, e);
        }
        return min;
    }

    public static final short m1238minOft1qELG4(short a, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short min = a;
        int iM346getSizeimpl = UShortArray.m346getSizeimpl(other);
        for (int i = 0; i < iM346getSizeimpl; i++) {
            short e = UShortArray.m345getMh2AYeg(other, i);
            min = UComparisonsKt.m1227minOf5PvTz6A(min, e);
        }
        return min;
    }
}
