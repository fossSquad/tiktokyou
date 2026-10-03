package ni.shikatu.kotlin.ranges;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001&B\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u001e\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0082\u0004J\n\u0010\"\u001a\u00020#H\u0096\u0080\u0004J\n\u0010$\u001a\u00020%H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nRI\u0010\f\u001a\u00020\u00038VX\u0097\u0084\br\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015r\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\t0\u0018¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\nÊ\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b((¨\u0006'"}, d2 = {"Lni/shikatu/kotlin/ranges/ULongRange;", "Lni/shikatu/kotlin/ranges/ULongProgression;", "Lni/shikatu/kotlin/ranges/ClosedRange;", "Lni/shikatu/kotlin/ULong;", "Lni/shikatu/kotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "Lni/shikatu/kotlin/Deprecated;", "message", "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "value", "contains-VKZWuLQ", "(J)Z", "isEmpty", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib", "1.5"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {
    public static final Companion Companion = new Companion(null);
    private static final ULongRange EMPTY = new ULongRange(-1, 0, null);

    public  ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")

    public static  void m1278getEndExclusivesVKNKU$annotations() {
    }

    private ULongRange(long start, long endInclusive) {
        super(start, endInclusive, 1L, null);
    }

    @Override
    public boolean contains(ULong value) {
        return m1279containsVKZWuLQ(value.m232unboximpl());
    }

    @Override
    public ULong getEndExclusive() {
        return ULong.m174boximpl(m1280getEndExclusivesVKNKU());
    }

    @Override
    public ULong getEndInclusive() {
        return ULong.m174boximpl(m1281getEndInclusivesVKNKU());
    }

    @Override
    public ULong getStart() {
        return ULong.m174boximpl(m1282getStartsVKNKU());
    }

    public long m1282getStartsVKNKU() {
        return m1274getFirstsVKNKU();
    }

    public long m1281getEndInclusivesVKNKU() {
        return m1275getLastsVKNKU();
    }

    public long m1280getEndExclusivesVKNKU() {
        if (m1275getLastsVKNKU() == -1) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return ULong.m180constructorimpl(m1275getLastsVKNKU() + ULong.m180constructorimpl(((long) 1) & 4294967295L));
    }

    public boolean m1279containsVKZWuLQ(long value) {
        return Long.compareUnsigned(m1274getFirstsVKNKU(), value) <= 0 && Long.compareUnsigned(value, m1275getLastsVKNKU()) <= 0;
    }

    @Override
    public boolean isEmpty() {
        return Long.compareUnsigned(m1274getFirstsVKNKU(), m1275getLastsVKNKU()) > 0;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof ULongRange) && ((isEmpty() && ((ULongRange) other).isEmpty()) || (m1274getFirstsVKNKU() == ((ULongRange) other).m1274getFirstsVKNKU() && m1275getLastsVKNKU() == ((ULongRange) other).m1275getLastsVKNKU()));
    }

    @Override
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) ULong.m180constructorimpl(m1274getFirstsVKNKU() ^ ULong.m180constructorimpl(m1274getFirstsVKNKU() >>> 32))) * 31) + ((int) ULong.m180constructorimpl(m1275getLastsVKNKU() ^ ULong.m180constructorimpl(m1275getLastsVKNKU() >>> 32)));
    }

    @Override
    public String toString() {
        return ((Object) ULong.m226toStringimpl(m1274getFirstsVKNKU())) + ".." + ((Object) ULong.m226toStringimpl(m1275getLastsVKNKU()));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/ranges/ULongRange$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "EMPTY", "Lni/shikatu/kotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }
}
