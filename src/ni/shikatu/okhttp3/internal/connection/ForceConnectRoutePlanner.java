package ni.shikatu.okhttp3.internal.connection;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArrayDeque;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Address;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\tH\u0096\u0001J\u0011\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/ForceConnectRoutePlanner;", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner;", "delegate", "Lni/shikatu/okhttp3/internal/connection/RealRoutePlanner;", "<init>", "(Lokhttp3/internal/connection/RealRoutePlanner;)V", "plan", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$Plan;", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "failedConnection", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "isCanceled", "sameHostAndPort", "url", "Lni/shikatu/okhttp3/HttpUrl;", "address", "Lni/shikatu/okhttp3/Address;", "getAddress", "()Lokhttp3/Address;", "deferredPlans", "Lni/shikatu/kotlin/collections/ArrayDeque;", "getDeferredPlans", "()Lkotlin/collections/ArrayDeque;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceConnectRoutePlanner implements RoutePlanner {
    private final RealRoutePlanner delegate;

    @Override
    public Address getAddress() {
        return this.delegate.getAddress();
    }

    @Override
    public ArrayDeque<RoutePlanner.Plan> getDeferredPlans() {
        return this.delegate.getDeferredPlans();
    }

    @Override
    public boolean hasNext(RealConnection realConnection) {
        return this.delegate.hasNext(realConnection);
    }

    @Override
    public boolean isCanceled() {
        return this.delegate.isCanceled();
    }

    @Override
    public boolean sameHostAndPort(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        return this.delegate.sameHostAndPort(httpUrl);
    }

    public ForceConnectRoutePlanner(RealRoutePlanner delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override
    public RoutePlanner.Plan plan() {
        return this.delegate.planConnect$okhttp();
    }
}
