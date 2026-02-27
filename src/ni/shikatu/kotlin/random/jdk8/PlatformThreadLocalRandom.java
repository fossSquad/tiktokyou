package ni.shikatu.kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.AbstractPlatformRandom;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\rH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/random/jdk8/PlatformThreadLocalRandom;", "Lni/shikatu/kotlin/random/AbstractPlatformRandom;", "<init>", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextInt", "", "from", "until", "nextLong", "", "nextDouble", "", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    @Override
    public Random getImpl() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Intrinsics.checkNotNullExpressionValue(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }

    @Override
    public int nextInt(int from, int until) {
        return ThreadLocalRandom.current().nextInt(from, until);
    }

    @Override
    public long nextLong(long until) {
        return ThreadLocalRandom.current().nextLong(until);
    }

    @Override
    public long nextLong(long from, long until) {
        return ThreadLocalRandom.current().nextLong(from, until);
    }

    @Override
    public double nextDouble(double until) {
        return ThreadLocalRandom.current().nextDouble(until);
    }
}
