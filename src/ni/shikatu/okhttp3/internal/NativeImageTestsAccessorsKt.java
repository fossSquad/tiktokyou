package ni.shikatu.okhttp3.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Cache;
import ni.shikatu.okhttp3.Dispatcher;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal.connection.Exchange;
import ni.shikatu.okhttp3.internal.connection.RealCall;
import ni.shikatu.okhttp3.internal.connection.RealConnection;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.FileSystem;
import ni.shikatu.okio.Path;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\n\u0010\u001a\u001a\u00060\u001bR\u00020\u001cH\u0000\"(\u0010\t\u001a\u00020\u0005*\u00020\n2\u0006\u0010\b\u001a\u00020\u00058@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0018\u0010\u0014\u001a\u00020\n*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"buildCache", "Lni/shikatu/okhttp3/Cache;", "file", "Lni/shikatu/okio/Path;", "maxSize", _UrlKt.FRAGMENT_ENCODE_SET, "fileSystem", "Lni/shikatu/okio/FileSystem;", "value", "idleAtNsAccessor", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "getIdleAtNsAccessor", "(Lokhttp3/internal/connection/RealConnection;)J", "setIdleAtNsAccessor", "(Lokhttp3/internal/connection/RealConnection;J)V", "exchangeAccessor", "Lni/shikatu/okhttp3/internal/connection/Exchange;", "Lni/shikatu/okhttp3/Response;", "getExchangeAccessor", "(Lokhttp3/Response;)Lokhttp3/internal/connection/Exchange;", "connectionAccessor", "getConnectionAccessor", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/connection/RealConnection;", "finishedAccessor", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Dispatcher;", "call", "Lni/shikatu/okhttp3/internal/connection/RealCall$AsyncCall;", "Lni/shikatu/okhttp3/internal/connection/RealCall;", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NativeImageTestsAccessorsKt {
    public static final Cache buildCache(Path file, long maxSize, FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        return new Cache(fileSystem, file, maxSize);
    }

    public static final long getIdleAtNsAccessor(RealConnection $this$idleAtNsAccessor) {
        Intrinsics.checkNotNullParameter($this$idleAtNsAccessor, "<this>");
        return $this$idleAtNsAccessor.getIdleAtNs();
    }

    public static final void setIdleAtNsAccessor(RealConnection $this$idleAtNsAccessor, long value) {
        Intrinsics.checkNotNullParameter($this$idleAtNsAccessor, "<this>");
        $this$idleAtNsAccessor.setIdleAtNs(value);
    }

    public static final Exchange getExchangeAccessor(Response $this$exchangeAccessor) {
        Intrinsics.checkNotNullParameter($this$exchangeAccessor, "<this>");
        return $this$exchangeAccessor.exchange();
    }

    public static final RealConnection getConnectionAccessor(Exchange $this$connectionAccessor) {
        Intrinsics.checkNotNullParameter($this$connectionAccessor, "<this>");
        return $this$connectionAccessor.getConnection$okhttp();
    }

    public static final void finishedAccessor(Dispatcher $this$finishedAccessor, RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter($this$finishedAccessor, "<this>");
        Intrinsics.checkNotNullParameter(call, "call");
        $this$finishedAccessor.finished$okhttp(call);
    }
}
