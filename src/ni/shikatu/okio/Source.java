package ni.shikatu.okio;

import java.io.Closeable;
import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lni/shikatu/okio/Source;", "Ljava/io/Closeable;", "Lni/shikatu/okio/Closeable;", "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "timeout", "Lni/shikatu/okio/Timeout;", "close", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Source extends Closeable {
    @Override
    void close() throws IOException;

    long read(Buffer buffer, long j) throws IOException;

    Timeout timeout();
}
