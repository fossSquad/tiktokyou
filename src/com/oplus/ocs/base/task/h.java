package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

public final class h<TResult> implements b<TResult> {
    public Executor a;
    public final Object b = new Object();
    public volatile OnFailureListener c;

    public h(Executor executor, OnFailureListener onFailureListener) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(onFailureListener, "OnFailureListener is not null");
        this.a = executor;
        this.c = onFailureListener;
    }

    public final OnFailureListener a() {
        OnFailureListener onFailureListener;
        synchronized (this.b) {
            onFailureListener = this.c;
        }
        return onFailureListener;
    }

    @Override
    public final void a(Task<TResult> task) {
        com.oplus.ocs.base.utils.d.a(task, "Task is not null");
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new i(this, task));
        }
    }
}
