package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.ranges.UIntRange;
import ni.shikatu.kotlin.ranges.URangesKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001xB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u0016\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u0017\u0010\u000fJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0018\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u001c\u0010\fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u001d\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001e\u0010\u0011J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u001f\u0010\u001aJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b!\u0010\fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\"\u0010\u000fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u0011J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b$\u0010\u001aJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b&\u0010\fJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b'\u0010\u000fJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u0011J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b)\u0010\u001aJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b+\u0010\fJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b,\u0010\u000fJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u0011J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b.\u0010\u001aJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\b¢\u0006\u0004\b0\u0010\fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b1\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b2\u0010\u0011J\u0018\u0010/\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b3\u0010\u001aJ\u0018\u00104\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0087\b¢\u0006\u0004\b5\u00106J\u0018\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b7\u00108J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b9\u0010\u0011J\u0018\u00104\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b:\u0010\u001aJ\u0010\u0010;\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b<\u0010\u0005J\u0010\u0010=\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b>\u0010\u0005J\u0018\u0010?\u001a\u00020@2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bA\u0010BJ\u0018\u0010C\u001a\u00020@2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bD\u0010BJ\u0018\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0087\f¢\u0006\u0004\bG\u0010\u0011J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0087\f¢\u0006\u0004\bI\u0010\u0011J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bK\u0010\u0011J\u0018\u0010L\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bM\u0010\u0011J\u0018\u0010N\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bO\u0010\u0011J\u0010\u0010P\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bQ\u0010\u0005J\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b[\u0010\u0005J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\nH\u0087\b¢\u0006\u0004\ba\u0010UJ\u0010\u0010b\u001a\u00020\rH\u0087\b¢\u0006\u0004\bc\u0010YJ\u0010\u0010d\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\be\u0010\u0005J\u0010\u0010f\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\bg\u0010_J\u0010\u0010h\u001a\u00020iH\u0087\b¢\u0006\u0004\bj\u0010kJ\u0010\u0010l\u001a\u00020mH\u0087\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ\u0013\u0010t\u001a\u00020u2\b\u0010\t\u001a\u0004\u0018\u00010vHÖ\u0003J\t\u0010w\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006y"}, d2 = {"Lni/shikatu/kotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "compareTo", "other", "Lni/shikatu/kotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "Lni/shikatu/kotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "compareTo-WZ4Q5Ns", "(II)I", "Lni/shikatu/kotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(IJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(IB)B", "mod-xj2QHRw", "(IS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-pVg5ArA", "dec", "dec-pVg5ArA", "rangeTo", "Lni/shikatu/kotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "and", "and-WZ4Q5Ns", "or", "or-WZ4Q5Ns", "xor", "xor-WZ4Q5Ns", "inv", "inv-pVg5ArA", "toByte", "", "toByte-impl", "(I)B", "toShort", "", "toShort-impl", "(I)S", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(I)F", "toDouble", "", "toDouble-impl", "(I)D", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    public static final  UInt m93boximpl(int i) {
        return new UInt(i);
    }

    public static int m99constructorimpl(int i) {
        return i;
    }

    public static boolean m105equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m151unboximpl();
    }

    public static final boolean m106equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static  void getData$annotations() {
    }

    public static int m111hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m105equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m111hashCodeimpl(this.data);
    }

    public final  int m151unboximpl() {
        return this.data;
    }

    @Override
    public /* bridge */  int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(m151unboximpl(), uInt.m151unboximpl());
    }

    private  UInt(int data) {
        this.data = data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/UInt$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lni/shikatu/kotlin/UInt;", "I", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final int m94compareTo7apg3OU(int arg0, byte other) {
        return Integer.compareUnsigned(arg0, m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m98compareToxj2QHRw(int arg0, short other) {
        return Integer.compareUnsigned(arg0, m99constructorimpl(65535 & other));
    }

    private int m96compareToWZ4Q5Ns(int other) {
        return UnsignedKt.uintCompare(m151unboximpl(), other);
    }

    private static int m97compareToWZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.uintCompare(arg0, other);
    }

    private static final int m95compareToVKZWuLQ(int arg0, long other) {
        return Long.compareUnsigned(ULong.m178constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final int m123plus7apg3OU(int arg0, byte other) {
        return m99constructorimpl(m99constructorimpl(other & UByte.MAX_VALUE) + arg0);
    }

    private static final int m126plusxj2QHRw(int arg0, short other) {
        return m99constructorimpl(m99constructorimpl(65535 & other) + arg0);
    }

    private static final int m125plusWZ4Q5Ns(int arg0, int other) {
        return m99constructorimpl(arg0 + other);
    }

    private static final long m124plusVKZWuLQ(int arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 4294967295L) + other);
    }

    private static final int m114minus7apg3OU(int arg0, byte other) {
        return m99constructorimpl(arg0 - m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m117minusxj2QHRw(int arg0, short other) {
        return m99constructorimpl(arg0 - m99constructorimpl(65535 & other));
    }

    private static final int m116minusWZ4Q5Ns(int arg0, int other) {
        return m99constructorimpl(arg0 - other);
    }

    private static final long m115minusVKZWuLQ(int arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 4294967295L) - other);
    }

    private static final int m135times7apg3OU(int arg0, byte other) {
        return m99constructorimpl(m99constructorimpl(other & UByte.MAX_VALUE) * arg0);
    }

    private static final int m138timesxj2QHRw(int arg0, short other) {
        return m99constructorimpl(m99constructorimpl(65535 & other) * arg0);
    }

    private static final int m137timesWZ4Q5Ns(int arg0, int other) {
        return m99constructorimpl(arg0 * other);
    }

    private static final long m136timesVKZWuLQ(int arg0, long other) {
        return ULong.m178constructorimpl(ULong.m178constructorimpl(((long) arg0) & 4294967295L) * other);
    }

    private static final int m101div7apg3OU(int arg0, byte other) {
        return Integer.divideUnsigned(arg0, m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m104divxj2QHRw(int arg0, short other) {
        return Integer.divideUnsigned(arg0, m99constructorimpl(65535 & other));
    }

    private static final int m103divWZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.m355uintDivideJ1ME1BU(arg0, other);
    }

    private static final long m102divVKZWuLQ(int arg0, long other) {
        return Long.divideUnsigned(ULong.m178constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final int m129rem7apg3OU(int arg0, byte other) {
        return Integer.remainderUnsigned(arg0, m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m132remxj2QHRw(int arg0, short other) {
        return Integer.remainderUnsigned(arg0, m99constructorimpl(65535 & other));
    }

    private static final int m131remWZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.m356uintRemainderJ1ME1BU(arg0, other);
    }

    private static final long m130remVKZWuLQ(int arg0, long other) {
        return Long.remainderUnsigned(ULong.m178constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final int m107floorDiv7apg3OU(int arg0, byte other) {
        return Integer.divideUnsigned(arg0, m99constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m110floorDivxj2QHRw(int arg0, short other) {
        return Integer.divideUnsigned(arg0, m99constructorimpl(65535 & other));
    }

    private static final int m109floorDivWZ4Q5Ns(int arg0, int other) {
        return Integer.divideUnsigned(arg0, other);
    }

    private static final long m108floorDivVKZWuLQ(int arg0, long other) {
        return Long.divideUnsigned(ULong.m178constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final byte m118mod7apg3OU(int arg0, byte other) {
        return UByte.m22constructorimpl((byte) Integer.remainderUnsigned(arg0, m99constructorimpl(other & UByte.MAX_VALUE)));
    }

    private static final short m121modxj2QHRw(int arg0, short other) {
        return UShort.m285constructorimpl((short) Integer.remainderUnsigned(arg0, m99constructorimpl(65535 & other)));
    }

    private static final int m120modWZ4Q5Ns(int arg0, int other) {
        return Integer.remainderUnsigned(arg0, other);
    }

    private static final long m119modVKZWuLQ(int arg0, long other) {
        return Long.remainderUnsigned(ULong.m178constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final int m112incpVg5ArA(int arg0) {
        return m99constructorimpl(arg0 + 1);
    }

    private static final int m100decpVg5ArA(int arg0) {
        return m99constructorimpl(arg0 - 1);
    }

    private static final UIntRange m127rangeToWZ4Q5Ns(int arg0, int other) {
        return new UIntRange(arg0, other, null);
    }

    private static final UIntRange m128rangeUntilWZ4Q5Ns(int arg0, int other) {
        return URangesKt.m1288untilJ1ME1BU(arg0, other);
    }

    private static final int m133shlpVg5ArA(int arg0, int bitCount) {
        return m99constructorimpl(arg0 << bitCount);
    }

    private static final int m134shrpVg5ArA(int arg0, int bitCount) {
        return m99constructorimpl(arg0 >>> bitCount);
    }

    private static final int m92andWZ4Q5Ns(int arg0, int other) {
        return m99constructorimpl(arg0 & other);
    }

    private static final int m122orWZ4Q5Ns(int arg0, int other) {
        return m99constructorimpl(arg0 | other);
    }

    private static final int m150xorWZ4Q5Ns(int arg0, int other) {
        return m99constructorimpl(arg0 ^ other);
    }

    private static final int m113invpVg5ArA(int arg0) {
        return m99constructorimpl(~arg0);
    }

    private static final byte m139toByteimpl(int arg0) {
        return (byte) arg0;
    }

    private static final short m144toShortimpl(int arg0) {
        return (short) arg0;
    }

    private static final int m142toIntimpl(int arg0) {
        return arg0;
    }

    private static final long m143toLongimpl(int arg0) {
        return ((long) arg0) & 4294967295L;
    }

    private static final byte m146toUBytew2LRezQ(int arg0) {
        return UByte.m22constructorimpl((byte) arg0);
    }

    private static final short m149toUShortMh2AYeg(int arg0) {
        return UShort.m285constructorimpl((short) arg0);
    }

    private static final int m147toUIntpVg5ArA(int arg0) {
        return arg0;
    }

    private static final long m148toULongsVKNKU(int arg0) {
        return ULong.m178constructorimpl(((long) arg0) & 4294967295L);
    }

    private static final float m141toFloatimpl(int arg0) {
        return (float) UnsignedKt.uintToDouble(arg0);
    }

    private static final double m140toDoubleimpl(int arg0) {
        return UnsignedKt.uintToDouble(arg0);
    }

    public static String m145toStringimpl(int arg0) {
        return String.valueOf(((long) arg0) & 4294967295L);
    }

    public String toString() {
        return m145toStringimpl(this.data);
    }
}
