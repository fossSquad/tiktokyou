package ni.shikatu.okio.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Pipe;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Socket;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lni/shikatu/okio/internal/PipeSocket;", "Lni/shikatu/okio/Socket;", "sinkPipe", "Lni/shikatu/okio/Pipe;", "sourcePipe", "<init>", "(Lokio/Pipe;Lokio/Pipe;)V", "getSinkPipe", "()Lokio/Pipe;", "getSourcePipe", "source", "Lni/shikatu/okio/Source;", "getSource", "()Lokio/Source;", "sink", "Lni/shikatu/okio/Sink;", "getSink", "()Lokio/Sink;", "cancel", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PipeSocket implements Socket {
    private final Pipe sinkPipe;
    private final Pipe sourcePipe;

    public PipeSocket(Pipe sinkPipe, Pipe sourcePipe) {
        Intrinsics.checkNotNullParameter(sinkPipe, "sinkPipe");
        Intrinsics.checkNotNullParameter(sourcePipe, "sourcePipe");
        this.sinkPipe = sinkPipe;
        this.sourcePipe = sourcePipe;
    }

    public final Pipe getSinkPipe() {
        return this.sinkPipe;
    }

    public final Pipe getSourcePipe() {
        return this.sourcePipe;
    }

    @Override
    public Source getSource() {
        return this.sourcePipe.source();
    }

    @Override
    public Sink getSink() {
        return this.sinkPipe.sink();
    }

    @Override
    public void cancel() {
        this.sourcePipe.cancel();
        this.sinkPipe.cancel();
    }
}
