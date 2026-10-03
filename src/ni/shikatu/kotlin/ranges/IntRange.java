package ni.shikatu.kotlin.ranges;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001#B\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096\u0082\u0004J\n\u0010\u001c\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0082\u0004J\n\u0010 \u001a\u00020\u0003H\u0096\u0080\u0004J\n\u0010!\u001a\u00020\"H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nRI\u0010\f\u001a\u00020\u00038VX\u0097\u0084\br\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015r\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\t0\u0018¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n¨\u0006$"}, d2 = {"Lni/shikatu/kotlin/ranges/IntRange;", "Lni/shikatu/kotlin/ranges/IntProgression;", "Lni/shikatu/kotlin/ranges/ClosedRange;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(II)V", "getStart", "()Ljava/lang/Integer;", "getEndInclusive", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "Lni/shikatu/kotlin/Deprecated;", "message", "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "value", "isEmpty", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class IntRange extends IntProgression implements ClosedRange<Integer>, OpenEndRange<Integer> {
    public static final Companion Companion = new Companion(null);
    private static final IntRange EMPTY = new IntRange(1, 0);

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static  void getEndExclusive$annotations() {
    }

    public IntRange(int start, int endInclusive) {
        super(start, endInclusive, 1);
    }

    @Override
    public boolean contains(Integer comparable) {
        return contains(comparable.intValue());
    }

    @Override
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }

    @Override
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override
    public Integer getEndExclusive() {
        if (getLast() == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return Integer.valueOf(getLast() + 1);
    }

    public boolean contains(int value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof IntRange) && ((isEmpty() && ((IntRange) other).isEmpty()) || (getFirst() == ((IntRange) other).getFirst() && getLast() == ((IntRange) other).getLast()));
    }

    @Override
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/ranges/IntRange$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "EMPTY", "Lni/shikatu/kotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntRange getEMPTY() {
            return IntRange.EMPTY;
        }
    }
}
