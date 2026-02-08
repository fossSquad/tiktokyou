package com.oplus.ocs.base.task;

import X.0VpD;
import X.0zxW;

public final class g implements Runnable {
    public f a;
    public Task b;

    public g(f fVar, Task task) {
        this.a = fVar;
        this.b = task;
    }

    public static void com_oplus_ocs_base_task_g_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(g gVar) {
        try {
            gVar.com_oplus_ocs_base_task_g__run$___twin___();
        } catch (Throwable th) {
            if (!0VpD.LIZ(th)) {
                throw th;
            }
        }
    }

    public final void com_oplus_ocs_base_task_g__run$___twin___() {
        synchronized (this.a.a) {
            if (this.a.a() != null) {
                this.a.a().onComplete(this.b);
            }
        }
    }

    @Override
    public final void run() {
        0zxW.LIZ("g@c4bb.run");
        com_oplus_ocs_base_task_g_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
        0zxW.LIZIZ("g@c4bb.run");
    }
}
