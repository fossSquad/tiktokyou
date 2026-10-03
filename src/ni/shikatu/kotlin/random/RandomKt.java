package ni.shikatu.kotlin.random;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.kotlin.ranges.LongRange;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a$\u0010\b\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a$\u0010\u000b\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\t\u001a\u00020\fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u0012\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0016\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0018H\u0080\u0080\u0004¨\u0006\u0019"}, d2 = {"Random", "Lni/shikatu/kotlin/random/Random;", "seed", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", _UrlKt.FRAGMENT_ENCODE_SET, "nextInt", "range", "Lni/shikatu/kotlin/ranges/IntRange;", "nextLong", "Lni/shikatu/kotlin/ranges/LongRange;", "fastLog2", "value", "takeUpperBits", "bitCount", "checkRangeBounds", _UrlKt.FRAGMENT_ENCODE_SET, "from", "until", _UrlKt.FRAGMENT_ENCODE_SET, "boundsErrorMessage", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class RandomKt {
    public static final Random Random(int seed) {
        return new XorWowRandom(seed, seed >> 31);
    }

    public static final Random Random(long seed) {
        return new XorWowRandom((int) seed, (int) (seed >> 32));
    }

    public static final int nextInt(Random $this$nextInt, IntRange range) {
        Intrinsics.checkNotNullParameter($this$nextInt, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (range.getLast() < Integer.MAX_VALUE) {
            return $this$nextInt.nextInt(range.getFirst(), range.getLast() + 1);
        }
        return range.getFirst() > Integer.MIN_VALUE ? $this$nextInt.nextInt(range.getFirst() - 1, range.getLast()) + 1 : $this$nextInt.nextInt();
    }

    public static final long nextLong(Random $this$nextLong, LongRange range) {
        Intrinsics.checkNotNullParameter($this$nextLong, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (range.getLast() < LongCompanionObject.MAX_VALUE) {
            return $this$nextLong.nextLong(range.getFirst(), range.getLast() + 1);
        }
        return range.getFirst() > Long.MIN_VALUE ? $this$nextLong.nextLong(range.getFirst() - 1, range.getLast()) + 1 : $this$nextLong.nextLong();
    }

    public static final int fastLog2(int value) {
        return 31 - Integer.numberOfLeadingZeros(value);
    }

    public static final int takeUpperBits(int $this$takeUpperBits, int bitCount) {
        return ($this$takeUpperBits >>> (32 - bitCount)) & ((-bitCount) >> 31);
    }

    public static final void checkRangeBounds(int from, int until) {
        if (!(until > from)) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(from), Integer.valueOf(until)).toString());
        }
    }

    public static final void checkRangeBounds(long from, long until) {
        if (!(until > from)) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(from), Long.valueOf(until)).toString());
        }
    }

    public static final void checkRangeBounds(double from, double until) {
        if (!(until > from)) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(from), Double.valueOf(until)).toString());
        }
    }

    public static final String boundsErrorMessage(Object from, Object until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }
}
