package ni.shikatu.okio;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.ByteCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0006\u001a\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0080\b\u001a\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0080\b\u001a4\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001a4\u0010\u0015\u001a\u00020\u0012*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0012*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001a4\u0010\u001b\u001a\u00020\u0004*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001a4\u0010\u001d\u001a\u00020\u0004*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\u001a4\u0010\u001f\u001a\u00020\u0004*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014H\u0080\bø\u0001\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"utf8Size", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "beginIndex", _UrlKt.FRAGMENT_ENCODE_SET, "endIndex", "size", "REPLACEMENT_BYTE", _UrlKt.FRAGMENT_ENCODE_SET, "REPLACEMENT_CHARACTER", _UrlKt.FRAGMENT_ENCODE_SET, "REPLACEMENT_CODE_POINT", "isIsoControl", _UrlKt.FRAGMENT_ENCODE_SET, "codePoint", "isUtf8Continuation", "byte", "processUtf8Bytes", _UrlKt.FRAGMENT_ENCODE_SET, "yield", "Lni/shikatu/kotlin/Function1;", "processUtf8CodePoints", _UrlKt.FRAGMENT_ENCODE_SET, "HIGH_SURROGATE_HEADER", "LOG_SURROGATE_HEADER", "processUtf16Chars", "MASK_2BYTES", "process2Utf8Bytes", "MASK_3BYTES", "process3Utf8Bytes", "MASK_4BYTES", "process4Utf8Bytes", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final long size(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, i, 0, 2, null);
    }

    public static  long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    public static final long size(String $this$utf8Size, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$utf8Size, "<this>");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= $this$utf8Size.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + $this$utf8Size.length()).toString());
        }
        long result = 0;
        int i = beginIndex;
        while (i < endIndex) {
            int c = $this$utf8Size.charAt(i);
            if (c < 128) {
                result++;
                i++;
            } else if (c < 2048) {
                result += (long) 2;
                i++;
            } else if (c < 55296 || c > 57343) {
                result += (long) 3;
                i++;
            } else {
                int low = i + 1 < endIndex ? $this$utf8Size.charAt(i + 1) : 0;
                if (c > 56319 || low < 56320 || low > 57343) {
                    result++;
                    i++;
                } else {
                    result += (long) 4;
                    i += 2;
                }
            }
        }
        return result;
    }

    public static final boolean isIsoControl(int codePoint) {
        if (codePoint >= 0 && codePoint < 32) {
            return true;
        }
        return 127 <= codePoint && codePoint < 160;
    }

    public static final boolean isUtf8Continuation(byte b) {
        int other$iv = 192 & b;
        return other$iv == 128;
    }

    public static final void processUtf8Bytes(String $this$processUtf8Bytes, int beginIndex, int endIndex, Function1<? super Byte, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$processUtf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int index = beginIndex;
        while (index < endIndex) {
            char c = $this$processUtf8Bytes.charAt(index);
            if (Intrinsics.compare((int) c, 128) < 0) {
                function1.invoke(Byte.valueOf((byte) c));
                index++;
                while (index < endIndex && Intrinsics.compare((int) $this$processUtf8Bytes.charAt(index), 128) < 0) {
                    function1.invoke(Byte.valueOf((byte) $this$processUtf8Bytes.charAt(index)));
                    index++;
                }
            } else if (Intrinsics.compare((int) c, 2048) < 0) {
                function1.invoke(Byte.valueOf((byte) ((c >> 6) | 192)));
                function1.invoke(Byte.valueOf((byte) (128 | (c & '?'))));
                index++;
            } else {
                boolean z = false;
                if (!(55296 <= c && c < 57344)) {
                    function1.invoke(Byte.valueOf((byte) ((c >> '\f') | 224)));
                    function1.invoke(Byte.valueOf((byte) (((c >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) (128 | (c & '?'))));
                    index++;
                } else {
                    if (Intrinsics.compare((int) c, 56319) <= 0 && endIndex > index + 1) {
                        char cCharAt = $this$processUtf8Bytes.charAt(index + 1);
                        if (56320 <= cCharAt && cCharAt < 57344) {
                            z = true;
                        }
                        if (z) {
                            int codePoint = ((c << '\n') + $this$processUtf8Bytes.charAt(index + 1)) - 56613888;
                            function1.invoke(Byte.valueOf((byte) ((codePoint >> 18) | 240)));
                            function1.invoke(Byte.valueOf((byte) (((codePoint >> 12) & 63) | 128)));
                            function1.invoke(Byte.valueOf((byte) (((codePoint >> 6) & 63) | 128)));
                            function1.invoke(Byte.valueOf((byte) (128 | (codePoint & 63))));
                            index += 2;
                        }
                    }
                    function1.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                    index++;
                }
            }
        }
    }

    public static final void processUtf8CodePoints(byte[] $this$processUtf8CodePoints, int beginIndex, int endIndex, Function1<? super Integer, Unit> function1) {
        int codePoint$iv;
        int i;
        byte b2$iv;
        byte[] bArr = $this$processUtf8CodePoints;
        int i2 = endIndex;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int index = beginIndex;
        while (index < i2) {
            byte b0 = bArr[index];
            if (b0 >= 0) {
                function1.invoke(Integer.valueOf(b0));
                index++;
                while (index < i2 && bArr[index] >= 0) {
                    function1.invoke(Integer.valueOf(bArr[index]));
                    index++;
                }
            } else {
                int other$iv = b0 >> 5;
                if (other$iv == -2) {
                    int beginIndex$iv = index;
                    if (endIndex <= beginIndex$iv + 1) {
                        function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        Unit unit = Unit.INSTANCE;
                        codePoint$iv = 1;
                    } else {
                        byte b0$iv = $this$processUtf8CodePoints[beginIndex$iv];
                        byte b1$iv = $this$processUtf8CodePoints[beginIndex$iv + 1];
                        if ((b1$iv & 192) == 128) {
                            int codePoint$iv2 = (b1$iv ^ ByteCompanionObject.MIN_VALUE) ^ (b0$iv << 6);
                            if (codePoint$iv2 < 128) {
                                function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                function1.invoke(Integer.valueOf(codePoint$iv2));
                                Unit unit3 = Unit.INSTANCE;
                            }
                            codePoint$iv = 2;
                        } else {
                            function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit4 = Unit.INSTANCE;
                            codePoint$iv = 1;
                        }
                    }
                    index += codePoint$iv;
                } else {
                    int other$iv2 = b0 >> 4;
                    if (other$iv2 == -2) {
                        int beginIndex$iv2 = index;
                        if (endIndex <= beginIndex$iv2 + 2) {
                            function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            Unit unit5 = Unit.INSTANCE;
                            if (endIndex > beginIndex$iv2 + 1) {
                                int byte$iv$iv = $this$processUtf8CodePoints[beginIndex$iv2 + 1];
                                int other$iv$iv$iv = 192 & byte$iv$iv;
                                int $i$f$isUtf8Continuation = other$iv$iv$iv == 128 ? 1 : 0;
                                if ($i$f$isUtf8Continuation == 0) {
                                    i = 1;
                                } else {
                                    i = 2;
                                }
                            } else {
                                i = 1;
                            }
                        } else {
                            byte b0$iv2 = $this$processUtf8CodePoints[beginIndex$iv2];
                            byte b1$iv2 = $this$processUtf8CodePoints[beginIndex$iv2 + 1];
                            if ((b1$iv2 & 192) == 128) {
                                byte b2$iv2 = $this$processUtf8CodePoints[beginIndex$iv2 + 2];
                                if ((b2$iv2 & 192) == 128) {
                                    int codePoint$iv3 = (((-123008) ^ b2$iv2) ^ (b1$iv2 << 6)) ^ (b0$iv2 << 12);
                                    if (codePoint$iv3 < 2048) {
                                        function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                        Unit unit6 = Unit.INSTANCE;
                                    } else {
                                        if (55296 <= codePoint$iv3 && codePoint$iv3 < 57344) {
                                            function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                            Unit unit7 = Unit.INSTANCE;
                                        } else {
                                            function1.invoke(Integer.valueOf(codePoint$iv3));
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                    }
                                    i = 3;
                                } else {
                                    function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    Unit unit9 = Unit.INSTANCE;
                                    i = 2;
                                }
                            } else {
                                function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit10 = Unit.INSTANCE;
                                i = 1;
                            }
                        }
                        index += i;
                    } else {
                        int other$iv3 = b0 >> 3;
                        if (other$iv3 == -2) {
                            int beginIndex$iv3 = index;
                            if (endIndex <= beginIndex$iv3 + 3) {
                                function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                Unit unit11 = Unit.INSTANCE;
                                if (endIndex > beginIndex$iv3 + 1) {
                                    int byte$iv$iv2 = $this$processUtf8CodePoints[beginIndex$iv3 + 1];
                                    int other$iv$iv$iv2 = 192 & byte$iv$iv2;
                                    byte byte$iv$iv3 = other$iv$iv$iv2 == 128 ? (byte) 1 : (byte) 0;
                                    if (byte$iv$iv3 == 0) {
                                        b2$iv = 1;
                                    } else if (endIndex > beginIndex$iv3 + 2) {
                                        int byte$iv$iv4 = $this$processUtf8CodePoints[beginIndex$iv3 + 2];
                                        int other$iv$iv$iv3 = 192 & byte$iv$iv4;
                                        if (other$iv$iv$iv3 == 128) {
                                            b2$iv = 3;
                                        } else {
                                            b2$iv = 2;
                                        }
                                    } else {
                                        b2$iv = 2;
                                    }
                                } else {
                                    b2$iv = 1;
                                }
                            } else {
                                byte b0$iv3 = $this$processUtf8CodePoints[beginIndex$iv3];
                                byte b1$iv3 = $this$processUtf8CodePoints[beginIndex$iv3 + 1];
                                if ((b1$iv3 & 192) == 128) {
                                    byte b2$iv3 = $this$processUtf8CodePoints[beginIndex$iv3 + 2];
                                    if ((b2$iv3 & 192) == 128) {
                                        byte b3$iv = $this$processUtf8CodePoints[beginIndex$iv3 + 3];
                                        if ((b3$iv & 192) == 128) {
                                            int codePoint$iv4 = (((3678080 ^ b3$iv) ^ (b2$iv3 << 6)) ^ (b1$iv3 << 12)) ^ (b0$iv3 << 18);
                                            if (codePoint$iv4 > 1114111) {
                                                function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                                Unit unit12 = Unit.INSTANCE;
                                            } else {
                                                if (!(55296 <= codePoint$iv4 && codePoint$iv4 < 57344) && codePoint$iv4 >= 65536) {
                                                    function1.invoke(Integer.valueOf(codePoint$iv4));
                                                    Unit unit13 = Unit.INSTANCE;
                                                } else {
                                                    function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                                    Unit unit14 = Unit.INSTANCE;
                                                }
                                            }
                                            b2$iv = 4;
                                        } else {
                                            function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                            Unit unit15 = Unit.INSTANCE;
                                            b2$iv = 3;
                                        }
                                    } else {
                                        function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                        Unit unit16 = Unit.INSTANCE;
                                        b2$iv = 2;
                                    }
                                } else {
                                    function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    Unit unit17 = Unit.INSTANCE;
                                    b2$iv = 1;
                                }
                            }
                            index += b2$iv;
                            bArr = $this$processUtf8CodePoints;
                            i2 = endIndex;
                        } else {
                            function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            index++;
                            bArr = $this$processUtf8CodePoints;
                            i2 = endIndex;
                        }
                    }
                }
            }
        }
    }

    public static final void processUtf16Chars(byte[] $this$processUtf16Chars, int beginIndex, int endIndex, Function1<? super Character, Unit> function1) {
        int codePoint$iv;
        int i;
        byte b3$iv;
        Intrinsics.checkNotNullParameter($this$processUtf16Chars, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int index = beginIndex;
        while (index < endIndex) {
            byte b0 = $this$processUtf16Chars[index];
            if (b0 >= 0) {
                function1.invoke(Character.valueOf((char) b0));
                index++;
                while (index < endIndex && $this$processUtf16Chars[index] >= 0) {
                    function1.invoke(Character.valueOf((char) $this$processUtf16Chars[index]));
                    index++;
                }
            } else {
                int other$iv = b0 >> 5;
                if (other$iv == -2) {
                    int beginIndex$iv = index;
                    if (endIndex <= beginIndex$iv + 1) {
                        function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        Unit unit = Unit.INSTANCE;
                        codePoint$iv = 1;
                    } else {
                        byte b0$iv = $this$processUtf16Chars[beginIndex$iv];
                        byte b1$iv = $this$processUtf16Chars[beginIndex$iv + 1];
                        if ((b1$iv & 192) == 128) {
                            int codePoint$iv2 = (b1$iv ^ ByteCompanionObject.MIN_VALUE) ^ (b0$iv << 6);
                            if (codePoint$iv2 < 128) {
                                function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                function1.invoke(Character.valueOf((char) codePoint$iv2));
                                Unit unit3 = Unit.INSTANCE;
                            }
                            codePoint$iv = 2;
                        } else {
                            function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            Unit unit4 = Unit.INSTANCE;
                            codePoint$iv = 1;
                        }
                    }
                    index += codePoint$iv;
                } else {
                    int other$iv2 = b0 >> 4;
                    if (other$iv2 == -2) {
                        int beginIndex$iv2 = index;
                        if (endIndex <= beginIndex$iv2 + 2) {
                            function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            Unit unit5 = Unit.INSTANCE;
                            if (endIndex > beginIndex$iv2 + 1) {
                                int byte$iv$iv = $this$processUtf16Chars[beginIndex$iv2 + 1];
                                int other$iv$iv$iv = 192 & byte$iv$iv;
                                int $i$f$isUtf8Continuation = other$iv$iv$iv == 128 ? 1 : 0;
                                if ($i$f$isUtf8Continuation == 0) {
                                    i = 1;
                                } else {
                                    i = 2;
                                }
                            } else {
                                i = 1;
                            }
                        } else {
                            byte b0$iv2 = $this$processUtf16Chars[beginIndex$iv2];
                            byte b1$iv2 = $this$processUtf16Chars[beginIndex$iv2 + 1];
                            if ((b1$iv2 & 192) == 128) {
                                byte b2$iv = $this$processUtf16Chars[beginIndex$iv2 + 2];
                                if ((b2$iv & 192) == 128) {
                                    int codePoint$iv3 = (((-123008) ^ b2$iv) ^ (b1$iv2 << 6)) ^ (b0$iv2 << 12);
                                    if (codePoint$iv3 < 2048) {
                                        function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                        Unit unit6 = Unit.INSTANCE;
                                    } else {
                                        if (55296 <= codePoint$iv3 && codePoint$iv3 < 57344) {
                                            function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                            Unit unit7 = Unit.INSTANCE;
                                        } else {
                                            function1.invoke(Character.valueOf((char) codePoint$iv3));
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                    }
                                    i = 3;
                                } else {
                                    function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                    Unit unit9 = Unit.INSTANCE;
                                    i = 2;
                                }
                            } else {
                                function1.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                Unit unit10 = Unit.INSTANCE;
                                i = 1;
                            }
                        }
                        index += i;
                    } else {
                        int other$iv3 = b0 >> 3;
                        if (other$iv3 == -2) {
                            int beginIndex$iv3 = index;
                            if (endIndex <= beginIndex$iv3 + 3) {
                                if (65533 != 65533) {
                                    function1.invoke(Character.valueOf((char) ((REPLACEMENT_CODE_POINT >>> 10) + HIGH_SURROGATE_HEADER)));
                                    function1.invoke(Character.valueOf((char) ((65533 & 1023) + LOG_SURROGATE_HEADER)));
                                } else {
                                    function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                }
                                Unit unit11 = Unit.INSTANCE;
                                if (endIndex > beginIndex$iv3 + 1) {
                                    int byte$iv$iv2 = $this$processUtf16Chars[beginIndex$iv3 + 1];
                                    int other$iv$iv$iv2 = 192 & byte$iv$iv2;
                                    byte byte$iv$iv3 = other$iv$iv$iv2 == 128 ? (byte) 1 : (byte) 0;
                                    if (byte$iv$iv3 == 0) {
                                        b3$iv = 1;
                                    } else if (endIndex > beginIndex$iv3 + 2) {
                                        int byte$iv$iv4 = $this$processUtf16Chars[beginIndex$iv3 + 2];
                                        int other$iv$iv$iv3 = 192 & byte$iv$iv4;
                                        int $i$f$isUtf8Continuation2 = other$iv$iv$iv3 == 128 ? 1 : 0;
                                        if ($i$f$isUtf8Continuation2 == 0) {
                                            b3$iv = 2;
                                        } else {
                                            b3$iv = 3;
                                        }
                                    } else {
                                        b3$iv = 2;
                                    }
                                } else {
                                    b3$iv = 1;
                                }
                            } else {
                                byte b0$iv3 = $this$processUtf16Chars[beginIndex$iv3];
                                byte b1$iv3 = $this$processUtf16Chars[beginIndex$iv3 + 1];
                                if ((b1$iv3 & 192) == 128) {
                                    byte b2$iv2 = $this$processUtf16Chars[beginIndex$iv3 + 2];
                                    if ((b2$iv2 & 192) == 128) {
                                        byte b3$iv2 = $this$processUtf16Chars[beginIndex$iv3 + 3];
                                        if ((b3$iv2 & 192) == 128) {
                                            int codePoint$iv4 = (((3678080 ^ b3$iv2) ^ (b2$iv2 << 6)) ^ (b1$iv3 << 12)) ^ (b0$iv3 << 18);
                                            if (codePoint$iv4 > 1114111) {
                                                if (65533 != 65533) {
                                                    function1.invoke(Character.valueOf((char) ((REPLACEMENT_CODE_POINT >>> 10) + HIGH_SURROGATE_HEADER)));
                                                    function1.invoke(Character.valueOf((char) ((65533 & 1023) + LOG_SURROGATE_HEADER)));
                                                } else {
                                                    function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                                }
                                                Unit unit12 = Unit.INSTANCE;
                                            } else {
                                                if (55296 <= codePoint$iv4 && codePoint$iv4 < 57344) {
                                                    if (65533 != 65533) {
                                                        function1.invoke(Character.valueOf((char) ((REPLACEMENT_CODE_POINT >>> 10) + HIGH_SURROGATE_HEADER)));
                                                        function1.invoke(Character.valueOf((char) ((65533 & 1023) + LOG_SURROGATE_HEADER)));
                                                    } else {
                                                        function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                                    }
                                                    Unit unit13 = Unit.INSTANCE;
                                                } else if (codePoint$iv4 < 65536) {
                                                    if (65533 != 65533) {
                                                        function1.invoke(Character.valueOf((char) ((REPLACEMENT_CODE_POINT >>> 10) + HIGH_SURROGATE_HEADER)));
                                                        function1.invoke(Character.valueOf((char) ((65533 & 1023) + LOG_SURROGATE_HEADER)));
                                                    } else {
                                                        function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                                    }
                                                    Unit unit14 = Unit.INSTANCE;
                                                } else {
                                                    if (codePoint$iv4 != 65533) {
                                                        function1.invoke(Character.valueOf((char) ((codePoint$iv4 >>> 10) + HIGH_SURROGATE_HEADER)));
                                                        function1.invoke(Character.valueOf((char) ((codePoint$iv4 & 1023) + LOG_SURROGATE_HEADER)));
                                                    } else {
                                                        function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                                    }
                                                    Unit unit15 = Unit.INSTANCE;
                                                }
                                            }
                                            b3$iv = 4;
                                        } else {
                                            if (65533 != 65533) {
                                                function1.invoke(Character.valueOf((char) ((REPLACEMENT_CODE_POINT >>> 10) + HIGH_SURROGATE_HEADER)));
                                                function1.invoke(Character.valueOf((char) ((65533 & 1023) + LOG_SURROGATE_HEADER)));
                                            } else {
                                                function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                            }
                                            Unit unit16 = Unit.INSTANCE;
                                            b3$iv = 3;
                                        }
                                    } else {
                                        if (65533 != 65533) {
                                            function1.invoke(Character.valueOf((char) ((REPLACEMENT_CODE_POINT >>> 10) + HIGH_SURROGATE_HEADER)));
                                            function1.invoke(Character.valueOf((char) ((65533 & 1023) + LOG_SURROGATE_HEADER)));
                                        } else {
                                            function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                        }
                                        Unit unit17 = Unit.INSTANCE;
                                        b3$iv = 2;
                                    }
                                } else {
                                    if (65533 != 65533) {
                                        function1.invoke(Character.valueOf((char) ((REPLACEMENT_CODE_POINT >>> 10) + HIGH_SURROGATE_HEADER)));
                                        function1.invoke(Character.valueOf((char) ((65533 & 1023) + LOG_SURROGATE_HEADER)));
                                    } else {
                                        function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    }
                                    Unit unit18 = Unit.INSTANCE;
                                    b3$iv = 1;
                                }
                            }
                            index += b3$iv;
                        } else {
                            function1.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            index++;
                        }
                    }
                }
            }
        }
    }

    public static final int process2Utf8Bytes(byte[] $this$process2Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$process2Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i = beginIndex + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (endIndex <= i) {
            function1.invoke(numValueOf);
            return 1;
        }
        byte b0 = $this$process2Utf8Bytes[beginIndex];
        int b1 = $this$process2Utf8Bytes[beginIndex + 1];
        int other$iv$iv = 192 & b1;
        if (!(other$iv$iv == 128)) {
            function1.invoke(numValueOf);
            return 1;
        }
        int codePoint = (b1 ^ MASK_2BYTES) ^ (b0 << 6);
        if (codePoint < 128) {
            function1.invoke(numValueOf);
            return 2;
        }
        function1.invoke(Integer.valueOf(codePoint));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] $this$process3Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$process3Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i = beginIndex + 2;
        boolean z = false;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (endIndex <= i) {
            function1.invoke(numValueOf);
            if (endIndex > beginIndex + 1) {
                int byte$iv = $this$process3Utf8Bytes[beginIndex + 1];
                int other$iv$iv = 192 & byte$iv;
                if (other$iv$iv == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b0 = $this$process3Utf8Bytes[beginIndex];
        int b1 = $this$process3Utf8Bytes[beginIndex + 1];
        int other$iv$iv2 = 192 & b1;
        byte byte$iv2 = other$iv$iv2 == 128 ? (byte) 1 : (byte) 0;
        if (byte$iv2 == 0) {
            function1.invoke(numValueOf);
            return 1;
        }
        int b2 = $this$process3Utf8Bytes[beginIndex + 2];
        int other$iv$iv3 = 192 & b2;
        if (!(other$iv$iv3 == 128)) {
            function1.invoke(numValueOf);
            return 2;
        }
        int codePoint = (((-123008) ^ b2) ^ (b1 << 6)) ^ (b0 << 12);
        if (codePoint < 2048) {
            function1.invoke(numValueOf);
            return 3;
        }
        if (55296 <= codePoint && codePoint < 57344) {
            z = true;
        }
        if (z) {
            function1.invoke(numValueOf);
            return 3;
        }
        function1.invoke(Integer.valueOf(codePoint));
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] $this$process4Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$process4Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i = beginIndex + 3;
        boolean z = false;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (endIndex <= i) {
            function1.invoke(numValueOf);
            if (endIndex > beginIndex + 1) {
                int byte$iv = $this$process4Utf8Bytes[beginIndex + 1];
                int other$iv$iv = 192 & byte$iv;
                byte byte$iv2 = other$iv$iv == 128 ? (byte) 1 : (byte) 0;
                if (byte$iv2 != 0) {
                    if (endIndex > beginIndex + 2) {
                        int byte$iv3 = $this$process4Utf8Bytes[beginIndex + 2];
                        int other$iv$iv2 = 192 & byte$iv3;
                        if (other$iv$iv2 == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b0 = $this$process4Utf8Bytes[beginIndex];
        int b1 = $this$process4Utf8Bytes[beginIndex + 1];
        int other$iv$iv3 = 192 & b1;
        byte byte$iv4 = other$iv$iv3 == 128 ? (byte) 1 : (byte) 0;
        if (byte$iv4 == 0) {
            function1.invoke(numValueOf);
            return 1;
        }
        int b2 = $this$process4Utf8Bytes[beginIndex + 2];
        int other$iv$iv4 = b2 & 192;
        byte byte$iv5 = other$iv$iv4 == 128 ? (byte) 1 : (byte) 0;
        if (byte$iv5 == 0) {
            function1.invoke(numValueOf);
            return 2;
        }
        int b3 = $this$process4Utf8Bytes[beginIndex + 3];
        int other$iv$iv5 = b3 & 192;
        if (!(other$iv$iv5 == 128)) {
            function1.invoke(numValueOf);
            return 3;
        }
        int codePoint = (((3678080 ^ b3) ^ (b2 << 6)) ^ (b1 << 12)) ^ (b0 << 18);
        if (codePoint > 1114111) {
            function1.invoke(numValueOf);
            return 4;
        }
        if (55296 <= codePoint && codePoint < 57344) {
            z = true;
        }
        if (z) {
            function1.invoke(numValueOf);
            return 4;
        }
        if (codePoint < 65536) {
            function1.invoke(numValueOf);
            return 4;
        }
        function1.invoke(Integer.valueOf(codePoint));
        return 4;
    }
}
