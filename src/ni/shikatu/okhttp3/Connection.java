package ni.shikatu.okhttp3;

import java.net.Socket;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/Connection;", _UrlKt.FRAGMENT_ENCODE_SET, "route", "Lni/shikatu/okhttp3/Route;", "socket", "Ljava/net/Socket;", "handshake", "Lni/shikatu/okhttp3/Handshake;", "protocol", "Lni/shikatu/okhttp3/Protocol;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
