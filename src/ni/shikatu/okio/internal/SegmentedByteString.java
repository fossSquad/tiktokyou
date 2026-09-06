package ni.shikatu.okio.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.C0026SegmentedByteString;
import ni.shikatu.okio.Segment;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a]\u0010\t\u001a\u00020\n*\u00020\u00072K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fH\u0080\bø\u0001\u0000\u001aj\u0010\t\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fH\u0082\b\u001a\u001d\u0010\u0015\u001a\u00020\u0016*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0001*\u00020\u0007H\u0080\b\u001a\r\u0010\u001a\u001a\u00020\r*\u00020\u0007H\u0080\b\u001a%\u0010\u001b\u001a\u00020\n*\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u001e\u001a\u00020\u001f*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u001e\u001a\u00020\u001f*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\"\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010%\u001a\u00020\u001f*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010&H\u0080\b\u001a\r\u0010'\u001a\u00020\u0001*\u00020\u0007H\u0080\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"binarySearch", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "value", "fromIndex", "toIndex", "segment", "Lni/shikatu/okio/SegmentedByteString;", "pos", "forEachSegment", _UrlKt.FRAGMENT_ENCODE_SET, "action", "Lni/shikatu/kotlin/Function3;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ParameterName;", "name", "data", "offset", "byteCount", "beginIndex", "endIndex", "commonSubstring", "Lni/shikatu/okio/ByteString;", "commonInternalGet", _UrlKt.FRAGMENT_ENCODE_SET, "commonGetSize", "commonToByteArray", "commonWrite", "buffer", "Lni/shikatu/okio/Buffer;", "commonRangeEquals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "otherOffset", "commonCopyInto", "target", "targetOffset", "commonEquals", _UrlKt.FRAGMENT_ENCODE_SET, "commonHashCode", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SegmentedByteString {
    public static final int binarySearch(int[] $this$binarySearch, int value, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        int left = fromIndex;
        int right = toIndex - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = $this$binarySearch[mid];
            if (midVal < value) {
                left = mid + 1;
            } else {
                if (midVal <= value) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return (-left) - 1;
    }

    public static final int segment(C0026SegmentedByteString $this$segment, int pos) {
        Intrinsics.checkNotNullParameter($this$segment, "<this>");
        int i = binarySearch($this$segment.getDirectory$okio(), pos + 1, 0, $this$segment.getSegments$okio().length);
        return i >= 0 ? i : ~i;
    }

    public static final void forEachSegment(C0026SegmentedByteString $this$forEachSegment, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter($this$forEachSegment, "<this>");
        Intrinsics.checkNotNullParameter(function3, "action");
        int segmentCount = $this$forEachSegment.getSegments$okio().length;
        int pos = 0;
        for (int s = 0; s < segmentCount; s++) {
            int segmentPos = $this$forEachSegment.getDirectory$okio()[segmentCount + s];
            int nextSegmentOffset = $this$forEachSegment.getDirectory$okio()[s];
            function3.invoke($this$forEachSegment.getSegments$okio()[s], Integer.valueOf(segmentPos), Integer.valueOf(nextSegmentOffset - pos));
            pos = nextSegmentOffset;
        }
    }

    private static final void forEachSegment(C0026SegmentedByteString $this$forEachSegment, int beginIndex, int endIndex, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int s = segment($this$forEachSegment, beginIndex);
        int pos = beginIndex;
        while (pos < endIndex) {
            int segmentOffset = s == 0 ? 0 : $this$forEachSegment.getDirectory$okio()[s - 1];
            int segmentSize = $this$forEachSegment.getDirectory$okio()[s] - segmentOffset;
            int segmentPos = $this$forEachSegment.getDirectory$okio()[$this$forEachSegment.getSegments$okio().length + s];
            int byteCount = Math.min(endIndex, segmentOffset + segmentSize) - pos;
            int offset = (pos - segmentOffset) + segmentPos;
            function3.invoke($this$forEachSegment.getSegments$okio()[s], Integer.valueOf(offset), Integer.valueOf(byteCount));
            pos += byteCount;
            s++;
        }
    }

    public static final ByteString commonSubstring(C0026SegmentedByteString $this$commonSubstring, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$commonSubstring, "<this>");
        int endIndex2 = ni.shikatu.okio.SegmentedByteString.resolveDefaultParameter($this$commonSubstring, endIndex);
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
        }
        if (!(endIndex2 <= $this$commonSubstring.size())) {
            throw new IllegalArgumentException(("endIndex=" + endIndex2 + " > length(" + $this$commonSubstring.size() + ')').toString());
        }
        int subLen = endIndex2 - beginIndex;
        if (!(subLen >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + endIndex2 + " < beginIndex=" + beginIndex).toString());
        }
        if (beginIndex == 0 && endIndex2 == $this$commonSubstring.size()) {
            return $this$commonSubstring;
        }
        if (beginIndex == endIndex2) {
            return ByteString.EMPTY;
        }
        int beginSegment = segment($this$commonSubstring, beginIndex);
        int endSegment = segment($this$commonSubstring, endIndex2 - 1);
        byte[][] newSegments = (byte[][]) ArraysKt.copyOfRange($this$commonSubstring.getSegments$okio(), beginSegment, endSegment + 1);
        int[] newDirectory = new int[newSegments.length * 2];
        int index = 0;
        int s = beginSegment;
        if (s <= endSegment) {
            while (true) {
                newDirectory[index] = Math.min($this$commonSubstring.getDirectory$okio()[s] - beginIndex, subLen);
                int index2 = index + 1;
                newDirectory[index + newSegments.length] = $this$commonSubstring.getDirectory$okio()[$this$commonSubstring.getSegments$okio().length + s];
                if (s == endSegment) {
                    break;
                }
                s++;
                index = index2;
            }
        }
        int segmentOffset = beginSegment != 0 ? $this$commonSubstring.getDirectory$okio()[beginSegment - 1] : 0;
        int length = newSegments.length;
        newDirectory[length] = newDirectory[length] + (beginIndex - segmentOffset);
        return new C0026SegmentedByteString(newSegments, newDirectory);
    }

    public static final byte commonInternalGet(C0026SegmentedByteString $this$commonInternalGet, int pos) {
        Intrinsics.checkNotNullParameter($this$commonInternalGet, "<this>");
        ni.shikatu.okio.SegmentedByteString.checkOffsetAndCount($this$commonInternalGet.getDirectory$okio()[$this$commonInternalGet.getSegments$okio().length - 1], pos, 1L);
        int segment = segment($this$commonInternalGet, pos);
        int segmentOffset = segment == 0 ? 0 : $this$commonInternalGet.getDirectory$okio()[segment - 1];
        int segmentPos = $this$commonInternalGet.getDirectory$okio()[$this$commonInternalGet.getSegments$okio().length + segment];
        return $this$commonInternalGet.getSegments$okio()[segment][(pos - segmentOffset) + segmentPos];
    }

    public static final int commonGetSize(C0026SegmentedByteString $this$commonGetSize) {
        Intrinsics.checkNotNullParameter($this$commonGetSize, "<this>");
        return $this$commonGetSize.getDirectory$okio()[$this$commonGetSize.getSegments$okio().length - 1];
    }

    public static final byte[] commonToByteArray(C0026SegmentedByteString $this$commonToByteArray) {
        Intrinsics.checkNotNullParameter($this$commonToByteArray, "<this>");
        byte[] result = new byte[$this$commonToByteArray.size()];
        int resultPos = 0;
        int segmentCount$iv = $this$commonToByteArray.getSegments$okio().length;
        int pos$iv = 0;
        for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
            int segmentPos$iv = $this$commonToByteArray.getDirectory$okio()[segmentCount$iv + s$iv];
            int nextSegmentOffset$iv = $this$commonToByteArray.getDirectory$okio()[s$iv];
            byte[] data = $this$commonToByteArray.getSegments$okio()[s$iv];
            int byteCount = nextSegmentOffset$iv - pos$iv;
            ArraysKt.copyInto(data, result, resultPos, segmentPos$iv, segmentPos$iv + byteCount);
            resultPos += byteCount;
            pos$iv = nextSegmentOffset$iv;
        }
        return result;
    }

    public static final void commonWrite(C0026SegmentedByteString $this$commonWrite, Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int $i$f$commonWrite = 0;
        int endIndex$iv = offset + byteCount;
        int s$iv = segment($this$commonWrite, offset);
        int pos$iv = offset;
        while (pos$iv < endIndex$iv) {
            int segmentOffset$iv = s$iv == 0 ? 0 : $this$commonWrite.getDirectory$okio()[s$iv - 1];
            int segmentSize$iv = $this$commonWrite.getDirectory$okio()[s$iv] - segmentOffset$iv;
            int segmentPos$iv = $this$commonWrite.getDirectory$okio()[$this$commonWrite.getSegments$okio().length + s$iv];
            int byteCount$iv = Math.min(endIndex$iv, segmentOffset$iv + segmentSize$iv) - pos$iv;
            int offset$iv = (pos$iv - segmentOffset$iv) + segmentPos$iv;
            byte[] data = $this$commonWrite.getSegments$okio()[s$iv];
            Segment segment = new Segment(data, offset$iv, offset$iv + byteCount$iv, true, false);
            int $i$f$commonWrite2 = $i$f$commonWrite;
            if (buffer.head == null) {
                segment.prev = segment;
                segment.next = segment.prev;
                buffer.head = segment.next;
            } else {
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(segment);
            }
            pos$iv += byteCount$iv;
            s$iv++;
            $i$f$commonWrite = $i$f$commonWrite2;
        }
        buffer.setSize$okio(buffer.size() + ((long) byteCount));
    }

    public static final boolean commonRangeEquals(C0026SegmentedByteString $this$commonRangeEquals, int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int $i$f$commonRangeEquals = 0;
        if (offset >= 0 && offset <= $this$commonRangeEquals.size() - byteCount) {
            int endIndex$iv = offset + byteCount;
            int s$iv = segment($this$commonRangeEquals, offset);
            int pos$iv = offset;
            int otherOffset2 = otherOffset;
            while (pos$iv < endIndex$iv) {
                int segmentOffset$iv = s$iv == 0 ? 0 : $this$commonRangeEquals.getDirectory$okio()[s$iv - 1];
                int segmentSize$iv = $this$commonRangeEquals.getDirectory$okio()[s$iv] - segmentOffset$iv;
                int segmentPos$iv = $this$commonRangeEquals.getDirectory$okio()[$this$commonRangeEquals.getSegments$okio().length + s$iv];
                int byteCount$iv = Math.min(endIndex$iv, segmentOffset$iv + segmentSize$iv) - pos$iv;
                int offset$iv = segmentPos$iv + (pos$iv - segmentOffset$iv);
                byte[] data = $this$commonRangeEquals.getSegments$okio()[s$iv];
                int offset2 = $i$f$commonRangeEquals;
                if (!other.rangeEquals(otherOffset2, data, offset$iv, byteCount$iv)) {
                    return false;
                }
                otherOffset2 += byteCount$iv;
                pos$iv += byteCount$iv;
                s$iv++;
                $i$f$commonRangeEquals = offset2;
            }
            return true;
        }
        return false;
    }

    public static final boolean commonRangeEquals(C0026SegmentedByteString $this$commonRangeEquals, int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int $i$f$commonRangeEquals = 0;
        if (offset < 0 || offset > $this$commonRangeEquals.size() - byteCount) {
            return false;
        }
        if (otherOffset >= 0 && otherOffset <= other.length - byteCount) {
            int endIndex$iv = offset + byteCount;
            int s$iv = segment($this$commonRangeEquals, offset);
            int pos$iv = offset;
            int otherOffset2 = otherOffset;
            while (pos$iv < endIndex$iv) {
                int segmentOffset$iv = s$iv == 0 ? 0 : $this$commonRangeEquals.getDirectory$okio()[s$iv - 1];
                int segmentSize$iv = $this$commonRangeEquals.getDirectory$okio()[s$iv] - segmentOffset$iv;
                int segmentPos$iv = $this$commonRangeEquals.getDirectory$okio()[$this$commonRangeEquals.getSegments$okio().length + s$iv];
                int byteCount$iv = Math.min(endIndex$iv, segmentOffset$iv + segmentSize$iv) - pos$iv;
                int offset$iv = segmentPos$iv + (pos$iv - segmentOffset$iv);
                byte[] data = $this$commonRangeEquals.getSegments$okio()[s$iv];
                int offset2 = $i$f$commonRangeEquals;
                if (!ni.shikatu.okio.SegmentedByteString.arrayRangeEquals(data, offset$iv, other, otherOffset2, byteCount$iv)) {
                    return false;
                }
                otherOffset2 += byteCount$iv;
                pos$iv += byteCount$iv;
                s$iv++;
                $i$f$commonRangeEquals = offset2;
            }
            return true;
        }
        return false;
    }

    public static final void commonCopyInto(C0026SegmentedByteString $this$commonCopyInto, int offset, byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonCopyInto, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        int $i$f$commonCopyInto = 0;
        ni.shikatu.okio.SegmentedByteString.checkOffsetAndCount($this$commonCopyInto.size(), offset, byteCount);
        ni.shikatu.okio.SegmentedByteString.checkOffsetAndCount(target.length, targetOffset, byteCount);
        int endIndex$iv = offset + byteCount;
        int s$iv = segment($this$commonCopyInto, offset);
        int pos$iv = offset;
        int targetOffset2 = targetOffset;
        while (pos$iv < endIndex$iv) {
            int segmentOffset$iv = s$iv == 0 ? 0 : $this$commonCopyInto.getDirectory$okio()[s$iv - 1];
            int segmentSize$iv = $this$commonCopyInto.getDirectory$okio()[s$iv] - segmentOffset$iv;
            int segmentPos$iv = $this$commonCopyInto.getDirectory$okio()[$this$commonCopyInto.getSegments$okio().length + s$iv];
            int byteCount$iv = Math.min(endIndex$iv, segmentOffset$iv + segmentSize$iv) - pos$iv;
            int offset$iv = segmentPos$iv + (pos$iv - segmentOffset$iv);
            byte[] data = $this$commonCopyInto.getSegments$okio()[s$iv];
            int segmentPos$iv2 = offset$iv + byteCount$iv;
            ArraysKt.copyInto(data, target, targetOffset2, offset$iv, segmentPos$iv2);
            targetOffset2 += byteCount$iv;
            pos$iv += byteCount$iv;
            s$iv++;
            $i$f$commonCopyInto = $i$f$commonCopyInto;
        }
    }

    public static final boolean commonEquals(C0026SegmentedByteString $this$commonEquals, Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        if (other == $this$commonEquals) {
            return true;
        }
        if (other instanceof ByteString) {
            return ((ByteString) other).size() == $this$commonEquals.size() && $this$commonEquals.rangeEquals(0, (ByteString) other, 0, $this$commonEquals.size());
        }
        return false;
    }

    public static final int commonHashCode(C0026SegmentedByteString $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        int result = $this$commonHashCode.getHashCode$okio();
        if (result != 0) {
            return result;
        }
        int result2 = 1;
        int segmentCount$iv = $this$commonHashCode.getSegments$okio().length;
        int pos$iv = 0;
        for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
            int segmentPos$iv = $this$commonHashCode.getDirectory$okio()[segmentCount$iv + s$iv];
            int nextSegmentOffset$iv = $this$commonHashCode.getDirectory$okio()[s$iv];
            byte[] data = $this$commonHashCode.getSegments$okio()[s$iv];
            int byteCount = nextSegmentOffset$iv - pos$iv;
            int limit = segmentPos$iv + byteCount;
            for (int i = segmentPos$iv; i < limit; i++) {
                result2 = (result2 * 31) + data[i];
            }
            pos$iv = nextSegmentOffset$iv;
        }
        $this$commonHashCode.setHashCode$okio(result2);
        return result2;
    }
}
