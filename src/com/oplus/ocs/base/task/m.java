package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

public final class m<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, b<TResult> {
    public SuccessContinuation<TResult, TContinuationResult> a;
    public Executor b;
    public TaskImpl<TContinuationResult> c;

    public m(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, TaskImpl<TContinuationResult> taskImpl) {
        com.oplus.ocs.base.utils.d.a(executor, "executor is not null");
        com.oplus.ocs.base.utils.d.a(successContinuation, "successContinuation is not null");
        com.oplus.ocs.base.utils.d.a(taskImpl, "task is not null");
        this.b = executor;
        this.a = successContinuation;
        this.c = taskImpl;
    }

    @Override
    public final void a(Task<TResult> task) {
        com.oplus.ocs.base.utils.d.a(task, "task is not null");
        this.b.execute(new n(this, task));
    }

    @Override
    public final void onCanceled() {
        this.c.tryCancel();
    }

    @Override
    public final void onFailure(Exception exc) {
        com.oplus.ocs.base.utils.d.a(exc, "param exception is not null");
        this.c.setException(exc);
    }

    @Override
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.setResult(tcontinuationresult);
    }
}
