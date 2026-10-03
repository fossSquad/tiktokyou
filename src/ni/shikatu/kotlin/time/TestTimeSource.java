package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005H\u0094\u0080\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082\u0080\u0004¢\u0006\u0004\b\u000e\u0010\fR\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012Ê\u0001\u0010\b\u0013\u0012\f\b\u0014\u0012\b\b\fJ\u0004\b\t0\u0015¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/time/TestTimeSource;", "Lni/shikatu/kotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", _UrlKt.FRAGMENT_ENCODE_SET, "read", "plusAssign", _UrlKt.FRAGMENT_ENCODE_SET, "duration", "Lni/shikatu/kotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    public final void m1501plusAssignLRDsOJo(long duration) {
        long longDelta = Duration.m1424toLongimpl(duration, getUnit());
        int $i$f$isSaturated = ((longDelta - 1) | 1) == LongCompanionObject.MAX_VALUE ? 1 : 0;
        if ($i$f$isSaturated == 0) {
            long newReading = this.reading + longDelta;
            if ((this.reading ^ longDelta) >= 0 && (this.reading ^ newReading) < 0) {
                m1500overflowLRDsOJo(duration);
            }
            this.reading = newReading;
            return;
        }
        long half = Duration.m1388divUwyO8pc(duration, 2);
        long $this$isSaturated$iv = Duration.m1424toLongimpl(half, getUnit());
        if (!((($this$isSaturated$iv - 1) | 1) == LongCompanionObject.MAX_VALUE)) {
            long readingBefore = this.reading;
            try {
                m1501plusAssignLRDsOJo(half);
                m1501plusAssignLRDsOJo(Duration.m1413minusLRDsOJo(duration, half));
                return;
            } catch (IllegalStateException e) {
                this.reading = readingBefore;
                throw e;
            }
        }
        m1500overflowLRDsOJo(duration);
    }

    private final void m1500overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m1425toStringimpl(duration)) + '.');
    }
}
