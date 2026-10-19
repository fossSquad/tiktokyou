package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005H\u0082\u0080\u0004J\n\u0010\u0007\u001a\u00020\bH\u0096\u0080\u0004J\u0011\u0010\t\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000eH\u0086\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u0016R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d¨\u0006\u001a"}, d2 = {"Lni/shikatu/kotlin/time/MonotonicTimeSource;", "Lni/shikatu/kotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "zero", _UrlKt.FRAGMENT_ENCODE_SET, "read", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "markNow", "Lni/shikatu/kotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "elapsedFrom", "Lni/shikatu/kotlin/time/Duration;", "timeMark", "elapsedFrom-6eNON_k", "(J)J", "differenceBetween", "one", "another", "differenceBetween-fRLX17w", "(JJ)J", "adjustReading", "duration", "adjustReading-6QKq23U", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MonotonicTimeSource implements TimeSource.WithComparableMarks {
    public static final MonotonicTimeSource INSTANCE = new MonotonicTimeSource();
    private static final long zero = System.nanoTime();

    private MonotonicTimeSource() {
    }

    @Override
    public /* bridge */  ComparableTimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m1505boximpl(m1499markNowz9LOYto());
    }

    @Override
    public /* bridge */  TimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m1505boximpl(m1499markNowz9LOYto());
    }

    private final long read() {
        return System.nanoTime() - zero;
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    public long m1499markNowz9LOYto() {
        return TimeSource.Monotonic.ValueTimeMark.m1508constructorimpl(read());
    }

    public final long m1498elapsedFrom6eNON_k(long timeMark) {
        return LongSaturatedMathKt.saturatingDiff(read(), timeMark, DurationUnit.NANOSECONDS);
    }

    public final long m1497differenceBetweenfRLX17w(long one, long another) {
        return LongSaturatedMathKt.saturatingOriginsDiff(one, another, DurationUnit.NANOSECONDS);
    }

    public final long m1496adjustReading6QKq23U(long timeMark, long duration) {
        return TimeSource.Monotonic.ValueTimeMark.m1508constructorimpl(LongSaturatedMathKt.m1494saturatingAddNuflL3o(timeMark, DurationUnit.NANOSECONDS, duration));
    }
}
