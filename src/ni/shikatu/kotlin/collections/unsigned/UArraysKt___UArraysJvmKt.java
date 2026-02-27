package ni.shikatu.kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.UnsignedKt;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0000\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014*\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014*\u00020\bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014*\u00020\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014*\u00020\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\"\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b#\u0010$\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b%\u0010&\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0007¢\u0006\u0004\b,\u0010-\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000b*\u00020\fH\u0007¢\u0006\u0004\b.\u0010/\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0007¢\u0006\u0004\b0\u00101\u001a=\u00102\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a=\u00102\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a=\u00102\u001a\u0004\u0018\u00010\u000b\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a=\u00102\u001a\u0004\u0018\u00010\u000f\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a1\u0010?\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`BH\u0007¢\u0006\u0004\bC\u0010D\u001a1\u0010?\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0007`BH\u0007¢\u0006\u0004\bE\u0010F\u001a1\u0010?\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000b0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000b`BH\u0007¢\u0006\u0004\bG\u0010H\u001a1\u0010?\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000f`BH\u0007¢\u0006\u0004\bI\u0010J\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0004\bL\u0010+\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0007¢\u0006\u0004\bM\u0010-\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000b*\u00020\fH\u0007¢\u0006\u0004\bN\u0010/\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0007¢\u0006\u0004\bO\u00101\u001a=\u0010P\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a=\u0010P\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a=\u0010P\u001a\u0004\u0018\u00010\u000b\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a=\u0010P\u001a\u0004\u0018\u00010\u000f\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a1\u0010U\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`BH\u0007¢\u0006\u0004\bV\u0010D\u001a1\u0010U\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0007`BH\u0007¢\u0006\u0004\bW\u0010F\u001a1\u0010U\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000b0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000b`BH\u0007¢\u0006\u0004\bX\u0010H\u001a1\u0010U\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000f`BH\u0007¢\u0006\u0004\bY\u0010J\u001a+\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a+\u0010Z\u001a\u00020[*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010^\u001a+\u0010Z\u001a\u00020[*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010_\u001a+\u0010Z\u001a\u00020[*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010`\u001a+\u0010Z\u001a\u00020a*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a+\u0010Z\u001a\u00020a*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010d\u001a+\u0010Z\u001a\u00020a*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010e\u001a+\u0010Z\u001a\u00020a*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006g"}, d2 = {"elementAt", "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/UIntArray;", "index", "", "elementAt-qFRl0hI", "([II)I", "Lni/shikatu/kotlin/ULong;", "Lni/shikatu/kotlin/ULongArray;", "elementAt-r7IrZao", "([JI)J", "Lni/shikatu/kotlin/UByte;", "Lni/shikatu/kotlin/UByteArray;", "elementAt-PpDY95g", "([BI)B", "Lni/shikatu/kotlin/UShort;", "Lni/shikatu/kotlin/UShortArray;", "elementAt-nggk6HY", "([SI)S", "asList", "", "asList--ajY-9A", "([I)Ljava/util/List;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "max", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lni/shikatu/kotlin/Function1;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min--ajY-9A", "min-QwZRm1k", "min-GBYM_sE", "min-rL5Bavg", "minBy", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-JOV_ifY", "minBy-xTcfx_M", "minWith", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-XMRcp5o", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, pn = "ni.shikatu.kotlin.collections", xi = 49, xs = "ni/shikatu/kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {

    private static final int m490elementAtqFRl0hI(int[] $this$elementAt_u2dqFRl0hI, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dqFRl0hI, "$this$elementAt");
        return UIntArray.m159getpVg5ArA($this$elementAt_u2dqFRl0hI, index);
    }

    private static final long m491elementAtr7IrZao(long[] $this$elementAt_u2dr7IrZao, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dr7IrZao, "$this$elementAt");
        return ULongArray.m238getsVKNKU($this$elementAt_u2dr7IrZao, index);
    }

    private static final byte m488elementAtPpDY95g(byte[] $this$elementAt_u2dPpDY95g, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dPpDY95g, "$this$elementAt");
        return UByteArray.m80getw2LRezQ($this$elementAt_u2dPpDY95g, index);
    }

    private static final short m489elementAtnggk6HY(short[] $this$elementAt_u2dnggk6HY, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dnggk6HY, "$this$elementAt");
        return UShortArray.m343getMh2AYeg($this$elementAt_u2dnggk6HY, index);
    }

    public static final List<UInt> m476asListajY9A(int[] $this$asList_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$asList_u2d_u2dajY_u2d9A, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1($this$asList_u2d_u2dajY_u2d9A);
    }

    public static final List<ULong> m478asListQwZRm1k(long[] $this$asList_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$asList_u2dQwZRm1k, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2($this$asList_u2dQwZRm1k);
    }

    public static final List<UByte> m477asListGBYM_sE(byte[] $this$asList_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$asList_u2dGBYM_sE, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3($this$asList_u2dGBYM_sE);
    }

    public static final List<UShort> m479asListrL5Bavg(short[] $this$asList_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$asList_u2drL5Bavg, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4($this$asList_u2drL5Bavg);
    }

    public static  int m481binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m160getSizeimpl(iArr);
        }
        return UArraysKt.m480binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    public static final int m480binarySearch2fe2U9s(int[] $this$binarySearch_u2d2fe2U9s, int element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2d2fe2U9s, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UIntArray.m160getSizeimpl($this$binarySearch_u2d2fe2U9s));
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = $this$binarySearch_u2d2fe2U9s[mid];
            int cmp = UnsignedKt.uintCompare(midVal, element);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static  int m485binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m239getSizeimpl(jArr);
        }
        return UArraysKt.m484binarySearchK6DWlUc(jArr, j, i, i2);
    }

    public static final int m484binarySearchK6DWlUc(long[] $this$binarySearch_u2dK6DWlUc, long element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dK6DWlUc, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, ULongArray.m239getSizeimpl($this$binarySearch_u2dK6DWlUc));
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = $this$binarySearch_u2dK6DWlUc[mid];
            int cmp = UnsignedKt.ulongCompare(midVal, element);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static  int m487binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m81getSizeimpl(bArr);
        }
        return UArraysKt.m486binarySearchWpHrYlw(bArr, b, i, i2);
    }

    public static final int m486binarySearchWpHrYlw(byte[] $this$binarySearch_u2dWpHrYlw, byte element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dWpHrYlw, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UByteArray.m81getSizeimpl($this$binarySearch_u2dWpHrYlw));
        int signedElement = element & UByte.MAX_VALUE;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            byte midVal = $this$binarySearch_u2dWpHrYlw[mid];
            int cmp = UnsignedKt.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static  int m483binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m344getSizeimpl(sArr);
        }
        return UArraysKt.m482binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    public static final int m482binarySearchEtDCXyQ(short[] $this$binarySearch_u2dEtDCXyQ, short element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dEtDCXyQ, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UShortArray.m344getSizeimpl($this$binarySearch_u2dEtDCXyQ));
        int signedElement = 65535 & element;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = $this$binarySearch_u2dEtDCXyQ[mid];
            int cmp = UnsignedKt.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UInt m492maxajY9A(int[] $this$max_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$max_u2d_u2dajY_u2d9A, "$this$max");
        return UArraysKt.m861maxOrNullajY9A($this$max_u2d_u2dajY_u2d9A);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  ULong m494maxQwZRm1k(long[] $this$max_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$max_u2dQwZRm1k, "$this$max");
        return UArraysKt.m863maxOrNullQwZRm1k($this$max_u2dQwZRm1k);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UByte m493maxGBYM_sE(byte[] $this$max_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$max_u2dGBYM_sE, "$this$max");
        return UArraysKt.m862maxOrNullGBYM_sE($this$max_u2dGBYM_sE);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UShort m495maxrL5Bavg(short[] $this$max_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$max_u2drL5Bavg, "$this$max");
        return UArraysKt.m864maxOrNullrL5Bavg($this$max_u2drL5Bavg);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UInt m498maxByjgv0xPQ(int[] $this$maxBy_u2djgv0xPQ, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy_u2djgv0xPQ, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UIntArray.m162isEmptyimpl($this$maxBy_u2djgv0xPQ)) {
            return null;
        }
        int iM159getpVg5ArA = UIntArray.m159getpVg5ArA($this$maxBy_u2djgv0xPQ, 0);
        int lastIndex = ArraysKt.getLastIndex($this$maxBy_u2djgv0xPQ);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UInt.m93boximpl(iM159getpVg5ArA));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM159getpVg5ArA2 = UIntArray.m159getpVg5ArA($this$maxBy_u2djgv0xPQ, i);
                    R rInvoke2 = function1.invoke(UInt.m93boximpl(iM159getpVg5ArA2));
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        iM159getpVg5ArA = iM159getpVg5ArA2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UInt.m93boximpl(iM159getpVg5ArA);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> ULong m497maxByMShoTSo(long[] $this$maxBy_u2dMShoTSo, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy_u2dMShoTSo, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (ULongArray.m241isEmptyimpl($this$maxBy_u2dMShoTSo)) {
            return null;
        }
        long jM238getsVKNKU = ULongArray.m238getsVKNKU($this$maxBy_u2dMShoTSo, 0);
        int lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dMShoTSo);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(ULong.m172boximpl(jM238getsVKNKU));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM238getsVKNKU2 = ULongArray.m238getsVKNKU($this$maxBy_u2dMShoTSo, i);
                    R rInvoke2 = function1.invoke(ULong.m172boximpl(jM238getsVKNKU2));
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        jM238getsVKNKU = jM238getsVKNKU2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return ULong.m172boximpl(jM238getsVKNKU);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UByte m496maxByJOV_ifY(byte[] $this$maxBy_u2dJOV_ifY, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy_u2dJOV_ifY, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UByteArray.m83isEmptyimpl($this$maxBy_u2dJOV_ifY)) {
            return null;
        }
        byte bM80getw2LRezQ = UByteArray.m80getw2LRezQ($this$maxBy_u2dJOV_ifY, 0);
        int lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dJOV_ifY);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UByte.m16boximpl(bM80getw2LRezQ));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bM80getw2LRezQ2 = UByteArray.m80getw2LRezQ($this$maxBy_u2dJOV_ifY, i);
                    R rInvoke2 = function1.invoke(UByte.m16boximpl(bM80getw2LRezQ2));
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        bM80getw2LRezQ = bM80getw2LRezQ2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UByte.m16boximpl(bM80getw2LRezQ);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UShort m499maxByxTcfx_M(short[] $this$maxBy_u2dxTcfx_M, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$maxBy_u2dxTcfx_M, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UShortArray.m346isEmptyimpl($this$maxBy_u2dxTcfx_M)) {
            return null;
        }
        short sM343getMh2AYeg = UShortArray.m343getMh2AYeg($this$maxBy_u2dxTcfx_M, 0);
        int lastIndex = ArraysKt.getLastIndex($this$maxBy_u2dxTcfx_M);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UShort.m279boximpl(sM343getMh2AYeg));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM343getMh2AYeg2 = UShortArray.m343getMh2AYeg($this$maxBy_u2dxTcfx_M, i);
                    R rInvoke2 = function1.invoke(UShort.m279boximpl(sM343getMh2AYeg2));
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        sM343getMh2AYeg = sM343getMh2AYeg2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UShort.m279boximpl(sM343getMh2AYeg);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UInt m501maxWithYmdZ_VM(int[] $this$maxWith_u2dYmdZ_VM, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dYmdZ_VM, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m870maxWithOrNullYmdZ_VM($this$maxWith_u2dYmdZ_VM, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  ULong m503maxWithzrEWJaI(long[] $this$maxWith_u2dzrEWJaI, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dzrEWJaI, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m872maxWithOrNullzrEWJaI($this$maxWith_u2dzrEWJaI, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UByte m500maxWithXMRcp5o(byte[] $this$maxWith_u2dXMRcp5o, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2dXMRcp5o, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m869maxWithOrNullXMRcp5o($this$maxWith_u2dXMRcp5o, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UShort m502maxWitheOHTfZs(short[] $this$maxWith_u2deOHTfZs, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith_u2deOHTfZs, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m871maxWithOrNulleOHTfZs($this$maxWith_u2deOHTfZs, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UInt m504minajY9A(int[] $this$min_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$min_u2d_u2dajY_u2d9A, "$this$min");
        return UArraysKt.m917minOrNullajY9A($this$min_u2d_u2dajY_u2d9A);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  ULong m506minQwZRm1k(long[] $this$min_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$min_u2dQwZRm1k, "$this$min");
        return UArraysKt.m919minOrNullQwZRm1k($this$min_u2dQwZRm1k);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UByte m505minGBYM_sE(byte[] $this$min_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$min_u2dGBYM_sE, "$this$min");
        return UArraysKt.m918minOrNullGBYM_sE($this$min_u2dGBYM_sE);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UShort m507minrL5Bavg(short[] $this$min_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$min_u2drL5Bavg, "$this$min");
        return UArraysKt.m920minOrNullrL5Bavg($this$min_u2drL5Bavg);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UInt m510minByjgv0xPQ(int[] $this$minBy_u2djgv0xPQ, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy_u2djgv0xPQ, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UIntArray.m162isEmptyimpl($this$minBy_u2djgv0xPQ)) {
            return null;
        }
        int iM159getpVg5ArA = UIntArray.m159getpVg5ArA($this$minBy_u2djgv0xPQ, 0);
        int lastIndex = ArraysKt.getLastIndex($this$minBy_u2djgv0xPQ);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UInt.m93boximpl(iM159getpVg5ArA));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM159getpVg5ArA2 = UIntArray.m159getpVg5ArA($this$minBy_u2djgv0xPQ, i);
                    R rInvoke2 = function1.invoke(UInt.m93boximpl(iM159getpVg5ArA2));
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        iM159getpVg5ArA = iM159getpVg5ArA2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UInt.m93boximpl(iM159getpVg5ArA);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> ULong m509minByMShoTSo(long[] $this$minBy_u2dMShoTSo, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy_u2dMShoTSo, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (ULongArray.m241isEmptyimpl($this$minBy_u2dMShoTSo)) {
            return null;
        }
        long jM238getsVKNKU = ULongArray.m238getsVKNKU($this$minBy_u2dMShoTSo, 0);
        int lastIndex = ArraysKt.getLastIndex($this$minBy_u2dMShoTSo);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(ULong.m172boximpl(jM238getsVKNKU));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM238getsVKNKU2 = ULongArray.m238getsVKNKU($this$minBy_u2dMShoTSo, i);
                    R rInvoke2 = function1.invoke(ULong.m172boximpl(jM238getsVKNKU2));
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        jM238getsVKNKU = jM238getsVKNKU2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return ULong.m172boximpl(jM238getsVKNKU);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UByte m508minByJOV_ifY(byte[] $this$minBy_u2dJOV_ifY, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy_u2dJOV_ifY, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UByteArray.m83isEmptyimpl($this$minBy_u2dJOV_ifY)) {
            return null;
        }
        byte bM80getw2LRezQ = UByteArray.m80getw2LRezQ($this$minBy_u2dJOV_ifY, 0);
        int lastIndex = ArraysKt.getLastIndex($this$minBy_u2dJOV_ifY);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UByte.m16boximpl(bM80getw2LRezQ));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bM80getw2LRezQ2 = UByteArray.m80getw2LRezQ($this$minBy_u2dJOV_ifY, i);
                    R rInvoke2 = function1.invoke(UByte.m16boximpl(bM80getw2LRezQ2));
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        bM80getw2LRezQ = bM80getw2LRezQ2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UByte.m16boximpl(bM80getw2LRezQ);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    private static final  <R extends Comparable<? super R>> UShort m511minByxTcfx_M(short[] $this$minBy_u2dxTcfx_M, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.checkNotNullParameter($this$minBy_u2dxTcfx_M, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UShortArray.m346isEmptyimpl($this$minBy_u2dxTcfx_M)) {
            return null;
        }
        short sM343getMh2AYeg = UShortArray.m343getMh2AYeg($this$minBy_u2dxTcfx_M, 0);
        int lastIndex = ArraysKt.getLastIndex($this$minBy_u2dxTcfx_M);
        if (lastIndex != 0) {
            R rInvoke = function1.invoke(UShort.m279boximpl(sM343getMh2AYeg));
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM343getMh2AYeg2 = UShortArray.m343getMh2AYeg($this$minBy_u2dxTcfx_M, i);
                    R rInvoke2 = function1.invoke(UShort.m279boximpl(sM343getMh2AYeg2));
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        sM343getMh2AYeg = sM343getMh2AYeg2;
                        rInvoke = rInvoke2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        return UShort.m279boximpl(sM343getMh2AYeg);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UInt m513minWithYmdZ_VM(int[] $this$minWith_u2dYmdZ_VM, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dYmdZ_VM, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m926minWithOrNullYmdZ_VM($this$minWith_u2dYmdZ_VM, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  ULong m515minWithzrEWJaI(long[] $this$minWith_u2dzrEWJaI, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dzrEWJaI, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m928minWithOrNullzrEWJaI($this$minWith_u2dzrEWJaI, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UByte m512minWithXMRcp5o(byte[] $this$minWith_u2dXMRcp5o, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2dXMRcp5o, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m925minWithOrNullXMRcp5o($this$minWith_u2dXMRcp5o, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")

    public static final  UShort m514minWitheOHTfZs(short[] $this$minWith_u2deOHTfZs, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith_u2deOHTfZs, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m927minWithOrNulleOHTfZs($this$minWith_u2deOHTfZs, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(int[] $this$sumOf_u2djgv0xPQ, Function1<? super UInt, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM160getSizeimpl = UIntArray.m160getSizeimpl($this$sumOf_u2djgv0xPQ);
        for (int i = 0; i < iM160getSizeimpl; i++) {
            int element = UIntArray.m159getpVg5ArA($this$sumOf_u2djgv0xPQ, i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(UInt.m93boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(long[] $this$sumOf_u2dMShoTSo, Function1<? super ULong, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM239getSizeimpl = ULongArray.m239getSizeimpl($this$sumOf_u2dMShoTSo);
        for (int i = 0; i < iM239getSizeimpl; i++) {
            long element = ULongArray.m238getsVKNKU($this$sumOf_u2dMShoTSo, i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(ULong.m172boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] $this$sumOf_u2dJOV_ifY, Function1<? super UByte, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM81getSizeimpl = UByteArray.m81getSizeimpl($this$sumOf_u2dJOV_ifY);
        for (int i = 0; i < iM81getSizeimpl; i++) {
            byte element = UByteArray.m80getw2LRezQ($this$sumOf_u2dJOV_ifY, i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(UByte.m16boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(short[] $this$sumOf_u2dxTcfx_M, Function1<? super UShort, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal sum = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM344getSizeimpl = UShortArray.m344getSizeimpl($this$sumOf_u2dxTcfx_M);
        for (int i = 0; i < iM344getSizeimpl; i++) {
            short element = UShortArray.m343getMh2AYeg($this$sumOf_u2dxTcfx_M, i);
            BigDecimal bigDecimalAdd = sum.add(function1.invoke(UShort.m279boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(int[] $this$sumOf_u2djgv0xPQ, Function1<? super UInt, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM160getSizeimpl = UIntArray.m160getSizeimpl($this$sumOf_u2djgv0xPQ);
        for (int i = 0; i < iM160getSizeimpl; i++) {
            int element = UIntArray.m159getpVg5ArA($this$sumOf_u2djgv0xPQ, i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(UInt.m93boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(long[] $this$sumOf_u2dMShoTSo, Function1<? super ULong, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM239getSizeimpl = ULongArray.m239getSizeimpl($this$sumOf_u2dMShoTSo);
        for (int i = 0; i < iM239getSizeimpl; i++) {
            long element = ULongArray.m238getsVKNKU($this$sumOf_u2dMShoTSo, i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(ULong.m172boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(byte[] $this$sumOf_u2dJOV_ifY, Function1<? super UByte, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM81getSizeimpl = UByteArray.m81getSizeimpl($this$sumOf_u2dJOV_ifY);
        for (int i = 0; i < iM81getSizeimpl; i++) {
            byte element = UByteArray.m80getw2LRezQ($this$sumOf_u2dJOV_ifY, i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(UByte.m16boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(short[] $this$sumOf_u2dxTcfx_M, Function1<? super UShort, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger sum = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(...)");
        int iM344getSizeimpl = UShortArray.m344getSizeimpl($this$sumOf_u2dxTcfx_M);
        for (int i = 0; i < iM344getSizeimpl; i++) {
            short element = UShortArray.m343getMh2AYeg($this$sumOf_u2dxTcfx_M, i);
            BigInteger bigIntegerAdd = sum.add(function1.invoke(UShort.m279boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
            sum = bigIntegerAdd;
        }
        return sum;
    }
}
