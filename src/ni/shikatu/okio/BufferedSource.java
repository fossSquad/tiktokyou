package ni.shikatu.okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\fH&J\b\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\fH&J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH&J'\u0010\u001d\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020!2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\"H&¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H&J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%H&J\u0010\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020%H&J \u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014H&J\u0018\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010*\u001a\u00020\f2\u0006\u0010'\u001a\u00020+H&J\b\u0010,\u001a\u00020-H&J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\fH&J\n\u0010.\u001a\u0004\u0018\u00010-H&J\b\u0010/\u001a\u00020-H&J\u0010\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\fH&J\b\u00101\u001a\u00020\u0014H&J\u0010\u00102\u001a\u00020-2\u0006\u00103\u001a\u000204H&J\u0018\u00102\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u000204H&J\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000fH&J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\fH&J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH&J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001cH&J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\fH&J \u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH&J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001cH&J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\fH&J\u0018\u0010<\u001a\u00020\b2\u0006\u0010)\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001cH&J(\u0010<\u001a\u00020\b2\u0006\u0010)\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014H&J\b\u0010>\u001a\u00020\u0000H&J\b\u0010?\u001a\u00020@H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0004Aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006BÀ\u0006\u0001"}, d2 = {"Lni/shikatu/okio/BufferedSource;", "Lni/shikatu/okio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "buffer", "Lni/shikatu/okio/Buffer;", "getBuffer", "()Lokio/Buffer;", "exhausted", _UrlKt.FRAGMENT_ENCODE_SET, "require", _UrlKt.FRAGMENT_ENCODE_SET, "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "request", "readByte", _UrlKt.FRAGMENT_ENCODE_SET, "readShort", _UrlKt.FRAGMENT_ENCODE_SET, "readShortLe", "readInt", _UrlKt.FRAGMENT_ENCODE_SET, "readIntLe", "readLong", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "readByteString", "Lni/shikatu/okio/ByteString;", "select", "options", "Lni/shikatu/okio/Options;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readByteArray", _UrlKt.FRAGMENT_ENCODE_SET, "read", "sink", "readFully", "offset", "readAll", "Lni/shikatu/okio/Sink;", "readUtf8", _UrlKt.FRAGMENT_ENCODE_SET, "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readString", "charset", "Ljava/nio/charset/Charset;", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "peek", "inputStream", "Ljava/io/InputStream;", "Lni/shikatu/okio/RealBufferedSource;", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BufferedSource extends Source, ReadableByteChannel {
    @Deprecated(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", imports = {}))
    Buffer buffer();

    boolean exhausted() throws IOException;

    Buffer getBuffer();

    long indexOf(byte b) throws IOException;

    long indexOf(byte b, long j) throws IOException;

    long indexOf(byte b, long j, long j2) throws IOException;

    long indexOf(ByteString byteString) throws IOException;

    long indexOf(ByteString byteString, long j) throws IOException;

    long indexOf(ByteString byteString, long j, long j2) throws IOException;

    long indexOfElement(ByteString byteString) throws IOException;

    long indexOfElement(ByteString byteString, long j) throws IOException;

    InputStream inputStream();

    BufferedSource peek();

    boolean rangeEquals(long j, ByteString byteString) throws IOException;

    boolean rangeEquals(long j, ByteString byteString, int i, int i2) throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;

    long readAll(Sink sink) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    byte[] readByteArray(long j) throws IOException;

    ByteString readByteString() throws IOException;

    ByteString readByteString(long j) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(Buffer buffer, long j) throws IOException;

    void readFully(byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    String readString(long j, Charset charset) throws IOException;

    String readString(Charset charset) throws IOException;

    String readUtf8() throws IOException;

    String readUtf8(long j) throws IOException;

    int readUtf8CodePoint() throws IOException;

    String readUtf8Line() throws IOException;

    String readUtf8LineStrict() throws IOException;

    String readUtf8LineStrict(long j) throws IOException;

    boolean request(long j) throws IOException;

    void require(long j) throws IOException;

    int select(Options options) throws IOException;

    <T> T select(TypedOptions<T> typedOptions) throws IOException;

    void skip(long j) throws IOException;
}
