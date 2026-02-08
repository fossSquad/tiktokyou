package com.oplus.ocs.base.task;

import X.0VpD;
import X.0zxW;

public final class l implements Runnable {
    public Task a;
    public c b;

    public l(c cVar, Task task) {
        this.b = cVar;
        this.a = task;
    }

    public static void com_oplus_ocs_base_task_l_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(l lVar) {
        try {
            lVar.com_oplus_ocs_base_task_l__run$___twin___();
        } catch (Throwable th) {
            if (!0VpD.LIZ(th)) {
                throw th;
            }
        }
    }

    public final void com_oplus_ocs_base_task_l__run$___twin___() {
        Object objThen;
        if (this.a.isCanceled()) {
            this.b.b.tryCancel();
            return;
        }
        try {
            objThen = this.b.a.then((Task<TResult>) this.a);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof Exception) {
                this.b.b.setException((Exception) e.getCause());
            } else {
                this.b.b.setException(e);
            }
            objThen = null;
        } catch (Exception e2) {
            this.b.b.setException(e2);
            objThen = null;
        }
        this.b.b.setResult((TContinuationResult) objThen);
    }

    @Override
    public final void run() {
        0zxW.LIZ("l@c4c0.run");
        com_oplus_ocs_base_task_l_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
        0zxW.LIZIZ("l@c4c0.run");
    }
}
