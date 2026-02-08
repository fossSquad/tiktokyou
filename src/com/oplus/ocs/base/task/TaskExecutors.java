package com.oplus.ocs.base.task;

import X.0Vx6;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class TaskExecutors {
    public static final Executor MAIN_THREAD = new MainExecutor();
    public static final Executor CURRENT_THREAD = new r();

    public static class MainExecutor implements Executor {
        public Handler a = new k93.a(Looper.getMainLooper());

        @Override
        public void execute(Runnable runnable) {
            com.oplus.ocs.base.utils.d.a(runnable);
            0Vx6.LJJLIIIIJ(this.a, runnable);
        }
    }
}
