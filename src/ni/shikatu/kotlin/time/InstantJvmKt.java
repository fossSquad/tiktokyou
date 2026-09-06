package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.internal.PlatformImplementationsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0080\u0080\u0004\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"systemClock", "Lni/shikatu/kotlin/time/Clock;", "systemClockNow", "Lni/shikatu/kotlin/time/Instant;", "serializedInstant", _UrlKt.FRAGMENT_ENCODE_SET, "instant", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class InstantJvmKt {
    private static final Clock systemClock = PlatformImplementationsKt.IMPLEMENTATIONS.getSystemClock();

    public static final Instant systemClockNow() {
        return systemClock.now();
    }

    public static final Object serializedInstant(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return new InstantSerialized(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
    }
}
