package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.ranges.ULongRange;
import ni.shikatu.kotlin.ranges.URangesKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b \u0010\u0018J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b!\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\"\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u001eJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b%\u0010\u0018J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b&\u0010\u001aJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b'\u0010\u001cJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u001eJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b*\u0010\u0018J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b+\u0010\u001aJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b,\u0010\u001cJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u001eJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b/\u0010\u0018J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b0\u0010\u001aJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b1\u0010\u001cJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b2\u0010\u001eJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b4\u0010\u0018J\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b5\u0010\u001aJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b6\u0010\u001cJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b7\u0010\u001eJ\u0018\u00108\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b9\u0010:J\u0018\u00108\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b;\u0010<J\u0018\u00108\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b=\u0010\u0013J\u0018\u00108\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b>\u0010\u001eJ\u0010\u0010?\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b@\u0010\u0005J\u0010\u0010A\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bB\u0010\u0005J\u0018\u0010C\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010FJ\u0018\u0010G\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bH\u0010FJ\u0018\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\tH\u0087\f¢\u0006\u0004\bK\u0010\u001cJ\u0018\u0010L\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\tH\u0087\f¢\u0006\u0004\bM\u0010\u001cJ\u0018\u0010N\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bO\u0010\u001eJ\u0018\u0010P\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bQ\u0010\u001eJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bS\u0010\u001eJ\u0010\u0010T\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\tH\u0087\b¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\bd\u0010YJ\u0010\u0010e\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\bf\u0010]J\u0010\u0010g\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\bh\u0010`J\u0010\u0010i\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bj\u0010\u0005J\u0010\u0010k\u001a\u00020lH\u0087\b¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020pH\u0087\b¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020tH\u0016¢\u0006\u0004\bu\u0010vJ\u0013\u0010w\u001a\u00020x2\b\u0010\n\u001a\u0004\u0018\u00010yHÖ\u0003J\t\u0010z\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006|"}, d2 = {"Lni/shikatu/kotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "compareTo", "", "other", "Lni/shikatu/kotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lni/shikatu/kotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "Lni/shikatu/kotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "plus", "plus-7apg3OU", "(JB)J", "plus-xj2QHRw", "(JS)J", "plus-WZ4Q5Ns", "(JI)J", "plus-VKZWuLQ", "(JJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(JB)B", "mod-xj2QHRw", "(JS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-s-VKNKU", "dec", "dec-s-VKNKU", "rangeTo", "Lni/shikatu/kotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "and", "and-VKZWuLQ", "or", "or-VKZWuLQ", "xor", "xor-VKZWuLQ", "inv", "inv-s-VKNKU", "toByte", "", "toByte-impl", "(J)B", "toShort", "", "toShort-impl", "(J)S", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(J)F", "toDouble", "", "toDouble-impl", "(J)D", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    public static final  ULong m172boximpl(long j) {
        return new ULong(j);
    }

    public static long m178constructorimpl(long j) {
        return j;
    }

    public static boolean m184equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m230unboximpl();
    }

    public static final boolean m185equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static  void getData$annotations() {
    }

    public static int m190hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m184equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m190hashCodeimpl(this.data);
    }

    public final  long m230unboximpl() {
        return this.data;
    }

    @Override
    public /* bridge */  int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(m230unboximpl(), uLong.m230unboximpl());
    }

    private  ULong(long data) {
        this.data = data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/ULong$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lni/shikatu/kotlin/ULong;", "J", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final int m173compareTo7apg3OU(long arg0, byte other) {
        return Long.compareUnsigned(arg0, m178constructorimpl(((long) other) & 255));
    }

    private static final int m177compareToxj2QHRw(long arg0, short other) {
        return Long.compareUnsigned(arg0, m178constructorimpl(((long) other) & 65535));
    }

    private static final int m176compareToWZ4Q5Ns(long arg0, int other) {
        return Long.compareUnsigned(arg0, m178constructorimpl(((long) other) & 4294967295L));
    }

    private int m174compareToVKZWuLQ(long other) {
        return UnsignedKt.ulongCompare(m230unboximpl(), other);
    }

    private static int m175compareToVKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongCompare(arg0, other);
    }

    private static final long m202plus7apg3OU(long arg0, byte other) {
        return m178constructorimpl(m178constructorimpl(((long) other) & 255) + arg0);
    }

    private static final long m205plusxj2QHRw(long arg0, short other) {
        return m178constructorimpl(m178constructorimpl(((long) other) & 65535) + arg0);
    }

    private static final long m204plusWZ4Q5Ns(long arg0, int other) {
        return m178constructorimpl(m178constructorimpl(((long) other) & 4294967295L) + arg0);
    }

    private static final long m203plusVKZWuLQ(long arg0, long other) {
        return m178constructorimpl(arg0 + other);
    }

    private static final long m193minus7apg3OU(long arg0, byte other) {
        return m178constructorimpl(arg0 - m178constructorimpl(((long) other) & 255));
    }

    private static final long m196minusxj2QHRw(long arg0, short other) {
        return m178constructorimpl(arg0 - m178constructorimpl(((long) other) & 65535));
    }

    private static final long m195minusWZ4Q5Ns(long arg0, int other) {
        return m178constructorimpl(arg0 - m178constructorimpl(((long) other) & 4294967295L));
    }

    private static final long m194minusVKZWuLQ(long arg0, long other) {
        return m178constructorimpl(arg0 - other);
    }

    private static final long m214times7apg3OU(long arg0, byte other) {
        return m178constructorimpl(m178constructorimpl(((long) other) & 255) * arg0);
    }

    private static final long m217timesxj2QHRw(long arg0, short other) {
        return m178constructorimpl(m178constructorimpl(((long) other) & 65535) * arg0);
    }

    private static final long m216timesWZ4Q5Ns(long arg0, int other) {
        return m178constructorimpl(m178constructorimpl(((long) other) & 4294967295L) * arg0);
    }

    private static final long m215timesVKZWuLQ(long arg0, long other) {
        return m178constructorimpl(arg0 * other);
    }

    private static final long m180div7apg3OU(long arg0, byte other) {
        return Long.divideUnsigned(arg0, m178constructorimpl(((long) other) & 255));
    }

    private static final long m183divxj2QHRw(long arg0, short other) {
        return Long.divideUnsigned(arg0, m178constructorimpl(((long) other) & 65535));
    }

    private static final long m182divWZ4Q5Ns(long arg0, int other) {
        return Long.divideUnsigned(arg0, m178constructorimpl(((long) other) & 4294967295L));
    }

    private static final long m181divVKZWuLQ(long arg0, long other) {
        return UnsignedKt.m357ulongDivideeb3DHEI(arg0, other);
    }

    private static final long m208rem7apg3OU(long arg0, byte other) {
        return Long.remainderUnsigned(arg0, m178constructorimpl(((long) other) & 255));
    }

    private static final long m211remxj2QHRw(long arg0, short other) {
        return Long.remainderUnsigned(arg0, m178constructorimpl(((long) other) & 65535));
    }

    private static final long m210remWZ4Q5Ns(long arg0, int other) {
        return Long.remainderUnsigned(arg0, m178constructorimpl(((long) other) & 4294967295L));
    }

    private static final long m209remVKZWuLQ(long arg0, long other) {
        return UnsignedKt.m358ulongRemaindereb3DHEI(arg0, other);
    }

    private static final long m186floorDiv7apg3OU(long arg0, byte other) {
        return Long.divideUnsigned(arg0, m178constructorimpl(((long) other) & 255));
    }

    private static final long m189floorDivxj2QHRw(long arg0, short other) {
        return Long.divideUnsigned(arg0, m178constructorimpl(((long) other) & 65535));
    }

    private static final long m188floorDivWZ4Q5Ns(long arg0, int other) {
        return Long.divideUnsigned(arg0, m178constructorimpl(((long) other) & 4294967295L));
    }

    private static final long m187floorDivVKZWuLQ(long arg0, long other) {
        return Long.divideUnsigned(arg0, other);
    }

    private static final byte m197mod7apg3OU(long arg0, byte other) {
        return UByte.m22constructorimpl((byte) Long.remainderUnsigned(arg0, m178constructorimpl(((long) other) & 255)));
    }

    private static final short m200modxj2QHRw(long arg0, short other) {
        return UShort.m285constructorimpl((short) Long.remainderUnsigned(arg0, m178constructorimpl(((long) other) & 65535)));
    }

    private static final int m199modWZ4Q5Ns(long arg0, int other) {
        return UInt.m99constructorimpl((int) Long.remainderUnsigned(arg0, m178constructorimpl(((long) other) & 4294967295L)));
    }

    private static final long m198modVKZWuLQ(long arg0, long other) {
        return Long.remainderUnsigned(arg0, other);
    }

    private static final long m191incsVKNKU(long arg0) {
        return m178constructorimpl(1 + arg0);
    }

    private static final long m179decsVKNKU(long arg0) {
        return m178constructorimpl((-1) + arg0);
    }

    private static final ULongRange m206rangeToVKZWuLQ(long arg0, long other) {
        return new ULongRange(arg0, other, null);
    }

    private static final ULongRange m207rangeUntilVKZWuLQ(long arg0, long other) {
        return URangesKt.m1290untileb3DHEI(arg0, other);
    }

    private static final long m212shlsVKNKU(long arg0, int bitCount) {
        return m178constructorimpl(arg0 << bitCount);
    }

    private static final long m213shrsVKNKU(long arg0, int bitCount) {
        return m178constructorimpl(arg0 >>> bitCount);
    }

    private static final long m171andVKZWuLQ(long arg0, long other) {
        return m178constructorimpl(arg0 & other);
    }

    private static final long m201orVKZWuLQ(long arg0, long other) {
        return m178constructorimpl(arg0 | other);
    }

    private static final long m229xorVKZWuLQ(long arg0, long other) {
        return m178constructorimpl(arg0 ^ other);
    }

    private static final long m192invsVKNKU(long arg0) {
        return m178constructorimpl(~arg0);
    }

    private static final byte m218toByteimpl(long arg0) {
        return (byte) arg0;
    }

    private static final short m223toShortimpl(long arg0) {
        return (short) arg0;
    }

    private static final int m221toIntimpl(long arg0) {
        return (int) arg0;
    }

    private static final long m222toLongimpl(long arg0) {
        return arg0;
    }

    private static final byte m225toUBytew2LRezQ(long arg0) {
        return UByte.m22constructorimpl((byte) arg0);
    }

    private static final short m228toUShortMh2AYeg(long arg0) {
        return UShort.m285constructorimpl((short) arg0);
    }

    private static final int m226toUIntpVg5ArA(long arg0) {
        return UInt.m99constructorimpl((int) arg0);
    }

    private static final long m227toULongsVKNKU(long arg0) {
        return arg0;
    }

    private static final float m220toFloatimpl(long arg0) {
        return (float) UnsignedKt.ulongToDouble(arg0);
    }

    private static final double m219toDoubleimpl(long arg0) {
        return UnsignedKt.ulongToDouble(arg0);
    }

    public static String m224toStringimpl(long arg0) {
        return UnsignedKt.ulongToString(arg0, 10);
    }

    public String toString() {
        return m224toStringimpl(this.data);
    }
}
