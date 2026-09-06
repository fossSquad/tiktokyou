package ni.shikatu.okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.DeflaterSink;
import ni.shikatu.okio.Sink;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0014\u0010\u0010\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "noContextTakeover", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Z)V", "deflatedBytes", "Lni/shikatu/okio/Buffer;", "deflater", "Ljava/util/zip/Deflater;", "deflaterSink", "Lni/shikatu/okio/DeflaterSink;", "deflate", _UrlKt.FRAGMENT_ENCODE_SET, "buffer", "close", "endsWith", "suffix", "Lni/shikatu/okio/ByteString;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageDeflater implements Closeable {
    private final Buffer deflatedBytes = new Buffer();
    private final Deflater deflater = new Deflater(-1, true);
    private final DeflaterSink deflaterSink = new DeflaterSink((Sink) this.deflatedBytes, this.deflater);
    private final boolean noContextTakeover;

    public MessageDeflater(boolean noContextTakeover) {
        this.noContextTakeover = noContextTakeover;
    }

    public final void deflate(Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (!(this.deflatedBytes.size() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(buffer, buffer.size());
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            long newSize = this.deflatedBytes.size() - ((long) 4);
            Buffer.UnsafeCursor andWriteUnsafe$default = Buffer.readAndWriteUnsafe$default(this.deflatedBytes, null, 1, null);
            try {
                Buffer.UnsafeCursor cursor = andWriteUnsafe$default;
                Long.valueOf(cursor.resizeBuffer(newSize));
                CloseableKt.closeFinally(andWriteUnsafe$default, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(andWriteUnsafe$default, th);
                    throw th2;
                }
            }
        } else {
            this.deflatedBytes.writeByte(0);
        }
        buffer.write(this.deflatedBytes, this.deflatedBytes.size());
    }

    @Override
    public void close() throws Throwable {
        this.deflaterSink.close();
    }

    private final boolean endsWith(Buffer $this$endsWith, ByteString suffix) {
        return $this$endsWith.rangeEquals($this$endsWith.size() - ((long) suffix.size()), suffix);
    }
}
