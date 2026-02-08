package com.oplus.ocs.base.task;

import X.0VpD;
import X.0zxW;
import java.util.concurrent.Executor;

public final class n implements Runnable {
    public m a;
    public Task b;

    public n(m mVar, Task task) {
        this.a = mVar;
        this.b = task;
    }

    public static void com_oplus_ocs_base_task_n_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(n nVar) {
        try {
            nVar.com_oplus_ocs_base_task_n__run$___twin___();
        } catch (Throwable th) {
            if (!0VpD.LIZ(th)) {
                throw th;
            }
        }
    }

    public final void com_oplus_ocs_base_task_n__run$___twin___() {
        try {
            Task taskThen = this.a.a.then((TResult) this.b.getResult());
            if (taskThen == null) {
                this.a.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.CURRENT_THREAD;
            taskThen.addOnSuccessListener(executor, this.a);
            taskThen.addOnFailureListener(executor, this.a);
            taskThen.addOnCanceledListener(executor, this.a);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof Exception) {
                this.a.onFailure((Exception) e.getCause());
            } else {
                this.a.onFailure(e);
            }
        } catch (Exception e2) {
            this.a.onFailure(e2);
        }
    }

    @Override
    public final void run() {
        0zxW.LIZ("n@c4c2.run");
        com_oplus_ocs_base_task_n_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
        0zxW.LIZIZ("n@c4c2.run");
    }
}
