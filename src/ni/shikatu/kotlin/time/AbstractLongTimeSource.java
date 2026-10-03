package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.math.MathKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH¤\u0080\u0004J\n\u0010\u000f\u001a\u00020\tH\u0082\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\n¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016Ê\u0001\u0010\b\u0017\u0012\f\b\u0018\u0012\b\b\fJ\u0004\b\t0\u0019¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlin/time/AbstractLongTimeSource;", "Lni/shikatu/kotlin/time/TimeSource$WithComparableMarks;", "unit", "Lni/shikatu/kotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", _UrlKt.FRAGMENT_ENCODE_SET, "zero", "getZero", "()J", "zero$delegate", "Lni/shikatu/kotlin/Lazy;", "adjustedRead", "markNow", "Lni/shikatu/kotlin/time/ComparableTimeMark;", "LongTimeMark", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;
    private final Lazy zero$delegate;

    public abstract long read();

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.zero$delegate = LazyKt.lazy(new Function0() {
            @Override
            public final Object invoke() {
                return Long.valueOf(this.f$0.read());
            }
        });
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return ((Number) this.zero$delegate.getValue()).longValue();
    }

    public final long adjustedRead() {
        return read() - getZero();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lni/shikatu/kotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lni/shikatu/kotlin/time/ComparableTimeMark;", "startedAt", _UrlKt.FRAGMENT_ENCODE_SET, "timeSource", "Lni/shikatu/kotlin/time/AbstractLongTimeSource;", "offset", "Lni/shikatu/kotlin/time/Duration;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public  LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        private LongTimeMark(long startedAt, AbstractLongTimeSource timeSource, long offset) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = startedAt;
            this.timeSource = timeSource;
            this.offset = offset;
        }

        @Override
        public /* bridge */ int compareTo(ComparableTimeMark other) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, other);
        }

        @Override
        public /* bridge */ boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override
        public /* bridge */ boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override

        public /* bridge */ ComparableTimeMark mo1374minusLRDsOJo(long duration) {
            return ComparableTimeMark.DefaultImpls.m1378minusLRDsOJo(this, duration);
        }

        @Override

        public long mo1373elapsedNowUwyO8pc() {
            return Duration.m1413minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override

        public ComparableTimeMark mo1376plusLRDsOJo(long duration) {
            DurationUnit unit = this.timeSource.getUnit();
            if (Duration.m1410isInfiniteimpl(duration)) {
                return new LongTimeMark(LongSaturatedMathKt.m1494saturatingAddNuflL3o(this.startedAt, unit, duration), this.timeSource, Duration.Companion.m1480getZEROUwyO8pc(), null);
            }
            long durationInUnit = Duration.m1428truncateToUwyO8pc$kotlin_stdlib(duration, unit);
            long rest = Duration.m1414plusLRDsOJo(Duration.m1413minusLRDsOJo(duration, durationInUnit), this.offset);
            long sum = LongSaturatedMathKt.m1494saturatingAddNuflL3o(this.startedAt, unit, durationInUnit);
            long restInUnit = Duration.m1428truncateToUwyO8pc$kotlin_stdlib(rest, unit);
            long sum2 = LongSaturatedMathKt.m1494saturatingAddNuflL3o(sum, unit, restInUnit);
            long restUnderUnit = Duration.m1413minusLRDsOJo(rest, restInUnit);
            long restUnderUnitNs = Duration.m1398getInWholeNanosecondsimpl(restUnderUnit);
            if (sum2 != 0 && restUnderUnitNs != 0 && (sum2 ^ restUnderUnitNs) < 0) {
                long correction = DurationKt.toDuration(MathKt.getSign(restUnderUnitNs), unit);
                sum2 = LongSaturatedMathKt.m1494saturatingAddNuflL3o(sum2, unit, correction);
                restUnderUnit = Duration.m1413minusLRDsOJo(restUnderUnit, correction);
            }
            long newValue = sum2;
            long newOffset = (((newValue - 1) | 1) > LongCompanionObject.MAX_VALUE ? 1 : (((newValue - 1) | 1) == LongCompanionObject.MAX_VALUE ? 0 : -1)) == 0 ? Duration.Companion.m1480getZEROUwyO8pc() : restUnderUnit;
            return new LongTimeMark(newValue, this.timeSource, newOffset, null);
        }

        @Override

        public long mo1375minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (!(other instanceof LongTimeMark) || !Intrinsics.areEqual(this.timeSource, ((LongTimeMark) other).timeSource)) {
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
            }
            long startedAtDiff = LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, ((LongTimeMark) other).startedAt, this.timeSource.getUnit());
            return Duration.m1414plusLRDsOJo(startedAtDiff, Duration.m1413minusLRDsOJo(this.offset, ((LongTimeMark) other).offset));
        }

        @Override
        public boolean equals(Object other) {
            return (other instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) other).timeSource) && Duration.m1390equalsimpl0(mo1375minusUwyO8pc((ComparableTimeMark) other), Duration.Companion.m1480getZEROUwyO8pc());
        }

        @Override
        public int hashCode() {
            return (Duration.m1406hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m1425toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }
    }

    @Override
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m1480getZEROUwyO8pc(), null);
    }
}
