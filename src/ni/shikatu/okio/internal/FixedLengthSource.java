package ni.shikatu.okio.internal;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.ForwardingSource;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/okio/internal/FixedLengthSource;", "Lni/shikatu/okio/ForwardingSource;", "delegate", "Lni/shikatu/okio/Source;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "truncate", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokio/Source;JZ)V", "bytesReceived", "read", "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "truncateToSize", _UrlKt.FRAGMENT_ENCODE_SET, "newSize", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    public FixedLengthSource(Source delegate, long size, boolean truncate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.size = size;
        this.truncate = truncate;
    }

    @Override
    public long read(Buffer sink, long byteCount) throws IOException {
        long toRead;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.bytesReceived > this.size) {
            toRead = 0;
        } else if (this.truncate) {
            long remaining = this.size - this.bytesReceived;
            if (remaining == 0) {
                return -1L;
            }
            toRead = Math.min(byteCount, remaining);
        } else {
            toRead = byteCount;
        }
        long result = super.read(sink, toRead);
        if (result != -1) {
            this.bytesReceived += result;
        }
        if ((this.bytesReceived < this.size && result == -1) || this.bytesReceived > this.size) {
            if (result > 0 && this.bytesReceived > this.size) {
                truncateToSize(sink, sink.size() - (this.bytesReceived - this.size));
            }
            throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
        }
        return result;
    }

    private final void truncateToSize(Buffer $this$truncateToSize, long newSize) throws IOException {
        Buffer scratch = new Buffer();
        scratch.writeAll($this$truncateToSize);
        $this$truncateToSize.write(scratch, newSize);
        scratch.clear();
    }
}
