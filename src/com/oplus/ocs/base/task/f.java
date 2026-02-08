package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

public final class f<TResult> implements b<TResult> {
    public final Object a = new Object();
    public Executor b;
    public volatile OnCompleteListener<TResult> c;

    public f(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        com.oplus.ocs.base.utils.d.a(executor, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(onCompleteListener, "OnCompleteListener is not null");
        this.b = executor;
        this.c = onCompleteListener;
    }

    public final OnCompleteListener<TResult> a() {
        OnCompleteListener<TResult> onCompleteListener;
        synchronized (this.a) {
            onCompleteListener = this.c;
        }
        return onCompleteListener;
    }

    @Override
    public final void a(Task<TResult> task) {
        com.oplus.ocs.base.utils.d.a(task, "Task is not null");
        synchronized (this.a) {
            if (this.c == null) {
                return;
            }
            this.b.execute(new g(this, task));
        }
    }
}
