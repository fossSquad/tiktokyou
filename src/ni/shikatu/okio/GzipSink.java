package ni.shikatu.okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.internal._ZlibJvmKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0013\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0004\b \u0010\tR\u000e\u0010\u0002\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\u00060\u0007j\u0002`\b8\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006!"}, d2 = {"Lni/shikatu/okio/GzipSink;", "Lni/shikatu/okio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "Lni/shikatu/okio/RealBufferedSink;", "deflater", "Ljava/util/zip/Deflater;", "Lni/shikatu/okio/Deflater;", "()Ljava/util/zip/Deflater;", "Ljava/util/zip/Deflater;", "deflaterSink", "Lni/shikatu/okio/DeflaterSink;", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "crc", "Ljava/util/zip/CRC32;", "Lni/shikatu/okio/internal/CRC32;", "Ljava/util/zip/CRC32;", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "flush", "timeout", "Lni/shikatu/okio/Timeout;", "close", "writeFooter", "updateCrc", "buffer", "-deprecated_deflater", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = new RealBufferedSink(sink);
        this.deflater = new Deflater(_ZlibJvmKt.getDEFAULT_COMPRESSION(), true);
        this.deflaterSink = new DeflaterSink((BufferedSink) this.sink, this.deflater);
        this.crc = new CRC32();
        RealBufferedSink this_$iv = this.sink;
        Buffer $this$_init__u24lambda_u240 = this_$iv.bufferField;
        $this$_init__u24lambda_u240.writeShort(8075);
        $this$_init__u24lambda_u240.writeByte(8);
        $this$_init__u24lambda_u240.writeByte(0);
        $this$_init__u24lambda_u240.writeInt(0);
        $this$_init__u24lambda_u240.writeByte(0);
        $this$_init__u24lambda_u240.writeByte(0);
    }

    public final Deflater deflater() {
        return this.deflater;
    }

    @Override
    public void write(Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (byteCount == 0) {
            return;
        }
        updateCrc(source, byteCount);
        this.deflaterSink.write(source, byteCount);
    }

    @Override
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        Throwable thrown = null;
        try {
            this.deflaterSink.finishDeflate$okio();
            writeFooter();
        } catch (Throwable e) {
            thrown = e;
        }
        try {
            this.deflater.end();
        } catch (Throwable e2) {
            if (thrown == null) {
                thrown = e2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable e3) {
            if (thrown == null) {
                thrown = e3;
            }
        }
        this.closed = true;
        if (thrown != null) {
            throw thrown;
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private final void updateCrc(Buffer buffer, long byteCount) {
        Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        long remaining = byteCount;
        while (remaining > 0) {
            long a$iv = remaining;
            int b$iv = (int) Math.min(a$iv, head.limit - head.pos);
            this.crc.update(head.data, head.pos, b$iv);
            remaining -= (long) b$iv;
            Segment segment = head.next;
            Intrinsics.checkNotNull(segment);
            head = segment;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", imports = {}))

    public final Deflater m1769deprecated_deflater() {
        return this.deflater;
    }
}
