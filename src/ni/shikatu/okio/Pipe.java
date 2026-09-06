package ni.shikatu.okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020\u0019J&\u0010,\u001a\u00020+*\u00020\u00192\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020+0.¢\u0006\u0002\b/H\u0082\bJ\r\u0010&\u001a\u00020\u0019H\u0007¢\u0006\u0002\b0J\r\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\b1J\u0006\u00102\u001a\u00020+R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u00020\u00198\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010'\u001a\u00020(8\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010)¨\u00063"}, d2 = {"Lni/shikatu/okio/Pipe;", _UrlKt.FRAGMENT_ENCODE_SET, "maxBufferSize", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(J)V", "getMaxBufferSize$okio", "()J", "buffer", "Lni/shikatu/okio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", _UrlKt.FRAGMENT_ENCODE_SET, "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "foldedSink", "Lni/shikatu/okio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "sink", "source", "Lni/shikatu/okio/Source;", "()Lokio/Source;", "fold", _UrlKt.FRAGMENT_ENCODE_SET, "forward", "block", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "-deprecated_sink", "-deprecated_source", "cancel", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Pipe {
    private boolean canceled;
    private final Condition condition;
    private Sink foldedSink;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;
    private final Buffer buffer = new Buffer();
    private final ReentrantLock lock = new ReentrantLock();

    public Pipe(long maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
        Condition conditionNewCondition = this.lock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "newCondition(...)");
        this.condition = conditionNewCondition;
        if (!(this.maxBufferSize >= 1)) {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + this.maxBufferSize).toString());
        }
        this.sink = new Sink() {
            private final Timeout timeout = new Timeout();

            @Override
            public void write(Buffer source, long byteCount) throws Throwable {
                boolean zHasDeadline;
                Intrinsics.checkNotNullParameter(source, "source");
                Sink sink = null;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    long byteCount2 = byteCount;
                    while (byteCount2 > 0) {
                        try {
                            Sink it = pipe.getFoldedSink$okio();
                            if (it != null) {
                                sink = it;
                                break;
                            }
                            if (pipe.getSourceClosed$okio()) {
                                throw new IOException("source is closed");
                            }
                            long bufferSpaceAvailable = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                            if (bufferSpaceAvailable == 0) {
                                this.timeout.awaitSignal(pipe.getCondition());
                                if (pipe.getCanceled$okio()) {
                                    throw new IOException("canceled");
                                }
                            } else {
                                long bytesToWrite = Math.min(bufferSpaceAvailable, byteCount2);
                                pipe.getBuffer$okio().write(source, bytesToWrite);
                                byteCount2 -= bytesToWrite;
                                pipe.getCondition().signalAll();
                            }
                        } catch (Throwable th) {
                            th = th;
                            lock.unlock();
                            throw th;
                        }
                    }
                    try {
                        Unit unit = Unit.INSTANCE;
                        lock.unlock();
                        if (sink != null) {
                            Pipe this_$iv = Pipe.this;
                            Sink $this$forward$iv = sink;
                            Timeout this_$iv$iv = $this$forward$iv.timeout();
                            Timeout other$iv$iv = this_$iv.sink().timeout();
                            long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
                            this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                            if (!this_$iv$iv.hasDeadline()) {
                                if (other$iv$iv.hasDeadline()) {
                                    this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                                }
                                try {
                                    $this$forward$iv.write(source, byteCount2);
                                    Unit unit2 = Unit.INSTANCE;
                                    if (zHasDeadline) {
                                        return;
                                    } else {
                                        return;
                                    }
                                } finally {
                                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                                    if (other$iv$iv.hasDeadline()) {
                                        this_$iv$iv.clearDeadline();
                                    }
                                }
                            }
                            long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(Math.min(this_$iv$iv.deadlineNanoTime(), other$iv$iv.deadlineNanoTime()));
                            }
                            try {
                                $this$forward$iv.write(source, byteCount2);
                                Unit unit3 = Unit.INSTANCE;
                            } finally {
                                this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                                if (other$iv$iv.hasDeadline()) {
                                    this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        lock.unlock();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            @Override
            public void flush() {
                boolean zHasDeadline;
                Sink sink = null;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    Sink it = pipe.getFoldedSink$okio();
                    if (it != null) {
                        sink = it;
                    } else if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                        throw new IOException("source is closed");
                    }
                    Unit unit = Unit.INSTANCE;
                    lock.unlock();
                    if (sink != null) {
                        Pipe this_$iv = Pipe.this;
                        Sink $this$forward$iv = sink;
                        Timeout this_$iv$iv = $this$forward$iv.timeout();
                        Timeout other$iv$iv = this_$iv.sink().timeout();
                        long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
                        this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!this_$iv$iv.hasDeadline()) {
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                            }
                            try {
                                $this$forward$iv.flush();
                                Unit unit2 = Unit.INSTANCE;
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                                if (other$iv$iv.hasDeadline()) {
                                    this_$iv$iv.clearDeadline();
                                }
                            }
                        }
                        long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.deadlineNanoTime(Math.min(this_$iv$iv.deadlineNanoTime(), other$iv$iv.deadlineNanoTime()));
                        }
                        try {
                            $this$forward$iv.flush();
                            Unit unit3 = Unit.INSTANCE;
                        } finally {
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                            }
                        }
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override
            public void close() {
                boolean zHasDeadline;
                Sink sink = null;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        lock.unlock();
                        return;
                    }
                    Sink it = pipe.getFoldedSink$okio();
                    if (it != null) {
                        sink = it;
                    } else {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        pipe.setSinkClosed$okio(true);
                        pipe.getCondition().signalAll();
                    }
                    Unit unit = Unit.INSTANCE;
                    lock.unlock();
                    if (sink != null) {
                        Pipe this_$iv = Pipe.this;
                        Sink $this$forward$iv = sink;
                        Timeout this_$iv$iv = $this$forward$iv.timeout();
                        Timeout other$iv$iv = this_$iv.sink().timeout();
                        long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
                        this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!this_$iv$iv.hasDeadline()) {
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                            }
                            try {
                                $this$forward$iv.close();
                                Unit unit2 = Unit.INSTANCE;
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                                if (other$iv$iv.hasDeadline()) {
                                    this_$iv$iv.clearDeadline();
                                }
                            }
                        }
                        long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.deadlineNanoTime(Math.min(this_$iv$iv.deadlineNanoTime(), other$iv$iv.deadlineNanoTime()));
                        }
                        try {
                            $this$forward$iv.close();
                            Unit unit3 = Unit.INSTANCE;
                        } finally {
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                            }
                        }
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override
            public Timeout timeout() {
                return this.timeout;
            }
        };
        this.source = new Source() {
            private final Timeout timeout = new Timeout();

            @Override
            public long read(Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSourceClosed$okio()) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (pipe.getBuffer$okio().size() == 0) {
                        if (pipe.getSinkClosed$okio()) {
                            lock.unlock();
                            return -1L;
                        }
                        this.timeout.awaitSignal(pipe.getCondition());
                        if (pipe.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                    }
                    long j = pipe.getBuffer$okio().read(sink, byteCount);
                    pipe.getCondition().signalAll();
                    lock.unlock();
                    return j;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override
            public void close() {
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    pipe.setSourceClosed$okio(true);
                    pipe.getCondition().signalAll();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    lock.unlock();
                }
            }

            @Override
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }

    public final void fold(Sink sink) throws IOException {
        Buffer buffer;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (true) {
            boolean done = false;
            Buffer buffer2 = null;
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                boolean closed = this.sinkClosed;
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    done = true;
                } else {
                    buffer2 = new Buffer();
                    buffer2.write(this.buffer, this.buffer.size());
                    this.condition.signalAll();
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                if (done) {
                    if (closed) {
                        sink.close();
                        return;
                    }
                    return;
                }
                if (buffer2 == null) {
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException("sinkBuffer");
                        buffer = null;
                    } catch (Throwable th) {
                        ReentrantLock reentrantLock2 = this.lock;
                        reentrantLock2.lock();
                        try {
                            this.sourceClosed = true;
                            this.condition.signalAll();
                            Unit unit2 = Unit.INSTANCE;
                            throw th;
                        } finally {
                            reentrantLock2.unlock();
                        }
                    }
                } else {
                    buffer = buffer2;
                }
                sink.write(buffer, buffer2.size());
                sink.flush();
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
    }

    private final void forward(Sink $this$forward, Function1<? super Sink, Unit> function1) {
        Timeout this_$iv = $this$forward.timeout();
        Timeout other$iv = sink().timeout();
        long originalTimeout$iv = this_$iv.timeoutNanos();
        this_$iv.timeout(Timeout.Companion.minTimeout(other$iv.timeoutNanos(), this_$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this_$iv.hasDeadline()) {
            long originalDeadline$iv = this_$iv.deadlineNanoTime();
            if (other$iv.hasDeadline()) {
                this_$iv.deadlineNanoTime(Math.min(this_$iv.deadlineNanoTime(), other$iv.deadlineNanoTime()));
            }
            try {
                function1.invoke($this$forward);
                Unit unit = Unit.INSTANCE;
                return;
            } finally {
                InlineMarker.finallyStart(1);
                this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                if (other$iv.hasDeadline()) {
                    this_$iv.deadlineNanoTime(originalDeadline$iv);
                }
                InlineMarker.finallyEnd(1);
            }
        }
        if (other$iv.hasDeadline()) {
            this_$iv.deadlineNanoTime(other$iv.deadlineNanoTime());
        }
        try {
            function1.invoke($this$forward);
            Unit unit2 = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
            if (other$iv.hasDeadline()) {
                this_$iv.clearDeadline();
            }
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))

    public final Sink m1772deprecated_sink() {
        return this.sink;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}))

    public final Source m1773deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
