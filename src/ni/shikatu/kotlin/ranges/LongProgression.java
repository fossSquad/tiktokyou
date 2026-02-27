package ni.shikatu.kotlin.ranges;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.internal.ProgressionUtilKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lni/shikatu/kotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "<init>", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "iterator", "Lni/shikatu/kotlin/collections/LongIterator;", "isEmpty", "", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LongProgression implements Iterable<Long>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final long first;
    private final long last;
    private final long step;

    public LongProgression(long start, long endInclusive, long step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (step == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = start;
        this.last = ProgressionUtilKt.getProgressionLastElement(start, endInclusive, step);
        this.step = step;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    @Override
    public Iterator<Long> iterator() {
        return new LongProgressionIterator(this.first, this.last, this.step);
    }

    public boolean isEmpty() {
        long j = this.step;
        long j2 = this.first;
        long j3 = this.last;
        if (j > 0) {
            if (j2 > j3) {
                return true;
            }
        } else if (j2 < j3) {
            return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        return (other instanceof LongProgression) && ((isEmpty() && ((LongProgression) other).isEmpty()) || (this.first == ((LongProgression) other).first && this.last == ((LongProgression) other).last && this.step == ((LongProgression) other).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = 31;
        return (int) ((j * (((this.first ^ (this.first >>> 32)) * j) + (this.last ^ (this.last >>> 32)))) + (this.step ^ (this.step >>> 32)));
    }

    public String toString() {
        StringBuilder sbAppend;
        long j;
        if (this.step > 0) {
            sbAppend = new StringBuilder().append(this.first).append("..").append(this.last).append(" step ");
            j = this.step;
        } else {
            sbAppend = new StringBuilder().append(this.first).append(" downTo ").append(this.last).append(" step ");
            j = -this.step;
        }
        return sbAppend.append(j).toString();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lni/shikatu/kotlin/ranges/LongProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lni/shikatu/kotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LongProgression fromClosedRange(long rangeStart, long rangeEnd, long step) {
            return new LongProgression(rangeStart, rangeEnd, step);
        }
    }
}
