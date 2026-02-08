package com.oplus.ocs.base.task;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public class TaskImpl<TResult> extends Task<TResult> {
    public TResult b;
    public Exception c;
    public volatile boolean e;
    public volatile boolean f;
    public final Object a = new Object();
    public q<TResult> d = new q<>();

    private void a() {
        synchronized (this.a) {
            com.oplus.ocs.base.utils.d.a(this.e, "Task is not yet complete");
        }
    }

    private void b() {
        synchronized (this.a) {
            com.oplus.ocs.base.utils.d.a(!this.e, "Task is already complete");
        }
    }

    private void c() {
        if (this.f) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private void d() {
        synchronized (this.a) {
            if (this.e) {
                this.d.a(this);
            }
        }
    }

    @Override
    public Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        com.oplus.ocs.base.utils.d.a(onCanceledListener, "OnCanceledListener is not null");
        addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        return this;
    }

    @Override
    public Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(onCanceledListener, "OnCanceledListener is not null");
        this.d.a(new d(executor, onCanceledListener));
        d();
        return this;
    }

    @Override
    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        com.oplus.ocs.base.utils.d.a(onCompleteListener, "OnCompleteListener is not null");
        addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
        return this;
    }

    @Override
    public Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(onCompleteListener, "OnCompleteListener is not null");
        this.d.a(new f(executor, onCompleteListener));
        d();
        return this;
    }

    @Override
    public Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        com.oplus.ocs.base.utils.d.a(onFailureListener, "OnFailureListener is not null");
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    @Override
    public Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(onFailureListener, "OnFailureListener is not null");
        this.d.a(new h(executor, onFailureListener));
        d();
        return this;
    }

    @Override
    public Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        com.oplus.ocs.base.utils.d.a(onSuccessListener, "OnSuccessListener is not null");
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    @Override
    public Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(onSuccessListener, "OnSuccessListener is not null");
        this.d.a(new j(executor, onSuccessListener));
        d();
        return this;
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        com.oplus.ocs.base.utils.d.a(continuation, "Continuation is not null");
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(continuation, "Continuation is not null");
        TaskImpl taskImpl = new TaskImpl();
        this.d.a(new c(executor, continuation, taskImpl));
        d();
        return taskImpl;
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        com.oplus.ocs.base.utils.d.a(continuation, "Continuation is not null");
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(continuation, "Continuation is not null");
        TaskImpl taskImpl = new TaskImpl();
        this.d.a(new c(executor, continuation, taskImpl));
        d();
        return taskImpl;
    }

    @Override
    public Exception getException() {
        Exception exc;
        synchronized (this.a) {
            exc = this.c;
        }
        return exc;
    }

    @Override
    public TResult getResult() {
        TResult tresult;
        synchronized (this.a) {
            a();
            c();
            if (this.c != null) {
                throw new RuntimeException(this.c);
            }
            tresult = this.b;
        }
        return tresult;
    }

    @Override
    public <X extends Throwable> TResult getResult(Class<X> cls) {
        TResult tresult;
        synchronized (this.a) {
            a();
            c();
            if (cls.isInstance(this.c)) {
                throw cls.cast(this.c);
            }
            if (this.c != null) {
                throw new RuntimeException(this.c);
            }
            tresult = this.b;
        }
        return tresult;
    }

    @Override
    public boolean isCanceled() {
        return this.f;
    }

    @Override
    public boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.e;
        }
        return z;
    }

    @Override
    public boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.e && !this.f && this.c == null;
        }
        return z;
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        com.oplus.ocs.base.utils.d.a(successContinuation, "SuccessContinuation is not null");
        return onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
    }

    @Override
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(successContinuation, "SuccessContinuation is not null");
        TaskImpl taskImpl = new TaskImpl();
        this.d.a(new m(executor, successContinuation, taskImpl));
        d();
        return taskImpl;
    }

    public void setException(Exception exc) {
        com.oplus.ocs.base.utils.d.a(exc, "Exception must not be null");
        synchronized (this.a) {
            b();
            this.e = true;
            this.c = exc;
        }
        this.d.a(this);
    }

    public void setResult(TResult tresult) {
        synchronized (this.a) {
            b();
            this.e = true;
            this.b = tresult;
        }
        this.d.a(this);
    }

    public boolean tryCancel() {
        boolean z;
        synchronized (this.a) {
            if (this.e) {
                z = false;
            } else {
                z = true;
                this.e = true;
                this.f = true;
                this.d.a(this);
            }
        }
        return z;
    }

    public boolean trySetException(Exception exc) {
        boolean z;
        com.oplus.ocs.base.utils.d.a(exc, "Exception must not be null");
        com.oplus.ocs.base.utils.d.a(exc, "Exception must not be null");
        synchronized (this.a) {
            if (this.e) {
                z = false;
            } else {
                this.e = true;
                this.c = exc;
                this.d.a(this);
                z = true;
            }
        }
        return z;
    }

    public boolean trySetResult(TResult tresult) {
        boolean z;
        synchronized (this.a) {
            if (this.e) {
                z = false;
            } else {
                this.e = true;
                this.b = tresult;
                this.d.a(this);
                z = true;
            }
        }
        return z;
    }
}
