package ni.shikatu.okhttp3.internal.http;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.MediaType;
import ni.shikatu.okhttp3.RequestBody;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.GzipSink;
import ni.shikatu.okio.Okio;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lni/shikatu/okhttp3/internal/http/GzipRequestBody;", "Lni/shikatu/okhttp3/RequestBody;", "delegate", "<init>", "(Lokhttp3/RequestBody;)V", "getDelegate", "()Lokhttp3/RequestBody;", "contentType", "Lni/shikatu/okhttp3/MediaType;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "writeTo", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/BufferedSink;", "isOneShot", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GzipRequestBody extends RequestBody {
    private final RequestBody delegate;

    public GzipRequestBody(RequestBody delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final RequestBody getDelegate() {
        return this.delegate;
    }

    @Override
    public MediaType contentType() {
        return this.delegate.contentType();
    }

    @Override
    public long contentLength() {
        return -1L;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(sink));
        try {
            BufferedSink p0 = bufferedSinkBuffer;
            this.delegate.writeTo(p0);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedSinkBuffer, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedSinkBuffer, th);
                throw th2;
            }
        }
    }

    @Override
    public boolean isOneShot() {
        return this.delegate.isOneShot();
    }
}
