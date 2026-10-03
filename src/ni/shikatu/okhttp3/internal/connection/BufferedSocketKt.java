package ni.shikatu.okhttp3.internal.connection;

import java.net.Socket;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.Okio;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"asBufferedSocket", "Lni/shikatu/okhttp3/internal/connection/BufferedSocket;", "Ljava/net/Socket;", "Lni/shikatu/okio/Socket;", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BufferedSocketKt {
    public static final BufferedSocket asBufferedSocket(Socket $this$asBufferedSocket) {
        Intrinsics.checkNotNullParameter($this$asBufferedSocket, "<this>");
        return asBufferedSocket(Okio.socket($this$asBufferedSocket));
    }

    public static final BufferedSocket asBufferedSocket(ni.shikatu.okio.Socket $this$asBufferedSocket) {
        Intrinsics.checkNotNullParameter($this$asBufferedSocket, "<this>");
        return new BufferedSocket($this$asBufferedSocket) {
            private final ni.shikatu.okio.Socket delegate;
            private final BufferedSink sink;
            private final BufferedSource source;

            {
                this.delegate = $this$asBufferedSocket;
                this.source = Okio.buffer(this.delegate.getSource());
                this.sink = Okio.buffer(this.delegate.getSink());
            }

            @Override
            public BufferedSource getSource() {
                return this.source;
            }

            @Override
            public BufferedSink getSink() {
                return this.sink;
            }

            @Override
            public void cancel() {
                this.delegate.cancel();
            }
        };
    }
}
