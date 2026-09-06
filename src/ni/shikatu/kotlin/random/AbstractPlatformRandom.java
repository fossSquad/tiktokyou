package ni.shikatu.kotlin.random;

import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\u000b\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0097\u0080\bb\u0002\b\u0018R\u0013\u0010\u0004\u001a\u00020\u0005X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lni/shikatu/kotlin/random/AbstractPlatformRandom;", "Lni/shikatu/kotlin/random/Random;", "<init>", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", _UrlKt.FRAGMENT_ENCODE_SET, "bitCount", "nextInt", "until", "nextLong", _UrlKt.FRAGMENT_ENCODE_SET, "nextBoolean", _UrlKt.FRAGMENT_ENCODE_SET, "nextDouble", _UrlKt.FRAGMENT_ENCODE_SET, "nextFloat", _UrlKt.FRAGMENT_ENCODE_SET, "nextBytes", _UrlKt.FRAGMENT_ENCODE_SET, "array", "Lni/shikatu/kotlin/IgnorableReturnValue;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractPlatformRandom extends Random {
    public abstract java.util.Random getImpl();

    @Override
    public int nextBits(int bitCount) {
        return RandomKt.takeUpperBits(getImpl().nextInt(), bitCount);
    }

    @Override
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override
    public int nextInt(int until) {
        return getImpl().nextInt(until);
    }

    @Override
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override
    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    @Override
    public double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override
    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override
    @IgnorableReturnValue
    public byte[] nextBytes(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        getImpl().nextBytes(array);
        return array;
    }
}
