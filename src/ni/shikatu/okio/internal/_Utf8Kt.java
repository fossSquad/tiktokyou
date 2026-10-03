package ni.shikatu.okio.internal;

import java.util.Arrays;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.ByteCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Utf8;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, d2 = {"commonToUtf8String", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "beginIndex", _UrlKt.FRAGMENT_ENCODE_SET, "endIndex", "commonAsUtf8ToByteArray", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _Utf8Kt {
    public static  String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    public static final String commonToUtf8String(byte[] $this$commonToUtf8String, int beginIndex, int endIndex) {
        int endIndex$iv;
        int length;
        int length2;
        int length3;
        int length4;
        int i;
        int length5;
        int length6;
        int length7;
        int i2;
        int length8;
        int length9;
        byte b0$iv$iv;
        Intrinsics.checkNotNullParameter($this$commonToUtf8String, "<this>");
        if (beginIndex < 0 || endIndex > $this$commonToUtf8String.length || beginIndex > endIndex) {
            throw new ArrayIndexOutOfBoundsException("size=" + $this$commonToUtf8String.length + " beginIndex=" + beginIndex + " endIndex=" + endIndex);
        }
        char[] chars = new char[endIndex - beginIndex];
        int index$iv = 0;
        int endIndex$iv2 = endIndex;
        int beginIndex$iv = beginIndex;
        int index$iv2 = beginIndex$iv;
        while (index$iv2 < endIndex$iv2) {
            byte b0$iv = $this$commonToUtf8String[index$iv2];
            if (b0$iv >= 0) {
                char c = (char) b0$iv;
                int length10 = index$iv + 1;
                chars[index$iv] = c;
                index$iv2++;
                while (index$iv2 < endIndex$iv2 && $this$commonToUtf8String[index$iv2] >= 0) {
                    int index$iv3 = index$iv2 + 1;
                    char c2 = (char) $this$commonToUtf8String[index$iv2];
                    chars[length10] = c2;
                    index$iv2 = index$iv3;
                    length10++;
                }
                Unit unit = Unit.INSTANCE;
                endIndex$iv = endIndex$iv2;
                beginIndex$iv = beginIndex$iv;
                index$iv = length10;
            } else {
                int other$iv$iv = b0$iv >> 5;
                if (other$iv$iv == -2) {
                    int endIndex$iv$iv = endIndex$iv2;
                    int beginIndex$iv$iv = index$iv2;
                    if (endIndex$iv$iv <= beginIndex$iv$iv + 1) {
                        char c3 = (char) Utf8.REPLACEMENT_CODE_POINT;
                        int length11 = index$iv + 1;
                        chars[index$iv] = c3;
                        Unit unit2 = Unit.INSTANCE;
                        endIndex$iv = endIndex$iv2;
                        b0$iv$iv = 1;
                        length9 = length11;
                    } else {
                        byte b0$iv$iv2 = $this$commonToUtf8String[beginIndex$iv$iv];
                        int b1$iv$iv = $this$commonToUtf8String[beginIndex$iv$iv + 1];
                        endIndex$iv = endIndex$iv2;
                        int endIndex$iv3 = b1$iv$iv & 192;
                        if (endIndex$iv3 == 128) {
                            int codePoint$iv$iv = (b1$iv$iv ^ Utf8.MASK_2BYTES) ^ (b0$iv$iv2 << 6);
                            if (codePoint$iv$iv < 128) {
                                char c4 = (char) Utf8.REPLACEMENT_CODE_POINT;
                                length8 = index$iv + 1;
                                chars[index$iv] = c4;
                                Unit unit3 = Unit.INSTANCE;
                            } else {
                                char c5 = (char) codePoint$iv$iv;
                                length8 = index$iv + 1;
                                chars[index$iv] = c5;
                                Unit unit4 = Unit.INSTANCE;
                            }
                            length9 = length8;
                            b0$iv$iv = 2;
                        } else {
                            char c6 = (char) Utf8.REPLACEMENT_CODE_POINT;
                            length9 = index$iv + 1;
                            chars[index$iv] = c6;
                            Unit unit5 = Unit.INSTANCE;
                            b0$iv$iv = 1;
                        }
                    }
                    index$iv2 += b0$iv$iv;
                    Unit unit6 = Unit.INSTANCE;
                    index$iv = length9;
                } else {
                    endIndex$iv = endIndex$iv2;
                    beginIndex$iv = beginIndex$iv;
                    int other$iv$iv2 = b0$iv >> 4;
                    if (other$iv$iv2 == -2) {
                        int beginIndex$iv$iv2 = index$iv2;
                        if (endIndex$iv <= beginIndex$iv$iv2 + 2) {
                            char c7 = (char) Utf8.REPLACEMENT_CODE_POINT;
                            length7 = index$iv + 1;
                            chars[index$iv] = c7;
                            Unit unit7 = Unit.INSTANCE;
                            if (endIndex$iv > beginIndex$iv$iv2 + 1) {
                                int byte$iv$iv$iv = $this$commonToUtf8String[beginIndex$iv$iv2 + 1];
                                int other$iv$iv$iv$iv = 192 & byte$iv$iv$iv;
                                if (other$iv$iv$iv$iv == 128) {
                                    i2 = 2;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                i2 = 1;
                            }
                        } else {
                            byte b0$iv$iv3 = $this$commonToUtf8String[beginIndex$iv$iv2];
                            byte b1$iv$iv2 = $this$commonToUtf8String[beginIndex$iv$iv2 + 1];
                            if ((b1$iv$iv2 & 192) == 128) {
                                byte b2$iv$iv = $this$commonToUtf8String[beginIndex$iv$iv2 + 2];
                                if ((b2$iv$iv & 192) == 128) {
                                    int codePoint$iv$iv2 = (((-123008) ^ b2$iv$iv) ^ (b1$iv$iv2 << 6)) ^ (b0$iv$iv3 << 12);
                                    if (codePoint$iv$iv2 < 2048) {
                                        char c8 = (char) Utf8.REPLACEMENT_CODE_POINT;
                                        length6 = index$iv + 1;
                                        chars[index$iv] = c8;
                                        Unit unit8 = Unit.INSTANCE;
                                    } else {
                                        if (55296 <= codePoint$iv$iv2 && codePoint$iv$iv2 < 57344) {
                                            char c9 = (char) Utf8.REPLACEMENT_CODE_POINT;
                                            length6 = index$iv + 1;
                                            chars[index$iv] = c9;
                                            Unit unit9 = Unit.INSTANCE;
                                        } else {
                                            char c10 = (char) codePoint$iv$iv2;
                                            length6 = index$iv + 1;
                                            chars[index$iv] = c10;
                                            Unit unit10 = Unit.INSTANCE;
                                        }
                                    }
                                    length7 = length6;
                                    i2 = 3;
                                } else {
                                    char c11 = (char) Utf8.REPLACEMENT_CODE_POINT;
                                    int length12 = index$iv + 1;
                                    chars[index$iv] = c11;
                                    Unit unit11 = Unit.INSTANCE;
                                    length7 = length12;
                                    i2 = 2;
                                }
                            } else {
                                char c12 = (char) Utf8.REPLACEMENT_CODE_POINT;
                                int length13 = index$iv + 1;
                                chars[index$iv] = c12;
                                Unit unit12 = Unit.INSTANCE;
                                i2 = 1;
                                length7 = length13;
                            }
                        }
                        index$iv2 += i2;
                        Unit unit13 = Unit.INSTANCE;
                        index$iv = length7;
                    } else {
                        int other$iv$iv3 = b0$iv >> 3;
                        if (other$iv$iv3 == -2) {
                            int beginIndex$iv$iv3 = index$iv2;
                            if (endIndex$iv <= beginIndex$iv$iv3 + 3) {
                                if (65533 != 65533) {
                                    char c13 = (char) ((Utf8.REPLACEMENT_CODE_POINT >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                    int length14 = index$iv + 1;
                                    chars[index$iv] = c13;
                                    char c14 = (char) ((65533 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                    length2 = length14 + 1;
                                    chars[length14] = c14;
                                } else {
                                    int length15 = index$iv + 1;
                                    chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                                    length2 = length15;
                                }
                                Unit unit14 = Unit.INSTANCE;
                                if (endIndex$iv > beginIndex$iv$iv3 + 1) {
                                    int byte$iv$iv$iv2 = $this$commonToUtf8String[beginIndex$iv$iv3 + 1];
                                    int other$iv$iv$iv$iv2 = byte$iv$iv$iv2 & 192;
                                    byte byte$iv$iv$iv3 = other$iv$iv$iv$iv2 == 128 ? (byte) 1 : (byte) 0;
                                    if (byte$iv$iv$iv3 == 0) {
                                        i = 1;
                                    } else if (endIndex$iv > beginIndex$iv$iv3 + 2) {
                                        int byte$iv$iv$iv4 = $this$commonToUtf8String[beginIndex$iv$iv3 + 2];
                                        int other$iv$iv$iv$iv3 = byte$iv$iv$iv4 & 192;
                                        if (other$iv$iv$iv$iv3 == 128) {
                                            i = 3;
                                        } else {
                                            i = 2;
                                        }
                                    } else {
                                        i = 2;
                                    }
                                } else {
                                    i = 1;
                                }
                            } else {
                                byte b0$iv$iv4 = $this$commonToUtf8String[beginIndex$iv$iv3];
                                byte b1$iv$iv3 = $this$commonToUtf8String[beginIndex$iv$iv3 + 1];
                                if ((b1$iv$iv3 & 192) == 128) {
                                    int endIndex$iv$iv2 = beginIndex$iv$iv3 + 2;
                                    byte b2$iv$iv2 = $this$commonToUtf8String[endIndex$iv$iv2];
                                    if ((b2$iv$iv2 & 192) == 128) {
                                        byte b3$iv$iv = $this$commonToUtf8String[beginIndex$iv$iv3 + 3];
                                        if ((b3$iv$iv & 192) == 128) {
                                            int codePoint$iv$iv3 = (((b3$iv$iv ^ ByteCompanionObject.MIN_VALUE) ^ (b2$iv$iv2 << 6)) ^ (b1$iv$iv3 << 12)) ^ (b0$iv$iv4 << 18);
                                            if (codePoint$iv$iv3 > 1114111) {
                                                if (65533 != 65533) {
                                                    char c15 = (char) ((Utf8.REPLACEMENT_CODE_POINT >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                    int length16 = index$iv + 1;
                                                    chars[index$iv] = c15;
                                                    char c16 = (char) ((65533 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                                    length5 = length16 + 1;
                                                    chars[length16] = c16;
                                                } else {
                                                    int length17 = index$iv + 1;
                                                    chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                                                    length5 = length17;
                                                }
                                                Unit unit15 = Unit.INSTANCE;
                                                length2 = length5;
                                            } else {
                                                if (55296 <= codePoint$iv$iv3 && codePoint$iv$iv3 < 57344) {
                                                    if (65533 != 65533) {
                                                        char c17 = (char) ((Utf8.REPLACEMENT_CODE_POINT >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                        int length18 = index$iv + 1;
                                                        chars[index$iv] = c17;
                                                        char c18 = (char) ((65533 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                                        length4 = length18 + 1;
                                                        chars[length18] = c18;
                                                    } else {
                                                        int length19 = index$iv + 1;
                                                        chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                                                        length4 = length19;
                                                    }
                                                    Unit unit16 = Unit.INSTANCE;
                                                    length2 = length4;
                                                } else if (codePoint$iv$iv3 < 65536) {
                                                    if (65533 != 65533) {
                                                        char c19 = (char) ((Utf8.REPLACEMENT_CODE_POINT >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                        int length20 = index$iv + 1;
                                                        chars[index$iv] = c19;
                                                        char c20 = (char) ((65533 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                                        length3 = length20 + 1;
                                                        chars[length20] = c20;
                                                    } else {
                                                        int length21 = index$iv + 1;
                                                        chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                                                        length3 = length21;
                                                    }
                                                    Unit unit17 = Unit.INSTANCE;
                                                    length2 = length3;
                                                } else {
                                                    if (codePoint$iv$iv3 != 65533) {
                                                        char c21 = (char) ((codePoint$iv$iv3 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                        int length22 = index$iv + 1;
                                                        chars[index$iv] = c21;
                                                        char c22 = (char) ((codePoint$iv$iv3 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                                        length = length22 + 1;
                                                        chars[length22] = c22;
                                                    } else {
                                                        int length23 = index$iv + 1;
                                                        chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                                                        length = length23;
                                                    }
                                                    Unit unit18 = Unit.INSTANCE;
                                                    length2 = length;
                                                }
                                            }
                                            i = 4;
                                        } else {
                                            if (65533 != 65533) {
                                                char c23 = (char) ((Utf8.REPLACEMENT_CODE_POINT >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                int length24 = index$iv + 1;
                                                chars[index$iv] = c23;
                                                char c24 = (char) ((65533 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                                chars[length24] = c24;
                                                length2 = length24 + 1;
                                            } else {
                                                length2 = index$iv + 1;
                                                chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                                            }
                                            Unit unit19 = Unit.INSTANCE;
                                            i = 3;
                                        }
                                    } else {
                                        if (65533 != 65533) {
                                            char c25 = (char) ((Utf8.REPLACEMENT_CODE_POINT >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            int length25 = index$iv + 1;
                                            chars[index$iv] = c25;
                                            char c26 = (char) ((65533 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                            chars[length25] = c26;
                                            length2 = length25 + 1;
                                        } else {
                                            length2 = index$iv + 1;
                                            chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                                        }
                                        Unit unit20 = Unit.INSTANCE;
                                        i = 2;
                                    }
                                } else {
                                    if (65533 != 65533) {
                                        char c27 = (char) ((Utf8.REPLACEMENT_CODE_POINT >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                        int length26 = index$iv + 1;
                                        chars[index$iv] = c27;
                                        char c28 = (char) ((65533 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                        length2 = length26 + 1;
                                        chars[length26] = c28;
                                    } else {
                                        int length27 = index$iv + 1;
                                        chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                                        length2 = length27;
                                    }
                                    Unit unit21 = Unit.INSTANCE;
                                    i = 1;
                                }
                            }
                            index$iv2 += i;
                            Unit unit22 = Unit.INSTANCE;
                            index$iv = length2;
                        } else {
                            int length28 = index$iv + 1;
                            chars[index$iv] = Utf8.REPLACEMENT_CHARACTER;
                            Integer.valueOf(index$iv2);
                            index$iv2++;
                            index$iv = length28;
                        }
                    }
                }
            }
            beginIndex$iv = beginIndex$iv;
            endIndex$iv2 = endIndex$iv;
        }
        return StringsKt.concatToString(chars, 0, index$iv);
    }

    public static final byte[] commonAsUtf8ToByteArray(String $this$commonAsUtf8ToByteArray) {
        Intrinsics.checkNotNullParameter($this$commonAsUtf8ToByteArray, "<this>");
        byte[] bytes = new byte[$this$commonAsUtf8ToByteArray.length() * 4];
        int length = $this$commonAsUtf8ToByteArray.length();
        for (int index = 0; index < length; index++) {
            char b0 = $this$commonAsUtf8ToByteArray.charAt(index);
            if (Intrinsics.compare((int) b0, 128) >= 0) {
                int size = index;
                int endIndex$iv = $this$commonAsUtf8ToByteArray.length();
                int beginIndex$iv = index;
                int index$iv = beginIndex$iv;
                while (index$iv < endIndex$iv) {
                    char c$iv = $this$commonAsUtf8ToByteArray.charAt(index$iv);
                    if (Intrinsics.compare((int) c$iv, 128) < 0) {
                        byte c = (byte) c$iv;
                        bytes[size] = c;
                        index$iv++;
                        size++;
                        while (index$iv < endIndex$iv && Intrinsics.compare((int) $this$commonAsUtf8ToByteArray.charAt(index$iv), 128) < 0) {
                            int index$iv2 = index$iv + 1;
                            byte c2 = (byte) $this$commonAsUtf8ToByteArray.charAt(index$iv);
                            bytes[size] = c2;
                            index$iv = index$iv2;
                            size++;
                        }
                    } else if (Intrinsics.compare((int) c$iv, 2048) < 0) {
                        byte c3 = (byte) ((c$iv >> 6) | 192);
                        int size2 = size + 1;
                        bytes[size] = c3;
                        byte c4 = (byte) ((c$iv & '?') | 128);
                        bytes[size2] = c4;
                        index$iv++;
                        size = size2 + 1;
                    } else if (55296 <= c$iv && c$iv < 57344) {
                        if (Intrinsics.compare((int) c$iv, 56319) <= 0 && endIndex$iv > index$iv + 1) {
                            char cCharAt = $this$commonAsUtf8ToByteArray.charAt(index$iv + 1);
                            if (56320 <= cCharAt && cCharAt < 57344) {
                                int codePoint$iv = ((c$iv << '\n') + $this$commonAsUtf8ToByteArray.charAt(index$iv + 1)) - 56613888;
                                byte c5 = (byte) ((codePoint$iv >> 18) | 240);
                                int size3 = size + 1;
                                bytes[size] = c5;
                                byte c6 = (byte) (((codePoint$iv >> 12) & 63) | 128);
                                int size4 = size3 + 1;
                                bytes[size3] = c6;
                                byte c7 = (byte) (((codePoint$iv >> 6) & 63) | 128);
                                int size5 = size4 + 1;
                                bytes[size4] = c7;
                                byte c8 = (byte) ((codePoint$iv & 63) | 128);
                                bytes[size5] = c8;
                                index$iv += 2;
                                size = size5 + 1;
                            }
                        }
                        bytes[size] = Utf8.REPLACEMENT_BYTE;
                        index$iv++;
                        size++;
                    } else {
                        byte c9 = (byte) ((c$iv >> '\f') | 224);
                        int size6 = size + 1;
                        bytes[size] = c9;
                        byte c10 = (byte) (((c$iv >> 6) & 63) | 128);
                        int size7 = size6 + 1;
                        bytes[size6] = c10;
                        byte c11 = (byte) ((c$iv & '?') | 128);
                        bytes[size7] = c11;
                        index$iv++;
                        size = size7 + 1;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bytes, size);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                return bArrCopyOf;
            }
            bytes[index] = (byte) b0;
        }
        int index2 = $this$commonAsUtf8ToByteArray.length();
        byte[] bArrCopyOf2 = Arrays.copyOf(bytes, index2);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(...)");
        return bArrCopyOf2;
    }
}
