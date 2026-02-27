package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/time/TestTimeSource;", "Lni/shikatu/kotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", "", "read", "plusAssign", "", "duration", "Lni/shikatu/kotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    @Override
    public long read() {
        return this.reading;
    }

    public final void m1468plusAssignLRDsOJo(long duration) {
        long longDelta = Duration.m1401toLongimpl(duration, getUnit());
        int $i$f$isSaturated = ((longDelta - 1) | 1) == LongCompanionObject.MAX_VALUE ? 1 : 0;
        if ($i$f$isSaturated == 0) {
            long newReading = this.reading + longDelta;
            if ((this.reading ^ longDelta) >= 0 && (this.reading ^ newReading) < 0) {
                m1467overflowLRDsOJo(duration);
            }
            this.reading = newReading;
            return;
        }
        long half = Duration.m1365divUwyO8pc(duration, 2);
        long $this$isSaturated$iv = Duration.m1401toLongimpl(half, getUnit());
        if (!((($this$isSaturated$iv - 1) | 1) == LongCompanionObject.MAX_VALUE)) {
            long readingBefore = this.reading;
            try {
                m1468plusAssignLRDsOJo(half);
                m1468plusAssignLRDsOJo(Duration.m1390minusLRDsOJo(duration, half));
                return;
            } catch (IllegalStateException e) {
                this.reading = readingBefore;
                throw e;
            }
        }
        m1467overflowLRDsOJo(duration);
    }

    private final void m1467overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m1402toStringimpl(duration)) + '.');
    }
}
