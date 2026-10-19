package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0004\b\u000e\u0010\b\u001a\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a\u000e\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\u0088\u0004¨\u0006\u001d"}, d2 = {"saturatingAdd", _UrlKt.FRAGMENT_ENCODE_SET, "value", "unit", "Lni/shikatu/kotlin/time/DurationUnit;", "duration", "Lni/shikatu/kotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class LongSaturatedMathKt {

    public static final long m1494saturatingAddNuflL3o(long value, DurationUnit unit, long duration) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long durationInUnit = Duration.m1424toLongimpl(duration, unit);
        if (((value - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            return m1493checkInfiniteSumDefinedPjuGub4(value, duration, durationInUnit);
        }
        if (((durationInUnit - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            return m1495saturatingAddInHalvesNuflL3o(value, unit, duration);
        }
        long result = value + durationInUnit;
        if (((value ^ result) & (durationInUnit ^ result)) >= 0) {
            return result;
        }
        if (value < 0) {
            return Long.MIN_VALUE;
        }
        return LongCompanionObject.MAX_VALUE;
    }

    private static final long m1493checkInfiniteSumDefinedPjuGub4(long value, long duration, long durationInUnit) {
        if (!Duration.m1410isInfiniteimpl(duration) || (value ^ durationInUnit) >= 0) {
            return value;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final long m1495saturatingAddInHalvesNuflL3o(long value, DurationUnit unit, long duration) {
        long half = Duration.m1388divUwyO8pc(duration, 2);
        long halfInUnit = Duration.m1424toLongimpl(half, unit);
        if ((1 | (halfInUnit - 1)) == LongCompanionObject.MAX_VALUE) {
            return halfInUnit;
        }
        return m1494saturatingAddNuflL3o(m1494saturatingAddNuflL3o(value, unit, half), unit, Duration.m1413minusLRDsOJo(duration, half));
    }

    private static final long infinityOfSign(long value) {
        return value < 0 ? Duration.Companion.m1479getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.Companion.m1477getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long valueNs, long origin, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ((1 | (origin - 1)) == LongCompanionObject.MAX_VALUE) {
            return Duration.m1429unaryMinusUwyO8pc(infinityOfSign(origin));
        }
        return saturatingFiniteDiff(valueNs, origin, unit);
    }

    public static final long saturatingOriginsDiff(long origin1, long origin2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        int $i$f$isSaturated = ((origin2 - 1) | 1) == LongCompanionObject.MAX_VALUE ? 1 : 0;
        if ($i$f$isSaturated != 0) {
            return origin1 == origin2 ? Duration.Companion.m1480getZEROUwyO8pc() : Duration.m1429unaryMinusUwyO8pc(infinityOfSign(origin2));
        }
        if ((1 | (origin1 - 1)) == LongCompanionObject.MAX_VALUE) {
            return infinityOfSign(origin1);
        }
        return saturatingFiniteDiff(origin1, origin2, unit);
    }

    private static final long saturatingFiniteDiff(long value1, long value2, DurationUnit unit) {
        long result = value1 - value2;
        if (((result ^ value1) & (~(result ^ value2))) < 0) {
            if (unit.compareTo(DurationUnit.MILLISECONDS) < 0) {
                long unitsInMilli = DurationUnitKt.convertDurationUnit(1L, DurationUnit.MILLISECONDS, unit);
                long resultMs = (value1 / unitsInMilli) - (value2 / unitsInMilli);
                long resultUnit = (value1 % unitsInMilli) - (value2 % unitsInMilli);
                Duration.Companion companion = Duration.Companion;
                return Duration.m1414plusLRDsOJo(DurationKt.toDuration(resultMs, DurationUnit.MILLISECONDS), DurationKt.toDuration(resultUnit, unit));
            }
            return Duration.m1429unaryMinusUwyO8pc(infinityOfSign(result));
        }
        return DurationKt.toDuration(result, unit);
    }

    public static final boolean isSaturated(long $this$isSaturated) {
        return (1 | ($this$isSaturated - 1)) == LongCompanionObject.MAX_VALUE;
    }
}
