package ni.shikatu.kotlin.random;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/random/FallbackThreadLocalRandom;", "Lni/shikatu/kotlin/random/AbstractPlatformRandom;", "<init>", "()V", "implStorage", "ni/shikatu/kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Lni/shikatu/kotlin/random/FallbackThreadLocalRandom$implStorage$1;", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    private final FallbackThreadLocalRandom$implStorage$1 implStorage = new ThreadLocal<java.util.Random>() {

        @Override
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    };

    @Override
    public java.util.Random getImpl() {
        java.util.Random random = get();
        Intrinsics.checkNotNullExpressionValue(random, "get(...)");
        return random;
    }
}
