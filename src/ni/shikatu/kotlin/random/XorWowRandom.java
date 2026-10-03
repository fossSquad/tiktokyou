package ni.shikatu.kotlin.random;

import java.io.InvalidObjectException;
import java.io.Serializable;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0017B9\b@\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fB\u0019\bP\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u000fJ\n\u0010\u0010\u001a\u00020\u0011H\u0082\u0080\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0082\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0005H\u0096\u0080\u0004J\u0012\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0096\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlin/random/XorWowRandom;", "Lni/shikatu/kotlin/random/Random;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "x", _UrlKt.FRAGMENT_ENCODE_SET, "y", "z", "w", "v", "addend", "<init>", "(IIIIII)V", "seed1", "seed2", "(II)V", "checkInvariants", _UrlKt.FRAGMENT_ENCODE_SET, "readResolve", _UrlKt.FRAGMENT_ENCODE_SET, "nextInt", "nextBits", "bitCount", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class XorWowRandom extends Random implements Serializable {
    private static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private int addend;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public XorWowRandom(int x, int y, int z, int w, int v, int addend) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.v = v;
        this.addend = addend;
        checkInvariants();
        for (int i = 0; i < 64; i++) {
            nextInt();
        }
    }

    public XorWowRandom(int seed1, int seed2) {
        this(seed1, seed2, 0, 0, ~seed1, (seed1 << 10) ^ (seed2 >>> 4));
    }

    private final void checkInvariants() {
        if (!(((((this.x | this.y) | this.z) | this.w) | this.v) != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
    }

    private final Object readResolve() throws Throwable {
        try {
            checkInvariants();
            return this;
        } catch (Throwable th) {
            Throwable thInitCause = new InvalidObjectException(th.getMessage()).initCause(th);
            Intrinsics.checkNotNullExpressionValue(thInitCause, "initCause(...)");
            throw thInitCause;
        }
    }

    @Override
    public int nextInt() {
        int t = this.x;
        int t2 = t ^ (t >>> 2);
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        int v0 = this.v;
        this.w = v0;
        int t3 = (((t2 << 1) ^ t2) ^ v0) ^ (v0 << 4);
        this.v = t3;
        this.addend += 362437;
        return this.addend + t3;
    }

    @Override
    public int nextBits(int bitCount) {
        return RandomKt.takeUpperBits(nextInt(), bitCount);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/random/XorWowRandom$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
