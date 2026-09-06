package ni.shikatu.okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0094\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0001H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J \u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\nJ\u001a\u0010\"\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001eJ\u0016\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\nJ \u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0006\u0010&\u001a\u00020\nJ\b\u0010'\u001a\u00020(H\u0016J\u0016\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b+J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020-H\u0016J\b\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\nH\u0016J\b\u00106\u001a\u000207H\u0016J\u0010\u00106\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0016J'\u00108\u001a\u0004\u0018\u0001H;\"\b\b\u0000\u0010;*\u00020<2\f\u00109\u001a\b\u0012\u0004\u0012\u0002H;0=H\u0016¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010A\u001a\u00020\n2\u0006\u0010@\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010C\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010E\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010F\u001a\u00020GH\u0016J\n\u0010H\u001a\u0004\u0018\u00010DH\u0016J\b\u0010I\u001a\u00020DH\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020/H\u0016J\b\u0010L\u001a\u00020MH\u0016J\u0010\u0010L\u001a\u00020M2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020MH\u0016J\u0010\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020MH\u0016J \u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020M2\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020OH\u0016J\u0006\u0010P\u001a\u00020\u0019J\u0010\u0010Q\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u000207H\u0016J \u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u0002072\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020DH\u0016J \u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020/H\u0016J\u0010\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020/H\u0016J\u0018\u0010Z\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010F\u001a\u00020GH\u0016J(\u0010Z\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020/2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020MH\u0016J \u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020M2\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010R\u001a\u00020/2\u0006\u0010[\u001a\u00020OH\u0016J\u0010\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020]H\u0016J\u0018\u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020]2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020/H\u0016J\u0010\u0010`\u001a\u00020\u00002\u0006\u0010a\u001a\u00020/H\u0016J\u0010\u0010b\u001a\u00020\u00002\u0006\u0010a\u001a\u00020/H\u0016J\u0010\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020/H\u0016J\u0010\u0010e\u001a\u00020\u00002\u0006\u0010d\u001a\u00020/H\u0016J\u0010\u0010f\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010h\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010i\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010j\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0015\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020/H\u0000¢\u0006\u0002\bmJ\u0018\u0010R\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0018\u0010N\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(H\u0016J\u0018\u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(2\u0006\u0010o\u001a\u00020\nH\u0016J \u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u0010q\u001a\u000207H\u0016J\u0018\u0010n\u001a\u00020\n2\u0006\u0010q\u001a\u0002072\u0006\u0010o\u001a\u00020\nH\u0016J \u0010n\u001a\u00020\n2\u0006\u0010q\u001a\u0002072\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0016J\u0010\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u000207H\u0016J\u0018\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u0002072\u0006\u0010o\u001a\u00020\nH\u0016J\u0018\u0010t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010q\u001a\u000207H\u0016J(\u0010t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010q\u001a\u0002072\u0006\u0010u\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\b\u0010v\u001a\u00020\u0019H\u0016J\b\u0010w\u001a\u00020\u0017H\u0016J\b\u0010x\u001a\u00020\u0019H\u0016J\b\u0010y\u001a\u00020zH\u0016J\u0006\u0010{\u001a\u000207J\u0006\u0010|\u001a\u000207J\u0006\u0010}\u001a\u000207J\u0006\u0010~\u001a\u000207J\u0011\u0010\u007f\u001a\u0002072\u0007\u0010\u0080\u0001\u001a\u00020DH\u0002J\u0010\u0010\u0081\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u0010\u0010\u0083\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u0010\u0010\u0084\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u001b\u0010\u0085\u0001\u001a\u0002072\u0007\u0010\u0080\u0001\u001a\u00020D2\u0007\u0010\u0082\u0001\u001a\u000207H\u0002J\u0015\u0010\u0086\u0001\u001a\u00020\u00172\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010<H\u0096\u0002J\t\u0010\u0088\u0001\u001a\u00020/H\u0016J\t\u0010\u0089\u0001\u001a\u00020DH\u0016J\u0007\u0010\u008a\u0001\u001a\u00020\u0000J\t\u0010\u008b\u0001\u001a\u00020\u0000H\u0016J\u0007\u0010\u008c\u0001\u001a\u000207J\u000f\u0010\u008c\u0001\u001a\u0002072\u0006\u0010\u001a\u001a\u00020/J\u0016\u0010\u008d\u0001\u001a\u00030\u008e\u00012\n\b\u0002\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0007J\u0016\u0010\u0090\u0001\u001a\u00030\u008e\u00012\n\b\u0002\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0007J\u0017\u0010+\u001a\u00020(2\u0007\u0010\u0091\u0001\u001a\u00020\nH\u0007¢\u0006\u0003\b\u0092\u0001J\u000e\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0003\b\u0093\u0001R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0095\u0001"}, d2 = {"Lni/shikatu/okio/Buffer;", "Lni/shikatu/okio/BufferedSource;", "Lni/shikatu/okio/BufferedSink;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/nio/channels/ByteChannel;", "<init>", "()V", "head", "Lni/shikatu/okio/Segment;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "size", "()J", "setSize$okio", "(J)V", "buffer", "getBuffer", "()Lokio/Buffer;", "outputStream", "Ljava/io/OutputStream;", "emitCompleteSegments", "emit", "exhausted", _UrlKt.FRAGMENT_ENCODE_SET, "require", _UrlKt.FRAGMENT_ENCODE_SET, "byteCount", "request", "peek", "inputStream", "Ljava/io/InputStream;", "copyTo", "out", "offset", "writeTo", "readFrom", "input", "forever", "completeSegmentByteCount", "readByte", _UrlKt.FRAGMENT_ENCODE_SET, "get", "pos", "getByte", "readShort", _UrlKt.FRAGMENT_ENCODE_SET, "readInt", _UrlKt.FRAGMENT_ENCODE_SET, "readLong", "readShortLe", "readIntLe", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "readByteString", "Lni/shikatu/okio/ByteString;", "select", "options", "Lni/shikatu/okio/Options;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readFully", "sink", "readAll", "Lni/shikatu/okio/Sink;", "readUtf8", _UrlKt.FRAGMENT_ENCODE_SET, "readString", "charset", "Ljava/nio/charset/Charset;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readByteArray", _UrlKt.FRAGMENT_ENCODE_SET, "read", "Ljava/nio/ByteBuffer;", "clear", "skip", "write", "byteString", "writeUtf8", "string", "beginIndex", "endIndex", "writeUtf8CodePoint", "codePoint", "writeString", "source", "writeAll", "Lni/shikatu/okio/Source;", "writeByte", "b", "writeShort", "s", "writeShortLe", "writeInt", "i", "writeIntLe", "writeLong", "v", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "writableSegment", "minimumCapacity", "writableSegment$okio", "indexOf", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "flush", "isOpen", "close", "timeout", "Lni/shikatu/okio/Timeout;", "md5", "sha1", "sha256", "sha512", "digest", "algorithm", "hmacSha1", "key", "hmacSha256", "hmacSha512", "hmac", "equals", "other", "hashCode", "toString", "copy", "clone", "snapshot", "readUnsafe", "Lni/shikatu/okio/Buffer$UnsafeCursor;", "unsafeCursor", "readAndWriteUnsafe", "index", "-deprecated_getByte", "-deprecated_size", "UnsafeCursor", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    public final Buffer copyTo(OutputStream outputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return copyTo$default(this, outputStream, j, 0L, 4, (Object) null);
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    public final long size() {
        return this.size;
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    @Override
    public Buffer buffer() {
        return this;
    }

    @Override
    public Buffer getBuffer() {
        return this;
    }

    @Override
    public OutputStream outputStream() {
        return new OutputStream() {
            @Override
            public void write(int b) {
                Buffer.this.writeByte(b);
            }

            @Override
            public void write(byte[] data, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(data, "data");
                Buffer.this.write(data, offset, byteCount);
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }
        };
    }

    @Override
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override
    public Buffer emit() {
        return this;
    }

    @Override
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override
    public void require(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override
    public boolean request(long byteCount) {
        return this.size >= byteCount;
    }

    @Override
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override
    public InputStream inputStream() {
        return new InputStream() {
            @Override
            public int read() throws EOFException {
                if (Buffer.this.size() > 0) {
                    byte $this$and$iv = Buffer.this.readByte();
                    return $this$and$iv & UByte.MAX_VALUE;
                }
                return -1;
            }

            @Override
            public int read(byte[] sink, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                return Buffer.this.read(sink, offset, byteCount);
            }

            @Override
            public int available() {
                long a$iv = Buffer.this.size();
                return (int) Math.min(a$iv, IntCompanionObject.MAX_VALUE);
            }

            @Override
            public void close() {
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    public static  Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        long j3;
        long j4;
        if ((i & 2) == 0) {
            j3 = j;
        } else {
            j3 = 0;
        }
        if ((i & 4) == 0) {
            j4 = j2;
        } else {
            j4 = buffer.size - j3;
        }
        return buffer.copyTo(outputStream, j3, j4);
    }

    public final Buffer copyTo(OutputStream out, long offset, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        long offset2 = offset;
        long byteCount2 = byteCount;
        SegmentedByteString.checkOffsetAndCount(this.size, offset2, byteCount2);
        if (byteCount2 == 0) {
            return this;
        }
        Segment s = this.head;
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
            int pos = (int) (((long) s.pos) + offset2);
            long b$iv = byteCount2;
            int a$iv = (int) Math.min(s.limit - pos, b$iv);
            out.write(s.data, pos, a$iv);
            byteCount2 -= (long) a$iv;
            offset2 = 0;
            s = s.next;
        }
        return this;
    }

    public static  Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        long j3;
        if ((i & 2) != 0) {
            j3 = 0;
        } else {
            j3 = j;
        }
        return buffer.copyTo(buffer2, j3, j2);
    }

    public final Buffer copyTo(Buffer out, long offset, long byteCount) {
        long j;
        Intrinsics.checkNotNullParameter(out, "out");
        Buffer $this$commonCopyTo$iv = this;
        long offset$iv = offset;
        long byteCount$iv = byteCount;
        SegmentedByteString.checkOffsetAndCount($this$commonCopyTo$iv.size(), offset$iv, byteCount$iv);
        long j2 = 0;
        if (byteCount$iv == 0) {
            return $this$commonCopyTo$iv;
        }
        out.setSize$okio(out.size() + byteCount$iv);
        Segment s$iv = $this$commonCopyTo$iv.head;
        while (true) {
            Intrinsics.checkNotNull(s$iv);
            j = j2;
            if (offset$iv < s$iv.limit - s$iv.pos) {
                break;
            }
            offset$iv -= (long) (s$iv.limit - s$iv.pos);
            s$iv = s$iv.next;
            j2 = j;
        }
        while (byteCount$iv > j) {
            Intrinsics.checkNotNull(s$iv);
            Segment copy$iv = s$iv.sharedCopy();
            copy$iv.pos += (int) offset$iv;
            copy$iv.limit = Math.min(copy$iv.pos + ((int) byteCount$iv), copy$iv.limit);
            if (out.head == null) {
                copy$iv.prev = copy$iv;
                copy$iv.next = copy$iv.prev;
                out.head = copy$iv.next;
            } else {
                Segment segment = out.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment.prev;
                Intrinsics.checkNotNull(segment2);
                segment2.push(copy$iv);
            }
            byteCount$iv -= (long) (copy$iv.limit - copy$iv.pos);
            offset$iv = 0;
            s$iv = s$iv.next;
            $this$commonCopyTo$iv = $this$commonCopyTo$iv;
        }
        return $this$commonCopyTo$iv;
    }

    public static  Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    public final Buffer copyTo(Buffer out, long offset) {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo(out, offset, this.size - offset);
    }

    public static  Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    public final Buffer writeTo(OutputStream out, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        long byteCount2 = byteCount;
        SegmentedByteString.checkOffsetAndCount(this.size, 0L, byteCount2);
        Segment s = this.head;
        while (byteCount2 > 0) {
            Intrinsics.checkNotNull(s);
            long a$iv = byteCount2;
            int b$iv = (int) Math.min(a$iv, s.limit - s.pos);
            out.write(s.data, s.pos, b$iv);
            s.pos += b$iv;
            this.size -= (long) b$iv;
            byteCount2 -= (long) b$iv;
            if (s.pos == s.limit) {
                Segment toRecycle = s;
                s = toRecycle.pop();
                this.head = s;
                SegmentPool.recycle(toRecycle);
            }
        }
        return this;
    }

    public final Buffer readFrom(InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        readFrom(input, LongCompanionObject.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream input, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        readFrom(input, byteCount, false);
        return this;
    }

    private final void readFrom(InputStream input, long byteCount, boolean forever) throws IOException {
        long byteCount2 = byteCount;
        while (true) {
            if (byteCount2 > 0 || forever) {
                Segment tail = writableSegment$okio(1);
                int b$iv = 8192 - tail.limit;
                long a$iv = byteCount2;
                int bytesRead = input.read(tail.data, tail.limit, (int) Math.min(a$iv, b$iv));
                if (bytesRead == -1) {
                    if (tail.pos == tail.limit) {
                        this.head = tail.pop();
                        SegmentPool.recycle(tail);
                    }
                    if (!forever) {
                        throw new EOFException();
                    }
                    return;
                }
                tail.limit += bytesRead;
                this.size += (long) bytesRead;
                byteCount2 -= (long) bytesRead;
            } else {
                return;
            }
        }
    }

    public final long completeSegmentByteCount() {
        long result$iv = size();
        if (result$iv == 0) {
            return 0L;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment tail$iv = segment.prev;
        Intrinsics.checkNotNull(tail$iv);
        if (tail$iv.limit < 8192 && tail$iv.owner) {
            result$iv -= (long) (tail$iv.limit - tail$iv.pos);
        }
        return result$iv;
    }

    @Override
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment$iv = this.head;
        Intrinsics.checkNotNull(segment$iv);
        int pos$iv = segment$iv.pos;
        int limit$iv = segment$iv.limit;
        byte[] data$iv = segment$iv.data;
        int pos$iv2 = pos$iv + 1;
        byte b$iv = data$iv[pos$iv];
        setSize$okio(size() - 1);
        if (pos$iv2 == limit$iv) {
            this.head = segment$iv.pop();
            SegmentPool.recycle(segment$iv);
        } else {
            segment$iv.pos = pos$iv2;
        }
        return b$iv;
    }

    public final byte getByte(long pos) {
        SegmentedByteString.checkOffsetAndCount(size(), pos, 1L);
        Segment s$iv$iv = this.head;
        if (s$iv$iv == null) {
            Segment s$iv = null;
            Intrinsics.checkNotNull(null);
            return s$iv.data[(int) ((((long) s$iv.pos) + pos) - (-1))];
        }
        if (size() - pos < pos) {
            long offset$iv$iv = size();
            while (offset$iv$iv > pos) {
                Segment segment = s$iv$iv.prev;
                Intrinsics.checkNotNull(segment);
                s$iv$iv = segment;
                offset$iv$iv -= (long) (s$iv$iv.limit - s$iv$iv.pos);
            }
            Segment s$iv2 = s$iv$iv;
            long offset$iv = offset$iv$iv;
            Intrinsics.checkNotNull(s$iv2);
            return s$iv2.data[(int) ((((long) s$iv2.pos) + pos) - offset$iv)];
        }
        long offset$iv$iv2 = 0;
        while (true) {
            long nextOffset$iv$iv = ((long) (s$iv$iv.limit - s$iv$iv.pos)) + offset$iv$iv2;
            if (nextOffset$iv$iv <= pos) {
                Segment segment2 = s$iv$iv.next;
                Intrinsics.checkNotNull(segment2);
                s$iv$iv = segment2;
                offset$iv$iv2 = nextOffset$iv$iv;
            } else {
                Segment s$iv3 = s$iv$iv;
                long offset$iv2 = offset$iv$iv2;
                Intrinsics.checkNotNull(s$iv3);
                return s$iv3.data[(int) ((((long) s$iv3.pos) + pos) - offset$iv2)];
            }
        }
    }

    @Override
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment$iv = this.head;
        Intrinsics.checkNotNull(segment$iv);
        int pos$iv = segment$iv.pos;
        int limit$iv = segment$iv.limit;
        if (limit$iv - pos$iv < 2) {
            byte $this$and$iv$iv = readByte();
            int i = ($this$and$iv$iv & UByte.MAX_VALUE) << 8;
            byte $this$and$iv$iv2 = readByte();
            int s$iv = i | ($this$and$iv$iv2 & UByte.MAX_VALUE);
            return (short) s$iv;
        }
        byte[] data$iv = segment$iv.data;
        int pos$iv2 = pos$iv + 1;
        byte $this$and$iv$iv3 = data$iv[pos$iv];
        int i2 = ($this$and$iv$iv3 & UByte.MAX_VALUE) << 8;
        int pos$iv3 = pos$iv2 + 1;
        byte $this$and$iv$iv4 = data$iv[pos$iv2];
        int s$iv2 = i2 | ($this$and$iv$iv4 & UByte.MAX_VALUE);
        setSize$okio(size() - 2);
        if (pos$iv3 == limit$iv) {
            this.head = segment$iv.pop();
            SegmentPool.recycle(segment$iv);
        } else {
            segment$iv.pos = pos$iv3;
        }
        return (short) s$iv2;
    }

    @Override
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment$iv = this.head;
        Intrinsics.checkNotNull(segment$iv);
        int pos$iv = segment$iv.pos;
        int limit$iv = segment$iv.limit;
        if (limit$iv - pos$iv < 4) {
            byte $this$and$iv$iv = readByte();
            int i = ($this$and$iv$iv & UByte.MAX_VALUE) << 24;
            byte $this$and$iv$iv2 = readByte();
            int i2 = i | (($this$and$iv$iv2 & UByte.MAX_VALUE) << 16);
            byte $this$and$iv$iv3 = readByte();
            int i3 = i2 | (($this$and$iv$iv3 & UByte.MAX_VALUE) << 8);
            byte $this$and$iv$iv4 = readByte();
            return i3 | ($this$and$iv$iv4 & UByte.MAX_VALUE);
        }
        byte[] data$iv = segment$iv.data;
        int pos$iv2 = pos$iv + 1;
        byte $this$and$iv$iv5 = data$iv[pos$iv];
        int i4 = ($this$and$iv$iv5 & UByte.MAX_VALUE) << 24;
        int pos$iv3 = pos$iv2 + 1;
        byte $this$and$iv$iv6 = data$iv[pos$iv2];
        int i5 = i4 | (($this$and$iv$iv6 & UByte.MAX_VALUE) << 16);
        int pos$iv4 = pos$iv3 + 1;
        byte $this$and$iv$iv7 = data$iv[pos$iv3];
        int i6 = i5 | (($this$and$iv$iv7 & UByte.MAX_VALUE) << 8);
        int pos$iv5 = pos$iv4 + 1;
        byte $this$and$iv$iv8 = data$iv[pos$iv4];
        int i$iv = i6 | ($this$and$iv$iv8 & UByte.MAX_VALUE);
        setSize$okio(size() - 4);
        if (pos$iv5 == limit$iv) {
            this.head = segment$iv.pop();
            SegmentPool.recycle(segment$iv);
        } else {
            segment$iv.pos = pos$iv5;
        }
        return i$iv;
    }

    @Override
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment$iv = this.head;
        Intrinsics.checkNotNull(segment$iv);
        int pos$iv = segment$iv.pos;
        int limit$iv = segment$iv.limit;
        if (limit$iv - pos$iv < 8) {
            int $this$and$iv$iv = readInt();
            int $this$and$iv$iv2 = readInt();
            return ((((long) $this$and$iv$iv) & 4294967295L) << 32) | (((long) $this$and$iv$iv2) & 4294967295L);
        }
        byte[] data$iv = segment$iv.data;
        int pos$iv2 = pos$iv + 1;
        byte $this$and$iv$iv3 = data$iv[pos$iv];
        long other$iv$iv = 255 & ((long) $this$and$iv$iv3);
        int pos$iv3 = pos$iv2 + 1;
        byte $this$and$iv$iv4 = data$iv[pos$iv2];
        long j = ((((long) $this$and$iv$iv4) & 255) << 48) | (other$iv$iv << 56);
        int pos$iv4 = pos$iv3 + 1;
        byte $this$and$iv$iv5 = data$iv[pos$iv3];
        long other$iv$iv2 = 255 & ((long) $this$and$iv$iv5);
        int pos$iv5 = pos$iv4 + 1;
        byte $this$and$iv$iv6 = data$iv[pos$iv4];
        long j2 = j | (other$iv$iv2 << 40) | ((((long) $this$and$iv$iv6) & 255) << 32);
        int pos$iv6 = pos$iv5 + 1;
        byte $this$and$iv$iv7 = data$iv[pos$iv5];
        long other$iv$iv3 = 255 & ((long) $this$and$iv$iv7);
        int pos$iv7 = pos$iv6 + 1;
        byte $this$and$iv$iv8 = data$iv[pos$iv6];
        long j3 = j2 | (other$iv$iv3 << 24) | ((((long) $this$and$iv$iv8) & 255) << 16);
        int pos$iv8 = pos$iv7 + 1;
        byte $this$and$iv$iv9 = data$iv[pos$iv7];
        long other$iv$iv4 = 255 & ((long) $this$and$iv$iv9);
        int pos$iv9 = pos$iv8 + 1;
        byte $this$and$iv$iv10 = data$iv[pos$iv8];
        long v$iv = j3 | (other$iv$iv4 << 8) | (((long) $this$and$iv$iv10) & 255);
        setSize$okio(size() - 8);
        if (pos$iv9 == limit$iv) {
            this.head = segment$iv.pop();
            SegmentPool.recycle(segment$iv);
        } else {
            segment$iv.pos = pos$iv9;
        }
        return v$iv;
    }

    @Override
    public short readShortLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readShort());
    }

    @Override
    public int readIntLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readInt());
    }

    @Override
    public long readLongLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readLong());
    }

    @Override
    public long readDecimalLong() throws EOFException {
        int $i$f$commonReadDecimalLong;
        long j;
        byte b$iv;
        boolean negative$iv;
        int $i$f$commonReadDecimalLong2 = 0;
        long j2 = 0;
        if (size() == 0) {
            throw new EOFException();
        }
        long value$iv = 0;
        int seen$iv = 0;
        boolean negative$iv2 = false;
        boolean done$iv = false;
        long overflowDigit$iv = -7;
        loop0: while (true) {
            Segment segment$iv = this.head;
            Intrinsics.checkNotNull(segment$iv);
            byte[] data$iv = segment$iv.data;
            int pos$iv = segment$iv.pos;
            int limit$iv = segment$iv.limit;
            while (true) {
                if (pos$iv >= limit$iv) {
                    $i$f$commonReadDecimalLong = $i$f$commonReadDecimalLong2;
                    j = j2;
                    break;
                }
                b$iv = data$iv[pos$iv];
                j = j2;
                if (b$iv < 48 || b$iv > 57) {
                    $i$f$commonReadDecimalLong = $i$f$commonReadDecimalLong2;
                    done$iv = done$iv;
                    if (b$iv == 45 && seen$iv == 0) {
                        negative$iv2 = true;
                        overflowDigit$iv--;
                    } else {
                        done$iv = true;
                        break;
                    }
                } else {
                    int digit$iv = 48 - b$iv;
                    if (value$iv < ni.shikatu.okio.internal.Buffer.OVERFLOW_ZONE) {
                        negative$iv = negative$iv2;
                        break loop0;
                    }
                    if (value$iv == ni.shikatu.okio.internal.Buffer.OVERFLOW_ZONE) {
                        negative$iv = negative$iv2;
                        if (digit$iv < overflowDigit$iv) {
                            break loop0;
                        }
                    } else {
                        negative$iv = negative$iv2;
                    }
                    value$iv = (value$iv * 10) + ((long) digit$iv);
                    $i$f$commonReadDecimalLong = $i$f$commonReadDecimalLong2;
                    negative$iv2 = negative$iv;
                }
                pos$iv++;
                seen$iv++;
                done$iv = done$iv;
                j2 = j;
                $i$f$commonReadDecimalLong2 = $i$f$commonReadDecimalLong;
            }
            if (pos$iv == limit$iv) {
                this.head = segment$iv.pop();
                SegmentPool.recycle(segment$iv);
            } else {
                segment$iv.pos = pos$iv;
            }
            if (done$iv || this.head == null) {
                setSize$okio(size() - ((long) seen$iv));
                int minimumSeen$iv = negative$iv2 != 0 ? 2 : 1;
                if (seen$iv >= minimumSeen$iv) {
                    return negative$iv2 != 0 ? value$iv : -value$iv;
                }
                if (size() == j) {
                    throw new EOFException();
                }
                String expected$iv = negative$iv2 != 0 ? "Expected a digit" : "Expected a digit or '-'";
                throw new NumberFormatException(expected$iv + " but was 0x" + SegmentedByteString.toHexString(getByte(j)));
            }
            j2 = j;
            negative$iv2 = negative$iv2;
            $i$f$commonReadDecimalLong2 = $i$f$commonReadDecimalLong;
        }
        Buffer buffer$iv = new Buffer().writeDecimalLong(value$iv).writeByte((int) b$iv);
        if (!negative$iv) {
            buffer$iv.readByte();
        }
        throw new NumberFormatException("Number too large: " + buffer$iv.readUtf8());
    }

    @Override
    public long readHexadecimalUnsignedLong() throws EOFException {
        int digit$iv;
        if (size() == 0) {
            throw new EOFException();
        }
        long value$iv = 0;
        int seen$iv = 0;
        boolean done$iv = false;
        do {
            Segment segment$iv = this.head;
            Intrinsics.checkNotNull(segment$iv);
            byte[] data$iv = segment$iv.data;
            int pos$iv = segment$iv.pos;
            int limit$iv = segment$iv.limit;
            while (pos$iv < limit$iv) {
                byte b$iv = data$iv[pos$iv];
                if (b$iv >= 48 && b$iv <= 57) {
                    digit$iv = b$iv - 48;
                } else if (b$iv >= 97 && b$iv <= 102) {
                    digit$iv = (b$iv - 97) + 10;
                } else if (b$iv >= 65 && b$iv <= 70) {
                    digit$iv = (b$iv - 65) + 10;
                } else {
                    if (seen$iv == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + SegmentedByteString.toHexString(b$iv));
                    }
                    done$iv = true;
                    break;
                }
                if (((-1152921504606846976L) & value$iv) != 0) {
                    Buffer buffer$iv = new Buffer().writeHexadecimalUnsignedLong(value$iv).writeByte((int) b$iv);
                    throw new NumberFormatException("Number too large: " + buffer$iv.readUtf8());
                }
                value$iv = (value$iv << 4) | ((long) digit$iv);
                pos$iv++;
                seen$iv++;
            }
            if (pos$iv == limit$iv) {
                this.head = segment$iv.pop();
                SegmentPool.recycle(segment$iv);
            } else {
                segment$iv.pos = pos$iv;
            }
            if (done$iv) {
                break;
            }
        } while (this.head != null);
        setSize$okio(size() - ((long) seen$iv));
        return value$iv;
    }

    @Override
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override
    public ByteString readByteString(long byteCount) throws EOFException {
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (size() < byteCount) {
            throw new EOFException();
        }
        if (byteCount >= 4096) {
            ByteString byteStringSnapshot = snapshot((int) byteCount);
            skip(byteCount);
            return byteStringSnapshot;
        }
        return new ByteString(readByteArray(byteCount));
    }

    @Override
    public int select(Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        int index$iv = ni.shikatu.okio.internal.Buffer.selectPrefix$default(this, options, false, 2, null);
        if (index$iv == -1) {
            return -1;
        }
        int selectedSize$iv = options.getByteStrings$okio()[index$iv].size();
        skip(selectedSize$iv);
        return index$iv;
    }

    @Override
    public <T> T select(TypedOptions<T> typedOptions) throws IOException {
        Intrinsics.checkNotNullParameter(typedOptions, "options");
        Buffer $this$commonSelect$iv = this;
        int index$iv = $this$commonSelect$iv.select(typedOptions.getOptions$okio());
        if (index$iv == -1) {
            return null;
        }
        return typedOptions.get(index$iv);
    }

    @Override
    public void readFully(Buffer sink, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (size() < byteCount) {
            sink.write(this, size());
            throw new EOFException();
        }
        sink.write(this, byteCount);
    }

    @Override
    public long readAll(Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long byteCount$iv = size();
        if (byteCount$iv > 0) {
            sink.write(this, byteCount$iv);
        }
        return byteCount$iv;
    }

    @Override
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override
    public String readUtf8(long byteCount) throws EOFException {
        return readString(byteCount, Charsets.UTF_8);
    }

    @Override
    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.size, charset);
    }

    @Override
    public String readString(long byteCount, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (this.size < byteCount) {
            throw new EOFException();
        }
        if (byteCount == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        Segment s = this.head;
        Intrinsics.checkNotNull(s);
        if (((long) s.pos) + byteCount > s.limit) {
            return new String(readByteArray(byteCount), charset);
        }
        String result = new String(s.data, s.pos, (int) byteCount, charset);
        s.pos += (int) byteCount;
        this.size -= byteCount;
        if (s.pos == s.limit) {
            this.head = s.pop();
            SegmentPool.recycle(s);
        }
        return result;
    }

    @Override
    public String readUtf8Line() throws EOFException {
        long newline$iv = indexOf((byte) 10);
        if (newline$iv != -1) {
            return ni.shikatu.okio.internal.Buffer.readUtf8Line(this, newline$iv);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = LongCompanionObject.MAX_VALUE;
        if (limit != LongCompanionObject.MAX_VALUE) {
            j = limit + 1;
        }
        long scanLength$iv = j;
        long newline$iv = indexOf((byte) 10, 0L, scanLength$iv);
        if (newline$iv != -1) {
            return ni.shikatu.okio.internal.Buffer.readUtf8Line(this, newline$iv);
        }
        if (scanLength$iv < size() && getByte(scanLength$iv - 1) == 13 && getByte(scanLength$iv) == 10) {
            return ni.shikatu.okio.internal.Buffer.readUtf8Line(this, scanLength$iv);
        }
        Buffer data$iv = new Buffer();
        long b$iv$iv = size();
        copyTo(data$iv, 0L, Math.min(32, b$iv$iv));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), limit) + " content=" + data$iv.readByteString().hex() + Typography.ellipsis);
    }

    @Override
    public int readUtf8CodePoint() throws EOFException {
        int other$iv$iv;
        int codePoint$iv;
        int byteCount$iv;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b0$iv = getByte(0L);
        int other$iv$iv2 = 128 & b0$iv;
        if (other$iv$iv2 == 0) {
            other$iv$iv = 127 & b0$iv;
            codePoint$iv = 1;
            byteCount$iv = 0;
        } else {
            int other$iv$iv3 = 224 & b0$iv;
            if (other$iv$iv3 == 192) {
                other$iv$iv = 31 & b0$iv;
                codePoint$iv = 2;
                byteCount$iv = 128;
            } else {
                int other$iv$iv4 = 240 & b0$iv;
                if (other$iv$iv4 == 224) {
                    other$iv$iv = 15 & b0$iv;
                    codePoint$iv = 3;
                    byteCount$iv = 2048;
                } else {
                    int other$iv$iv5 = 248 & b0$iv;
                    if (other$iv$iv5 != 240) {
                        skip(1L);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                    other$iv$iv = 7 & b0$iv;
                    codePoint$iv = 4;
                    byteCount$iv = 65536;
                }
            }
        }
        if (size() < codePoint$iv) {
            throw new EOFException("size < " + codePoint$iv + ": " + size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b0$iv) + ')');
        }
        for (int i$iv = 1; i$iv < codePoint$iv; i$iv++) {
            int b$iv = getByte(i$iv);
            int other$iv$iv6 = 192 & b$iv;
            if (other$iv$iv6 != 128) {
                skip(i$iv);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            int codePoint$iv2 = other$iv$iv << 6;
            int other$iv$iv7 = 63 & b$iv;
            other$iv$iv = codePoint$iv2 | other$iv$iv7;
        }
        skip(codePoint$iv);
        if (other$iv$iv > 1114111) {
            return Utf8.REPLACEMENT_CODE_POINT;
        }
        boolean z = false;
        if (55296 <= other$iv$iv && other$iv$iv < 57344) {
            z = true;
        }
        return (!z && other$iv$iv >= byteCount$iv) ? other$iv$iv : Utf8.REPLACEMENT_CODE_POINT;
    }

    @Override
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override
    public byte[] readByteArray(long byteCount) throws EOFException {
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (size() < byteCount) {
            throw new EOFException();
        }
        byte[] result$iv = new byte[(int) byteCount];
        readFully(result$iv);
        return result$iv;
    }

    @Override
    public int read(byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int offset$iv = 0;
        while (offset$iv < sink.length) {
            int read$iv = read(sink, offset$iv, sink.length - offset$iv);
            if (read$iv == -1) {
                throw new EOFException();
            }
            offset$iv += read$iv;
        }
    }

    @Override
    public int read(byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, offset, byteCount);
        Segment s$iv = this.head;
        if (s$iv == null) {
            return -1;
        }
        int toCopy$iv = Math.min(byteCount, s$iv.limit - s$iv.pos);
        ArraysKt.copyInto(s$iv.data, sink, offset, s$iv.pos, s$iv.pos + toCopy$iv);
        s$iv.pos += toCopy$iv;
        setSize$okio(size() - ((long) toCopy$iv));
        if (s$iv.pos == s$iv.limit) {
            this.head = s$iv.pop();
            SegmentPool.recycle(s$iv);
        }
        return toCopy$iv;
    }

    @Override
    public int read(ByteBuffer sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(sink.remaining(), s.limit - s.pos);
        sink.put(s.data, s.pos, toCopy);
        s.pos += toCopy;
        this.size -= (long) toCopy;
        if (s.pos == s.limit) {
            this.head = s.pop();
            SegmentPool.recycle(s);
        }
        return toCopy;
    }

    public final void clear() throws EOFException {
        skip(size());
    }

    @Override
    public void skip(long byteCount) throws EOFException {
        long byteCount$iv = byteCount;
        while (byteCount$iv > 0) {
            Segment head$iv = this.head;
            if (head$iv == null) {
                throw new EOFException();
            }
            long a$iv$iv = byteCount$iv;
            int b$iv$iv = (int) Math.min(a$iv$iv, head$iv.limit - head$iv.pos);
            setSize$okio(size() - ((long) b$iv$iv));
            byteCount$iv -= (long) b$iv$iv;
            head$iv.pos += b$iv$iv;
            if (head$iv.pos == head$iv.limit) {
                this.head = head$iv.pop();
                SegmentPool.recycle(head$iv);
            }
        }
    }

    @Override
    public Buffer write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        int byteCount$iv = byteString.size();
        byteString.write$okio(this, 0, byteCount$iv);
        return this;
    }

    @Override
    public Buffer write(ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, offset, byteCount);
        return this;
    }

    @Override
    public Buffer writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    @Override
    public Buffer writeUtf8(String string, int beginIndex, int endIndex) {
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
        int i$iv = beginIndex;
        while (i$iv < endIndex) {
            int c$iv = string.charAt(i$iv);
            if (c$iv < 128) {
                Segment tail$iv = writableSegment$okio(i);
                byte[] data$iv = tail$iv.data;
                int segmentOffset$iv = tail$iv.limit - i$iv;
                int runLimit$iv = Math.min(endIndex, 8192 - segmentOffset$iv);
                data$iv[i$iv + segmentOffset$iv] = (byte) c$iv;
                int i$iv2 = i$iv + 1;
                while (i$iv2 < runLimit$iv) {
                    int c$iv2 = string.charAt(i$iv2);
                    if (c$iv2 >= 128) {
                        break;
                    }
                    data$iv[i$iv2 + segmentOffset$iv] = (byte) c$iv2;
                    i$iv2++;
                }
                int runSize$iv = (i$iv2 + segmentOffset$iv) - tail$iv.limit;
                tail$iv.limit += runSize$iv;
                setSize$okio(size() + ((long) runSize$iv));
                i = i;
                i$iv = i$iv2;
            } else {
                int i2 = i;
                if (c$iv < 2048) {
                    Segment tail$iv2 = writableSegment$okio(2);
                    tail$iv2.data[tail$iv2.limit] = (byte) ((c$iv >> 6) | 192);
                    tail$iv2.data[tail$iv2.limit + i2] = (byte) (128 | (c$iv & 63));
                    tail$iv2.limit += 2;
                    setSize$okio(size() + 2);
                    i$iv++;
                    i = i2;
                } else if (c$iv >= 55296 && c$iv <= 57343) {
                    int low$iv = i$iv + 1 < endIndex ? string.charAt(i$iv + 1) : 0;
                    if (c$iv <= 56319) {
                        if (((56320 > low$iv || low$iv >= 57344) ? 0 : i2) != 0) {
                            int codePoint$iv = (((c$iv & 1023) << 10) | (low$iv & 1023)) + 65536;
                            Segment tail$iv3 = writableSegment$okio(4);
                            tail$iv3.data[tail$iv3.limit] = (byte) ((codePoint$iv >> 18) | 240);
                            tail$iv3.data[tail$iv3.limit + 1] = (byte) (((codePoint$iv >> 12) & 63) | 128);
                            tail$iv3.data[tail$iv3.limit + 2] = (byte) ((63 & (codePoint$iv >> 6)) | 128);
                            tail$iv3.data[tail$iv3.limit + 3] = (byte) (128 | (codePoint$iv & 63));
                            tail$iv3.limit += 4;
                            setSize$okio(size() + 4);
                            i$iv += 2;
                            i = i2;
                        }
                    }
                    writeByte(63);
                    i$iv++;
                    i = i2;
                } else {
                    Segment tail$iv4 = writableSegment$okio(3);
                    tail$iv4.data[tail$iv4.limit] = (byte) ((c$iv >> 12) | 224);
                    tail$iv4.data[tail$iv4.limit + 1] = (byte) ((63 & (c$iv >> 6)) | 128);
                    tail$iv4.data[tail$iv4.limit + 2] = (byte) (128 | (c$iv & 63));
                    tail$iv4.limit += 3;
                    setSize$okio(size() + 3);
                    i$iv++;
                    i = i2;
                }
            }
        }
        return this;
    }

    @Override
    public Buffer writeUtf8CodePoint(int codePoint) {
        if (codePoint >= 128) {
            if (codePoint >= 2048) {
                boolean z = false;
                if (55296 <= codePoint && codePoint < 57344) {
                    z = true;
                }
                if (!z) {
                    if (codePoint >= 65536) {
                        if (codePoint <= 1114111) {
                            Segment tail$iv = writableSegment$okio(4);
                            tail$iv.data[tail$iv.limit] = (byte) ((codePoint >> 18) | 240);
                            tail$iv.data[tail$iv.limit + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                            tail$iv.data[tail$iv.limit + 2] = (byte) ((63 & (codePoint >> 6)) | 128);
                            tail$iv.data[tail$iv.limit + 3] = (byte) (128 | (codePoint & 63));
                            tail$iv.limit += 4;
                            setSize$okio(size() + 4);
                        } else {
                            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(codePoint));
                        }
                    } else {
                        Segment tail$iv2 = writableSegment$okio(3);
                        tail$iv2.data[tail$iv2.limit] = (byte) ((codePoint >> 12) | 224);
                        tail$iv2.data[tail$iv2.limit + 1] = (byte) ((63 & (codePoint >> 6)) | 128);
                        tail$iv2.data[tail$iv2.limit + 2] = (byte) (128 | (codePoint & 63));
                        tail$iv2.limit += 3;
                        setSize$okio(size() + 3);
                    }
                } else {
                    writeByte(63);
                }
            } else {
                Segment tail$iv3 = writableSegment$okio(2);
                tail$iv3.data[tail$iv3.limit] = (byte) ((codePoint >> 6) | 192);
                tail$iv3.data[tail$iv3.limit + 1] = (byte) (128 | (codePoint & 63));
                tail$iv3.limit += 2;
                setSize$okio(size() + 2);
            }
        } else {
            writeByte(codePoint);
        }
        return this;
    }

    @Override
    public Buffer writeString(String string, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override
    public Buffer writeString(String string, int beginIndex, int endIndex, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return writeUtf8(string, beginIndex, endIndex);
        }
        String strSubstring = string.substring(beginIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        byte[] data = strSubstring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(data, "getBytes(...)");
        return write(data, 0, data.length);
    }

    @Override
    public Buffer write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return write(source, 0, source.length);
    }

    @Override
    public Buffer write(byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        int offset$iv = offset;
        SegmentedByteString.checkOffsetAndCount(source.length, offset$iv, byteCount);
        int limit$iv = offset$iv + byteCount;
        while (offset$iv < limit$iv) {
            Segment tail$iv = writableSegment$okio(1);
            int toCopy$iv = Math.min(limit$iv - offset$iv, 8192 - tail$iv.limit);
            ArraysKt.copyInto(source, tail$iv.data, tail$iv.limit, offset$iv, offset$iv + toCopy$iv);
            offset$iv += toCopy$iv;
            tail$iv.limit += toCopy$iv;
        }
        setSize$okio(size() + ((long) byteCount));
        return this;
    }

    @Override
    public int write(ByteBuffer source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        int byteCount = source.remaining();
        int remaining = byteCount;
        while (remaining > 0) {
            Segment tail = writableSegment$okio(1);
            int toCopy = Math.min(remaining, 8192 - tail.limit);
            source.get(tail.data, tail.limit, toCopy);
            remaining -= toCopy;
            tail.limit += toCopy;
        }
        this.size += (long) byteCount;
        return byteCount;
    }

    @Override
    public long writeAll(Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long totalBytesRead$iv = 0;
        while (true) {
            long readCount$iv = source.read(this, 8192L);
            if (readCount$iv == -1) {
                return totalBytesRead$iv;
            }
            totalBytesRead$iv += readCount$iv;
        }
    }

    @Override
    public Buffer write(Source source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long byteCount$iv = byteCount;
        while (byteCount$iv > 0) {
            long read$iv = source.read(this, byteCount$iv);
            if (read$iv == -1) {
                throw new EOFException();
            }
            byteCount$iv -= read$iv;
        }
        return this;
    }

    @Override
    public Buffer writeByte(int b) {
        Segment tail$iv = writableSegment$okio(1);
        byte[] bArr = tail$iv.data;
        int i = tail$iv.limit;
        tail$iv.limit = i + 1;
        bArr[i] = (byte) b;
        setSize$okio(size() + 1);
        return this;
    }

    @Override
    public Buffer writeShort(int s) {
        Segment tail$iv = writableSegment$okio(2);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((s >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        data$iv[limit$iv2] = (byte) (s & KotlinVersion.MAX_COMPONENT_VALUE);
        tail$iv.limit = limit$iv2 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override
    public Buffer writeShortLe(int s) {
        return writeShort((int) SegmentedByteString.reverseBytes((short) s));
    }

    @Override
    public Buffer writeInt(int i) {
        Segment tail$iv = writableSegment$okio(4);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((i >>> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
        int limit$iv3 = limit$iv2 + 1;
        data$iv[limit$iv2] = (byte) ((i >>> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
        int limit$iv4 = limit$iv3 + 1;
        data$iv[limit$iv3] = (byte) ((i >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        data$iv[limit$iv4] = (byte) (i & KotlinVersion.MAX_COMPONENT_VALUE);
        tail$iv.limit = limit$iv4 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override
    public Buffer writeIntLe(int i) {
        return writeInt(SegmentedByteString.reverseBytes(i));
    }

    @Override
    public Buffer writeLong(long v) {
        Segment tail$iv = writableSegment$okio(8);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((v >>> 56) & 255);
        int limit$iv3 = limit$iv2 + 1;
        data$iv[limit$iv2] = (byte) ((v >>> 48) & 255);
        int limit$iv4 = limit$iv3 + 1;
        data$iv[limit$iv3] = (byte) ((v >>> 40) & 255);
        int limit$iv5 = limit$iv4 + 1;
        data$iv[limit$iv4] = (byte) ((v >>> 32) & 255);
        int limit$iv6 = limit$iv5 + 1;
        data$iv[limit$iv5] = (byte) ((v >>> 24) & 255);
        int limit$iv7 = limit$iv6 + 1;
        data$iv[limit$iv6] = (byte) ((v >>> 16) & 255);
        int limit$iv8 = limit$iv7 + 1;
        data$iv[limit$iv7] = (byte) ((v >>> 8) & 255);
        data$iv[limit$iv8] = (byte) (v & 255);
        tail$iv.limit = limit$iv8 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override
    public Buffer writeLongLe(long v) {
        return writeLong(SegmentedByteString.reverseBytes(v));
    }

    @Override
    public Buffer writeDecimalLong(long v) {
        long v$iv = v;
        if (v$iv == 0) {
            return writeByte(48);
        }
        boolean negative$iv = false;
        if (v$iv < 0) {
            v$iv = -v$iv;
            if (v$iv < 0) {
                return writeUtf8("-9223372036854775808");
            }
            negative$iv = true;
        }
        int width$iv = ni.shikatu.okio.internal.Buffer.countDigitsIn(v$iv);
        if (negative$iv) {
            width$iv++;
        }
        Segment tail$iv = writableSegment$okio(width$iv);
        byte[] data$iv = tail$iv.data;
        int pos$iv = tail$iv.limit + width$iv;
        for (long j = 0; v$iv != j; j = 0) {
            long j2 = 10;
            int digit$iv = (int) (v$iv % j2);
            pos$iv--;
            data$iv[pos$iv] = ni.shikatu.okio.internal.Buffer.getHEX_DIGIT_BYTES()[digit$iv];
            v$iv /= j2;
        }
        if (negative$iv) {
            data$iv[pos$iv - 1] = 45;
        }
        tail$iv.limit += width$iv;
        setSize$okio(size() + ((long) width$iv));
        return this;
    }

    @Override
    public Buffer writeHexadecimalUnsignedLong(long v) {
        long v$iv = v;
        if (v$iv == 0) {
            return writeByte(48);
        }
        long x$iv = v$iv | (v$iv >>> 1);
        long x$iv2 = x$iv | (x$iv >>> 2);
        char c = 4;
        long x$iv3 = x$iv2 | (x$iv2 >>> 4);
        long x$iv4 = x$iv3 | (x$iv3 >>> 8);
        long x$iv5 = x$iv4 | (x$iv4 >>> 16);
        long x$iv6 = x$iv5 | (x$iv5 >>> 32);
        long x$iv7 = x$iv6 - ((x$iv6 >>> 1) & 6148914691236517205L);
        long x$iv8 = ((x$iv7 >>> 2) & 3689348814741910323L) + (x$iv7 & 3689348814741910323L);
        long x$iv9 = ((x$iv8 >>> 4) + x$iv8) & 1085102592571150095L;
        long x$iv10 = x$iv9 + (x$iv9 >>> 8);
        long x$iv11 = x$iv10 + (x$iv10 >>> 16);
        int width$iv = (int) ((((long) 3) + ((x$iv11 & 63) + ((x$iv11 >>> 32) & 63))) / ((long) 4));
        Segment tail$iv = writableSegment$okio(width$iv);
        byte[] data$iv = tail$iv.data;
        int pos$iv = (tail$iv.limit + width$iv) - 1;
        int start$iv = tail$iv.limit;
        while (pos$iv >= start$iv) {
            char c2 = c;
            int pos$iv2 = pos$iv;
            data$iv[pos$iv2] = ni.shikatu.okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (v$iv & 15)];
            v$iv >>>= c2;
            pos$iv = pos$iv2 - 1;
            c = c2;
        }
        tail$iv.limit += width$iv;
        setSize$okio(size() + ((long) width$iv));
        return this;
    }

    public final Segment writableSegment$okio(int minimumCapacity) {
        if (!(minimumCapacity >= 1 && minimumCapacity <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        if (this.head == null) {
            Segment result$iv = SegmentPool.take();
            this.head = result$iv;
            result$iv.prev = result$iv;
            result$iv.next = result$iv;
            return result$iv;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment tail$iv = segment.prev;
        Intrinsics.checkNotNull(tail$iv);
        return (tail$iv.limit + minimumCapacity > 8192 || !tail$iv.owner) ? tail$iv.push(SegmentPool.take()) : tail$iv;
    }

    @Override
    public void write(Buffer source, long byteCount) {
        Segment tail$iv;
        Intrinsics.checkNotNullParameter(source, "source");
        long byteCount$iv = byteCount;
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, byteCount$iv);
        while (byteCount$iv > 0) {
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.limit;
            Segment segment2 = source.head;
            Intrinsics.checkNotNull(segment2);
            if (byteCount$iv < i - segment2.pos) {
                if (this.head != null) {
                    Segment segment3 = this.head;
                    Intrinsics.checkNotNull(segment3);
                    tail$iv = segment3.prev;
                } else {
                    tail$iv = null;
                }
                if (tail$iv != null && tail$iv.owner) {
                    if ((((long) tail$iv.limit) + byteCount$iv) - ((long) (tail$iv.shared ? 0 : tail$iv.pos)) <= 8192) {
                        Segment segment4 = source.head;
                        Intrinsics.checkNotNull(segment4);
                        segment4.writeTo(tail$iv, (int) byteCount$iv);
                        source.setSize$okio(source.size() - byteCount$iv);
                        setSize$okio(size() + byteCount$iv);
                        return;
                    }
                }
                Segment segment5 = source.head;
                Intrinsics.checkNotNull(segment5);
                source.head = segment5.split((int) byteCount$iv);
            }
            Segment tail$iv2 = source.head;
            Intrinsics.checkNotNull(tail$iv2);
            long movedByteCount$iv = tail$iv2.limit - tail$iv2.pos;
            source.head = tail$iv2.pop();
            if (this.head == null) {
                this.head = tail$iv2;
                tail$iv2.prev = tail$iv2;
                tail$iv2.next = tail$iv2.prev;
            } else {
                Segment segment6 = this.head;
                Intrinsics.checkNotNull(segment6);
                Segment tail$iv3 = segment6.prev;
                Intrinsics.checkNotNull(tail$iv3);
                tail$iv3.push(tail$iv2).compact();
            }
            source.setSize$okio(source.size() - movedByteCount$iv);
            setSize$okio(size() + movedByteCount$iv);
            byteCount$iv -= movedByteCount$iv;
        }
    }

    @Override
    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        long byteCount$iv = byteCount > size() ? size() : byteCount;
        sink.write(this, byteCount$iv);
        return byteCount$iv;
    }

    @Override
    public long indexOf(byte b) {
        return indexOf(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    @Override
    public long indexOf(byte b, long fromIndex) {
        return indexOf(b, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    @Override
    public long indexOf(byte b, long fromIndex, long toIndex) {
        Buffer $this$seek$iv$iv;
        Segment s$iv$iv;
        int limit$iv = 0;
        boolean z = false;
        if (0 <= fromIndex && fromIndex <= toIndex) {
            z = true;
        }
        if (z) {
            long toIndex$iv = toIndex > size() ? size() : toIndex;
            if (fromIndex != toIndex$iv && (s$iv$iv = ($this$seek$iv$iv = this).head) != null) {
                if ($this$seek$iv$iv.size() - fromIndex < fromIndex) {
                    long offset$iv$iv = $this$seek$iv$iv.size();
                    while (offset$iv$iv > fromIndex) {
                        Segment segment = s$iv$iv.prev;
                        Intrinsics.checkNotNull(segment);
                        s$iv$iv = segment;
                        offset$iv$iv -= (long) (s$iv$iv.limit - s$iv$iv.pos);
                    }
                    Segment s$iv = s$iv$iv;
                    long offset$iv = offset$iv$iv;
                    if (s$iv == null) {
                        return -1L;
                    }
                    long offset$iv2 = offset$iv;
                    long fromIndex$iv = fromIndex;
                    Segment s$iv2 = s$iv;
                    while (offset$iv2 < toIndex$iv) {
                        int $i$f$commonIndexOf = limit$iv;
                        byte[] data$iv = s$iv2.data;
                        long toIndex$iv2 = toIndex$iv;
                        Buffer $this$seek$iv$iv2 = $this$seek$iv$iv;
                        int limit$iv2 = (int) Math.min(s$iv2.limit, (((long) s$iv2.pos) + toIndex$iv2) - offset$iv2);
                        for (int pos$iv = (int) ((((long) s$iv2.pos) + fromIndex$iv) - offset$iv2); pos$iv < limit$iv2; pos$iv++) {
                            if (data$iv[pos$iv] == b) {
                                return ((long) (pos$iv - s$iv2.pos)) + offset$iv2;
                            }
                        }
                        offset$iv2 += (long) (s$iv2.limit - s$iv2.pos);
                        fromIndex$iv = offset$iv2;
                        Segment segment2 = s$iv2.next;
                        Intrinsics.checkNotNull(segment2);
                        s$iv2 = segment2;
                        limit$iv = $i$f$commonIndexOf;
                        toIndex$iv = toIndex$iv2;
                        $this$seek$iv$iv = $this$seek$iv$iv2;
                    }
                    return -1L;
                }
                long toIndex$iv3 = toIndex$iv;
                long offset$iv$iv2 = 0;
                while (true) {
                    long nextOffset$iv$iv = ((long) (s$iv$iv.limit - s$iv$iv.pos)) + offset$iv$iv2;
                    if (nextOffset$iv$iv > fromIndex) {
                        break;
                    }
                    Segment segment3 = s$iv$iv.next;
                    Intrinsics.checkNotNull(segment3);
                    s$iv$iv = segment3;
                    offset$iv$iv2 = nextOffset$iv$iv;
                }
                Segment s$iv3 = s$iv$iv;
                long offset$iv3 = offset$iv$iv2;
                if (s$iv3 == null) {
                    return -1L;
                }
                Segment s$iv4 = s$iv3;
                long offset$iv4 = offset$iv3;
                long fromIndex$iv2 = fromIndex;
                while (offset$iv4 < toIndex$iv3) {
                    Segment s$iv5 = s$iv3;
                    byte[] data$iv2 = s$iv4.data;
                    long offset$iv$iv3 = offset$iv$iv2;
                    long offset$iv$iv4 = s$iv4.limit;
                    long offset$iv5 = offset$iv3;
                    int limit$iv3 = (int) Math.min(offset$iv$iv4, (((long) s$iv4.pos) + toIndex$iv3) - offset$iv4);
                    for (int pos$iv2 = (int) ((((long) s$iv4.pos) + fromIndex$iv2) - offset$iv4); pos$iv2 < limit$iv3; pos$iv2++) {
                        if (data$iv2[pos$iv2] == b) {
                            return ((long) (pos$iv2 - s$iv4.pos)) + offset$iv4;
                        }
                    }
                    offset$iv4 += (long) (s$iv4.limit - s$iv4.pos);
                    fromIndex$iv2 = offset$iv4;
                    Segment segment4 = s$iv4.next;
                    Intrinsics.checkNotNull(segment4);
                    s$iv4 = segment4;
                    s$iv3 = s$iv5;
                    offset$iv$iv2 = offset$iv$iv3;
                    offset$iv3 = offset$iv5;
                }
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
    }

    @Override
    public long indexOf(ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override
    public long indexOf(ByteString bytes, long fromIndex) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    @Override
    public long indexOf(ByteString bytes, long fromIndex, long toIndex) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return ni.shikatu.okio.internal.Buffer.commonIndexOf(this, bytes, fromIndex, (24 & 4) != 0 ? Long.MAX_VALUE : toIndex, (24 & 8) != 0 ? 0 : 0, (24 & 16) != 0 ? bytes.size() : 0);
    }

    @Override
    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override
    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        ByteString targetBytes$iv = targetBytes;
        int $i$f$commonIndexOfElement = 0;
        if (!(fromIndex >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex).toString());
        }
        Buffer $this$seek$iv$iv = this;
        Segment s$iv$iv = $this$seek$iv$iv.head;
        if (s$iv$iv == null) {
            return -1L;
        }
        if ($this$seek$iv$iv.size() - fromIndex < fromIndex) {
            long offset$iv$iv = $this$seek$iv$iv.size();
            while (offset$iv$iv > fromIndex) {
                Segment segment = s$iv$iv.prev;
                Intrinsics.checkNotNull(segment);
                s$iv$iv = segment;
                offset$iv$iv -= (long) (s$iv$iv.limit - s$iv$iv.pos);
            }
            Segment s$iv = s$iv$iv;
            long offset$iv = offset$iv$iv;
            if (s$iv == null) {
                return -1L;
            }
            long offset$iv2 = offset$iv;
            if (targetBytes$iv.size() == 2) {
                int b0$iv = targetBytes$iv.getByte(0);
                int b1$iv = targetBytes$iv.getByte(1);
                long fromIndex$iv = fromIndex;
                Segment s$iv2 = s$iv;
                while (offset$iv2 < size()) {
                    int $i$f$commonIndexOfElement2 = $i$f$commonIndexOfElement;
                    byte[] data$iv = s$iv2.data;
                    Buffer $this$seek$iv$iv2 = $this$seek$iv$iv;
                    int b$iv = (int) ((((long) s$iv2.pos) + fromIndex$iv) - offset$iv2);
                    int limit$iv = s$iv2.limit;
                    while (b$iv < limit$iv) {
                        int pos$iv = b$iv;
                        int pos$iv2 = data$iv[pos$iv];
                        if (pos$iv2 == b0$iv || pos$iv2 == b1$iv) {
                            return ((long) (pos$iv - s$iv2.pos)) + offset$iv2;
                        }
                        b$iv = pos$iv + 1;
                    }
                    int b0$iv2 = b0$iv;
                    offset$iv2 += (long) (s$iv2.limit - s$iv2.pos);
                    fromIndex$iv = offset$iv2;
                    Segment segment2 = s$iv2.next;
                    Intrinsics.checkNotNull(segment2);
                    s$iv2 = segment2;
                    $i$f$commonIndexOfElement = $i$f$commonIndexOfElement2;
                    $this$seek$iv$iv = $this$seek$iv$iv2;
                    b0$iv = b0$iv2;
                }
            } else {
                byte[] targetByteArray$iv = targetBytes$iv.internalArray$okio();
                long fromIndex$iv2 = fromIndex;
                Segment s$iv3 = s$iv;
                while (offset$iv2 < size()) {
                    byte[] data$iv2 = s$iv3.data;
                    int b$iv2 = (int) ((((long) s$iv3.pos) + fromIndex$iv2) - offset$iv2);
                    int limit$iv2 = s$iv3.limit;
                    while (b$iv2 < limit$iv2) {
                        int pos$iv3 = b$iv2;
                        byte pos$iv4 = data$iv2[pos$iv3];
                        int limit$iv3 = limit$iv2;
                        int limit$iv4 = targetByteArray$iv.length;
                        byte[] targetByteArray$iv2 = targetByteArray$iv;
                        int i = 0;
                        while (i < limit$iv4) {
                            int i2 = i;
                            byte t$iv = targetByteArray$iv2[i2];
                            if (pos$iv4 == t$iv) {
                                return ((long) (pos$iv3 - s$iv3.pos)) + offset$iv2;
                            }
                            i = i2 + 1;
                        }
                        b$iv2 = pos$iv3 + 1;
                        limit$iv2 = limit$iv3;
                        targetByteArray$iv = targetByteArray$iv2;
                    }
                    byte[] targetByteArray$iv3 = targetByteArray$iv;
                    offset$iv2 += (long) (s$iv3.limit - s$iv3.pos);
                    fromIndex$iv2 = offset$iv2;
                    Segment segment3 = s$iv3.next;
                    Intrinsics.checkNotNull(segment3);
                    s$iv3 = segment3;
                    targetByteArray$iv = targetByteArray$iv3;
                }
            }
            return -1L;
        }
        long offset$iv$iv2 = 0;
        while (true) {
            long nextOffset$iv$iv = ((long) (s$iv$iv.limit - s$iv$iv.pos)) + offset$iv$iv2;
            if (nextOffset$iv$iv > fromIndex) {
                break;
            }
            Segment segment4 = s$iv$iv.next;
            Intrinsics.checkNotNull(segment4);
            s$iv$iv = segment4;
            offset$iv$iv2 = nextOffset$iv$iv;
        }
        Segment s$iv4 = s$iv$iv;
        long offset$iv3 = offset$iv$iv2;
        if (s$iv4 == null) {
            return -1L;
        }
        Segment s$iv5 = s$iv4;
        long offset$iv4 = offset$iv3;
        if (targetBytes$iv.size() == 2) {
            int b0$iv3 = targetBytes$iv.getByte(0);
            int b1$iv2 = targetBytes$iv.getByte(1);
            long fromIndex$iv3 = fromIndex;
            while (offset$iv4 < size()) {
                long offset$iv$iv3 = offset$iv$iv2;
                byte[] data$iv3 = s$iv5.data;
                int b$iv3 = (int) ((((long) s$iv5.pos) + fromIndex$iv3) - offset$iv4);
                int limit$iv5 = s$iv5.limit;
                while (b$iv3 < limit$iv5) {
                    int pos$iv5 = b$iv3;
                    int pos$iv6 = data$iv3[pos$iv5];
                    if (pos$iv6 == b0$iv3 || pos$iv6 == b1$iv2) {
                        int b$iv4 = s$iv5.pos;
                        return ((long) (pos$iv5 - b$iv4)) + offset$iv4;
                    }
                    b$iv3 = pos$iv5 + 1;
                }
                int pos$iv7 = s$iv5.limit;
                offset$iv4 += (long) (pos$iv7 - s$iv5.pos);
                fromIndex$iv3 = offset$iv4;
                Segment segment5 = s$iv5.next;
                Intrinsics.checkNotNull(segment5);
                s$iv5 = segment5;
                offset$iv$iv2 = offset$iv$iv3;
            }
        } else {
            byte[] targetByteArray$iv4 = targetBytes$iv.internalArray$okio();
            long fromIndex$iv4 = fromIndex;
            while (offset$iv4 < size()) {
                byte[] data$iv4 = s$iv5.data;
                Segment s$iv6 = s$iv5;
                int pos$iv8 = (int) ((((long) s$iv5.pos) + fromIndex$iv4) - offset$iv4);
                int limit$iv6 = s$iv6.limit;
                while (pos$iv8 < limit$iv6) {
                    byte[] data$iv5 = data$iv4;
                    byte b$iv5 = data$iv5[pos$iv8];
                    ByteString targetBytes$iv2 = targetBytes$iv;
                    int length = targetByteArray$iv4.length;
                    byte[] targetByteArray$iv5 = targetByteArray$iv4;
                    int i3 = 0;
                    while (i3 < length) {
                        int i4 = i3;
                        byte t$iv2 = targetByteArray$iv5[i4];
                        if (b$iv5 == t$iv2) {
                            return ((long) (pos$iv8 - s$iv6.pos)) + offset$iv4;
                        }
                        i3 = i4 + 1;
                    }
                    pos$iv8++;
                    data$iv4 = data$iv5;
                    targetBytes$iv = targetBytes$iv2;
                    targetByteArray$iv4 = targetByteArray$iv5;
                }
                byte[] targetByteArray$iv6 = targetByteArray$iv4;
                offset$iv4 += (long) (s$iv6.limit - s$iv6.pos);
                fromIndex$iv4 = offset$iv4;
                Segment segment6 = s$iv6.next;
                Intrinsics.checkNotNull(segment6);
                s$iv5 = segment6;
                targetByteArray$iv4 = targetByteArray$iv6;
            }
        }
        return -1L;
    }

    @Override
    public boolean rangeEquals(long offset, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override
    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (byteCount >= 0 && offset >= 0 && ((long) byteCount) + offset <= size() && bytesOffset >= 0 && bytesOffset + byteCount <= bytes.size()) {
            return byteCount == 0 || ni.shikatu.okio.internal.Buffer.commonIndexOf(this, bytes, offset, 1 + offset, bytesOffset, byteCount) != -1;
        }
        return false;
    }

    @Override
    public void flush() {
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public void close() {
    }

    @Override
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private final ByteString digest(String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Segment head = this.head;
        if (head != null) {
            messageDigest.update(head.data, head.pos, head.limit - head.pos);
            Segment s = head.next;
            Intrinsics.checkNotNull(s);
            while (s != head) {
                messageDigest.update(s.data, s.pos, s.limit - s.pos);
                Segment segment = s.next;
                Intrinsics.checkNotNull(segment);
                s = segment;
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return new ByteString(bArrDigest);
    }

    public final ByteString hmacSha1(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac("HmacSHA1", key);
    }

    public final ByteString hmacSha256(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac("HmacSHA256", key);
    }

    public final ByteString hmacSha512(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac("HmacSHA512", key);
    }

    private final ByteString hmac(String algorithm, ByteString key) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.internalArray$okio(), algorithm));
            Segment head = this.head;
            if (head != null) {
                mac.update(head.data, head.pos, head.limit - head.pos);
                Segment s = head.next;
                Intrinsics.checkNotNull(s);
                while (s != head) {
                    mac.update(s.data, s.pos, s.limit - s.pos);
                    Segment segment = s.next;
                    Intrinsics.checkNotNull(segment);
                    s = segment;
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof Buffer) && size() == ((Buffer) other).size()) {
            if (size() == 0) {
                return true;
            }
            Segment sa$iv = this.head;
            Intrinsics.checkNotNull(sa$iv);
            Segment sb$iv = ((Buffer) other).head;
            Intrinsics.checkNotNull(sb$iv);
            int posA$iv = sa$iv.pos;
            int posB$iv = sb$iv.pos;
            long pos$iv = 0;
            while (pos$iv < size()) {
                long count$iv = Math.min(sa$iv.limit - posA$iv, sb$iv.limit - posB$iv);
                long i$iv = 0;
                while (i$iv < count$iv) {
                    int posA$iv2 = posA$iv + 1;
                    int posB$iv2 = posB$iv + 1;
                    if (sa$iv.data[posA$iv] != sb$iv.data[posB$iv]) {
                        return false;
                    }
                    i$iv++;
                    posA$iv = posA$iv2;
                    posB$iv = posB$iv2;
                }
                if (posA$iv == sa$iv.limit) {
                    Segment sa$iv2 = sa$iv.next;
                    Intrinsics.checkNotNull(sa$iv2);
                    posA$iv = sa$iv2.pos;
                    sa$iv = sa$iv2;
                }
                if (posB$iv == sb$iv.limit) {
                    Segment sb$iv2 = sb$iv.next;
                    Intrinsics.checkNotNull(sb$iv2);
                    posB$iv = sb$iv2.pos;
                    sb$iv = sb$iv2;
                }
                pos$iv += count$iv;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Segment s$iv = this.head;
        if (s$iv == null) {
            return 0;
        }
        int result$iv = 1;
        do {
            int limit$iv = s$iv.limit;
            for (int pos$iv = s$iv.pos; pos$iv < limit$iv; pos$iv++) {
                result$iv = (result$iv * 31) + s$iv.data[pos$iv];
            }
            Segment segment = s$iv.next;
            Intrinsics.checkNotNull(segment);
            s$iv = segment;
        } while (s$iv != this.head);
        return result$iv;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Buffer copy() {
        Buffer result$iv = new Buffer();
        if (size() != 0) {
            Segment head$iv = this.head;
            Intrinsics.checkNotNull(head$iv);
            Segment headCopy$iv = head$iv.sharedCopy();
            result$iv.head = headCopy$iv;
            headCopy$iv.prev = result$iv.head;
            headCopy$iv.next = headCopy$iv.prev;
            for (Segment s$iv = head$iv.next; s$iv != head$iv; s$iv = s$iv.next) {
                Segment segment = headCopy$iv.prev;
                Intrinsics.checkNotNull(segment);
                Intrinsics.checkNotNull(s$iv);
                segment.push(s$iv.sharedCopy());
            }
            result$iv.setSize$okio(size());
        }
        return result$iv;
    }

    public Buffer clone() {
        return copy();
    }

    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public final ByteString snapshot(int byteCount) {
        if (byteCount == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(size(), 0L, byteCount);
        int offset$iv = 0;
        int segmentCount$iv = 0;
        Segment s$iv = this.head;
        while (offset$iv < byteCount) {
            Intrinsics.checkNotNull(s$iv);
            if (s$iv.limit == s$iv.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            offset$iv += s$iv.limit - s$iv.pos;
            segmentCount$iv++;
            s$iv = s$iv.next;
        }
        byte[][] segments$iv = new byte[segmentCount$iv][];
        int[] directory$iv = new int[segmentCount$iv * 2];
        int offset$iv2 = 0;
        int segmentCount$iv2 = 0;
        Segment s$iv2 = this.head;
        while (offset$iv2 < byteCount) {
            Intrinsics.checkNotNull(s$iv2);
            segments$iv[segmentCount$iv2] = s$iv2.data;
            offset$iv2 += s$iv2.limit - s$iv2.pos;
            directory$iv[segmentCount$iv2] = Math.min(offset$iv2, byteCount);
            directory$iv[segments$iv.length + segmentCount$iv2] = s$iv2.pos;
            s$iv2.shared = true;
            segmentCount$iv2++;
            s$iv2 = s$iv2.next;
        }
        return new C0026SegmentedByteString(segments$iv, directory$iv);
    }

    public static  UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return ni.shikatu.okio.internal.Buffer.commonReadUnsafe(this, unsafeCursor);
    }

    public static  UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return ni.shikatu.okio.internal.Buffer.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))

    public final byte m1750deprecated_getByte(long index) {
        return getByte(index);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))

    public final long m1751deprecated_size() {
        return this.size;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lni/shikatu/okio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "<init>", "()V", "buffer", "Lni/shikatu/okio/Buffer;", "readWrite", _UrlKt.FRAGMENT_ENCODE_SET, "segment", "Lni/shikatu/okio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "offset", _UrlKt.FRAGMENT_ENCODE_SET, "data", _UrlKt.FRAGMENT_ENCODE_SET, "start", _UrlKt.FRAGMENT_ENCODE_SET, "end", "next", "seek", "resizeBuffer", "newSize", "expandBuffer", "minByteCount", "close", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final void setSegment$okio(Segment segment) {
            this.segment = segment;
        }

        public final int next() {
            long j = this.offset;
            Buffer buffer = this.buffer;
            Intrinsics.checkNotNull(buffer);
            if (j != buffer.size()) {
                return seek(this.offset == -1 ? 0L : this.offset + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final int seek(long offset) {
            Segment next$iv;
            long nextOffset$iv;
            Buffer buffer$iv = this.buffer;
            if (buffer$iv == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (offset < -1 || offset > buffer$iv.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + offset + " > size=" + buffer$iv.size());
            }
            if (offset == -1 || offset == buffer$iv.size()) {
                setSegment$okio(null);
                this.offset = offset;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long min$iv = 0;
            long max$iv = buffer$iv.size();
            Segment head$iv = buffer$iv.head;
            Segment tail$iv = buffer$iv.head;
            if (getSegment$okio() != null) {
                long j = this.offset;
                int i = this.start;
                Segment segment$okio = getSegment$okio();
                Intrinsics.checkNotNull(segment$okio);
                long segmentOffset$iv = j - ((long) (i - segment$okio.pos));
                if (segmentOffset$iv > offset) {
                    max$iv = segmentOffset$iv;
                    tail$iv = getSegment$okio();
                } else {
                    min$iv = segmentOffset$iv;
                    head$iv = getSegment$okio();
                }
            }
            if (max$iv - offset > offset - min$iv) {
                next$iv = head$iv;
                nextOffset$iv = min$iv;
                while (true) {
                    Intrinsics.checkNotNull(next$iv);
                    if (offset < ((long) (next$iv.limit - next$iv.pos)) + nextOffset$iv) {
                        break;
                    }
                    nextOffset$iv += (long) (next$iv.limit - next$iv.pos);
                    next$iv = next$iv.next;
                }
            } else {
                next$iv = tail$iv;
                nextOffset$iv = max$iv;
                while (nextOffset$iv > offset) {
                    Intrinsics.checkNotNull(next$iv);
                    next$iv = next$iv.prev;
                    Intrinsics.checkNotNull(next$iv);
                    nextOffset$iv -= (long) (next$iv.limit - next$iv.pos);
                }
            }
            if (this.readWrite) {
                Intrinsics.checkNotNull(next$iv);
                if (next$iv.shared) {
                    Segment unsharedNext$iv = next$iv.unsharedCopy();
                    if (buffer$iv.head == next$iv) {
                        buffer$iv.head = unsharedNext$iv;
                    }
                    next$iv = next$iv.push(unsharedNext$iv);
                    Segment segment = next$iv.prev;
                    Intrinsics.checkNotNull(segment);
                    segment.pop();
                }
            }
            setSegment$okio(next$iv);
            this.offset = offset;
            Intrinsics.checkNotNull(next$iv);
            this.data = next$iv.data;
            this.start = next$iv.pos + ((int) (offset - nextOffset$iv));
            this.end = next$iv.limit;
            return this.end - this.start;
        }

        public final long resizeBuffer(long newSize) {
            Buffer buffer$iv = this.buffer;
            if (buffer$iv == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long oldSize$iv = buffer$iv.size();
            int segmentBytesToAdd$iv = 1;
            long j = 0;
            if (newSize <= oldSize$iv) {
                if ((newSize < 0 ? 0 : 1) == 0) {
                    throw new IllegalArgumentException(("newSize < 0: " + newSize).toString());
                }
                long bytesToSubtract$iv = oldSize$iv - newSize;
                while (bytesToSubtract$iv > 0) {
                    Segment segment = buffer$iv.head;
                    Intrinsics.checkNotNull(segment);
                    Segment tail$iv = segment.prev;
                    Intrinsics.checkNotNull(tail$iv);
                    int tailSize$iv = tail$iv.limit - tail$iv.pos;
                    if (tailSize$iv <= bytesToSubtract$iv) {
                        buffer$iv.head = tail$iv.pop();
                        SegmentPool.recycle(tail$iv);
                        bytesToSubtract$iv -= (long) tailSize$iv;
                    } else {
                        tail$iv.limit -= (int) bytesToSubtract$iv;
                        break;
                    }
                }
                setSegment$okio(null);
                this.offset = newSize;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (newSize > oldSize$iv) {
                boolean needsToSeek$iv = true;
                long bytesToAdd$iv = newSize - oldSize$iv;
                while (bytesToAdd$iv > j) {
                    Segment tail$iv2 = buffer$iv.writableSegment$okio(segmentBytesToAdd$iv);
                    int b$iv$iv = 8192 - tail$iv2.limit;
                    long a$iv$iv = bytesToAdd$iv;
                    int segmentBytesToAdd$iv2 = (int) Math.min(a$iv$iv, b$iv$iv);
                    tail$iv2.limit += segmentBytesToAdd$iv2;
                    bytesToAdd$iv -= (long) segmentBytesToAdd$iv2;
                    if (!needsToSeek$iv) {
                        segmentBytesToAdd$iv = 1;
                        j = 0;
                    } else {
                        setSegment$okio(tail$iv2);
                        this.offset = oldSize$iv;
                        this.data = tail$iv2.data;
                        this.start = tail$iv2.limit - segmentBytesToAdd$iv2;
                        this.end = tail$iv2.limit;
                        needsToSeek$iv = false;
                        segmentBytesToAdd$iv = 1;
                        j = 0;
                    }
                }
            }
            buffer$iv.setSize$okio(newSize);
            return oldSize$iv;
        }

        public final long expandBuffer(int minByteCount) {
            if (!(minByteCount > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + minByteCount).toString());
            }
            if (!(minByteCount <= 8192)) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + minByteCount).toString());
            }
            Buffer buffer$iv = this.buffer;
            if (buffer$iv == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            long oldSize$iv = buffer$iv.size();
            Segment tail$iv = buffer$iv.writableSegment$okio(minByteCount);
            int result$iv = 8192 - tail$iv.limit;
            tail$iv.limit = 8192;
            buffer$iv.setSize$okio(((long) result$iv) + oldSize$iv);
            setSegment$okio(tail$iv);
            this.offset = oldSize$iv;
            this.data = tail$iv.data;
            this.start = 8192 - result$iv;
            this.end = 8192;
            return result$iv;
        }

        @Override
        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }
}
