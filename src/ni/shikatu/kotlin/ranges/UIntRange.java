package ni.shikatu.kotlin.ranges;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001&B\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u001e\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0082\u0004J\n\u0010\"\u001a\u00020#H\u0096\u0080\u0004J\n\u0010$\u001a\u00020%H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nRI\u0010\f\u001a\u00020\u00038VX\u0097\u0084\br\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015r\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\t0\u0018¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\nÊ\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b((¨\u0006'"}, d2 = {"Lni/shikatu/kotlin/ranges/UIntRange;", "Lni/shikatu/kotlin/ranges/UIntProgression;", "Lni/shikatu/kotlin/ranges/ClosedRange;", "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-pVg5ArA", "()I", "getEndInclusive-pVg5ArA", "endExclusive", "getEndExclusive-pVg5ArA$annotations", "()V", "getEndExclusive-pVg5ArA", "Lni/shikatu/kotlin/Deprecated;", "message", "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "value", "contains-WZ4Q5Ns", "(I)Z", "isEmpty", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib", "1.5"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {
    public static final Companion Companion;
    private static final UIntRange EMPTY;

    public  UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")

    public static  void m1269getEndExclusivepVg5ArA$annotations() {
    }

    private UIntRange(int start, int endInclusive) {
        super(start, endInclusive, 1, null);
    }

    @Override
    public boolean contains(UInt value) {
        return m1270containsWZ4Q5Ns(value.m153unboximpl());
    }

    @Override
    public UInt getEndExclusive() {
        return UInt.m95boximpl(m1271getEndExclusivepVg5ArA());
    }

    @Override
    public UInt getEndInclusive() {
        return UInt.m95boximpl(m1272getEndInclusivepVg5ArA());
    }

    @Override
    public UInt getStart() {
        return UInt.m95boximpl(m1273getStartpVg5ArA());
    }

    public int m1273getStartpVg5ArA() {
        return m1265getFirstpVg5ArA();
    }

    public int m1272getEndInclusivepVg5ArA() {
        return m1266getLastpVg5ArA();
    }

    public int m1271getEndExclusivepVg5ArA() {
        if (m1266getLastpVg5ArA() == -1) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return UInt.m101constructorimpl(m1266getLastpVg5ArA() + 1);
    }

    public boolean m1270containsWZ4Q5Ns(int value) {
        return Integer.compareUnsigned(m1265getFirstpVg5ArA(), value) <= 0 && Integer.compareUnsigned(value, m1266getLastpVg5ArA()) <= 0;
    }

    @Override
    public boolean isEmpty() {
        return Integer.compareUnsigned(m1265getFirstpVg5ArA(), m1266getLastpVg5ArA()) > 0;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof UIntRange) && ((isEmpty() && ((UIntRange) other).isEmpty()) || (m1265getFirstpVg5ArA() == ((UIntRange) other).m1265getFirstpVg5ArA() && m1266getLastpVg5ArA() == ((UIntRange) other).m1266getLastpVg5ArA()));
    }

    @Override
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m1265getFirstpVg5ArA() * 31) + m1266getLastpVg5ArA();
    }

    @Override
    public String toString() {
        return ((Object) UInt.m147toStringimpl(m1265getFirstpVg5ArA())) + ".." + ((Object) UInt.m147toStringimpl(m1266getLastpVg5ArA()));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/ranges/UIntRange$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "EMPTY", "Lni/shikatu/kotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
