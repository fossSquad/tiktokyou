package ni.shikatu.okio.internal;

import java.io.EOFException;
import java.io.IOException;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.C0026SegmentedByteString;
import ni.shikatu.okio.Options;
import ni.shikatu.okio.Segment;
import ni.shikatu.okio.SegmentPool;
import ni.shikatu.okio.SegmentedByteString;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Utf8;
import ni.shikatu.okio._JvmPlatformKt;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a?\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u001a\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u00140\u0017H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0007H\u0000\u001a%\u0010\u001d\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\r\u0010!\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010\"\u001a\u00020#*\u00020\u0010H\u0080\b\u001a\r\u0010$\u001a\u00020%*\u00020\u0010H\u0080\b\u001a\r\u0010&\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a\r\u0010'\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\u0015\u0010(\u001a\u00020#*\u00020\u00102\u0006\u0010)\u001a\u00020\u0012H\u0080\b\u001a\r\u0010*\u001a\u00020+*\u00020\u0010H\u0080\b\u001a\u0015\u0010,\u001a\u00020+*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a)\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0012H\u0002\u001a\u0015\u00105\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u0015\u00106\u001a\u00020\t*\u00020\u00102\u0006\u00107\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020\u0001H\u0080\b\u001a%\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\r\u00109\u001a\u00020\u0001*\u00020\u0010H\u0080\b\u001a\u0015\u00109\u001a\u00020\u0001*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010:\u001a\u00020\u0005*\u00020\u00102\u0006\u0010;\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010<\u001a\u00020+*\u00020\u00102\u0006\u0010;\u001a\u00020\u0001H\u0080\b\u001a%\u0010:\u001a\u00020\u0005*\u00020\u00102\u0006\u0010;\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\r\u0010?\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010@\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010A\u001a\u00020/*\u00020\u0010H\u0080\b\u001a\u0015\u0010A\u001a\u00020/*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010B\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0080\b\u001a\u001d\u0010<\u001a\u00020+*\u00020\u00102\u0006\u0010;\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010C\u001a\u00020\u0012*\u00020\u00102\u0006\u0010;\u001a\u00020DH\u0080\b\u001a\u0015\u0010E\u001a\u00020\u000f*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u000f\u0010F\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0080\b\u001a\u0015\u0010G\u001a\u00020\u000f*\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0080\b\u001a\r\u0010I\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a%\u0010J\u001a\u00020\u0010*\u00020\u00102\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010N\u001a\u00020\u0010*\u00020\u00102\u0006\u0010O\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010P\u001a\u00020\u0012*\u00020\u00102\u0006\u00108\u001a\u00020QH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020Q2\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010R\u001a\u00020\u0010*\u00020\u00102\u0006\u0010S\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010T\u001a\u00020\u0010*\u00020\u00102\u0006\u0010U\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010V\u001a\u00020\u0010*\u00020\u00102\u0006\u0010W\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010X\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u001d\u0010-\u001a\u00020+*\u00020\u00102\u0006\u00108\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u001d\u0010:\u001a\u00020\u0012*\u00020\u00102\u0006\u0010;\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a%\u0010Y\u001a\u00020\u0012*\u00020\u00102\u0006\u0010S\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0080\b\u001a:\u0010Y\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\u000b\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010Z\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u0005H\u0000\u001a\u001d\u0010[\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\\\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u0012H\u0080\b\u001a-\u0010]\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0017\u0010^\u001a\u00020\u0007*\u00020\u00102\b\u0010_\u001a\u0004\u0018\u00010`H\u0080\b\u001a\r\u0010a\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a\r\u0010b\u001a\u00020\u0010*\u00020\u0010H\u0080\b\u001a\r\u0010c\u001a\u00020/*\u00020\u0010H\u0080\b\u001a\u0015\u0010c\u001a\u00020/*\u00020\u00102\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0014\u0010d\u001a\u00020e*\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0000\u001a\u0014\u0010g\u001a\u00020e*\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0000\u001a\r\u0010h\u001a\u00020\u0005*\u00020eH\u0080\b\u001a\u0015\u0010i\u001a\u00020\u0005*\u00020e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010j\u001a\u00020\u0012*\u00020e2\u0006\u0010k\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010l\u001a\u00020\u0012*\u00020e2\u0006\u0010m\u001a\u00020\u0005H\u0080\b\u001a\r\u0010n\u001a\u00020+*\u00020eH\u0080\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006o"}, d2 = {"HEX_DIGIT_BYTES", _UrlKt.FRAGMENT_ENCODE_SET, "getHEX_DIGIT_BYTES", "()[B", "SEGMENTING_THRESHOLD", _UrlKt.FRAGMENT_ENCODE_SET, "rangeEquals", _UrlKt.FRAGMENT_ENCODE_SET, "segment", "Lni/shikatu/okio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "readUtf8Line", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/Buffer;", "newline", _UrlKt.FRAGMENT_ENCODE_SET, "seek", "T", "fromIndex", "lambda", "Lni/shikatu/kotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "options", "Lni/shikatu/okio/Options;", "selectTruncated", "commonCopyTo", "out", "offset", "byteCount", "commonCompleteSegmentByteCount", "commonReadByte", _UrlKt.FRAGMENT_ENCODE_SET, "commonReadShort", _UrlKt.FRAGMENT_ENCODE_SET, "commonReadInt", "commonReadLong", "commonGet", "pos", "commonClear", _UrlKt.FRAGMENT_ENCODE_SET, "commonSkip", "commonWrite", "byteString", "Lni/shikatu/okio/ByteString;", "commonWriteDecimalLong", "v", "countDigitsIn", "DigitCountToLargestValue", _UrlKt.FRAGMENT_ENCODE_SET, "commonWriteHexadecimalUnsignedLong", "commonWritableSegment", "minimumCapacity", "source", "commonReadByteArray", "commonRead", "sink", "commonReadFully", "OVERFLOW_ZONE", "OVERFLOW_DIGIT_START", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "commonSelect", "commonReadAll", "Lni/shikatu/okio/Sink;", "commonReadUtf8", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonReadUtf8CodePoint", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "commonWriteAll", "Lni/shikatu/okio/Source;", "commonWriteByte", "b", "commonWriteShort", "s", "commonWriteInt", "i", "commonWriteLong", "commonIndexOf", "toIndex", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonEquals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "commonHashCode", "commonCopy", "commonSnapshot", "commonReadUnsafe", "Lni/shikatu/okio/Buffer$UnsafeCursor;", "unsafeCursor", "commonReadAndWriteUnsafe", "commonNext", "commonSeek", "commonResizeBuffer", "newSize", "commonExpandBuffer", "minByteCount", "commonClose", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Buffer {
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    private static final long[] DigitCountToLargestValue = {-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, LongCompanionObject.MAX_VALUE};

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int segmentPos, byte[] bytes, int bytesOffset, int bytesLimit) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Segment segment2 = segment;
        int segmentPos2 = segmentPos;
        int segmentLimit = segment2.limit;
        byte[] data = segment2.data;
        for (int i = bytesOffset; i < bytesLimit; i++) {
            if (segmentPos2 == segmentLimit) {
                Segment segment3 = segment2.next;
                Intrinsics.checkNotNull(segment3);
                byte[] data2 = segment3.data;
                segmentPos2 = segment3.pos;
                segmentLimit = segment3.limit;
                data = data2;
                segment2 = segment3;
            }
            if (data[segmentPos2] != bytes[i]) {
                return false;
            }
            segmentPos2++;
        }
        return true;
    }

    public static final String readUtf8Line(ni.shikatu.okio.Buffer $this$readUtf8Line, long newline) throws EOFException {
        Intrinsics.checkNotNullParameter($this$readUtf8Line, "<this>");
        if (newline > 0 && $this$readUtf8Line.getByte(newline - 1) == 13) {
            String result = $this$readUtf8Line.readUtf8(newline - 1);
            $this$readUtf8Line.skip(2L);
            return result;
        }
        String result2 = $this$readUtf8Line.readUtf8(newline);
        $this$readUtf8Line.skip(1L);
        return result2;
    }

    public static final <T> T seek(ni.shikatu.okio.Buffer $this$seek, long fromIndex, Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter($this$seek, "<this>");
        Intrinsics.checkNotNullParameter(function2, "lambda");
        Segment s = $this$seek.head;
        if (s == null) {
            return function2.invoke(null, -1L);
        }
        if ($this$seek.size() - fromIndex < fromIndex) {
            long offset = $this$seek.size();
            while (offset > fromIndex) {
                Segment segment = s.prev;
                Intrinsics.checkNotNull(segment);
                s = segment;
                offset -= (long) (s.limit - s.pos);
            }
            return function2.invoke(s, Long.valueOf(offset));
        }
        long offset2 = 0;
        while (true) {
            long nextOffset = ((long) (s.limit - s.pos)) + offset2;
            if (nextOffset <= fromIndex) {
                Segment segment2 = s.next;
                Intrinsics.checkNotNull(segment2);
                s = segment2;
                offset2 = nextOffset;
            } else {
                return function2.invoke(s, Long.valueOf(offset2));
            }
        }
    }

    public static  int selectPrefix$default(ni.shikatu.okio.Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int selectPrefix(ni.shikatu.okio.Buffer $this$selectPrefix, Options options, boolean selectTruncated) {
        int i;
        int nextStep;
        int triePos;
        int pos;
        Intrinsics.checkNotNullParameter($this$selectPrefix, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment head = $this$selectPrefix.head;
        int nextStep2 = -1;
        if (head == null) {
            return selectTruncated ? -2 : -1;
        }
        Segment s = head;
        byte[] data = head.data;
        int pos2 = head.pos;
        int limit = head.limit;
        int[] trie = options.getTrie$okio();
        int scanOrSelect = 0;
        int prefixIndex = -1;
        loop0: while (true) {
            int triePos2 = scanOrSelect + 1;
            int scanOrSelect2 = trie[scanOrSelect];
            int triePos3 = triePos2 + 1;
            int possiblePrefixIndex = trie[triePos2];
            if (possiblePrefixIndex != nextStep2) {
                prefixIndex = possiblePrefixIndex;
            }
            if (s == null) {
                i = -2;
                break;
            }
            if (scanOrSelect2 < 0) {
                int scanByteCount = scanOrSelect2 * (-1);
                i = -2;
                int trieLimit = triePos3 + scanByteCount;
                while (true) {
                    int pos3 = pos2 + 1;
                    byte $this$and$iv = data[pos2];
                    int triePos4 = triePos3 + 1;
                    if (($this$and$iv & UByte.MAX_VALUE) != trie[triePos3]) {
                        return prefixIndex;
                    }
                    boolean scanComplete = triePos4 == trieLimit;
                    if (pos3 != limit) {
                        triePos = triePos4;
                        pos = pos3;
                    } else {
                        Intrinsics.checkNotNull(s);
                        triePos = triePos4;
                        Segment segment = s.next;
                        Intrinsics.checkNotNull(segment);
                        s = segment;
                        pos = s.pos;
                        data = s.data;
                        limit = s.limit;
                        if (s == head) {
                            if (!scanComplete) {
                                break loop0;
                            }
                            s = null;
                        }
                    }
                    if (scanComplete) {
                        nextStep = trie[triePos];
                        pos2 = pos;
                        break;
                    }
                    pos2 = pos;
                    triePos3 = triePos;
                }
            } else {
                int pos4 = pos2 + 1;
                byte $this$and$iv2 = data[pos2];
                int i2 = $this$and$iv2 & UByte.MAX_VALUE;
                int selectLimit = triePos3 + scanOrSelect2;
                while (triePos3 != selectLimit) {
                    if (i2 == trie[triePos3]) {
                        int nextStep3 = trie[triePos3 + scanOrSelect2];
                        if (pos4 != limit) {
                            pos2 = pos4;
                            nextStep = nextStep3;
                        } else {
                            Segment s2 = s.next;
                            Intrinsics.checkNotNull(s2);
                            int pos5 = s2.pos;
                            byte[] data2 = s2.data;
                            int limit2 = s2.limit;
                            if (s2 != head) {
                                pos2 = pos5;
                                limit = limit2;
                                nextStep = nextStep3;
                                data = data2;
                                s = s2;
                            } else {
                                data = data2;
                                s = null;
                                limit = limit2;
                                pos2 = pos5;
                                nextStep = nextStep3;
                            }
                        }
                    } else {
                        triePos3++;
                    }
                }
                return prefixIndex;
            }
            if (nextStep >= 0) {
                return nextStep;
            }
            scanOrSelect = -nextStep;
            nextStep2 = -1;
        }
        return selectTruncated ? i : prefixIndex;
    }

    public static final ni.shikatu.okio.Buffer commonCopyTo(ni.shikatu.okio.Buffer $this$commonCopyTo, ni.shikatu.okio.Buffer out, long offset, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonCopyTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        long offset2 = offset;
        long byteCount2 = byteCount;
        SegmentedByteString.checkOffsetAndCount($this$commonCopyTo.size(), offset2, byteCount2);
        if (byteCount2 == 0) {
            return $this$commonCopyTo;
        }
        out.setSize$okio(out.size() + byteCount2);
        Segment s = $this$commonCopyTo.head;
        while (true) {
            Intrinsics.checkNotNull(s);
            if (offset2 < s.limit - s.pos) {
                break;
            }
            offset2 -= (long) (s.limit - s.pos);
            s = s.next;
        }
        while (byteCount2 > 0) {
            Intrinsics.checkNotNull(s);
            Segment copy = s.sharedCopy();
            copy.pos += (int) offset2;
            copy.limit = Math.min(copy.pos + ((int) byteCount2), copy.limit);
            if (out.head == null) {
                copy.prev = copy;
                copy.next = copy.prev;
                out.head = copy.next;
            } else {
                Segment segment = out.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment.prev;
                Intrinsics.checkNotNull(segment2);
                segment2.push(copy);
            }
            byteCount2 -= (long) (copy.limit - copy.pos);
            offset2 = 0;
            s = s.next;
        }
        return $this$commonCopyTo;
    }

    public static final long commonCompleteSegmentByteCount(ni.shikatu.okio.Buffer $this$commonCompleteSegmentByteCount) {
        Intrinsics.checkNotNullParameter($this$commonCompleteSegmentByteCount, "<this>");
        long result = $this$commonCompleteSegmentByteCount.size();
        if (result == 0) {
            return 0L;
        }
        Segment segment = $this$commonCompleteSegmentByteCount.head;
        Intrinsics.checkNotNull(segment);
        Segment tail = segment.prev;
        Intrinsics.checkNotNull(tail);
        if (tail.limit < 8192 && tail.owner) {
            return result - ((long) (tail.limit - tail.pos));
        }
        return result;
    }

    public static final byte commonReadByte(ni.shikatu.okio.Buffer $this$commonReadByte) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadByte, "<this>");
        if ($this$commonReadByte.size() == 0) {
            throw new EOFException();
        }
        Segment segment = $this$commonReadByte.head;
        Intrinsics.checkNotNull(segment);
        int pos = segment.pos;
        int limit = segment.limit;
        byte[] data = segment.data;
        int pos2 = pos + 1;
        byte b = data[pos];
        $this$commonReadByte.setSize$okio($this$commonReadByte.size() - 1);
        if (pos2 == limit) {
            $this$commonReadByte.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos2;
        }
        return b;
    }

    public static final short commonReadShort(ni.shikatu.okio.Buffer $this$commonReadShort) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadShort, "<this>");
        if ($this$commonReadShort.size() < 2) {
            throw new EOFException();
        }
        Segment segment = $this$commonReadShort.head;
        Intrinsics.checkNotNull(segment);
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 2) {
            byte $this$and$iv = $this$commonReadShort.readByte();
            int i = ($this$and$iv & UByte.MAX_VALUE) << 8;
            byte $this$and$iv2 = $this$commonReadShort.readByte();
            int s = i | ($this$and$iv2 & UByte.MAX_VALUE);
            return (short) s;
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        byte $this$and$iv3 = data[pos];
        int i2 = ($this$and$iv3 & UByte.MAX_VALUE) << 8;
        int pos3 = pos2 + 1;
        byte $this$and$iv4 = data[pos2];
        int s2 = i2 | ($this$and$iv4 & UByte.MAX_VALUE);
        $this$commonReadShort.setSize$okio($this$commonReadShort.size() - 2);
        if (pos3 == limit) {
            $this$commonReadShort.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos3;
        }
        return (short) s2;
    }

    public static final int commonReadInt(ni.shikatu.okio.Buffer $this$commonReadInt) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadInt, "<this>");
        if ($this$commonReadInt.size() < 4) {
            throw new EOFException();
        }
        Segment segment = $this$commonReadInt.head;
        Intrinsics.checkNotNull(segment);
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 4) {
            byte $this$and$iv = $this$commonReadInt.readByte();
            int i = ($this$and$iv & UByte.MAX_VALUE) << 24;
            byte $this$and$iv2 = $this$commonReadInt.readByte();
            int i2 = i | (($this$and$iv2 & UByte.MAX_VALUE) << 16);
            byte $this$and$iv3 = $this$commonReadInt.readByte();
            int i3 = i2 | (($this$and$iv3 & UByte.MAX_VALUE) << 8);
            byte $this$and$iv4 = $this$commonReadInt.readByte();
            return i3 | ($this$and$iv4 & UByte.MAX_VALUE);
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        byte $this$and$iv5 = data[pos];
        int i4 = ($this$and$iv5 & UByte.MAX_VALUE) << 24;
        int pos3 = pos2 + 1;
        byte $this$and$iv6 = data[pos2];
        int i5 = i4 | (($this$and$iv6 & UByte.MAX_VALUE) << 16);
        int pos4 = pos3 + 1;
        byte $this$and$iv7 = data[pos3];
        int i6 = i5 | (($this$and$iv7 & UByte.MAX_VALUE) << 8);
        int pos5 = pos4 + 1;
        byte $this$and$iv8 = data[pos4];
        int i7 = i6 | ($this$and$iv8 & UByte.MAX_VALUE);
        $this$commonReadInt.setSize$okio($this$commonReadInt.size() - 4);
        if (pos5 == limit) {
            $this$commonReadInt.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos5;
        }
        return i7;
    }

    public static final long commonReadLong(ni.shikatu.okio.Buffer $this$commonReadLong) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadLong, "<this>");
        if ($this$commonReadLong.size() < 8) {
            throw new EOFException();
        }
        Segment segment = $this$commonReadLong.head;
        Intrinsics.checkNotNull(segment);
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 8) {
            int $this$and$iv = $this$commonReadLong.readInt();
            int $this$and$iv2 = $this$commonReadLong.readInt();
            return ((((long) $this$and$iv) & 4294967295L) << 32) | (((long) $this$and$iv2) & 4294967295L);
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        byte $this$and$iv3 = data[pos];
        long other$iv = 255 & ((long) $this$and$iv3);
        int pos3 = pos2 + 1;
        byte $this$and$iv4 = data[pos2];
        long j = ((((long) $this$and$iv4) & 255) << 48) | (other$iv << 56);
        int pos4 = pos3 + 1;
        byte $this$and$iv5 = data[pos3];
        long other$iv2 = 255 & ((long) $this$and$iv5);
        int pos5 = pos4 + 1;
        byte $this$and$iv6 = data[pos4];
        long j2 = j | (other$iv2 << 40) | ((((long) $this$and$iv6) & 255) << 32);
        int pos6 = pos5 + 1;
        byte $this$and$iv7 = data[pos5];
        long other$iv3 = 255 & ((long) $this$and$iv7);
        int pos7 = pos6 + 1;
        byte $this$and$iv8 = data[pos6];
        long j3 = j2 | (other$iv3 << 24) | ((((long) $this$and$iv8) & 255) << 16);
        int pos8 = pos7 + 1;
        byte $this$and$iv9 = data[pos7];
        long other$iv4 = 255 & ((long) $this$and$iv9);
        int pos9 = pos8 + 1;
        byte $this$and$iv10 = data[pos8];
        long v = j3 | (other$iv4 << 8) | (((long) $this$and$iv10) & 255);
        $this$commonReadLong.setSize$okio($this$commonReadLong.size() - 8);
        if (pos9 == limit) {
            $this$commonReadLong.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos9;
        }
        return v;
    }

    public static final byte commonGet(ni.shikatu.okio.Buffer $this$commonGet, long pos) {
        Intrinsics.checkNotNullParameter($this$commonGet, "<this>");
        SegmentedByteString.checkOffsetAndCount($this$commonGet.size(), pos, 1L);
        Segment s$iv = $this$commonGet.head;
        if (s$iv == null) {
            Segment s = null;
            Intrinsics.checkNotNull(null);
            return s.data[(int) ((((long) s.pos) + pos) - (-1))];
        }
        if ($this$commonGet.size() - pos < pos) {
            long offset$iv = $this$commonGet.size();
            while (offset$iv > pos) {
                Segment segment = s$iv.prev;
                Intrinsics.checkNotNull(segment);
                s$iv = segment;
                offset$iv -= (long) (s$iv.limit - s$iv.pos);
            }
            Segment s2 = s$iv;
            long offset = offset$iv;
            Intrinsics.checkNotNull(s2);
            return s2.data[(int) ((((long) s2.pos) + pos) - offset)];
        }
        long offset$iv2 = 0;
        while (true) {
            long nextOffset$iv = ((long) (s$iv.limit - s$iv.pos)) + offset$iv2;
            if (nextOffset$iv <= pos) {
                Segment segment2 = s$iv.next;
                Intrinsics.checkNotNull(segment2);
                s$iv = segment2;
                offset$iv2 = nextOffset$iv;
            } else {
                Segment s3 = s$iv;
                long offset2 = offset$iv2;
                Intrinsics.checkNotNull(s3);
                return s3.data[(int) ((((long) s3.pos) + pos) - offset2)];
            }
        }
    }

    public static final void commonClear(ni.shikatu.okio.Buffer $this$commonClear) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonClear, "<this>");
        $this$commonClear.skip($this$commonClear.size());
    }

    public static final void commonSkip(ni.shikatu.okio.Buffer $this$commonSkip, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonSkip, "<this>");
        long byteCount2 = byteCount;
        while (byteCount2 > 0) {
            Segment head = $this$commonSkip.head;
            if (head == null) {
                throw new EOFException();
            }
            long a$iv = byteCount2;
            int b$iv = (int) Math.min(a$iv, head.limit - head.pos);
            $this$commonSkip.setSize$okio($this$commonSkip.size() - ((long) b$iv));
            byteCount2 -= (long) b$iv;
            head.pos += b$iv;
            if (head.pos == head.limit) {
                $this$commonSkip.head = head.pop();
                SegmentPool.recycle(head);
            }
        }
    }

    public static  ni.shikatu.okio.Buffer commonWrite$default(ni.shikatu.okio.Buffer $this$commonWrite_u24default, ByteString byteString, int offset, int byteCount, int i, Object obj) {
        if ((i & 2) != 0) {
            offset = 0;
        }
        if ((i & 4) != 0) {
            byteCount = byteString.size();
        }
        Intrinsics.checkNotNullParameter($this$commonWrite_u24default, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio($this$commonWrite_u24default, offset, byteCount);
        return $this$commonWrite_u24default;
    }

    public static final ni.shikatu.okio.Buffer commonWrite(ni.shikatu.okio.Buffer $this$commonWrite, ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio($this$commonWrite, offset, byteCount);
        return $this$commonWrite;
    }

    public static final ni.shikatu.okio.Buffer commonWriteDecimalLong(ni.shikatu.okio.Buffer $this$commonWriteDecimalLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteDecimalLong, "<this>");
        long v2 = v;
        if (v2 == 0) {
            return $this$commonWriteDecimalLong.writeByte(48);
        }
        boolean negative = false;
        if (v2 < 0) {
            v2 = -v2;
            if (v2 < 0) {
                return $this$commonWriteDecimalLong.writeUtf8("-9223372036854775808");
            }
            negative = true;
        }
        int width = countDigitsIn(v2);
        if (negative) {
            width++;
        }
        Segment tail = $this$commonWriteDecimalLong.writableSegment$okio(width);
        byte[] data = tail.data;
        int pos = tail.limit + width;
        while (v2 != 0) {
            long j = 10;
            int digit = (int) (v2 % j);
            pos--;
            data[pos] = getHEX_DIGIT_BYTES()[digit];
            v2 /= j;
        }
        if (negative) {
            data[pos - 1] = 45;
        }
        tail.limit += width;
        $this$commonWriteDecimalLong.setSize$okio($this$commonWriteDecimalLong.size() + ((long) width));
        return $this$commonWriteDecimalLong;
    }

    public static final int countDigitsIn(long v) {
        int guess = ((64 - Long.numberOfLeadingZeros(v)) * 10) >>> 5;
        return (v > DigitCountToLargestValue[guess] ? 1 : 0) + guess;
    }

    public static final ni.shikatu.okio.Buffer commonWriteHexadecimalUnsignedLong(ni.shikatu.okio.Buffer $this$commonWriteHexadecimalUnsignedLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteHexadecimalUnsignedLong, "<this>");
        long v2 = v;
        if (v2 == 0) {
            return $this$commonWriteHexadecimalUnsignedLong.writeByte(48);
        }
        long x = v2 | (v2 >>> 1);
        long x2 = x | (x >>> 2);
        long x3 = x2 | (x2 >>> 4);
        long x4 = x3 | (x3 >>> 8);
        long x5 = x4 | (x4 >>> 16);
        long x6 = x5 | (x5 >>> 32);
        long x7 = x6 - ((x6 >>> 1) & 6148914691236517205L);
        long x8 = ((x7 >>> 2) & 3689348814741910323L) + (3689348814741910323L & x7);
        long x9 = ((x8 >>> 4) + x8) & 1085102592571150095L;
        long x10 = x9 + (x9 >>> 8);
        long x11 = x10 + (x10 >>> 16);
        int width = (int) ((((long) 3) + ((x11 & 63) + (63 & (x11 >>> 32)))) / ((long) 4));
        Segment tail = $this$commonWriteHexadecimalUnsignedLong.writableSegment$okio(width);
        byte[] data = tail.data;
        int start = tail.limit;
        for (int pos = (tail.limit + width) - 1; pos >= start; pos--) {
            data[pos] = getHEX_DIGIT_BYTES()[(int) (15 & v2)];
            v2 >>>= 4;
        }
        tail.limit += width;
        $this$commonWriteHexadecimalUnsignedLong.setSize$okio($this$commonWriteHexadecimalUnsignedLong.size() + ((long) width));
        return $this$commonWriteHexadecimalUnsignedLong;
    }

    public static final Segment commonWritableSegment(ni.shikatu.okio.Buffer $this$commonWritableSegment, int minimumCapacity) {
        Intrinsics.checkNotNullParameter($this$commonWritableSegment, "<this>");
        if (!(minimumCapacity >= 1 && minimumCapacity <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        if ($this$commonWritableSegment.head == null) {
            Segment result = SegmentPool.take();
            $this$commonWritableSegment.head = result;
            result.prev = result;
            result.next = result;
            return result;
        }
        Segment segment = $this$commonWritableSegment.head;
        Intrinsics.checkNotNull(segment);
        Segment tail = segment.prev;
        Intrinsics.checkNotNull(tail);
        if (tail.limit + minimumCapacity > 8192 || !tail.owner) {
            return tail.push(SegmentPool.take());
        }
        return tail;
    }

    public static final ni.shikatu.okio.Buffer commonWrite(ni.shikatu.okio.Buffer $this$commonWrite, byte[] source) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return $this$commonWrite.write(source, 0, source.length);
    }

    public static final ni.shikatu.okio.Buffer commonWrite(ni.shikatu.okio.Buffer $this$commonWrite, byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int offset2 = offset;
        SegmentedByteString.checkOffsetAndCount(source.length, offset2, byteCount);
        int limit = offset2 + byteCount;
        while (offset2 < limit) {
            Segment tail = $this$commonWrite.writableSegment$okio(1);
            int toCopy = Math.min(limit - offset2, 8192 - tail.limit);
            ArraysKt.copyInto(source, tail.data, tail.limit, offset2, offset2 + toCopy);
            offset2 += toCopy;
            tail.limit += toCopy;
        }
        $this$commonWrite.setSize$okio($this$commonWrite.size() + ((long) byteCount));
        return $this$commonWrite;
    }

    public static final byte[] commonReadByteArray(ni.shikatu.okio.Buffer $this$commonReadByteArray) {
        Intrinsics.checkNotNullParameter($this$commonReadByteArray, "<this>");
        return $this$commonReadByteArray.readByteArray($this$commonReadByteArray.size());
    }

    public static final byte[] commonReadByteArray(ni.shikatu.okio.Buffer $this$commonReadByteArray, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadByteArray, "<this>");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if ($this$commonReadByteArray.size() < byteCount) {
            throw new EOFException();
        }
        byte[] result = new byte[(int) byteCount];
        $this$commonReadByteArray.readFully(result);
        return result;
    }

    public static final int commonRead(ni.shikatu.okio.Buffer $this$commonRead, byte[] sink) {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        return $this$commonRead.read(sink, 0, sink.length);
    }

    public static final void commonReadFully(ni.shikatu.okio.Buffer $this$commonReadFully, byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadFully, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int offset = 0;
        while (offset < sink.length) {
            int read = $this$commonReadFully.read(sink, offset, sink.length - offset);
            if (read == -1) {
                throw new EOFException();
            }
            offset += read;
        }
    }

    public static final int commonRead(ni.shikatu.okio.Buffer $this$commonRead, byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, offset, byteCount);
        Segment s = $this$commonRead.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(byteCount, s.limit - s.pos);
        ArraysKt.copyInto(s.data, sink, offset, s.pos, s.pos + toCopy);
        s.pos += toCopy;
        $this$commonRead.setSize$okio($this$commonRead.size() - ((long) toCopy));
        if (s.pos == s.limit) {
            $this$commonRead.head = s.pop();
            SegmentPool.recycle(s);
        }
        return toCopy;
    }

    public static final long commonReadDecimalLong(ni.shikatu.okio.Buffer $this$commonReadDecimalLong) throws EOFException {
        int $i$f$commonReadDecimalLong;
        long j;
        byte b;
        boolean negative;
        Intrinsics.checkNotNullParameter($this$commonReadDecimalLong, "<this>");
        int $i$f$commonReadDecimalLong2 = 0;
        long j2 = 0;
        if ($this$commonReadDecimalLong.size() == 0) {
            throw new EOFException();
        }
        long value = 0;
        int seen = 0;
        boolean negative2 = false;
        boolean done = false;
        long overflowDigit = -7;
        loop0: while (true) {
            Segment segment = $this$commonReadDecimalLong.head;
            Intrinsics.checkNotNull(segment);
            byte[] data = segment.data;
            int pos = segment.pos;
            int limit = segment.limit;
            while (true) {
                if (pos >= limit) {
                    $i$f$commonReadDecimalLong = $i$f$commonReadDecimalLong2;
                    j = j2;
                    break;
                }
                b = data[pos];
                j = j2;
                if (b < 48 || b > 57) {
                    $i$f$commonReadDecimalLong = $i$f$commonReadDecimalLong2;
                    done = done;
                    if (b == 45 && seen == 0) {
                        negative2 = true;
                        overflowDigit--;
                    } else {
                        done = true;
                        break;
                    }
                } else {
                    int digit = 48 - b;
                    if (value < OVERFLOW_ZONE) {
                        negative = negative2;
                        break loop0;
                    }
                    if (value == OVERFLOW_ZONE) {
                        negative = negative2;
                        if (digit < overflowDigit) {
                            break loop0;
                        }
                    } else {
                        negative = negative2;
                    }
                    value = (value * 10) + ((long) digit);
                    $i$f$commonReadDecimalLong = $i$f$commonReadDecimalLong2;
                    negative2 = negative;
                }
                pos++;
                seen++;
                done = done;
                j2 = j;
                $i$f$commonReadDecimalLong2 = $i$f$commonReadDecimalLong;
            }
            if (pos == limit) {
                $this$commonReadDecimalLong.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = pos;
            }
            if (done || $this$commonReadDecimalLong.head == null) {
                $this$commonReadDecimalLong.setSize$okio($this$commonReadDecimalLong.size() - ((long) seen));
                int minimumSeen = negative2 != 0 ? 2 : 1;
                if (seen >= minimumSeen) {
                    return negative2 != 0 ? value : -value;
                }
                if ($this$commonReadDecimalLong.size() == j) {
                    throw new EOFException();
                }
                String expected = negative2 != 0 ? "Expected a digit" : "Expected a digit or '-'";
                throw new NumberFormatException(expected + " but was 0x" + SegmentedByteString.toHexString($this$commonReadDecimalLong.getByte(j)));
            }
            j2 = j;
            negative2 = negative2;
            $i$f$commonReadDecimalLong2 = $i$f$commonReadDecimalLong;
        }
        ni.shikatu.okio.Buffer buffer = new ni.shikatu.okio.Buffer().writeDecimalLong(value).writeByte((int) b);
        if (!negative) {
            buffer.readByte();
        }
        throw new NumberFormatException("Number too large: " + buffer.readUtf8());
    }

    public static final long commonReadHexadecimalUnsignedLong(ni.shikatu.okio.Buffer $this$commonReadHexadecimalUnsignedLong) throws EOFException {
        int digit;
        Intrinsics.checkNotNullParameter($this$commonReadHexadecimalUnsignedLong, "<this>");
        if ($this$commonReadHexadecimalUnsignedLong.size() == 0) {
            throw new EOFException();
        }
        long value = 0;
        int seen = 0;
        boolean done = false;
        do {
            Segment segment = $this$commonReadHexadecimalUnsignedLong.head;
            Intrinsics.checkNotNull(segment);
            byte[] data = segment.data;
            int pos = segment.pos;
            int limit = segment.limit;
            while (pos < limit) {
                byte b = data[pos];
                if (b >= 48 && b <= 57) {
                    digit = b - 48;
                } else if (b >= 97 && b <= 102) {
                    digit = (b - 97) + 10;
                } else if (b >= 65 && b <= 70) {
                    digit = (b - 65) + 10;
                } else {
                    if (seen == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + SegmentedByteString.toHexString(b));
                    }
                    done = true;
                    break;
                }
                if (((-1152921504606846976L) & value) != 0) {
                    ni.shikatu.okio.Buffer buffer = new ni.shikatu.okio.Buffer().writeHexadecimalUnsignedLong(value).writeByte((int) b);
                    throw new NumberFormatException("Number too large: " + buffer.readUtf8());
                }
                value = (value << 4) | ((long) digit);
                pos++;
                seen++;
            }
            if (pos == limit) {
                $this$commonReadHexadecimalUnsignedLong.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = pos;
            }
            if (done) {
                break;
            }
        } while ($this$commonReadHexadecimalUnsignedLong.head != null);
        $this$commonReadHexadecimalUnsignedLong.setSize$okio($this$commonReadHexadecimalUnsignedLong.size() - ((long) seen));
        return value;
    }

    public static final ByteString commonReadByteString(ni.shikatu.okio.Buffer $this$commonReadByteString) {
        Intrinsics.checkNotNullParameter($this$commonReadByteString, "<this>");
        return $this$commonReadByteString.readByteString($this$commonReadByteString.size());
    }

    public static final ByteString commonReadByteString(ni.shikatu.okio.Buffer $this$commonReadByteString, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadByteString, "<this>");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if ($this$commonReadByteString.size() < byteCount) {
            throw new EOFException();
        }
        if (byteCount >= 4096) {
            ByteString byteStringSnapshot = $this$commonReadByteString.snapshot((int) byteCount);
            $this$commonReadByteString.skip(byteCount);
            return byteStringSnapshot;
        }
        return new ByteString($this$commonReadByteString.readByteArray(byteCount));
    }

    public static final int commonSelect(ni.shikatu.okio.Buffer $this$commonSelect, Options options) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonSelect, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int index = selectPrefix$default($this$commonSelect, options, false, 2, null);
        if (index == -1) {
            return -1;
        }
        int selectedSize = options.getByteStrings$okio()[index].size();
        $this$commonSelect.skip(selectedSize);
        return index;
    }

    public static final void commonReadFully(ni.shikatu.okio.Buffer $this$commonReadFully, ni.shikatu.okio.Buffer sink, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadFully, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if ($this$commonReadFully.size() < byteCount) {
            sink.write($this$commonReadFully, $this$commonReadFully.size());
            throw new EOFException();
        }
        sink.write($this$commonReadFully, byteCount);
    }

    public static final long commonReadAll(ni.shikatu.okio.Buffer $this$commonReadAll, Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadAll, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long byteCount = $this$commonReadAll.size();
        if (byteCount > 0) {
            sink.write($this$commonReadAll, byteCount);
        }
        return byteCount;
    }

    public static final String commonReadUtf8(ni.shikatu.okio.Buffer $this$commonReadUtf8, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8, "<this>");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if ($this$commonReadUtf8.size() < byteCount) {
            throw new EOFException();
        }
        if (byteCount == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        Segment s = $this$commonReadUtf8.head;
        Intrinsics.checkNotNull(s);
        if (((long) s.pos) + byteCount > s.limit) {
            return _Utf8Kt.commonToUtf8String$default($this$commonReadUtf8.readByteArray(byteCount), 0, 0, 3, null);
        }
        String result = _Utf8Kt.commonToUtf8String(s.data, s.pos, s.pos + ((int) byteCount));
        s.pos += (int) byteCount;
        $this$commonReadUtf8.setSize$okio($this$commonReadUtf8.size() - byteCount);
        if (s.pos == s.limit) {
            $this$commonReadUtf8.head = s.pop();
            SegmentPool.recycle(s);
        }
        return result;
    }

    public static final String commonReadUtf8Line(ni.shikatu.okio.Buffer $this$commonReadUtf8Line) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8Line, "<this>");
        long newline = $this$commonReadUtf8Line.indexOf((byte) 10);
        if (newline != -1) {
            return readUtf8Line($this$commonReadUtf8Line, newline);
        }
        if ($this$commonReadUtf8Line.size() != 0) {
            return $this$commonReadUtf8Line.readUtf8($this$commonReadUtf8Line.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(ni.shikatu.okio.Buffer $this$commonReadUtf8LineStrict, long limit) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8LineStrict, "<this>");
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = LongCompanionObject.MAX_VALUE;
        if (limit != LongCompanionObject.MAX_VALUE) {
            j = limit + 1;
        }
        long scanLength = j;
        long newline = $this$commonReadUtf8LineStrict.indexOf((byte) 10, 0L, scanLength);
        if (newline != -1) {
            return readUtf8Line($this$commonReadUtf8LineStrict, newline);
        }
        if (scanLength < $this$commonReadUtf8LineStrict.size() && $this$commonReadUtf8LineStrict.getByte(scanLength - 1) == 13 && $this$commonReadUtf8LineStrict.getByte(scanLength) == 10) {
            return readUtf8Line($this$commonReadUtf8LineStrict, scanLength);
        }
        ni.shikatu.okio.Buffer data = new ni.shikatu.okio.Buffer();
        long b$iv = $this$commonReadUtf8LineStrict.size();
        $this$commonReadUtf8LineStrict.copyTo(data, 0L, Math.min(32, b$iv));
        throw new EOFException("\\n not found: limit=" + Math.min($this$commonReadUtf8LineStrict.size(), limit) + " content=" + data.readByteString().hex() + Typography.ellipsis);
    }

    public static final int commonReadUtf8CodePoint(ni.shikatu.okio.Buffer $this$commonReadUtf8CodePoint) throws EOFException {
        int other$iv;
        int codePoint;
        int byteCount;
        Intrinsics.checkNotNullParameter($this$commonReadUtf8CodePoint, "<this>");
        if ($this$commonReadUtf8CodePoint.size() == 0) {
            throw new EOFException();
        }
        byte b0 = $this$commonReadUtf8CodePoint.getByte(0L);
        int other$iv2 = 128 & b0;
        if (other$iv2 == 0) {
            other$iv = 127 & b0;
            codePoint = 1;
            byteCount = 0;
        } else {
            int other$iv3 = 224 & b0;
            if (other$iv3 == 192) {
                other$iv = 31 & b0;
                codePoint = 2;
                byteCount = 128;
            } else {
                int other$iv4 = 240 & b0;
                if (other$iv4 == 224) {
                    other$iv = 15 & b0;
                    codePoint = 3;
                    byteCount = 2048;
                } else {
                    int other$iv5 = 248 & b0;
                    if (other$iv5 != 240) {
                        $this$commonReadUtf8CodePoint.skip(1L);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                    other$iv = 7 & b0;
                    codePoint = 4;
                    byteCount = 65536;
                }
            }
        }
        if ($this$commonReadUtf8CodePoint.size() < codePoint) {
            throw new EOFException("size < " + codePoint + ": " + $this$commonReadUtf8CodePoint.size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b0) + ')');
        }
        for (int i = 1; i < codePoint; i++) {
            int b = $this$commonReadUtf8CodePoint.getByte(i);
            int other$iv6 = 192 & b;
            if (other$iv6 == 128) {
                int codePoint2 = other$iv << 6;
                int other$iv7 = 63 & b;
                other$iv = codePoint2 | other$iv7;
            } else {
                $this$commonReadUtf8CodePoint.skip(i);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
        }
        $this$commonReadUtf8CodePoint.skip(codePoint);
        if (other$iv > 1114111) {
            return Utf8.REPLACEMENT_CODE_POINT;
        }
        boolean z = false;
        if (55296 <= other$iv && other$iv < 57344) {
            z = true;
        }
        if (z || other$iv < byteCount) {
            return Utf8.REPLACEMENT_CODE_POINT;
        }
        return other$iv;
    }

    public static final ni.shikatu.okio.Buffer commonWriteUtf8(ni.shikatu.okio.Buffer $this$commonWriteUtf8, String string, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        int i = 1;
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        int i2 = beginIndex;
        while (i2 < endIndex) {
            int c = string.charAt(i2);
            if (c < 128) {
                Segment tail = $this$commonWriteUtf8.writableSegment$okio(i);
                byte[] data = tail.data;
                int segmentOffset = tail.limit - i2;
                int runLimit = Math.min(endIndex, 8192 - segmentOffset);
                data[i2 + segmentOffset] = (byte) c;
                i2++;
                while (i2 < runLimit) {
                    int c2 = string.charAt(i2);
                    if (c2 >= 128) {
                        break;
                    }
                    data[i2 + segmentOffset] = (byte) c2;
                    i2++;
                }
                int runSize = (i2 + segmentOffset) - tail.limit;
                tail.limit += runSize;
                $this$commonWriteUtf8.setSize$okio($this$commonWriteUtf8.size() + ((long) runSize));
                i = i;
            } else {
                int i3 = i;
                if (c < 2048) {
                    Segment tail2 = $this$commonWriteUtf8.writableSegment$okio(2);
                    tail2.data[tail2.limit] = (byte) ((c >> 6) | 192);
                    tail2.data[tail2.limit + 1] = (byte) (128 | (c & 63));
                    tail2.limit += 2;
                    $this$commonWriteUtf8.setSize$okio($this$commonWriteUtf8.size() + 2);
                    i2++;
                    i = i3;
                } else if (c < 55296 || c > 57343) {
                    Segment tail3 = $this$commonWriteUtf8.writableSegment$okio(3);
                    tail3.data[tail3.limit] = (byte) ((c >> 12) | 224);
                    tail3.data[tail3.limit + 1] = (byte) ((63 & (c >> 6)) | 128);
                    tail3.data[tail3.limit + 2] = (byte) (128 | (c & 63));
                    tail3.limit += 3;
                    $this$commonWriteUtf8.setSize$okio($this$commonWriteUtf8.size() + 3);
                    i2++;
                    i = i3;
                } else {
                    int low = i2 + 1 < endIndex ? string.charAt(i2 + 1) : 0;
                    if (c <= 56319) {
                        if (((56320 > low || low >= 57344) ? 0 : i3) != 0) {
                            int codePoint = (((c & 1023) << 10) | (low & 1023)) + 65536;
                            Segment tail4 = $this$commonWriteUtf8.writableSegment$okio(4);
                            tail4.data[tail4.limit] = (byte) ((codePoint >> 18) | 240);
                            tail4.data[tail4.limit + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                            tail4.data[tail4.limit + 2] = (byte) ((63 & (codePoint >> 6)) | 128);
                            tail4.data[tail4.limit + 3] = (byte) (128 | (codePoint & 63));
                            tail4.limit += 4;
                            $this$commonWriteUtf8.setSize$okio($this$commonWriteUtf8.size() + 4);
                            i2 += 2;
                            i = i3;
                        }
                    }
                    $this$commonWriteUtf8.writeByte(63);
                    i2++;
                    i = i3;
                }
            }
        }
        return $this$commonWriteUtf8;
    }

    public static final ni.shikatu.okio.Buffer commonWriteUtf8CodePoint(ni.shikatu.okio.Buffer $this$commonWriteUtf8CodePoint, int codePoint) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8CodePoint, "<this>");
        if (codePoint < 128) {
            $this$commonWriteUtf8CodePoint.writeByte(codePoint);
        } else if (codePoint < 2048) {
            Segment tail = $this$commonWriteUtf8CodePoint.writableSegment$okio(2);
            tail.data[tail.limit] = (byte) ((codePoint >> 6) | 192);
            tail.data[tail.limit + 1] = (byte) (128 | (codePoint & 63));
            tail.limit += 2;
            $this$commonWriteUtf8CodePoint.setSize$okio($this$commonWriteUtf8CodePoint.size() + 2);
        } else {
            boolean z = false;
            if (55296 <= codePoint && codePoint < 57344) {
                z = true;
            }
            if (z) {
                $this$commonWriteUtf8CodePoint.writeByte(63);
            } else if (codePoint < 65536) {
                Segment tail2 = $this$commonWriteUtf8CodePoint.writableSegment$okio(3);
                tail2.data[tail2.limit] = (byte) ((codePoint >> 12) | 224);
                tail2.data[tail2.limit + 1] = (byte) ((63 & (codePoint >> 6)) | 128);
                tail2.data[tail2.limit + 2] = (byte) (128 | (codePoint & 63));
                tail2.limit += 3;
                $this$commonWriteUtf8CodePoint.setSize$okio($this$commonWriteUtf8CodePoint.size() + 3);
            } else if (codePoint <= 1114111) {
                Segment tail3 = $this$commonWriteUtf8CodePoint.writableSegment$okio(4);
                tail3.data[tail3.limit] = (byte) ((codePoint >> 18) | 240);
                tail3.data[tail3.limit + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                tail3.data[tail3.limit + 2] = (byte) ((63 & (codePoint >> 6)) | 128);
                tail3.data[tail3.limit + 3] = (byte) (128 | (codePoint & 63));
                tail3.limit += 4;
                $this$commonWriteUtf8CodePoint.setSize$okio($this$commonWriteUtf8CodePoint.size() + 4);
            } else {
                throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(codePoint));
            }
        }
        return $this$commonWriteUtf8CodePoint;
    }

    public static final long commonWriteAll(ni.shikatu.okio.Buffer $this$commonWriteAll, Source source) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonWriteAll, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long totalBytesRead = 0;
        while (true) {
            long readCount = source.read($this$commonWriteAll, 8192L);
            if (readCount != -1) {
                totalBytesRead += readCount;
            } else {
                return totalBytesRead;
            }
        }
    }

    public static final ni.shikatu.okio.Buffer commonWrite(ni.shikatu.okio.Buffer $this$commonWrite, Source source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long byteCount2 = byteCount;
        while (byteCount2 > 0) {
            long read = source.read($this$commonWrite, byteCount2);
            if (read == -1) {
                throw new EOFException();
            }
            byteCount2 -= read;
        }
        return $this$commonWrite;
    }

    public static final ni.shikatu.okio.Buffer commonWriteByte(ni.shikatu.okio.Buffer $this$commonWriteByte, int b) {
        Intrinsics.checkNotNullParameter($this$commonWriteByte, "<this>");
        Segment tail = $this$commonWriteByte.writableSegment$okio(1);
        byte[] bArr = tail.data;
        int i = tail.limit;
        tail.limit = i + 1;
        bArr[i] = (byte) b;
        $this$commonWriteByte.setSize$okio($this$commonWriteByte.size() + 1);
        return $this$commonWriteByte;
    }

    public static final ni.shikatu.okio.Buffer commonWriteShort(ni.shikatu.okio.Buffer $this$commonWriteShort, int s) {
        Intrinsics.checkNotNullParameter($this$commonWriteShort, "<this>");
        Segment tail = $this$commonWriteShort.writableSegment$okio(2);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((s >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        data[limit2] = (byte) (s & KotlinVersion.MAX_COMPONENT_VALUE);
        tail.limit = limit2 + 1;
        $this$commonWriteShort.setSize$okio($this$commonWriteShort.size() + 2);
        return $this$commonWriteShort;
    }

    public static final ni.shikatu.okio.Buffer commonWriteInt(ni.shikatu.okio.Buffer $this$commonWriteInt, int i) {
        Intrinsics.checkNotNullParameter($this$commonWriteInt, "<this>");
        Segment tail = $this$commonWriteInt.writableSegment$okio(4);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((i >>> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((i >>> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((i >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        data[limit4] = (byte) (i & KotlinVersion.MAX_COMPONENT_VALUE);
        tail.limit = limit4 + 1;
        $this$commonWriteInt.setSize$okio($this$commonWriteInt.size() + 4);
        return $this$commonWriteInt;
    }

    public static final ni.shikatu.okio.Buffer commonWriteLong(ni.shikatu.okio.Buffer $this$commonWriteLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteLong, "<this>");
        Segment tail = $this$commonWriteLong.writableSegment$okio(8);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((v >>> 56) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((v >>> 48) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((v >>> 40) & 255);
        int limit5 = limit4 + 1;
        data[limit4] = (byte) ((v >>> 32) & 255);
        int limit6 = limit5 + 1;
        data[limit5] = (byte) ((v >>> 24) & 255);
        int limit7 = limit6 + 1;
        data[limit6] = (byte) ((v >>> 16) & 255);
        int limit8 = limit7 + 1;
        data[limit7] = (byte) ((v >>> 8) & 255);
        data[limit8] = (byte) (v & 255);
        tail.limit = limit8 + 1;
        $this$commonWriteLong.setSize$okio($this$commonWriteLong.size() + 8);
        return $this$commonWriteLong;
    }

    public static final void commonWrite(ni.shikatu.okio.Buffer $this$commonWrite, ni.shikatu.okio.Buffer source, long byteCount) {
        Segment tail;
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long byteCount2 = byteCount;
        if (!(source != $this$commonWrite)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, byteCount2);
        while (byteCount2 > 0) {
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.limit;
            Segment segment2 = source.head;
            Intrinsics.checkNotNull(segment2);
            if (byteCount2 < i - segment2.pos) {
                if ($this$commonWrite.head != null) {
                    Segment segment3 = $this$commonWrite.head;
                    Intrinsics.checkNotNull(segment3);
                    tail = segment3.prev;
                } else {
                    tail = null;
                }
                if (tail != null && tail.owner) {
                    if ((((long) tail.limit) + byteCount2) - ((long) (tail.shared ? 0 : tail.pos)) <= 8192) {
                        Segment segment4 = source.head;
                        Intrinsics.checkNotNull(segment4);
                        segment4.writeTo(tail, (int) byteCount2);
                        source.setSize$okio(source.size() - byteCount2);
                        $this$commonWrite.setSize$okio($this$commonWrite.size() + byteCount2);
                        return;
                    }
                }
                Segment segment5 = source.head;
                Intrinsics.checkNotNull(segment5);
                source.head = segment5.split((int) byteCount2);
            }
            Segment tail2 = source.head;
            Intrinsics.checkNotNull(tail2);
            long movedByteCount = tail2.limit - tail2.pos;
            source.head = tail2.pop();
            if ($this$commonWrite.head == null) {
                $this$commonWrite.head = tail2;
                tail2.prev = tail2;
                tail2.next = tail2.prev;
            } else {
                Segment segment6 = $this$commonWrite.head;
                Intrinsics.checkNotNull(segment6);
                Segment tail3 = segment6.prev;
                Intrinsics.checkNotNull(tail3);
                tail3.push(tail2).compact();
            }
            source.setSize$okio(source.size() - movedByteCount);
            $this$commonWrite.setSize$okio($this$commonWrite.size() + movedByteCount);
            byteCount2 -= movedByteCount;
        }
    }

    public static final long commonRead(ni.shikatu.okio.Buffer $this$commonRead, ni.shikatu.okio.Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if ($this$commonRead.size() == 0) {
            return -1L;
        }
        long byteCount2 = byteCount > $this$commonRead.size() ? $this$commonRead.size() : byteCount;
        sink.write($this$commonRead, byteCount2);
        return byteCount2;
    }

    public static final long commonIndexOf(ni.shikatu.okio.Buffer $this$commonIndexOf, byte b, long fromIndex, long toIndex) {
        ni.shikatu.okio.Buffer $this$seek$iv;
        Segment s$iv;
        Intrinsics.checkNotNullParameter($this$commonIndexOf, "<this>");
        boolean z = false;
        if (0 <= fromIndex && fromIndex <= toIndex) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("size=" + $this$commonIndexOf.size() + " fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        long toIndex2 = toIndex > $this$commonIndexOf.size() ? $this$commonIndexOf.size() : toIndex;
        long j = -1;
        if (fromIndex != toIndex2 && (s$iv = ($this$seek$iv = $this$commonIndexOf).head) != null) {
            if ($this$seek$iv.size() - fromIndex < fromIndex) {
                long offset$iv = $this$seek$iv.size();
                while (offset$iv > fromIndex) {
                    long j2 = j;
                    Segment segment = s$iv.prev;
                    Intrinsics.checkNotNull(segment);
                    s$iv = segment;
                    offset$iv -= (long) (s$iv.limit - s$iv.pos);
                    j = j2;
                }
                long j3 = j;
                Segment s = s$iv;
                long offset = offset$iv;
                if (s == null) {
                    return j3;
                }
                long offset2 = offset;
                long fromIndex2 = fromIndex;
                Segment s2 = s;
                while (offset2 < toIndex2) {
                    byte[] data = s2.data;
                    long toIndex3 = toIndex2;
                    ni.shikatu.okio.Buffer $this$seek$iv2 = $this$seek$iv;
                    int limit = (int) Math.min(s2.limit, (((long) s2.pos) + toIndex3) - offset2);
                    for (int pos = (int) ((((long) s2.pos) + fromIndex2) - offset2); pos < limit; pos++) {
                        if (data[pos] == b) {
                            return ((long) (pos - s2.pos)) + offset2;
                        }
                    }
                    offset2 += (long) (s2.limit - s2.pos);
                    fromIndex2 = offset2;
                    Segment segment2 = s2.next;
                    Intrinsics.checkNotNull(segment2);
                    s2 = segment2;
                    toIndex2 = toIndex3;
                    $this$seek$iv = $this$seek$iv2;
                }
                return j3;
            }
            long toIndex4 = toIndex2;
            long offset$iv2 = 0;
            while (true) {
                long nextOffset$iv = ((long) (s$iv.limit - s$iv.pos)) + offset$iv2;
                if (nextOffset$iv > fromIndex) {
                    break;
                }
                Segment segment3 = s$iv.next;
                Intrinsics.checkNotNull(segment3);
                s$iv = segment3;
                offset$iv2 = nextOffset$iv;
            }
            Segment s3 = s$iv;
            long offset3 = offset$iv2;
            if (s3 == null) {
                return -1L;
            }
            Segment s4 = s3;
            long offset4 = offset3;
            long fromIndex3 = fromIndex;
            while (offset4 < toIndex4) {
                long offset$iv3 = offset$iv2;
                byte[] data2 = s4.data;
                Segment s5 = s3;
                long offset5 = offset3;
                int limit2 = (int) Math.min(s4.limit, (((long) s4.pos) + toIndex4) - offset4);
                for (int pos2 = (int) ((((long) s4.pos) + fromIndex3) - offset4); pos2 < limit2; pos2++) {
                    if (data2[pos2] == b) {
                        return ((long) (pos2 - s4.pos)) + offset4;
                    }
                }
                offset4 += (long) (s4.limit - s4.pos);
                fromIndex3 = offset4;
                Segment segment4 = s4.next;
                Intrinsics.checkNotNull(segment4);
                s4 = segment4;
                offset$iv2 = offset$iv3;
                s3 = s5;
                offset3 = offset5;
            }
            return -1L;
        }
        return -1L;
    }

    public static final long commonIndexOf(ni.shikatu.okio.Buffer $this$commonIndexOf, ByteString bytes, long fromIndex, long toIndex, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        SegmentedByteString.checkOffsetAndCount(bytes.size(), bytesOffset, byteCount);
        if (!(byteCount > 0)) {
            throw new IllegalArgumentException("byteCount == 0".toString());
        }
        if (!(fromIndex >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex).toString());
        }
        if (!(fromIndex <= toIndex)) {
            throw new IllegalArgumentException(("fromIndex > toIndex: " + fromIndex + " > " + toIndex).toString());
        }
        long toIndex2 = toIndex > $this$commonIndexOf.size() ? $this$commonIndexOf.size() : toIndex;
        if (fromIndex == toIndex2) {
            return -1L;
        }
        long fromIndex$iv = fromIndex;
        ni.shikatu.okio.Buffer $this$seek$iv = $this$commonIndexOf;
        Segment s$iv = $this$seek$iv.head;
        if (s$iv == null) {
            return -1L;
        }
        if ($this$seek$iv.size() - fromIndex$iv < fromIndex$iv) {
            long offset$iv = $this$seek$iv.size();
            while (offset$iv > fromIndex$iv) {
                Segment segment = s$iv.prev;
                Intrinsics.checkNotNull(segment);
                s$iv = segment;
                offset$iv -= (long) (s$iv.limit - s$iv.pos);
                $this$seek$iv = $this$seek$iv;
            }
            Segment s = s$iv;
            long offset = offset$iv;
            if (s == null) {
                return -1L;
            }
            Segment s2 = s;
            long offset2 = offset;
            byte[] targetByteArray = bytes.internalArray$okio();
            byte b0 = targetByteArray[bytesOffset];
            long resultLimit = Math.min(toIndex2, ($this$commonIndexOf.size() - ((long) byteCount)) + 1);
            long fromIndex2 = fromIndex;
            while (offset2 < resultLimit) {
                long resultLimit2 = resultLimit;
                byte[] data = s2.data;
                int a$iv = s2.limit;
                long fromIndex$iv2 = fromIndex$iv;
                long b$iv = (((long) s2.pos) + resultLimit2) - offset2;
                int segmentLimit = (int) Math.min(a$iv, b$iv);
                for (int pos = (int) ((((long) s2.pos) + fromIndex2) - offset2); pos < segmentLimit; pos++) {
                    if (data[pos] == b0 && rangeEquals(s2, pos + 1, targetByteArray, bytesOffset + 1, byteCount)) {
                        return ((long) (pos - s2.pos)) + offset2;
                    }
                }
                int pos2 = s2.limit;
                offset2 += (long) (pos2 - s2.pos);
                fromIndex2 = offset2;
                Segment segment2 = s2.next;
                Intrinsics.checkNotNull(segment2);
                s2 = segment2;
                resultLimit = resultLimit2;
                fromIndex$iv = fromIndex$iv2;
            }
            return -1L;
        }
        long offset$iv2 = 0;
        while (true) {
            long nextOffset$iv = ((long) (s$iv.limit - s$iv.pos)) + offset$iv2;
            if (nextOffset$iv > fromIndex$iv) {
                break;
            }
            Segment segment3 = s$iv.next;
            Intrinsics.checkNotNull(segment3);
            s$iv = segment3;
            offset$iv2 = nextOffset$iv;
        }
        Segment s3 = s$iv;
        long offset3 = offset$iv2;
        int i = 0;
        if (s3 == null) {
            return -1L;
        }
        Segment s4 = s3;
        long offset4 = offset3;
        byte[] targetByteArray2 = bytes.internalArray$okio();
        byte b1 = targetByteArray2[bytesOffset];
        long offset5 = byteCount;
        long resultLimit3 = Math.min(toIndex2, ($this$commonIndexOf.size() - offset5) + 1);
        long fromIndex3 = fromIndex;
        while (offset4 < resultLimit3) {
            Segment s5 = s3;
            byte[] data2 = s4.data;
            int a$iv2 = s4.limit;
            long resultLimit4 = resultLimit3;
            long b$iv2 = (((long) s4.pos) + resultLimit4) - offset4;
            long toIndex3 = toIndex2;
            int i2 = i;
            int a$iv3 = (int) Math.min(a$iv2, b$iv2);
            for (int pos3 = (int) ((((long) s4.pos) + fromIndex3) - offset4); pos3 < a$iv3; pos3++) {
                if (data2[pos3] == b1 && rangeEquals(s4, pos3 + 1, targetByteArray2, bytesOffset + 1, byteCount)) {
                    return ((long) (pos3 - s4.pos)) + offset4;
                }
            }
            int pos4 = s4.limit;
            offset4 += (long) (pos4 - s4.pos);
            fromIndex3 = offset4;
            Segment segment4 = s4.next;
            Intrinsics.checkNotNull(segment4);
            s4 = segment4;
            i = i2;
            s3 = s5;
            resultLimit3 = resultLimit4;
            toIndex2 = toIndex3;
        }
        return -1L;
    }

    public static final long commonIndexOfElement(ni.shikatu.okio.Buffer $this$commonIndexOfElement, ByteString targetBytes, long fromIndex) {
        ni.shikatu.okio.Buffer buffer = $this$commonIndexOfElement;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        int $i$f$commonIndexOfElement = 0;
        if (!(fromIndex >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex).toString());
        }
        ni.shikatu.okio.Buffer $this$seek$iv = $this$commonIndexOfElement;
        Segment s$iv = $this$seek$iv.head;
        long j = -1;
        if (s$iv == null) {
            return -1L;
        }
        if ($this$seek$iv.size() - fromIndex >= fromIndex) {
            long offset$iv = 0;
            while (true) {
                long nextOffset$iv = ((long) (s$iv.limit - s$iv.pos)) + offset$iv;
                if (nextOffset$iv > fromIndex) {
                    break;
                }
                Segment segment = s$iv.next;
                Intrinsics.checkNotNull(segment);
                s$iv = segment;
                offset$iv = nextOffset$iv;
            }
            Segment s = s$iv;
            long offset = offset$iv;
            if (s == null) {
                return -1L;
            }
            Segment s2 = s;
            long offset2 = offset;
            if (targetBytes.size() == 2) {
                int b0 = targetBytes.getByte(0);
                int b1 = targetBytes.getByte(1);
                long fromIndex2 = fromIndex;
                while (offset2 < $this$commonIndexOfElement.size()) {
                    byte[] data = s2.data;
                    long offset$iv2 = offset$iv;
                    long offset$iv3 = s2.pos;
                    int limit = s2.limit;
                    for (int pos = (int) ((offset$iv3 + fromIndex2) - offset2); pos < limit; pos++) {
                        int b = data[pos];
                        if (b == b0 || b == b1) {
                            int pos2 = pos;
                            int pos3 = s2.pos;
                            return ((long) (pos2 - pos3)) + offset2;
                        }
                    }
                    int pos4 = s2.limit;
                    offset2 += (long) (pos4 - s2.pos);
                    fromIndex2 = offset2;
                    Segment segment2 = s2.next;
                    Intrinsics.checkNotNull(segment2);
                    s2 = segment2;
                    offset$iv = offset$iv2;
                }
            } else {
                byte[] targetByteArray = targetBytes.internalArray$okio();
                long fromIndex3 = fromIndex;
                while (offset2 < $this$commonIndexOfElement.size()) {
                    byte[] data2 = s2.data;
                    int pos5 = (int) ((((long) s2.pos) + fromIndex3) - offset2);
                    int limit2 = s2.limit;
                    while (pos5 < limit2) {
                        byte b2 = data2[pos5];
                        byte[] data3 = data2;
                        int length = targetByteArray.length;
                        byte[] targetByteArray2 = targetByteArray;
                        int i = 0;
                        while (i < length) {
                            int i2 = i;
                            byte t = targetByteArray2[i2];
                            if (b2 == t) {
                                return ((long) (pos5 - s2.pos)) + offset2;
                            }
                            i = i2 + 1;
                        }
                        pos5++;
                        data2 = data3;
                        targetByteArray = targetByteArray2;
                    }
                    byte[] targetByteArray3 = targetByteArray;
                    offset2 += (long) (s2.limit - s2.pos);
                    fromIndex3 = offset2;
                    Segment segment3 = s2.next;
                    Intrinsics.checkNotNull(segment3);
                    s2 = segment3;
                    targetByteArray = targetByteArray3;
                }
            }
            return -1L;
        }
        long offset$iv4 = $this$seek$iv.size();
        while (offset$iv4 > fromIndex) {
            Segment segment4 = s$iv.prev;
            Intrinsics.checkNotNull(segment4);
            s$iv = segment4;
            offset$iv4 -= (long) (s$iv.limit - s$iv.pos);
            j = j;
        }
        long j2 = j;
        Segment s3 = s$iv;
        long offset3 = offset$iv4;
        if (s3 == null) {
            return j2;
        }
        long offset4 = offset3;
        if (targetBytes.size() == 2) {
            int b3 = targetBytes.getByte(0);
            int b4 = targetBytes.getByte(1);
            long fromIndex4 = fromIndex;
            Segment s4 = s3;
            while (offset4 < buffer.size()) {
                int $i$f$commonIndexOfElement2 = $i$f$commonIndexOfElement;
                byte[] data4 = s4.data;
                int b5 = (int) ((((long) s4.pos) + fromIndex4) - offset4);
                int limit3 = s4.limit;
                while (b5 < limit3) {
                    int pos6 = b5;
                    int pos7 = data4[pos6];
                    if (pos7 == b3 || pos7 == b4) {
                        int b6 = s4.pos;
                        return ((long) (pos6 - b6)) + offset4;
                    }
                    b5 = pos6 + 1;
                }
                int pos8 = s4.limit;
                offset4 += (long) (pos8 - s4.pos);
                fromIndex4 = offset4;
                Segment segment5 = s4.next;
                Intrinsics.checkNotNull(segment5);
                s4 = segment5;
                buffer = $this$commonIndexOfElement;
                $i$f$commonIndexOfElement = $i$f$commonIndexOfElement2;
            }
        } else {
            byte[] targetByteArray4 = targetBytes.internalArray$okio();
            long fromIndex5 = fromIndex;
            Segment s5 = s3;
            while (offset4 < $this$commonIndexOfElement.size()) {
                byte[] data5 = s5.data;
                int pos9 = (int) ((((long) s5.pos) + fromIndex5) - offset4);
                int limit4 = s5.limit;
                while (pos9 < limit4) {
                    byte b7 = data5[pos9];
                    ni.shikatu.okio.Buffer $this$seek$iv2 = $this$seek$iv;
                    int length2 = targetByteArray4.length;
                    byte[] targetByteArray5 = targetByteArray4;
                    int i3 = 0;
                    while (i3 < length2) {
                        int i4 = i3;
                        byte t2 = targetByteArray5[i4];
                        if (b7 == t2) {
                            return ((long) (pos9 - s5.pos)) + offset4;
                        }
                        i3 = i4 + 1;
                    }
                    pos9++;
                    $this$seek$iv = $this$seek$iv2;
                    targetByteArray4 = targetByteArray5;
                }
                byte[] targetByteArray6 = targetByteArray4;
                offset4 += (long) (s5.limit - s5.pos);
                fromIndex5 = offset4;
                Segment segment6 = s5.next;
                Intrinsics.checkNotNull(segment6);
                s5 = segment6;
                $this$seek$iv = $this$seek$iv;
                targetByteArray4 = targetByteArray6;
            }
        }
        return j2;
    }

    public static final boolean commonRangeEquals(ni.shikatu.okio.Buffer $this$commonRangeEquals, long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (byteCount >= 0 && offset >= 0 && ((long) byteCount) + offset <= $this$commonRangeEquals.size() && bytesOffset >= 0 && bytesOffset + byteCount <= bytes.size()) {
            return byteCount == 0 || commonIndexOf($this$commonRangeEquals, bytes, offset, offset + 1, bytesOffset, byteCount) != -1;
        }
        return false;
    }

    public static final boolean commonEquals(ni.shikatu.okio.Buffer $this$commonEquals, Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        if ($this$commonEquals == other) {
            return true;
        }
        if (!(other instanceof ni.shikatu.okio.Buffer) || $this$commonEquals.size() != ((ni.shikatu.okio.Buffer) other).size()) {
            return false;
        }
        if ($this$commonEquals.size() == 0) {
            return true;
        }
        Segment sa = $this$commonEquals.head;
        Intrinsics.checkNotNull(sa);
        Segment sb = ((ni.shikatu.okio.Buffer) other).head;
        Intrinsics.checkNotNull(sb);
        int posA = sa.pos;
        int posB = sb.pos;
        long pos = 0;
        while (pos < $this$commonEquals.size()) {
            long count = Math.min(sa.limit - posA, sb.limit - posB);
            long i = 0;
            while (i < count) {
                int posA2 = posA + 1;
                int posB2 = posB + 1;
                if (sa.data[posA] != sb.data[posB]) {
                    return false;
                }
                i++;
                posA = posA2;
                posB = posB2;
            }
            if (posA == sa.limit) {
                Segment sa2 = sa.next;
                Intrinsics.checkNotNull(sa2);
                posA = sa2.pos;
                sa = sa2;
            }
            if (posB == sb.limit) {
                Segment sb2 = sb.next;
                Intrinsics.checkNotNull(sb2);
                posB = sb2.pos;
                sb = sb2;
            }
            pos += count;
        }
        return true;
    }

    public static final int commonHashCode(ni.shikatu.okio.Buffer $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        Segment s = $this$commonHashCode.head;
        if (s == null) {
            return 0;
        }
        int result = 1;
        do {
            int limit = s.limit;
            for (int pos = s.pos; pos < limit; pos++) {
                result = (result * 31) + s.data[pos];
            }
            Segment segment = s.next;
            Intrinsics.checkNotNull(segment);
            s = segment;
        } while (s != $this$commonHashCode.head);
        return result;
    }

    public static final ni.shikatu.okio.Buffer commonCopy(ni.shikatu.okio.Buffer $this$commonCopy) {
        Intrinsics.checkNotNullParameter($this$commonCopy, "<this>");
        ni.shikatu.okio.Buffer result = new ni.shikatu.okio.Buffer();
        if ($this$commonCopy.size() == 0) {
            return result;
        }
        Segment head = $this$commonCopy.head;
        Intrinsics.checkNotNull(head);
        Segment headCopy = head.sharedCopy();
        result.head = headCopy;
        headCopy.prev = result.head;
        headCopy.next = headCopy.prev;
        for (Segment s = head.next; s != head; s = s.next) {
            Segment segment = headCopy.prev;
            Intrinsics.checkNotNull(segment);
            Intrinsics.checkNotNull(s);
            segment.push(s.sharedCopy());
        }
        result.setSize$okio($this$commonCopy.size());
        return result;
    }

    public static final ByteString commonSnapshot(ni.shikatu.okio.Buffer $this$commonSnapshot) {
        Intrinsics.checkNotNullParameter($this$commonSnapshot, "<this>");
        if (!($this$commonSnapshot.size() <= 2147483647L)) {
            throw new IllegalStateException(("size > Int.MAX_VALUE: " + $this$commonSnapshot.size()).toString());
        }
        return $this$commonSnapshot.snapshot((int) $this$commonSnapshot.size());
    }

    public static final ByteString commonSnapshot(ni.shikatu.okio.Buffer $this$commonSnapshot, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonSnapshot, "<this>");
        if (byteCount == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount($this$commonSnapshot.size(), 0L, byteCount);
        int offset = 0;
        int segmentCount = 0;
        Segment s = $this$commonSnapshot.head;
        while (offset < byteCount) {
            Intrinsics.checkNotNull(s);
            if (s.limit == s.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            offset += s.limit - s.pos;
            segmentCount++;
            s = s.next;
        }
        byte[][] segments = new byte[segmentCount][];
        int[] directory = new int[segmentCount * 2];
        int offset2 = 0;
        int segmentCount2 = 0;
        Segment s2 = $this$commonSnapshot.head;
        while (offset2 < byteCount) {
            Intrinsics.checkNotNull(s2);
            segments[segmentCount2] = s2.data;
            offset2 += s2.limit - s2.pos;
            directory[segmentCount2] = Math.min(offset2, byteCount);
            directory[segments.length + segmentCount2] = s2.pos;
            s2.shared = true;
            segmentCount2++;
            s2 = s2.next;
        }
        return new C0026SegmentedByteString(segments, directory);
    }

    public static final ni.shikatu.okio.Buffer.UnsafeCursor commonReadUnsafe(ni.shikatu.okio.Buffer $this$commonReadUnsafe, ni.shikatu.okio.Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter($this$commonReadUnsafe, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        ni.shikatu.okio.Buffer.UnsafeCursor unsafeCursor2 = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (!(unsafeCursor2.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor2.buffer = $this$commonReadUnsafe;
        unsafeCursor2.readWrite = false;
        return unsafeCursor2;
    }

    public static final ni.shikatu.okio.Buffer.UnsafeCursor commonReadAndWriteUnsafe(ni.shikatu.okio.Buffer $this$commonReadAndWriteUnsafe, ni.shikatu.okio.Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter($this$commonReadAndWriteUnsafe, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        ni.shikatu.okio.Buffer.UnsafeCursor unsafeCursor2 = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (!(unsafeCursor2.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor2.buffer = $this$commonReadAndWriteUnsafe;
        unsafeCursor2.readWrite = true;
        return unsafeCursor2;
    }

    public static final int commonNext(ni.shikatu.okio.Buffer.UnsafeCursor $this$commonNext) {
        Intrinsics.checkNotNullParameter($this$commonNext, "<this>");
        long j = $this$commonNext.offset;
        ni.shikatu.okio.Buffer buffer = $this$commonNext.buffer;
        Intrinsics.checkNotNull(buffer);
        if (j != buffer.size()) {
            return $this$commonNext.seek($this$commonNext.offset == -1 ? 0L : $this$commonNext.offset + ((long) ($this$commonNext.end - $this$commonNext.start)));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final int commonSeek(ni.shikatu.okio.Buffer.UnsafeCursor $this$commonSeek, long offset) {
        Segment next;
        long nextOffset;
        Intrinsics.checkNotNullParameter($this$commonSeek, "<this>");
        ni.shikatu.okio.Buffer buffer = $this$commonSeek.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (offset < -1 || offset > buffer.size()) {
            throw new ArrayIndexOutOfBoundsException("offset=" + offset + " > size=" + buffer.size());
        }
        if (offset == -1 || offset == buffer.size()) {
            $this$commonSeek.setSegment$okio(null);
            $this$commonSeek.offset = offset;
            $this$commonSeek.data = null;
            $this$commonSeek.start = -1;
            $this$commonSeek.end = -1;
            return -1;
        }
        long min = 0;
        long max = buffer.size();
        Segment head = buffer.head;
        Segment tail = buffer.head;
        if ($this$commonSeek.getSegment$okio() != null) {
            long j = $this$commonSeek.offset;
            int i = $this$commonSeek.start;
            Segment segment$okio = $this$commonSeek.getSegment$okio();
            Intrinsics.checkNotNull(segment$okio);
            long segmentOffset = j - ((long) (i - segment$okio.pos));
            if (segmentOffset > offset) {
                max = segmentOffset;
                tail = $this$commonSeek.getSegment$okio();
            } else {
                min = segmentOffset;
                head = $this$commonSeek.getSegment$okio();
            }
        }
        if (max - offset > offset - min) {
            next = head;
            nextOffset = min;
            while (true) {
                Intrinsics.checkNotNull(next);
                if (offset < ((long) (next.limit - next.pos)) + nextOffset) {
                    break;
                }
                nextOffset += (long) (next.limit - next.pos);
                next = next.next;
            }
        } else {
            next = tail;
            nextOffset = max;
            while (nextOffset > offset) {
                Intrinsics.checkNotNull(next);
                next = next.prev;
                Intrinsics.checkNotNull(next);
                nextOffset -= (long) (next.limit - next.pos);
            }
        }
        if ($this$commonSeek.readWrite) {
            Intrinsics.checkNotNull(next);
            if (next.shared) {
                Segment unsharedNext = next.unsharedCopy();
                if (buffer.head == next) {
                    buffer.head = unsharedNext;
                }
                next = next.push(unsharedNext);
                Segment segment = next.prev;
                Intrinsics.checkNotNull(segment);
                segment.pop();
            }
        }
        $this$commonSeek.setSegment$okio(next);
        $this$commonSeek.offset = offset;
        Intrinsics.checkNotNull(next);
        $this$commonSeek.data = next.data;
        $this$commonSeek.start = next.pos + ((int) (offset - nextOffset));
        $this$commonSeek.end = next.limit;
        return $this$commonSeek.end - $this$commonSeek.start;
    }

    public static final long commonResizeBuffer(ni.shikatu.okio.Buffer.UnsafeCursor $this$commonResizeBuffer, long newSize) {
        Intrinsics.checkNotNullParameter($this$commonResizeBuffer, "<this>");
        ni.shikatu.okio.Buffer buffer = $this$commonResizeBuffer.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!$this$commonResizeBuffer.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        long oldSize = buffer.size();
        int segmentBytesToAdd = 1;
        long j = 0;
        if (newSize <= oldSize) {
            if ((newSize < 0 ? 0 : 1) == 0) {
                throw new IllegalArgumentException(("newSize < 0: " + newSize).toString());
            }
            long bytesToSubtract = oldSize - newSize;
            while (bytesToSubtract > 0) {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                Segment tail = segment.prev;
                Intrinsics.checkNotNull(tail);
                int tailSize = tail.limit - tail.pos;
                if (tailSize <= bytesToSubtract) {
                    buffer.head = tail.pop();
                    SegmentPool.recycle(tail);
                    bytesToSubtract -= (long) tailSize;
                } else {
                    tail.limit -= (int) bytesToSubtract;
                    break;
                }
            }
            $this$commonResizeBuffer.setSegment$okio(null);
            $this$commonResizeBuffer.offset = newSize;
            $this$commonResizeBuffer.data = null;
            $this$commonResizeBuffer.start = -1;
            $this$commonResizeBuffer.end = -1;
        } else if (newSize > oldSize) {
            boolean needsToSeek = true;
            long bytesToAdd = newSize - oldSize;
            while (bytesToAdd > j) {
                Segment tail2 = buffer.writableSegment$okio(segmentBytesToAdd);
                int b$iv = 8192 - tail2.limit;
                long a$iv = bytesToAdd;
                int segmentBytesToAdd2 = (int) Math.min(a$iv, b$iv);
                tail2.limit += segmentBytesToAdd2;
                bytesToAdd -= (long) segmentBytesToAdd2;
                if (!needsToSeek) {
                    segmentBytesToAdd = 1;
                    j = 0;
                } else {
                    $this$commonResizeBuffer.setSegment$okio(tail2);
                    $this$commonResizeBuffer.offset = oldSize;
                    $this$commonResizeBuffer.data = tail2.data;
                    $this$commonResizeBuffer.start = tail2.limit - segmentBytesToAdd2;
                    $this$commonResizeBuffer.end = tail2.limit;
                    needsToSeek = false;
                    segmentBytesToAdd = 1;
                    j = 0;
                }
            }
        }
        buffer.setSize$okio(newSize);
        return oldSize;
    }

    public static final long commonExpandBuffer(ni.shikatu.okio.Buffer.UnsafeCursor $this$commonExpandBuffer, int minByteCount) {
        Intrinsics.checkNotNullParameter($this$commonExpandBuffer, "<this>");
        if (!(minByteCount > 0)) {
            throw new IllegalArgumentException(("minByteCount <= 0: " + minByteCount).toString());
        }
        if (!(minByteCount <= 8192)) {
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + minByteCount).toString());
        }
        ni.shikatu.okio.Buffer buffer = $this$commonExpandBuffer.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!$this$commonExpandBuffer.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        }
        long oldSize = buffer.size();
        Segment tail = buffer.writableSegment$okio(minByteCount);
        int result = 8192 - tail.limit;
        tail.limit = 8192;
        buffer.setSize$okio(((long) result) + oldSize);
        $this$commonExpandBuffer.setSegment$okio(tail);
        $this$commonExpandBuffer.offset = oldSize;
        $this$commonExpandBuffer.data = tail.data;
        $this$commonExpandBuffer.start = 8192 - result;
        $this$commonExpandBuffer.end = 8192;
        return result;
    }

    public static final void commonClose(ni.shikatu.okio.Buffer.UnsafeCursor $this$commonClose) {
        Intrinsics.checkNotNullParameter($this$commonClose, "<this>");
        if (!($this$commonClose.buffer != null)) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        $this$commonClose.buffer = null;
        $this$commonClose.setSegment$okio(null);
        $this$commonClose.offset = -1L;
        $this$commonClose.data = null;
        $this$commonClose.start = -1;
        $this$commonClose.end = -1;
    }
}
