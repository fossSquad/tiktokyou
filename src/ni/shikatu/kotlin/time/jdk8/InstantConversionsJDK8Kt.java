package ni.shikatu.kotlin.time.jdk8;

import java.time.Instant;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0010\b\u0006\u0012\f\b\u0007\u0012\b\b\fJ\u0004\b\t0\b\u001a.\u0010\t\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0010\b\u0006\u0012\f\b\u0007\u0012\b\b\fJ\u0004\b\t0\b¨\u0006\n"}, d2 = {"toJavaInstant", "Ljava/time/Instant;", "Lni/shikatu/kotlin/time/Instant;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.3", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;", "toKotlinInstant", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 2, mv = {2, 4, 0}, pn = "ni.shikatu.kotlin.time", xi = 48)
public final class InstantConversionsJDK8Kt {
    public static final Instant toJavaInstant(ni.shikatu.kotlin.time.Instant $this$toJavaInstant) {
        Intrinsics.checkNotNullParameter($this$toJavaInstant, "<this>");
        Instant instantOfEpochSecond = Instant.ofEpochSecond($this$toJavaInstant.getEpochSeconds(), $this$toJavaInstant.getNanosecondsOfSecond());
        Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, "ofEpochSecond(...)");
        return instantOfEpochSecond;
    }

    public static final ni.shikatu.kotlin.time.Instant toKotlinInstant(Instant $this$toKotlinInstant) {
        Intrinsics.checkNotNullParameter($this$toKotlinInstant, "<this>");
        return ni.shikatu.kotlin.time.Instant.Companion.fromEpochSeconds($this$toKotlinInstant.getEpochSecond(), $this$toKotlinInstant.getNano());
    }
}
