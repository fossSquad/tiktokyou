package ni.shikatu.kotlin.uuid;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.ByteCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.HexExtensionsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Utf8;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\n\u001a\n\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u0016\u0010\b\u001a\u00020\t*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001H\u0080\u0080\u0004\u001a.\u0010\u000b\u001a\u00020\f*\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0080\u0080\u0004\u001a\u001e\u0010\u0011\u001a\u00020\f*\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\tH\u0080\u0080\u0004\u001a\u0012\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001af\u0010\u0017\u001a\u00020\f*\u00020\u00152\u0006\u0010\n\u001a\u00020\u00012K\u0010\u0018\u001aG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0019H\u0080\u0088\u0004ø\u0001\u0000\u001ab\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152K\u0010\u0018\u001aG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u0019H\u0080\u0088\u0004ø\u0001\u0000\u001a\u0012\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u0015H\u0080\u0080\u0004\u001ab\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00152K\u0010\u0018\u001aG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001f0\u0019H\u0080\u0088\u0004ø\u0001\u0000\u001a\u001b\u0010$\u001a\u00020\u0015*\u00020\u00152\u0006\u0010%\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b&\u001a\u001b\u0010$\u001a\u00020\u0015*\u00020\u00072\u0006\u0010'\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b&\u001a\"\u0010(\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0001H\u0080\u0080\u0004\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0002\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"UUID_HEX_LENGTH", _UrlKt.FRAGMENT_ENCODE_SET, "UUID_HEX_DASH_LENGTH", "secureRandomUuid", "Lni/shikatu/kotlin/uuid/Uuid;", "uuidFromRandomBytes", "randomBytes", _UrlKt.FRAGMENT_ENCODE_SET, "getLongAtCommonImpl", _UrlKt.FRAGMENT_ENCODE_SET, "index", "formatBytesIntoCommonImpl", _UrlKt.FRAGMENT_ENCODE_SET, "dst", "dstOffset", "startIndex", "endIndex", "setLongAtCommonImpl", "value", "uuidParseHexDashCommonImpl", "hexDashString", _UrlKt.FRAGMENT_ENCODE_SET, "uuidParseHexDashOrNullCommonImpl", "uuidCheckHyphenAt", "onError", "Lni/shikatu/kotlin/Function3;", "Lni/shikatu/kotlin/ParameterName;", "name", "inputString", "errorDescription", "errorPosition", _UrlKt.FRAGMENT_ENCODE_SET, "uuidParseHexCommonImpl", "hexString", "uuidParseHexOrNullCommonImpl", "errorIndex", "truncateForErrorMessage", "maxLength", "truncateForErrorMessage$UuidKt__UuidKt", "maxSize", "uuidThrowUnexpectedCharacterException", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/uuid/UuidKt")
class UuidKt__UuidKt extends UuidKt__UuidJVMKt {
    private static final int UUID_HEX_DASH_LENGTH = 36;
    private static final int UUID_HEX_LENGTH = 32;

    public static final Uuid secureRandomUuid() {
        byte[] it = new byte[16];
        UuidKt.secureRandomBytes(it);
        return UuidKt.uuidFromRandomBytes(it);
    }

    public static final Uuid uuidFromRandomBytes(byte[] randomBytes) {
        Intrinsics.checkNotNullParameter(randomBytes, "randomBytes");
        randomBytes[6] = (byte) (randomBytes[6] & 15);
        randomBytes[6] = (byte) (randomBytes[6] | 64);
        randomBytes[8] = (byte) (randomBytes[8] & Utf8.REPLACEMENT_BYTE);
        randomBytes[8] = (byte) (randomBytes[8] | ByteCompanionObject.MIN_VALUE);
        return Uuid.Companion.fromByteArray(randomBytes);
    }

    public static final long getLongAtCommonImpl(byte[] $this$getLongAtCommonImpl, int index) {
        Intrinsics.checkNotNullParameter($this$getLongAtCommonImpl, "<this>");
        return ((((long) $this$getLongAtCommonImpl[index + 0]) & 255) << 56) | ((((long) $this$getLongAtCommonImpl[index + 1]) & 255) << 48) | ((((long) $this$getLongAtCommonImpl[index + 2]) & 255) << 40) | ((((long) $this$getLongAtCommonImpl[index + 3]) & 255) << 32) | ((((long) $this$getLongAtCommonImpl[index + 4]) & 255) << 24) | ((((long) $this$getLongAtCommonImpl[index + 5]) & 255) << 16) | ((((long) $this$getLongAtCommonImpl[index + 6]) & 255) << 8) | (255 & ((long) $this$getLongAtCommonImpl[index + 7]));
    }

    public static final void formatBytesIntoCommonImpl(long $this$formatBytesIntoCommonImpl, byte[] dst, int dstOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        int dstIndex = dstOffset;
        int reversedIndex = 7 - startIndex;
        int i = 8 - endIndex;
        if (i > reversedIndex) {
            return;
        }
        while (true) {
            int shift = reversedIndex << 3;
            int byteDigits = HexExtensionsKt.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[(int) (($this$formatBytesIntoCommonImpl >> shift) & 255)];
            int dstIndex2 = dstIndex + 1;
            dst[dstIndex] = (byte) (byteDigits >> 8);
            dstIndex = dstIndex2 + 1;
            dst[dstIndex2] = (byte) byteDigits;
            if (reversedIndex == i) {
                return;
            } else {
                reversedIndex--;
            }
        }
    }

    public static final void setLongAtCommonImpl(byte[] $this$setLongAtCommonImpl, int index, long value) {
        Intrinsics.checkNotNullParameter($this$setLongAtCommonImpl, "<this>");
        int i = index;
        int reversedIndex = 7;
        while (-1 < reversedIndex) {
            int shift = reversedIndex << 3;
            $this$setLongAtCommonImpl[i] = (byte) (value >> shift);
            reversedIndex--;
            i++;
        }
    }

    public static final Uuid uuidParseHexDashCommonImpl(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        long result$iv$iv = 0;
        int index$iv$iv = 0;
        while (true) {
            char c = 4;
            if (index$iv$iv >= 8) {
                if (hexDashString.charAt(8) != '-') {
                    UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "'-' (hyphen)", 8);
                    throw new KotlinNothingValueException();
                }
                long result$iv$iv2 = 0;
                for (int index$iv$iv2 = 9; index$iv$iv2 < 13; index$iv$iv2++) {
                    long j = result$iv$iv2 << 4;
                    int index$iv$iv$iv = index$iv$iv2;
                    int code$iv$iv$iv = hexDashString.charAt(index$iv$iv$iv);
                    if ((code$iv$iv$iv >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv] < 0) {
                        UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "a hexadecimal digit", index$iv$iv$iv);
                        throw new KotlinNothingValueException();
                    }
                    result$iv$iv2 = j | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv];
                }
                if (hexDashString.charAt(13) != '-') {
                    UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "'-' (hyphen)", 13);
                    throw new KotlinNothingValueException();
                }
                long result$iv$iv3 = 0;
                int index$iv$iv3 = 14;
                while (index$iv$iv3 < 18) {
                    long j2 = result$iv$iv3 << c;
                    int index$iv$iv$iv2 = index$iv$iv3;
                    char c2 = c;
                    int code$iv$iv$iv2 = hexDashString.charAt(index$iv$iv$iv2);
                    if ((code$iv$iv$iv2 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv2] < 0) {
                        UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "a hexadecimal digit", index$iv$iv$iv2);
                        throw new KotlinNothingValueException();
                    }
                    result$iv$iv3 = j2 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv2];
                    index$iv$iv3++;
                    c = c2;
                }
                char c3 = c;
                if (hexDashString.charAt(18) != '-') {
                    UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "'-' (hyphen)", 18);
                    throw new KotlinNothingValueException();
                }
                int startIndex$iv$iv = 19;
                int endIndex$iv$iv = 23;
                long result$iv$iv4 = 0;
                int index$iv$iv4 = 19;
                while (index$iv$iv4 < endIndex$iv$iv) {
                    long j3 = result$iv$iv4 << c3;
                    int index$iv$iv$iv3 = index$iv$iv4;
                    int startIndex$iv$iv2 = startIndex$iv$iv;
                    int endIndex$iv$iv2 = endIndex$iv$iv;
                    int code$iv$iv$iv3 = hexDashString.charAt(index$iv$iv$iv3);
                    if ((code$iv$iv$iv3 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv3] < 0) {
                        UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "a hexadecimal digit", index$iv$iv$iv3);
                        throw new KotlinNothingValueException();
                    }
                    result$iv$iv4 = j3 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv3];
                    index$iv$iv4++;
                    endIndex$iv$iv = endIndex$iv$iv2;
                    startIndex$iv$iv = startIndex$iv$iv2;
                }
                if (hexDashString.charAt(23) != '-') {
                    UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "'-' (hyphen)", 23);
                    throw new KotlinNothingValueException();
                }
                int startIndex$iv$iv3 = 24;
                int endIndex$iv$iv3 = UUID_HEX_DASH_LENGTH;
                long result$iv$iv5 = 0;
                int index$iv$iv5 = 24;
                while (index$iv$iv5 < endIndex$iv$iv3) {
                    long j4 = result$iv$iv5 << c3;
                    int index$iv$iv$iv4 = index$iv$iv5;
                    int startIndex$iv$iv4 = startIndex$iv$iv3;
                    int endIndex$iv$iv4 = endIndex$iv$iv3;
                    int code$iv$iv$iv4 = hexDashString.charAt(index$iv$iv$iv4);
                    if ((code$iv$iv$iv4 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv4] < 0) {
                        UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "a hexadecimal digit", index$iv$iv$iv4);
                        throw new KotlinNothingValueException();
                    }
                    result$iv$iv5 = j4 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv4];
                    index$iv$iv5++;
                    endIndex$iv$iv3 = endIndex$iv$iv4;
                    startIndex$iv$iv3 = startIndex$iv$iv4;
                }
                long msb$iv = (result$iv$iv << 32) | (result$iv$iv2 << 16) | result$iv$iv3;
                long lsb$iv = (result$iv$iv4 << 48) | result$iv$iv5;
                return Uuid.Companion.fromLongs(msb$iv, lsb$iv);
            }
            long j5 = result$iv$iv << 4;
            int index$iv$iv$iv5 = index$iv$iv;
            int code$iv$iv$iv5 = hexDashString.charAt(index$iv$iv$iv5);
            if ((code$iv$iv$iv5 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv5] < 0) {
                UuidKt.uuidThrowUnexpectedCharacterException(hexDashString, "a hexadecimal digit", index$iv$iv$iv5);
                throw new KotlinNothingValueException();
            }
            result$iv$iv = j5 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv5];
            index$iv$iv++;
        }
    }

    public static final Uuid uuidParseHexDashOrNullCommonImpl(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        String hexDashString$iv = hexDashString;
        long result$iv$iv = 0;
        int index$iv$iv = 0;
        while (true) {
            int index$iv$iv$iv = 4;
            Uuid uuid = null;
            if (index$iv$iv >= 8) {
                if (hexDashString$iv.charAt(8) != '-') {
                    return null;
                }
                long result$iv$iv2 = 0;
                int index$iv$iv2 = 9;
                while (index$iv$iv2 < 13) {
                    long j = result$iv$iv2 << index$iv$iv$iv;
                    int index$iv$iv$iv2 = index$iv$iv2;
                    int i = index$iv$iv$iv;
                    Uuid uuid2 = uuid;
                    int code$iv$iv$iv = hexDashString$iv.charAt(index$iv$iv$iv2);
                    if ((code$iv$iv$iv >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv] < 0) {
                        return uuid2;
                    }
                    result$iv$iv2 = j | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv];
                    index$iv$iv2++;
                    uuid = uuid2;
                    index$iv$iv$iv = i;
                }
                int i2 = index$iv$iv$iv;
                Uuid uuid3 = uuid;
                if (hexDashString$iv.charAt(13) != '-') {
                    return uuid3;
                }
                long result$iv$iv3 = 0;
                int index$iv$iv3 = 14;
                while (index$iv$iv3 < 18) {
                    long j2 = result$iv$iv3 << i2;
                    int index$iv$iv$iv3 = index$iv$iv3;
                    String $this$longDecimalFromHexDigitAt$iv$iv$iv = hexDashString$iv;
                    int code$iv$iv$iv2 = hexDashString$iv.charAt(index$iv$iv$iv3);
                    if ((code$iv$iv$iv2 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv2] < 0) {
                        return uuid3;
                    }
                    result$iv$iv3 = j2 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv2];
                    index$iv$iv3++;
                    hexDashString$iv = $this$longDecimalFromHexDigitAt$iv$iv$iv;
                }
                String hexDashString$iv2 = hexDashString$iv;
                if (hexDashString$iv2.charAt(18) != '-') {
                    return uuid3;
                }
                int startIndex$iv$iv = 19;
                long result$iv$iv4 = 0;
                int index$iv$iv4 = 19;
                while (index$iv$iv4 < 23) {
                    long j3 = result$iv$iv4 << i2;
                    int index$iv$iv$iv4 = index$iv$iv4;
                    int startIndex$iv$iv2 = startIndex$iv$iv;
                    int code$iv$iv$iv3 = hexDashString$iv2.charAt(index$iv$iv$iv4);
                    if ((code$iv$iv$iv3 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv3] < 0) {
                        return uuid3;
                    }
                    result$iv$iv4 = j3 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv3];
                    index$iv$iv4++;
                    startIndex$iv$iv = startIndex$iv$iv2;
                }
                if (hexDashString$iv2.charAt(23) != '-') {
                    return uuid3;
                }
                int startIndex$iv$iv3 = 24;
                long result$iv$iv5 = 0;
                int index$iv$iv5 = 24;
                while (index$iv$iv5 < UUID_HEX_DASH_LENGTH) {
                    long j4 = result$iv$iv5 << i2;
                    int index$iv$iv$iv5 = index$iv$iv5;
                    int startIndex$iv$iv4 = startIndex$iv$iv3;
                    int code$iv$iv$iv4 = hexDashString$iv2.charAt(index$iv$iv$iv5);
                    if ((code$iv$iv$iv4 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv4] < 0) {
                        return uuid3;
                    }
                    result$iv$iv5 = j4 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv4];
                    index$iv$iv5++;
                    startIndex$iv$iv3 = startIndex$iv$iv4;
                }
                long msb$iv = (result$iv$iv << 32) | (result$iv$iv2 << 16) | result$iv$iv3;
                long lsb$iv = (result$iv$iv4 << 48) | result$iv$iv5;
                return Uuid.Companion.fromLongs(msb$iv, lsb$iv);
            }
            long j5 = result$iv$iv << 4;
            int index$iv$iv$iv6 = index$iv$iv;
            int code$iv$iv$iv5 = hexDashString$iv.charAt(index$iv$iv$iv6);
            if ((code$iv$iv$iv5 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv5] < 0) {
                return null;
            }
            result$iv$iv = j5 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv5];
            index$iv$iv++;
        }
    }

    public static final void uuidCheckHyphenAt(String $this$uuidCheckHyphenAt, int index, Function3<? super String, ? super String, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter($this$uuidCheckHyphenAt, "<this>");
        Intrinsics.checkNotNullParameter(function3, "onError");
        if ($this$uuidCheckHyphenAt.charAt(index) != '-') {
            function3.invoke($this$uuidCheckHyphenAt, "'-' (hyphen)", Integer.valueOf(index));
        }
    }

    public static final Uuid uuidParseHexDashCommonImpl(String hexDashString, Function3 onError) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        Intrinsics.checkNotNullParameter(onError, "onError");
        long result$iv = 0;
        int index$iv = 0;
        while (true) {
            char c = 4;
            if (index$iv < 8) {
                long j = result$iv << 4;
                int index$iv$iv = index$iv;
                int code$iv$iv = hexDashString.charAt(index$iv$iv);
                if ((code$iv$iv >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv] < 0) {
                    onError.invoke(hexDashString, "a hexadecimal digit", Integer.valueOf(index$iv$iv));
                    throw new KotlinNothingValueException();
                }
                result$iv = j | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv];
                index$iv++;
            } else {
                if (hexDashString.charAt(8) != '-') {
                    onError.invoke(hexDashString, "'-' (hyphen)", 8);
                }
                long result$iv2 = 0;
                int index$iv2 = 9;
                while (index$iv2 < 13) {
                    long j2 = result$iv2 << c;
                    int index$iv$iv2 = index$iv2;
                    char c2 = c;
                    int code$iv$iv2 = hexDashString.charAt(index$iv$iv2);
                    if ((code$iv$iv2 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv2] < 0) {
                        onError.invoke(hexDashString, "a hexadecimal digit", Integer.valueOf(index$iv$iv2));
                        throw new KotlinNothingValueException();
                    }
                    result$iv2 = j2 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv2];
                    index$iv2++;
                    c = c2;
                }
                char c3 = c;
                if (hexDashString.charAt(13) != '-') {
                    onError.invoke(hexDashString, "'-' (hyphen)", 13);
                }
                int startIndex$iv = 14;
                int endIndex$iv = 18;
                long result$iv3 = 0;
                int index$iv3 = 14;
                while (index$iv3 < endIndex$iv) {
                    long j3 = result$iv3 << c3;
                    int index$iv$iv3 = index$iv3;
                    int startIndex$iv2 = startIndex$iv;
                    int endIndex$iv2 = endIndex$iv;
                    int code$iv$iv3 = hexDashString.charAt(index$iv$iv3);
                    if ((code$iv$iv3 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv3] < 0) {
                        onError.invoke(hexDashString, "a hexadecimal digit", Integer.valueOf(index$iv$iv3));
                        throw new KotlinNothingValueException();
                    }
                    result$iv3 = j3 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv3];
                    index$iv3++;
                    endIndex$iv = endIndex$iv2;
                    startIndex$iv = startIndex$iv2;
                }
                if (hexDashString.charAt(18) != '-') {
                    onError.invoke(hexDashString, "'-' (hyphen)", 18);
                }
                int startIndex$iv3 = 19;
                int endIndex$iv3 = 23;
                long result$iv4 = 0;
                int index$iv4 = 19;
                while (index$iv4 < endIndex$iv3) {
                    long j4 = result$iv4 << c3;
                    int index$iv$iv4 = index$iv4;
                    int startIndex$iv4 = startIndex$iv3;
                    int endIndex$iv4 = endIndex$iv3;
                    int code$iv$iv4 = hexDashString.charAt(index$iv$iv4);
                    if ((code$iv$iv4 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv4] < 0) {
                        onError.invoke(hexDashString, "a hexadecimal digit", Integer.valueOf(index$iv$iv4));
                        throw new KotlinNothingValueException();
                    }
                    result$iv4 = j4 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv4];
                    index$iv4++;
                    endIndex$iv3 = endIndex$iv4;
                    startIndex$iv3 = startIndex$iv4;
                }
                if (hexDashString.charAt(23) != '-') {
                    onError.invoke(hexDashString, "'-' (hyphen)", 23);
                }
                int endIndex$iv5 = UUID_HEX_DASH_LENGTH;
                long result$iv5 = 0;
                int startIndex$iv5 = 24;
                while (startIndex$iv5 < endIndex$iv5) {
                    long j5 = result$iv5 << c3;
                    int index$iv5 = startIndex$iv5;
                    int index$iv$iv5 = endIndex$iv5;
                    int code$iv$iv5 = hexDashString.charAt(startIndex$iv5);
                    if ((code$iv$iv5 >>> 8) == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv5] >= 0) {
                        result$iv5 = j5 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv5];
                        startIndex$iv5 = index$iv5 + 1;
                        endIndex$iv5 = index$iv$iv5;
                    } else {
                        int it$iv = startIndex$iv5;
                        onError.invoke(hexDashString, "a hexadecimal digit", Integer.valueOf(it$iv));
                        throw new KotlinNothingValueException();
                    }
                }
                long msb = (result$iv << 32) | (result$iv2 << 16) | result$iv3;
                long lsb = (result$iv4 << 48) | result$iv5;
                return Uuid.Companion.fromLongs(msb, lsb);
            }
        }
    }

    public static final Uuid uuidParseHexCommonImpl(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        long result$iv$iv = 0;
        for (int index$iv$iv = 0; index$iv$iv < 16; index$iv$iv++) {
            long j = result$iv$iv << 4;
            int index$iv$iv$iv = index$iv$iv;
            int code$iv$iv$iv = hexString.charAt(index$iv$iv$iv);
            if ((code$iv$iv$iv >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv] < 0) {
                UuidKt.uuidThrowUnexpectedCharacterException(hexString, "a hexadecimal digit", index$iv$iv$iv);
                throw new KotlinNothingValueException();
            }
            result$iv$iv = j | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv];
        }
        long result$iv$iv2 = 0;
        for (int index$iv$iv2 = 16; index$iv$iv2 < 32; index$iv$iv2++) {
            long j2 = result$iv$iv2 << 4;
            int index$iv$iv$iv2 = index$iv$iv2;
            int code$iv$iv$iv2 = hexString.charAt(index$iv$iv$iv2);
            if ((code$iv$iv$iv2 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv2] < 0) {
                UuidKt.uuidThrowUnexpectedCharacterException(hexString, "a hexadecimal digit", index$iv$iv$iv2);
                throw new KotlinNothingValueException();
            }
            result$iv$iv2 = j2 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv2];
        }
        return Uuid.Companion.fromLongs(result$iv$iv, result$iv$iv2);
    }

    public static final Uuid uuidParseHexOrNullCommonImpl(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        long result$iv$iv = 0;
        int index$iv$iv = 0;
        while (true) {
            Uuid uuid = null;
            char c = 4;
            if (index$iv$iv >= 16) {
                long result$iv$iv2 = 0;
                int index$iv$iv2 = 16;
                while (index$iv$iv2 < 32) {
                    long j = result$iv$iv2 << c;
                    int index$iv$iv$iv = index$iv$iv2;
                    Uuid uuid2 = uuid;
                    int code$iv$iv$iv = hexString.charAt(index$iv$iv$iv);
                    if ((code$iv$iv$iv >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv] < 0) {
                        return uuid2;
                    }
                    result$iv$iv2 = j | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv];
                    index$iv$iv2++;
                    uuid = uuid2;
                    c = 4;
                }
                return Uuid.Companion.fromLongs(result$iv$iv, result$iv$iv2);
            }
            long j2 = result$iv$iv << 4;
            int index$iv$iv$iv2 = index$iv$iv;
            int code$iv$iv$iv2 = hexString.charAt(index$iv$iv$iv2);
            if ((code$iv$iv$iv2 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv2] < 0) {
                return null;
            }
            result$iv$iv = j2 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv$iv2];
            index$iv$iv++;
        }
    }

    public static final Uuid uuidParseHexCommonImpl(String hexString, Function3 onError) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        Intrinsics.checkNotNullParameter(onError, "onError");
        long result$iv = 0;
        for (int index$iv = 0; index$iv < 16; index$iv++) {
            long j = result$iv << 4;
            int index$iv$iv = index$iv;
            int code$iv$iv = hexString.charAt(index$iv$iv);
            if ((code$iv$iv >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv] < 0) {
                onError.invoke(hexString, "a hexadecimal digit", Integer.valueOf(index$iv$iv));
                throw new KotlinNothingValueException();
            }
            result$iv = j | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv];
        }
        long result$iv2 = 0;
        for (int index$iv2 = 16; index$iv2 < 32; index$iv2++) {
            long j2 = result$iv2 << 4;
            int index$iv$iv2 = index$iv2;
            int code$iv$iv2 = hexString.charAt(index$iv$iv2);
            if ((code$iv$iv2 >>> 8) != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv2] < 0) {
                onError.invoke(hexString, "a hexadecimal digit", Integer.valueOf(index$iv$iv2));
                throw new KotlinNothingValueException();
            }
            result$iv2 = j2 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[code$iv$iv2];
        }
        return Uuid.Companion.fromLongs(result$iv, result$iv2);
    }

    public static final String truncateForErrorMessage$UuidKt__UuidKt(String $this$truncateForErrorMessage, int maxLength) {
        if ($this$truncateForErrorMessage.length() <= maxLength) {
            return $this$truncateForErrorMessage;
        }
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull($this$truncateForErrorMessage, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = $this$truncateForErrorMessage.substring(0, maxLength);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sb.append(strSubstring).append("...").toString();
    }

    public static final String truncateForErrorMessage$UuidKt__UuidKt(byte[] $this$truncateForErrorMessage, int maxSize) {
        return ArraysKt.joinToString$default($this$truncateForErrorMessage, (CharSequence) null, (CharSequence) "[", (CharSequence) "]", maxSize, (CharSequence) null, (Function1) null, 49, (Object) null);
    }

    public static final Void uuidThrowUnexpectedCharacterException(String inputString, String errorDescription, int errorIndex) {
        Intrinsics.checkNotNullParameter(inputString, "inputString");
        Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
        throw new IllegalArgumentException("Expected " + errorDescription + " at index " + errorIndex + ", but was '" + inputString.charAt(errorIndex) + '\'');
    }
}
