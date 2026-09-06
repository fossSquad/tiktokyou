package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.ranges.ULongRange;
import ni.shikatu.kotlin.ranges.URangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0084\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0084\u0001B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b#\u0010\u001bJ!\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b$\u0010\u001dJ!\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b%\u0010\u001fJ!\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b&\u0010!J!\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b(\u0010\u001bJ!\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b)\u0010\u001dJ!\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b*\u0010\u001fJ!\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b+\u0010!J!\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b-\u0010\u001bJ!\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b.\u0010\u001dJ!\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b/\u0010\u001fJ!\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b0\u0010!J!\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b2\u0010\u001bJ!\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b3\u0010\u001dJ!\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b4\u0010\u001fJ!\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b5\u0010!J!\u00106\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b7\u0010\u001bJ!\u00106\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b8\u0010\u001dJ!\u00106\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b9\u0010\u001fJ!\u00106\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b:\u0010!J!\u0010;\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b<\u0010=J!\u0010;\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b>\u0010?J!\u0010;\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0014H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b@\u0010\u0016J!\u0010;\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bA\u0010!J\u0015\u0010B\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bC\u0010\u0005J\u0015\u0010D\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bE\u0010\u0005J\u001d\u0010F\u001a\u00020G2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bH\u0010IJ=\u0010J\u001a\u00020G2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bL\u0012\b\bM\u0012\u0004\b\b(Nb\u0010\bO\u0012\f\bP\u0012\b\b\fJ\u0004\b\t0Qb\u0002\b\u0010¢\u0006\u0004\bK\u0010IJ!\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u000bH\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bT\u0010\u001fJ!\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u000bH\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bV\u0010\u001fJ!\u0010W\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bX\u0010!J!\u0010Y\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bZ\u0010!J!\u0010[\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\\\u0010!J\u0019\u0010]\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b^\u0010\u0005J\u0019\u0010_\u001a\u00020`H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020dH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\be\u0010fJ\u0019\u0010g\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bh\u0010iJ\u0019\u0010j\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bk\u0010\u0005J\u0019\u0010l\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bm\u0010bJ\u0019\u0010n\u001a\u00020\u0011H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bo\u0010fJ\u0019\u0010p\u001a\u00020\u0014H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bq\u0010iJ\u0019\u0010r\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bs\u0010\u0005J\u0019\u0010t\u001a\u00020uH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bv\u0010wJ\u0019\u0010x\u001a\u00020yH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bz\u0010{J\u0015\u0010|\u001a\u00020}H\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b~\u0010\u007fJ\u0017\u0010\u0080\u0001\u001a\u00030\u0081\u00012\t\u0010\f\u001a\u0005\u0018\u00010\u0082\u0001HÖ\u0083\u0004J\u000b\u0010\u0083\u0001\u001a\u00020\u000bHÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\r\bL\u0012\t\bM\u0012\u0005\b\b(\u0086\u0001Ê\u0001\u0003\b\u0087\u0001¨\u0006\u0085\u0001"}, d2 = {"Lni/shikatu/kotlin/ULong;", _UrlKt.FRAGMENT_ENCODE_SET, "data", _UrlKt.FRAGMENT_ENCODE_SET, "constructor-impl", "(J)J", "Lni/shikatu/kotlin/internal/IntrinsicConstEvaluation;", "Lni/shikatu/kotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", _UrlKt.FRAGMENT_ENCODE_SET, "other", "Lni/shikatu/kotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "Lni/shikatu/kotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "plus", "plus-7apg3OU", "(JB)J", "plus-xj2QHRw", "(JS)J", "plus-WZ4Q5Ns", "(JI)J", "plus-VKZWuLQ", "(JJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(JB)B", "mod-xj2QHRw", "(JS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-s-VKNKU", "dec", "dec-s-VKNKU", "rangeTo", "Lni/shikatu/kotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "and", "and-VKZWuLQ", "or", "or-VKZWuLQ", "xor", "xor-VKZWuLQ", "inv", "inv-s-VKNKU", "toByte", _UrlKt.FRAGMENT_ENCODE_SET, "toByte-impl", "(J)B", "toShort", _UrlKt.FRAGMENT_ENCODE_SET, "toShort-impl", "(J)S", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", _UrlKt.FRAGMENT_ENCODE_SET, "toFloat-impl", "(J)F", "toDouble", _UrlKt.FRAGMENT_ENCODE_SET, "toDouble-impl", "(J)D", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "toString-impl", "(J)Ljava/lang/String;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "Companion", "ni.shikatu.kotlin-stdlib", "1.5", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    public static final  ULong m174boximpl(long j) {
        return new ULong(j);
    }

    public static long m180constructorimpl(long j) {
        return j;
    }

    public static boolean m186equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m232unboximpl();
    }

    public static final boolean m187equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static  void getData$annotations() {
    }

    public static int m192hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m186equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m192hashCodeimpl(this.data);
    }

    public final  long m232unboximpl() {
        return this.data;
    }

    @Override
    public /* bridge */  int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(m232unboximpl(), uLong.m232unboximpl());
    }

    private  ULong(long data) {
        this.data = data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/ULong$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MIN_VALUE", "Lni/shikatu/kotlin/ULong;", "J", "MAX_VALUE", "SIZE_BYTES", _UrlKt.FRAGMENT_ENCODE_SET, "SIZE_BITS", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final int m175compareTo7apg3OU(long arg0, byte other) {
        return Long.compareUnsigned(arg0, m180constructorimpl(((long) other) & 255));
    }

    private static final int m179compareToxj2QHRw(long arg0, short other) {
        return Long.compareUnsigned(arg0, m180constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    private static final int m178compareToWZ4Q5Ns(long arg0, int other) {
        return Long.compareUnsigned(arg0, m180constructorimpl(((long) other) & 4294967295L));
    }

    private int m176compareToVKZWuLQ(long other) {
        return UnsignedKt.ulongCompare(m232unboximpl(), other);
    }

    private static int m177compareToVKZWuLQ(long arg0, long other) {
        return UnsignedKt.ulongCompare(arg0, other);
    }

    private static final long m204plus7apg3OU(long arg0, byte other) {
        return m180constructorimpl(m180constructorimpl(((long) other) & 255) + arg0);
    }

    private static final long m207plusxj2QHRw(long arg0, short other) {
        return m180constructorimpl(m180constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX) + arg0);
    }

    private static final long m206plusWZ4Q5Ns(long arg0, int other) {
        return m180constructorimpl(m180constructorimpl(((long) other) & 4294967295L) + arg0);
    }

    private static final long m205plusVKZWuLQ(long arg0, long other) {
        return m180constructorimpl(arg0 + other);
    }

    private static final long m195minus7apg3OU(long arg0, byte other) {
        return m180constructorimpl(arg0 - m180constructorimpl(((long) other) & 255));
    }

    private static final long m198minusxj2QHRw(long arg0, short other) {
        return m180constructorimpl(arg0 - m180constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    private static final long m197minusWZ4Q5Ns(long arg0, int other) {
        return m180constructorimpl(arg0 - m180constructorimpl(((long) other) & 4294967295L));
    }

    private static final long m196minusVKZWuLQ(long arg0, long other) {
        return m180constructorimpl(arg0 - other);
    }

    private static final long m216times7apg3OU(long arg0, byte other) {
        return m180constructorimpl(m180constructorimpl(((long) other) & 255) * arg0);
    }

    private static final long m219timesxj2QHRw(long arg0, short other) {
        return m180constructorimpl(m180constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX) * arg0);
    }

    private static final long m218timesWZ4Q5Ns(long arg0, int other) {
        return m180constructorimpl(m180constructorimpl(((long) other) & 4294967295L) * arg0);
    }

    private static final long m217timesVKZWuLQ(long arg0, long other) {
        return m180constructorimpl(arg0 * other);
    }

    private static final long m182div7apg3OU(long arg0, byte other) {
        return Long.divideUnsigned(arg0, m180constructorimpl(((long) other) & 255));
    }

    private static final long m185divxj2QHRw(long arg0, short other) {
        return Long.divideUnsigned(arg0, m180constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    private static final long m184divWZ4Q5Ns(long arg0, int other) {
        return Long.divideUnsigned(arg0, m180constructorimpl(((long) other) & 4294967295L));
    }

    private static final long m183divVKZWuLQ(long arg0, long other) {
        return UnsignedKt.m359ulongDivideeb3DHEI(arg0, other);
    }

    private static final long m210rem7apg3OU(long arg0, byte other) {
        return Long.remainderUnsigned(arg0, m180constructorimpl(((long) other) & 255));
    }

    private static final long m213remxj2QHRw(long arg0, short other) {
        return Long.remainderUnsigned(arg0, m180constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    private static final long m212remWZ4Q5Ns(long arg0, int other) {
        return Long.remainderUnsigned(arg0, m180constructorimpl(((long) other) & 4294967295L));
    }

    private static final long m211remVKZWuLQ(long arg0, long other) {
        return UnsignedKt.m360ulongRemaindereb3DHEI(arg0, other);
    }

    private static final long m188floorDiv7apg3OU(long arg0, byte other) {
        return Long.divideUnsigned(arg0, m180constructorimpl(((long) other) & 255));
    }

    private static final long m191floorDivxj2QHRw(long arg0, short other) {
        return Long.divideUnsigned(arg0, m180constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    private static final long m190floorDivWZ4Q5Ns(long arg0, int other) {
        return Long.divideUnsigned(arg0, m180constructorimpl(((long) other) & 4294967295L));
    }

    private static final long m189floorDivVKZWuLQ(long arg0, long other) {
        return Long.divideUnsigned(arg0, other);
    }

    private static final byte m199mod7apg3OU(long arg0, byte other) {
        return UByte.m24constructorimpl((byte) Long.remainderUnsigned(arg0, m180constructorimpl(((long) other) & 255)));
    }

    private static final short m202modxj2QHRw(long arg0, short other) {
        return UShort.m287constructorimpl((short) Long.remainderUnsigned(arg0, m180constructorimpl(((long) other) & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    private static final int m201modWZ4Q5Ns(long arg0, int other) {
        return UInt.m101constructorimpl((int) Long.remainderUnsigned(arg0, m180constructorimpl(((long) other) & 4294967295L)));
    }

    private static final long m200modVKZWuLQ(long arg0, long other) {
        return Long.remainderUnsigned(arg0, other);
    }

    private static final long m193incsVKNKU(long arg0) {
        return m180constructorimpl(1 + arg0);
    }

    private static final long m181decsVKNKU(long arg0) {
        return m180constructorimpl((-1) + arg0);
    }

    private static final ULongRange m208rangeToVKZWuLQ(long arg0, long other) {
        return new ULongRange(arg0, other, null);
    }

    private static final ULongRange m209rangeUntilVKZWuLQ(long arg0, long other) {
        return URangesKt.m1312untileb3DHEI(arg0, other);
    }

    private static final long m214shlsVKNKU(long arg0, int bitCount) {
        return m180constructorimpl(arg0 << bitCount);
    }

    private static final long m215shrsVKNKU(long arg0, int bitCount) {
        return m180constructorimpl(arg0 >>> bitCount);
    }

    private static final long m173andVKZWuLQ(long arg0, long other) {
        return m180constructorimpl(arg0 & other);
    }

    private static final long m203orVKZWuLQ(long arg0, long other) {
        return m180constructorimpl(arg0 | other);
    }

    private static final long m231xorVKZWuLQ(long arg0, long other) {
        return m180constructorimpl(arg0 ^ other);
    }

    private static final long m194invsVKNKU(long arg0) {
        return m180constructorimpl(~arg0);
    }

    private static final byte m220toByteimpl(long arg0) {
        return (byte) arg0;
    }

    private static final short m225toShortimpl(long arg0) {
        return (short) arg0;
    }

    private static final int m223toIntimpl(long arg0) {
        return (int) arg0;
    }

    private static final long m224toLongimpl(long arg0) {
        return arg0;
    }

    private static final byte m227toUBytew2LRezQ(long arg0) {
        return UByte.m24constructorimpl((byte) arg0);
    }

    private static final short m230toUShortMh2AYeg(long arg0) {
        return UShort.m287constructorimpl((short) arg0);
    }

    private static final int m228toUIntpVg5ArA(long arg0) {
        return UInt.m101constructorimpl((int) arg0);
    }

    private static final long m229toULongsVKNKU(long arg0) {
        return arg0;
    }

    private static final float m222toFloatimpl(long arg0) {
        return (float) UnsignedKt.ulongToDouble(arg0);
    }

    private static final double m221toDoubleimpl(long arg0) {
        return UnsignedKt.ulongToDouble(arg0);
    }

    public static String m226toStringimpl(long arg0) {
        return UnsignedKt.ulongToString(arg0, 10);
    }

    public String toString() {
        return m226toStringimpl(this.data);
    }
}
