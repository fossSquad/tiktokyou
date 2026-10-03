package ni.shikatu.okhttp3.internal.http2;

import java.io.IOException;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.http.HttpStatusCodesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Huffman;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "CODES", _UrlKt.FRAGMENT_ENCODE_SET, "CODE_BIT_COUNTS", _UrlKt.FRAGMENT_ENCODE_SET, "root", "Lni/shikatu/okhttp3/internal/http2/Huffman$Node;", "encode", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/ByteString;", "sink", "Lni/shikatu/okio/BufferedSink;", "encodedLength", _UrlKt.FRAGMENT_ENCODE_SET, "bytes", "decode", "Lni/shikatu/okio/BufferedSource;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "addCode", "symbol", "code", "codeBitCount", "Node", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Huffman {
    public static final Huffman INSTANCE = new Huffman();
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS, HttpStatusCodesKt.HTTP_PROCESSING, HttpStatusCodesKt.HTTP_EARLY_HINTS, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final byte[] CODE_BIT_COUNTS = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
    private static final Node root = new Node();

    private Huffman() {
    }

    static {
        int length = CODE_BIT_COUNTS.length;
        for (int i = 0; i < length; i++) {
            INSTANCE.addCode(i, CODES[i], CODE_BIT_COUNTS[i]);
        }
    }

    public final void encode(ByteString source, BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long accumulator = 0;
        int accumulatorBitCount = 0;
        int size = source.size();
        for (int i = 0; i < size; i++) {
            int symbol = _UtilCommonKt.and(source.getByte(i), KotlinVersion.MAX_COMPONENT_VALUE);
            int code = CODES[symbol];
            int codeBitCount = CODE_BIT_COUNTS[symbol];
            accumulator = (accumulator << codeBitCount) | ((long) code);
            accumulatorBitCount += codeBitCount;
            while (accumulatorBitCount >= 8) {
                accumulatorBitCount -= 8;
                sink.writeByte((int) (accumulator >> accumulatorBitCount));
            }
        }
        if (accumulatorBitCount > 0) {
            sink.writeByte((int) ((accumulator << (8 - accumulatorBitCount)) | (255 >>> accumulatorBitCount)));
        }
    }

    public final int encodedLength(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long bitCount = 0;
        int size = bytes.size();
        for (int i = 0; i < size; i++) {
            int byteIn = _UtilCommonKt.and(bytes.getByte(i), KotlinVersion.MAX_COMPONENT_VALUE);
            bitCount += (long) CODE_BIT_COUNTS[byteIn];
        }
        return (int) ((((long) 7) + bitCount) >> 3);
    }

    public final void decode(BufferedSource source, long byteCount, BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        Node node = root;
        int accumulator = 0;
        int accumulatorBitCount = 0;
        for (long i = 0; i < byteCount; i++) {
            int byteIn = _UtilCommonKt.and(source.readByte(), KotlinVersion.MAX_COMPONENT_VALUE);
            accumulator = (accumulator << 8) | byteIn;
            accumulatorBitCount += 8;
            while (accumulatorBitCount >= 8) {
                int childIndex = (accumulator >>> (accumulatorBitCount - 8)) & KotlinVersion.MAX_COMPONENT_VALUE;
                Node[] children = node.getChildren();
                Intrinsics.checkNotNull(children);
                Node node2 = children[childIndex];
                Intrinsics.checkNotNull(node2);
                node = node2;
                if (node.getChildren() == null) {
                    sink.writeByte(node.getSymbol());
                    accumulatorBitCount -= node.getTerminalBitCount();
                    node = root;
                } else {
                    accumulatorBitCount -= 8;
                }
            }
        }
        while (accumulatorBitCount > 0) {
            int childIndex2 = (accumulator << (8 - accumulatorBitCount)) & KotlinVersion.MAX_COMPONENT_VALUE;
            Node[] children2 = node.getChildren();
            Intrinsics.checkNotNull(children2);
            Node node3 = children2[childIndex2];
            Intrinsics.checkNotNull(node3);
            if (node3.getChildren() == null && node3.getTerminalBitCount() <= accumulatorBitCount) {
                sink.writeByte(node3.getSymbol());
                accumulatorBitCount -= node3.getTerminalBitCount();
                node = root;
            } else {
                return;
            }
        }
    }

    private final void addCode(int symbol, int code, int codeBitCount) {
        Node terminal = new Node(symbol, codeBitCount);
        int accumulatorBitCount = codeBitCount;
        Node node = root;
        while (accumulatorBitCount > 8) {
            accumulatorBitCount -= 8;
            int childIndex = (code >>> accumulatorBitCount) & KotlinVersion.MAX_COMPONENT_VALUE;
            Node[] children = node.getChildren();
            Intrinsics.checkNotNull(children);
            Node child = children[childIndex];
            if (child == null) {
                child = new Node();
                children[childIndex] = child;
            }
            node = child;
        }
        int shift = 8 - accumulatorBitCount;
        int start = (code << shift) & KotlinVersion.MAX_COMPONENT_VALUE;
        int end = 1 << shift;
        Node[] children2 = node.getChildren();
        Intrinsics.checkNotNull(children2);
        ArraysKt.fill(children2, terminal, start, start + end);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007R\u001d\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/Huffman$Node;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "symbol", _UrlKt.FRAGMENT_ENCODE_SET, "bits", "(II)V", "children", _UrlKt.FRAGMENT_ENCODE_SET, "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lni/shikatu/okhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Node {
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        public Node(int symbol, int bits) {
            this.children = null;
            this.symbol = symbol;
            int b = bits & 7;
            this.terminalBitCount = b == 0 ? 8 : b;
        }
    }
}
