package ni.shikatu.okio;

import java.io.IOException;
import java.util.zip.Deflater;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.internal._ZlibJvmKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0016J\r\u0010\u0014\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lni/shikatu/okio/DeflaterSink;", "Lni/shikatu/okio/Sink;", "sink", "Lni/shikatu/okio/BufferedSink;", "deflater", "Ljava/util/zip/Deflater;", "<init>", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "deflate", "syncFlush", "flush", "finishDeflate", "finishDeflate$okio", "close", "timeout", "Lni/shikatu/okio/Timeout;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
    }

    @Override
    public void write(Buffer source, long remaining) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, remaining);
        while (remaining > 0) {
            Segment head = source.head;
            Intrinsics.checkNotNull(head);
            long a$iv = remaining;
            int b$iv = (int) Math.min(a$iv, head.limit - head.pos);
            this.deflater.setInput(head.data, head.pos, b$iv);
            deflate(false);
            source.setSize$okio(source.size() - ((long) b$iv));
            head.pos += b$iv;
            if (head.pos == head.limit) {
                source.head = head.pop();
                SegmentPool.recycle(head);
            }
            remaining -= (long) b$iv;
        }
        this.deflater.setInput(_ZlibJvmKt.getEMPTY_BYTE_ARRAY(), 0, 0);
    }

    private final void deflate(boolean syncFlush) throws IOException {
        Segment s;
        int deflated;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            s = buffer.writableSegment$okio(1);
            if (syncFlush) {
                try {
                    deflated = this.deflater.deflate(s.data, s.limit, 8192 - s.limit, 2);
                } catch (NullPointerException npe) {
                    throw new IOException("Deflater already closed", npe);
                }
            } else {
                deflated = this.deflater.deflate(s.data, s.limit, 8192 - s.limit);
            }
            if (deflated > 0) {
                s.limit += deflated;
                buffer.setSize$okio(buffer.size() + ((long) deflated));
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (s.pos == s.limit) {
            buffer.head = s.pop();
            SegmentPool.recycle(s);
        }
    }

    @Override
    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    public final void finishDeflate$okio() throws IOException {
        this.deflater.finish();
        deflate(false);
    }

    @Override
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        Throwable thrown = null;
        try {
            finishDeflate$okio();
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

    @Override
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }
}
