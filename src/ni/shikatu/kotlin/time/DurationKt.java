package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.math.MathKt;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.http2.Http2;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\n\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0011¢\u0006\u0004\b\u000f\u0010\u0010\u001a/\u0010\r\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001d\u001a/\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010 \u001a\u0016\u0010!\u001a\u00020\t*\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010#\u001a\u00020\u0018*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010$\u001a\u00020\u0018*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u001e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a&\u0010(\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a\u0016\u0010*\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a%\u0010+\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020\u0016H\u0083\u0088\u0004b\u0002\b\u0011¢\u0006\u0002\u0010-\u001a'\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000100H\u0082\u0088\u0004¢\u0006\u0004\b1\u00102\u001a\u0018\u00103\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0018\u00105\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0012\u0010A\u001a\u00020\t*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010A\u001a\u00020\u0002*\u00020\u0002H\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0017\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0017\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u001f\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0002H\u0082\u0080\u0004¢\u0006\u0002\u0010Z\u001a\u0017\u0010[\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0017\u0010\\\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\"\u001f\u00106\u001a\u00020\u000b*\u00020\u00048BX\u0082\u0084\b¢\u0006\f\u0012\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0019\u0010;\u001a\u00020\t*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b<\u0010=\"\u0019\u0010>\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b?\u0010@\"\u000f\u0010B\u001a\u00020\u0002X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010C\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010D\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010E\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010F\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010G\u001a\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010H\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010I\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010J\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010K\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010L\u001a\u00020\u0016X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010M\u001a\u00020\u0002X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"toDuration", "Lni/shikatu/kotlin/time/Duration;", _UrlKt.FRAGMENT_ENCODE_SET, "unit", "Lni/shikatu/kotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.6", _UrlKt.FRAGMENT_ENCODE_SET, "(JLkotlin/time/DurationUnit;)J", _UrlKt.FRAGMENT_ENCODE_SET, "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "Lni/shikatu/kotlin/internal/InlineOnly;", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", _UrlKt.FRAGMENT_ENCODE_SET, "strictIso", _UrlKt.FRAGMENT_ENCODE_SET, "throwException", "(Ljava/lang/String;ZZ)J", "parseIsoStringFormat", "startIndex", "(Ljava/lang/String;IZ)J", "parseDefaultStringFormat", "hasSign", "(Ljava/lang/String;IZZ)J", "addMillisWithoutOverflow", "other", "isInfiniteMillis", "isFiniteMillis", "sameSign", "a", "b", "parseFractionFallback", "endIndex", "fractionDigitsToNanos", "handleError", "message", "(ZLjava/lang/String;)J", "onInvalid", "block", "Lni/shikatu/kotlin/Function0;", "onInvalid-ge6A_vg", "(JLkotlin/jvm/functions/Function0;)Lkotlin/time/Duration;", "defaultDurationUnitByShortNameOrNull", "start", "isoDurationUnitByShortNameOrNull", "fractionMultiplier", "getFractionMultiplier$annotations", "(Lkotlin/time/DurationUnit;)V", "getFractionMultiplier", "(Lkotlin/time/DurationUnit;)D", "fallbackFractionMultiplier", "getFallbackFractionMultiplier", "(Lkotlin/time/DurationUnit;)J", "shortNameLength", "getShortNameLength", "(Lkotlin/time/DurationUnit;)I", "multiplyBy10", "NANOS_IN_MILLIS", "MICROS_IN_MILLIS", "NANOS_IN_MICROS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "MILLIS_IN_SECOND", "MILLIS_IN_MINUTE", "MILLIS_IN_HOUR", "MILLIS_IN_DAY", "INFINITY_STRING", "FRACTION_LIMIT", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DurationKt {
    private static final int FRACTION_LIMIT = 15;
    private static final String INFINITY_STRING = "Infinity";
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final long MICROS_IN_MILLIS = 1000;
    public static final long MILLIS_IN_DAY = 86400000;
    public static final long MILLIS_IN_HOUR = 3600000;
    public static final long MILLIS_IN_MINUTE = 60000;
    public static final long MILLIS_IN_SECOND = 1000;
    public static final long NANOS_IN_MICROS = 1000;
    public static final int NANOS_IN_MILLIS = 1000000;

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DurationUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DurationUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DurationUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DurationUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static  void getFractionMultiplier$annotations(DurationUnit durationUnit) {
    }

    public static final long toDuration(int $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration($this$toDuration, unit);
    }

    public static final long toDuration(long $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long maxNsInUnit = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, unit);
        boolean z = false;
        if ((-maxNsInUnit) <= $this$toDuration && $this$toDuration <= maxNsInUnit) {
            z = true;
        }
        if (z) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS));
        }
        if (unit.compareTo(DurationUnit.MILLISECONDS) >= 0) {
            return durationOfMillis(((long) MathKt.getSign($this$toDuration)) * DurationUnitKt.convertDurationUnitToMilliseconds(Math.abs(RangesKt.coerceAtLeast($this$toDuration, -9223372036854775807L)), unit));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }

    public static final long toDuration(double $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double valueInNs = DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(valueInNs)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long nanos = MathKt.roundToLong(valueInNs);
        boolean z = false;
        if (-4611686018426999999L <= nanos && nanos < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            long millis = durationOfNanos(nanos);
            return millis;
        }
        long millis2 = MathKt.roundToLong(DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS));
        return durationOfMillisNormalized(millis2);
    }

    private static final long m1487timesmvk6XK0(int $this$times_u2dmvk6XK0, long duration) {
        return Duration.m1416timesUwyO8pc(duration, $this$times_u2dmvk6XK0);
    }

    private static final long m1486timeskIfJnKk(double $this$times_u2dkIfJnKk, long duration) {
        return Duration.m1415timesUwyO8pc(duration, $this$times_u2dkIfJnKk);
    }

    static  long parseDuration$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return parseDuration(str, z, z2);
    }

    public static final long parseDuration(String value, boolean strictIso, boolean throwException) {
        int index;
        long result;
        if (value.length() == 0) {
            if (throwException) {
                throw new IllegalArgumentException("The string is empty");
            }
            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
        }
        char firstChar = value.charAt(0);
        boolean isNegative = false;
        switch (firstChar) {
            case '+':
                int index2 = 0 + 1;
                index = index2;
                break;
            case ',':
            default:
                index = 0;
                break;
            case '-':
                isNegative = true;
                int index3 = 0 + 1;
                index = index3;
                break;
        }
        boolean hasSign = index > 0;
        if (value.length() <= index) {
            if (throwException) {
                throw new IllegalArgumentException("No components");
            }
            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
        }
        if (value.charAt(index) == 'P') {
            result = parseIsoStringFormat(value, index + 1, throwException);
        } else {
            if (strictIso) {
                if (throwException) {
                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                }
                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
            }
            if (StringsKt.regionMatches(value, index, INFINITY_STRING, 0, Math.max(value.length() - index, 8), true)) {
                result = Duration.Companion.m1477getINFINITEUwyO8pc();
            } else {
                result = parseDefaultStringFormat(value, index, hasSign, throwException);
            }
        }
        return (!isNegative || Duration.m1390equalsimpl0(result, Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib())) ? result : Duration.m1429unaryMinusUwyO8pc(result);
    }

    private static final long parseIsoStringFormat(String value, int startIndex, boolean throwException) {
        int index;
        int index$iv;
        int startIndex$iv$iv;
        String $this$skipWhile$iv$iv;
        boolean isTimeComponent;
        char ch;
        int i$iv$iv;
        long result$iv;
        int index$iv2;
        long result$iv2;
        int localSign;
        int index2;
        int longEndIndex;
        int i;
        int sign;
        long longValue;
        DurationUnit unit;
        String str;
        long it;
        int index3;
        String value$iv;
        int $i$f$parse;
        String value$iv2;
        int endIndex$iv$iv;
        int result$iv$iv;
        int index$iv$iv;
        String $this$parseDigits$iv$iv;
        int endIndex$iv$iv2;
        int i2;
        String $this$parseDigits$iv$iv2;
        int endIndex$iv$iv3;
        int result$iv$iv2;
        int index$iv$iv2;
        int index$iv$iv3;
        int i3;
        int i4;
        int startIndex$iv$iv2;
        String $this$skipWhile$iv$iv2;
        int index$iv3;
        int $i$f$parse2;
        int $i$f$parse3;
        int i$iv$iv2;
        int fractionEndIndex;
        String $this$skipWhile$iv$iv3;
        int startIndex$iv$iv3;
        char it$iv;
        int endIndex$iv$iv4;
        char ch$iv$iv;
        boolean z;
        int endIndex$iv$iv5;
        String $this$parseDigits$iv$iv3;
        char ch$iv$iv2;
        boolean z2;
        char ch$iv;
        boolean z3;
        int digit$iv;
        int index$iv4;
        int longStartIndex;
        int i$iv$iv3;
        int digit$iv2;
        int i$iv$iv4;
        int localSign2;
        int longEndIndex2;
        int i5;
        char it$iv2;
        boolean z4;
        String $this$skipWhile$iv$iv4;
        boolean z5;
        int index4 = startIndex;
        if (index4 == value.length()) {
            if (throwException) {
                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
            }
            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
        }
        long totalMillis = 0;
        long totalNanos = 0;
        boolean isTimeComponent2 = false;
        DurationUnit prevUnit = null;
        while (index4 < value.length()) {
            char ch2 = value.charAt(index4);
            if (ch2 != 'T') {
                int longStartIndex2 = index4;
                LongParser this_$iv = LongParser.Companion.getIso();
                int startIndex$iv = index4;
                int sign$iv = 1;
                if (this_$iv.allowSign) {
                    index = startIndex$iv;
                    char firstChar$iv = value.charAt(index);
                    switch (firstChar$iv) {
                        case '+':
                            int index$iv5 = index + 1;
                            index$iv = index$iv5;
                            break;
                        case '-':
                            sign$iv = -1;
                            int index$iv6 = index + 1;
                            index$iv = index$iv6;
                            break;
                    }
                    startIndex$iv$iv = index$iv;
                    $this$skipWhile$iv$iv = value;
                    while (true) {
                        isTimeComponent = isTimeComponent2;
                        ch = ch2;
                        if (startIndex$iv$iv < $this$skipWhile$iv$iv.length()) {
                            $this$skipWhile$iv$iv4 = $this$skipWhile$iv$iv;
                            i$iv$iv = startIndex$iv$iv;
                            if ($this$skipWhile$iv$iv4.charAt(startIndex$iv$iv) == '0') {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                startIndex$iv$iv = i$iv$iv + 1;
                                $this$skipWhile$iv$iv = $this$skipWhile$iv$iv4;
                                isTimeComponent2 = isTimeComponent;
                                ch2 = ch;
                            }
                        } else {
                            i$iv$iv = startIndex$iv$iv;
                        }
                    }
                    result$iv = 0;
                    index$iv2 = i$iv$iv;
                    while (true) {
                        result$iv2 = result$iv;
                        if (index$iv2 >= value.length()) {
                            ch$iv = value.charAt(index$iv2);
                            if ('0' <= ch$iv || ch$iv >= ':') {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (z3) {
                                digit$iv = ch$iv - '0';
                                if (result$iv2 <= this_$iv.overflowThreshold) {
                                    if (result$iv2 == this_$iv.overflowThreshold) {
                                        index$iv4 = index$iv2;
                                        longStartIndex = longStartIndex2;
                                        if (digit$iv > this_$iv.lastDigitMax) {
                                        }
                                    } else {
                                        index$iv4 = index$iv2;
                                        longStartIndex = longStartIndex2;
                                    }
                                    index$iv2 = index$iv4 + 1;
                                    result$iv = (result$iv2 << 3) + (result$iv2 << 1) + ((long) digit$iv);
                                    longStartIndex2 = longStartIndex;
                                } else {
                                    index$iv4 = index$iv2;
                                    longStartIndex = longStartIndex2;
                                }
                                i$iv$iv3 = index$iv4;
                                while (true) {
                                    digit$iv2 = digit$iv;
                                    if (i$iv$iv3 < value.length()) {
                                        it$iv2 = value.charAt(i$iv$iv3);
                                        i$iv$iv4 = i$iv$iv3;
                                        if ('0' <= it$iv2 || it$iv2 >= ':') {
                                            z4 = false;
                                        } else {
                                            z4 = true;
                                        }
                                        if (z4) {
                                            i$iv$iv3 = i$iv$iv4 + 1;
                                            digit$iv = digit$iv2;
                                        }
                                    } else {
                                        i$iv$iv4 = i$iv$iv3;
                                    }
                                }
                                int longEndIndex3 = i$iv$iv4;
                                localSign2 = sign$iv;
                                index2 = longEndIndex3;
                                longEndIndex2 = value.length();
                                if (index2 != longEndIndex2) {
                                    switch (ch) {
                                        case '+':
                                        case '-':
                                            i5 = 1;
                                            break;
                                        case ',':
                                        default:
                                            i5 = 0;
                                            break;
                                    }
                                    if (index2 == longStartIndex + i5) {
                                        sign = localSign2;
                                        longValue = this_$iv.overflowLimit;
                                    }
                                }
                                if (throwException) {
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            if (value.charAt(index2) == '.') {
                                index3 = index2 + 1;
                                FractionalParser fractionalParser = FractionalParser.INSTANCE;
                                value$iv = value;
                                $i$f$parse = 0;
                                value$iv2 = value$iv;
                                endIndex$iv$iv = Math.min(index3 + 6, value$iv2.length());
                                result$iv$iv = 0;
                                index$iv$iv = index3;
                                while (true) {
                                    if (index$iv$iv < endIndex$iv$iv) {
                                        endIndex$iv$iv5 = endIndex$iv$iv;
                                        $this$parseDigits$iv$iv3 = value$iv2;
                                        $this$parseDigits$iv$iv = value$iv;
                                        ch$iv$iv2 = $this$parseDigits$iv$iv3.charAt(index$iv$iv);
                                        if ('0' <= ch$iv$iv2 || ch$iv$iv2 >= ':') {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1) + (ch$iv$iv2 - '0');
                                            index$iv$iv++;
                                            value$iv = $this$parseDigits$iv$iv;
                                            endIndex$iv$iv = endIndex$iv$iv5;
                                            value$iv2 = $this$parseDigits$iv$iv3;
                                        }
                                    } else {
                                        $this$parseDigits$iv$iv = value$iv;
                                    }
                                }
                                endIndex$iv$iv2 = index$iv$iv - index3;
                                for (i2 = 0; i2 < 6 - endIndex$iv$iv2; i2++) {
                                    result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                                }
                                int index$iv7 = index$iv$iv;
                                int index$iv$iv4 = result$iv$iv;
                                $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv;
                                int maxDigits$iv$iv = $this$parseDigits$iv$iv2.length();
                                endIndex$iv$iv3 = Math.min(index$iv7 + 9, maxDigits$iv$iv);
                                result$iv$iv2 = 0;
                                index$iv$iv2 = index$iv7;
                                while (true) {
                                    if (index$iv$iv2 < endIndex$iv$iv3) {
                                        endIndex$iv$iv4 = endIndex$iv$iv3;
                                        ch$iv$iv = $this$parseDigits$iv$iv2.charAt(index$iv$iv2);
                                        index$iv$iv3 = index$iv$iv2;
                                        if ('0' <= ch$iv$iv || ch$iv$iv >= ':') {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        if (z) {
                                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                            index$iv$iv2 = index$iv$iv3 + 1;
                                            endIndex$iv$iv3 = endIndex$iv$iv4;
                                        }
                                    } else {
                                        index$iv$iv3 = index$iv$iv2;
                                    }
                                }
                                i3 = 9 - (index$iv$iv3 - index$iv7);
                                for (i4 = 0; i4 < i3; i4++) {
                                    result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                }
                                int index$iv8 = index$iv$iv3;
                                int lowPrecisionDigits$iv = result$iv$iv2;
                                startIndex$iv$iv2 = index$iv8;
                                $this$skipWhile$iv$iv2 = $this$parseDigits$iv$iv;
                                index$iv3 = startIndex$iv$iv2;
                                while (true) {
                                    $i$f$parse2 = $i$f$parse;
                                    $i$f$parse3 = $this$skipWhile$iv$iv2.length();
                                    if (index$iv3 < $i$f$parse3) {
                                        $this$skipWhile$iv$iv3 = $this$skipWhile$iv$iv2;
                                        startIndex$iv$iv3 = startIndex$iv$iv2;
                                        it$iv = $this$skipWhile$iv$iv3.charAt(index$iv3);
                                        i$iv$iv2 = index$iv3;
                                        if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : (char) 1) != 0) {
                                            index$iv3 = i$iv$iv2 + 1;
                                            startIndex$iv$iv2 = startIndex$iv$iv3;
                                            $this$skipWhile$iv$iv2 = $this$skipWhile$iv$iv3;
                                            $i$f$parse = $i$f$parse2;
                                        }
                                    } else {
                                        i$iv$iv2 = index$iv3;
                                    }
                                }
                                fractionEndIndex = i$iv$iv2;
                                if (fractionEndIndex == index3 && fractionEndIndex != value.length()) {
                                    if (value.charAt(fractionEndIndex) == 'S') {
                                        long fractionValue = (((long) index$iv$iv4) * ((long) 1000000000)) + ((long) lowPrecisionDigits$iv);
                                        totalNanos = ((long) sign) * fractionDigitsToNanos(fractionValue, DurationUnit.SECONDS);
                                        index2 = fractionEndIndex;
                                    }
                                }
                                if (throwException) {
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            unit = isoDurationUnitByShortNameOrNull(value, index2);
                            if (unit == null) {
                                str = "Unknown duration unit short name: " + value.charAt(index2);
                                if (throwException) {
                                    throw new IllegalArgumentException(str);
                                }
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            if (prevUnit == null && prevUnit.compareTo(unit) <= 0) {
                                if (throwException) {
                                    throw new IllegalArgumentException("Unexpected order of duration components");
                                }
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            prevUnit = unit;
                            if (unit == DurationUnit.DAYS) {
                                if (isTimeComponent) {
                                    if (throwException) {
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                it = ((long) sign) * DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit);
                            } else {
                                if (!isTimeComponent) {
                                    if (throwException) {
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                it = addMillisWithoutOverflow(totalMillis, ((long) sign) * DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit));
                                if (it == Duration.INVALID_RAW_VALUE) {
                                    if (throwException) {
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                            }
                            totalMillis = it;
                            index4 = index2 + 1;
                            isTimeComponent2 = isTimeComponent;
                        }
                        int longEndIndex4 = index$iv2;
                        localSign = sign$iv;
                        index2 = longEndIndex4;
                        longEndIndex = value.length();
                        if (index2 != longEndIndex) {
                            switch (ch) {
                                case '+':
                                case '-':
                                    i = 1;
                                    break;
                                case ',':
                                default:
                                    i = 0;
                                    break;
                            }
                            if (index2 == longStartIndex2 + i) {
                                sign = localSign;
                                longValue = result$iv2;
                                if (value.charAt(index2) == '.') {
                                    index3 = index2 + 1;
                                    FractionalParser fractionalParser2 = FractionalParser.INSTANCE;
                                    value$iv = value;
                                    $i$f$parse = 0;
                                    value$iv2 = value$iv;
                                    endIndex$iv$iv = Math.min(index3 + 6, value$iv2.length());
                                    result$iv$iv = 0;
                                    index$iv$iv = index3;
                                    while (true) {
                                        if (index$iv$iv < endIndex$iv$iv) {
                                            endIndex$iv$iv5 = endIndex$iv$iv;
                                            $this$parseDigits$iv$iv3 = value$iv2;
                                            $this$parseDigits$iv$iv = value$iv;
                                            ch$iv$iv2 = $this$parseDigits$iv$iv3.charAt(index$iv$iv);
                                            if ('0' <= ch$iv$iv2) {
                                                z2 = false;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1) + (ch$iv$iv2 - '0');
                                                index$iv$iv++;
                                                value$iv = $this$parseDigits$iv$iv;
                                                endIndex$iv$iv = endIndex$iv$iv5;
                                                value$iv2 = $this$parseDigits$iv$iv3;
                                            }
                                        } else {
                                            $this$parseDigits$iv$iv = value$iv;
                                        }
                                    }
                                    endIndex$iv$iv2 = index$iv$iv - index3;
                                    while (i2 < 6 - endIndex$iv$iv2) {
                                        result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                                    }
                                    int index$iv9 = index$iv$iv;
                                    int index$iv$iv5 = result$iv$iv;
                                    $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv;
                                    int maxDigits$iv$iv2 = $this$parseDigits$iv$iv2.length();
                                    endIndex$iv$iv3 = Math.min(index$iv9 + 9, maxDigits$iv$iv2);
                                    result$iv$iv2 = 0;
                                    index$iv$iv2 = index$iv9;
                                    while (true) {
                                        if (index$iv$iv2 < endIndex$iv$iv3) {
                                            endIndex$iv$iv4 = endIndex$iv$iv3;
                                            ch$iv$iv = $this$parseDigits$iv$iv2.charAt(index$iv$iv2);
                                            index$iv$iv3 = index$iv$iv2;
                                            if ('0' <= ch$iv$iv) {
                                                z = false;
                                            } else {
                                                z = false;
                                            }
                                            if (z) {
                                                result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                                index$iv$iv2 = index$iv$iv3 + 1;
                                                endIndex$iv$iv3 = endIndex$iv$iv4;
                                            }
                                        } else {
                                            index$iv$iv3 = index$iv$iv2;
                                        }
                                    }
                                    i3 = 9 - (index$iv$iv3 - index$iv9);
                                    while (i4 < i3) {
                                        result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                    }
                                    int index$iv10 = index$iv$iv3;
                                    int lowPrecisionDigits$iv2 = result$iv$iv2;
                                    startIndex$iv$iv2 = index$iv10;
                                    $this$skipWhile$iv$iv2 = $this$parseDigits$iv$iv;
                                    index$iv3 = startIndex$iv$iv2;
                                    while (true) {
                                        $i$f$parse2 = $i$f$parse;
                                        $i$f$parse3 = $this$skipWhile$iv$iv2.length();
                                        if (index$iv3 < $i$f$parse3) {
                                            $this$skipWhile$iv$iv3 = $this$skipWhile$iv$iv2;
                                            startIndex$iv$iv3 = startIndex$iv$iv2;
                                            it$iv = $this$skipWhile$iv$iv3.charAt(index$iv3);
                                            i$iv$iv2 = index$iv3;
                                            if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : (char) 1) != 0) {
                                                index$iv3 = i$iv$iv2 + 1;
                                                startIndex$iv$iv2 = startIndex$iv$iv3;
                                                $this$skipWhile$iv$iv2 = $this$skipWhile$iv$iv3;
                                                $i$f$parse = $i$f$parse2;
                                            }
                                        } else {
                                            i$iv$iv2 = index$iv3;
                                        }
                                    }
                                    fractionEndIndex = i$iv$iv2;
                                    if (fractionEndIndex == index3) {
                                    }
                                    if (throwException) {
                                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                                unit = isoDurationUnitByShortNameOrNull(value, index2);
                                if (unit == null) {
                                    str = "Unknown duration unit short name: " + value.charAt(index2);
                                    if (throwException) {
                                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    throw new IllegalArgumentException(str);
                                }
                                if (prevUnit == null) {
                                }
                                prevUnit = unit;
                                if (unit == DurationUnit.DAYS) {
                                    if (isTimeComponent) {
                                        if (throwException) {
                                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                        }
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                    it = ((long) sign) * DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit);
                                } else {
                                    if (!isTimeComponent) {
                                        if (throwException) {
                                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                        }
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                    it = addMillisWithoutOverflow(totalMillis, ((long) sign) * DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit));
                                    if (it == Duration.INVALID_RAW_VALUE) {
                                        if (throwException) {
                                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                        }
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                }
                                totalMillis = it;
                                index4 = index2 + 1;
                                isTimeComponent2 = isTimeComponent;
                            }
                        }
                        if (throwException) {
                            throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                        }
                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                    }
                }
                index = startIndex$iv;
                index$iv = index;
                startIndex$iv$iv = index$iv;
                $this$skipWhile$iv$iv = value;
                while (true) {
                    isTimeComponent = isTimeComponent2;
                    ch = ch2;
                    if (startIndex$iv$iv < $this$skipWhile$iv$iv.length()) {
                        $this$skipWhile$iv$iv4 = $this$skipWhile$iv$iv;
                        i$iv$iv = startIndex$iv$iv;
                        if ($this$skipWhile$iv$iv4.charAt(startIndex$iv$iv) == '0') {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            startIndex$iv$iv = i$iv$iv + 1;
                            $this$skipWhile$iv$iv = $this$skipWhile$iv$iv4;
                            isTimeComponent2 = isTimeComponent;
                            ch2 = ch;
                        }
                    } else {
                        i$iv$iv = startIndex$iv$iv;
                    }
                }
                result$iv = 0;
                index$iv2 = i$iv$iv;
                while (true) {
                    result$iv2 = result$iv;
                    if (index$iv2 >= value.length()) {
                        ch$iv = value.charAt(index$iv2);
                        if ('0' <= ch$iv) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            digit$iv = ch$iv - '0';
                            if (result$iv2 <= this_$iv.overflowThreshold) {
                                if (result$iv2 == this_$iv.overflowThreshold) {
                                    index$iv4 = index$iv2;
                                    longStartIndex = longStartIndex2;
                                    if (digit$iv > this_$iv.lastDigitMax) {
                                    }
                                } else {
                                    index$iv4 = index$iv2;
                                    longStartIndex = longStartIndex2;
                                }
                                index$iv2 = index$iv4 + 1;
                                result$iv = (result$iv2 << 3) + (result$iv2 << 1) + ((long) digit$iv);
                                longStartIndex2 = longStartIndex;
                            } else {
                                index$iv4 = index$iv2;
                                longStartIndex = longStartIndex2;
                            }
                            i$iv$iv3 = index$iv4;
                            while (true) {
                                digit$iv2 = digit$iv;
                                if (i$iv$iv3 < value.length()) {
                                    it$iv2 = value.charAt(i$iv$iv3);
                                    i$iv$iv4 = i$iv$iv3;
                                    if ('0' <= it$iv2) {
                                        z4 = false;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        i$iv$iv3 = i$iv$iv4 + 1;
                                        digit$iv = digit$iv2;
                                    }
                                } else {
                                    i$iv$iv4 = i$iv$iv3;
                                }
                            }
                            int longEndIndex5 = i$iv$iv4;
                            localSign2 = sign$iv;
                            index2 = longEndIndex5;
                            longEndIndex2 = value.length();
                            if (index2 != longEndIndex2) {
                                switch (ch) {
                                    case '+':
                                    case '-':
                                        i5 = 1;
                                        break;
                                    case ',':
                                    default:
                                        i5 = 0;
                                        break;
                                }
                                if (index2 == longStartIndex + i5) {
                                    sign = localSign2;
                                    longValue = this_$iv.overflowLimit;
                                }
                            }
                            if (throwException) {
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                        }
                        if (value.charAt(index2) == '.') {
                            index3 = index2 + 1;
                            FractionalParser fractionalParser3 = FractionalParser.INSTANCE;
                            value$iv = value;
                            $i$f$parse = 0;
                            value$iv2 = value$iv;
                            endIndex$iv$iv = Math.min(index3 + 6, value$iv2.length());
                            result$iv$iv = 0;
                            index$iv$iv = index3;
                            while (true) {
                                if (index$iv$iv < endIndex$iv$iv) {
                                    endIndex$iv$iv5 = endIndex$iv$iv;
                                    $this$parseDigits$iv$iv3 = value$iv2;
                                    $this$parseDigits$iv$iv = value$iv;
                                    ch$iv$iv2 = $this$parseDigits$iv$iv3.charAt(index$iv$iv);
                                    if ('0' <= ch$iv$iv2) {
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1) + (ch$iv$iv2 - '0');
                                        index$iv$iv++;
                                        value$iv = $this$parseDigits$iv$iv;
                                        endIndex$iv$iv = endIndex$iv$iv5;
                                        value$iv2 = $this$parseDigits$iv$iv3;
                                    }
                                } else {
                                    $this$parseDigits$iv$iv = value$iv;
                                }
                            }
                            endIndex$iv$iv2 = index$iv$iv - index3;
                            while (i2 < 6 - endIndex$iv$iv2) {
                                result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                            }
                            int index$iv11 = index$iv$iv;
                            int index$iv$iv6 = result$iv$iv;
                            $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv;
                            int maxDigits$iv$iv3 = $this$parseDigits$iv$iv2.length();
                            endIndex$iv$iv3 = Math.min(index$iv11 + 9, maxDigits$iv$iv3);
                            result$iv$iv2 = 0;
                            index$iv$iv2 = index$iv11;
                            while (true) {
                                if (index$iv$iv2 < endIndex$iv$iv3) {
                                    endIndex$iv$iv4 = endIndex$iv$iv3;
                                    ch$iv$iv = $this$parseDigits$iv$iv2.charAt(index$iv$iv2);
                                    index$iv$iv3 = index$iv$iv2;
                                    if ('0' <= ch$iv$iv) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                        index$iv$iv2 = index$iv$iv3 + 1;
                                        endIndex$iv$iv3 = endIndex$iv$iv4;
                                    }
                                } else {
                                    index$iv$iv3 = index$iv$iv2;
                                }
                            }
                            i3 = 9 - (index$iv$iv3 - index$iv11);
                            while (i4 < i3) {
                                result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                            }
                            int index$iv12 = index$iv$iv3;
                            int lowPrecisionDigits$iv3 = result$iv$iv2;
                            startIndex$iv$iv2 = index$iv12;
                            $this$skipWhile$iv$iv2 = $this$parseDigits$iv$iv;
                            index$iv3 = startIndex$iv$iv2;
                            while (true) {
                                $i$f$parse2 = $i$f$parse;
                                $i$f$parse3 = $this$skipWhile$iv$iv2.length();
                                if (index$iv3 < $i$f$parse3) {
                                    $this$skipWhile$iv$iv3 = $this$skipWhile$iv$iv2;
                                    startIndex$iv$iv3 = startIndex$iv$iv2;
                                    it$iv = $this$skipWhile$iv$iv3.charAt(index$iv3);
                                    i$iv$iv2 = index$iv3;
                                    if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : (char) 1) != 0) {
                                        index$iv3 = i$iv$iv2 + 1;
                                        startIndex$iv$iv2 = startIndex$iv$iv3;
                                        $this$skipWhile$iv$iv2 = $this$skipWhile$iv$iv3;
                                        $i$f$parse = $i$f$parse2;
                                    }
                                } else {
                                    i$iv$iv2 = index$iv3;
                                }
                            }
                            fractionEndIndex = i$iv$iv2;
                            if (fractionEndIndex == index3) {
                            }
                            if (throwException) {
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                        }
                        unit = isoDurationUnitByShortNameOrNull(value, index2);
                        if (unit == null) {
                            str = "Unknown duration unit short name: " + value.charAt(index2);
                            if (throwException) {
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            throw new IllegalArgumentException(str);
                        }
                        if (prevUnit == null) {
                        }
                        prevUnit = unit;
                        if (unit == DurationUnit.DAYS) {
                            if (isTimeComponent) {
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                            }
                            it = ((long) sign) * DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit);
                        } else {
                            if (!isTimeComponent) {
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                            }
                            it = addMillisWithoutOverflow(totalMillis, ((long) sign) * DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit));
                            if (it == Duration.INVALID_RAW_VALUE) {
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                            }
                        }
                        totalMillis = it;
                        index4 = index2 + 1;
                        isTimeComponent2 = isTimeComponent;
                    }
                    int longEndIndex6 = index$iv2;
                    localSign = sign$iv;
                    index2 = longEndIndex6;
                    longEndIndex = value.length();
                    if (index2 != longEndIndex) {
                        switch (ch) {
                            case '+':
                            case '-':
                                i = 1;
                                break;
                            case ',':
                            default:
                                i = 0;
                                break;
                        }
                        if (index2 == longStartIndex2 + i) {
                            sign = localSign;
                            longValue = result$iv2;
                            if (value.charAt(index2) == '.') {
                                index3 = index2 + 1;
                                FractionalParser fractionalParser4 = FractionalParser.INSTANCE;
                                value$iv = value;
                                $i$f$parse = 0;
                                value$iv2 = value$iv;
                                endIndex$iv$iv = Math.min(index3 + 6, value$iv2.length());
                                result$iv$iv = 0;
                                index$iv$iv = index3;
                                while (true) {
                                    if (index$iv$iv < endIndex$iv$iv) {
                                        endIndex$iv$iv5 = endIndex$iv$iv;
                                        $this$parseDigits$iv$iv3 = value$iv2;
                                        $this$parseDigits$iv$iv = value$iv;
                                        ch$iv$iv2 = $this$parseDigits$iv$iv3.charAt(index$iv$iv);
                                        if ('0' <= ch$iv$iv2) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1) + (ch$iv$iv2 - '0');
                                            index$iv$iv++;
                                            value$iv = $this$parseDigits$iv$iv;
                                            endIndex$iv$iv = endIndex$iv$iv5;
                                            value$iv2 = $this$parseDigits$iv$iv3;
                                        }
                                    } else {
                                        $this$parseDigits$iv$iv = value$iv;
                                    }
                                }
                                endIndex$iv$iv2 = index$iv$iv - index3;
                                while (i2 < 6 - endIndex$iv$iv2) {
                                    result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                                }
                                int index$iv13 = index$iv$iv;
                                int index$iv$iv7 = result$iv$iv;
                                $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv;
                                int maxDigits$iv$iv4 = $this$parseDigits$iv$iv2.length();
                                endIndex$iv$iv3 = Math.min(index$iv13 + 9, maxDigits$iv$iv4);
                                result$iv$iv2 = 0;
                                index$iv$iv2 = index$iv13;
                                while (true) {
                                    if (index$iv$iv2 < endIndex$iv$iv3) {
                                        endIndex$iv$iv4 = endIndex$iv$iv3;
                                        ch$iv$iv = $this$parseDigits$iv$iv2.charAt(index$iv$iv2);
                                        index$iv$iv3 = index$iv$iv2;
                                        if ('0' <= ch$iv$iv) {
                                            z = false;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                            index$iv$iv2 = index$iv$iv3 + 1;
                                            endIndex$iv$iv3 = endIndex$iv$iv4;
                                        }
                                    } else {
                                        index$iv$iv3 = index$iv$iv2;
                                    }
                                }
                                i3 = 9 - (index$iv$iv3 - index$iv13);
                                while (i4 < i3) {
                                    result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                }
                                int index$iv14 = index$iv$iv3;
                                int lowPrecisionDigits$iv4 = result$iv$iv2;
                                startIndex$iv$iv2 = index$iv14;
                                $this$skipWhile$iv$iv2 = $this$parseDigits$iv$iv;
                                index$iv3 = startIndex$iv$iv2;
                                while (true) {
                                    $i$f$parse2 = $i$f$parse;
                                    $i$f$parse3 = $this$skipWhile$iv$iv2.length();
                                    if (index$iv3 < $i$f$parse3) {
                                        $this$skipWhile$iv$iv3 = $this$skipWhile$iv$iv2;
                                        startIndex$iv$iv3 = startIndex$iv$iv2;
                                        it$iv = $this$skipWhile$iv$iv3.charAt(index$iv3);
                                        i$iv$iv2 = index$iv3;
                                        if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : (char) 1) != 0) {
                                            index$iv3 = i$iv$iv2 + 1;
                                            startIndex$iv$iv2 = startIndex$iv$iv3;
                                            $this$skipWhile$iv$iv2 = $this$skipWhile$iv$iv3;
                                            $i$f$parse = $i$f$parse2;
                                        }
                                    } else {
                                        i$iv$iv2 = index$iv3;
                                    }
                                }
                                fractionEndIndex = i$iv$iv2;
                                if (fractionEndIndex == index3) {
                                }
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                            }
                            unit = isoDurationUnitByShortNameOrNull(value, index2);
                            if (unit == null) {
                                str = "Unknown duration unit short name: " + value.charAt(index2);
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(str);
                            }
                            if (prevUnit == null) {
                            }
                            prevUnit = unit;
                            if (unit == DurationUnit.DAYS) {
                                if (isTimeComponent) {
                                    if (throwException) {
                                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                                it = ((long) sign) * DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit);
                            } else {
                                if (!isTimeComponent) {
                                    if (throwException) {
                                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                                it = addMillisWithoutOverflow(totalMillis, ((long) sign) * DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit));
                                if (it == Duration.INVALID_RAW_VALUE) {
                                    if (throwException) {
                                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                            }
                            totalMillis = it;
                            index4 = index2 + 1;
                            isTimeComponent2 = isTimeComponent;
                        }
                    }
                    if (throwException) {
                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                    }
                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                }
            }
            if (isTimeComponent2 || (index4 = index4 + 1) == value.length()) {
                if (throwException) {
                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                }
                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
            }
            isTimeComponent2 = true;
        }
        return Duration.m1414plusLRDsOJo(toDuration(totalMillis, DurationUnit.MILLISECONDS), toDuration(totalNanos, DurationUnit.NANOSECONDS));
    }

    private static final long parseDefaultStringFormat(String value, int startIndex, boolean hasSign, boolean throwException) {
        char c;
        int index;
        int index$iv;
        int startIndex$iv$iv;
        String $this$skipWhile$iv$iv;
        int i$iv$iv;
        long result$iv;
        int index$iv2;
        LongParser this_$iv;
        int longEndIndex;
        int index2;
        long longValue;
        char c2;
        long fractionValue;
        int highPrecisionDigits$iv;
        long fractionValue2;
        DurationUnit unit;
        String str;
        long jFractionDigitsToNanos;
        int index3;
        String $this$parseDigits$iv$iv;
        int endIndex$iv$iv;
        int result$iv$iv;
        int index$iv$iv;
        int endIndex$iv$iv2;
        int i;
        int index$iv3;
        String $this$parseDigits$iv$iv2;
        int endIndex$iv$iv3;
        int result$iv$iv2;
        int index$iv$iv2;
        int i2;
        int index$iv4;
        int index$iv5;
        int index$iv6;
        int i$iv$iv2;
        int fractionEndIndex;
        char it$iv;
        int endIndex$iv$iv4;
        long fractionValue3;
        String $this$parseDigits$iv$iv3;
        char ch$iv$iv;
        char c3;
        int endIndex$iv$iv5;
        String $this$parseDigits$iv$iv4;
        int longStartIndex;
        char ch$iv$iv2;
        char c4;
        char ch$iv;
        char c5;
        int digit$iv;
        String value$iv;
        String $this$skipWhile$iv$iv2;
        int index$iv7;
        char ch$iv2;
        int i$iv$iv3;
        int longEndIndex2;
        char it$iv2;
        char c6;
        String $this$skipWhile$iv$iv3;
        char c7;
        int index4 = startIndex;
        int length = value.length();
        boolean allowSpaces = !hasSign;
        if (hasSign && value.charAt(index4) == '(' && value.charAt(length - 1) == ')') {
            allowSpaces = true;
            index4++;
            length--;
            if (index4 == length) {
                if (throwException) {
                    throw new IllegalArgumentException("No components");
                }
                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
            }
        }
        long totalMillis = 0;
        long totalNanos = 0;
        DurationUnit prevUnit = null;
        boolean isFirstComponent = true;
        while (index4 < length) {
            if (isFirstComponent || !allowSpaces) {
                c = 1;
            } else {
                int i$iv = index4;
                while (true) {
                    if (i$iv < value.length()) {
                        char it = value.charAt(i$iv);
                        c = 1;
                        char it2 = it == ' ' ? (char) 1 : (char) 0;
                        if (it2 != 0) {
                            i$iv++;
                        }
                    } else {
                        c = 1;
                    }
                }
                index4 = i$iv;
            }
            boolean isFirstComponent2 = false;
            int longStartIndex2 = index4;
            LongParser this_$iv2 = LongParser.Companion.getDefault();
            int startIndex$iv = index4;
            String value$iv2 = value;
            if (this_$iv2.allowSign) {
                index = startIndex$iv;
                char firstChar$iv = value$iv2.charAt(index);
                switch (firstChar$iv) {
                    case '+':
                        int index$iv8 = index + 1;
                        index$iv = index$iv8;
                        break;
                    case '-':
                        int index$iv9 = index + 1;
                        index$iv = index$iv9;
                        break;
                }
                startIndex$iv$iv = index$iv;
                $this$skipWhile$iv$iv = value$iv2;
                while (true) {
                    allowSpaces = allowSpaces;
                    isFirstComponent = isFirstComponent2;
                    if (startIndex$iv$iv < $this$skipWhile$iv$iv.length()) {
                        $this$skipWhile$iv$iv3 = $this$skipWhile$iv$iv;
                        i$iv$iv = startIndex$iv$iv;
                        if ($this$skipWhile$iv$iv3.charAt(startIndex$iv$iv) == '0') {
                            c7 = c;
                        } else {
                            c7 = 0;
                        }
                        if (c7 != 0) {
                            startIndex$iv$iv = i$iv$iv + 1;
                            $this$skipWhile$iv$iv = $this$skipWhile$iv$iv3;
                            allowSpaces = allowSpaces;
                            isFirstComponent2 = isFirstComponent;
                        }
                    } else {
                        i$iv$iv = startIndex$iv$iv;
                    }
                }
                result$iv = 0;
                index$iv2 = i$iv$iv;
                while (true) {
                    this_$iv = this_$iv2;
                    if (index$iv2 >= value$iv2.length()) {
                        ch$iv = value$iv2.charAt(index$iv2);
                        if ('0' <= ch$iv || ch$iv >= ':') {
                            c5 = 0;
                        } else {
                            c5 = c;
                        }
                        if (c5 != 0) {
                            digit$iv = ch$iv - '0';
                            if (result$iv <= this_$iv.overflowThreshold) {
                                if (result$iv == this_$iv.overflowThreshold) {
                                    value$iv = value$iv2;
                                    if (digit$iv > this_$iv.lastDigitMax) {
                                    }
                                } else {
                                    value$iv = value$iv2;
                                }
                                result$iv = (result$iv << 3) + (result$iv << c) + ((long) digit$iv);
                                index$iv2++;
                                this_$iv2 = this_$iv;
                                value$iv2 = value$iv;
                                startIndex$iv = startIndex$iv;
                            } else {
                                value$iv = value$iv2;
                            }
                            $this$skipWhile$iv$iv2 = value$iv;
                            index$iv7 = index$iv2;
                            while (true) {
                                ch$iv2 = ch$iv;
                                if (index$iv7 < $this$skipWhile$iv$iv2.length()) {
                                    it$iv2 = $this$skipWhile$iv$iv2.charAt(index$iv7);
                                    i$iv$iv3 = index$iv7;
                                    if ('0' <= it$iv2 || it$iv2 >= ':') {
                                        c6 = 0;
                                    } else {
                                        c6 = c;
                                    }
                                    if (c6 != 0) {
                                        index$iv7 = i$iv$iv3 + 1;
                                        ch$iv = ch$iv2;
                                    }
                                } else {
                                    i$iv$iv3 = index$iv7;
                                }
                            }
                            longEndIndex2 = i$iv$iv3;
                            if (longEndIndex2 != longStartIndex2 || longEndIndex2 == length || 1 != 0) {
                                if (throwException) {
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            index2 = longEndIndex2;
                            result$iv = this_$iv.overflowLimit;
                        }
                        longValue = result$iv;
                        if (value.charAt(index2) == '.') {
                            c2 = c;
                        } else {
                            c2 = 0;
                        }
                        fractionValue = 0;
                        if (c2 != 0) {
                            int fractionStartIndex = index2;
                            index3 = index2 + 1;
                            FractionalParser fractionalParser = FractionalParser.INSTANCE;
                            $this$parseDigits$iv$iv = value;
                            int fractionStartIndex2 = $this$parseDigits$iv$iv.length();
                            endIndex$iv$iv = Math.min(index3 + 6, fractionStartIndex2);
                            result$iv$iv = 0;
                            index$iv$iv = index3;
                            while (index$iv$iv < endIndex$iv$iv) {
                                endIndex$iv$iv5 = endIndex$iv$iv;
                                $this$parseDigits$iv$iv4 = $this$parseDigits$iv$iv;
                                longStartIndex = longStartIndex2;
                                ch$iv$iv2 = $this$parseDigits$iv$iv4.charAt(index$iv$iv);
                                if ('0' <= ch$iv$iv2 || ch$iv$iv2 >= ':') {
                                    c4 = 0;
                                } else {
                                    c4 = c;
                                }
                                if (c4 == 0) {
                                    endIndex$iv$iv2 = index$iv$iv - index3;
                                    for (i = 0; i < 6 - endIndex$iv$iv2; i++) {
                                        result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                                    }
                                    index$iv3 = index$iv$iv;
                                    int index$iv$iv3 = result$iv$iv;
                                    $this$parseDigits$iv$iv2 = value;
                                    int maxDigits$iv$iv = $this$parseDigits$iv$iv2.length();
                                    endIndex$iv$iv3 = Math.min(index$iv3 + 9, maxDigits$iv$iv);
                                    result$iv$iv2 = 0;
                                    index$iv$iv2 = index$iv3;
                                    while (index$iv$iv2 < endIndex$iv$iv3) {
                                        endIndex$iv$iv4 = endIndex$iv$iv3;
                                        fractionValue3 = fractionValue;
                                        $this$parseDigits$iv$iv3 = $this$parseDigits$iv$iv2;
                                        ch$iv$iv = $this$parseDigits$iv$iv3.charAt(index$iv$iv2);
                                        if ('0' <= ch$iv$iv || ch$iv$iv >= ':') {
                                            c3 = 0;
                                        } else {
                                            c3 = c;
                                        }
                                        if (c3 == 0) {
                                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                            index$iv$iv2++;
                                            $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv3;
                                            endIndex$iv$iv3 = endIndex$iv$iv4;
                                            fractionValue = fractionValue3;
                                        } else {
                                            for (i2 = 0; i2 < 9 - (index$iv$iv2 - index$iv3); i2++) {
                                                result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                            }
                                            index$iv4 = index$iv$iv2;
                                            int lowPrecisionDigits$iv = result$iv$iv2;
                                            while (true) {
                                                index$iv5 = index$iv4;
                                                index$iv6 = value.length();
                                                if (index$iv$iv2 < index$iv6) {
                                                    it$iv = value.charAt(index$iv$iv2);
                                                    i$iv$iv2 = index$iv$iv2;
                                                    if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                                        index$iv$iv2 = i$iv$iv2 + 1;
                                                        index$iv4 = index$iv5;
                                                    }
                                                } else {
                                                    i$iv$iv2 = index$iv$iv2;
                                                }
                                            }
                                            fractionEndIndex = i$iv$iv2;
                                            if (fractionEndIndex != index3 || fractionEndIndex == length) {
                                                if (throwException) {
                                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                                }
                                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                            }
                                            index2 = fractionEndIndex;
                                            fractionValue2 = (((long) index$iv$iv3) * ((long) 1000000000)) + ((long) lowPrecisionDigits$iv);
                                            highPrecisionDigits$iv = fractionStartIndex;
                                        }
                                    }
                                    while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                        result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                    }
                                    index$iv4 = index$iv$iv2;
                                    int lowPrecisionDigits$iv2 = result$iv$iv2;
                                    while (true) {
                                        index$iv5 = index$iv4;
                                        index$iv6 = value.length();
                                        if (index$iv$iv2 < index$iv6) {
                                            it$iv = value.charAt(index$iv$iv2);
                                            i$iv$iv2 = index$iv$iv2;
                                            if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                                index$iv$iv2 = i$iv$iv2 + 1;
                                                index$iv4 = index$iv5;
                                            }
                                        } else {
                                            i$iv$iv2 = index$iv$iv2;
                                        }
                                    }
                                    fractionEndIndex = i$iv$iv2;
                                    if (fractionEndIndex != index3) {
                                    }
                                    if (throwException) {
                                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                                result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1) + (ch$iv$iv2 - '0');
                                index$iv$iv++;
                                longStartIndex2 = longStartIndex;
                                endIndex$iv$iv = endIndex$iv$iv5;
                                $this$parseDigits$iv$iv = $this$parseDigits$iv$iv4;
                            }
                            endIndex$iv$iv2 = index$iv$iv - index3;
                            while (i < 6 - endIndex$iv$iv2) {
                                result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                            }
                            index$iv3 = index$iv$iv;
                            int index$iv$iv4 = result$iv$iv;
                            $this$parseDigits$iv$iv2 = value;
                            int maxDigits$iv$iv2 = $this$parseDigits$iv$iv2.length();
                            endIndex$iv$iv3 = Math.min(index$iv3 + 9, maxDigits$iv$iv2);
                            result$iv$iv2 = 0;
                            index$iv$iv2 = index$iv3;
                            while (index$iv$iv2 < endIndex$iv$iv3) {
                                endIndex$iv$iv4 = endIndex$iv$iv3;
                                fractionValue3 = fractionValue;
                                $this$parseDigits$iv$iv3 = $this$parseDigits$iv$iv2;
                                ch$iv$iv = $this$parseDigits$iv$iv3.charAt(index$iv$iv2);
                                if ('0' <= ch$iv$iv) {
                                    c3 = 0;
                                } else {
                                    c3 = 0;
                                }
                                if (c3 == 0) {
                                    while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                        result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                    }
                                    index$iv4 = index$iv$iv2;
                                    int lowPrecisionDigits$iv3 = result$iv$iv2;
                                    while (true) {
                                        index$iv5 = index$iv4;
                                        index$iv6 = value.length();
                                        if (index$iv$iv2 < index$iv6) {
                                            it$iv = value.charAt(index$iv$iv2);
                                            i$iv$iv2 = index$iv$iv2;
                                            if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                                index$iv$iv2 = i$iv$iv2 + 1;
                                                index$iv4 = index$iv5;
                                            }
                                        } else {
                                            i$iv$iv2 = index$iv$iv2;
                                        }
                                    }
                                    fractionEndIndex = i$iv$iv2;
                                    if (fractionEndIndex != index3) {
                                    }
                                    if (throwException) {
                                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                }
                                result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                index$iv$iv2++;
                                $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv3;
                                endIndex$iv$iv3 = endIndex$iv$iv4;
                                fractionValue = fractionValue3;
                            }
                            while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                            }
                            index$iv4 = index$iv$iv2;
                            int lowPrecisionDigits$iv4 = result$iv$iv2;
                            while (true) {
                                index$iv5 = index$iv4;
                                index$iv6 = value.length();
                                if (index$iv$iv2 < index$iv6) {
                                    it$iv = value.charAt(index$iv$iv2);
                                    i$iv$iv2 = index$iv$iv2;
                                    if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                        index$iv$iv2 = i$iv$iv2 + 1;
                                        index$iv4 = index$iv5;
                                    }
                                } else {
                                    i$iv$iv2 = index$iv$iv2;
                                }
                            }
                            fractionEndIndex = i$iv$iv2;
                            if (fractionEndIndex != index3) {
                            }
                            if (throwException) {
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                        }
                        highPrecisionDigits$iv = -1;
                        fractionValue2 = 0;
                        unit = defaultDurationUnitByShortNameOrNull(value, index2);
                        if (unit == null) {
                            str = "Unknown duration unit short name: " + value.charAt(index2);
                            if (throwException) {
                                throw new IllegalArgumentException(str);
                            }
                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                        }
                        if (prevUnit == null && prevUnit.compareTo(unit) <= 0) {
                            if (throwException) {
                                throw new IllegalArgumentException("Unexpected order of duration components");
                            }
                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                        }
                        prevUnit = unit;
                        switch (WhenMappings.$EnumSwitchMapping$0[unit.ordinal()]) {
                            case 1:
                                totalMillis += longValue / 1000;
                                if (totalMillis <= MAX_NANOS_IN_MILLIS) {
                                    totalNanos = (longValue % 1000) * 1000;
                                }
                                break;
                            case 2:
                                long j = NANOS_IN_MILLIS;
                                totalMillis += longValue / j;
                                totalNanos += longValue % j;
                                break;
                            default:
                                totalMillis = addMillisWithoutOverflow(totalMillis, DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit));
                                break;
                        }
                        index4 = index2 + getShortNameLength(unit);
                        if (c2 != 0) {
                            if (index4 < length) {
                                if (throwException) {
                                    throw new IllegalArgumentException("Fractional component must be last");
                                }
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            if (unit.compareTo(DurationUnit.MINUTES) >= 0 || index4 - highPrecisionDigits$iv <= 15) {
                                jFractionDigitsToNanos = fractionDigitsToNanos(fractionValue2, unit);
                            } else {
                                jFractionDigitsToNanos = parseFractionFallback(value, highPrecisionDigits$iv, index4 - getShortNameLength(unit), unit);
                            }
                            totalNanos += jFractionDigitsToNanos;
                        }
                    }
                    longEndIndex = index$iv2;
                    if (longEndIndex == longStartIndex2 && longEndIndex != length) {
                        if (0 == 0) {
                            index2 = longEndIndex;
                            longValue = result$iv;
                            if (value.charAt(index2) == '.') {
                                c2 = c;
                            } else {
                                c2 = 0;
                            }
                            fractionValue = 0;
                            if (c2 != 0) {
                                int fractionStartIndex3 = index2;
                                index3 = index2 + 1;
                                FractionalParser fractionalParser2 = FractionalParser.INSTANCE;
                                $this$parseDigits$iv$iv = value;
                                int fractionStartIndex4 = $this$parseDigits$iv$iv.length();
                                endIndex$iv$iv = Math.min(index3 + 6, fractionStartIndex4);
                                result$iv$iv = 0;
                                index$iv$iv = index3;
                                while (index$iv$iv < endIndex$iv$iv) {
                                    endIndex$iv$iv5 = endIndex$iv$iv;
                                    $this$parseDigits$iv$iv4 = $this$parseDigits$iv$iv;
                                    longStartIndex = longStartIndex2;
                                    ch$iv$iv2 = $this$parseDigits$iv$iv4.charAt(index$iv$iv);
                                    if ('0' <= ch$iv$iv2) {
                                        c4 = 0;
                                    } else {
                                        c4 = 0;
                                    }
                                    if (c4 == 0) {
                                        endIndex$iv$iv2 = index$iv$iv - index3;
                                        while (i < 6 - endIndex$iv$iv2) {
                                            result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                                        }
                                        index$iv3 = index$iv$iv;
                                        int index$iv$iv5 = result$iv$iv;
                                        $this$parseDigits$iv$iv2 = value;
                                        int maxDigits$iv$iv3 = $this$parseDigits$iv$iv2.length();
                                        endIndex$iv$iv3 = Math.min(index$iv3 + 9, maxDigits$iv$iv3);
                                        result$iv$iv2 = 0;
                                        index$iv$iv2 = index$iv3;
                                        while (index$iv$iv2 < endIndex$iv$iv3) {
                                            endIndex$iv$iv4 = endIndex$iv$iv3;
                                            fractionValue3 = fractionValue;
                                            $this$parseDigits$iv$iv3 = $this$parseDigits$iv$iv2;
                                            ch$iv$iv = $this$parseDigits$iv$iv3.charAt(index$iv$iv2);
                                            if ('0' <= ch$iv$iv) {
                                                c3 = 0;
                                            } else {
                                                c3 = 0;
                                            }
                                            if (c3 == 0) {
                                                while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                                    result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                                }
                                                index$iv4 = index$iv$iv2;
                                                int lowPrecisionDigits$iv5 = result$iv$iv2;
                                                while (true) {
                                                    index$iv5 = index$iv4;
                                                    index$iv6 = value.length();
                                                    if (index$iv$iv2 < index$iv6) {
                                                        it$iv = value.charAt(index$iv$iv2);
                                                        i$iv$iv2 = index$iv$iv2;
                                                        if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                                            index$iv$iv2 = i$iv$iv2 + 1;
                                                            index$iv4 = index$iv5;
                                                        }
                                                    } else {
                                                        i$iv$iv2 = index$iv$iv2;
                                                    }
                                                }
                                                fractionEndIndex = i$iv$iv2;
                                                if (fractionEndIndex != index3) {
                                                }
                                                if (throwException) {
                                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                                }
                                                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                            }
                                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                            index$iv$iv2++;
                                            $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv3;
                                            endIndex$iv$iv3 = endIndex$iv$iv4;
                                            fractionValue = fractionValue3;
                                        }
                                        while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                        }
                                        index$iv4 = index$iv$iv2;
                                        int lowPrecisionDigits$iv6 = result$iv$iv2;
                                        while (true) {
                                            index$iv5 = index$iv4;
                                            index$iv6 = value.length();
                                            if (index$iv$iv2 < index$iv6) {
                                                it$iv = value.charAt(index$iv$iv2);
                                                i$iv$iv2 = index$iv$iv2;
                                                if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                                    index$iv$iv2 = i$iv$iv2 + 1;
                                                    index$iv4 = index$iv5;
                                                }
                                            } else {
                                                i$iv$iv2 = index$iv$iv2;
                                            }
                                        }
                                        fractionEndIndex = i$iv$iv2;
                                        if (fractionEndIndex != index3) {
                                        }
                                        if (throwException) {
                                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                        }
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                    result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1) + (ch$iv$iv2 - '0');
                                    index$iv$iv++;
                                    longStartIndex2 = longStartIndex;
                                    endIndex$iv$iv = endIndex$iv$iv5;
                                    $this$parseDigits$iv$iv = $this$parseDigits$iv$iv4;
                                }
                                endIndex$iv$iv2 = index$iv$iv - index3;
                                while (i < 6 - endIndex$iv$iv2) {
                                    result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                                }
                                index$iv3 = index$iv$iv;
                                int index$iv$iv6 = result$iv$iv;
                                $this$parseDigits$iv$iv2 = value;
                                int maxDigits$iv$iv4 = $this$parseDigits$iv$iv2.length();
                                endIndex$iv$iv3 = Math.min(index$iv3 + 9, maxDigits$iv$iv4);
                                result$iv$iv2 = 0;
                                index$iv$iv2 = index$iv3;
                                while (index$iv$iv2 < endIndex$iv$iv3) {
                                    endIndex$iv$iv4 = endIndex$iv$iv3;
                                    fractionValue3 = fractionValue;
                                    $this$parseDigits$iv$iv3 = $this$parseDigits$iv$iv2;
                                    ch$iv$iv = $this$parseDigits$iv$iv3.charAt(index$iv$iv2);
                                    if ('0' <= ch$iv$iv) {
                                        c3 = 0;
                                    } else {
                                        c3 = 0;
                                    }
                                    if (c3 == 0) {
                                        while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                        }
                                        index$iv4 = index$iv$iv2;
                                        int lowPrecisionDigits$iv7 = result$iv$iv2;
                                        while (true) {
                                            index$iv5 = index$iv4;
                                            index$iv6 = value.length();
                                            if (index$iv$iv2 < index$iv6) {
                                                it$iv = value.charAt(index$iv$iv2);
                                                i$iv$iv2 = index$iv$iv2;
                                                if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                                    index$iv$iv2 = i$iv$iv2 + 1;
                                                    index$iv4 = index$iv5;
                                                }
                                            } else {
                                                i$iv$iv2 = index$iv$iv2;
                                            }
                                        }
                                        fractionEndIndex = i$iv$iv2;
                                        if (fractionEndIndex != index3) {
                                        }
                                        if (throwException) {
                                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                        }
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                    result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                    index$iv$iv2++;
                                    $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv3;
                                    endIndex$iv$iv3 = endIndex$iv$iv4;
                                    fractionValue = fractionValue3;
                                }
                                while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                    result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                }
                                index$iv4 = index$iv$iv2;
                                int lowPrecisionDigits$iv8 = result$iv$iv2;
                                while (true) {
                                    index$iv5 = index$iv4;
                                    index$iv6 = value.length();
                                    if (index$iv$iv2 < index$iv6) {
                                        it$iv = value.charAt(index$iv$iv2);
                                        i$iv$iv2 = index$iv$iv2;
                                        if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                            index$iv$iv2 = i$iv$iv2 + 1;
                                            index$iv4 = index$iv5;
                                        }
                                    } else {
                                        i$iv$iv2 = index$iv$iv2;
                                    }
                                }
                                fractionEndIndex = i$iv$iv2;
                                if (fractionEndIndex != index3) {
                                }
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                            }
                            highPrecisionDigits$iv = -1;
                            fractionValue2 = 0;
                            unit = defaultDurationUnitByShortNameOrNull(value, index2);
                            if (unit == null) {
                                str = "Unknown duration unit short name: " + value.charAt(index2);
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(str);
                            }
                            if (prevUnit == null) {
                            }
                            prevUnit = unit;
                            switch (WhenMappings.$EnumSwitchMapping$0[unit.ordinal()]) {
                                case 1:
                                    totalMillis += longValue / 1000;
                                    if (totalMillis <= MAX_NANOS_IN_MILLIS) {
                                        totalNanos = (longValue % 1000) * 1000;
                                    }
                                    break;
                                case 2:
                                    long j2 = NANOS_IN_MILLIS;
                                    totalMillis += longValue / j2;
                                    totalNanos += longValue % j2;
                                    break;
                                default:
                                    totalMillis = addMillisWithoutOverflow(totalMillis, DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit));
                                    break;
                            }
                            index4 = index2 + getShortNameLength(unit);
                            if (c2 != 0) {
                                if (index4 < length) {
                                    if (throwException) {
                                        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    throw new IllegalArgumentException("Fractional component must be last");
                                }
                                if (unit.compareTo(DurationUnit.MINUTES) >= 0) {
                                    jFractionDigitsToNanos = fractionDigitsToNanos(fractionValue2, unit);
                                } else {
                                    jFractionDigitsToNanos = fractionDigitsToNanos(fractionValue2, unit);
                                }
                                totalNanos += jFractionDigitsToNanos;
                            }
                        }
                    }
                    if (throwException) {
                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                    }
                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                }
            }
            index = startIndex$iv;
            index$iv = index;
            startIndex$iv$iv = index$iv;
            $this$skipWhile$iv$iv = value$iv2;
            while (true) {
                allowSpaces = allowSpaces;
                isFirstComponent = isFirstComponent2;
                if (startIndex$iv$iv < $this$skipWhile$iv$iv.length()) {
                    $this$skipWhile$iv$iv3 = $this$skipWhile$iv$iv;
                    i$iv$iv = startIndex$iv$iv;
                    if ($this$skipWhile$iv$iv3.charAt(startIndex$iv$iv) == '0') {
                        c7 = c;
                    } else {
                        c7 = 0;
                    }
                    if (c7 != 0) {
                        startIndex$iv$iv = i$iv$iv + 1;
                        $this$skipWhile$iv$iv = $this$skipWhile$iv$iv3;
                        allowSpaces = allowSpaces;
                        isFirstComponent2 = isFirstComponent;
                    }
                } else {
                    i$iv$iv = startIndex$iv$iv;
                }
            }
            result$iv = 0;
            index$iv2 = i$iv$iv;
            while (true) {
                this_$iv = this_$iv2;
                if (index$iv2 >= value$iv2.length()) {
                    ch$iv = value$iv2.charAt(index$iv2);
                    if ('0' <= ch$iv) {
                        c5 = 0;
                    } else {
                        c5 = 0;
                    }
                    if (c5 != 0) {
                        digit$iv = ch$iv - '0';
                        if (result$iv <= this_$iv.overflowThreshold) {
                            if (result$iv == this_$iv.overflowThreshold) {
                                value$iv = value$iv2;
                                if (digit$iv > this_$iv.lastDigitMax) {
                                }
                            } else {
                                value$iv = value$iv2;
                            }
                            result$iv = (result$iv << 3) + (result$iv << c) + ((long) digit$iv);
                            index$iv2++;
                            this_$iv2 = this_$iv;
                            value$iv2 = value$iv;
                            startIndex$iv = startIndex$iv;
                        } else {
                            value$iv = value$iv2;
                        }
                        $this$skipWhile$iv$iv2 = value$iv;
                        index$iv7 = index$iv2;
                        while (true) {
                            ch$iv2 = ch$iv;
                            if (index$iv7 < $this$skipWhile$iv$iv2.length()) {
                                it$iv2 = $this$skipWhile$iv$iv2.charAt(index$iv7);
                                i$iv$iv3 = index$iv7;
                                if ('0' <= it$iv2) {
                                    c6 = 0;
                                } else {
                                    c6 = 0;
                                }
                                if (c6 != 0) {
                                    index$iv7 = i$iv$iv3 + 1;
                                    ch$iv = ch$iv2;
                                }
                            } else {
                                i$iv$iv3 = index$iv7;
                            }
                        }
                        longEndIndex2 = i$iv$iv3;
                        if (longEndIndex2 != longStartIndex2) {
                        }
                        if (throwException) {
                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                        }
                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                    }
                    longValue = result$iv;
                    if (value.charAt(index2) == '.') {
                        c2 = c;
                    } else {
                        c2 = 0;
                    }
                    fractionValue = 0;
                    if (c2 != 0) {
                        int fractionStartIndex5 = index2;
                        index3 = index2 + 1;
                        FractionalParser fractionalParser3 = FractionalParser.INSTANCE;
                        $this$parseDigits$iv$iv = value;
                        int fractionStartIndex6 = $this$parseDigits$iv$iv.length();
                        endIndex$iv$iv = Math.min(index3 + 6, fractionStartIndex6);
                        result$iv$iv = 0;
                        index$iv$iv = index3;
                        while (index$iv$iv < endIndex$iv$iv) {
                            endIndex$iv$iv5 = endIndex$iv$iv;
                            $this$parseDigits$iv$iv4 = $this$parseDigits$iv$iv;
                            longStartIndex = longStartIndex2;
                            ch$iv$iv2 = $this$parseDigits$iv$iv4.charAt(index$iv$iv);
                            if ('0' <= ch$iv$iv2) {
                                c4 = 0;
                            } else {
                                c4 = 0;
                            }
                            if (c4 == 0) {
                                endIndex$iv$iv2 = index$iv$iv - index3;
                                while (i < 6 - endIndex$iv$iv2) {
                                    result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                                }
                                index$iv3 = index$iv$iv;
                                int index$iv$iv7 = result$iv$iv;
                                $this$parseDigits$iv$iv2 = value;
                                int maxDigits$iv$iv5 = $this$parseDigits$iv$iv2.length();
                                endIndex$iv$iv3 = Math.min(index$iv3 + 9, maxDigits$iv$iv5);
                                result$iv$iv2 = 0;
                                index$iv$iv2 = index$iv3;
                                while (index$iv$iv2 < endIndex$iv$iv3) {
                                    endIndex$iv$iv4 = endIndex$iv$iv3;
                                    fractionValue3 = fractionValue;
                                    $this$parseDigits$iv$iv3 = $this$parseDigits$iv$iv2;
                                    ch$iv$iv = $this$parseDigits$iv$iv3.charAt(index$iv$iv2);
                                    if ('0' <= ch$iv$iv) {
                                        c3 = 0;
                                    } else {
                                        c3 = 0;
                                    }
                                    if (c3 == 0) {
                                        while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                        }
                                        index$iv4 = index$iv$iv2;
                                        int lowPrecisionDigits$iv9 = result$iv$iv2;
                                        while (true) {
                                            index$iv5 = index$iv4;
                                            index$iv6 = value.length();
                                            if (index$iv$iv2 < index$iv6) {
                                                it$iv = value.charAt(index$iv$iv2);
                                                i$iv$iv2 = index$iv$iv2;
                                                if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                                    index$iv$iv2 = i$iv$iv2 + 1;
                                                    index$iv4 = index$iv5;
                                                }
                                            } else {
                                                i$iv$iv2 = index$iv$iv2;
                                            }
                                        }
                                        fractionEndIndex = i$iv$iv2;
                                        if (fractionEndIndex != index3) {
                                        }
                                        if (throwException) {
                                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                        }
                                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                                    }
                                    result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                                    index$iv$iv2++;
                                    $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv3;
                                    endIndex$iv$iv3 = endIndex$iv$iv4;
                                    fractionValue = fractionValue3;
                                }
                                while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                    result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                }
                                index$iv4 = index$iv$iv2;
                                int lowPrecisionDigits$iv10 = result$iv$iv2;
                                while (true) {
                                    index$iv5 = index$iv4;
                                    index$iv6 = value.length();
                                    if (index$iv$iv2 < index$iv6) {
                                        it$iv = value.charAt(index$iv$iv2);
                                        i$iv$iv2 = index$iv$iv2;
                                        if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                            index$iv$iv2 = i$iv$iv2 + 1;
                                            index$iv4 = index$iv5;
                                        }
                                    } else {
                                        i$iv$iv2 = index$iv$iv2;
                                    }
                                }
                                fractionEndIndex = i$iv$iv2;
                                if (fractionEndIndex != index3) {
                                }
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                            }
                            result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1) + (ch$iv$iv2 - '0');
                            index$iv$iv++;
                            longStartIndex2 = longStartIndex;
                            endIndex$iv$iv = endIndex$iv$iv5;
                            $this$parseDigits$iv$iv = $this$parseDigits$iv$iv4;
                        }
                        endIndex$iv$iv2 = index$iv$iv - index3;
                        while (i < 6 - endIndex$iv$iv2) {
                            result$iv$iv = (result$iv$iv << 3) + (result$iv$iv << 1);
                        }
                        index$iv3 = index$iv$iv;
                        int index$iv$iv8 = result$iv$iv;
                        $this$parseDigits$iv$iv2 = value;
                        int maxDigits$iv$iv6 = $this$parseDigits$iv$iv2.length();
                        endIndex$iv$iv3 = Math.min(index$iv3 + 9, maxDigits$iv$iv6);
                        result$iv$iv2 = 0;
                        index$iv$iv2 = index$iv3;
                        while (index$iv$iv2 < endIndex$iv$iv3) {
                            endIndex$iv$iv4 = endIndex$iv$iv3;
                            fractionValue3 = fractionValue;
                            $this$parseDigits$iv$iv3 = $this$parseDigits$iv$iv2;
                            ch$iv$iv = $this$parseDigits$iv$iv3.charAt(index$iv$iv2);
                            if ('0' <= ch$iv$iv) {
                                c3 = 0;
                            } else {
                                c3 = 0;
                            }
                            if (c3 == 0) {
                                while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                                    result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                                }
                                index$iv4 = index$iv$iv2;
                                int lowPrecisionDigits$iv11 = result$iv$iv2;
                                while (true) {
                                    index$iv5 = index$iv4;
                                    index$iv6 = value.length();
                                    if (index$iv$iv2 < index$iv6) {
                                        it$iv = value.charAt(index$iv$iv2);
                                        i$iv$iv2 = index$iv$iv2;
                                        if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                            index$iv$iv2 = i$iv$iv2 + 1;
                                            index$iv4 = index$iv5;
                                        }
                                    } else {
                                        i$iv$iv2 = index$iv$iv2;
                                    }
                                }
                                fractionEndIndex = i$iv$iv2;
                                if (fractionEndIndex != index3) {
                                }
                                if (throwException) {
                                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                                }
                                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                            }
                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1) + (ch$iv$iv - '0');
                            index$iv$iv2++;
                            $this$parseDigits$iv$iv2 = $this$parseDigits$iv$iv3;
                            endIndex$iv$iv3 = endIndex$iv$iv4;
                            fractionValue = fractionValue3;
                        }
                        while (i2 < 9 - (index$iv$iv2 - index$iv3)) {
                            result$iv$iv2 = (result$iv$iv2 << 3) + (result$iv$iv2 << 1);
                        }
                        index$iv4 = index$iv$iv2;
                        int lowPrecisionDigits$iv12 = result$iv$iv2;
                        while (true) {
                            index$iv5 = index$iv4;
                            index$iv6 = value.length();
                            if (index$iv$iv2 < index$iv6) {
                                it$iv = value.charAt(index$iv$iv2);
                                i$iv$iv2 = index$iv$iv2;
                                if ((('0' <= it$iv || it$iv >= ':') ? (char) 0 : c) != 0) {
                                    index$iv$iv2 = i$iv$iv2 + 1;
                                    index$iv4 = index$iv5;
                                }
                            } else {
                                i$iv$iv2 = index$iv$iv2;
                            }
                        }
                        fractionEndIndex = i$iv$iv2;
                        if (fractionEndIndex != index3) {
                        }
                        if (throwException) {
                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                        }
                        throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
                    }
                    highPrecisionDigits$iv = -1;
                    fractionValue2 = 0;
                    unit = defaultDurationUnitByShortNameOrNull(value, index2);
                    if (unit == null) {
                        str = "Unknown duration unit short name: " + value.charAt(index2);
                        if (throwException) {
                            return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                        }
                        throw new IllegalArgumentException(str);
                    }
                    if (prevUnit == null) {
                    }
                    prevUnit = unit;
                    switch (WhenMappings.$EnumSwitchMapping$0[unit.ordinal()]) {
                        case 1:
                            totalMillis += longValue / 1000;
                            if (totalMillis <= MAX_NANOS_IN_MILLIS) {
                                totalNanos = (longValue % 1000) * 1000;
                            }
                            break;
                        case 2:
                            long j3 = NANOS_IN_MILLIS;
                            totalMillis += longValue / j3;
                            totalNanos += longValue % j3;
                            break;
                        default:
                            totalMillis = addMillisWithoutOverflow(totalMillis, DurationUnitKt.convertDurationUnitToMilliseconds(longValue, unit));
                            break;
                    }
                    index4 = index2 + getShortNameLength(unit);
                    if (c2 != 0) {
                        if (index4 < length) {
                            if (throwException) {
                                return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                        if (unit.compareTo(DurationUnit.MINUTES) >= 0) {
                            jFractionDigitsToNanos = fractionDigitsToNanos(fractionValue2, unit);
                        } else {
                            jFractionDigitsToNanos = fractionDigitsToNanos(fractionValue2, unit);
                        }
                        totalNanos += jFractionDigitsToNanos;
                    }
                }
                longEndIndex = index$iv2;
                if (longEndIndex == longStartIndex2) {
                }
                if (throwException) {
                    return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
                }
                throw new IllegalArgumentException(_UrlKt.FRAGMENT_ENCODE_SET);
            }
        }
        return Duration.m1414plusLRDsOJo(toDuration(totalMillis, DurationUnit.MILLISECONDS), toDuration(totalNanos, DurationUnit.NANOSECONDS));
    }

    public static final long addMillisWithoutOverflow(long $this$addMillisWithoutOverflow, long other) {
        if (!($this$addMillisWithoutOverflow == MAX_MILLIS || $this$addMillisWithoutOverflow == -4611686018427387903L)) {
            return other == MAX_MILLIS || other == -4611686018427387903L ? other : RangesKt.coerceIn($this$addMillisWithoutOverflow + other, -4611686018427387903L, MAX_MILLIS);
        }
        if (!(-4611686018427387903L < other && other < MAX_MILLIS)) {
            if (!(($this$addMillisWithoutOverflow ^ other) >= 0)) {
                return Duration.INVALID_RAW_VALUE;
            }
        }
        return $this$addMillisWithoutOverflow;
    }

    private static final boolean isInfiniteMillis(long $this$isInfiniteMillis) {
        return $this$isInfiniteMillis == MAX_MILLIS || $this$isInfiniteMillis == -4611686018427387903L;
    }

    private static final boolean isFiniteMillis(long $this$isFiniteMillis) {
        return -4611686018427387903L < $this$isFiniteMillis && $this$isFiniteMillis < MAX_MILLIS;
    }

    private static final boolean sameSign(long a, long b) {
        return (a ^ b) >= 0;
    }

    private static final long parseFractionFallback(String $this$parseFractionFallback, int startIndex, int endIndex, DurationUnit unit) {
        Intrinsics.checkNotNull($this$parseFractionFallback, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = $this$parseFractionFallback.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return MathKt.roundToLong(Double.parseDouble(strSubstring) * getFallbackFractionMultiplier(unit));
    }

    private static final long fractionDigitsToNanos(long $this$fractionDigitsToNanos, DurationUnit unit) {
        return MathKt.roundToLong($this$fractionDigitsToNanos * getFractionMultiplier(unit));
    }

    static  long handleError$default(boolean throwException, String message, int i, Object obj) {
        if ((i & 2) != 0) {
            message = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        if (throwException) {
            throw new IllegalArgumentException(message);
        }
        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
    }

    private static final long handleError(boolean throwException, String message) {
        if (throwException) {
            throw new IllegalArgumentException(message);
        }
        return Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib();
    }

    private static final Duration m1485onInvalidge6A_vg(long $this$onInvalid_u2dge6A_vg, Function0<Duration> function0) {
        return Duration.m1390equalsimpl0($this$onInvalid_u2dge6A_vg, Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib()) ? function0.invoke() : Duration.m1383boximpl($this$onInvalid_u2dge6A_vg);
    }

    private static final DurationUnit defaultDurationUnitByShortNameOrNull(String $this$defaultDurationUnitByShortNameOrNull, int start) {
        char first = $this$defaultDurationUnitByShortNameOrNull.charAt(start);
        char second = start < StringsKt.getLastIndex($this$defaultDurationUnitByShortNameOrNull) ? $this$defaultDurationUnitByShortNameOrNull.charAt(start + 1) : (char) 0;
        switch (first) {
            case 'd':
                return DurationUnit.DAYS;
            case 'h':
                return DurationUnit.HOURS;
            case 'm':
                return second == 's' ? DurationUnit.MILLISECONDS : DurationUnit.MINUTES;
            case 'n':
                if (second == 's') {
                    return DurationUnit.NANOSECONDS;
                }
                return null;
            case 's':
                return DurationUnit.SECONDS;
            case 'u':
                if (second == 's') {
                    return DurationUnit.MICROSECONDS;
                }
                return null;
            default:
                return null;
        }
    }

    private static final DurationUnit isoDurationUnitByShortNameOrNull(String $this$isoDurationUnitByShortNameOrNull, int start) {
        switch ($this$isoDurationUnitByShortNameOrNull.charAt(start)) {
            case 'D':
                return DurationUnit.DAYS;
            case 'H':
                return DurationUnit.HOURS;
            case 'M':
                return DurationUnit.MINUTES;
            case 'S':
                return DurationUnit.SECONDS;
            default:
                return null;
        }
    }

    private static final double getFractionMultiplier(DurationUnit $this$fractionMultiplier) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$fractionMultiplier.ordinal()]) {
            case 1:
                return 1.0E-12d;
            case 2:
                return 1.0E-15d;
            case 3:
                return 1.0E-9d;
            case 4:
                return 1.0E-6d;
            case 5:
                return 6.0E-5d;
            case 6:
                return 0.0036d;
            case Http2.TYPE_GOAWAY /* 7 */:
                return 0.0864d;
            default:
                throw new IllegalStateException(("Unknown unit: " + $this$fractionMultiplier).toString());
        }
    }

    private static final long getFallbackFractionMultiplier(DurationUnit $this$fallbackFractionMultiplier) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$fallbackFractionMultiplier.ordinal()]) {
            case 5:
                return 60000000000L;
            case 6:
                return 3600000000000L;
            case Http2.TYPE_GOAWAY /* 7 */:
                return 86400000000000L;
            default:
                throw new IllegalStateException(("Invalid unit: " + $this$fallbackFractionMultiplier + " for fallback fraction multiplier").toString());
        }
    }

    private static final int getShortNameLength(DurationUnit $this$shortNameLength) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$shortNameLength.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return 2;
            default:
                return 1;
        }
    }

    private static final long multiplyBy10(long $this$multiplyBy10) {
        return ($this$multiplyBy10 << 3) + ($this$multiplyBy10 << 1);
    }

    private static final int multiplyBy10(int $this$multiplyBy10) {
        return ($this$multiplyBy10 << 3) + ($this$multiplyBy10 << 1);
    }

    public static final long nanosToMillis(long nanos) {
        return nanos / ((long) NANOS_IN_MILLIS);
    }

    public static final long millisToNanos(long millis) {
        return ((long) NANOS_IN_MILLIS) * millis;
    }

    public static final long durationOfNanos(long normalNanos) {
        return Duration.Companion.m1476fromRawValueUwyO8pc$kotlin_stdlib(normalNanos << 1);
    }

    public static final long durationOfMillis(long normalMillis) {
        return Duration.Companion.m1476fromRawValueUwyO8pc$kotlin_stdlib((normalMillis << 1) + 1);
    }

    public static final long durationOf(long normalValue, int unitDiscriminator) {
        return Duration.Companion.m1476fromRawValueUwyO8pc$kotlin_stdlib((normalValue << 1) + ((long) unitDiscriminator));
    }

    public static final long durationOfNanosNormalized(long nanos) {
        boolean z = false;
        if (-4611686018426999999L <= nanos && nanos < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(nanos);
        }
        return durationOfMillis(nanosToMillis(nanos));
    }

    public static final long durationOfMillisNormalized(long millis) {
        boolean z = false;
        if (-4611686018426L <= millis && millis < 4611686018427L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(millisToNanos(millis));
        }
        return durationOfMillis(RangesKt.coerceIn(millis, -4611686018427387903L, MAX_MILLIS));
    }
}
