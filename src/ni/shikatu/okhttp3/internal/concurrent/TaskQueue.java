package ni.shikatu.okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u00014B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&J&\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(J0\u0010)\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020#0(J\u0006\u0010+\u001a\u00020,J%\u0010-\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\rH\u0000¢\u0006\u0002\b/J\u0006\u00100\u001a\u00020#J\u0006\u0010\f\u001a\u00020#J\r\u00101\u001a\u00020\rH\u0000¢\u0006\u0002\b2J\b\u00103\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001b¨\u00065"}, d2 = {"Lni/shikatu/okhttp3/internal/concurrent/TaskQueue;", _UrlKt.FRAGMENT_ENCODE_SET, "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "getName$okhttp", "()Ljava/lang/String;", "shutdown", _UrlKt.FRAGMENT_ENCODE_SET, "getShutdown$okhttp", "()Z", "setShutdown$okhttp", "(Z)V", "activeTask", "Lni/shikatu/okhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "futureTasks", _UrlKt.FRAGMENT_ENCODE_SET, "getFutureTasks$okhttp", "()Ljava/util/List;", "cancelActiveTask", "getCancelActiveTask$okhttp", "setCancelActiveTask$okhttp", "scheduledTasks", _UrlKt.FRAGMENT_ENCODE_SET, "getScheduledTasks", "schedule", _UrlKt.FRAGMENT_ENCODE_SET, "task", "delayNanos", _UrlKt.FRAGMENT_ENCODE_SET, "block", "Lni/shikatu/kotlin/Function0;", "execute", "cancelable", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", "cancelAll", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "toString", "AwaitIdleTask", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    public TaskQueue(TaskRunner taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final void setShutdown$okhttp(boolean z) {
        this.shutdown = z;
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final void setCancelActiveTask$okhttp(boolean z) {
        this.cancelActiveTask = z;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> list;
        Lockable $this$withLock$iv = this.taskRunner;
        synchronized ($this$withLock$iv) {
            list = CollectionsKt.toList(this.futureTasks);
        }
        return list;
    }

    public static  void schedule$default(TaskQueue taskQueue, Task task, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(task, j);
    }

    public final void schedule(Task task, long delayNanos) {
        Intrinsics.checkNotNullParameter(task, "task");
        Lockable $this$withLock$iv = this.taskRunner;
        synchronized ($this$withLock$iv) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, delayNanos, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            } else if (task.getCancelable()) {
                Logger $this$taskLog$iv = this.taskRunner.getLogger$okhttp();
                if ($this$taskLog$iv.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log($this$taskLog$iv, task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Logger $this$taskLog$iv2 = this.taskRunner.getLogger$okhttp();
                if ($this$taskLog$iv2.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log($this$taskLog$iv2, task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public static  void schedule$default(TaskQueue taskQueue, String str, long j, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(str, j, function0);
    }

    public final void schedule(String name, long delayNanos, final Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        schedule(new Task(name) {
            @Override
            public long runOnce() {
                return function0.invoke().longValue();
            }
        }, delayNanos);
    }

    public static  void execute$default(TaskQueue taskQueue, String str, long j, boolean z, Function0 function0, int i, Object obj) {
        long j2;
        boolean z2;
        if ((i & 2) == 0) {
            j2 = j;
        } else {
            j2 = 0;
        }
        if ((i & 4) == 0) {
            z2 = z;
        } else {
            z2 = true;
        }
        taskQueue.execute(str, j2, z2, function0);
    }

    public final void execute(String name, long delayNanos, boolean cancelable, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        schedule(new Task(name, cancelable) {
            @Override
            public long runOnce() {
                function0.invoke();
                return -1L;
            }
        }, delayNanos);
    }

    public final CountDownLatch idleLatch() {
        CountDownLatch latch;
        Lockable $this$withLock$iv = this.taskRunner;
        synchronized ($this$withLock$iv) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task existingTask = this.activeTask;
            if (existingTask instanceof AwaitIdleTask) {
                latch = ((AwaitIdleTask) existingTask).getLatch();
            } else {
                for (Task futureTask : this.futureTasks) {
                    if (futureTask instanceof AwaitIdleTask) {
                        latch = ((AwaitIdleTask) futureTask).getLatch();
                    }
                }
                AwaitIdleTask newTask = new AwaitIdleTask();
                if (scheduleAndDecide$okhttp(newTask, 0L, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                latch = newTask.getLatch();
            }
            return latch;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lni/shikatu/okhttp3/internal/concurrent/Task;", "<init>", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(_UtilJvmKt.okHttpName + " awaitIdle", false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long delayNanos, boolean recurrence) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        task.initQueue$okhttp(this);
        long now = this.taskRunner.getBackend().nanoTime();
        long executeNanoTime = now + delayNanos;
        int existingIndex = this.futureTasks.indexOf(task);
        if (existingIndex != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= executeNanoTime) {
                Logger $this$taskLog$iv = this.taskRunner.getLogger$okhttp();
                if ($this$taskLog$iv.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log($this$taskLog$iv, task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(existingIndex);
        }
        task.setNextExecuteNanoTime$okhttp(executeNanoTime);
        Logger $this$taskLog$iv2 = this.taskRunner.getLogger$okhttp();
        if ($this$taskLog$iv2.isLoggable(Level.FINE)) {
            if (recurrence) {
                str = "run again after " + TaskLoggerKt.formatDuration(executeNanoTime - now);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(executeNanoTime - now);
            }
            TaskLoggerKt.log($this$taskLog$iv2, task, this, str);
        }
        int index$iv = 0;
        Iterator<Task> it = this.futureTasks.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                Task it2 = (Task) item$iv;
                if (it2.getNextExecuteNanoTime$okhttp() - now > delayNanos) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        if (index$iv == -1) {
            index$iv = this.futureTasks.size();
        }
        this.futureTasks.add(index$iv, task);
        return index$iv == 0;
    }

    public final void cancelAll() {
        Lockable $this$assertLockNotHeld$iv = this.taskRunner;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            Lockable $this$withLock$iv = this.taskRunner;
            synchronized ($this$withLock$iv) {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    public final void shutdown() {
        Lockable $this$assertLockNotHeld$iv = this.taskRunner;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock($this$assertLockNotHeld$iv)) {
            Lockable $this$withLock$iv = this.taskRunner;
            synchronized ($this$withLock$iv) {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertLockNotHeld$iv);
    }

    public final boolean cancelAllAndDecide$okhttp() {
        if (this.activeTask != null) {
            Task task = this.activeTask;
            Intrinsics.checkNotNull(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean tasksCanceled = false;
        for (int i = this.futureTasks.size() - 1; -1 < i; i--) {
            if (this.futureTasks.get(i).getCancelable()) {
                Logger $this$taskLog$iv = this.taskRunner.getLogger$okhttp();
                Task task$iv = this.futureTasks.get(i);
                if ($this$taskLog$iv.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log($this$taskLog$iv, task$iv, this, "canceled");
                }
                tasksCanceled = true;
                this.futureTasks.remove(i);
            }
        }
        return tasksCanceled;
    }

    public String toString() {
        return this.name;
    }
}
