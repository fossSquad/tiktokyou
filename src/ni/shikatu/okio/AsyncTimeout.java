package ni.shikatu.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\nH\u0016J\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\nH\u0014J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015J%\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0001J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"Lni/shikatu/okio/AsyncTimeout;", "Lni/shikatu/okio/Timeout;", "<init>", "()V", "state", _UrlKt.FRAGMENT_ENCODE_SET, "index", "timeoutAt", _UrlKt.FRAGMENT_ENCODE_SET, "enter", _UrlKt.FRAGMENT_ENCODE_SET, "exit", _UrlKt.FRAGMENT_ENCODE_SET, "cancel", "remainingNanos", "now", "remainingNanos$okio", "timedOut", "sink", "Lni/shikatu/okio/Sink;", "source", "Lni/shikatu/okio/Source;", "withTimeout", "T", "block", "Lni/shikatu/kotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "newTimeoutException", "Watchdog", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static AsyncTimeout idleSentinel;
    public int index = -1;
    private int state;
    private long timeoutAt;
    private static final Companion Companion = new Companion(null);
    private static final PriorityQueue queue = new PriorityQueue();
    private static final ReentrantLock lock = new ReentrantLock();

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos == 0 && !hasDeadline) {
            return;
        }
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (!(this.state == 0)) {
                throw new IllegalStateException("Unbalanced enter/exit".toString());
            }
            this.state = 1;
            Companion.insertIntoQueue(this, timeoutNanos, hasDeadline);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            int oldState = this.state;
            boolean z = false;
            this.state = 0;
            if (oldState == 1) {
                queue.remove(this);
            } else if (oldState == 2) {
                z = true;
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public void cancel() {
        super.cancel();
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (this.state == 1) {
                queue.remove(this);
                this.state = 3;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long remainingNanos$okio(long now) {
        return this.timeoutAt - now;
    }

    protected void timedOut() {
    }

    public final Sink sink(final Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new Sink() {
            @Override
            public void write(Buffer source, long remaining) throws IOException {
                long toWrite;
                Intrinsics.checkNotNullParameter(source, "source");
                SegmentedByteString.checkOffsetAndCount(source.size(), 0L, remaining);
                while (remaining > 0) {
                    long toWrite2 = 0;
                    Segment s = source.head;
                    Intrinsics.checkNotNull(s);
                    while (true) {
                        if (toWrite2 >= 65536) {
                            toWrite = toWrite2;
                            break;
                        }
                        int segmentSize = s.limit - s.pos;
                        toWrite2 += (long) segmentSize;
                        if (toWrite2 >= remaining) {
                            long toWrite3 = remaining;
                            toWrite = toWrite3;
                            break;
                        } else {
                            Segment segment = s.next;
                            Intrinsics.checkNotNull(segment);
                            s = segment;
                        }
                    }
                    AsyncTimeout this_$iv = AsyncTimeout.this;
                    Sink sink2 = sink;
                    this_$iv.enter();
                    try {
                        try {
                            sink2.write(source, toWrite);
                            Unit unit = Unit.INSTANCE;
                            boolean timedOut$iv = this_$iv.exit();
                            if (!timedOut$iv) {
                                remaining -= toWrite;
                            } else {
                                throw this_$iv.access$newTimeoutException(null);
                            }
                        } catch (IOException e$iv) {
                            if (!this_$iv.exit()) {
                                throw e$iv;
                            }
                            throw this_$iv.access$newTimeoutException(e$iv);
                        }
                    } catch (Throwable th) {
                        boolean timedOut$iv2 = this_$iv.exit();
                        if (timedOut$iv2 && 0 != 0) {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                        throw th;
                    }
                }
            }

            @Override
            public void flush() throws IOException {
                AsyncTimeout this_$iv = AsyncTimeout.this;
                Sink sink2 = sink;
                this_$iv.enter();
                try {
                    try {
                        sink2.flush();
                        Unit unit = Unit.INSTANCE;
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                        } else {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (timedOut$iv2 && 0 != 0) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                    throw th;
                }
            }

            @Override
            public void close() throws IOException {
                AsyncTimeout this_$iv = AsyncTimeout.this;
                Sink sink2 = sink;
                this_$iv.enter();
                try {
                    try {
                        sink2.close();
                        Unit unit = Unit.INSTANCE;
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                        } else {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (timedOut$iv2 && 0 != 0) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                    throw th;
                }
            }

            @Override
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }
        };
    }

    public final Source source(final Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Source() {
            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                AsyncTimeout this_$iv = AsyncTimeout.this;
                Source source2 = source;
                this_$iv.enter();
                try {
                    try {
                        long j = source2.read(sink, byteCount);
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                            return j;
                        }
                        throw this_$iv.access$newTimeoutException(null);
                    } catch (IOException e$iv) {
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(e$iv);
                        }
                        throw e$iv;
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (!timedOut$iv2 || 0 == 0) {
                        throw th;
                    }
                    throw this_$iv.access$newTimeoutException(null);
                }
            }

            @Override
            public void close() throws IOException {
                AsyncTimeout this_$iv = AsyncTimeout.this;
                Source source2 = source;
                this_$iv.enter();
                try {
                    try {
                        source2.close();
                        Unit unit = Unit.INSTANCE;
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                        } else {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (timedOut$iv2 && 0 != 0) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                    throw th;
                }
            }

            @Override
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }
        };
    }

    public final <T> T withTimeout(Function0<? extends T> function0) throws IOException {
        Intrinsics.checkNotNullParameter(function0, "block");
        enter();
        try {
            try {
                T tInvoke = function0.invoke();
                InlineMarker.finallyStart(1);
                boolean timedOut = exit();
                if (!timedOut) {
                    InlineMarker.finallyEnd(1);
                    return tInvoke;
                }
                throw access$newTimeoutException(null);
            } catch (IOException e) {
                if (exit()) {
                    throw access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            boolean timedOut2 = exit();
            if (timedOut2 && 0 != 0) {
                throw access$newTimeoutException(null);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public final IOException access$newTimeoutException(IOException cause) {
        return newTimeoutException(cause);
    }

    protected IOException newTimeoutException(IOException cause) {
        InterruptedIOException e = new InterruptedIOException("timeout");
        if (cause != null) {
            e.initCause(cause);
        }
        return e;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lni/shikatu/okio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "<init>", "()V", "run", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    ReentrantLock lock = AsyncTimeout.Companion.getLock();
                    lock.lock();
                    try {
                        AsyncTimeout asyncTimeoutAwaitTimeout = AsyncTimeout.Companion.awaitTimeout();
                        if (asyncTimeoutAwaitTimeout == AsyncTimeout.Companion.getIdleSentinel()) {
                            AsyncTimeout.Companion.setIdleSentinel(null);
                            lock.unlock();
                            return;
                        } else {
                            Unit unit = Unit.INSTANCE;
                            lock.unlock();
                            if (asyncTimeoutAwaitTimeout != null) {
                                asyncTimeoutAwaitTimeout.timedOut();
                            }
                        }
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lni/shikatu/okio/AsyncTimeout$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "queue", "Lni/shikatu/okio/PriorityQueue;", "getQueue", "()Lokio/PriorityQueue;", "idleSentinel", "Lni/shikatu/okio/AsyncTimeout;", "getIdleSentinel", "()Lokio/AsyncTimeout;", "setIdleSentinel", "(Lokio/AsyncTimeout;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "TIMEOUT_WRITE_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "IDLE_TIMEOUT_MILLIS", _UrlKt.FRAGMENT_ENCODE_SET, "IDLE_TIMEOUT_NANOS", "STATE_IDLE", "STATE_IN_QUEUE", "STATE_TIMED_OUT", "STATE_CANCELED", "insertIntoQueue", _UrlKt.FRAGMENT_ENCODE_SET, "node", "timeoutNanos", "hasDeadline", _UrlKt.FRAGMENT_ENCODE_SET, "awaitTimeout", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PriorityQueue getQueue() {
            return AsyncTimeout.queue;
        }

        public final AsyncTimeout getIdleSentinel() {
            return AsyncTimeout.idleSentinel;
        }

        public final void setIdleSentinel(AsyncTimeout asyncTimeout) {
            AsyncTimeout.idleSentinel = asyncTimeout;
        }

        public final ReentrantLock getLock() {
            return AsyncTimeout.lock;
        }

        public final Condition getCondition() {
            return AsyncTimeout.condition;
        }

        public final void insertIntoQueue(AsyncTimeout node, long timeoutNanos, boolean hasDeadline) {
            if (getIdleSentinel() == null) {
                setIdleSentinel(new AsyncTimeout());
                new Watchdog().start();
            }
            long now = System.nanoTime();
            if (timeoutNanos != 0 && hasDeadline) {
                node.timeoutAt = Math.min(timeoutNanos, node.deadlineNanoTime() - now) + now;
            } else if (timeoutNanos != 0) {
                node.timeoutAt = now + timeoutNanos;
            } else if (hasDeadline) {
                node.timeoutAt = node.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            getQueue().add(node);
            if (node.index == 1) {
                getCondition().signal();
            }
        }

        public final AsyncTimeout awaitTimeout() throws InterruptedException {
            AsyncTimeout node = getQueue().first();
            if (node == null) {
                long startNanos = System.nanoTime();
                getCondition().await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                if (getQueue().first() != null || System.nanoTime() - startNanos < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return getIdleSentinel();
            }
            long startNanos2 = System.nanoTime();
            long waitNanos = node.remainingNanos$okio(startNanos2);
            if (waitNanos > 0) {
                getCondition().await(waitNanos, TimeUnit.NANOSECONDS);
                return null;
            }
            getQueue().remove(node);
            node.state = 2;
            return node;
        }
    }

    static {
        Condition conditionNewCondition = lock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "newCondition(...)");
        condition = conditionNewCondition;
        IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    }
}
