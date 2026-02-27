package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.UIntRange;
import ni.shikatu.kotlin.ranges.URangesKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u0017\u0010\rJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0018\u0010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0019\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u001d\u0010\rJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001e\u0010\u000fJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u001f\u0010\u0012J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b \u0010\u001bJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\"\u0010\rJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u000fJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b$\u0010\u0012J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u001bJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b'\u0010\rJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b)\u0010\u0012J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b*\u0010\u001bJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b,\u0010\rJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u000fJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b.\u0010\u0012J\u0018\u0010+\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b/\u0010\u001bJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b1\u0010\rJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b2\u0010\u000fJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b3\u0010\u0012J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b4\u0010\u001bJ\u0018\u00105\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b6\u00107J\u0018\u00105\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00105\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b:\u0010\u0012J\u0018\u00105\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b;\u0010\u001bJ\u0010\u0010<\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b=\u0010\u0005J\u0010\u0010>\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b?\u0010\u0005J\u0018\u0010@\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010CJ\u0018\u0010F\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bG\u00109J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bI\u00109J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bK\u00109J\u0010\u0010L\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bM\u0010\u0005J\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020\tH\u0087\b¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\\\u0010QJ\u0010\u0010]\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b^\u0010\u0005J\u0010\u0010_\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b`\u0010VJ\u0010\u0010a\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\bb\u0010ZJ\u0010\u0010c\u001a\u00020dH\u0087\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0013\u0010o\u001a\u00020p2\b\u0010\n\u001a\u0004\u0018\u00010qHÖ\u0003J\t\u0010r\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2 = {"Lni/shikatu/kotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "compareTo", "", "other", "Lni/shikatu/kotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "compareTo-xj2QHRw", "(SS)I", "Lni/shikatu/kotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lni/shikatu/kotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(SB)B", "mod-xj2QHRw", "(SS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-Mh2AYeg", "dec", "dec-Mh2AYeg", "rangeTo", "Lni/shikatu/kotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "and", "and-xj2QHRw", "or", "or-xj2QHRw", "xor", "xor-xj2QHRw", "inv", "inv-Mh2AYeg", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(S)F", "toDouble", "", "toDouble-impl", "(S)D", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    public static final  UShort m279boximpl(short s) {
        return new UShort(s);
    }

    public static short m285constructorimpl(short s) {
        return s;
    }

    public static boolean m291equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m335unboximpl();
    }

    public static final boolean m292equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static  void getData$annotations() {
    }

    public static int m297hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    public boolean equals(Object obj) {
        return m291equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m297hashCodeimpl(this.data);
    }

    public final  short m335unboximpl() {
        return this.data;
    }

    @Override
    public /* bridge */  int compareTo(UShort uShort) {
        return Intrinsics.compare(m335unboximpl() & MAX_VALUE, uShort.m335unboximpl() & MAX_VALUE);
    }

    private  UShort(short data) {
        this.data = data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/UShort$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lni/shikatu/kotlin/UShort;", "S", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final int m280compareTo7apg3OU(short arg0, byte other) {
        return Intrinsics.compare(65535 & arg0, other & UByte.MAX_VALUE);
    }

    private int m283compareToxj2QHRw(short other) {
        return Intrinsics.compare(m335unboximpl() & MAX_VALUE, 65535 & other);
    }

    private static int m284compareToxj2QHRw(short arg0, short other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, 65535 & other);
    }

    private static final int m282compareToWZ4Q5Ns(short arg0, int other) {
        return Integer.compareUnsigned(UInt.m99constructorimpl(65535 & arg0), other);
    }

    private static final int m281compareToVKZWuLQ(short arg0, long other) {
        return Long.compareUnsigned(ULong.m178constructorimpl(((long) arg0) & 65535), other);
    }

    private static final int m309plus7apg3OU(short arg0, byte other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(65535 & arg0) + UInt.m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m312plusxj2QHRw(short arg0, short other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) + UInt.m99constructorimpl(65535 & other));
    }

    private static final int m311plusWZ4Q5Ns(short arg0, int other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(65535 & arg0) + other);
    }

    private static final long m310plusVKZWuLQ(short arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 65535) + other);
    }

    private static final int m300minus7apg3OU(short arg0, byte other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(65535 & arg0) - UInt.m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m303minusxj2QHRw(short arg0, short other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) - UInt.m99constructorimpl(65535 & other));
    }

    private static final int m302minusWZ4Q5Ns(short arg0, int other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(65535 & arg0) - other);
    }

    private static final long m301minusVKZWuLQ(short arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 65535) - other);
    }

    private static final int m319times7apg3OU(short arg0, byte other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(65535 & arg0) * UInt.m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m322timesxj2QHRw(short arg0, short other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) * UInt.m99constructorimpl(65535 & other));
    }

    private static final int m321timesWZ4Q5Ns(short arg0, int other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(65535 & arg0) * other);
    }

    private static final long m320timesVKZWuLQ(short arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 65535) * other);
    }

    private static final int m287div7apg3OU(short arg0, byte other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(65535 & arg0), UInt.m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m290divxj2QHRw(short arg0, short other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other));
    }

    private static final int m289divWZ4Q5Ns(short arg0, int other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(65535 & arg0), other);
    }

    private static final long m288divVKZWuLQ(short arg0, long other) {
        return Long.divideUnsigned(ULong.m178constructorimpl(((long) arg0) & 65535), other);
    }

    private static final int m315rem7apg3OU(short arg0, byte other) {
        return Integer.remainderUnsigned(UInt.m99constructorimpl(65535 & arg0), UInt.m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m318remxj2QHRw(short arg0, short other) {
        return Integer.remainderUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other));
    }

    private static final int m317remWZ4Q5Ns(short arg0, int other) {
        return Integer.remainderUnsigned(UInt.m99constructorimpl(65535 & arg0), other);
    }

    private static final long m316remVKZWuLQ(short arg0, long other) {
        return Long.remainderUnsigned(ULong.m178constructorimpl(((long) arg0) & 65535), other);
    }

    private static final int m293floorDiv7apg3OU(short arg0, byte other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(65535 & arg0), UInt.m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m296floorDivxj2QHRw(short arg0, short other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other));
    }

    private static final int m295floorDivWZ4Q5Ns(short arg0, int other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(65535 & arg0), other);
    }

    private static final long m294floorDivVKZWuLQ(short arg0, long other) {
        return Long.divideUnsigned(ULong.m178constructorimpl(((long) arg0) & 65535), other);
    }

    private static final byte m304mod7apg3OU(short arg0, byte other) {
        return UByte.m22constructorimpl((byte) Integer.remainderUnsigned(UInt.m99constructorimpl(65535 & arg0), UInt.m99constructorimpl(other & UByte.MAX_VALUE)));
    }

    private static final short m307modxj2QHRw(short arg0, short other) {
        return m285constructorimpl((short) Integer.remainderUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other)));
    }

    private static final int m306modWZ4Q5Ns(short arg0, int other) {
        return Integer.remainderUnsigned(UInt.m99constructorimpl(65535 & arg0), other);
    }

    private static final long m305modVKZWuLQ(short arg0, long other) {
        return Long.remainderUnsigned(ULong.m178constructorimpl(((long) arg0) & 65535), other);
    }

    private static final short m298incMh2AYeg(short arg0) {
        return m285constructorimpl((short) (arg0 + 1));
    }

    private static final short m286decMh2AYeg(short arg0) {
        return m285constructorimpl((short) (arg0 - 1));
    }

    private static final UIntRange m313rangeToxj2QHRw(short arg0, short other) {
        return new UIntRange(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other), null);
    }

    private static final UIntRange m314rangeUntilxj2QHRw(short arg0, short other) {
        return URangesKt.m1288untilJ1ME1BU(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other));
    }

    private static final short m278andxj2QHRw(short arg0, short other) {
        return m285constructorimpl((short) (arg0 & other));
    }

    private static final short m308orxj2QHRw(short arg0, short other) {
        return m285constructorimpl((short) (arg0 | other));
    }

    private static final short m334xorxj2QHRw(short arg0, short other) {
        return m285constructorimpl((short) (arg0 ^ other));
    }

    private static final short m299invMh2AYeg(short arg0) {
        return m285constructorimpl((short) (~arg0));
    }

    private static final byte m323toByteimpl(short arg0) {
        return (byte) arg0;
    }

    private static final short m328toShortimpl(short arg0) {
        return arg0;
    }

    private static final int m326toIntimpl(short arg0) {
        return 65535 & arg0;
    }

    private static final long m327toLongimpl(short arg0) {
        return ((long) arg0) & 65535;
    }

    private static final byte m330toUBytew2LRezQ(short arg0) {
        return UByte.m22constructorimpl((byte) arg0);
    }

    private static final short m333toUShortMh2AYeg(short arg0) {
        return arg0;
    }

    private static final int m331toUIntpVg5ArA(short arg0) {
        return UInt.m99constructorimpl(65535 & arg0);
    }

    private static final long m332toULongsVKNKU(short arg0) {
        return ULong.m178constructorimpl(((long) arg0) & 65535);
    }

    private static final float m325toFloatimpl(short arg0) {
        return (float) UnsignedKt.uintToDouble(65535 & arg0);
    }

    private static final double m324toDoubleimpl(short arg0) {
        return UnsignedKt.uintToDouble(65535 & arg0);
    }

    public static String m329toStringimpl(short arg0) {
        return String.valueOf(65535 & arg0);
    }

    public String toString() {
        return m329toStringimpl(this.data);
    }
}
