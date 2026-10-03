package ni.shikatu.kotlin.ranges;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.internal.UProgressionUtilKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB!\b@\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0086\u0082\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\u0014\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004R\u0017\u0010\t\u001a\u00020\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u0005\u001a\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bÊ\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f¨\u0006\u001c"}, d2 = {"Lni/shikatu/kotlin/ranges/ULongProgression;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ULong;", "start", "endInclusive", "step", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "isEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.5"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final long first;
    private final long last;
    private final long step;

    public  ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private ULongProgression(long start, long endInclusive, long step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (step == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = start;
        this.last = UProgressionUtilKt.m1242getProgressionLastElement7ftBX0g(start, endInclusive, step);
        this.step = step;
    }

    public final long m1274getFirstsVKNKU() {
        return this.first;
    }

    public final long m1275getLastsVKNKU() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    @Override
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(this.first, this.last, this.step, null);
    }

    public boolean isEmpty() {
        long j = this.step;
        long j2 = this.first;
        long j3 = this.last;
        if (j > 0) {
            if (Long.compareUnsigned(j2, j3) > 0) {
                return true;
            }
        } else if (Long.compareUnsigned(j2, j3) < 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        return (other instanceof ULongProgression) && ((isEmpty() && ((ULongProgression) other).isEmpty()) || (this.first == ((ULongProgression) other).first && this.last == ((ULongProgression) other).last && this.step == ((ULongProgression) other).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((((int) ULong.m180constructorimpl(this.first ^ ULong.m180constructorimpl(this.first >>> 32))) * 31) + ((int) ULong.m180constructorimpl(this.last ^ ULong.m180constructorimpl(this.last >>> 32)))) * 31) + ((int) (this.step ^ (this.step >>> 32)));
    }

    public String toString() {
        StringBuilder sbAppend;
        long j;
        if (this.step > 0) {
            sbAppend = new StringBuilder().append((Object) ULong.m226toStringimpl(this.first)).append("..").append((Object) ULong.m226toStringimpl(this.last)).append(" step ");
            j = this.step;
        } else {
            sbAppend = new StringBuilder().append((Object) ULong.m226toStringimpl(this.first)).append(" downTo ").append((Object) ULong.m226toStringimpl(this.last)).append(" step ");
            j = -this.step;
        }
        return sbAppend.append(j).toString();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/ranges/ULongProgression$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "fromClosedRange", "Lni/shikatu/kotlin/ranges/ULongProgression;", "rangeStart", "Lni/shikatu/kotlin/ULong;", "rangeEnd", "step", _UrlKt.FRAGMENT_ENCODE_SET, "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ULongProgression m1276fromClosedRange7ftBX0g(long rangeStart, long rangeEnd, long step) {
            return new ULongProgression(rangeStart, rangeEnd, step, null);
        }
    }
}
