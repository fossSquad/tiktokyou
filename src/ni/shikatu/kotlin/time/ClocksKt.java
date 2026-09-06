package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005¢\u0006\u0002\b\u0005¨\u0006\u000e"}, d2 = {"asClock", "Lni/shikatu/kotlin/time/Clock;", "Lni/shikatu/kotlin/time/TimeSource;", "origin", "Lni/shikatu/kotlin/time/Instant;", "fromTimeSource", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.3", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ClocksKt {
    public static final Clock fromTimeSource(final TimeSource $this$asClock, final Instant origin) {
        Intrinsics.checkNotNullParameter($this$asClock, "<this>");
        Intrinsics.checkNotNullParameter(origin, "origin");
        return new Clock($this$asClock, origin) {
            final  Instant $origin;
            private final TimeMark startMark;

            {
                this.$origin = origin;
                this.startMark = $this$asClock.markNow();
            }

            @Override
            public Instant now() {
                return this.$origin.m1490plusLRDsOJo(this.startMark.mo1373elapsedNowUwyO8pc());
            }
        };
    }
}
