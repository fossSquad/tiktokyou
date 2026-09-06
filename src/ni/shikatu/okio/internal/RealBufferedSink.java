package ni.shikatu.okio.internal;

import java.io.EOFException;
import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0080\b\u001a%\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\f\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0080\b\u001a%\u0010\f\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0011\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0013H\u0080\b\u001a%\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0080\b\u001a\u001d\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0018\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0080\b\u001a\r\u0010#\u001a\u00020\u0007*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0007*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010'\u001a\u00020(*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020\u000e*\u00020\u0002H\u0080\b¨\u0006*"}, d2 = {"commonWrite", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/RealBufferedSink;", "source", "Lni/shikatu/okio/Buffer;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/BufferedSink;", "byteString", "Lni/shikatu/okio/ByteString;", "offset", _UrlKt.FRAGMENT_ENCODE_SET, "commonWriteUtf8", "string", _UrlKt.FRAGMENT_ENCODE_SET, "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", _UrlKt.FRAGMENT_ENCODE_SET, "commonWriteAll", "Lni/shikatu/okio/Source;", "commonWriteByte", "b", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "v", "commonWriteLongLe", "commonWriteDecimalLong", "commonWriteHexadecimalUnsignedLong", "commonEmitCompleteSegments", "commonEmit", "commonFlush", "commonClose", "commonTimeout", "Lni/shikatu/okio/Timeout;", "commonToString", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RealBufferedSink {
    public static final void commonWrite(ni.shikatu.okio.RealBufferedSink $this$commonWrite, Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if ($this$commonWrite.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(source, byteCount);
        $this$commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(ni.shikatu.okio.RealBufferedSink $this$commonWrite, ByteString byteString) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if ($this$commonWrite.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(byteString);
        return $this$commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(ni.shikatu.okio.RealBufferedSink $this$commonWrite, ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if ($this$commonWrite.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(byteString, offset, byteCount);
        return $this$commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(ni.shikatu.okio.RealBufferedSink $this$commonWriteUtf8, String string) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if ($this$commonWriteUtf8.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteUtf8.bufferField.writeUtf8(string);
        return $this$commonWriteUtf8.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(ni.shikatu.okio.RealBufferedSink $this$commonWriteUtf8, String string, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if ($this$commonWriteUtf8.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteUtf8.bufferField.writeUtf8(string, beginIndex, endIndex);
        return $this$commonWriteUtf8.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8CodePoint(ni.shikatu.okio.RealBufferedSink $this$commonWriteUtf8CodePoint, int codePoint) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8CodePoint, "<this>");
        if ($this$commonWriteUtf8CodePoint.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteUtf8CodePoint.bufferField.writeUtf8CodePoint(codePoint);
        return $this$commonWriteUtf8CodePoint.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(ni.shikatu.okio.RealBufferedSink $this$commonWrite, byte[] source) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if ($this$commonWrite.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(source);
        return $this$commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(ni.shikatu.okio.RealBufferedSink $this$commonWrite, byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if ($this$commonWrite.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(source, offset, byteCount);
        return $this$commonWrite.emitCompleteSegments();
    }

    public static final long commonWriteAll(ni.shikatu.okio.RealBufferedSink $this$commonWriteAll, Source source) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonWriteAll, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long totalBytesRead = 0;
        while (true) {
            long readCount = source.read($this$commonWriteAll.bufferField, 8192L);
            if (readCount != -1) {
                totalBytesRead += readCount;
                $this$commonWriteAll.emitCompleteSegments();
            } else {
                return totalBytesRead;
            }
        }
    }

    public static final BufferedSink commonWrite(ni.shikatu.okio.RealBufferedSink $this$commonWrite, Source source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long byteCount2 = byteCount;
        while (byteCount2 > 0) {
            long read = source.read($this$commonWrite.bufferField, byteCount2);
            if (read == -1) {
                throw new EOFException();
            }
            byteCount2 -= read;
            $this$commonWrite.emitCompleteSegments();
        }
        return $this$commonWrite;
    }

    public static final BufferedSink commonWriteByte(ni.shikatu.okio.RealBufferedSink $this$commonWriteByte, int b) {
        Intrinsics.checkNotNullParameter($this$commonWriteByte, "<this>");
        if ($this$commonWriteByte.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteByte.bufferField.writeByte(b);
        return $this$commonWriteByte.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShort(ni.shikatu.okio.RealBufferedSink $this$commonWriteShort, int s) {
        Intrinsics.checkNotNullParameter($this$commonWriteShort, "<this>");
        if ($this$commonWriteShort.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteShort.bufferField.writeShort(s);
        return $this$commonWriteShort.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShortLe(ni.shikatu.okio.RealBufferedSink $this$commonWriteShortLe, int s) {
        Intrinsics.checkNotNullParameter($this$commonWriteShortLe, "<this>");
        if ($this$commonWriteShortLe.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteShortLe.bufferField.writeShortLe(s);
        return $this$commonWriteShortLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteInt(ni.shikatu.okio.RealBufferedSink $this$commonWriteInt, int i) {
        Intrinsics.checkNotNullParameter($this$commonWriteInt, "<this>");
        if ($this$commonWriteInt.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteInt.bufferField.writeInt(i);
        return $this$commonWriteInt.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteIntLe(ni.shikatu.okio.RealBufferedSink $this$commonWriteIntLe, int i) {
        Intrinsics.checkNotNullParameter($this$commonWriteIntLe, "<this>");
        if ($this$commonWriteIntLe.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteIntLe.bufferField.writeIntLe(i);
        return $this$commonWriteIntLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLong(ni.shikatu.okio.RealBufferedSink $this$commonWriteLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteLong, "<this>");
        if ($this$commonWriteLong.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteLong.bufferField.writeLong(v);
        return $this$commonWriteLong.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLongLe(ni.shikatu.okio.RealBufferedSink $this$commonWriteLongLe, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteLongLe, "<this>");
        if ($this$commonWriteLongLe.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteLongLe.bufferField.writeLongLe(v);
        return $this$commonWriteLongLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteDecimalLong(ni.shikatu.okio.RealBufferedSink $this$commonWriteDecimalLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteDecimalLong, "<this>");
        if ($this$commonWriteDecimalLong.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteDecimalLong.bufferField.writeDecimalLong(v);
        return $this$commonWriteDecimalLong.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(ni.shikatu.okio.RealBufferedSink $this$commonWriteHexadecimalUnsignedLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteHexadecimalUnsignedLong, "<this>");
        if ($this$commonWriteHexadecimalUnsignedLong.closed) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteHexadecimalUnsignedLong.bufferField.writeHexadecimalUnsignedLong(v);
        return $this$commonWriteHexadecimalUnsignedLong.emitCompleteSegments();
    }

    public static final BufferedSink commonEmitCompleteSegments(ni.shikatu.okio.RealBufferedSink $this$commonEmitCompleteSegments) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonEmitCompleteSegments, "<this>");
        if ($this$commonEmitCompleteSegments.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long byteCount = $this$commonEmitCompleteSegments.bufferField.completeSegmentByteCount();
        if (byteCount > 0) {
            $this$commonEmitCompleteSegments.sink.write($this$commonEmitCompleteSegments.bufferField, byteCount);
        }
        return $this$commonEmitCompleteSegments;
    }

    public static final BufferedSink commonEmit(ni.shikatu.okio.RealBufferedSink $this$commonEmit) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonEmit, "<this>");
        if ($this$commonEmit.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long byteCount = $this$commonEmit.bufferField.size();
        if (byteCount > 0) {
            $this$commonEmit.sink.write($this$commonEmit.bufferField, byteCount);
        }
        return $this$commonEmit;
    }

    public static final void commonFlush(ni.shikatu.okio.RealBufferedSink $this$commonFlush) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonFlush, "<this>");
        if ($this$commonFlush.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if ($this$commonFlush.bufferField.size() > 0) {
            $this$commonFlush.sink.write($this$commonFlush.bufferField, $this$commonFlush.bufferField.size());
        }
        $this$commonFlush.sink.flush();
    }

    public static final void commonClose(ni.shikatu.okio.RealBufferedSink $this$commonClose) throws Throwable {
        Intrinsics.checkNotNullParameter($this$commonClose, "<this>");
        if ($this$commonClose.closed) {
            return;
        }
        Throwable thrown = null;
        try {
            if ($this$commonClose.bufferField.size() > 0) {
                $this$commonClose.sink.write($this$commonClose.bufferField, $this$commonClose.bufferField.size());
            }
        } catch (Throwable e) {
            thrown = e;
        }
        try {
            $this$commonClose.sink.close();
        } catch (Throwable e2) {
            if (thrown == null) {
                thrown = e2;
            }
        }
        $this$commonClose.closed = true;
        if (thrown != null) {
            throw thrown;
        }
    }

    public static final Timeout commonTimeout(ni.shikatu.okio.RealBufferedSink $this$commonTimeout) {
        Intrinsics.checkNotNullParameter($this$commonTimeout, "<this>");
        return $this$commonTimeout.sink.timeout();
    }

    public static final String commonToString(ni.shikatu.okio.RealBufferedSink $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return "buffer(" + $this$commonToString.sink + ')';
    }
}
