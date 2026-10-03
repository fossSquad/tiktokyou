package ni.shikatu.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J(\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\"H\u0016J \u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0017H\u0016J\u0010\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020%H\u0016J\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0017H\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0017H\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0017H\u0016J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0017H\u0016J\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0013H\u0016J\u0010\u00100\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0013H\u0016J\u0010\u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0013H\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0013H\u0016J\b\u00103\u001a\u00020\u0001H\u0016J\b\u00104\u001a\u00020\u0001H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0010H\u0016J\b\u00108\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u00078Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006="}, d2 = {"Lni/shikatu/okio/RealBufferedSink;", "Lni/shikatu/okio/BufferedSink;", "sink", "Lni/shikatu/okio/Sink;", "<init>", "(Lokio/Sink;)V", "bufferField", "Lni/shikatu/okio/Buffer;", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "buffer", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "byteString", "Lni/shikatu/okio/ByteString;", "offset", _UrlKt.FRAGMENT_ENCODE_SET, "writeUtf8", "string", _UrlKt.FRAGMENT_ENCODE_SET, "beginIndex", "endIndex", "writeUtf8CodePoint", "codePoint", "writeString", "charset", "Ljava/nio/charset/Charset;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/nio/ByteBuffer;", "writeAll", "Lni/shikatu/okio/Source;", "writeByte", "b", "writeShort", "s", "writeShortLe", "writeInt", "i", "writeIntLe", "writeLong", "v", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "emitCompleteSegments", "emit", "outputStream", "Ljava/io/OutputStream;", "flush", "isOpen", "close", "timeout", "Lni/shikatu/okio/Timeout;", "toString", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public static  void getBuffer$annotations() {
    }

    public RealBufferedSink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    @Override
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override
    public void write(Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source, byteCount);
        emitCompleteSegments();
    }

    @Override
    public BufferedSink write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(byteString);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink write(ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(byteString, offset, byteCount);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8(string);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeUtf8(String string, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8(string, beginIndex, endIndex);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeUtf8CodePoint(int codePoint) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8CodePoint(codePoint);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeString(String string, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeString(string, charset);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeString(String string, int beginIndex, int endIndex, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeString(string, beginIndex, endIndex, charset);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink write(byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source, offset, byteCount);
        return emitCompleteSegments();
    }

    @Override
    public int write(ByteBuffer source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        int result = this.bufferField.write(source);
        emitCompleteSegments();
        return result;
    }

    @Override
    public long writeAll(Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long totalBytesRead$iv = 0;
        while (true) {
            long readCount$iv = source.read(this.bufferField, 8192L);
            if (readCount$iv == -1) {
                return totalBytesRead$iv;
            }
            totalBytesRead$iv += readCount$iv;
            emitCompleteSegments();
        }
    }

    @Override
    public BufferedSink write(Source source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long byteCount$iv = byteCount;
        while (byteCount$iv > 0) {
            long read$iv = source.read(this.bufferField, byteCount$iv);
            if (read$iv == -1) {
                throw new EOFException();
            }
            byteCount$iv -= read$iv;
            emitCompleteSegments();
        }
        return this;
    }

    @Override
    public BufferedSink writeByte(int b) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeByte(b);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeShort(int s) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShort(s);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeShortLe(int s) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShortLe(s);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeInt(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeInt(i);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeIntLe(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeIntLe(i);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeLong(long v) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeLong(v);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeLongLe(long v) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeLongLe(v);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeDecimalLong(long v) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeDecimalLong(v);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeHexadecimalUnsignedLong(long v) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeHexadecimalUnsignedLong(v);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long byteCount$iv = this.bufferField.completeSegmentByteCount();
        if (byteCount$iv > 0) {
            this.sink.write(this.bufferField, byteCount$iv);
        }
        return this;
    }

    @Override
    public BufferedSink emit() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long byteCount$iv = this.bufferField.size();
        if (byteCount$iv > 0) {
            this.sink.write(this.bufferField, byteCount$iv);
        }
        return this;
    }

    @Override
    public OutputStream outputStream() {
        return new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                if (RealBufferedSink.this.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSink this_$iv = RealBufferedSink.this;
                int $i$f$getBuffer = (byte) b;
                this_$iv.bufferField.writeByte($i$f$getBuffer);
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override
            public void write(byte[] data, int offset, int byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(data, "data");
                if (RealBufferedSink.this.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSink this_$iv = RealBufferedSink.this;
                this_$iv.bufferField.write(data, offset, byteCount);
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override
            public void flush() throws IOException {
                if (!RealBufferedSink.this.closed) {
                    RealBufferedSink.this.flush();
                }
            }

            @Override
            public void close() throws Throwable {
                RealBufferedSink.this.close();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }
        };
    }

    @Override
    public void flush() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() > 0) {
            this.sink.write(this.bufferField, this.bufferField.size());
        }
        this.sink.flush();
    }

    @Override
    public boolean isOpen() {
        return !this.closed;
    }

    @Override
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        Throwable thrown$iv = null;
        try {
            if (this.bufferField.size() > 0) {
                this.sink.write(this.bufferField, this.bufferField.size());
            }
        } catch (Throwable e$iv) {
            thrown$iv = e$iv;
        }
        try {
            this.sink.close();
        } catch (Throwable e$iv2) {
            if (thrown$iv == null) {
                thrown$iv = e$iv2;
            }
        }
        this.closed = true;
        if (thrown$iv == null) {
        } else {
            throw thrown$iv;
        }
    }

    @Override
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }
}
