package com.oplus.ocs.base.task;

import X.0VpD;
import X.0zxW;

public final class i implements Runnable {
    public h a;
    public Task b;

    public i(h hVar, Task task) {
        this.a = hVar;
        this.b = task;
    }

    public static void com_oplus_ocs_base_task_i_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(i iVar) {
        try {
            iVar.com_oplus_ocs_base_task_i__run$___twin___();
        } catch (Throwable th) {
            if (!0VpD.LIZ(th)) {
                throw th;
            }
        }
    }

    public final void com_oplus_ocs_base_task_i__run$___twin___() {
        if (this.a.a() != null) {
            this.a.a().onFailure(this.b.getException());
        }
    }

    @Override
    public final void run() {
        0zxW.LIZ("i@c4bd.run");
        com_oplus_ocs_base_task_i_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
        0zxW.LIZIZ("i@c4bd.run");
    }
}
