package ni.shikatu.okhttp3.internal.concurrent;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\b\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a6\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"wait", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "notify", "notifyAll", "awaitNanos", "nanos", _UrlKt.FRAGMENT_ENCODE_SET, "assertLockNotHeld", "assertLockHeld", "withLock", "T", "action", "Lni/shikatu/kotlin/Function0;", "(Lokhttp3/internal/concurrent/Lockable;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LockableKt {
    public static final void wait(Lockable $this$wait) throws InterruptedException {
        Intrinsics.checkNotNullParameter($this$wait, "<this>");
        $this$wait.wait();
    }

    public static final void notify(Lockable $this$notify) {
        Intrinsics.checkNotNullParameter($this$notify, "<this>");
        $this$notify.notify();
    }

    public static final void notifyAll(Lockable $this$notifyAll) {
        Intrinsics.checkNotNullParameter($this$notifyAll, "<this>");
        $this$notifyAll.notifyAll();
    }

    public static final void awaitNanos(Lockable $this$awaitNanos, long nanos) throws InterruptedException {
        Intrinsics.checkNotNullParameter($this$awaitNanos, "<this>");
        long ms = nanos / 1000000;
        long ns = nanos - (1000000 * ms);
        if (ms > 0 || nanos > 0) {
            $this$awaitNanos.wait(ms, (int) ns);
        }
    }

    public static final void assertLockNotHeld(Lockable $this$assertLockNotHeld) {
        Intrinsics.checkNotNullParameter($this$assertLockNotHeld, "<this>");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock($this$assertLockNotHeld)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld);
        }
    }

    public static final void assertLockHeld(Lockable $this$assertLockHeld) {
        Intrinsics.checkNotNullParameter($this$assertLockHeld, "<this>");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock($this$assertLockHeld)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld);
        }
    }

    public static final <T> T withLock(Lockable $this$withLock, Function0<? extends T> function0) {
        T tInvoke;
        Intrinsics.checkNotNullParameter($this$withLock, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        synchronized ($this$withLock) {
            try {
                tInvoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            }
        }
        return tInvoke;
    }
}
