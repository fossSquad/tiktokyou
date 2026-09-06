package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.ranges.UIntRange;
import ni.shikatu.kotlin.ranges.URangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0081\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0081\u0001B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0019\u0010\u000eJ!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u0012J!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0014J!\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001f\u0010\u000eJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b \u0010\u0012J!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0014J!\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u001dJ!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b$\u0010\u000eJ!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b%\u0010\u0012J!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0014J!\u0010#\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b'\u0010\u001dJ!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b)\u0010\u000eJ!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b*\u0010\u0012J!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0014J!\u0010(\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b,\u0010\u001dJ!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b.\u0010\u000eJ!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b/\u0010\u0012J!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0014J!\u0010-\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b1\u0010\u001dJ!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b3\u0010\u000eJ!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b4\u0010\u0012J!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0014J!\u00102\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b6\u0010\u001dJ!\u00107\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b8\u00109J!\u00107\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b:\u0010;J!\u00107\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b<\u0010\u0014J!\u00107\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b=\u0010\u001dJ\u0015\u0010>\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\b?\u0010\u0005J\u0015\u0010@\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bA\u0010\u0005J\u001d\u0010B\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bD\u0010EJ=\u0010F\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bH\u0012\b\bI\u0012\u0004\b\b(Jb\u0010\bK\u0012\f\bL\u0012\b\b\fJ\u0004\b\t0Mb\u0002\b\u000f¢\u0006\u0004\bG\u0010EJ!\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bP\u0010\u0014J!\u0010Q\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bR\u0010\u0014J!\u0010S\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bT\u0010\u0014J!\u0010U\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0014J!\u0010W\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bX\u0010\u0014J\u0019\u0010Y\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bZ\u0010\u0005J\u0019\u0010[\u001a\u00020\\H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b]\u0010^J\u0019\u0010_\u001a\u00020`H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bd\u0010\u0005J\u0019\u0010e\u001a\u00020fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bg\u0010hJ\u0019\u0010i\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bj\u0010^J\u0019\u0010k\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bl\u0010bJ\u0019\u0010m\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bn\u0010\u0005J\u0019\u0010o\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bp\u0010hJ\u0019\u0010q\u001a\u00020rH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bs\u0010tJ\u0019\u0010u\u001a\u00020vH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bw\u0010xJ\u0015\u0010y\u001a\u00020zH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b{\u0010|J\u0014\u0010}\u001a\u00020~2\b\u0010\u000b\u001a\u0004\u0018\u00010\u007fHÖ\u0083\u0004J\u000b\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\r\bH\u0012\t\bI\u0012\u0005\b\b(\u0083\u0001Ê\u0001\u0003\b\u0084\u0001¨\u0006\u0082\u0001"}, d2 = {"Lni/shikatu/kotlin/UInt;", _UrlKt.FRAGMENT_ENCODE_SET, "data", _UrlKt.FRAGMENT_ENCODE_SET, "constructor-impl", "(I)I", "Lni/shikatu/kotlin/internal/IntrinsicConstEvaluation;", "Lni/shikatu/kotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", "other", "Lni/shikatu/kotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "compareTo-WZ4Q5Ns", "(II)I", "Lni/shikatu/kotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(IJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(IB)B", "mod-xj2QHRw", "(IS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-pVg5ArA", "dec", "dec-pVg5ArA", "rangeTo", "Lni/shikatu/kotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "and", "and-WZ4Q5Ns", "or", "or-WZ4Q5Ns", "xor", "xor-WZ4Q5Ns", "inv", "inv-pVg5ArA", "toByte", _UrlKt.FRAGMENT_ENCODE_SET, "toByte-impl", "(I)B", "toShort", _UrlKt.FRAGMENT_ENCODE_SET, "toShort-impl", "(I)S", "toInt", "toInt-impl", "toLong", _UrlKt.FRAGMENT_ENCODE_SET, "toLong-impl", "(I)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", _UrlKt.FRAGMENT_ENCODE_SET, "toFloat-impl", "(I)F", "toDouble", _UrlKt.FRAGMENT_ENCODE_SET, "toDouble-impl", "(I)D", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "toString-impl", "(I)Ljava/lang/String;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "Companion", "ni.shikatu.kotlin-stdlib", "1.5", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    public static final  UInt m95boximpl(int i) {
        return new UInt(i);
    }

    public static int m101constructorimpl(int i) {
        return i;
    }

    public static boolean m107equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m153unboximpl();
    }

    public static final boolean m108equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static  void getData$annotations() {
    }

    public static int m113hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m107equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m113hashCodeimpl(this.data);
    }

    public final  int m153unboximpl() {
        return this.data;
    }

    @Override
    public /* bridge */  int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(m153unboximpl(), uInt.m153unboximpl());
    }

    private  UInt(int data) {
        this.data = data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/UInt$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MIN_VALUE", "Lni/shikatu/kotlin/UInt;", "I", "MAX_VALUE", "SIZE_BYTES", _UrlKt.FRAGMENT_ENCODE_SET, "SIZE_BITS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final int m96compareTo7apg3OU(int arg0, byte other) {
        return Integer.compareUnsigned(arg0, m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m100compareToxj2QHRw(int arg0, short other) {
        return Integer.compareUnsigned(arg0, m101constructorimpl(65535 & other));
    }

    private int m98compareToWZ4Q5Ns(int other) {
        return UnsignedKt.uintCompare(m153unboximpl(), other);
    }

    private static int m99compareToWZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.uintCompare(arg0, other);
    }

    private static final int m97compareToVKZWuLQ(int arg0, long other) {
        return Long.compareUnsigned(ULong.m180constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final int m125plus7apg3OU(int arg0, byte other) {
        return m101constructorimpl(m101constructorimpl(other & UByte.MAX_VALUE) + arg0);
    }

    private static final int m128plusxj2QHRw(int arg0, short other) {
        return m101constructorimpl(m101constructorimpl(65535 & other) + arg0);
    }

    private static final int m127plusWZ4Q5Ns(int arg0, int other) {
        return m101constructorimpl(arg0 + other);
    }

    private static final long m126plusVKZWuLQ(int arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & 4294967295L) + other);
    }

    private static final int m116minus7apg3OU(int arg0, byte other) {
        return m101constructorimpl(arg0 - m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m119minusxj2QHRw(int arg0, short other) {
        return m101constructorimpl(arg0 - m101constructorimpl(65535 & other));
    }

    private static final int m118minusWZ4Q5Ns(int arg0, int other) {
        return m101constructorimpl(arg0 - other);
    }

    private static final long m117minusVKZWuLQ(int arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & 4294967295L) - other);
    }

    private static final int m137times7apg3OU(int arg0, byte other) {
        return m101constructorimpl(m101constructorimpl(other & UByte.MAX_VALUE) * arg0);
    }

    private static final int m140timesxj2QHRw(int arg0, short other) {
        return m101constructorimpl(m101constructorimpl(65535 & other) * arg0);
    }

    private static final int m139timesWZ4Q5Ns(int arg0, int other) {
        return m101constructorimpl(arg0 * other);
    }

    private static final long m138timesVKZWuLQ(int arg0, long other) {
        return ULong.m180constructorimpl(ULong.m180constructorimpl(((long) arg0) & 4294967295L) * other);
    }

    private static final int m103div7apg3OU(int arg0, byte other) {
        return Integer.divideUnsigned(arg0, m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m106divxj2QHRw(int arg0, short other) {
        return Integer.divideUnsigned(arg0, m101constructorimpl(65535 & other));
    }

    private static final int m105divWZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.m357uintDivideJ1ME1BU(arg0, other);
    }

    private static final long m104divVKZWuLQ(int arg0, long other) {
        return Long.divideUnsigned(ULong.m180constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final int m131rem7apg3OU(int arg0, byte other) {
        return Integer.remainderUnsigned(arg0, m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m134remxj2QHRw(int arg0, short other) {
        return Integer.remainderUnsigned(arg0, m101constructorimpl(65535 & other));
    }

    private static final int m133remWZ4Q5Ns(int arg0, int other) {
        return UnsignedKt.m358uintRemainderJ1ME1BU(arg0, other);
    }

    private static final long m132remVKZWuLQ(int arg0, long other) {
        return Long.remainderUnsigned(ULong.m180constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final int m109floorDiv7apg3OU(int arg0, byte other) {
        return Integer.divideUnsigned(arg0, m101constructorimpl(other & UByte.MAX_VALUE));
    }

    private static final int m112floorDivxj2QHRw(int arg0, short other) {
        return Integer.divideUnsigned(arg0, m101constructorimpl(65535 & other));
    }

    private static final int m111floorDivWZ4Q5Ns(int arg0, int other) {
        return Integer.divideUnsigned(arg0, other);
    }

    private static final long m110floorDivVKZWuLQ(int arg0, long other) {
        return Long.divideUnsigned(ULong.m180constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final byte m120mod7apg3OU(int arg0, byte other) {
        return UByte.m24constructorimpl((byte) Integer.remainderUnsigned(arg0, m101constructorimpl(other & UByte.MAX_VALUE)));
    }

    private static final short m123modxj2QHRw(int arg0, short other) {
        return UShort.m287constructorimpl((short) Integer.remainderUnsigned(arg0, m101constructorimpl(65535 & other)));
    }

    private static final int m122modWZ4Q5Ns(int arg0, int other) {
        return Integer.remainderUnsigned(arg0, other);
    }

    private static final long m121modVKZWuLQ(int arg0, long other) {
        return Long.remainderUnsigned(ULong.m180constructorimpl(((long) arg0) & 4294967295L), other);
    }

    private static final int m114incpVg5ArA(int arg0) {
        return m101constructorimpl(arg0 + 1);
    }

    private static final int m102decpVg5ArA(int arg0) {
        return m101constructorimpl(arg0 - 1);
    }

    private static final UIntRange m129rangeToWZ4Q5Ns(int arg0, int other) {
        return new UIntRange(arg0, other, null);
    }

    private static final UIntRange m130rangeUntilWZ4Q5Ns(int arg0, int other) {
        return URangesKt.m1310untilJ1ME1BU(arg0, other);
    }

    private static final int m135shlpVg5ArA(int arg0, int bitCount) {
        return m101constructorimpl(arg0 << bitCount);
    }

    private static final int m136shrpVg5ArA(int arg0, int bitCount) {
        return m101constructorimpl(arg0 >>> bitCount);
    }

    private static final int m94andWZ4Q5Ns(int arg0, int other) {
        return m101constructorimpl(arg0 & other);
    }

    private static final int m124orWZ4Q5Ns(int arg0, int other) {
        return m101constructorimpl(arg0 | other);
    }

    private static final int m152xorWZ4Q5Ns(int arg0, int other) {
        return m101constructorimpl(arg0 ^ other);
    }

    private static final int m115invpVg5ArA(int arg0) {
        return m101constructorimpl(~arg0);
    }

    private static final byte m141toByteimpl(int arg0) {
        return (byte) arg0;
    }

    private static final short m146toShortimpl(int arg0) {
        return (short) arg0;
    }

    private static final int m144toIntimpl(int arg0) {
        return arg0;
    }

    private static final long m145toLongimpl(int arg0) {
        return ((long) arg0) & 4294967295L;
    }

    private static final byte m148toUBytew2LRezQ(int arg0) {
        return UByte.m24constructorimpl((byte) arg0);
    }

    private static final short m151toUShortMh2AYeg(int arg0) {
        return UShort.m287constructorimpl((short) arg0);
    }

    private static final int m149toUIntpVg5ArA(int arg0) {
        return arg0;
    }

    private static final long m150toULongsVKNKU(int arg0) {
        return ULong.m180constructorimpl(((long) arg0) & 4294967295L);
    }

    private static final float m143toFloatimpl(int arg0) {
        return (float) UnsignedKt.uintToDouble(arg0);
    }

    private static final double m142toDoubleimpl(int arg0) {
        return UnsignedKt.uintToDouble(arg0);
    }

    public static String m147toStringimpl(int arg0) {
        return String.valueOf(((long) arg0) & 4294967295L);
    }

    public String toString() {
        return m147toStringimpl(this.data);
    }
}
