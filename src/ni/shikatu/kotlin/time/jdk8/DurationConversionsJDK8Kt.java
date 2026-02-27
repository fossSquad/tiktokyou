package ni.shikatu.kotlin.time.jdk8;

import java.time.Duration;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.time.DurationKt;
import ni.shikatu.kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"toKotlinDuration", "Lni/shikatu/kotlin/time/Duration;", "Ljava/time/Duration;", "(Ljava/time/Duration;)J", "toJavaDuration", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 2, mv = {2, 1, 0}, pn = "ni.shikatu.kotlin.time", xi = 48)
public final class DurationConversionsJDK8Kt {
    private static final long toKotlinDuration(Duration $this$toKotlinDuration) {
        Intrinsics.checkNotNullParameter($this$toKotlinDuration, "<this>");
        return ni.shikatu.kotlin.time.Duration.m1391plusLRDsOJo(DurationKt.toDuration($this$toKotlinDuration.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration($this$toKotlinDuration.getNano(), DurationUnit.NANOSECONDS));
    }

    private static final Duration m1494toJavaDurationLRDsOJo(long $this$toJavaDuration_u2dLRDsOJo) {
        long seconds = ni.shikatu.kotlin.time.Duration.m1376getInWholeSecondsimpl($this$toJavaDuration_u2dLRDsOJo);
        int nanoseconds = ni.shikatu.kotlin.time.Duration.m1378getNanosecondsComponentimpl($this$toJavaDuration_u2dLRDsOJo);
        Duration durationOfSeconds = Duration.ofSeconds(seconds, nanoseconds);
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds, "toComponents-impl(...)");
        return durationOfSeconds;
    }
}
