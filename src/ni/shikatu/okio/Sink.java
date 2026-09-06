package ni.shikatu.okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lni/shikatu/okio/Sink;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "flush", "timeout", "Lni/shikatu/okio/Timeout;", "close", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Sink extends Closeable, Flushable {
    @Override
    void close() throws IOException;

    void flush() throws IOException;

    Timeout timeout();

    void write(Buffer buffer, long j) throws IOException;
}
