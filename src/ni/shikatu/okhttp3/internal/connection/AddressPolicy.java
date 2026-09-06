package ni.shikatu.okhttp3.internal.connection;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/AddressPolicy;", _UrlKt.FRAGMENT_ENCODE_SET, "minimumConcurrentCalls", _UrlKt.FRAGMENT_ENCODE_SET, "backoffDelayMillis", _UrlKt.FRAGMENT_ENCODE_SET, "backoffJitterMillis", "<init>", "(IJI)V", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AddressPolicy {
    public final long backoffDelayMillis;
    public final int backoffJitterMillis;
    public final int minimumConcurrentCalls;

    public AddressPolicy() {
        this(0, 0L, 0, 7, null);
    }

    public AddressPolicy(int minimumConcurrentCalls, long backoffDelayMillis, int backoffJitterMillis) {
        this.minimumConcurrentCalls = minimumConcurrentCalls;
        this.backoffDelayMillis = backoffDelayMillis;
        this.backoffJitterMillis = backoffJitterMillis;
    }

    public  AddressPolicy(int i, long j, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 60000L : j, (i3 & 4) != 0 ? 100 : i2);
    }
}
