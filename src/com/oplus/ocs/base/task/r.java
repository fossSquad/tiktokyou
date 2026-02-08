package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

public final class r implements Executor {
    @Override
    public final void execute(Runnable runnable) {
        com.oplus.ocs.base.utils.d.a(runnable);
        runnable.run();
    }
}
