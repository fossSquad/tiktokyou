package com.oplus.ocs.base.task;

import java.util.ArrayDeque;
import java.util.Queue;

public final class q<TResult> {
    public Object a = new Object();
    public Queue<b<TResult>> b;
    public boolean c;

    public final void a(Task<TResult> task) {
        b<TResult> bVarPoll;
        com.oplus.ocs.base.utils.d.a(task, "Task is not be null");
        synchronized (this.a) {
            if (this.b == null || this.c) {
                return;
            }
            this.c = true;
            while (true) {
                synchronized (this.a) {
                    bVarPoll = this.b.poll();
                    if (bVarPoll == null) {
                        this.c = false;
                        return;
                    }
                }
                bVarPoll.a(task);
            }
        }
    }

    public final void a(b<TResult> bVar) {
        com.oplus.ocs.base.utils.d.a(bVar, "Cancellable is not be null");
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(bVar);
        }
    }
}
