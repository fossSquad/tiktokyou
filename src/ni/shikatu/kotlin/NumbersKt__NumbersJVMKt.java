package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.internal.DoubleCompanionObject;
import ni.shikatu.kotlin.jvm.internal.FloatCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0003\u001a \u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0002\b\u0003\u001a \u0010\f\u001a\u00020\b*\u00020\u0002H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0002\b\u0003\u001a(\u0010\r\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0002\b\u0003\u001a \u0010\u0007\u001a\u00020\u0010*\u00020\u0004H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0002\b\u0003\u001a \u0010\f\u001a\u00020\u0010*\u00020\u0004H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0002\b\u0003\u001a(\u0010\r\u001a\u00020\u0004*\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0002\b\u0003\u001a \u0010\u0012\u001a\u00020\u0010*\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a \u0010\u0014\u001a\u00020\u0010*\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a \u0010\u0015\u001a\u00020\u0010*\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a \u0010\u0016\u001a\u00020\u0010*\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a \u0010\u0017\u001a\u00020\u0010*\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a(\u0010\u0018\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001ab\u0002\b\u0003\u001a(\u0010\u001b\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001ab\u0002\b\u0003\u001a \u0010\u0012\u001a\u00020\u0010*\u00020\bH\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a \u0010\u0014\u001a\u00020\u0010*\u00020\bH\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a \u0010\u0015\u001a\u00020\u0010*\u00020\bH\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a \u0010\u0016\u001a\u00020\b*\u00020\bH\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a \u0010\u0017\u001a\u00020\b*\u00020\bH\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013b\u0002\b\u0003\u001a(\u0010\u0018\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001ab\u0002\b\u0003\u001a(\u0010\u001b\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0010H\u0087\u0088\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001ab\u0002\b\u0003¨\u0006\u001c"}, d2 = {"isNaN", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", _UrlKt.FRAGMENT_ENCODE_SET, "isInfinite", "isFinite", "toBits", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", "toRawBits", "fromBits", "Lni/shikatu/kotlin/Double$Companion;", "bits", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Float$Companion;", "countOneBits", "1.4", "countLeadingZeroBits", "countTrailingZeroBits", "takeHighestOneBit", "takeLowestOneBit", "rotateLeft", "bitCount", "1.6", "rotateRight", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    private static final boolean isNaN(double $this$isNaN) {
        return Double.isNaN($this$isNaN);
    }

    private static final boolean isNaN(float $this$isNaN) {
        return Float.isNaN($this$isNaN);
    }

    private static final boolean isInfinite(double $this$isInfinite) {
        return Double.isInfinite($this$isInfinite);
    }

    private static final boolean isInfinite(float $this$isInfinite) {
        return Float.isInfinite($this$isInfinite);
    }

    private static final boolean isFinite(double $this$isFinite) {
        return Math.abs($this$isFinite) <= Double.MAX_VALUE;
    }

    private static final boolean isFinite(float $this$isFinite) {
        return Math.abs($this$isFinite) <= Float.MAX_VALUE;
    }

    private static final long toBits(double $this$toBits) {
        return Double.doubleToLongBits($this$toBits);
    }

    private static final long toRawBits(double $this$toRawBits) {
        return Double.doubleToRawLongBits($this$toRawBits);
    }

    private static final double fromBits(DoubleCompanionObject $this$fromBits, long bits) {
        Intrinsics.checkNotNullParameter($this$fromBits, "<this>");
        return Double.longBitsToDouble(bits);
    }

    private static final int toBits(float $this$toBits) {
        return Float.floatToIntBits($this$toBits);
    }

    private static final int toRawBits(float $this$toRawBits) {
        return Float.floatToRawIntBits($this$toRawBits);
    }

    private static final float fromBits(FloatCompanionObject $this$fromBits, int bits) {
        Intrinsics.checkNotNullParameter($this$fromBits, "<this>");
        return Float.intBitsToFloat(bits);
    }

    private static final int countOneBits(int $this$countOneBits) {
        return Integer.bitCount($this$countOneBits);
    }

    private static final int countLeadingZeroBits(int $this$countLeadingZeroBits) {
        return Integer.numberOfLeadingZeros($this$countLeadingZeroBits);
    }

    private static final int countTrailingZeroBits(int $this$countTrailingZeroBits) {
        return Integer.numberOfTrailingZeros($this$countTrailingZeroBits);
    }

    private static final int takeHighestOneBit(int $this$takeHighestOneBit) {
        return Integer.highestOneBit($this$takeHighestOneBit);
    }

    private static final int takeLowestOneBit(int $this$takeLowestOneBit) {
        return Integer.lowestOneBit($this$takeLowestOneBit);
    }

    private static final int rotateLeft(int $this$rotateLeft, int bitCount) {
        return Integer.rotateLeft($this$rotateLeft, bitCount);
    }

    private static final int rotateRight(int $this$rotateRight, int bitCount) {
        return Integer.rotateRight($this$rotateRight, bitCount);
    }

    private static final int countOneBits(long $this$countOneBits) {
        return Long.bitCount($this$countOneBits);
    }

    private static final int countLeadingZeroBits(long $this$countLeadingZeroBits) {
        return Long.numberOfLeadingZeros($this$countLeadingZeroBits);
    }

    private static final int countTrailingZeroBits(long $this$countTrailingZeroBits) {
        return Long.numberOfTrailingZeros($this$countTrailingZeroBits);
    }

    private static final long takeHighestOneBit(long $this$takeHighestOneBit) {
        return Long.highestOneBit($this$takeHighestOneBit);
    }

    private static final long takeLowestOneBit(long $this$takeLowestOneBit) {
        return Long.lowestOneBit($this$takeLowestOneBit);
    }

    private static final long rotateLeft(long $this$rotateLeft, int bitCount) {
        return Long.rotateLeft($this$rotateLeft, bitCount);
    }

    private static final long rotateRight(long $this$rotateRight, int bitCount) {
        return Long.rotateRight($this$rotateRight, bitCount);
    }
}
