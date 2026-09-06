package ni.shikatu.kotlin.random;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.internal.PlatformImplementationsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u000e\u0010\u0007\u001a\u00020\u0002H\u0081\u0088\u0004b\u0002\b\b\u001a\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0080\u0080\u0004¨\u0006\u000e"}, d2 = {"asJavaRandom", "Ljava/util/Random;", "Lni/shikatu/kotlin/random/Random;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "asKotlinRandom", "defaultPlatformRandom", "Lni/shikatu/kotlin/internal/InlineOnly;", "doubleFromParts", _UrlKt.FRAGMENT_ENCODE_SET, "hi26", _UrlKt.FRAGMENT_ENCODE_SET, "low27", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class PlatformRandomKt {
    public static final java.util.Random asJavaRandom(Random $this$asJavaRandom) {
        java.util.Random impl;
        Intrinsics.checkNotNullParameter($this$asJavaRandom, "<this>");
        AbstractPlatformRandom abstractPlatformRandom = $this$asJavaRandom instanceof AbstractPlatformRandom ? (AbstractPlatformRandom) $this$asJavaRandom : null;
        return (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) ? new KotlinRandom($this$asJavaRandom) : impl;
    }

    public static final Random asKotlinRandom(java.util.Random $this$asKotlinRandom) {
        Random impl;
        Intrinsics.checkNotNullParameter($this$asKotlinRandom, "<this>");
        KotlinRandom kotlinRandom = $this$asKotlinRandom instanceof KotlinRandom ? (KotlinRandom) $this$asKotlinRandom : null;
        return (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) ? new PlatformRandom($this$asKotlinRandom) : impl;
    }

    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int hi26, int low27) {
        return ((((long) hi26) << 27) + ((long) low27)) / 9.007199254740992E15d;
    }
}
