package ni.shikatu.kotlin.uuid;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.ByteCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.HexExtensionsKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0019\u0010\u0004\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\b\u001a)\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u000e\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u0012\u001a!\u0010\u0013\u001a\u00020\n*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"uuidFromRandomBytes", "Lni/shikatu/kotlin/uuid/Uuid;", "randomBytes", "", "toLong", "", "startIndex", "", "toLong$UuidKt__UuidKt", "formatBytesInto", "", "dst", "dstOffset", "count", "formatBytesInto$UuidKt__UuidKt", "checkHyphenAt", "", "index", "checkHyphenAt$UuidKt__UuidKt", "toByteArray", "toByteArray$UuidKt__UuidKt", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/uuid/UuidKt")
class UuidKt__UuidKt extends UuidKt__UuidJVMKt {
    public static final Uuid uuidFromRandomBytes(byte[] randomBytes) {
        Intrinsics.checkNotNullParameter(randomBytes, "randomBytes");
        randomBytes[6] = (byte) (randomBytes[6] & 15);
        randomBytes[6] = (byte) (randomBytes[6] | 64);
        randomBytes[8] = (byte) (randomBytes[8] & 63);
        randomBytes[8] = (byte) (randomBytes[8] | ByteCompanionObject.MIN_VALUE);
        return Uuid.Companion.fromByteArray(randomBytes);
    }

    public static final long toLong$UuidKt__UuidKt(byte[] $this$toLong, int startIndex) {
        return ((((long) $this$toLong[startIndex + 0]) & 255) << 56) | ((((long) $this$toLong[startIndex + 1]) & 255) << 48) | ((((long) $this$toLong[startIndex + 2]) & 255) << 40) | ((((long) $this$toLong[startIndex + 3]) & 255) << 32) | ((((long) $this$toLong[startIndex + 4]) & 255) << 24) | ((((long) $this$toLong[startIndex + 5]) & 255) << 16) | ((((long) $this$toLong[startIndex + 6]) & 255) << 8) | (255 & ((long) $this$toLong[startIndex + 7]));
    }

    public static final void formatBytesInto$UuidKt__UuidKt(long $this$formatBytesInto, byte[] dst, int dstOffset, int count) {
        long j = $this$formatBytesInto;
        int dstIndex = (count * 2) + dstOffset;
        for (int dstIndex2 = 0; dstIndex2 < count; dstIndex2++) {
            int byteDigits = HexExtensionsKt.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[(int) (255 & j)];
            int dstIndex3 = dstIndex - 1;
            dst[dstIndex3] = (byte) byteDigits;
            dstIndex = dstIndex3 - 1;
            dst[dstIndex] = (byte) (byteDigits >> 8);
            j >>= 8;
        }
    }

    public static final void checkHyphenAt$UuidKt__UuidKt(String $this$checkHyphenAt, int index) {
        if (!($this$checkHyphenAt.charAt(index) == '-')) {
            throw new IllegalArgumentException(("Expected '-' (hyphen) at index " + index + ", but was '" + $this$checkHyphenAt.charAt(index) + '\'').toString());
        }
    }

    public static final void toByteArray$UuidKt__UuidKt(long $this$toByteArray, byte[] dst, int dstOffset) {
        for (int index = 0; index < 8; index++) {
            int shift = (7 - index) * 8;
            dst[dstOffset + index] = (byte) ($this$toByteArray >>> shift);
        }
    }
}
