package ni.shikatu.kotlin;

import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\n\u0010\u0004\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\f\u0010\u0004\u001a'\u0010\r\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u000e\u0010\u0004\u001a'\u0010\u000f\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0010\u0010\u0004\u001a/\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\u0017\u0010\u0014\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001b\u0010\u001a\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001c\u0010\u001a\u001a'\u0010\r\u001a\u00020\u0018*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010\u000f\u001a\u00020\u0018*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001f\u0010\u001e\u001a/\u0010\u0011\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b \u0010!\u001a/\u0010\u0016\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\"\u0010!\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b$\u0010%\u001a'\u0010\t\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b&\u0010%\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b'\u0010%\u001a'\u0010\r\u001a\u00020#*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b(\u0010)\u001a'\u0010\u000f\u001a\u00020#*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b*\u0010)\u001a/\u0010\u0011\u001a\u00020#*\u00020#2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b+\u0010,\u001a/\u0010\u0016\u001a\u00020#*\u00020#2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b-\u0010,\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b/\u00100\u001a'\u0010\t\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b1\u00100\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b2\u00100\u001a'\u0010\r\u001a\u00020.*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b3\u00104\u001a'\u0010\u000f\u001a\u00020.*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b5\u00104\u001a/\u0010\u0011\u001a\u00020.*\u00020.2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b6\u00107\u001a/\u0010\u0016\u001a\u00020.*\u00020.2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b8\u00107¨\u00069"}, d2 = {"countOneBits", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UInt;", "countOneBits-WZ4Q5Ns", "(I)I", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.5", "Lni/shikatu/kotlin/internal/InlineOnly;", "countLeadingZeroBits", "countLeadingZeroBits-WZ4Q5Ns", "countTrailingZeroBits", "countTrailingZeroBits-WZ4Q5Ns", "takeHighestOneBit", "takeHighestOneBit-WZ4Q5Ns", "takeLowestOneBit", "takeLowestOneBit-WZ4Q5Ns", "rotateLeft", "bitCount", "rotateLeft-V7xB4Y4", "(II)I", "1.6", "rotateRight", "rotateRight-V7xB4Y4", "Lni/shikatu/kotlin/ULong;", "countOneBits-VKZWuLQ", "(J)I", "countLeadingZeroBits-VKZWuLQ", "countTrailingZeroBits-VKZWuLQ", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeLowestOneBit-VKZWuLQ", "rotateLeft-JSWoG40", "(JI)J", "rotateRight-JSWoG40", "Lni/shikatu/kotlin/UByte;", "countOneBits-7apg3OU", "(B)I", "countLeadingZeroBits-7apg3OU", "countTrailingZeroBits-7apg3OU", "takeHighestOneBit-7apg3OU", "(B)B", "takeLowestOneBit-7apg3OU", "rotateLeft-LxnNnR4", "(BI)B", "rotateRight-LxnNnR4", "Lni/shikatu/kotlin/UShort;", "countOneBits-xj2QHRw", "(S)I", "countLeadingZeroBits-xj2QHRw", "countTrailingZeroBits-xj2QHRw", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit-xj2QHRw", "rotateLeft-olVBNx4", "(SI)S", "rotateRight-olVBNx4", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class UNumbersKt {

    private static final int m258countOneBitsWZ4Q5Ns(int $this$countOneBits_u2dWZ4Q5Ns) {
        return Integer.bitCount($this$countOneBits_u2dWZ4Q5Ns);
    }

    private static final int m254countLeadingZeroBitsWZ4Q5Ns(int $this$countLeadingZeroBits_u2dWZ4Q5Ns) {
        return Integer.numberOfLeadingZeros($this$countLeadingZeroBits_u2dWZ4Q5Ns);
    }

    private static final int m262countTrailingZeroBitsWZ4Q5Ns(int $this$countTrailingZeroBits_u2dWZ4Q5Ns) {
        return Integer.numberOfTrailingZeros($this$countTrailingZeroBits_u2dWZ4Q5Ns);
    }

    private static final int m274takeHighestOneBitWZ4Q5Ns(int $this$takeHighestOneBit_u2dWZ4Q5Ns) {
        return UInt.m101constructorimpl(Integer.highestOneBit($this$takeHighestOneBit_u2dWZ4Q5Ns));
    }

    private static final int m278takeLowestOneBitWZ4Q5Ns(int $this$takeLowestOneBit_u2dWZ4Q5Ns) {
        return UInt.m101constructorimpl(Integer.lowestOneBit($this$takeLowestOneBit_u2dWZ4Q5Ns));
    }

    private static final int m266rotateLeftV7xB4Y4(int $this$rotateLeft_u2dV7xB4Y4, int bitCount) {
        return UInt.m101constructorimpl(Integer.rotateLeft($this$rotateLeft_u2dV7xB4Y4, bitCount));
    }

    private static final int m270rotateRightV7xB4Y4(int $this$rotateRight_u2dV7xB4Y4, int bitCount) {
        return UInt.m101constructorimpl(Integer.rotateRight($this$rotateRight_u2dV7xB4Y4, bitCount));
    }

    private static final int m257countOneBitsVKZWuLQ(long $this$countOneBits_u2dVKZWuLQ) {
        return Long.bitCount($this$countOneBits_u2dVKZWuLQ);
    }

    private static final int m253countLeadingZeroBitsVKZWuLQ(long $this$countLeadingZeroBits_u2dVKZWuLQ) {
        return Long.numberOfLeadingZeros($this$countLeadingZeroBits_u2dVKZWuLQ);
    }

    private static final int m261countTrailingZeroBitsVKZWuLQ(long $this$countTrailingZeroBits_u2dVKZWuLQ) {
        return Long.numberOfTrailingZeros($this$countTrailingZeroBits_u2dVKZWuLQ);
    }

    private static final long m273takeHighestOneBitVKZWuLQ(long $this$takeHighestOneBit_u2dVKZWuLQ) {
        return ULong.m180constructorimpl(Long.highestOneBit($this$takeHighestOneBit_u2dVKZWuLQ));
    }

    private static final long m277takeLowestOneBitVKZWuLQ(long $this$takeLowestOneBit_u2dVKZWuLQ) {
        return ULong.m180constructorimpl(Long.lowestOneBit($this$takeLowestOneBit_u2dVKZWuLQ));
    }

    private static final long m264rotateLeftJSWoG40(long $this$rotateLeft_u2dJSWoG40, int bitCount) {
        return ULong.m180constructorimpl(Long.rotateLeft($this$rotateLeft_u2dJSWoG40, bitCount));
    }

    private static final long m268rotateRightJSWoG40(long $this$rotateRight_u2dJSWoG40, int bitCount) {
        return ULong.m180constructorimpl(Long.rotateRight($this$rotateRight_u2dJSWoG40, bitCount));
    }

    private static final int m256countOneBits7apg3OU(byte $this$countOneBits_u2d7apg3OU) {
        return Integer.bitCount(UInt.m101constructorimpl($this$countOneBits_u2d7apg3OU & UByte.MAX_VALUE));
    }

    private static final int m252countLeadingZeroBits7apg3OU(byte $this$countLeadingZeroBits_u2d7apg3OU) {
        return Integer.numberOfLeadingZeros($this$countLeadingZeroBits_u2d7apg3OU & UByte.MAX_VALUE) - 24;
    }

    private static final int m260countTrailingZeroBits7apg3OU(byte $this$countTrailingZeroBits_u2d7apg3OU) {
        return Integer.numberOfTrailingZeros($this$countTrailingZeroBits_u2d7apg3OU | 256);
    }

    private static final byte m272takeHighestOneBit7apg3OU(byte $this$takeHighestOneBit_u2d7apg3OU) {
        return UByte.m24constructorimpl((byte) Integer.highestOneBit($this$takeHighestOneBit_u2d7apg3OU & UByte.MAX_VALUE));
    }

    private static final byte m276takeLowestOneBit7apg3OU(byte $this$takeLowestOneBit_u2d7apg3OU) {
        return UByte.m24constructorimpl((byte) Integer.lowestOneBit($this$takeLowestOneBit_u2d7apg3OU & UByte.MAX_VALUE));
    }

    private static final byte m265rotateLeftLxnNnR4(byte $this$rotateLeft_u2dLxnNnR4, int bitCount) {
        return UByte.m24constructorimpl(NumbersKt.rotateLeft($this$rotateLeft_u2dLxnNnR4, bitCount));
    }

    private static final byte m269rotateRightLxnNnR4(byte $this$rotateRight_u2dLxnNnR4, int bitCount) {
        return UByte.m24constructorimpl(NumbersKt.rotateRight($this$rotateRight_u2dLxnNnR4, bitCount));
    }

    private static final int m259countOneBitsxj2QHRw(short $this$countOneBits_u2dxj2QHRw) {
        return Integer.bitCount(UInt.m101constructorimpl(65535 & $this$countOneBits_u2dxj2QHRw));
    }

    private static final int m255countLeadingZeroBitsxj2QHRw(short $this$countLeadingZeroBits_u2dxj2QHRw) {
        return Integer.numberOfLeadingZeros(65535 & $this$countLeadingZeroBits_u2dxj2QHRw) - 16;
    }

    private static final int m263countTrailingZeroBitsxj2QHRw(short $this$countTrailingZeroBits_u2dxj2QHRw) {
        return Integer.numberOfTrailingZeros(65536 | $this$countTrailingZeroBits_u2dxj2QHRw);
    }

    private static final short m275takeHighestOneBitxj2QHRw(short $this$takeHighestOneBit_u2dxj2QHRw) {
        return UShort.m287constructorimpl((short) Integer.highestOneBit(65535 & $this$takeHighestOneBit_u2dxj2QHRw));
    }

    private static final short m279takeLowestOneBitxj2QHRw(short $this$takeLowestOneBit_u2dxj2QHRw) {
        return UShort.m287constructorimpl((short) Integer.lowestOneBit(65535 & $this$takeLowestOneBit_u2dxj2QHRw));
    }

    private static final short m267rotateLeftolVBNx4(short $this$rotateLeft_u2dolVBNx4, int bitCount) {
        return UShort.m287constructorimpl(NumbersKt.rotateLeft($this$rotateLeft_u2dolVBNx4, bitCount));
    }

    private static final short m271rotateRightolVBNx4(short $this$rotateRight_u2dolVBNx4, int bitCount) {
        return UShort.m287constructorimpl(NumbersKt.rotateRight($this$rotateRight_u2dolVBNx4, bitCount));
    }
}
