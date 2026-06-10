package X;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class x implements Runnable {
    @Override
    public final void run() {
        try {
            Context contextC = p4.c();
            if (contextC != null) {
                y.b(contextC);
                if (!d7.a().m) {
                    y.a(contextC);
                    AtomicBoolean atomicBoolean = y.b;
                    atomicBoolean.set(false);
                    Handler handler = y.a;
                    handler.removeCallbacks(y.e);
                    if (atomicBoolean.get()) {
                        handler.postDelayed(this, 300000L);
                        return;
                    }
                    return;
                }
                y.b(contextC, "heartbeat");
                y.c(contextC);
            }
            if (y.b.get()) {
                y.a.postDelayed(this, 300000L);
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
                int i = p4.a;
            } finally {
                if (y.b.get()) {
                    y.a.postDelayed(this, 300000L);
                }
            }
        }
    }
}
