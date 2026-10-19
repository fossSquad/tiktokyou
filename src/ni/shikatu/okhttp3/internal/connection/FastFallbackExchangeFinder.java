package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.concurrent.Task;
import ni.shikatu.okhttp3.internal.concurrent.TaskQueue;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/FastFallbackExchangeFinder;", "Lni/shikatu/okhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner;", "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "<init>", "(Lokhttp3/internal/connection/RoutePlanner;Lokhttp3/internal/concurrent/TaskRunner;)V", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "connectDelayNanos", _UrlKt.FRAGMENT_ENCODE_SET, "nextTcpConnectAtNanos", "tcpConnectsInFlight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$Plan;", "connectResults", "Ljava/util/concurrent/BlockingQueue;", "Lni/shikatu/okhttp3/internal/connection/RoutePlanner$ConnectResult;", "ni.shikatu.kotlin.jvm.PlatformType", "find", "Lni/shikatu/okhttp3/internal/connection/RealConnection;", "launchTcpConnect", "awaitTcpConnect", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "cancelInFlightConnects", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    private final long connectDelayNanos;
    private final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    private long nextTcpConnectAtNanos;
    private final RoutePlanner routePlanner;
    private final TaskRunner taskRunner;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight;

    public FastFallbackExchangeFinder(RoutePlanner routePlanner, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.routePlanner = routePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.connectResults = this.taskRunner.getBackend().decorate(new LinkedBlockingDeque());
    }

    @Override
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    @Override
    public RealConnection find() throws IOException {
        IOException firstException = null;
        while (true) {
            try {
                if (!this.tcpConnectsInFlight.isEmpty() || RoutePlanner.hasNext$default(getRoutePlanner(), null, 1, null)) {
                    if (getRoutePlanner().isCanceled()) {
                        throw new IOException("Canceled");
                    }
                    long now = this.taskRunner.getBackend().nanoTime();
                    long awaitTimeoutNanos = this.nextTcpConnectAtNanos - now;
                    RoutePlanner.ConnectResult connectResult = null;
                    if (this.tcpConnectsInFlight.isEmpty() || awaitTimeoutNanos <= 0) {
                        connectResult = launchTcpConnect();
                        this.nextTcpConnectAtNanos = this.connectDelayNanos + now;
                        awaitTimeoutNanos = this.connectDelayNanos;
                    }
                    if (connectResult == null) {
                        RoutePlanner.ConnectResult connectResultAwaitTcpConnect = awaitTcpConnect(awaitTimeoutNanos, TimeUnit.NANOSECONDS);
                        if (connectResultAwaitTcpConnect != null) {
                            connectResult = connectResultAwaitTcpConnect;
                        }
                    }
                    if (connectResult.isSuccess()) {
                        cancelInFlightConnects();
                        if (!connectResult.getPlan().isReady()) {
                            connectResult = connectResult.getPlan().mo1745connectTlsEtc();
                        }
                        if (connectResult.isSuccess()) {
                            RealConnection realConnectionMo1741handleSuccess = connectResult.getPlan().mo1741handleSuccess();
                            cancelInFlightConnects();
                            return realConnectionMo1741handleSuccess;
                        }
                    }
                    Throwable throwable = connectResult.getThrowable();
                    if (throwable != null) {
                        if (!(throwable instanceof IOException)) {
                            throw throwable;
                        }
                        if (firstException == null) {
                            firstException = (IOException) throwable;
                        } else {
                            ExceptionsKt.addSuppressed(firstException, throwable);
                        }
                    }
                    RoutePlanner.Plan nextPlan = connectResult.getNextPlan();
                    if (nextPlan != null) {
                        getRoutePlanner().getDeferredPlans().addFirst(nextPlan);
                    }
                } else {
                    cancelInFlightConnects();
                    Intrinsics.checkNotNull(firstException);
                    throw firstException;
                }
            } catch (Throwable th) {
                cancelInFlightConnects();
                throw th;
            }
        }
    }

    private final RoutePlanner.ConnectResult launchTcpConnect() {
        RoutePlanner.Plan failedPlan;
        if (!RoutePlanner.hasNext$default(getRoutePlanner(), null, 1, null)) {
            return null;
        }
        try {
            failedPlan = getRoutePlanner().plan();
        } catch (Throwable e) {
            failedPlan = new FailedPlan(e);
        }
        final RoutePlanner.Plan plan = failedPlan;
        if (plan.isReady()) {
            return new RoutePlanner.ConnectResult(plan, null, null, 6, null);
        }
        if (plan instanceof FailedPlan) {
            return ((FailedPlan) plan).getResult();
        }
        this.tcpConnectsInFlight.add(plan);
        String taskName = _UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact();
        TaskQueue.schedule$default(this.taskRunner.newQueue(), new Task(taskName) {
            @Override
            public long runOnce() throws InterruptedException {
                RoutePlanner.ConnectResult connectResult;
                try {
                    connectResult = plan.mo1744connectTcp();
                } catch (Throwable e2) {
                    connectResult = new RoutePlanner.ConnectResult(plan, null, e2, 2, null);
                }
                if (this.tcpConnectsInFlight.contains(plan)) {
                    this.connectResults.put(connectResult);
                    return -1L;
                }
                return -1L;
            }
        }, 0L, 2, null);
        return null;
    }

    private final RoutePlanner.ConnectResult awaitTcpConnect(long timeout, TimeUnit unit) {
        RoutePlanner.ConnectResult result;
        if (this.tcpConnectsInFlight.isEmpty() || (result = this.connectResults.poll(timeout, unit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(result.getPlan());
        return result;
    }

    private final void cancelInFlightConnects() {
        Iterator<RoutePlanner.Plan> it = this.tcpConnectsInFlight.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RoutePlanner.Plan plan = it.next();
            plan.mo1740cancel();
            RoutePlanner.Plan retry = plan.mo1742retry();
            if (retry != null) {
                getRoutePlanner().getDeferredPlans().addLast(retry);
            }
        }
        this.tcpConnectsInFlight.clear();
    }
}
