package ni.shikatu.kotlin.comparisons;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a(\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a\u001f\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b'\u0010\b\u001a\u001f\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b(\u0010\u000b\u001a\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b)\u0010\u000e\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a(\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b+\u0010\u0013\u001a(\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b,\u0010\u0015\u001a(\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b-\u0010\u0017\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b.\u0010\u001b\u001a#\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b/\u0010\u001e\u001a#\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lni/shikatu/kotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lni/shikatu/kotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lni/shikatu/kotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lni/shikatu/kotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lni/shikatu/kotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lni/shikatu/kotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lni/shikatu/kotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lni/shikatu/kotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/comparisons/UComparisonsKt")
public class UComparisonsKt___UComparisonsKt {

    public static final int m1193maxOfJ1ME1BU(int a, int b) {
        return Integer.compareUnsigned(a, b) >= 0 ? a : b;
    }

    public static final long m1201maxOfeb3DHEI(long a, long b) {
        return Long.compareUnsigned(a, b) >= 0 ? a : b;
    }

    public static final byte m1194maxOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare(a & UByte.MAX_VALUE, b & UByte.MAX_VALUE) >= 0 ? a : b;
    }

    public static final short m1192maxOf5PvTz6A(short a, short b) {
        return Intrinsics.compare(a & UShort.MAX_VALUE, 65535 & b) >= 0 ? a : b;
    }

    private static final int m1198maxOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m1193maxOfJ1ME1BU(a, UComparisonsKt.m1193maxOfJ1ME1BU(b, c));
    }

    private static final long m1202maxOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m1201maxOfeb3DHEI(a, UComparisonsKt.m1201maxOfeb3DHEI(b, c));
    }

    private static final byte m1200maxOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m1194maxOfKr8caGY(a, UComparisonsKt.m1194maxOfKr8caGY(b, c));
    }

    private static final short m1197maxOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m1192maxOf5PvTz6A(a, UComparisonsKt.m1192maxOf5PvTz6A(b, c));
    }

    public static final int m1195maxOfMd2H83M(int a, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int max = a;
        int iM160getSizeimpl = UIntArray.m160getSizeimpl(other);
        for (int i = 0; i < iM160getSizeimpl; i++) {
            int e = UIntArray.m159getpVg5ArA(other, i);
            max = UComparisonsKt.m1193maxOfJ1ME1BU(max, e);
        }
        return max;
    }

    public static final long m1196maxOfR03FKyM(long a, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long max = a;
        int iM239getSizeimpl = ULongArray.m239getSizeimpl(other);
        for (int i = 0; i < iM239getSizeimpl; i++) {
            long e = ULongArray.m238getsVKNKU(other, i);
            max = UComparisonsKt.m1201maxOfeb3DHEI(max, e);
        }
        return max;
    }

    public static final byte m1199maxOfWr6uiD8(byte a, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte max = a;
        int iM81getSizeimpl = UByteArray.m81getSizeimpl(other);
        for (int i = 0; i < iM81getSizeimpl; i++) {
            byte e = UByteArray.m80getw2LRezQ(other, i);
            max = UComparisonsKt.m1194maxOfKr8caGY(max, e);
        }
        return max;
    }

    public static final short m1203maxOft1qELG4(short a, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short max = a;
        int iM344getSizeimpl = UShortArray.m344getSizeimpl(other);
        for (int i = 0; i < iM344getSizeimpl; i++) {
            short e = UShortArray.m343getMh2AYeg(other, i);
            max = UComparisonsKt.m1192maxOf5PvTz6A(max, e);
        }
        return max;
    }

    public static final int m1205minOfJ1ME1BU(int a, int b) {
        return Integer.compareUnsigned(a, b) <= 0 ? a : b;
    }

    public static final long m1213minOfeb3DHEI(long a, long b) {
        return Long.compareUnsigned(a, b) <= 0 ? a : b;
    }

    public static final byte m1206minOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare(a & UByte.MAX_VALUE, b & UByte.MAX_VALUE) <= 0 ? a : b;
    }

    public static final short m1204minOf5PvTz6A(short a, short b) {
        return Intrinsics.compare(a & UShort.MAX_VALUE, 65535 & b) <= 0 ? a : b;
    }

    private static final int m1210minOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m1205minOfJ1ME1BU(a, UComparisonsKt.m1205minOfJ1ME1BU(b, c));
    }

    private static final long m1214minOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m1213minOfeb3DHEI(a, UComparisonsKt.m1213minOfeb3DHEI(b, c));
    }

    private static final byte m1212minOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m1206minOfKr8caGY(a, UComparisonsKt.m1206minOfKr8caGY(b, c));
    }

    private static final short m1209minOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m1204minOf5PvTz6A(a, UComparisonsKt.m1204minOf5PvTz6A(b, c));
    }

    public static final int m1207minOfMd2H83M(int a, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = a;
        int iM160getSizeimpl = UIntArray.m160getSizeimpl(other);
        for (int i = 0; i < iM160getSizeimpl; i++) {
            int e = UIntArray.m159getpVg5ArA(other, i);
            min = UComparisonsKt.m1205minOfJ1ME1BU(min, e);
        }
        return min;
    }

    public static final long m1208minOfR03FKyM(long a, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long min = a;
        int iM239getSizeimpl = ULongArray.m239getSizeimpl(other);
        for (int i = 0; i < iM239getSizeimpl; i++) {
            long e = ULongArray.m238getsVKNKU(other, i);
            min = UComparisonsKt.m1213minOfeb3DHEI(min, e);
        }
        return min;
    }

    public static final byte m1211minOfWr6uiD8(byte a, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte min = a;
        int iM81getSizeimpl = UByteArray.m81getSizeimpl(other);
        for (int i = 0; i < iM81getSizeimpl; i++) {
            byte e = UByteArray.m80getw2LRezQ(other, i);
            min = UComparisonsKt.m1206minOfKr8caGY(min, e);
        }
        return min;
    }

    public static final short m1215minOft1qELG4(short a, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short min = a;
        int iM344getSizeimpl = UShortArray.m344getSizeimpl(other);
        for (int i = 0; i < iM344getSizeimpl; i++) {
            short e = UShortArray.m343getMh2AYeg(other, i);
            min = UComparisonsKt.m1204minOf5PvTz6A(min, e);
        }
        return min;
    }
}
