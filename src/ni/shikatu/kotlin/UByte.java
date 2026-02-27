package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.UIntRange;
import ni.shikatu.kotlin.ranges.URangesKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0017\u0010\fJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u0018\u0010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0019\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001d\u0010\fJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u001e\u0010\u000fJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u001f\u0010\u0012J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b \u0010\u001bJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\"\u0010\fJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b#\u0010\u000fJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b$\u0010\u0012J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u001bJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b'\u0010\fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b(\u0010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b)\u0010\u0012J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b*\u0010\u001bJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b,\u0010\fJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b-\u0010\u000fJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b.\u0010\u0012J\u0018\u0010+\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b/\u0010\u001bJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b1\u0010\fJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\b¢\u0006\u0004\b2\u0010\u000fJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b3\u0010\u0012J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b4\u0010\u001bJ\u0018\u00105\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b6\u00107J\u0018\u00105\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00105\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b:\u0010\u0012J\u0018\u00105\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b;\u0010\u001bJ\u0010\u0010<\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b=\u0010\u0005J\u0010\u0010>\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b?\u0010\u0005J\u0018\u0010@\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010CJ\u0018\u0010F\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bG\u00107J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bI\u00107J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bK\u00107J\u0010\u0010L\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bM\u0010\u0005J\u0010\u0010N\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bO\u0010\u0005J\u0010\u0010P\u001a\u00020QH\u0087\b¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020\tH\u0087\b¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\\\u0010\u0005J\u0010\u0010]\u001a\u00020\rH\u0087\b¢\u0006\u0004\b^\u0010SJ\u0010\u0010_\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b`\u0010VJ\u0010\u0010a\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\bb\u0010ZJ\u0010\u0010c\u001a\u00020dH\u0087\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0013\u0010o\u001a\u00020p2\b\u0010\n\u001a\u0004\u0018\u00010qHÖ\u0003J\t\u0010r\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2 = {"Lni/shikatu/kotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "compareTo", "", "other", "compareTo-7apg3OU", "(BB)I", "Lni/shikatu/kotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "Lni/shikatu/kotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lni/shikatu/kotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(BJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(BB)B", "mod-xj2QHRw", "(BS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-w2LRezQ", "dec", "dec-w2LRezQ", "rangeTo", "Lni/shikatu/kotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "and", "and-7apg3OU", "or", "or-7apg3OU", "xor", "xor-7apg3OU", "inv", "inv-w2LRezQ", "toByte", "toByte-impl", "toShort", "", "toShort-impl", "(B)S", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(B)F", "toDouble", "", "toDouble-impl", "(B)D", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    public static final  UByte m16boximpl(byte b) {
        return new UByte(b);
    }

    public static byte m22constructorimpl(byte b) {
        return b;
    }

    public static boolean m28equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m72unboximpl();
    }

    public static final boolean m29equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static  void getData$annotations() {
    }

    public static int m34hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    public boolean equals(Object obj) {
        return m28equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m34hashCodeimpl(this.data);
    }

    public final  byte m72unboximpl() {
        return this.data;
    }

    @Override
    public /* bridge */  int compareTo(UByte uByte) {
        return Intrinsics.compare(m72unboximpl() & MAX_VALUE, uByte.m72unboximpl() & MAX_VALUE);
    }

    private  UByte(byte data) {
        this.data = data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/UByte$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lni/shikatu/kotlin/UByte;", "B", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private int m17compareTo7apg3OU(byte other) {
        return Intrinsics.compare(m72unboximpl() & MAX_VALUE, other & MAX_VALUE);
    }

    private static int m18compareTo7apg3OU(byte arg0, byte other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, other & MAX_VALUE);
    }

    private static final int m21compareToxj2QHRw(byte arg0, short other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, 65535 & other);
    }

    private static final int m20compareToWZ4Q5Ns(byte arg0, int other) {
        return Integer.compareUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final int m19compareToVKZWuLQ(byte arg0, long other) {
        return Long.compareUnsigned(ULong.m178constructorimpl(((long) arg0) & 255), other);
    }

    private static final int m46plus7apg3OU(byte arg0, byte other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) + UInt.m99constructorimpl(other & MAX_VALUE));
    }

    private static final int m49plusxj2QHRw(byte arg0, short other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) + UInt.m99constructorimpl(65535 & other));
    }

    private static final int m48plusWZ4Q5Ns(byte arg0, int other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) + other);
    }

    private static final long m47plusVKZWuLQ(byte arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 255) + other);
    }

    private static final int m37minus7apg3OU(byte arg0, byte other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) - UInt.m99constructorimpl(other & MAX_VALUE));
    }

    private static final int m40minusxj2QHRw(byte arg0, short other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) - UInt.m99constructorimpl(65535 & other));
    }

    private static final int m39minusWZ4Q5Ns(byte arg0, int other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) - other);
    }

    private static final long m38minusVKZWuLQ(byte arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 255) - other);
    }

    private static final int m56times7apg3OU(byte arg0, byte other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) * UInt.m99constructorimpl(other & MAX_VALUE));
    }

    private static final int m59timesxj2QHRw(byte arg0, short other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) * UInt.m99constructorimpl(65535 & other));
    }

    private static final int m58timesWZ4Q5Ns(byte arg0, int other) {
        return UInt.m99constructorimpl(UInt.m99constructorimpl(arg0 & MAX_VALUE) * other);
    }

    private static final long m57timesVKZWuLQ(byte arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 255) * other);
    }

    private static final int m24div7apg3OU(byte arg0, byte other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(other & MAX_VALUE));
    }

    private static final int m27divxj2QHRw(byte arg0, short other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other));
    }

    private static final int m26divWZ4Q5Ns(byte arg0, int other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final long m25divVKZWuLQ(byte arg0, long other) {
        return Long.divideUnsigned(ULong.m178constructorimpl(((long) arg0) & 255), other);
    }

    private static final int m52rem7apg3OU(byte arg0, byte other) {
        return Integer.remainderUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(other & MAX_VALUE));
    }

    private static final int m55remxj2QHRw(byte arg0, short other) {
        return Integer.remainderUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other));
    }

    private static final int m54remWZ4Q5Ns(byte arg0, int other) {
        return Integer.remainderUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final long m53remVKZWuLQ(byte arg0, long other) {
        return Long.remainderUnsigned(ULong.m178constructorimpl(((long) arg0) & 255), other);
    }

    private static final int m30floorDiv7apg3OU(byte arg0, byte other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(other & MAX_VALUE));
    }

    private static final int m33floorDivxj2QHRw(byte arg0, short other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other));
    }

    private static final int m32floorDivWZ4Q5Ns(byte arg0, int other) {
        return Integer.divideUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final long m31floorDivVKZWuLQ(byte arg0, long other) {
        return Long.divideUnsigned(ULong.m178constructorimpl(((long) arg0) & 255), other);
    }

    private static final byte m41mod7apg3OU(byte arg0, byte other) {
        return m22constructorimpl((byte) Integer.remainderUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(other & MAX_VALUE)));
    }

    private static final short m44modxj2QHRw(byte arg0, short other) {
        return UShort.m285constructorimpl((short) Integer.remainderUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(65535 & other)));
    }

    private static final int m43modWZ4Q5Ns(byte arg0, int other) {
        return Integer.remainderUnsigned(UInt.m99constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final long m42modVKZWuLQ(byte arg0, long other) {
        return Long.remainderUnsigned(ULong.m178constructorimpl(((long) arg0) & 255), other);
    }

    private static final byte m35incw2LRezQ(byte arg0) {
        return m22constructorimpl((byte) (arg0 + 1));
    }

    private static final byte m23decw2LRezQ(byte arg0) {
        return m22constructorimpl((byte) (arg0 - 1));
    }

    private static final UIntRange m50rangeTo7apg3OU(byte arg0, byte other) {
        return new UIntRange(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(other & MAX_VALUE), null);
    }

    private static final UIntRange m51rangeUntil7apg3OU(byte arg0, byte other) {
        return URangesKt.m1288untilJ1ME1BU(UInt.m99constructorimpl(arg0 & MAX_VALUE), UInt.m99constructorimpl(other & MAX_VALUE));
    }

    private static final byte m15and7apg3OU(byte arg0, byte other) {
        return m22constructorimpl((byte) (arg0 & other));
    }

    private static final byte m45or7apg3OU(byte arg0, byte other) {
        return m22constructorimpl((byte) (arg0 | other));
    }

    private static final byte m71xor7apg3OU(byte arg0, byte other) {
        return m22constructorimpl((byte) (arg0 ^ other));
    }

    private static final byte m36invw2LRezQ(byte arg0) {
        return m22constructorimpl((byte) (~arg0));
    }

    private static final byte m60toByteimpl(byte arg0) {
        return arg0;
    }

    private static final short m65toShortimpl(byte arg0) {
        return (short) (arg0 & 255);
    }

    private static final int m63toIntimpl(byte arg0) {
        return arg0 & MAX_VALUE;
    }

    private static final long m64toLongimpl(byte arg0) {
        return ((long) arg0) & 255;
    }

    private static final byte m67toUBytew2LRezQ(byte arg0) {
        return arg0;
    }

    private static final short m70toUShortMh2AYeg(byte arg0) {
        return UShort.m285constructorimpl((short) (arg0 & 255));
    }

    private static final int m68toUIntpVg5ArA(byte arg0) {
        return UInt.m99constructorimpl(arg0 & MAX_VALUE);
    }

    private static final long m69toULongsVKNKU(byte arg0) {
        return ULong.m178constructorimpl(((long) arg0) & 255);
    }

    private static final float m62toFloatimpl(byte arg0) {
        return (float) UnsignedKt.uintToDouble(arg0 & MAX_VALUE);
    }

    private static final double m61toDoubleimpl(byte arg0) {
        return UnsignedKt.uintToDouble(arg0 & MAX_VALUE);
    }

    public static String m66toStringimpl(byte arg0) {
        return String.valueOf(arg0 & MAX_VALUE);
    }

    public String toString() {
        return m66toStringimpl(this.data);
    }
}
