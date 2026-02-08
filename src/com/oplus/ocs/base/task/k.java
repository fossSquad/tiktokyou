package com.oplus.ocs.base.task;

import X.0VpD;
import X.0zxW;

public final class k implements Runnable {
    public j a;
    public Task b;

    public k(j jVar, Task task) {
        this.a = jVar;
        this.b = task;
    }

    public static void com_oplus_ocs_base_task_k_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(k kVar) {
        try {
            kVar.com_oplus_ocs_base_task_k__run$___twin___();
        } catch (Throwable th) {
            if (!0VpD.LIZ(th)) {
                throw th;
            }
        }
    }

    public final void com_oplus_ocs_base_task_k__run$___twin___() {
        if (this.a.a() != null) {
            this.a.a().onSuccess(this.b.getResult());
        }
    }

    @Override
    public final void run() {
        0zxW.LIZ("k@c4bf.run");
        com_oplus_ocs_base_task_k_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
        0zxW.LIZIZ("k@c4bf.run");
    }
}
