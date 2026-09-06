package ni.shikatu.okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0003+,-B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002J \u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u0004\u0018\u00010!J\b\u0010&\u001a\u00020\u001cH\u0002J\u0006\u0010'\u001a\u00020\u0017J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)J\u0006\u0010*\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\b\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "backend", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner$Backend;", "logger", "Ljava/util/logging/Logger;", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;Ljava/util/logging/Logger;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "getLogger$okhttp", "()Ljava/util/logging/Logger;", "logger$1", "nextQueueName", _UrlKt.FRAGMENT_ENCODE_SET, "coordinatorWaiting", _UrlKt.FRAGMENT_ENCODE_SET, "coordinatorWakeUpAt", _UrlKt.FRAGMENT_ENCODE_SET, "executeCallCount", "runCallCount", "busyQueues", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/concurrent/TaskQueue;", "readyQueues", "runnable", "Ljava/lang/Runnable;", "kickCoordinator", _UrlKt.FRAGMENT_ENCODE_SET, "taskQueue", "kickCoordinator$okhttp", "beforeRun", "task", "Lni/shikatu/okhttp3/internal/concurrent/Task;", "afterRun", "delayNanos", "completedNormally", "awaitTaskToRun", "startAnotherThread", "newQueue", "activeQueues", _UrlKt.FRAGMENT_ENCODE_SET, "cancelAll", "Backend", "RealBackend", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TaskRunner implements Lockable {
    public static final Companion Companion = new Companion(null);
    public static final TaskRunner INSTANCE;
    private static final Logger logger;
    private final Backend backend;
    private final List<TaskQueue> busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int executeCallCount;
    private final Logger logger$1;
    private int nextQueueName;
    private final List<TaskQueue> readyQueues;
    private int runCallCount;
    private final Runnable runnable;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H&J\"\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000bH&J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/internal/concurrent/TaskRunner$Backend;", _UrlKt.FRAGMENT_ENCODE_SET, "nanoTime", _UrlKt.FRAGMENT_ENCODE_SET, "coordinatorNotify", _UrlKt.FRAGMENT_ENCODE_SET, "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "coordinatorWait", "nanos", "decorate", "Ljava/util/concurrent/BlockingQueue;", "T", "queue", "execute", "runnable", "Ljava/lang/Runnable;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Backend {
        void coordinatorNotify(TaskRunner taskRunner);

        void coordinatorWait(TaskRunner taskRunner, long j);

        <T> BlockingQueue<T> decorate(BlockingQueue<T> blockingQueue);

        void execute(TaskRunner taskRunner, Runnable runnable);

        long nanoTime();
    }

    public TaskRunner(Backend backend, Logger logger2) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.backend = backend;
        this.logger$1 = logger2;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new Runnable() {
            @Override
            public void run() {
                Task taskAwaitTaskToRun;
                Task taskAwaitTaskToRun2;
                Lockable $this$withLock$iv = this.this$0;
                TaskRunner taskRunner = this.this$0;
                synchronized ($this$withLock$iv) {
                    taskRunner.runCallCount++;
                    taskAwaitTaskToRun = taskRunner.awaitTaskToRun();
                }
                if (taskAwaitTaskToRun == null) {
                    return;
                }
                Thread currentThread = Thread.currentThread();
                String oldName = currentThread.getName();
                Task task = taskAwaitTaskToRun;
                while (true) {
                    try {
                        currentThread.setName(task.getName());
                        Logger $this$logElapsed$iv = this.this$0.getLogger$okhttp();
                        TaskQueue queue$iv = task.getQueue$okhttp();
                        Intrinsics.checkNotNull(queue$iv);
                        Task task$iv = task;
                        long startNs$iv = -1;
                        boolean loggingEnabled$iv = $this$logElapsed$iv.isLoggable(Level.FINE);
                        if (loggingEnabled$iv) {
                            startNs$iv = queue$iv.getTaskRunner$okhttp().getBackend().nanoTime();
                            TaskLoggerKt.log($this$logElapsed$iv, task$iv, queue$iv, "starting");
                        }
                        try {
                            long delayNanos = task.runOnce();
                            if (loggingEnabled$iv) {
                                TaskLoggerKt.log($this$logElapsed$iv, task$iv, queue$iv, "finished run in " + TaskLoggerKt.formatDuration(queue$iv.getTaskRunner$okhttp().getBackend().nanoTime() - startNs$iv));
                            }
                            Lockable $this$withLock$iv2 = this.this$0;
                            TaskRunner taskRunner2 = this.this$0;
                            synchronized ($this$withLock$iv2) {
                                taskRunner2.afterRun(task, delayNanos, true);
                                taskAwaitTaskToRun2 = taskRunner2.awaitTaskToRun();
                            }
                            if (taskAwaitTaskToRun2 == null) {
                                currentThread.setName(oldName);
                                return;
                            }
                            task = taskAwaitTaskToRun2;
                        } catch (Throwable th) {
                            if (!loggingEnabled$iv) {
                                throw th;
                            }
                            long elapsedNs$iv = queue$iv.getTaskRunner$okhttp().getBackend().nanoTime() - startNs$iv;
                            if (0 != 0) {
                                TaskLoggerKt.log($this$logElapsed$iv, task$iv, queue$iv, "finished run in " + TaskLoggerKt.formatDuration(elapsedNs$iv));
                                throw th;
                            }
                            TaskLoggerKt.log($this$logElapsed$iv, task$iv, queue$iv, "failed a run in " + TaskLoggerKt.formatDuration(elapsedNs$iv));
                            throw th;
                        }
                    } catch (Throwable thrown) {
                        try {
                            Lockable $this$withLock$iv3 = this.this$0;
                            TaskRunner taskRunner3 = this.this$0;
                            synchronized ($this$withLock$iv3) {
                                taskRunner3.afterRun(task, -1L, false);
                                Unit unit = Unit.INSTANCE;
                                if (!(thrown instanceof InterruptedException)) {
                                    throw thrown;
                                }
                                Thread.currentThread().interrupt();
                                currentThread.setName(oldName);
                                return;
                            }
                        } catch (Throwable th2) {
                            currentThread.setName(oldName);
                            throw th2;
                        }
                    }
                }
            }
        };
    }

    public  TaskRunner(Backend backend, Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backend, (i & 2) != 0 ? logger : logger2);
    }

    public final Backend getBackend() {
        return this.backend;
    }

    public final Logger getLogger$okhttp() {
        return this.logger$1;
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        TaskRunner $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            if (taskQueue.getActiveTask$okhttp() == null) {
                if (!taskQueue.getFutureTasks$okhttp().isEmpty()) {
                    _UtilCommonKt.addIfAbsent(this.readyQueues, taskQueue);
                } else {
                    this.readyQueues.remove(taskQueue);
                }
            }
            if (this.coordinatorWaiting) {
                this.backend.coordinatorNotify(this);
                return;
            } else {
                startAnotherThread();
                return;
            }
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    private final void beforeRun(Task task) {
        TaskRunner $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            task.setNextExecuteNanoTime$okhttp(-1L);
            TaskQueue queue = task.getQueue$okhttp();
            Intrinsics.checkNotNull(queue);
            queue.getFutureTasks$okhttp().remove(task);
            this.readyQueues.remove(queue);
            queue.setActiveTask$okhttp(task);
            this.busyQueues.add(queue);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    public final void afterRun(Task task, long delayNanos, boolean completedNormally) {
        TaskRunner $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            TaskQueue queue = task.getQueue$okhttp();
            Intrinsics.checkNotNull(queue);
            if (!(queue.getActiveTask$okhttp() == task)) {
                throw new IllegalStateException("Check failed.");
            }
            boolean cancelActiveTask = queue.getCancelActiveTask$okhttp();
            queue.setCancelActiveTask$okhttp(false);
            queue.setActiveTask$okhttp(null);
            this.busyQueues.remove(queue);
            if (delayNanos != -1 && !cancelActiveTask && !queue.getShutdown$okhttp()) {
                queue.scheduleAndDecide$okhttp(task, delayNanos, true);
            }
            if (!queue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.add(queue);
                if (!completedNormally) {
                    startAnotherThread();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    public final Task awaitTaskToRun() {
        TaskRunner $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            while (!this.readyQueues.isEmpty()) {
                long now = this.backend.nanoTime();
                long minDelayNanos = LongCompanionObject.MAX_VALUE;
                Task readyTask = null;
                boolean multipleReadyTasks = false;
                for (TaskQueue queue : this.readyQueues) {
                    Task candidate = queue.getFutureTasks$okhttp().get(0);
                    long candidateDelay = Math.max(0L, candidate.getNextExecuteNanoTime$okhttp() - now);
                    if (candidateDelay > 0) {
                        minDelayNanos = Math.min(candidateDelay, minDelayNanos);
                    } else {
                        if (readyTask != null) {
                            multipleReadyTasks = true;
                            break;
                        }
                        readyTask = candidate;
                    }
                }
                if (readyTask != null) {
                    beforeRun(readyTask);
                    if (multipleReadyTasks || (!this.coordinatorWaiting && !this.readyQueues.isEmpty())) {
                        startAnotherThread();
                    }
                    return readyTask;
                }
                if (this.coordinatorWaiting) {
                    if (minDelayNanos < this.coordinatorWakeUpAt - now) {
                        this.backend.coordinatorNotify(this);
                    }
                    return null;
                }
                this.coordinatorWaiting = true;
                this.coordinatorWakeUpAt = now + minDelayNanos;
                try {
                    try {
                        this.backend.coordinatorWait(this, minDelayNanos);
                    } catch (InterruptedException e) {
                        cancelAll();
                    }
                    this.coordinatorWaiting = false;
                } catch (Throwable th) {
                    this.coordinatorWaiting = false;
                    throw th;
                }
            }
            return null;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    private final void startAnotherThread() {
        TaskRunner $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            if (this.executeCallCount > this.runCallCount) {
                return;
            }
            this.executeCallCount++;
            this.backend.execute(this, this.runnable);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    public final TaskQueue newQueue() {
        int name;
        TaskRunner $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            name = this.nextQueueName;
            this.nextQueueName = name + 1;
        }
        return new TaskQueue(this, new StringBuilder().append('Q').append(name).toString());
    }

    public final List<TaskQueue> activeQueues() {
        List<TaskQueue> listPlus;
        TaskRunner $this$withLock$iv = this;
        synchronized ($this$withLock$iv) {
            listPlus = CollectionsKt.plus((Collection) this.busyQueues, (Iterable) this.readyQueues);
        }
        return listPlus;
    }

    public final void cancelAll() {
        TaskRunner $this$assertLockHeld$iv = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock($this$assertLockHeld$iv)) {
            int i = this.busyQueues.size();
            while (true) {
                i--;
                if (-1 >= i) {
                    break;
                } else {
                    this.busyQueues.get(i).cancelAllAndDecide$okhttp();
                }
            }
            for (int i2 = this.readyQueues.size() - 1; -1 < i2; i2--) {
                TaskQueue queue = this.readyQueues.get(i2);
                queue.cancelAllAndDecide$okhttp();
                if (queue.getFutureTasks$okhttp().isEmpty()) {
                    this.readyQueues.remove(i2);
                }
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lni/shikatu/okhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "nanoTime", _UrlKt.FRAGMENT_ENCODE_SET, "coordinatorNotify", _UrlKt.FRAGMENT_ENCODE_SET, "taskRunner", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "coordinatorWait", "nanos", "decorate", "Ljava/util/concurrent/BlockingQueue;", "T", "queue", "execute", "runnable", "Ljava/lang/Runnable;", "shutdown", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class RealBackend implements Backend {
        private final ThreadPoolExecutor executor;

        public RealBackend(ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, IntCompanionObject.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        public final ThreadPoolExecutor getExecutor() {
            return this.executor;
        }

        @Override
        public long nanoTime() {
            return System.nanoTime();
        }

        @Override
        public void coordinatorNotify(TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            TaskRunner $this$notify$iv = taskRunner;
            $this$notify$iv.notify();
        }

        @Override
        public void coordinatorWait(TaskRunner taskRunner, long nanos) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            TaskRunner $this$assertLockHeld$iv = taskRunner;
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock($this$assertLockHeld$iv)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertLockHeld$iv);
            }
            if (nanos > 0) {
                TaskRunner $this$awaitNanos$iv = taskRunner;
                long ms$iv = nanos / 1000000;
                long ns$iv = nanos - (1000000 * ms$iv);
                if (ms$iv <= 0 && nanos <= 0) {
                    return;
                }
                $this$awaitNanos$iv.wait(ms$iv, (int) ns$iv);
            }
        }

        @Override
        public <T> BlockingQueue<T> decorate(BlockingQueue<T> blockingQueue) {
            Intrinsics.checkNotNullParameter(blockingQueue, "queue");
            return blockingQueue;
        }

        @Override
        public void execute(TaskRunner taskRunner, Runnable runnable) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.executor.execute(runnable);
        }

        public final void shutdown() {
            this.executor.shutdown();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/internal/concurrent/TaskRunner$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "INSTANCE", "Lni/shikatu/okhttp3/internal/concurrent/TaskRunner;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Logger getLogger() {
            return TaskRunner.logger;
        }
    }

    static {
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(...)");
        logger = logger2;
        INSTANCE = new TaskRunner(new RealBackend(_UtilJvmKt.threadFactory(_UtilJvmKt.okHttpName + " TaskRunner", true)), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    }
}
