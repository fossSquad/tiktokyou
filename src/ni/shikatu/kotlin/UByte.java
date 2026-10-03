package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.UIntRange;
import ni.shikatu.kotlin.ranges.URangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u000eJ!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0012J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b \u0010\u000eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0012J!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u0015J!\u0010\u001f\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b#\u0010\u001eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b%\u0010\u000eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0012J!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b'\u0010\u0015J!\u0010$\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b(\u0010\u001eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b*\u0010\u000eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0012J!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b,\u0010\u0015J!\u0010)\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b-\u0010\u001eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b/\u0010\u000eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0012J!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b1\u0010\u0015J!\u0010.\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b2\u0010\u001eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b4\u0010\u000eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0012J!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b6\u0010\u0015J!\u00103\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b7\u0010\u001eJ!\u00108\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b9\u0010:J!\u00108\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b;\u0010<J!\u00108\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b=\u0010\u0015J!\u00108\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b>\u0010\u001eJ\u0015\u0010?\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\b@\u0010\u0005J\u0015\u0010A\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bB\u0010\u0005J\u001d\u0010C\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bE\u0010FJ=\u0010G\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bI\u0012\b\bJ\u0012\u0004\b\b(Kb\u0010\bL\u0012\f\bM\u0012\b\b\fJ\u0004\b\t0Nb\u0002\b\u000f¢\u0006\u0004\bH\u0010FJ!\u0010O\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bP\u0010:J!\u0010Q\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bR\u0010:J!\u0010S\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bT\u0010:J\u0019\u0010U\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0005J\u0019\u0010W\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bX\u0010\u0005J\u0019\u0010Y\u001a\u00020ZH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b[\u0010\\J\u0019\u0010]\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b^\u0010_J\u0019\u0010`\u001a\u00020aH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bb\u0010cJ\u0019\u0010d\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\be\u0010\u0005J\u0019\u0010f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bg\u0010\\J\u0019\u0010h\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bi\u0010_J\u0019\u0010j\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bk\u0010cJ\u0019\u0010l\u001a\u00020mH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bn\u0010oJ\u0019\u0010p\u001a\u00020qH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\br\u0010sJ\u0015\u0010t\u001a\u00020uH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\bv\u0010wJ\u0014\u0010x\u001a\u00020y2\b\u0010\f\u001a\u0004\u0018\u00010zHÖ\u0083\u0004J\n\u0010{\u001a\u00020\u000bHÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\f\bI\u0012\b\bJ\u0012\u0004\b\b(~Ê\u0001\u0002\b\u007f¨\u0006}"}, d2 = {"Lni/shikatu/kotlin/UByte;", _UrlKt.FRAGMENT_ENCODE_SET, "data", _UrlKt.FRAGMENT_ENCODE_SET, "constructor-impl", "(B)B", "Lni/shikatu/kotlin/internal/IntrinsicConstEvaluation;", "Lni/shikatu/kotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", _UrlKt.FRAGMENT_ENCODE_SET, "other", "compareTo-7apg3OU", "(BB)I", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "Lni/shikatu/kotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lni/shikatu/kotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(BJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(BB)B", "mod-xj2QHRw", "(BS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-w2LRezQ", "dec", "dec-w2LRezQ", "rangeTo", "Lni/shikatu/kotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "and", "and-7apg3OU", "or", "or-7apg3OU", "xor", "xor-7apg3OU", "inv", "inv-w2LRezQ", "toByte", "toByte-impl", "toShort", _UrlKt.FRAGMENT_ENCODE_SET, "toShort-impl", "(B)S", "toInt", "toInt-impl", "(B)I", "toLong", _UrlKt.FRAGMENT_ENCODE_SET, "toLong-impl", "(B)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", _UrlKt.FRAGMENT_ENCODE_SET, "toFloat-impl", "(B)F", "toDouble", _UrlKt.FRAGMENT_ENCODE_SET, "toDouble-impl", "(B)D", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "toString-impl", "(B)Ljava/lang/String;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "Companion", "ni.shikatu.kotlin-stdlib", "1.5", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    public static final  UByte m18boximpl(byte b) {
        return new UByte(b);
    }

    public static byte m24constructorimpl(byte b) {
        return b;
    }

    public static boolean m30equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m74unboximpl();
    }

    public static final boolean m31equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static  void getData$annotations() {
    }

    public static int m36hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    public boolean equals(Object obj) {
        return m30equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m36hashCodeimpl(this.data);
    }

    public final  byte m74unboximpl() {
        return this.data;
    }

    @Override
    public /* bridge */  int compareTo(UByte uByte) {
        return Intrinsics.compare(m74unboximpl() & MAX_VALUE, uByte.m74unboximpl() & MAX_VALUE);
    }

    private  UByte(byte data) {
        this.data = data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/UByte$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MIN_VALUE", "Lni/shikatu/kotlin/UByte;", "B", "MAX_VALUE", "SIZE_BYTES", _UrlKt.FRAGMENT_ENCODE_SET, "SIZE_BITS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private int m19compareTo7apg3OU(byte other) {
        return Intrinsics.compare(m74unboximpl() & MAX_VALUE, other & MAX_VALUE);
    }

    private static int m20compareTo7apg3OU(byte arg0, byte other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, other & MAX_VALUE);
    }

    private static final int m23compareToxj2QHRw(byte arg0, short other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, 65535 & other);
    }

    private static final int m22compareToWZ4Q5Ns(byte arg0, int other) {
        return Integer.compareUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final int m21compareToVKZWuLQ(byte arg0, long other) {
        return Long.compareUnsigned(ULong.m180constructorimpl(((long) arg0) & 255), other);
    }

    private static final int m48plus7apg3OU(byte arg0, byte other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) + UInt.m101constructorimpl(other & MAX_VALUE));
    }

    private static final int m51plusxj2QHRw(byte arg0, short other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) + UInt.m101constructorimpl(65535 & other));
    }

    private static final int m50plusWZ4Q5Ns(byte arg0, int other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) + other);
    }

    private static final long m49plusVKZWuLQ(byte arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & 255) + other);
    }

    private static final int m39minus7apg3OU(byte arg0, byte other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) - UInt.m101constructorimpl(other & MAX_VALUE));
    }

    private static final int m42minusxj2QHRw(byte arg0, short other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) - UInt.m101constructorimpl(65535 & other));
    }

    private static final int m41minusWZ4Q5Ns(byte arg0, int other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) - other);
    }

    private static final long m40minusVKZWuLQ(byte arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & 255) - other);
    }

    private static final int m58times7apg3OU(byte arg0, byte other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) * UInt.m101constructorimpl(other & MAX_VALUE));
    }

    private static final int m61timesxj2QHRw(byte arg0, short other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) * UInt.m101constructorimpl(65535 & other));
    }

    private static final int m60timesWZ4Q5Ns(byte arg0, int other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) * other);
    }

    private static final long m59timesVKZWuLQ(byte arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & 255) * other);
    }

    private static final int m26div7apg3OU(byte arg0, byte other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(other & MAX_VALUE));
    }

    private static final int m29divxj2QHRw(byte arg0, short other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other));
    }

    private static final int m28divWZ4Q5Ns(byte arg0, int other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final long m27divVKZWuLQ(byte arg0, long other) {
        return Long.divideUnsigned(ULong.m180constructorimpl(((long) arg0) & 255), other);
    }

    private static final int m54rem7apg3OU(byte arg0, byte other) {
        return Integer.remainderUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(other & MAX_VALUE));
    }

    private static final int m57remxj2QHRw(byte arg0, short other) {
        return Integer.remainderUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other));
    }

    private static final int m56remWZ4Q5Ns(byte arg0, int other) {
        return Integer.remainderUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final long m55remVKZWuLQ(byte arg0, long other) {
        return Long.remainderUnsigned(ULong.m180constructorimpl(((long) arg0) & 255), other);
    }

    private static final int m32floorDiv7apg3OU(byte arg0, byte other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(other & MAX_VALUE));
    }

    private static final int m35floorDivxj2QHRw(byte arg0, short other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other));
    }

    private static final int m34floorDivWZ4Q5Ns(byte arg0, int other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final long m33floorDivVKZWuLQ(byte arg0, long other) {
        return Long.divideUnsigned(ULong.m180constructorimpl(((long) arg0) & 255), other);
    }

    private static final byte m43mod7apg3OU(byte arg0, byte other) {
        return m24constructorimpl((byte) Integer.remainderUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(other & MAX_VALUE)));
    }

    private static final short m46modxj2QHRw(byte arg0, short other) {
        return UShort.m287constructorimpl((short) Integer.remainderUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other)));
    }

    private static final int m45modWZ4Q5Ns(byte arg0, int other) {
        return Integer.remainderUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), other);
    }

    private static final long m44modVKZWuLQ(byte arg0, long other) {
        return Long.remainderUnsigned(ULong.m180constructorimpl(((long) arg0) & 255), other);
    }

    private static final byte m37incw2LRezQ(byte arg0) {
        return m24constructorimpl((byte) (arg0 + 1));
    }

    private static final byte m25decw2LRezQ(byte arg0) {
        return m24constructorimpl((byte) (arg0 - 1));
    }

    private static final UIntRange m52rangeTo7apg3OU(byte arg0, byte other) {
        return new UIntRange(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(other & MAX_VALUE), null);
    }

    private static final UIntRange m53rangeUntil7apg3OU(byte arg0, byte other) {
        return URangesKt.m1310untilJ1ME1BU(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(other & MAX_VALUE));
    }

    private static final byte m17and7apg3OU(byte arg0, byte other) {
        return m24constructorimpl((byte) (arg0 & other));
    }

    private static final byte m47or7apg3OU(byte arg0, byte other) {
        return m24constructorimpl((byte) (arg0 | other));
    }

    private static final byte m73xor7apg3OU(byte arg0, byte other) {
        return m24constructorimpl((byte) (arg0 ^ other));
    }

    private static final byte m38invw2LRezQ(byte arg0) {
        return m24constructorimpl((byte) (~arg0));
    }

    private static final byte m62toByteimpl(byte arg0) {
        return arg0;
    }

    private static final short m67toShortimpl(byte arg0) {
        return (short) (arg0 & 255);
    }

    private static final int m65toIntimpl(byte arg0) {
        return arg0 & MAX_VALUE;
    }

    private static final long m66toLongimpl(byte arg0) {
        return ((long) arg0) & 255;
    }

    private static final byte m69toUBytew2LRezQ(byte arg0) {
        return arg0;
    }

    private static final short m72toUShortMh2AYeg(byte arg0) {
        return UShort.m287constructorimpl((short) (arg0 & 255));
    }

    private static final int m70toUIntpVg5ArA(byte arg0) {
        return UInt.m101constructorimpl(arg0 & MAX_VALUE);
    }

    private static final long m71toULongsVKNKU(byte arg0) {
        return ULong.m180constructorimpl(((long) arg0) & 255);
    }

    private static final float m64toFloatimpl(byte arg0) {
        return (float) UnsignedKt.uintToDouble(arg0 & MAX_VALUE);
    }

    private static final double m63toDoubleimpl(byte arg0) {
        return UnsignedKt.uintToDouble(arg0 & MAX_VALUE);
    }

    public static String m68toStringimpl(byte arg0) {
        return String.valueOf(arg0 & MAX_VALUE);
    }

    public String toString() {
        return m68toStringimpl(this.data);
    }
}
