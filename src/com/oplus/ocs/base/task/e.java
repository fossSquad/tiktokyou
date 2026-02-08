package com.oplus.ocs.base.task;

import X.0VpD;
import X.0zxW;

public final class e implements Runnable {
    public d a;

    public e(d dVar) {
        this.a = dVar;
    }

    public static void com_oplus_ocs_base_task_e_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(e eVar) {
        try {
            eVar.com_oplus_ocs_base_task_e__run$___twin___();
        } catch (Throwable th) {
            if (!0VpD.LIZ(th)) {
                throw th;
            }
        }
    }

    public final void com_oplus_ocs_base_task_e__run$___twin___() {
        if (this.a.a() != null) {
            this.a.a().onCanceled();
        }
    }

    @Override
    public final void run() {
        0zxW.LIZ("e@c4b9.run");
        com_oplus_ocs_base_task_e_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
        0zxW.LIZIZ("e@c4b9.run");
    }
}
