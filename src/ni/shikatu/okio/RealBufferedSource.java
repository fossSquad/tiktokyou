package ni.shikatu.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.text.CharsKt;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J'\u0010\u001b\u001a\u0004\u0018\u0001H\u001f\"\b\b\u0000\u0010\u001f*\u00020 2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020$H\u0016J \u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u001cH\u0016J\u0010\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020'H\u0016J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010,\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.H\u0016J\n\u0010/\u001a\u0004\u0018\u00010+H\u0016J\b\u00100\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0010H\u0016J\b\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00106\u001a\u00020\u001cH\u0016J\b\u00107\u001a\u00020\u001cH\u0016J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u0018H\u0016J\u0018\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0010H\u0016J \u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001aH\u0016J\u0018\u0010=\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0010H\u0016J \u0010=\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u001aH\u0016J\u0018\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0010H\u0016J\u0018\u0010D\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001aH\u0016J(\u0010D\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u001cH\u0016J\b\u0010F\u001a\u00020\u0001H\u0016J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\tH\u0016J\b\u0010J\u001a\u00020\u0015H\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020+H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u00078Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006N"}, d2 = {"Lni/shikatu/okio/RealBufferedSource;", "Lni/shikatu/okio/BufferedSource;", "source", "Lni/shikatu/okio/Source;", "<init>", "(Lokio/Source;)V", "bufferField", "Lni/shikatu/okio/Buffer;", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "buffer", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "byteCount", "exhausted", "require", _UrlKt.FRAGMENT_ENCODE_SET, "request", "readByte", _UrlKt.FRAGMENT_ENCODE_SET, "readByteString", "Lni/shikatu/okio/ByteString;", "select", _UrlKt.FRAGMENT_ENCODE_SET, "options", "Lni/shikatu/okio/Options;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readByteArray", _UrlKt.FRAGMENT_ENCODE_SET, "readFully", "offset", "Ljava/nio/ByteBuffer;", "readAll", "Lni/shikatu/okio/Sink;", "readUtf8", _UrlKt.FRAGMENT_ENCODE_SET, "readString", "charset", "Ljava/nio/charset/Charset;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readShort", _UrlKt.FRAGMENT_ENCODE_SET, "readShortLe", "readInt", "readIntLe", "readLong", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "peek", "inputStream", "Ljava/io/InputStream;", "isOpen", "close", "timeout", "Lni/shikatu/okio/Timeout;", "toString", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public static  void getBuffer$annotations() {
    }

    public RealBufferedSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
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
    public long read(Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() == 0) {
            if (byteCount == 0) {
                return 0L;
            }
            long read$iv = this.source.read(this.bufferField, 8192L);
            if (read$iv == -1) {
                return -1L;
            }
        }
        long toRead$iv = Math.min(byteCount, this.bufferField.size());
        return this.bufferField.read(sink, toRead$iv);
    }

    @Override
    public boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        return this.bufferField.exhausted() && this.source.read(this.bufferField, 8192L) == -1;
    }

    @Override
    public void require(long byteCount) throws IOException {
        if (request(byteCount)) {
        } else {
            throw new EOFException();
        }
    }

    @Override
    public boolean request(long byteCount) throws IOException {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.bufferField.size() < byteCount) {
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public byte readByte() throws IOException {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override
    public ByteString readByteString() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override
    public ByteString readByteString(long byteCount) throws IOException {
        require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    @Override
    public int select(Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int index$iv = ni.shikatu.okio.internal.Buffer.selectPrefix(this.bufferField, options, true);
            switch (index$iv) {
                case -2:
                    break;
                case -1:
                    return -1;
                default:
                    int selectedSize$iv = options.getByteStrings$okio()[index$iv].size();
                    this.bufferField.skip(selectedSize$iv);
                    return index$iv;
            }
        } while (this.source.read(this.bufferField, 8192L) != -1);
        return -1;
    }

    @Override
    public <T> T select(TypedOptions<T> typedOptions) throws IOException {
        Intrinsics.checkNotNullParameter(typedOptions, "options");
        RealBufferedSource $this$commonSelect$iv = this;
        int index$iv = $this$commonSelect$iv.select(typedOptions.getOptions$okio());
        if (index$iv == -1) {
            return null;
        }
        return typedOptions.get(index$iv);
    }

    @Override
    public byte[] readByteArray() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override
    public byte[] readByteArray(long byteCount) throws IOException {
        require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    @Override
    public int read(byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override
    public void readFully(byte[] sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e$iv) {
            int offset$iv = 0;
            while (this.bufferField.size() > 0) {
                int read$iv = this.bufferField.read(sink, offset$iv, (int) this.bufferField.size());
                if (read$iv == -1) {
                    throw new AssertionError();
                }
                offset$iv += read$iv;
            }
            throw e$iv;
        }
    }

    @Override
    public int read(byte[] sink, int offset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, offset, byteCount);
        if (this.bufferField.size() == 0) {
            if (byteCount == 0) {
                return 0;
            }
            long read$iv = this.source.read(this.bufferField, 8192L);
            if (read$iv == -1) {
                return -1;
            }
        }
        long b$iv$iv = this.bufferField.size();
        int toRead$iv = (int) Math.min(byteCount, b$iv$iv);
        return this.bufferField.read(sink, offset, toRead$iv);
    }

    @Override
    public int read(ByteBuffer sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.bufferField.size() == 0) {
            long read = this.source.read(this.bufferField, 8192L);
            if (read == -1) {
                return -1;
            }
        }
        return this.bufferField.read(sink);
    }

    @Override
    public void readFully(Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(byteCount);
            this.bufferField.readFully(sink, byteCount);
        } catch (EOFException e$iv) {
            sink.writeAll(this.bufferField);
            throw e$iv;
        }
    }

    @Override
    public long readAll(Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long totalBytesWritten$iv = 0;
        while (this.source.read(this.bufferField, 8192L) != -1) {
            long emitByteCount$iv = this.bufferField.completeSegmentByteCount();
            if (emitByteCount$iv > 0) {
                totalBytesWritten$iv += emitByteCount$iv;
                sink.write(this.bufferField, emitByteCount$iv);
            }
        }
        if (this.bufferField.size() <= 0) {
            return totalBytesWritten$iv;
        }
        long totalBytesWritten$iv2 = totalBytesWritten$iv + this.bufferField.size();
        sink.write(this.bufferField, this.bufferField.size());
        return totalBytesWritten$iv2;
    }

    @Override
    public String readUtf8() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override
    public String readUtf8(long byteCount) throws IOException {
        require(byteCount);
        return this.bufferField.readUtf8(byteCount);
    }

    @Override
    public String readString(Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override
    public String readString(long byteCount, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        require(byteCount);
        return this.bufferField.readString(byteCount, charset);
    }

    @Override
    public String readUtf8Line() throws IOException {
        long newline$iv = indexOf((byte) 10);
        if (newline$iv != -1) {
            return ni.shikatu.okio.internal.Buffer.readUtf8Line(this.bufferField, newline$iv);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @Override
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override
    public String readUtf8LineStrict(long limit) throws IOException {
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long scanLength$iv = limit == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
        long newline$iv = indexOf((byte) 10, 0L, scanLength$iv);
        if (newline$iv != -1) {
            return ni.shikatu.okio.internal.Buffer.readUtf8Line(this.bufferField, newline$iv);
        }
        if (scanLength$iv < LongCompanionObject.MAX_VALUE && request(scanLength$iv) && this.bufferField.getByte(scanLength$iv - 1) == 13 && request(scanLength$iv + 1) && this.bufferField.getByte(scanLength$iv) == 10) {
            return ni.shikatu.okio.internal.Buffer.readUtf8Line(this.bufferField, scanLength$iv);
        }
        Buffer data$iv = new Buffer();
        Buffer buffer = this.bufferField;
        long b$iv$iv = this.bufferField.size();
        buffer.copyTo(data$iv, 0L, Math.min(32, b$iv$iv));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), limit) + " content=" + data$iv.readByteString().hex() + Typography.ellipsis);
    }

    @Override
    public int readUtf8CodePoint() throws IOException {
        require(1L);
        int b0$iv = this.bufferField.getByte(0L);
        if ((b0$iv & 224) == 192) {
            require(2L);
        } else if ((b0$iv & 240) == 224) {
            require(3L);
        } else if ((b0$iv & 248) == 240) {
            require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override
    public short readShort() throws IOException {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override
    public short readShortLe() throws IOException {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override
    public int readInt() throws IOException {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override
    public int readIntLe() throws IOException {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override
    public long readLong() throws IOException {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override
    public long readLongLe() throws IOException {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override
    public long readDecimalLong() throws IOException {
        require(1L);
        for (long pos$iv = 0; request(pos$iv + 1); pos$iv++) {
            byte b$iv = this.bufferField.getByte(pos$iv);
            if ((b$iv < 48 || b$iv > 57) && !(pos$iv == 0 && b$iv == 45)) {
                if (pos$iv != 0) {
                    break;
                }
                StringBuilder sbAppend = new StringBuilder().append("Expected a digit or '-' but was 0x");
                String string = Integer.toString(b$iv, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new NumberFormatException(sbAppend.append(string).toString());
            }
        }
        return this.bufferField.readDecimalLong();
    }

    @Override
    public long readHexadecimalUnsignedLong() throws IOException {
        require(1L);
        for (int pos$iv = 0; request(pos$iv + 1); pos$iv++) {
            byte b$iv = this.bufferField.getByte(pos$iv);
            if ((b$iv < 48 || b$iv > 57) && ((b$iv < 97 || b$iv > 102) && (b$iv < 65 || b$iv > 70))) {
                if (pos$iv != 0) {
                    break;
                }
                StringBuilder sbAppend = new StringBuilder().append("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(b$iv, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new NumberFormatException(sbAppend.append(string).toString());
            }
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override
    public void skip(long byteCount) throws IOException {
        long byteCount$iv = byteCount;
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (byteCount$iv > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long toSkip$iv = Math.min(byteCount$iv, this.bufferField.size());
            this.bufferField.skip(toSkip$iv);
            byteCount$iv -= toSkip$iv;
        }
    }

    @Override
    public long indexOf(byte b) throws IOException {
        return indexOf(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    @Override
    public long indexOf(byte b, long fromIndex) {
        return indexOf(b, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    @Override
    public long indexOf(byte b, long fromIndex, long toIndex) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        boolean z = false;
        if (0 <= fromIndex && fromIndex <= toIndex) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        long fromIndex$iv = fromIndex;
        while (fromIndex$iv < toIndex) {
            long result$iv = this.bufferField.indexOf(b, fromIndex$iv, toIndex);
            if (result$iv != -1) {
                return result$iv;
            }
            long lastBufferSize$iv = this.bufferField.size();
            if (lastBufferSize$iv < toIndex && this.source.read(this.bufferField, 8192L) != -1) {
                fromIndex$iv = Math.max(fromIndex$iv, lastBufferSize$iv);
            }
            return -1L;
        }
        return -1L;
    }

    @Override
    public long indexOf(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override
    public long indexOf(ByteString bytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    @Override
    public long indexOf(ByteString bytes, long fromIndex, long toIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return ni.shikatu.okio.internal.RealBufferedSource.commonIndexOf(this, bytes, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? bytes.size() : 0, fromIndex, (6 & 16) != 0 ? Long.MAX_VALUE : toIndex);
    }

    @Override
    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override
    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long fromIndex$iv = fromIndex;
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long result$iv = this.bufferField.indexOfElement(targetBytes, fromIndex$iv);
            if (result$iv != -1) {
                return result$iv;
            }
            long lastBufferSize$iv = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex$iv = Math.max(fromIndex$iv, lastBufferSize$iv);
        }
    }

    @Override
    public boolean rangeEquals(long offset, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override
    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (byteCount >= 0 && offset >= 0 && bytesOffset >= 0 && bytesOffset + byteCount <= bytes.size()) {
            if (byteCount != 0 && ni.shikatu.okio.internal.RealBufferedSource.commonIndexOf(this, bytes, bytesOffset, byteCount, offset, 1 + offset) == -1) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override
    public InputStream inputStream() {
        return new InputStream() {
            @Override
            public int read() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSource this_$iv = RealBufferedSource.this;
                if (this_$iv.bufferField.size() == 0) {
                    Source source = RealBufferedSource.this.source;
                    RealBufferedSource this_$iv2 = RealBufferedSource.this;
                    long count = source.read(this_$iv2.bufferField, 8192L);
                    if (count == -1) {
                        return -1;
                    }
                }
                RealBufferedSource this_$iv3 = RealBufferedSource.this;
                byte $this$and$iv = this_$iv3.bufferField.readByte();
                return $this$and$iv & UByte.MAX_VALUE;
            }

            @Override
            public int read(byte[] data, int offset, int byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(data, "data");
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                SegmentedByteString.checkOffsetAndCount(data.length, offset, byteCount);
                RealBufferedSource this_$iv = RealBufferedSource.this;
                if (this_$iv.bufferField.size() == 0) {
                    Source source = RealBufferedSource.this.source;
                    RealBufferedSource this_$iv2 = RealBufferedSource.this;
                    long count = source.read(this_$iv2.bufferField, 8192L);
                    if (count == -1) {
                        return -1;
                    }
                }
                RealBufferedSource this_$iv3 = RealBufferedSource.this;
                return this_$iv3.bufferField.read(data, offset, byteCount);
            }

            @Override
            public int available() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSource this_$iv = RealBufferedSource.this;
                long a$iv = this_$iv.bufferField.size();
                return (int) Math.min(a$iv, IntCompanionObject.MAX_VALUE);
            }

            @Override
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override
            public long transferTo(OutputStream out) throws IOException {
                Intrinsics.checkNotNullParameter(out, "out");
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                long count = 0;
                while (true) {
                    RealBufferedSource this_$iv = RealBufferedSource.this;
                    if (this_$iv.bufferField.size() == 0) {
                        Source source = RealBufferedSource.this.source;
                        RealBufferedSource this_$iv2 = RealBufferedSource.this;
                        long read = source.read(this_$iv2.bufferField, 8192L);
                        if (read == -1) {
                            return count;
                        }
                    }
                    RealBufferedSource this_$iv3 = RealBufferedSource.this;
                    count += this_$iv3.bufferField.size();
                    RealBufferedSource this_$iv4 = RealBufferedSource.this;
                    Buffer.writeTo$default(this_$iv4.bufferField, out, 0L, 2, null);
                }
            }
        };
    }

    @Override
    public boolean isOpen() {
        return !this.closed;
    }

    @Override
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }
}
