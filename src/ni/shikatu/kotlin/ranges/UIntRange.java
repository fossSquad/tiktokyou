package ni.shikatu.kotlin.ranges;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001dB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0013\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\f\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlin/ranges/UIntRange;", "Lni/shikatu/kotlin/ranges/UIntProgression;", "Lni/shikatu/kotlin/ranges/ClosedRange;", "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-pVg5ArA", "()I", "getEndInclusive-pVg5ArA", "endExclusive", "getEndExclusive-pVg5ArA$annotations", "()V", "getEndExclusive-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {
    public static final Companion Companion;
    private static final UIntRange EMPTY;

    public  UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")

    public static  void m1247getEndExclusivepVg5ArA$annotations() {
    }

    @Override
    public /* bridge */  boolean contains(Comparable value) {
        return m1248containsWZ4Q5Ns(((UInt) value).m151unboximpl());
    }

    @Override
    public /* bridge */  Comparable getEndExclusive() {
        return UInt.m93boximpl(m1249getEndExclusivepVg5ArA());
    }

    @Override
    public /* bridge */  Comparable getEndInclusive() {
        return UInt.m93boximpl(m1250getEndInclusivepVg5ArA());
    }

    @Override
    public /* bridge */  Comparable getStart() {
        return UInt.m93boximpl(m1251getStartpVg5ArA());
    }

    private UIntRange(int start, int endInclusive) {
        super(start, endInclusive, 1, null);
    }

    public int m1251getStartpVg5ArA() {
        return m1243getFirstpVg5ArA();
    }

    public int m1250getEndInclusivepVg5ArA() {
        return m1244getLastpVg5ArA();
    }

    public int m1249getEndExclusivepVg5ArA() {
        if (m1244getLastpVg5ArA() == -1) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return UInt.m99constructorimpl(m1244getLastpVg5ArA() + 1);
    }

    public boolean m1248containsWZ4Q5Ns(int value) {
        return Integer.compareUnsigned(m1243getFirstpVg5ArA(), value) <= 0 && Integer.compareUnsigned(value, m1244getLastpVg5ArA()) <= 0;
    }

    @Override
    public boolean isEmpty() {
        return Integer.compareUnsigned(m1243getFirstpVg5ArA(), m1244getLastpVg5ArA()) > 0;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof UIntRange) && ((isEmpty() && ((UIntRange) other).isEmpty()) || (m1243getFirstpVg5ArA() == ((UIntRange) other).m1243getFirstpVg5ArA() && m1244getLastpVg5ArA() == ((UIntRange) other).m1244getLastpVg5ArA()));
    }

    @Override
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m1243getFirstpVg5ArA() * 31) + m1244getLastpVg5ArA();
    }

    @Override
    public String toString() {
        return ((Object) UInt.m145toStringimpl(m1243getFirstpVg5ArA())) + ".." + ((Object) UInt.m145toStringimpl(m1244getLastpVg5ArA()));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/ranges/UIntRange$Companion;", "", "<init>", "()V", "EMPTY", "Lni/shikatu/kotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UIntRange getEMPTY() {
            return UIntRange.EMPTY;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        EMPTY = new UIntRange(-1, 0, defaultConstructorMarker);
    }
}
