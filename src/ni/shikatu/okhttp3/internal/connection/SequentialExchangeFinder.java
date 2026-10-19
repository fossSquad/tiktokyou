package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/SequentialExchangeFinder;", "Lni/shikatu/okhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner;", "<init>", "(Lokhttp3/internal/connection/RoutePlanner;)V", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "find", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SequentialExchangeFinder implements ExchangeFinder {
    private final RoutePlanner routePlanner;

    public SequentialExchangeFinder(RoutePlanner routePlanner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        this.routePlanner = routePlanner;
    }

    @Override
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    @Override
    public RealConnection find() throws Throwable {
        IOException firstException = null;
        while (!getRoutePlanner().isCanceled()) {
            try {
                RoutePlanner.Plan plan = getRoutePlanner().plan();
                if (!plan.isReady()) {
                    RoutePlanner.ConnectResult tcpConnectResult = plan.mo1744connectTcp();
                    RoutePlanner.ConnectResult connectResult = tcpConnectResult.isSuccess() ? plan.mo1745connectTlsEtc() : tcpConnectResult;
                    RoutePlanner.Plan nextPlan = connectResult.component2();
                    Throwable failure = connectResult.component3();
                    if (failure != null) {
                        throw failure;
                    }
                    if (nextPlan != null) {
                        getRoutePlanner().getDeferredPlans().addFirst(nextPlan);
                    }
                }
                return plan.mo1741handleSuccess();
            } catch (IOException e) {
                if (firstException == null) {
                    firstException = e;
                } else {
                    ExceptionsKt.addSuppressed(firstException, e);
                }
                if (!RoutePlanner.hasNext$default(getRoutePlanner(), null, 1, null)) {
                    throw firstException;
                }
            }
        }
        throw new IOException("Canceled");
    }
}
