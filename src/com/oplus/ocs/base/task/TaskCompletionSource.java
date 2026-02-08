package com.oplus.ocs.base.task;

public class TaskCompletionSource<TResult> {
    public TaskImpl<TResult> a = new TaskImpl<>();

    public Task<TResult> getTask() {
        return this.a;
    }

    public void setException(Exception exc) {
        com.oplus.ocs.base.utils.d.a(exc);
        this.a.setException(exc);
    }

    public void setResult(TResult tresult) {
        this.a.setResult(tresult);
    }

    public boolean trySetException(Exception exc) {
        com.oplus.ocs.base.utils.d.a(exc);
        return this.a.trySetException(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.a.trySetResult(tresult);
    }
}
