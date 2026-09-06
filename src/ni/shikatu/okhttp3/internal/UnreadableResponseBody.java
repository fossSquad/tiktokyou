package ni.shikatu.okhttp3.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.MediaType;
import ni.shikatu.okhttp3.ResponseBody;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lni/shikatu/okhttp3/internal/UnreadableResponseBody;", "Lni/shikatu/okhttp3/ResponseBody;", "Lni/shikatu/okio/Source;", "mediaType", "Lni/shikatu/okhttp3/MediaType;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/MediaType;J)V", "contentType", "source", "Lni/shikatu/okio/BufferedSource;", "read", "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "timeout", "Lni/shikatu/okio/Timeout;", "close", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UnreadableResponseBody extends ResponseBody implements Source {
    private final long contentLength;
    private final MediaType mediaType;

    public UnreadableResponseBody(MediaType mediaType, long contentLength) {
        this.mediaType = mediaType;
        this.contentLength = contentLength;
    }

    @Override
    public MediaType contentType() {
        return this.mediaType;
    }

    @Override
    public long contentLength() {
        return this.contentLength;
    }

    @Override
    public BufferedSource source() {
        return Okio.buffer(this);
    }

    @Override
    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override
    public void close() {
    }
}
