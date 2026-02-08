package com.oplus.ocs.base.task;

import X.0wS0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Tasks {

    public static class a implements c {
        public final Object a = new Object();
        public TaskImpl<Void> b;
        public Exception c;
        public volatile int d;
        public volatile int e;
        public volatile int f;
        public volatile int g;
        public volatile boolean h;

        public a(int i, TaskImpl<Void> taskImpl) {
            this.d = i;
            this.b = taskImpl;
        }

        private void a() {
            synchronized (this.a) {
                if (this.e + this.f + this.g != this.d) {
                    return;
                }
                if (this.c != null) {
                    TaskImpl<Void> taskImpl = this.b;
                    int i = this.f;
                    StringBuilder sbLIZ = 0wS0.LIZ();
                    sbLIZ.append(i);
                    sbLIZ.append(" out of ");
                    sbLIZ.append(this.d);
                    sbLIZ.append(" underlying tasks failed");
                    taskImpl.setException(new ExecutionException(0wS0.LIZIZ(sbLIZ), this.c));
                } else if (this.h) {
                    this.b.tryCancel();
                } else {
                    this.b.setResult(null);
                }
            }
        }

        @Override
        public final void onCanceled() {
            synchronized (this.a) {
                this.g++;
                this.h = true;
                a();
            }
        }

        @Override
        public final void onFailure(Exception exc) {
            com.oplus.ocs.base.utils.d.a(exc);
            synchronized (this.a) {
                this.f++;
                this.c = exc;
                a();
            }
        }

        @Override
        public final void onSuccess(Object obj) {
            synchronized (this.a) {
                this.e++;
                a();
            }
        }
    }

    public static class b implements c {
        public CountDownLatch a;

        public b() {
            this.a = new CountDownLatch(1);
        }

        public b(byte b) {
            this();
        }

        @Override
        public final void onCanceled() {
            this.a.countDown();
        }

        @Override
        public final void onFailure(Exception exc) {
            this.a.countDown();
        }

        @Override
        public final void onSuccess(Object obj) {
            this.a.countDown();
        }
    }

    public interface c extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    public static <TResult> void a(Task<TResult> task, c cVar) {
        Executor executor = TaskExecutors.CURRENT_THREAD;
        task.addOnSuccessListener(executor, cVar);
        task.addOnFailureListener(executor, cVar);
        task.addOnCanceledListener(executor, cVar);
    }

    public static <TResult> TResult await(Task<TResult> task) throws InterruptedException {
        com.oplus.ocs.base.utils.d.b("Must not be called on the main application thread");
        com.oplus.ocs.base.utils.d.a(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) a(task);
        }
        b bVar = new b((byte) 0);
        a(task, bVar);
        bVar.a.await();
        return (TResult) a(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws TimeoutException {
        com.oplus.ocs.base.utils.d.b("Must not be called on the main application thread");
        com.oplus.ocs.base.utils.d.a(task, "Task must not be null");
        com.oplus.ocs.base.utils.d.a(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) a(task);
        }
        b bVar = new b((byte) 0);
        a(task, bVar);
        if (bVar.a.await(j, timeUnit)) {
            return (TResult) a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        com.oplus.ocs.base.utils.d.a(callable);
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor must not be null");
        com.oplus.ocs.base.utils.d.a(callable, "Callback must not be null");
        TaskImpl taskImpl = new TaskImpl();
        executor.execute(new com.oplus.ocs.base.task.a(taskImpl, callable));
        return taskImpl;
    }

    public static <TResult> Task<TResult> forCanceled() {
        TaskImpl taskImpl = new TaskImpl();
        taskImpl.tryCancel();
        return taskImpl;
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        com.oplus.ocs.base.utils.d.a(exc);
        TaskImpl taskImpl = new TaskImpl();
        taskImpl.setException(exc);
        return taskImpl;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        TaskImpl taskImpl = new TaskImpl();
        taskImpl.setResult(tresult);
        return taskImpl;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        TaskImpl taskImpl = new TaskImpl();
        a aVar = new a(collection.size(), taskImpl);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            a(it2.next(), aVar);
        }
        return taskImpl;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        return taskArr.length == 0 ? forResult(null) : whenAll(Arrays.asList(taskArr));
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        return whenAll(collection).continueWithTask(new o(collection));
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        return whenAllComplete(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        return (Task<List<TResult>>) whenAll(collection).continueWith(new p(collection));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        return whenAllSuccess(Arrays.asList(taskArr));
    }
}
