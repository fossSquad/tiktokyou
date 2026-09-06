package ni.shikatu.okio;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lni/shikatu/okio/Socket;", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Source;", "getSource", "()Lokio/Source;", "sink", "Lni/shikatu/okio/Sink;", "getSink", "()Lokio/Sink;", "cancel", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Socket {
    void cancel();

    Sink getSink();

    Source getSource();
}
