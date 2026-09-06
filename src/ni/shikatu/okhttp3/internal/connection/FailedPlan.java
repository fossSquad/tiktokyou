package ni.shikatu.okhttp3.internal.connection;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\f¨\u0006\u0013"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/FailedPlan;", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$Plan;", "e", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/Throwable;)V", "result", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$ConnectResult;", "getResult", "()Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "isReady", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "connectTcp", "connectTlsEtc", "handleSuccess", _UrlKt.FRAGMENT_ENCODE_SET, "cancel", "retry", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FailedPlan implements RoutePlanner.Plan {
    private final boolean isReady;
    private final RoutePlanner.ConnectResult result;

    public FailedPlan(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.result = new RoutePlanner.ConnectResult(this, null, e, 2, null);
    }

    @Override

    public /* bridge */  RealConnection mo1741handleSuccess() {
        return (RealConnection) handleSuccess();
    }

    @Override

    public /* bridge */  RoutePlanner.Plan mo1742retry() {
        return (RoutePlanner.Plan) retry();
    }

    public final RoutePlanner.ConnectResult getResult() {
        return this.result;
    }

    @Override
    public boolean isReady() {
        return this.isReady;
    }

    @Override

    public RoutePlanner.ConnectResult mo1744connectTcp() {
        return this.result;
    }

    @Override

    public RoutePlanner.ConnectResult mo1745connectTlsEtc() {
        return this.result;
    }

    public Void handleSuccess() {
        throw new IllegalStateException("unexpected call".toString());
    }

    @Override

    public Void mo1740cancel() {
        throw new IllegalStateException("unexpected cancel".toString());
    }

    public Void retry() {
        throw new IllegalStateException("unexpected retry".toString());
    }
}
