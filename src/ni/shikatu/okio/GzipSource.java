package ni.shikatu.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J \u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J \u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006&"}, d2 = {"Lni/shikatu/okio/GzipSource;", "Lni/shikatu/okio/Source;", "source", "<init>", "(Lokio/Source;)V", "section", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/RealBufferedSource;", "inflater", "Ljava/util/zip/Inflater;", "Lni/shikatu/okio/Inflater;", "Ljava/util/zip/Inflater;", "inflaterSource", "Lni/shikatu/okio/InflaterSource;", "crc", "Ljava/util/zip/CRC32;", "Lni/shikatu/okio/internal/CRC32;", "Ljava/util/zip/CRC32;", "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "consumeHeader", _UrlKt.FRAGMENT_ENCODE_SET, "consumeTrailer", "timeout", "Lni/shikatu/okio/Timeout;", "close", "updateCrc", "buffer", "offset", "checkEqual", "name", _UrlKt.FRAGMENT_ENCODE_SET, "expected", _UrlKt.FRAGMENT_ENCODE_SET, "actual", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = new RealBufferedSource(source);
        this.inflater = new Inflater(true);
        this.inflaterSource = new InflaterSource((BufferedSource) this.source, this.inflater);
        this.crc = new CRC32();
    }

    @Override
    public long read(Buffer sink, long byteCount) throws IOException {
        GzipSource gzipSource;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = (byte) 1;
        }
        if (this.section != 1) {
            gzipSource = this;
        } else {
            long offset = sink.size();
            long result = this.inflaterSource.read(sink, byteCount);
            if (result != -1) {
                updateCrc(sink, offset, result);
                return result;
            }
            gzipSource = this;
            gzipSource.section = (byte) 2;
        }
        if (gzipSource.section == 2) {
            consumeTrailer();
            gzipSource.section = (byte) 3;
            if (!gzipSource.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10L);
        RealBufferedSource this_$iv = this.source;
        int flags = this_$iv.bufferField.getByte(3L);
        int bit$iv = ((flags >> 1) & 1) == 1 ? 1 : 0;
        int i = bit$iv;
        if (i != 0) {
            RealBufferedSource this_$iv2 = this.source;
            updateCrc(this_$iv2.bufferField, 0L, 10L);
        }
        short id1id2 = this.source.readShort();
        checkEqual("ID1ID2", 8075, id1id2);
        this.source.skip(8L);
        int bit$iv2 = ((flags >> 2) & 1) == 1 ? 1 : 0;
        if (bit$iv2 != 0) {
            this.source.require(2L);
            if (i != 0) {
                RealBufferedSource this_$iv3 = this.source;
                updateCrc(this_$iv3.bufferField, 0L, 2L);
            }
            RealBufferedSource this_$iv4 = this.source;
            long xlen = this_$iv4.bufferField.readShortLe() & UShort.MAX_VALUE;
            this.source.require(xlen);
            if (i != 0) {
                RealBufferedSource this_$iv5 = this.source;
                updateCrc(this_$iv5.bufferField, 0L, xlen);
            }
            this.source.skip(xlen);
        }
        int bit$iv3 = ((flags >> 3) & 1) == 1 ? 1 : 0;
        if (bit$iv3 != 0) {
            long index = this.source.indexOf((byte) 0);
            if (index == -1) {
                throw new EOFException();
            }
            if (i != 0) {
                RealBufferedSource this_$iv6 = this.source;
                updateCrc(this_$iv6.bufferField, 0L, index + 1);
            }
            this.source.skip(index + 1);
        }
        if (((flags >> 4) & 1) == 1) {
            long index2 = this.source.indexOf((byte) 0);
            if (index2 == -1) {
                throw new EOFException();
            }
            if (i != 0) {
                RealBufferedSource this_$iv7 = this.source;
                updateCrc(this_$iv7.bufferField, 0L, index2 + 1);
            }
            this.source.skip(1 + index2);
        }
        if (i != 0) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    private final void updateCrc(Buffer buffer, long offset, long byteCount) {
        long offset2 = offset;
        long byteCount2 = byteCount;
        Segment s = buffer.head;
        Intrinsics.checkNotNull(s);
        while (offset2 >= s.limit - s.pos) {
            offset2 -= (long) (s.limit - s.pos);
            Segment segment = s.next;
            Intrinsics.checkNotNull(segment);
            s = segment;
        }
        while (byteCount2 > 0) {
            int pos = (int) (((long) s.pos) + offset2);
            long b$iv = byteCount2;
            int a$iv = (int) Math.min(s.limit - pos, b$iv);
            this.crc.update(s.data, pos, a$iv);
            byteCount2 -= (long) a$iv;
            offset2 = 0;
            Segment segment2 = s.next;
            Intrinsics.checkNotNull(segment2);
            s = segment2;
        }
    }

    private final void checkEqual(String name, int expected, int actual) throws IOException {
        if (actual != expected) {
            throw new IOException(name + ": actual 0x" + StringsKt.padStart(SegmentedByteString.toHexString(actual), 8, '0') + " != expected 0x" + StringsKt.padStart(SegmentedByteString.toHexString(expected), 8, '0'));
        }
    }
}
