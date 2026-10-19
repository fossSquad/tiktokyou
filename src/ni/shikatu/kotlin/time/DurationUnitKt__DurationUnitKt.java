package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.okhttp3.internal.http2.Http2;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u0007\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\u0004H\u0081\u0080\u0004b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\"\u0019\u0010\b\u001a\u00020\u0001*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"convertDurationUnitToMilliseconds", _UrlKt.FRAGMENT_ENCODE_SET, "value", "unit", "Lni/shikatu/kotlin/time/DurationUnit;", "multiplyNonNegativeWithoutOverflow", "other", "multiplyNonNegativeWithoutOverflow$DurationUnitKt__DurationUnitKt", "millisMultiplier", "getMillisMultiplier$DurationUnitKt__DurationUnitKt", "(Lkotlin/time/DurationUnit;)J", "shortName", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DurationUnit.HOURS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DurationUnit.MINUTES.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DurationUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long convertDurationUnitToMilliseconds(long value, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return multiplyNonNegativeWithoutOverflow$DurationUnitKt__DurationUnitKt(value, getMillisMultiplier$DurationUnitKt__DurationUnitKt(unit));
    }

    private static final long multiplyNonNegativeWithoutOverflow$DurationUnitKt__DurationUnitKt(long $this$multiplyNonNegativeWithoutOverflow, long other) {
        if ($this$multiplyNonNegativeWithoutOverflow == 0) {
            return 0L;
        }
        if ($this$multiplyNonNegativeWithoutOverflow == 1) {
            return RangesKt.coerceAtMost(other, DurationKt.MAX_MILLIS);
        }
        if (other == 1) {
            return RangesKt.coerceAtMost($this$multiplyNonNegativeWithoutOverflow, DurationKt.MAX_MILLIS);
        }
        int bitSum = (128 - Long.numberOfLeadingZeros($this$multiplyNonNegativeWithoutOverflow)) - Long.numberOfLeadingZeros(other);
        if (bitSum < 63) {
            return $this$multiplyNonNegativeWithoutOverflow * other;
        }
        return bitSum > 63 ? DurationKt.MAX_MILLIS : RangesKt.coerceAtMost($this$multiplyNonNegativeWithoutOverflow * other, DurationKt.MAX_MILLIS);
    }

    private static final long getMillisMultiplier$DurationUnitKt__DurationUnitKt(DurationUnit $this$millisMultiplier) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$millisMultiplier.ordinal()]) {
            case 1:
                return DurationKt.MILLIS_IN_DAY;
            case 2:
                return DurationKt.MILLIS_IN_HOUR;
            case 3:
                return 60000L;
            case 4:
                return 1000L;
            case 5:
                return 1L;
            default:
                throw new IllegalStateException(("Wrong unit for millisMultiplier: " + $this$millisMultiplier).toString());
        }
    }

    public static final String shortName(DurationUnit $this$shortName) {
        Intrinsics.checkNotNullParameter($this$shortName, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$shortName.ordinal()]) {
            case 1:
                return "d";
            case 2:
                return "h";
            case 3:
                return "m";
            case 4:
                return "s";
            case 5:
                return "ms";
            case 6:
                return "ns";
            case Http2.TYPE_GOAWAY /* 7 */:
                return "us";
            default:
                throw new IllegalStateException(("Unknown unit: " + $this$shortName).toString());
        }
    }
}
