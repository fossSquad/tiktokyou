package ni.shikatu.okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.okhttp3.internal.http2.Settings;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.InflaterSource;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "noContextTakeover", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Z)V", "deflatedBytes", "Lni/shikatu/okio/Buffer;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lni/shikatu/okio/InflaterSource;", "inflate", _UrlKt.FRAGMENT_ENCODE_SET, "buffer", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageInflater implements Closeable {
    private final Buffer deflatedBytes = new Buffer();
    private Inflater inflater;
    private InflaterSource inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean noContextTakeover) {
        this.noContextTakeover = noContextTakeover;
    }

    public final void inflate(Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (!(this.deflatedBytes.size() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Inflater it = this.inflater;
        if (it == null) {
            it = new Inflater(true);
            this.inflater = it;
        }
        InflaterSource it2 = this.inflaterSource;
        if (it2 == null) {
            it2 = new InflaterSource((Source) this.deflatedBytes, it);
            this.inflaterSource = it2;
        }
        if (this.noContextTakeover) {
            it.reset();
        }
        this.deflatedBytes.writeAll(buffer);
        this.deflatedBytes.writeInt(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        long totalBytesToRead = it.getBytesRead() + this.deflatedBytes.size();
        do {
            it2.readOrInflate(buffer, LongCompanionObject.MAX_VALUE);
            if (it.getBytesRead() >= totalBytesToRead) {
                break;
            }
        } while (!it.finished());
        if (it.getBytesRead() < totalBytesToRead) {
            this.deflatedBytes.clear();
            it2.close();
            this.inflaterSource = null;
            this.inflater = null;
        }
    }

    @Override
    public void close() throws IOException {
        InflaterSource inflaterSource = this.inflaterSource;
        if (inflaterSource != null) {
            inflaterSource.close();
        }
        this.inflaterSource = null;
        this.inflater = null;
    }
}
