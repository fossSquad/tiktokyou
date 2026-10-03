package ni.shikatu.kotlin;

import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u001a$\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\u0007\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\b\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\t\u001a\u00020\u000f*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\n\u001a\u00020\u000f*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000b\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u001a$\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r¨\u0006\u0010"}, d2 = {"countOneBits", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4", "Lni/shikatu/kotlin/internal/InlineOnly;", "countLeadingZeroBits", "countTrailingZeroBits", "takeHighestOneBit", "takeLowestOneBit", "rotateLeft", "bitCount", "1.6", "rotateRight", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/NumbersKt")
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    private static final int countOneBits(byte $this$countOneBits) {
        return Integer.bitCount($this$countOneBits & UByte.MAX_VALUE);
    }

    private static final int countLeadingZeroBits(byte $this$countLeadingZeroBits) {
        return Integer.numberOfLeadingZeros($this$countLeadingZeroBits & UByte.MAX_VALUE) - 24;
    }

    private static final int countTrailingZeroBits(byte $this$countTrailingZeroBits) {
        return Integer.numberOfTrailingZeros($this$countTrailingZeroBits | 256);
    }

    private static final byte takeHighestOneBit(byte $this$takeHighestOneBit) {
        return (byte) Integer.highestOneBit($this$takeHighestOneBit & UByte.MAX_VALUE);
    }

    private static final byte takeLowestOneBit(byte $this$takeLowestOneBit) {
        return (byte) Integer.lowestOneBit($this$takeLowestOneBit);
    }

    public static final byte rotateLeft(byte $this$rotateLeft, int bitCount) {
        return (byte) (($this$rotateLeft << (bitCount & 7)) | (($this$rotateLeft & KotlinVersion.MAX_COMPONENT_VALUE) >>> (8 - (bitCount & 7))));
    }

    public static final byte rotateRight(byte $this$rotateRight, int bitCount) {
        return (byte) (($this$rotateRight << (8 - (bitCount & 7))) | (($this$rotateRight & KotlinVersion.MAX_COMPONENT_VALUE) >>> (bitCount & 7)));
    }

    private static final int countOneBits(short $this$countOneBits) {
        return Integer.bitCount(65535 & $this$countOneBits);
    }

    private static final int countLeadingZeroBits(short $this$countLeadingZeroBits) {
        return Integer.numberOfLeadingZeros(65535 & $this$countLeadingZeroBits) - 16;
    }

    private static final int countTrailingZeroBits(short $this$countTrailingZeroBits) {
        return Integer.numberOfTrailingZeros(65536 | $this$countTrailingZeroBits);
    }

    private static final short takeHighestOneBit(short $this$takeHighestOneBit) {
        return (short) Integer.highestOneBit(65535 & $this$takeHighestOneBit);
    }

    private static final short takeLowestOneBit(short $this$takeLowestOneBit) {
        return (short) Integer.lowestOneBit($this$takeLowestOneBit);
    }

    public static final short rotateLeft(short $this$rotateLeft, int bitCount) {
        return (short) (($this$rotateLeft << (bitCount & 15)) | ((65535 & $this$rotateLeft) >>> (16 - (bitCount & 15))));
    }

    public static final short rotateRight(short $this$rotateRight, int bitCount) {
        return (short) (($this$rotateRight << (16 - (bitCount & 15))) | ((65535 & $this$rotateRight) >>> (bitCount & 15)));
    }
}
