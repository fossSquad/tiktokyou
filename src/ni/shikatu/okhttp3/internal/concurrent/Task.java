package ni.shikatu.okhttp3.internal.concurrent;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0013H&J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lni/shikatu/okhttp3/internal/concurrent/Task;", _UrlKt.FRAGMENT_ENCODE_SET, "name", _UrlKt.FRAGMENT_ENCODE_SET, "cancelable", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getCancelable", "()Z", "queue", "Lni/shikatu/okhttp3/internal/concurrent/TaskQueue;", "getQueue$okhttp", "()Lokhttp3/internal/concurrent/TaskQueue;", "setQueue$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "nextExecuteNanoTime", _UrlKt.FRAGMENT_ENCODE_SET, "getNextExecuteNanoTime$okhttp", "()J", "setNextExecuteNanoTime$okhttp", "(J)V", "runOnce", "initQueue", _UrlKt.FRAGMENT_ENCODE_SET, "initQueue$okhttp", "toString", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class Task {
    private final boolean cancelable;
    private final String name;
    private long nextExecuteNanoTime;
    private TaskQueue queue;

    public abstract long runOnce();

    public Task(String name, boolean cancelable) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.cancelable = cancelable;
        this.nextExecuteNanoTime = -1L;
    }

    public  Task(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void setQueue$okhttp(TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    public final void setNextExecuteNanoTime$okhttp(long j) {
        this.nextExecuteNanoTime = j;
    }

    public final void initQueue$okhttp(TaskQueue queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        if (this.queue == queue) {
            return;
        }
        if (!(this.queue == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.queue = queue;
    }

    public String toString() {
        return this.name;
    }
}
