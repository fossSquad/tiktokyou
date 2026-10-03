package ni.shikatu.kotlin.time;

import java.io.IOException;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0006\u001a\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082\u0080\u0004\u001a\u0012\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0082\u0080\u0004\u001a(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0082\u0088\u0004\u001a(\u0010$\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0082\u0088\u0004\u001a\u0012\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u001cH\u0080\u0080\u0004\u001a\u0016\u0010.\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010,\u001a\u00020\u0001H\u0082\u0080\u0004\u001a\u0016\u00104\u001a\u00020\u0019*\u00020\u00172\u0006\u00105\u001a\u00020\u001cH\u0082\u0080\u0004\"D\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\br\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\br\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000br\u0002\b\f¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"D\u0010\r\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\br\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\br\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000br\u0002\b\f¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\r\u0010\u0005\"\u000f\u0010\u000f\u001a\u00020\u0010X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0011\u001a\u00020\u0010X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0012\u001a\u00020\u0010X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0013\u001a\u00020\u0010X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u001b\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u001d\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010%\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010&\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010'\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010(\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010)\u001a\u00020\u001cX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010*\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010+\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010/\u001a\u000200X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000f\u00101\u001a\u000200X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000f\u00102\u001a\u000200X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000f\u00103\u001a\u000200X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"isDistantPast", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/time/Instant;", "isDistantPast$annotations", "(Lkotlin/time/Instant;)V", "(Lkotlin/time/Instant;)Z", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.3", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;", "Lni/shikatu/kotlin/internal/InlineOnly;", "isDistantFuture", "isDistantFuture$annotations", "DISTANT_PAST_SECONDS", _UrlKt.FRAGMENT_ENCODE_SET, "DISTANT_FUTURE_SECONDS", "MIN_SECOND", "MAX_SECOND", "parseIso", "Lni/shikatu/kotlin/time/InstantParseResult;", "isoString", _UrlKt.FRAGMENT_ENCODE_SET, "formatIso", _UrlKt.FRAGMENT_ENCODE_SET, "instant", "DAYS_PER_CYCLE", _UrlKt.FRAGMENT_ENCODE_SET, "DAYS_0000_TO_1970", "safeAddOrElse", "a", "b", "action", "Lni/shikatu/kotlin/Function0;", _UrlKt.FRAGMENT_ENCODE_SET, "safeMultiplyOrElse", "SECONDS_PER_HOUR", "SECONDS_PER_MINUTE", "HOURS_PER_DAY", "SECONDS_PER_DAY", "NANOS_PER_SECOND", "NANOS_PER_MILLI", "MILLIS_PER_SECOND", "isLeapYear", "year", "monthLength", "POWERS_OF_TEN", _UrlKt.FRAGMENT_ENCODE_SET, "asciiDigitPositionsInIsoStringAfterYear", "colonsInIsoOffsetString", "asciiDigitsInIsoOffsetString", "truncateForErrorMessage", "maxLength", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class InstantKt {
    private static final int DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    private static final long DISTANT_PAST_SECONDS = -3217862419201L;
    private static final int HOURS_PER_DAY = 24;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    public static final int NANOS_PER_SECOND = 1000000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MILLIS_PER_SECOND = 1000;
    private static final int[] POWERS_OF_TEN = {1, 10, 100, MILLIS_PER_SECOND, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    // bytes: "\n
    // \r"
    private static final int[] asciiDigitPositionsInIsoStringAfterYear = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
    private static final int[] colonsInIsoOffsetString = {3, 6};
    private static final int[] asciiDigitsInIsoOffsetString = {1, 2, 4, 5, 7, 8};

    public static  void isDistantFuture$annotations(Instant instant) {
    }

    public static  void isDistantPast$annotations(Instant instant) {
    }

    private static final boolean isDistantPast(Instant $this$isDistantPast) {
        Intrinsics.checkNotNullParameter($this$isDistantPast, "<this>");
        return $this$isDistantPast.compareTo(Instant.Companion.getDISTANT_PAST()) <= 0;
    }

    private static final boolean isDistantFuture(Instant $this$isDistantFuture) {
        Intrinsics.checkNotNullParameter($this$isDistantFuture, "<this>");
        return $this$isDistantFuture.compareTo(Instant.Companion.getDISTANT_FUTURE()) >= 0;
    }

    private static final InstantParseResult.Failure parseIso$parseFailure(CharSequence $isoString, String error) {
        return new InstantParseResult.Failure(error + " when parsing an Instant from \"" + truncateForErrorMessage($isoString, 64) + '\"', $isoString);
    }

    private static final InstantParseResult.Failure parseIso$expect(CharSequence $isoString, String what, int where, Function1<? super Character, Boolean> function1) {
        char c = $isoString.charAt(where);
        if (function1.invoke(Character.valueOf(c)).booleanValue()) {
            return null;
        }
        return parseIso$parseFailure($isoString, "Expected " + what + ", but got '" + c + "' at position " + where);
    }

    public static final InstantParseResult parseIso(CharSequence isoString) {
        int yearStrLength;
        int year;
        InstantParseResult.Failure it;
        InstantParseResult.Failure it2;
        InstantParseResult.Failure it3;
        InstantParseResult.Failure it4;
        InstantParseResult.Failure it5;
        int i;
        int month;
        int day;
        int hour;
        int minute;
        int second;
        int i2;
        int nanosecond;
        char sign;
        int offsetStrLength;
        int[] iArr;
        int length;
        int absYear;
        int[] iArr2;
        int length2;
        int i3;
        int offsetHour;
        int offsetMinute;
        int offsetSecond;
        int i4;
        int yearStrLength2;
        int j;
        int[] iArr3;
        int i5;
        char cCharAt;
        int j2;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        UnboundLocalDateTime this_$iv;
        long y$iv;
        long total$iv;
        long total$iv2;
        long total$iv3;
        int fraction;
        char yearSign;
        int fractionStrLength;
        boolean z3;
        char cCharAt2;
        int yearStart;
        boolean z4;
        InstantParseResult.Failure it6;
        int i8 = 0;
        if (isoString.length() == 0) {
            return new InstantParseResult.Failure("An empty string is not a valid Instant", isoString);
        }
        char c = isoString.charAt(0);
        switch (c) {
            case '+':
            case '-':
                i8 = 0 + 1;
                break;
            case ',':
            default:
                c = ' ';
                break;
        }
        int yearStart2 = i8;
        int absYear2 = 0;
        while (i8 < isoString.length()) {
            char cCharAt3 = isoString.charAt(i8);
            if (!('0' <= cCharAt3 && cCharAt3 < ':')) {
                yearStrLength = i8 - yearStart2;
                if (yearStrLength > 10) {
                    return parseIso$parseFailure(isoString, "Expected at most 10 digits for the year number, got " + yearStrLength + " digits");
                }
                if (yearStrLength != 10 && isoString.charAt(yearStart2) >= '2') {
                    return parseIso$parseFailure(isoString, "Expected at most 9 digits for the year number or year 1000000000, got " + yearStrLength + " digits");
                }
                if (yearStrLength < 4) {
                    return parseIso$parseFailure(isoString, "The year number must be padded to 4 digits, got " + yearStrLength + " digits");
                }
                if (c != '+' && yearStrLength == 4) {
                    return parseIso$parseFailure(isoString, "The '+' sign at the start is only valid for year numbers longer than 4 digits");
                }
                if (c != ' ' && yearStrLength != 4) {
                    return parseIso$parseFailure(isoString, "A '+' or '-' sign is required for year numbers longer than 4 digits");
                }
                if (c == '-') {
                    year = -absYear2;
                } else {
                    year = absYear2;
                }
                if (isoString.length() < i8 + 16) {
                    return parseIso$parseFailure(isoString, "The input string is too short");
                }
                it = parseIso$expect(isoString, "'-'", i8, new Function1() {
                    @Override
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(InstantKt.parseIso$lambda$0(((Character) obj).charValue()));
                    }
                });
                if (it != null) {
                    return it;
                }
                it2 = parseIso$expect(isoString, "'-'", i8 + 3, new Function1() {
                    @Override
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(InstantKt.parseIso$lambda$2(((Character) obj).charValue()));
                    }
                });
                if (it2 != null) {
                    return it2;
                }
                it3 = parseIso$expect(isoString, "'T' or 't'", i8 + 6, new Function1() {
                    @Override
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(InstantKt.parseIso$lambda$4(((Character) obj).charValue()));
                    }
                });
                if (it3 != null) {
                    return it3;
                }
                it4 = parseIso$expect(isoString, "':'", i8 + 9, new Function1() {
                    @Override
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(InstantKt.parseIso$lambda$6(((Character) obj).charValue()));
                    }
                });
                if (it4 != null) {
                    return it4;
                }
                it5 = parseIso$expect(isoString, "':'", i8 + 12, new Function1() {
                    @Override
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(InstantKt.parseIso$lambda$8(((Character) obj).charValue()));
                    }
                });
                if (it5 != null) {
                    return it5;
                }
                for (int i9 : asciiDigitPositionsInIsoStringAfterYear) {
                    it6 = parseIso$expect(isoString, "an ASCII digit", i8 + i9, new Function1() {
                        @Override
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(InstantKt.parseIso$lambda$10(((Character) obj).charValue()));
                        }
                    });
                    if (it6 != null) {
                        return it6;
                    }
                }
                month = parseIso$twoDigitNumber(isoString, i8 + 1);
                day = parseIso$twoDigitNumber(isoString, i8 + 4);
                hour = parseIso$twoDigitNumber(isoString, i8 + 7);
                minute = parseIso$twoDigitNumber(isoString, i8 + 10);
                second = parseIso$twoDigitNumber(isoString, i8 + 13);
                if (isoString.charAt(i8 + 15) == '.') {
                    int fractionStart = i8 + 16;
                    i2 = fractionStart;
                    fraction = 0;
                    while (true) {
                        yearSign = c;
                        if (i2 < isoString.length()) {
                            cCharAt2 = isoString.charAt(i2);
                            yearStart = yearStart2;
                            if ('0' <= cCharAt2 || cCharAt2 >= ':') {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (z4) {
                                fraction = (fraction * 10) + (isoString.charAt(i2) - '0');
                                i2++;
                                c = yearSign;
                                yearStart2 = yearStart;
                            }
                        }
                    }
                    fractionStrLength = i2 - fractionStart;
                    if (1 <= fractionStrLength || fractionStrLength >= 10) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        return parseIso$parseFailure(isoString, "1..9 digits are supported for the fraction of the second, got " + fractionStrLength + " digits");
                    }
                    nanosecond = POWERS_OF_TEN[9 - fractionStrLength] * fraction;
                } else {
                    i2 = i8 + 15;
                    nanosecond = 0;
                }
                if (i2 >= isoString.length()) {
                    return parseIso$parseFailure(isoString, "The UTC offset at the end of the string is missing");
                }
                sign = isoString.charAt(i2);
                switch (sign) {
                    case '+':
                    case '-':
                        offsetStrLength = isoString.length() - i2;
                        if (offsetStrLength > 9) {
                            return parseIso$parseFailure(isoString, "The UTC offset string \"" + truncateForErrorMessage(isoString.subSequence(i2, isoString.length()).toString(), 16) + "\" is too long");
                        }
                        if (offsetStrLength % 3 != 0) {
                            return parseIso$parseFailure(isoString, "Invalid UTC offset string \"" + isoString.subSequence(i2, isoString.length()).toString() + '\"');
                        }
                        iArr = colonsInIsoOffsetString;
                        length = iArr.length;
                        absYear = 0;
                        while (absYear < length) {
                            j2 = iArr[absYear];
                            i6 = length;
                            i7 = absYear;
                            if (i2 + j2 >= isoString.length()) {
                                iArr2 = asciiDigitsInIsoOffsetString;
                                length2 = iArr2.length;
                                i3 = 0;
                                while (i3 < length2) {
                                    j = iArr2[i3];
                                    iArr3 = iArr2;
                                    i5 = length2;
                                    if (i2 + j >= isoString.length()) {
                                        offsetHour = parseIso$twoDigitNumber(isoString, i2 + 1);
                                        if (offsetStrLength > 3) {
                                            offsetMinute = parseIso$twoDigitNumber(isoString, i2 + 4);
                                        } else {
                                            offsetMinute = 0;
                                        }
                                        if (offsetStrLength > 6) {
                                            offsetSecond = parseIso$twoDigitNumber(isoString, i2 + 7);
                                        } else {
                                            offsetSecond = 0;
                                        }
                                        if (offsetMinute > 59) {
                                            return parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                                        }
                                        if (offsetSecond > 59) {
                                            return parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                                        }
                                        if (offsetHour <= 17 && (offsetHour != 18 || offsetMinute != 0 || offsetSecond != 0)) {
                                            return parseIso$parseFailure(isoString, "Expected an offset in -18:00..+18:00, got " + isoString.subSequence(i2, isoString.length()).toString());
                                        }
                                        int i10 = (offsetHour * SECONDS_PER_HOUR) + (offsetMinute * SECONDS_PER_MINUTE) + offsetSecond;
                                        if (sign == '-') {
                                            i4 = -1;
                                        } else {
                                            i4 = 1;
                                        }
                                        yearStrLength2 = i10 * i4;
                                    } else {
                                        cCharAt = isoString.charAt(i2 + j);
                                        if (!('0' > cCharAt && cCharAt < ':')) {
                                            return parseIso$parseFailure(isoString, "Expected an ASCII digit at index " + (i2 + j) + ", got '" + isoString.charAt(i2 + j) + '\'');
                                        }
                                        i3++;
                                        iArr2 = iArr3;
                                        length2 = i5;
                                    }
                                    break;
                                }
                                offsetHour = parseIso$twoDigitNumber(isoString, i2 + 1);
                                if (offsetStrLength > 3) {
                                    offsetMinute = parseIso$twoDigitNumber(isoString, i2 + 4);
                                } else {
                                    offsetMinute = 0;
                                }
                                if (offsetStrLength > 6) {
                                    offsetSecond = parseIso$twoDigitNumber(isoString, i2 + 7);
                                } else {
                                    offsetSecond = 0;
                                }
                                if (offsetMinute > 59) {
                                    return parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                                }
                                if (offsetSecond > 59) {
                                    return parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                                }
                                if (offsetHour <= 17) {
                                }
                                int i11 = (offsetHour * SECONDS_PER_HOUR) + (offsetMinute * SECONDS_PER_MINUTE) + offsetSecond;
                                if (sign == '-') {
                                    i4 = -1;
                                } else {
                                    i4 = 1;
                                }
                                yearStrLength2 = i11 * i4;
                            } else {
                                if (isoString.charAt(i2 + j2) != ':') {
                                    return parseIso$parseFailure(isoString, "Expected ':' at index " + (i2 + j2) + ", got '" + isoString.charAt(i2 + j2) + '\'');
                                }
                                absYear = i7 + 1;
                                length = i6;
                            }
                            break;
                        }
                        iArr2 = asciiDigitsInIsoOffsetString;
                        length2 = iArr2.length;
                        i3 = 0;
                        while (i3 < length2) {
                            j = iArr2[i3];
                            iArr3 = iArr2;
                            i5 = length2;
                            if (i2 + j >= isoString.length()) {
                                offsetHour = parseIso$twoDigitNumber(isoString, i2 + 1);
                                if (offsetStrLength > 3) {
                                    offsetMinute = parseIso$twoDigitNumber(isoString, i2 + 4);
                                } else {
                                    offsetMinute = 0;
                                }
                                if (offsetStrLength > 6) {
                                    offsetSecond = parseIso$twoDigitNumber(isoString, i2 + 7);
                                } else {
                                    offsetSecond = 0;
                                }
                                if (offsetMinute > 59) {
                                    return parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                                }
                                if (offsetSecond > 59) {
                                    return parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                                }
                                if (offsetHour <= 17) {
                                }
                                int i12 = (offsetHour * SECONDS_PER_HOUR) + (offsetMinute * SECONDS_PER_MINUTE) + offsetSecond;
                                if (sign == '-') {
                                    i4 = -1;
                                } else {
                                    i4 = 1;
                                }
                                yearStrLength2 = i12 * i4;
                            } else {
                                cCharAt = isoString.charAt(i2 + j);
                                if (!('0' > cCharAt && cCharAt < ':')) {
                                    return parseIso$parseFailure(isoString, "Expected an ASCII digit at index " + (i2 + j) + ", got '" + isoString.charAt(i2 + j) + '\'');
                                }
                                i3++;
                                iArr2 = iArr3;
                                length2 = i5;
                            }
                            break;
                        }
                        offsetHour = parseIso$twoDigitNumber(isoString, i2 + 1);
                        if (offsetStrLength > 3) {
                            offsetMinute = parseIso$twoDigitNumber(isoString, i2 + 4);
                        } else {
                            offsetMinute = 0;
                        }
                        if (offsetStrLength > 6) {
                            offsetSecond = parseIso$twoDigitNumber(isoString, i2 + 7);
                        } else {
                            offsetSecond = 0;
                        }
                        if (offsetMinute > 59) {
                            return parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                        }
                        if (offsetSecond > 59) {
                            return parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                        }
                        if (offsetHour <= 17) {
                        }
                        int i13 = (offsetHour * SECONDS_PER_HOUR) + (offsetMinute * SECONDS_PER_MINUTE) + offsetSecond;
                        if (sign == '-') {
                            i4 = -1;
                        } else {
                            i4 = 1;
                        }
                        yearStrLength2 = i13 * i4;
                        break;
                        break;
                    case 'Z':
                    case 'z':
                        if (isoString.length() == i2 + 1) {
                            return parseIso$parseFailure(isoString, "Extra text after the instant at position " + (i2 + 1));
                        }
                        yearStrLength2 = 0;
                        break;
                        break;
                    default:
                        return parseIso$parseFailure(isoString, "Expected the UTC offset at position " + i2 + ", got '" + sign + '\'');
                }
                if (1 <= month || month >= 13) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return parseIso$parseFailure(isoString, "Expected a month number in 1..12, got " + month);
                }
                if (1 <= day || day > monthLength(month, isLeapYear(year))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    return parseIso$parseFailure(isoString, "Expected a valid day-of-month for month " + month + " of year " + year + ", got " + day);
                }
                if (hour > 23) {
                    return parseIso$parseFailure(isoString, "Expected hour in 0..23, got " + hour);
                }
                if (minute > 59) {
                    return parseIso$parseFailure(isoString, "Expected minute-of-hour in 0..59, got " + minute);
                }
                if (second > 59) {
                    return parseIso$parseFailure(isoString, "Expected second-of-minute in 0..59, got " + second);
                }
                this_$iv = new UnboundLocalDateTime(year, month, day, hour, minute, second, nanosecond);
                int offsetSeconds$iv = yearStrLength2;
                y$iv = this_$iv.getYear();
                total$iv = ((long) 365) * y$iv;
                if (y$iv >= 0) {
                    total$iv2 = total$iv + (((((long) 3) + y$iv) / ((long) 4)) - ((((long) 99) + y$iv) / ((long) 100))) + ((((long) 399) + y$iv) / ((long) 400));
                } else {
                    total$iv2 = total$iv - (((y$iv / ((long) (-4))) - (y$iv / ((long) (-100)))) + (y$iv / ((long) (-400))));
                }
                total$iv3 = total$iv2 + ((long) (((this_$iv.getMonth() * 367) - 362) / 12)) + ((long) (this_$iv.getDay() - 1));
                if (this_$iv.getMonth() > 2) {
                    total$iv3--;
                    if (!isLeapYear(this_$iv.getYear())) {
                        total$iv3--;
                    }
                }
                long epochDays$iv = total$iv3 - ((long) DAYS_0000_TO_1970);
                int daySeconds$iv = (this_$iv.getHour() * SECONDS_PER_HOUR) + (this_$iv.getMinute() * SECONDS_PER_MINUTE) + this_$iv.getSecond();
                long epochSeconds$iv = ((((long) SECONDS_PER_DAY) * epochDays$iv) + ((long) daySeconds$iv)) - ((long) offsetSeconds$iv);
                int p1 = this_$iv.getNanosecond();
                return new InstantParseResult.Success(epochSeconds$iv, p1);
            }
            absYear2 = (absYear2 * 10) + (isoString.charAt(i8) - '0');
            i8++;
        }
        yearStrLength = i8 - yearStart2;
        if (yearStrLength > 10) {
            return parseIso$parseFailure(isoString, "Expected at most 10 digits for the year number, got " + yearStrLength + " digits");
        }
        if (yearStrLength != 10) {
        }
        if (yearStrLength < 4) {
            return parseIso$parseFailure(isoString, "The year number must be padded to 4 digits, got " + yearStrLength + " digits");
        }
        if (c != '+') {
        }
        if (c != ' ') {
        }
        if (c == '-') {
            year = -absYear2;
        } else {
            year = absYear2;
        }
        if (isoString.length() < i8 + 16) {
            return parseIso$parseFailure(isoString, "The input string is too short");
        }
        it = parseIso$expect(isoString, "'-'", i8, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$0(((Character) obj).charValue()));
            }
        });
        if (it != null) {
            return it;
        }
        it2 = parseIso$expect(isoString, "'-'", i8 + 3, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$2(((Character) obj).charValue()));
            }
        });
        if (it2 != null) {
            return it2;
        }
        it3 = parseIso$expect(isoString, "'T' or 't'", i8 + 6, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$4(((Character) obj).charValue()));
            }
        });
        if (it3 != null) {
            return it3;
        }
        it4 = parseIso$expect(isoString, "':'", i8 + 9, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$6(((Character) obj).charValue()));
            }
        });
        if (it4 != null) {
            return it4;
        }
        it5 = parseIso$expect(isoString, "':'", i8 + 12, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$8(((Character) obj).charValue()));
            }
        });
        if (it5 != null) {
            return it5;
        }
        while (i < r6) {
            it6 = parseIso$expect(isoString, "an ASCII digit", i8 + i9, new Function1() {
                @Override
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(InstantKt.parseIso$lambda$10(((Character) obj).charValue()));
                }
            });
            if (it6 != null) {
                return it6;
            }
        }
        month = parseIso$twoDigitNumber(isoString, i8 + 1);
        day = parseIso$twoDigitNumber(isoString, i8 + 4);
        hour = parseIso$twoDigitNumber(isoString, i8 + 7);
        minute = parseIso$twoDigitNumber(isoString, i8 + 10);
        second = parseIso$twoDigitNumber(isoString, i8 + 13);
        if (isoString.charAt(i8 + 15) == '.') {
            int fractionStart2 = i8 + 16;
            i2 = fractionStart2;
            fraction = 0;
            while (true) {
                yearSign = c;
                if (i2 < isoString.length()) {
                    cCharAt2 = isoString.charAt(i2);
                    yearStart = yearStart2;
                    if ('0' <= cCharAt2) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        fraction = (fraction * 10) + (isoString.charAt(i2) - '0');
                        i2++;
                        c = yearSign;
                        yearStart2 = yearStart;
                    }
                }
            }
            fractionStrLength = i2 - fractionStart2;
            if (1 <= fractionStrLength) {
                z3 = false;
            } else {
                z3 = false;
            }
            if (z3) {
                return parseIso$parseFailure(isoString, "1..9 digits are supported for the fraction of the second, got " + fractionStrLength + " digits");
            }
            nanosecond = POWERS_OF_TEN[9 - fractionStrLength] * fraction;
        } else {
            i2 = i8 + 15;
            nanosecond = 0;
        }
        if (i2 >= isoString.length()) {
            return parseIso$parseFailure(isoString, "The UTC offset at the end of the string is missing");
        }
        sign = isoString.charAt(i2);
        switch (sign) {
            case '+':
            case '-':
                offsetStrLength = isoString.length() - i2;
                if (offsetStrLength > 9) {
                    return parseIso$parseFailure(isoString, "The UTC offset string \"" + truncateForErrorMessage(isoString.subSequence(i2, isoString.length()).toString(), 16) + "\" is too long");
                }
                if (offsetStrLength % 3 != 0) {
                    return parseIso$parseFailure(isoString, "Invalid UTC offset string \"" + isoString.subSequence(i2, isoString.length()).toString() + '\"');
                }
                iArr = colonsInIsoOffsetString;
                length = iArr.length;
                absYear = 0;
                while (absYear < length) {
                    j2 = iArr[absYear];
                    i6 = length;
                    i7 = absYear;
                    if (i2 + j2 >= isoString.length()) {
                        iArr2 = asciiDigitsInIsoOffsetString;
                        length2 = iArr2.length;
                        i3 = 0;
                        while (i3 < length2) {
                            j = iArr2[i3];
                            iArr3 = iArr2;
                            i5 = length2;
                            if (i2 + j >= isoString.length()) {
                                offsetHour = parseIso$twoDigitNumber(isoString, i2 + 1);
                                if (offsetStrLength > 3) {
                                    offsetMinute = parseIso$twoDigitNumber(isoString, i2 + 4);
                                } else {
                                    offsetMinute = 0;
                                }
                                if (offsetStrLength > 6) {
                                    offsetSecond = parseIso$twoDigitNumber(isoString, i2 + 7);
                                } else {
                                    offsetSecond = 0;
                                }
                                if (offsetMinute > 59) {
                                    return parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                                }
                                if (offsetSecond > 59) {
                                    return parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                                }
                                if (offsetHour <= 17) {
                                }
                                int i14 = (offsetHour * SECONDS_PER_HOUR) + (offsetMinute * SECONDS_PER_MINUTE) + offsetSecond;
                                if (sign == '-') {
                                    i4 = -1;
                                } else {
                                    i4 = 1;
                                }
                                yearStrLength2 = i14 * i4;
                            } else {
                                cCharAt = isoString.charAt(i2 + j);
                                if ('0' > cCharAt) {
                                    break;
                                }
                                if (!('0' > cCharAt && cCharAt < ':')) {
                                    return parseIso$parseFailure(isoString, "Expected an ASCII digit at index " + (i2 + j) + ", got '" + isoString.charAt(i2 + j) + '\'');
                                }
                                i3++;
                                iArr2 = iArr3;
                                length2 = i5;
                            }
                            break;
                        }
                        offsetHour = parseIso$twoDigitNumber(isoString, i2 + 1);
                        if (offsetStrLength > 3) {
                            offsetMinute = parseIso$twoDigitNumber(isoString, i2 + 4);
                        } else {
                            offsetMinute = 0;
                        }
                        if (offsetStrLength > 6) {
                            offsetSecond = parseIso$twoDigitNumber(isoString, i2 + 7);
                        } else {
                            offsetSecond = 0;
                        }
                        if (offsetMinute > 59) {
                            return parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                        }
                        if (offsetSecond > 59) {
                            return parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                        }
                        if (offsetHour <= 17) {
                        }
                        int i15 = (offsetHour * SECONDS_PER_HOUR) + (offsetMinute * SECONDS_PER_MINUTE) + offsetSecond;
                        if (sign == '-') {
                            i4 = -1;
                        } else {
                            i4 = 1;
                        }
                        yearStrLength2 = i15 * i4;
                    } else {
                        if (isoString.charAt(i2 + j2) != ':') {
                            return parseIso$parseFailure(isoString, "Expected ':' at index " + (i2 + j2) + ", got '" + isoString.charAt(i2 + j2) + '\'');
                        }
                        absYear = i7 + 1;
                        length = i6;
                    }
                    break;
                }
                iArr2 = asciiDigitsInIsoOffsetString;
                length2 = iArr2.length;
                i3 = 0;
                while (i3 < length2) {
                    j = iArr2[i3];
                    iArr3 = iArr2;
                    i5 = length2;
                    if (i2 + j >= isoString.length()) {
                        offsetHour = parseIso$twoDigitNumber(isoString, i2 + 1);
                        if (offsetStrLength > 3) {
                            offsetMinute = parseIso$twoDigitNumber(isoString, i2 + 4);
                        } else {
                            offsetMinute = 0;
                        }
                        if (offsetStrLength > 6) {
                            offsetSecond = parseIso$twoDigitNumber(isoString, i2 + 7);
                        } else {
                            offsetSecond = 0;
                        }
                        if (offsetMinute > 59) {
                            return parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                        }
                        if (offsetSecond > 59) {
                            return parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                        }
                        if (offsetHour <= 17) {
                        }
                        int i16 = (offsetHour * SECONDS_PER_HOUR) + (offsetMinute * SECONDS_PER_MINUTE) + offsetSecond;
                        if (sign == '-') {
                            i4 = -1;
                        } else {
                            i4 = 1;
                        }
                        yearStrLength2 = i16 * i4;
                    } else {
                        cCharAt = isoString.charAt(i2 + j);
                        if ('0' > cCharAt) {
                            break;
                        }
                        if (!('0' > cCharAt && cCharAt < ':')) {
                            return parseIso$parseFailure(isoString, "Expected an ASCII digit at index " + (i2 + j) + ", got '" + isoString.charAt(i2 + j) + '\'');
                        }
                        i3++;
                        iArr2 = iArr3;
                        length2 = i5;
                    }
                    break;
                }
                offsetHour = parseIso$twoDigitNumber(isoString, i2 + 1);
                if (offsetStrLength > 3) {
                    offsetMinute = parseIso$twoDigitNumber(isoString, i2 + 4);
                } else {
                    offsetMinute = 0;
                }
                if (offsetStrLength > 6) {
                    offsetSecond = parseIso$twoDigitNumber(isoString, i2 + 7);
                } else {
                    offsetSecond = 0;
                }
                if (offsetMinute > 59) {
                    return parseIso$parseFailure(isoString, "Expected offset-minute-of-hour in 0..59, got " + offsetMinute);
                }
                if (offsetSecond > 59) {
                    return parseIso$parseFailure(isoString, "Expected offset-second-of-minute in 0..59, got " + offsetSecond);
                }
                if (offsetHour <= 17) {
                }
                int i17 = (offsetHour * SECONDS_PER_HOUR) + (offsetMinute * SECONDS_PER_MINUTE) + offsetSecond;
                if (sign == '-') {
                    i4 = -1;
                } else {
                    i4 = 1;
                }
                yearStrLength2 = i17 * i4;
                break;
                break;
            case 'Z':
            case 'z':
                if (isoString.length() == i2 + 1) {
                    return parseIso$parseFailure(isoString, "Extra text after the instant at position " + (i2 + 1));
                }
                yearStrLength2 = 0;
                break;
                break;
            default:
                return parseIso$parseFailure(isoString, "Expected the UTC offset at position " + i2 + ", got '" + sign + '\'');
        }
        if (1 <= month) {
            z = false;
        } else {
            z = false;
        }
        if (!z) {
            return parseIso$parseFailure(isoString, "Expected a month number in 1..12, got " + month);
        }
        if (1 <= day) {
            z2 = false;
        } else {
            z2 = false;
        }
        if (!z2) {
            return parseIso$parseFailure(isoString, "Expected a valid day-of-month for month " + month + " of year " + year + ", got " + day);
        }
        if (hour > 23) {
            return parseIso$parseFailure(isoString, "Expected hour in 0..23, got " + hour);
        }
        if (minute > 59) {
            return parseIso$parseFailure(isoString, "Expected minute-of-hour in 0..59, got " + minute);
        }
        if (second > 59) {
            return parseIso$parseFailure(isoString, "Expected second-of-minute in 0..59, got " + second);
        }
        this_$iv = new UnboundLocalDateTime(year, month, day, hour, minute, second, nanosecond);
        int offsetSeconds$iv2 = yearStrLength2;
        y$iv = this_$iv.getYear();
        total$iv = ((long) 365) * y$iv;
        if (y$iv >= 0) {
            total$iv2 = total$iv + (((((long) 3) + y$iv) / ((long) 4)) - ((((long) 99) + y$iv) / ((long) 100))) + ((((long) 399) + y$iv) / ((long) 400));
        } else {
            total$iv2 = total$iv - (((y$iv / ((long) (-4))) - (y$iv / ((long) (-100)))) + (y$iv / ((long) (-400))));
        }
        total$iv3 = total$iv2 + ((long) (((this_$iv.getMonth() * 367) - 362) / 12)) + ((long) (this_$iv.getDay() - 1));
        if (this_$iv.getMonth() > 2) {
            total$iv3--;
            if (!isLeapYear(this_$iv.getYear())) {
                total$iv3--;
            }
        }
        long epochDays$iv2 = total$iv3 - ((long) DAYS_0000_TO_1970);
        int daySeconds$iv2 = (this_$iv.getHour() * SECONDS_PER_HOUR) + (this_$iv.getMinute() * SECONDS_PER_MINUTE) + this_$iv.getSecond();
        long epochSeconds$iv2 = ((((long) SECONDS_PER_DAY) * epochDays$iv2) + ((long) daySeconds$iv2)) - ((long) offsetSeconds$iv2);
        int p2 = this_$iv.getNanosecond();
        return new InstantParseResult.Success(epochSeconds$iv2, p2);
    }

    public static final boolean parseIso$lambda$0(char it) {
        return it == '-';
    }

    public static final boolean parseIso$lambda$2(char it) {
        return it == '-';
    }

    public static final boolean parseIso$lambda$4(char it) {
        return it == 'T' || it == 't';
    }

    public static final boolean parseIso$lambda$6(char it) {
        return it == ':';
    }

    public static final boolean parseIso$lambda$8(char it) {
        return it == ':';
    }

    public static final boolean parseIso$lambda$10(char it) {
        return '0' <= it && it < ':';
    }

    private static final int parseIso$twoDigitNumber(CharSequence s, int index) {
        return ((s.charAt(index) - '0') * 10) + (s.charAt(index + 1) - '0');
    }

    public static final String formatIso(Instant instant) throws IOException {
        StringBuilder $this$formatIso_u24lambda_u240 = new StringBuilder();
        UnboundLocalDateTime ldt = UnboundLocalDateTime.Companion.fromInstant(instant);
        int number = ldt.getYear();
        if (Math.abs(number) < MILLIS_PER_SECOND) {
            StringBuilder innerBuilder = new StringBuilder();
            if (number >= 0) {
                Intrinsics.checkNotNullExpressionValue(innerBuilder.append(number + 10000).deleteCharAt(0), "deleteCharAt(...)");
            } else {
                Intrinsics.checkNotNullExpressionValue(innerBuilder.append(number - 10000).deleteCharAt(1), "deleteCharAt(...)");
            }
            $this$formatIso_u24lambda_u240.append((CharSequence) innerBuilder);
        } else {
            if (number >= 10000) {
                $this$formatIso_u24lambda_u240.append('+');
            }
            $this$formatIso_u24lambda_u240.append(number);
        }
        $this$formatIso_u24lambda_u240.append('-');
        formatIso$lambda$0$appendTwoDigits($this$formatIso_u24lambda_u240, $this$formatIso_u24lambda_u240, ldt.getMonth());
        $this$formatIso_u24lambda_u240.append('-');
        formatIso$lambda$0$appendTwoDigits($this$formatIso_u24lambda_u240, $this$formatIso_u24lambda_u240, ldt.getDay());
        $this$formatIso_u24lambda_u240.append('T');
        formatIso$lambda$0$appendTwoDigits($this$formatIso_u24lambda_u240, $this$formatIso_u24lambda_u240, ldt.getHour());
        $this$formatIso_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
        formatIso$lambda$0$appendTwoDigits($this$formatIso_u24lambda_u240, $this$formatIso_u24lambda_u240, ldt.getMinute());
        $this$formatIso_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
        formatIso$lambda$0$appendTwoDigits($this$formatIso_u24lambda_u240, $this$formatIso_u24lambda_u240, ldt.getSecond());
        if (ldt.getNanosecond() != 0) {
            $this$formatIso_u24lambda_u240.append('.');
            int zerosToStrip = 0;
            while (ldt.getNanosecond() % POWERS_OF_TEN[zerosToStrip + 1] == 0) {
                zerosToStrip++;
            }
            int zerosToStrip2 = zerosToStrip - (zerosToStrip % 3);
            int numberToOutput = ldt.getNanosecond() / POWERS_OF_TEN[zerosToStrip2];
            String strValueOf = String.valueOf(POWERS_OF_TEN[9 - zerosToStrip2] + numberToOutput);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strValueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            $this$formatIso_u24lambda_u240.append(strSubstring);
        }
        $this$formatIso_u24lambda_u240.append('Z');
        return $this$formatIso_u24lambda_u240.toString();
    }

    private static final void formatIso$lambda$0$appendTwoDigits(Appendable $this$formatIso_u24lambda_u240_u24appendTwoDigits, StringBuilder $this_buildString, int number) throws IOException {
        if (number < 10) {
            $this$formatIso_u24lambda_u240_u24appendTwoDigits.append('0');
        }
        $this_buildString.append(number);
    }

    private static final long safeAddOrElse(long a, long b, Function0 action) {
        long sum = a + b;
        if ((a ^ sum) < 0 && (a ^ b) >= 0) {
            action.invoke();
            throw new KotlinNothingValueException();
        }
        return sum;
    }

    private static final long safeMultiplyOrElse(long a, long b, Function0 action) {
        if (b == 1) {
            return a;
        }
        if (a == 1) {
            return b;
        }
        if (a == 0 || b == 0) {
            return 0L;
        }
        long total = a * b;
        if (total / b != a || ((a == Long.MIN_VALUE && b == -1) || (b == Long.MIN_VALUE && a == -1))) {
            action.invoke();
            throw new KotlinNothingValueException();
        }
        return total;
    }

    public static final boolean isLeapYear(int year) {
        return (year & 3) == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private static final int monthLength(int $this$monthLength, boolean isLeapYear) {
        switch ($this$monthLength) {
            case 2:
                return isLeapYear ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static final String truncateForErrorMessage(CharSequence $this$truncateForErrorMessage, int maxLength) {
        return $this$truncateForErrorMessage.length() <= maxLength ? $this$truncateForErrorMessage.toString() : $this$truncateForErrorMessage.subSequence(0, maxLength).toString() + "...";
    }
}
