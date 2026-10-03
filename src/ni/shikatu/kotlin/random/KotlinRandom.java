package ni.shikatu.kotlin.random;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0010H\u0016R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000f\u0010\u0019\u001a\u00020\u000eX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lni/shikatu/kotlin/random/KotlinRandom;", "Ljava/util/Random;", "impl", "Lni/shikatu/kotlin/random/Random;", "<init>", "(Lkotlin/random/Random;)V", "getImpl", "()Lkotlin/random/Random;", "next", _UrlKt.FRAGMENT_ENCODE_SET, "bits", "nextInt", "bound", "nextBoolean", _UrlKt.FRAGMENT_ENCODE_SET, "nextLong", _UrlKt.FRAGMENT_ENCODE_SET, "nextFloat", _UrlKt.FRAGMENT_ENCODE_SET, "nextDouble", _UrlKt.FRAGMENT_ENCODE_SET, "nextBytes", _UrlKt.FRAGMENT_ENCODE_SET, "bytes", _UrlKt.FRAGMENT_ENCODE_SET, "seedInitialized", "setSeed", "seed", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class KotlinRandom extends java.util.Random {
    private static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private final Random impl;
    private boolean seedInitialized;

    public KotlinRandom(Random impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.impl = impl;
    }

    public final Random getImpl() {
        return this.impl;
    }

    @Override
    protected int next(int bits) {
        return this.impl.nextBits(bits);
    }

    @Override
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override
    public int nextInt(int bound) {
        return this.impl.nextInt(bound);
    }

    @Override
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override
    public void nextBytes(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.impl.nextBytes(bytes);
    }

    @Override
    public void setSeed(long seed) {
        if (!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/random/KotlinRandom$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
