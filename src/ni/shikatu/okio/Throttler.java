package ni.shikatu.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J$\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u0007J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0018J\f\u0010\u0019\u001a\u00020\u0003*\u00020\u0003H\u0002J\f\u0010\u001a\u001a\u00020\u0003*\u00020\u0003H\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lni/shikatu/okio/Throttler;", _UrlKt.FRAGMENT_ENCODE_SET, "allocatedUntil", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(J)V", "()V", "bytesPerSecond", "waitByteCount", "maxByteCount", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", _UrlKt.FRAGMENT_ENCODE_SET, "take", "byteCount", "take$okio", "byteCountOrWaitNanos", "now", "byteCountOrWaitNanos$okio", "nanosToBytes", "bytesToNanos", "source", "Lni/shikatu/okio/Source;", "sink", "Lni/shikatu/okio/Sink;", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private final Condition condition;
    private final ReentrantLock lock;
    private long maxByteCount;
    private long waitByteCount;

    public final void bytesPerSecond(long j) {
        bytesPerSecond$default(this, j, 0L, 0L, 6, null);
    }

    public final void bytesPerSecond(long j, long j2) {
        bytesPerSecond$default(this, j, j2, 0L, 4, null);
    }

    public Throttler(long allocatedUntil) {
        this.allocatedUntil = allocatedUntil;
        this.waitByteCount = 8192L;
        this.maxByteCount = 262144L;
        this.lock = new ReentrantLock();
        Condition conditionNewCondition = this.lock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "newCondition(...)");
        this.condition = conditionNewCondition;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public Throttler() {
        this(System.nanoTime());
    }

    public static  void bytesPerSecond$default(Throttler throttler, long j, long j2, long j3, int i, Object obj) {
        long j4;
        long j5;
        if ((i & 2) == 0) {
            j4 = j2;
        } else {
            j4 = throttler.waitByteCount;
        }
        if ((i & 4) == 0) {
            j5 = j3;
        } else {
            j5 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j, j4, j5);
    }

    public final void bytesPerSecond(long bytesPerSecond, long waitByteCount, long maxByteCount) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!(bytesPerSecond >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(waitByteCount > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(maxByteCount >= waitByteCount)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.bytesPerSecond = bytesPerSecond;
            this.waitByteCount = waitByteCount;
            this.maxByteCount = maxByteCount;
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long take$okio(long byteCount) {
        if (!(byteCount > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                long now = System.nanoTime();
                long byteCountOrWaitNanos = byteCountOrWaitNanos$okio(now, byteCount);
                if (byteCountOrWaitNanos >= 0) {
                    reentrantLock.unlock();
                    return byteCountOrWaitNanos;
                }
                this.condition.awaitNanos(-byteCountOrWaitNanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final long byteCountOrWaitNanos$okio(long now, long byteCount) {
        if (this.bytesPerSecond == 0) {
            return byteCount;
        }
        long idleInNanos = Math.max(this.allocatedUntil - now, 0L);
        long immediateBytes = this.maxByteCount - nanosToBytes(idleInNanos);
        if (immediateBytes >= byteCount) {
            this.allocatedUntil = now + idleInNanos + bytesToNanos(byteCount);
            return byteCount;
        }
        if (immediateBytes >= this.waitByteCount) {
            this.allocatedUntil = bytesToNanos(this.maxByteCount) + now;
            return immediateBytes;
        }
        long minByteCount = Math.min(this.waitByteCount, byteCount);
        long minWaitNanos = bytesToNanos(minByteCount - this.maxByteCount) + idleInNanos;
        if (minWaitNanos == 0) {
            this.allocatedUntil = bytesToNanos(this.maxByteCount) + now;
            return minByteCount;
        }
        return -minWaitNanos;
    }

    private final long nanosToBytes(long $this$nanosToBytes) {
        return (this.bytesPerSecond * $this$nanosToBytes) / 1000000000;
    }

    private final long bytesToNanos(long $this$bytesToNanos) {
        return (1000000000 * $this$bytesToNanos) / this.bytesPerSecond;
    }

    public final Source source(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new ForwardingSource(source) {
            @Override
            public long read(Buffer sink, long byteCount) throws InterruptedIOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                try {
                    long toRead = this.take$okio(byteCount);
                    return super.read(sink, toRead);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final Sink sink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new ForwardingSink(sink) {
            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(source, "source");
                long remaining = byteCount;
                while (remaining > 0) {
                    try {
                        long toWrite = this.take$okio(remaining);
                        super.write(source, toWrite);
                        remaining -= toWrite;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }
}
