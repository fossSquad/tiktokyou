package ni.shikatu.okhttp3.internal.connection;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/ExchangeFinder;", _UrlKt.FRAGMENT_ENCODE_SET, "routePlanner", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner;", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "find", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ExchangeFinder {
    RealConnection find();

    RoutePlanner getRoutePlanner();
}
