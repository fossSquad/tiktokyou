package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Deprecated(level = DeprecationLevel.ERROR, message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH¤\u0080\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010Ê\u0001\u0002\b\u0011Ê\u0001\u0018\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\b\u0015\u0012\u0006\b\n0\u00168\u0017¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/time/AbstractDoubleTimeSource;", "Lni/shikatu/kotlin/time/TimeSource$WithComparableMarks;", "unit", "Lni/shikatu/kotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", _UrlKt.FRAGMENT_ENCODE_SET, "markNow", "Lni/shikatu/kotlin/time/ComparableTimeMark;", "DoubleTimeMark", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/time/ExperimentalTime;", "Lni/shikatu/kotlin/Deprecated;", "message", "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "ERROR"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    protected abstract double read();

    public AbstractDoubleTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\r\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0096\u0082\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001f"}, d2 = {"Lni/shikatu/kotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lni/shikatu/kotlin/time/ComparableTimeMark;", "startedAt", _UrlKt.FRAGMENT_ENCODE_SET, "timeSource", "Lni/shikatu/kotlin/time/AbstractDoubleTimeSource;", "offset", "Lni/shikatu/kotlin/time/Duration;", "<init>", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTimeSource$annotations", "()V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class DoubleTimeMark implements ComparableTimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        public  DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, abstractDoubleTimeSource, j);
        }

        private static  void getTimeSource$annotations() {
        }

        private DoubleTimeMark(double startedAt, AbstractDoubleTimeSource timeSource, long offset) {
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
            return Duration.m1413minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override

        public ComparableTimeMark mo1376plusLRDsOJo(long duration) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.m1414plusLRDsOJo(this.offset, duration), null);
        }

        @Override

        public long mo1375minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (!(other instanceof DoubleTimeMark) || !Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark) other).timeSource)) {
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
            }
            if (Duration.m1390equalsimpl0(this.offset, ((DoubleTimeMark) other).offset) && Duration.m1410isInfiniteimpl(this.offset)) {
                return Duration.Companion.m1480getZEROUwyO8pc();
            }
            long offsetDiff = Duration.m1413minusLRDsOJo(this.offset, ((DoubleTimeMark) other).offset);
            long startedAtDiff = DurationKt.toDuration(this.startedAt - ((DoubleTimeMark) other).startedAt, this.timeSource.getUnit());
            return Duration.m1390equalsimpl0(startedAtDiff, Duration.m1429unaryMinusUwyO8pc(offsetDiff)) ? Duration.Companion.m1480getZEROUwyO8pc() : Duration.m1414plusLRDsOJo(startedAtDiff, offsetDiff);
        }

        @Override
        public boolean equals(Object other) {
            return (other instanceof DoubleTimeMark) && Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark) other).timeSource) && Duration.m1390equalsimpl0(mo1375minusUwyO8pc((ComparableTimeMark) other), Duration.Companion.m1480getZEROUwyO8pc());
        }

        @Override
        public int hashCode() {
            return Duration.m1406hashCodeimpl(Duration.m1414plusLRDsOJo(DurationKt.toDuration(this.startedAt, this.timeSource.getUnit()), this.offset));
        }

        public String toString() {
            return "DoubleTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m1425toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }
    }

    @Override
    public ComparableTimeMark markNow() {
        return new DoubleTimeMark(read(), this, Duration.Companion.m1480getZEROUwyO8pc(), null);
    }
}
