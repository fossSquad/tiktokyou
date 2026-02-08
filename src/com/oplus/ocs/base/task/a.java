package com.oplus.ocs.base.task;

import X.0VpD;
import X.0zxW;
import java.util.concurrent.Callable;

public final class a implements Runnable {
    public Callable a;
    public TaskImpl b;

    public a(TaskImpl taskImpl, Callable callable) {
        this.b = taskImpl;
        this.a = callable;
    }

    public static void com_oplus_ocs_base_task_a_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(a aVar) {
        try {
            aVar.com_oplus_ocs_base_task_a__run$___twin___();
        } catch (Throwable th) {
            if (!0VpD.LIZ(th)) {
                throw th;
            }
        }
    }

    public final void com_oplus_ocs_base_task_a__run$___twin___() {
        try {
            this.b.setResult(this.a.call());
        } catch (Exception e) {
            this.b.setException(e);
        }
    }

    @Override
    public final void run() {
        0zxW.LIZ("a@c4b5.run");
        com_oplus_ocs_base_task_a_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
        0zxW.LIZIZ("a@c4b5.run");
    }
}
