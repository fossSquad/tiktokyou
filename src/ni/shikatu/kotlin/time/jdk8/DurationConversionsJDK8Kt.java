package ni.shikatu.kotlin.time.jdk8;

import java.time.Duration;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.time.DurationKt;
import ni.shikatu.kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0003\u001a'\u0010\b\u001a\u00020\u0002*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"toKotlinDuration", "Lni/shikatu/kotlin/time/Duration;", "Ljava/time/Duration;", "(Ljava/time/Duration;)J", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.6", "Lni/shikatu/kotlin/internal/InlineOnly;", "toJavaDuration", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 2, mv = {2, 4, 0}, pn = "ni.shikatu.kotlin.time", xi = 48)
public final class DurationConversionsJDK8Kt {
    private static final long toKotlinDuration(Duration $this$toKotlinDuration) {
        Intrinsics.checkNotNullParameter($this$toKotlinDuration, "<this>");
        return ni.shikatu.kotlin.time.Duration.m1414plusLRDsOJo(DurationKt.toDuration($this$toKotlinDuration.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration($this$toKotlinDuration.getNano(), DurationUnit.NANOSECONDS));
    }

    private static final Duration m1527toJavaDurationLRDsOJo(long $this$toJavaDuration_u2dLRDsOJo) {
        long seconds = ni.shikatu.kotlin.time.Duration.m1399getInWholeSecondsimpl($this$toJavaDuration_u2dLRDsOJo);
        int nanoseconds = ni.shikatu.kotlin.time.Duration.m1401getNanosecondsComponentimpl($this$toJavaDuration_u2dLRDsOJo);
        Duration durationOfSeconds = Duration.ofSeconds(seconds, nanoseconds);
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds, "toComponents-impl(...)");
        return durationOfSeconds;
    }
}
