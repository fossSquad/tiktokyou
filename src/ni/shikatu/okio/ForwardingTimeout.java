package ni.shikatu.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0001H\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u001c\u0010\u0002\u001a\u00020\u00018\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u001a"}, d2 = {"Lni/shikatu/okio/ForwardingTimeout;", "Lni/shikatu/okio/Timeout;", "delegate", "<init>", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "timeout", _UrlKt.FRAGMENT_ENCODE_SET, "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "hasDeadline", _UrlKt.FRAGMENT_ENCODE_SET, "deadlineNanoTime", "clearTimeout", "clearDeadline", "throwIfReached", _UrlKt.FRAGMENT_ENCODE_SET, "cancel", "awaitSignal", "condition", "Ljava/util/concurrent/locks/Condition;", "waitUntilNotified", "monitor", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ForwardingTimeout extends Timeout {
    private Timeout delegate;

    public ForwardingTimeout(Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final Timeout delegate() {
        return this.delegate;
    }

    public final  void m1768setDelegate(Timeout timeout) {
        Intrinsics.checkNotNullParameter(timeout, "<set-?>");
        this.delegate = timeout;
    }

    public final ForwardingTimeout setDelegate(Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }

    @Override
    public Timeout timeout(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.delegate.timeout(timeout, unit);
    }

    @Override
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    @Override
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @Override
    public Timeout deadlineNanoTime(long deadlineNanoTime) {
        return this.delegate.deadlineNanoTime(deadlineNanoTime);
    }

    @Override
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override
    public void cancel() {
        this.delegate.cancel();
    }

    @Override
    public void awaitSignal(Condition condition) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(condition, "condition");
        this.delegate.awaitSignal(condition);
    }

    @Override
    public void waitUntilNotified(Object monitor) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        this.delegate.waitUntilNotified(monitor);
    }
}
