package ni.shikatu.kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.http.HttpStatusCodesKt;
import ni.shikatu.okhttp3.internal.http2.Settings;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u000e\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\"\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\rb\u0002\b\b\u001a\u0012\u0010\u000e\u001a\u00020\u0002*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u000e\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u000f\u001a\u00020\t*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u000f\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0010\u001a\u00020\u0004*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u0010\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0011\u001a\u00020\n*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u0011\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a#\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u0017\u001a#\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u0019\u001a \u0010\u001a\u001a\u00020\u001b*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a(\u0010\u001a\u001a\u00020\u001b*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001b*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a&\u0010\u001d\u001a\u0004\u0018\u00010\u001b*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a \u0010\u001e\u001a\u00020\u001f*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a(\u0010\u001e\u001a\u00020\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a\u001e\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a&\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a5\u0010#\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H$0'H\u0082\u0088\u0004¢\u0006\u0004\b(\u0010)\u001a5\u0010*\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H$0'H\u0082\u0088\u0004¢\u0006\u0004\b+\u0010)\u001a\u0017\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b.\u001a\u0017\u0010/\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b0\u001a%\u00101\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b4\u001a\u0017\u00105\u001a\u00020\f*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b7\u001a\u0017\u00108\u001a\u00020\f*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b9\u001a\u0017\u0010:\u001a\u00020\u0004*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b;\u001a;\u0010<\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b>\u001a;\u0010?\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b@\u001aC\u0010A\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\f2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\bC¨\u0006D"}, d2 = {"toString", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "radix", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "Lni/shikatu/kotlin/internal/InlineOnly;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "toBoolean", _UrlKt.FRAGMENT_ENCODE_SET, "1.4", "toByte", "toShort", "toInt", "toLong", "toFloat", _UrlKt.FRAGMENT_ENCODE_SET, "toDouble", _UrlKt.FRAGMENT_ENCODE_SET, "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toBigInteger", "Ljava/math/BigInteger;", "1.2", "toBigIntegerOrNull", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "screenFloatValue", "T", "str", "parse", "Lni/shikatu/kotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "screenBigDecimalValue", "screenBigDecimalValue$StringsKt__StringNumberConversionsJVMKt", "isValidFloat", "s", "isValidFloat$StringsKt__StringNumberConversionsJVMKt", "isValidBigDecimal", "isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt", "guessNamedFloatConstant", "start", "endInclusive", "guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt", "isAsciiDigit", _UrlKt.FRAGMENT_ENCODE_SET, "isAsciiDigit$StringsKt__StringNumberConversionsJVMKt", "isHexLetter", "isHexLetter$StringsKt__StringNumberConversionsJVMKt", "asciiLetterToLowerCaseCode", "asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt", "advanceWhile", "predicate", "advanceWhile$StringsKt__StringNumberConversionsJVMKt", "backtrackWhile", "backtrackWhile$StringsKt__StringNumberConversionsJVMKt", "advanceAndValidateMantissa", "hexFormat", "advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    private static final String toString(byte $this$toString, int radix) {
        String string = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final String toString(short $this$toString, int radix) {
        String string = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final String toString(int $this$toString, int radix) {
        String string = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final String toString(long $this$toString, int radix) {
        String string = Long.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final boolean toBoolean(String $this$toBoolean) {
        return Boolean.parseBoolean($this$toBoolean);
    }

    private static final byte toByte(String $this$toByte) {
        Intrinsics.checkNotNullParameter($this$toByte, "<this>");
        return Byte.parseByte($this$toByte);
    }

    private static final byte toByte(String $this$toByte, int radix) {
        Intrinsics.checkNotNullParameter($this$toByte, "<this>");
        return Byte.parseByte($this$toByte, CharsKt.checkRadix(radix));
    }

    private static final short toShort(String $this$toShort) {
        Intrinsics.checkNotNullParameter($this$toShort, "<this>");
        return Short.parseShort($this$toShort);
    }

    private static final short toShort(String $this$toShort, int radix) {
        Intrinsics.checkNotNullParameter($this$toShort, "<this>");
        return Short.parseShort($this$toShort, CharsKt.checkRadix(radix));
    }

    private static final int toInt(String $this$toInt) {
        Intrinsics.checkNotNullParameter($this$toInt, "<this>");
        return Integer.parseInt($this$toInt);
    }

    private static final int toInt(String $this$toInt, int radix) {
        Intrinsics.checkNotNullParameter($this$toInt, "<this>");
        return Integer.parseInt($this$toInt, CharsKt.checkRadix(radix));
    }

    private static final long toLong(String $this$toLong) {
        Intrinsics.checkNotNullParameter($this$toLong, "<this>");
        return Long.parseLong($this$toLong);
    }

    private static final long toLong(String $this$toLong, int radix) {
        Intrinsics.checkNotNullParameter($this$toLong, "<this>");
        return Long.parseLong($this$toLong, CharsKt.checkRadix(radix));
    }

    private static final float toFloat(String $this$toFloat) {
        Intrinsics.checkNotNullParameter($this$toFloat, "<this>");
        return Float.parseFloat($this$toFloat);
    }

    private static final double toDouble(String $this$toDouble) {
        Intrinsics.checkNotNullParameter($this$toDouble, "<this>");
        return Double.parseDouble($this$toDouble);
    }

    public static final Float toFloatOrNull(String $this$toFloatOrNull) {
        Intrinsics.checkNotNullParameter($this$toFloatOrNull, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toFloatOrNull)) {
                return Float.valueOf(Float.parseFloat($this$toFloatOrNull));
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static final Double toDoubleOrNull(String $this$toDoubleOrNull) {
        Intrinsics.checkNotNullParameter($this$toDoubleOrNull, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toDoubleOrNull)) {
                return Double.valueOf(Double.parseDouble($this$toDoubleOrNull));
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static final BigInteger toBigInteger(String $this$toBigInteger) {
        Intrinsics.checkNotNullParameter($this$toBigInteger, "<this>");
        return new BigInteger($this$toBigInteger);
    }

    private static final BigInteger toBigInteger(String $this$toBigInteger, int radix) {
        Intrinsics.checkNotNullParameter($this$toBigInteger, "<this>");
        return new BigInteger($this$toBigInteger, CharsKt.checkRadix(radix));
    }

    public static final BigInteger toBigIntegerOrNull(String $this$toBigIntegerOrNull) {
        Intrinsics.checkNotNullParameter($this$toBigIntegerOrNull, "<this>");
        return StringsKt.toBigIntegerOrNull($this$toBigIntegerOrNull, 10);
    }

    public static final BigInteger toBigIntegerOrNull(String $this$toBigIntegerOrNull, int radix) {
        Intrinsics.checkNotNullParameter($this$toBigIntegerOrNull, "<this>");
        CharsKt.checkRadix(radix);
        int length = $this$toBigIntegerOrNull.length();
        switch (length) {
            case 0:
                return null;
            case 1:
                if (CharsKt.digitOf($this$toBigIntegerOrNull.charAt(0), radix) < 0) {
                    return null;
                }
                break;
            default:
                int start = $this$toBigIntegerOrNull.charAt(0) == '-' ? 1 : 0;
                for (int index = start; index < length; index++) {
                    if (CharsKt.digitOf($this$toBigIntegerOrNull.charAt(index), radix) < 0) {
                        return null;
                    }
                }
                break;
        }
        return new BigInteger($this$toBigIntegerOrNull, CharsKt.checkRadix(radix));
    }

    private static final BigDecimal toBigDecimal(String $this$toBigDecimal) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        return new BigDecimal($this$toBigDecimal);
    }

    private static final BigDecimal toBigDecimal(String $this$toBigDecimal, MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, mathContext);
    }

    public static final BigDecimal toBigDecimalOrNull(String $this$toBigDecimalOrNull) {
        Intrinsics.checkNotNullParameter($this$toBigDecimalOrNull, "<this>");
        try {
            if (isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt($this$toBigDecimalOrNull)) {
                return new BigDecimal($this$toBigDecimalOrNull);
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String $this$toBigDecimalOrNull, MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimalOrNull, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt($this$toBigDecimalOrNull)) {
                return new BigDecimal($this$toBigDecimalOrNull, mathContext);
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (!isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return null;
            }
            return function1.invoke(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static final <T> T screenBigDecimalValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (!isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(str)) {
                return null;
            }
            return function1.invoke(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(String s) {
        char c;
        boolean z;
        int i;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = true;
        int endInclusive = s.length() - 1;
        int start = 0;
        while (true) {
            c = ' ';
            if (start > endInclusive) {
                break;
            }
            char it = s.charAt(start);
            char it2 = it <= ' ' ? (char) 1 : (char) 0;
            if (it2 == 0) {
                break;
            }
            start++;
        }
        if (start > endInclusive) {
            return false;
        }
        int endInclusive2 = endInclusive;
        while (endInclusive2 > start) {
            char it3 = s.charAt(endInclusive2);
            char it4 = it3 <= ' ' ? (char) 1 : (char) 0;
            if (it4 == 0) {
                break;
            }
            endInclusive2--;
        }
        if (s.charAt(start) == 43 || s.charAt(start) == '-') {
            start++;
        }
        if (start > endInclusive2) {
            return false;
        }
        boolean isHex = false;
        if (s.charAt(start) == '0') {
            int start2 = start + 1;
            if (start2 > endInclusive2) {
                return true;
            }
            if ((s.charAt(start2) | ' ') == 120) {
                int start3 = start2 + 1;
                int i2 = start3;
                while (true) {
                    if (i2 > endInclusive2) {
                        z = z6;
                        break;
                    }
                    char it5 = s.charAt(i2);
                    z = z6;
                    if (((it5 + 65488) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10 ? z : false) {
                        z5 = z;
                    } else {
                        if ((((it5 | ' ') + (-97)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 6 ? z : false) {
                            z5 = z;
                        } else {
                            z5 = false;
                        }
                    }
                    if (!z5) {
                        break;
                    }
                    i2++;
                    z6 = z;
                }
                boolean z7 = start3 != i2 ? z : false;
                if (i2 <= endInclusive2) {
                    if (s.charAt(i2) == '.') {
                        int i3 = i2 + 1;
                        int i4 = i3;
                        while (i4 <= endInclusive2) {
                            char it6 = s.charAt(i4);
                            char c2 = c;
                            if (((it6 + 65488) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10 ? z : false) {
                                z4 = z;
                            } else {
                                if ((((it6 | ' ') + (-97)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 6 ? z : false) {
                                    z4 = z;
                                } else {
                                    z4 = false;
                                }
                            }
                            if (!z4) {
                                break;
                            }
                            i4++;
                            c = c2;
                        }
                        z3 = i3 != i4 ? z : false;
                        i2 = i4;
                    } else {
                        z3 = false;
                    }
                    if (!z7 && !z3) {
                    }
                    start = i2;
                    if (start != -1 || start > endInclusive2) {
                        return false;
                    }
                    isHex = true;
                }
                i2 = -1;
                start = i2;
                if (start != -1) {
                }
                return false;
            }
            z = true;
            start = start2 - 1;
        } else {
            z = true;
        }
        if (!isHex) {
            int i5 = start;
            while (i5 <= endInclusive2) {
                char it7 = s.charAt(i5);
                if (!(((it7 + 65488) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10 ? z : false)) {
                    break;
                }
                i5++;
            }
            boolean z8 = start != i5 ? z : false;
            if (i5 <= endInclusive2) {
                if (s.charAt(i5) == '.') {
                    int i6 = i5 + 1;
                    i = i6;
                    while (i <= endInclusive2) {
                        char it8 = s.charAt(i);
                        if (!(((it8 + 65488) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10 ? z : false)) {
                            break;
                        }
                        i++;
                    }
                    z2 = i6 != i ? z : false;
                } else {
                    i = i5;
                    z2 = false;
                }
                if (z8 || z2) {
                    i5 = i;
                } else {
                    if (endInclusive2 == (i + 3) - 1) {
                        str = "NaN";
                    } else {
                        str = endInclusive2 == (i + 8) + (-1) ? "Infinity" : null;
                    }
                    i5 = (str != null && StringsKt.indexOf((CharSequence) s, str, i, false) == i) ? endInclusive2 + 1 : -1;
                }
            }
            start = i5;
            if (start == -1) {
                return false;
            }
            if (start > endInclusive2) {
                return z;
            }
        }
        int start4 = start + 1;
        int l = s.charAt(start) | 32;
        if (l != (isHex ? 112 : HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS)) {
            if (isHex || (!(l == 102 || l == 100) || start4 <= endInclusive2)) {
                return false;
            }
            return z;
        }
        if (start4 > endInclusive2) {
            return false;
        }
        if ((s.charAt(start4) == '+' || s.charAt(start4) == '-') && (start4 = start4 + 1) > endInclusive2) {
            return false;
        }
        int start5 = start4;
        while (start5 <= endInclusive2) {
            char it9 = s.charAt(start5);
            if (!(((it9 + 65488) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10 ? z : false)) {
                break;
            }
            start5++;
        }
        if (start5 > endInclusive2) {
            return z;
        }
        if (start5 != endInclusive2) {
            return false;
        }
        int l2 = s.charAt(start5) | 32;
        if (l2 == 102 || l2 == 100) {
            return z;
        }
        return false;
    }

    private static final boolean isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(String s) {
        int index;
        if (s.length() == 0) {
            return false;
        }
        int start = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;
        int startIndex$iv = start;
        int i$iv = startIndex$iv;
        while (i$iv < s.length()) {
            char it = s.charAt(i$iv);
            if (!Character.isDigit(it)) {
                break;
            }
            i$iv++;
        }
        if (i$iv == s.length()) {
            return i$iv - start > 0;
        }
        if (s.charAt(i$iv) == '.') {
            int index2 = i$iv + 1;
            if (index2 == s.length()) {
                return index2 - start > 1;
            }
            int i$iv2 = index2;
            while (i$iv2 < s.length()) {
                char it2 = s.charAt(i$iv2);
                if (!Character.isDigit(it2)) {
                    break;
                }
                i$iv2++;
            }
            i$iv = i$iv2;
        }
        if (i$iv == s.length()) {
            return true;
        }
        if ((s.charAt(i$iv) != 'e' && s.charAt(i$iv) != 'E') || (index = i$iv + 1) == s.length()) {
            return false;
        }
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }
        if (index == s.length()) {
            return false;
        }
        int startIndex$iv2 = index;
        int i$iv3 = startIndex$iv2;
        while (i$iv3 < s.length()) {
            char it3 = s.charAt(i$iv3);
            if (!Character.isDigit(it3)) {
                break;
            }
            i$iv3++;
        }
        return i$iv3 == s.length();
    }

    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int start, int endInclusive) {
        if (endInclusive == (start + 3) - 1) {
            return "NaN";
        }
        if (endInclusive == (start + 8) - 1) {
            return "Infinity";
        }
        return null;
    }

    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char $this$isAsciiDigit) {
        return (($this$isAsciiDigit + 65488) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10;
    }

    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char $this$isHexLetter) {
        return ((($this$isHexLetter | ' ') + (-97)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 6;
    }

    private static final int asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt(char $this$asciiLetterToLowerCaseCode) {
        return $this$asciiLetterToLowerCaseCode | ' ';
    }

    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String $this$advanceWhile, int start, int endInclusive, Function1<? super Character, Boolean> function1) {
        int start2 = start;
        while (start2 <= endInclusive && function1.invoke(Character.valueOf($this$advanceWhile.charAt(start2))).booleanValue()) {
            start2++;
        }
        return start2;
    }

    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String $this$backtrackWhile, int start, int endInclusive, Function1<? super Character, Boolean> function1) {
        int endInclusive2 = endInclusive;
        while (endInclusive2 > start && function1.invoke(Character.valueOf($this$backtrackWhile.charAt(endInclusive2))).booleanValue()) {
            endInclusive2--;
        }
        return endInclusive2;
    }

    private static final int advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt(String $this$advanceAndValidateMantissa, int start, int endInclusive, boolean hexFormat, Function1<? super Character, Boolean> function1) {
        String constant;
        int start2 = start;
        while (start2 <= endInclusive && function1.invoke(Character.valueOf($this$advanceAndValidateMantissa.charAt(start2))).booleanValue()) {
            start2++;
        }
        boolean hasIntegerPart = start != start2;
        if (start2 > endInclusive) {
            if (hexFormat) {
                return -1;
            }
            return start2;
        }
        boolean hasFractionalPart = false;
        if ($this$advanceAndValidateMantissa.charAt(start2) == '.') {
            int start3 = start2 + 1;
            int i = start3;
            while (i <= endInclusive && function1.invoke(Character.valueOf($this$advanceAndValidateMantissa.charAt(i))).booleanValue()) {
                i++;
            }
            start2 = i;
            hasFractionalPart = start3 != start2;
        }
        if (!hasIntegerPart && !hasFractionalPart) {
            if (hexFormat) {
                return -1;
            }
            if (endInclusive == (start2 + 3) - 1) {
                constant = "NaN";
            } else {
                constant = endInclusive == (start2 + 8) - 1 ? "Infinity" : null;
            }
            if (constant != null && StringsKt.indexOf((CharSequence) $this$advanceAndValidateMantissa, constant, start2, false) == start2) {
                return endInclusive + 1;
            }
            return -1;
        }
        return start2;
    }
}
