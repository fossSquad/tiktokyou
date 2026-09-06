package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.UIntRange;
import ni.shikatu.kotlin.ranges.URangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u000fJ!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0012J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b \u0010\u000fJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0012J!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u0015J!\u0010\u001f\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b#\u0010\u001eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b%\u0010\u000fJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0012J!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b'\u0010\u0015J!\u0010$\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b(\u0010\u001eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b*\u0010\u000fJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0012J!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b,\u0010\u0015J!\u0010)\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b-\u0010\u001eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b/\u0010\u000fJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0012J!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b1\u0010\u0015J!\u0010.\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b2\u0010\u001eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b4\u0010\u000fJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0012J!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b6\u0010\u0015J!\u00103\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b7\u0010\u001eJ!\u00108\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b9\u0010:J!\u00108\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b;\u0010<J!\u00108\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b=\u0010\u0015J!\u00108\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b>\u0010\u001eJ\u0015\u0010?\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\b@\u0010\u0005J\u0015\u0010A\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bB\u0010\u0005J\u001d\u0010C\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bE\u0010FJ=\u0010G\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bI\u0012\b\bJ\u0012\u0004\b\b(Kb\u0010\bL\u0012\f\bM\u0012\b\b\fJ\u0004\b\t0Nb\u0002\b\u0010¢\u0006\u0004\bH\u0010FJ!\u0010O\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bP\u0010<J!\u0010Q\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bR\u0010<J!\u0010S\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bT\u0010<J\u0019\u0010U\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0005J\u0019\u0010W\u001a\u00020XH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bY\u0010ZJ\u0019\u0010[\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\\\u0010\u0005J\u0019\u0010]\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b^\u0010_J\u0019\u0010`\u001a\u00020aH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bb\u0010cJ\u0019\u0010d\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\be\u0010ZJ\u0019\u0010f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bg\u0010\u0005J\u0019\u0010h\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bi\u0010_J\u0019\u0010j\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bk\u0010cJ\u0019\u0010l\u001a\u00020mH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bn\u0010oJ\u0019\u0010p\u001a\u00020qH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\br\u0010sJ\u0015\u0010t\u001a\u00020uH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\bv\u0010wJ\u0014\u0010x\u001a\u00020y2\b\u0010\f\u001a\u0004\u0018\u00010zHÖ\u0083\u0004J\n\u0010{\u001a\u00020\u000bHÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\f\bI\u0012\b\bJ\u0012\u0004\b\b(~Ê\u0001\u0002\b\u007f¨\u0006}"}, d2 = {"Lni/shikatu/kotlin/UShort;", _UrlKt.FRAGMENT_ENCODE_SET, "data", _UrlKt.FRAGMENT_ENCODE_SET, "constructor-impl", "(S)S", "Lni/shikatu/kotlin/internal/IntrinsicConstEvaluation;", "Lni/shikatu/kotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", _UrlKt.FRAGMENT_ENCODE_SET, "other", "Lni/shikatu/kotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lni/shikatu/kotlin/internal/InlineOnly;", "compareTo-xj2QHRw", "(SS)I", "Lni/shikatu/kotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lni/shikatu/kotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(SB)B", "mod-xj2QHRw", "(SS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-Mh2AYeg", "dec", "dec-Mh2AYeg", "rangeTo", "Lni/shikatu/kotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "and", "and-xj2QHRw", "or", "or-xj2QHRw", "xor", "xor-xj2QHRw", "inv", "inv-Mh2AYeg", "toByte", _UrlKt.FRAGMENT_ENCODE_SET, "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "toInt-impl", "(S)I", "toLong", _UrlKt.FRAGMENT_ENCODE_SET, "toLong-impl", "(S)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", _UrlKt.FRAGMENT_ENCODE_SET, "toFloat-impl", "(S)F", "toDouble", _UrlKt.FRAGMENT_ENCODE_SET, "toDouble-impl", "(S)D", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "toString-impl", "(S)Ljava/lang/String;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "Companion", "ni.shikatu.kotlin-stdlib", "1.5", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    public static final  UShort m281boximpl(short s) {
        return new UShort(s);
    }

    public static short m287constructorimpl(short s) {
        return s;
    }

    public static boolean m293equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m337unboximpl();
    }

    public static final boolean m294equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static  void getData$annotations() {
    }

    public static int m299hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    public boolean equals(Object obj) {
        return m293equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m299hashCodeimpl(this.data);
    }

    public final  short m337unboximpl() {
        return this.data;
    }

    @Override
    public /* bridge */  int compareTo(UShort uShort) {
        return Intrinsics.compare(m337unboximpl() & MAX_VALUE, uShort.m337unboximpl() & MAX_VALUE);
    }

    private  UShort(short data) {
        this.data = data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/UShort$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MIN_VALUE", "Lni/shikatu/kotlin/UShort;", "S", "MAX_VALUE", "SIZE_BYTES", _UrlKt.FRAGMENT_ENCODE_SET, "SIZE_BITS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final int m282compareTo7apg3OU(short arg0, byte other) {
        return Intrinsics.compare(65535 & arg0, other & UByte.MAX_VALUE);
    }

    private int m285compareToxj2QHRw(short other) {
        return Intrinsics.compare(m337unboximpl() & MAX_VALUE, 65535 & other);
    }

    private static int m286compareToxj2QHRw(short arg0, short other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, 65535 & other);
    }

    private static final int m284compareToWZ4Q5Ns(short arg0, int other) {
        return Integer.compareUnsigned(UInt.m101constructorimpl(65535 & arg0), other);
    }

    private static final int m283compareToVKZWuLQ(short arg0, long other) {
        return Long.compareUnsigned(ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX), other);
    }

    private static final int m311plus7apg3OU(short arg0, byte other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(65535 & arg0) + UInt.m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m314plusxj2QHRw(short arg0, short other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) + UInt.m101constructorimpl(65535 & other));
    }

    private static final int m313plusWZ4Q5Ns(short arg0, int other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(65535 & arg0) + other);
    }

    private static final long m312plusVKZWuLQ(short arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX) + other);
    }

    private static final int m302minus7apg3OU(short arg0, byte other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(65535 & arg0) - UInt.m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m305minusxj2QHRw(short arg0, short other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) - UInt.m101constructorimpl(65535 & other));
    }

    private static final int m304minusWZ4Q5Ns(short arg0, int other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(65535 & arg0) - other);
    }

    private static final long m303minusVKZWuLQ(short arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX) - other);
    }

    private static final int m321times7apg3OU(short arg0, byte other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(65535 & arg0) * UInt.m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m324timesxj2QHRw(short arg0, short other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(arg0 & MAX_VALUE) * UInt.m101constructorimpl(65535 & other));
    }

    private static final int m323timesWZ4Q5Ns(short arg0, int other) {
        return UInt.m101constructorimpl(UInt.m101constructorimpl(65535 & arg0) * other);
    }

    private static final long m322timesVKZWuLQ(short arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX) * other);
    }

    private static final int m289div7apg3OU(short arg0, byte other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(65535 & arg0), UInt.m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m292divxj2QHRw(short arg0, short other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other));
    }

    private static final int m291divWZ4Q5Ns(short arg0, int other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(65535 & arg0), other);
    }

    private static final long m290divVKZWuLQ(short arg0, long other) {
        return Long.divideUnsigned(ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX), other);
    }

    private static final int m317rem7apg3OU(short arg0, byte other) {
        return Integer.remainderUnsigned(UInt.m101constructorimpl(65535 & arg0), UInt.m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m320remxj2QHRw(short arg0, short other) {
        return Integer.remainderUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other));
    }

    private static final int m319remWZ4Q5Ns(short arg0, int other) {
        return Integer.remainderUnsigned(UInt.m101constructorimpl(65535 & arg0), other);
    }

    private static final long m318remVKZWuLQ(short arg0, long other) {
        return Long.remainderUnsigned(ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX), other);
    }

    private static final int m295floorDiv7apg3OU(short arg0, byte other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(65535 & arg0), UInt.m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m298floorDivxj2QHRw(short arg0, short other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other));
    }

    private static final int m297floorDivWZ4Q5Ns(short arg0, int other) {
        return Integer.divideUnsigned(UInt.m101constructorimpl(65535 & arg0), other);
    }

    private static final long m296floorDivVKZWuLQ(short arg0, long other) {
        return Long.divideUnsigned(ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX), other);
    }

    private static final byte m306mod7apg3OU(short arg0, byte other) {
        return UByte.m24constructorimpl((byte) Integer.remainderUnsigned(UInt.m101constructorimpl(65535 & arg0), UInt.m101constructorimpl(other & UByte.MAX_VALUE)));
    }

    private static final short m309modxj2QHRw(short arg0, short other) {
        return m287constructorimpl((short) Integer.remainderUnsigned(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other)));
    }

    private static final int m308modWZ4Q5Ns(short arg0, int other) {
        return Integer.remainderUnsigned(UInt.m101constructorimpl(65535 & arg0), other);
    }

    private static final long m307modVKZWuLQ(short arg0, long other) {
        return Long.remainderUnsigned(ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX), other);
    }

    private static final short m300incMh2AYeg(short arg0) {
        return m287constructorimpl((short) (arg0 + 1));
    }

    private static final short m288decMh2AYeg(short arg0) {
        return m287constructorimpl((short) (arg0 - 1));
    }

    private static final UIntRange m315rangeToxj2QHRw(short arg0, short other) {
        return new UIntRange(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other), null);
    }

    private static final UIntRange m316rangeUntilxj2QHRw(short arg0, short other) {
        return URangesKt.m1310untilJ1ME1BU(UInt.m101constructorimpl(arg0 & MAX_VALUE), UInt.m101constructorimpl(65535 & other));
    }

    private static final short m280andxj2QHRw(short arg0, short other) {
        return m287constructorimpl((short) (arg0 & other));
    }

    private static final short m310orxj2QHRw(short arg0, short other) {
        return m287constructorimpl((short) (arg0 | other));
    }

    private static final short m336xorxj2QHRw(short arg0, short other) {
        return m287constructorimpl((short) (arg0 ^ other));
    }

    private static final short m301invMh2AYeg(short arg0) {
        return m287constructorimpl((short) (~arg0));
    }

    private static final byte m325toByteimpl(short arg0) {
        return (byte) arg0;
    }

    private static final short m330toShortimpl(short arg0) {
        return arg0;
    }

    private static final int m328toIntimpl(short arg0) {
        return 65535 & arg0;
    }

    private static final long m329toLongimpl(short arg0) {
        return ((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    private static final byte m332toUBytew2LRezQ(short arg0) {
        return UByte.m24constructorimpl((byte) arg0);
    }

    private static final short m335toUShortMh2AYeg(short arg0) {
        return arg0;
    }

    private static final int m333toUIntpVg5ArA(short arg0) {
        return UInt.m101constructorimpl(65535 & arg0);
    }

    private static final long m334toULongsVKNKU(short arg0) {
        return ULong.m180constructorimpl(((long) arg0) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    private static final float m327toFloatimpl(short arg0) {
        return (float) UnsignedKt.uintToDouble(65535 & arg0);
    }

    private static final double m326toDoubleimpl(short arg0) {
        return UnsignedKt.uintToDouble(65535 & arg0);
    }

    public static String m331toStringimpl(short arg0) {
        return String.valueOf(65535 & arg0);
    }

    public String toString() {
        return m331toStringimpl(this.data);
    }
}
