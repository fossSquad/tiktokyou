package ni.shikatu.okio.internal;

import java.io.EOFException;
import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.text.CharsKt;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Options;
import ni.shikatu.okio.PeekSource;
import ni.shikatu.okio.SegmentedByteString;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0007*\u00020\u0002H\u0080\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0080\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0015\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0000\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0010H\u0080\b\u001a\u001d\u0010\u0015\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0018H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0080\b\u001a\r\u0010!\u001a\u00020 *\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010'\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\u0015\u0010(\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a%\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0080\b\u001a:\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010,\u001a\u00020\u0001H\u0000\u001a4\u0010/\u001a\u00020\u0007*\u00020\u00042\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0002\u001a\u001d\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00101\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0001H\u0080\b\u001a-\u00102\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0010H\u0080\b\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0080\b\u001a\r\u00105\u001a\u00020\t*\u00020\u0002H\u0080\b\u001a\r\u00106\u001a\u000207*\u00020\u0002H\u0080\b\u001a\r\u00108\u001a\u00020\u001a*\u00020\u0002H\u0080\b¨\u00069"}, d2 = {"commonRead", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/RealBufferedSource;", "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "commonExhausted", _UrlKt.FRAGMENT_ENCODE_SET, "commonRequire", _UrlKt.FRAGMENT_ENCODE_SET, "commonRequest", "commonReadByte", _UrlKt.FRAGMENT_ENCODE_SET, "commonReadByteString", "Lni/shikatu/okio/ByteString;", "commonSelect", _UrlKt.FRAGMENT_ENCODE_SET, "options", "Lni/shikatu/okio/Options;", "commonReadByteArray", _UrlKt.FRAGMENT_ENCODE_SET, "commonReadFully", "offset", "commonReadAll", "Lni/shikatu/okio/Sink;", "commonReadUtf8", _UrlKt.FRAGMENT_ENCODE_SET, "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonReadUtf8CodePoint", "commonReadShort", _UrlKt.FRAGMENT_ENCODE_SET, "commonReadShortLe", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonSkip", "commonIndexOf", "b", "fromIndex", "toIndex", "bytes", "bytesOffset", "isMatchPossibleByExpandingBuffer", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonPeek", "Lni/shikatu/okio/BufferedSource;", "commonClose", "commonTimeout", "Lni/shikatu/okio/Timeout;", "commonToString", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RealBufferedSource {
    public static final long commonRead(ni.shikatu.okio.RealBufferedSource $this$commonRead, Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if ($this$commonRead.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if ($this$commonRead.bufferField.size() == 0) {
            if (byteCount == 0) {
                return 0L;
            }
            long read = $this$commonRead.source.read($this$commonRead.bufferField, 8192L);
            if (read == -1) {
                return -1L;
            }
        }
        long toRead = Math.min(byteCount, $this$commonRead.bufferField.size());
        return $this$commonRead.bufferField.read(sink, toRead);
    }

    public static final boolean commonExhausted(ni.shikatu.okio.RealBufferedSource $this$commonExhausted) {
        Intrinsics.checkNotNullParameter($this$commonExhausted, "<this>");
        if ($this$commonExhausted.closed) {
            throw new IllegalStateException("closed".toString());
        }
        return $this$commonExhausted.bufferField.exhausted() && $this$commonExhausted.source.read($this$commonExhausted.bufferField, 8192L) == -1;
    }

    public static final void commonRequire(ni.shikatu.okio.RealBufferedSource $this$commonRequire, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonRequire, "<this>");
        if (!$this$commonRequire.request(byteCount)) {
            throw new EOFException();
        }
    }

    public static final boolean commonRequest(ni.shikatu.okio.RealBufferedSource $this$commonRequest, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRequest, "<this>");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if ($this$commonRequest.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while ($this$commonRequest.bufferField.size() < byteCount) {
            if ($this$commonRequest.source.read($this$commonRequest.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final byte commonReadByte(ni.shikatu.okio.RealBufferedSource $this$commonReadByte) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadByte, "<this>");
        $this$commonReadByte.require(1L);
        return $this$commonReadByte.bufferField.readByte();
    }

    public static final ByteString commonReadByteString(ni.shikatu.okio.RealBufferedSource $this$commonReadByteString) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadByteString, "<this>");
        $this$commonReadByteString.bufferField.writeAll($this$commonReadByteString.source);
        return $this$commonReadByteString.bufferField.readByteString();
    }

    public static final ByteString commonReadByteString(ni.shikatu.okio.RealBufferedSource $this$commonReadByteString, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadByteString, "<this>");
        $this$commonReadByteString.require(byteCount);
        return $this$commonReadByteString.bufferField.readByteString(byteCount);
    }

    public static final int commonSelect(ni.shikatu.okio.RealBufferedSource $this$commonSelect, Options options) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonSelect, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        if ($this$commonSelect.closed) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int index = Buffer.selectPrefix($this$commonSelect.bufferField, options, true);
            switch (index) {
                case -2:
                    break;
                case -1:
                    return -1;
                default:
                    int selectedSize = options.getByteStrings$okio()[index].size();
                    $this$commonSelect.bufferField.skip(selectedSize);
                    return index;
            }
        } while ($this$commonSelect.source.read($this$commonSelect.bufferField, 8192L) != -1);
        return -1;
    }

    public static final byte[] commonReadByteArray(ni.shikatu.okio.RealBufferedSource $this$commonReadByteArray) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadByteArray, "<this>");
        $this$commonReadByteArray.bufferField.writeAll($this$commonReadByteArray.source);
        return $this$commonReadByteArray.bufferField.readByteArray();
    }

    public static final byte[] commonReadByteArray(ni.shikatu.okio.RealBufferedSource $this$commonReadByteArray, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadByteArray, "<this>");
        $this$commonReadByteArray.require(byteCount);
        return $this$commonReadByteArray.bufferField.readByteArray(byteCount);
    }

    public static final void commonReadFully(ni.shikatu.okio.RealBufferedSource $this$commonReadFully, byte[] sink) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadFully, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            $this$commonReadFully.require(sink.length);
            $this$commonReadFully.bufferField.readFully(sink);
        } catch (EOFException e) {
            int offset = 0;
            while ($this$commonReadFully.bufferField.size() > 0) {
                int read = $this$commonReadFully.bufferField.read(sink, offset, (int) $this$commonReadFully.bufferField.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                offset += read;
            }
            throw e;
        }
    }

    public static final int commonRead(ni.shikatu.okio.RealBufferedSource $this$commonRead, byte[] sink, int offset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, offset, byteCount);
        if ($this$commonRead.bufferField.size() == 0) {
            if (byteCount == 0) {
                return 0;
            }
            long read = $this$commonRead.source.read($this$commonRead.bufferField, 8192L);
            if (read == -1) {
                return -1;
            }
        }
        long b$iv = $this$commonRead.bufferField.size();
        int toRead = (int) Math.min(byteCount, b$iv);
        return $this$commonRead.bufferField.read(sink, offset, toRead);
    }

    public static final void commonReadFully(ni.shikatu.okio.RealBufferedSource $this$commonReadFully, Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadFully, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            $this$commonReadFully.require(byteCount);
            $this$commonReadFully.bufferField.readFully(sink, byteCount);
        } catch (EOFException e) {
            sink.writeAll($this$commonReadFully.bufferField);
            throw e;
        }
    }

    public static final long commonReadAll(ni.shikatu.okio.RealBufferedSource $this$commonReadAll, Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadAll, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long totalBytesWritten = 0;
        while ($this$commonReadAll.source.read($this$commonReadAll.bufferField, 8192L) != -1) {
            long emitByteCount = $this$commonReadAll.bufferField.completeSegmentByteCount();
            if (emitByteCount > 0) {
                totalBytesWritten += emitByteCount;
                sink.write($this$commonReadAll.bufferField, emitByteCount);
            }
        }
        if ($this$commonReadAll.bufferField.size() > 0) {
            long totalBytesWritten2 = totalBytesWritten + $this$commonReadAll.bufferField.size();
            sink.write($this$commonReadAll.bufferField, $this$commonReadAll.bufferField.size());
            return totalBytesWritten2;
        }
        return totalBytesWritten;
    }

    public static final String commonReadUtf8(ni.shikatu.okio.RealBufferedSource $this$commonReadUtf8) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8, "<this>");
        $this$commonReadUtf8.bufferField.writeAll($this$commonReadUtf8.source);
        return $this$commonReadUtf8.bufferField.readUtf8();
    }

    public static final String commonReadUtf8(ni.shikatu.okio.RealBufferedSource $this$commonReadUtf8, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8, "<this>");
        $this$commonReadUtf8.require(byteCount);
        return $this$commonReadUtf8.bufferField.readUtf8(byteCount);
    }

    public static final String commonReadUtf8Line(ni.shikatu.okio.RealBufferedSource $this$commonReadUtf8Line) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8Line, "<this>");
        long newline = $this$commonReadUtf8Line.indexOf((byte) 10);
        if (newline != -1) {
            return Buffer.readUtf8Line($this$commonReadUtf8Line.bufferField, newline);
        }
        if ($this$commonReadUtf8Line.bufferField.size() != 0) {
            return $this$commonReadUtf8Line.readUtf8($this$commonReadUtf8Line.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(ni.shikatu.okio.RealBufferedSource $this$commonReadUtf8LineStrict, long limit) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8LineStrict, "<this>");
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long scanLength = limit == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
        long newline = $this$commonReadUtf8LineStrict.indexOf((byte) 10, 0L, scanLength);
        if (newline != -1) {
            return Buffer.readUtf8Line($this$commonReadUtf8LineStrict.bufferField, newline);
        }
        if (scanLength < LongCompanionObject.MAX_VALUE && $this$commonReadUtf8LineStrict.request(scanLength) && $this$commonReadUtf8LineStrict.bufferField.getByte(scanLength - 1) == 13 && $this$commonReadUtf8LineStrict.request(scanLength + 1) && $this$commonReadUtf8LineStrict.bufferField.getByte(scanLength) == 10) {
            return Buffer.readUtf8Line($this$commonReadUtf8LineStrict.bufferField, scanLength);
        }
        Buffer data = new Buffer();
        Buffer buffer = $this$commonReadUtf8LineStrict.bufferField;
        long b$iv = $this$commonReadUtf8LineStrict.bufferField.size();
        buffer.copyTo(data, 0L, Math.min(32, b$iv));
        throw new EOFException("\\n not found: limit=" + Math.min($this$commonReadUtf8LineStrict.bufferField.size(), limit) + " content=" + data.readByteString().hex() + Typography.ellipsis);
    }

    public static final int commonReadUtf8CodePoint(ni.shikatu.okio.RealBufferedSource $this$commonReadUtf8CodePoint) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8CodePoint, "<this>");
        $this$commonReadUtf8CodePoint.require(1L);
        int b0 = $this$commonReadUtf8CodePoint.bufferField.getByte(0L);
        if ((b0 & 224) == 192) {
            $this$commonReadUtf8CodePoint.require(2L);
        } else if ((b0 & 240) == 224) {
            $this$commonReadUtf8CodePoint.require(3L);
        } else if ((b0 & 248) == 240) {
            $this$commonReadUtf8CodePoint.require(4L);
        }
        return $this$commonReadUtf8CodePoint.bufferField.readUtf8CodePoint();
    }

    public static final short commonReadShort(ni.shikatu.okio.RealBufferedSource $this$commonReadShort) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadShort, "<this>");
        $this$commonReadShort.require(2L);
        return $this$commonReadShort.bufferField.readShort();
    }

    public static final short commonReadShortLe(ni.shikatu.okio.RealBufferedSource $this$commonReadShortLe) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadShortLe, "<this>");
        $this$commonReadShortLe.require(2L);
        return $this$commonReadShortLe.bufferField.readShortLe();
    }

    public static final int commonReadInt(ni.shikatu.okio.RealBufferedSource $this$commonReadInt) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadInt, "<this>");
        $this$commonReadInt.require(4L);
        return $this$commonReadInt.bufferField.readInt();
    }

    public static final int commonReadIntLe(ni.shikatu.okio.RealBufferedSource $this$commonReadIntLe) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadIntLe, "<this>");
        $this$commonReadIntLe.require(4L);
        return $this$commonReadIntLe.bufferField.readIntLe();
    }

    public static final long commonReadLong(ni.shikatu.okio.RealBufferedSource $this$commonReadLong) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadLong, "<this>");
        $this$commonReadLong.require(8L);
        return $this$commonReadLong.bufferField.readLong();
    }

    public static final long commonReadLongLe(ni.shikatu.okio.RealBufferedSource $this$commonReadLongLe) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadLongLe, "<this>");
        $this$commonReadLongLe.require(8L);
        return $this$commonReadLongLe.bufferField.readLongLe();
    }

    public static final long commonReadDecimalLong(ni.shikatu.okio.RealBufferedSource $this$commonReadDecimalLong) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadDecimalLong, "<this>");
        $this$commonReadDecimalLong.require(1L);
        for (long pos = 0; $this$commonReadDecimalLong.request(pos + 1); pos++) {
            byte b = $this$commonReadDecimalLong.bufferField.getByte(pos);
            if ((b < 48 || b > 57) && !(pos == 0 && b == 45)) {
                if (pos != 0) {
                    break;
                }
                StringBuilder sbAppend = new StringBuilder().append("Expected a digit or '-' but was 0x");
                String string = Integer.toString(b, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new NumberFormatException(sbAppend.append(string).toString());
            }
        }
        return $this$commonReadDecimalLong.bufferField.readDecimalLong();
    }

    public static final long commonReadHexadecimalUnsignedLong(ni.shikatu.okio.RealBufferedSource $this$commonReadHexadecimalUnsignedLong) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonReadHexadecimalUnsignedLong, "<this>");
        $this$commonReadHexadecimalUnsignedLong.require(1L);
        for (int pos = 0; $this$commonReadHexadecimalUnsignedLong.request(pos + 1); pos++) {
            byte b = $this$commonReadHexadecimalUnsignedLong.bufferField.getByte(pos);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                if (pos != 0) {
                    break;
                }
                StringBuilder sbAppend = new StringBuilder().append("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(b, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new NumberFormatException(sbAppend.append(string).toString());
            }
        }
        return $this$commonReadHexadecimalUnsignedLong.bufferField.readHexadecimalUnsignedLong();
    }

    public static final void commonSkip(ni.shikatu.okio.RealBufferedSource $this$commonSkip, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter($this$commonSkip, "<this>");
        long byteCount2 = byteCount;
        if ($this$commonSkip.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (byteCount2 > 0) {
            if ($this$commonSkip.bufferField.size() == 0 && $this$commonSkip.source.read($this$commonSkip.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long toSkip = Math.min(byteCount2, $this$commonSkip.bufferField.size());
            $this$commonSkip.bufferField.skip(toSkip);
            byteCount2 -= toSkip;
        }
    }

    public static final long commonIndexOf(ni.shikatu.okio.RealBufferedSource $this$commonIndexOf, byte b, long fromIndex, long toIndex) {
        Intrinsics.checkNotNullParameter($this$commonIndexOf, "<this>");
        if ($this$commonIndexOf.closed) {
            throw new IllegalStateException("closed".toString());
        }
        boolean z = false;
        if (0 <= fromIndex && fromIndex <= toIndex) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        long fromIndex2 = fromIndex;
        while (fromIndex2 < toIndex) {
            long result = $this$commonIndexOf.bufferField.indexOf(b, fromIndex2, toIndex);
            if (result != -1) {
                return result;
            }
            long lastBufferSize = $this$commonIndexOf.bufferField.size();
            if (lastBufferSize >= toIndex || $this$commonIndexOf.source.read($this$commonIndexOf.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex2 = Math.max(fromIndex2, lastBufferSize);
        }
        return -1L;
    }

    public static final long commonIndexOf(ni.shikatu.okio.RealBufferedSource $this$commonIndexOf, ByteString bytes, int bytesOffset, int byteCount, long fromIndex, long toIndex) {
        int i = byteCount;
        Intrinsics.checkNotNullParameter($this$commonIndexOf, "<this>");
        ByteString byteString = bytes;
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        int i2 = bytesOffset;
        SegmentedByteString.checkOffsetAndCount(byteString.size(), i2, i);
        if ($this$commonIndexOf.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long fromIndex2 = fromIndex;
        while (true) {
            int i3 = i2;
            long fromIndex3 = fromIndex2;
            long result = Buffer.commonIndexOf($this$commonIndexOf.bufferField, byteString, fromIndex3, toIndex, i3, i);
            if (result != -1) {
                return result;
            }
            long lastBufferSize = $this$commonIndexOf.bufferField.size();
            long nextFromIndex = (lastBufferSize - ((long) i)) + 1;
            if (nextFromIndex >= toIndex || !isMatchPossibleByExpandingBuffer($this$commonIndexOf.bufferField, bytes, bytesOffset, i, fromIndex3, toIndex) || $this$commonIndexOf.source.read($this$commonIndexOf.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex2 = Math.max(fromIndex3, nextFromIndex);
            byteString = bytes;
            i2 = bytesOffset;
            i = byteCount;
        }
    }

    private static final boolean isMatchPossibleByExpandingBuffer(Buffer $this$isMatchPossibleByExpandingBuffer, ByteString bytes, int bytesOffset, int byteCount, long fromIndex, long toIndex) {
        if ($this$isMatchPossibleByExpandingBuffer.size() < toIndex) {
            return true;
        }
        int begin = (int) Math.max(1L, ($this$isMatchPossibleByExpandingBuffer.size() - toIndex) + 1);
        long b$iv = ($this$isMatchPossibleByExpandingBuffer.size() - fromIndex) + 1;
        int limit = (int) Math.min(byteCount, b$iv);
        int i = limit - 1;
        if (begin <= i) {
            for (int i2 = i; !$this$isMatchPossibleByExpandingBuffer.rangeEquals($this$isMatchPossibleByExpandingBuffer.size() - ((long) i2), bytes, bytesOffset, i2); i2--) {
                if (i2 == begin) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static final long commonIndexOfElement(ni.shikatu.okio.RealBufferedSource $this$commonIndexOfElement, ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonIndexOfElement, "<this>");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long fromIndex2 = fromIndex;
        if ($this$commonIndexOfElement.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long result = $this$commonIndexOfElement.bufferField.indexOfElement(targetBytes, fromIndex2);
            if (result != -1) {
                return result;
            }
            long lastBufferSize = $this$commonIndexOfElement.bufferField.size();
            if ($this$commonIndexOfElement.source.read($this$commonIndexOfElement.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex2 = Math.max(fromIndex2, lastBufferSize);
        }
    }

    public static final boolean commonRangeEquals(ni.shikatu.okio.RealBufferedSource $this$commonRangeEquals, long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if ($this$commonRangeEquals.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (byteCount < 0 || offset < 0 || bytesOffset < 0 || bytesOffset + byteCount > bytes.size()) {
            return false;
        }
        if (byteCount != 0 && commonIndexOf($this$commonRangeEquals, bytes, bytesOffset, byteCount, offset, offset + 1) == -1) {
            return false;
        }
        return true;
    }

    public static final BufferedSource commonPeek(ni.shikatu.okio.RealBufferedSource $this$commonPeek) {
        Intrinsics.checkNotNullParameter($this$commonPeek, "<this>");
        return Okio.buffer(new PeekSource($this$commonPeek));
    }

    public static final void commonClose(ni.shikatu.okio.RealBufferedSource $this$commonClose) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonClose, "<this>");
        if ($this$commonClose.closed) {
            return;
        }
        $this$commonClose.closed = true;
        $this$commonClose.source.close();
        $this$commonClose.bufferField.clear();
    }

    public static final Timeout commonTimeout(ni.shikatu.okio.RealBufferedSource $this$commonTimeout) {
        Intrinsics.checkNotNullParameter($this$commonTimeout, "<this>");
        return $this$commonTimeout.source.timeout();
    }

    public static final String commonToString(ni.shikatu.okio.RealBufferedSource $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return "buffer(" + $this$commonToString.source + ')';
    }
}
