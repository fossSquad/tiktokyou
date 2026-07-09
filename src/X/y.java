package X;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class y implements Runnable {
    @Override
    public final void run() {
        try {
            Context contextC = g5.c();
            if (contextC != null) {
                z.b(contextC);
                if (!l8.a().n) {
                    z.a(contextC);
                    AtomicBoolean atomicBoolean = z.b;
                    atomicBoolean.set(false);
                    Handler handler = z.a;
                    handler.removeCallbacks(z.e);
                    if (atomicBoolean.get()) {
                        handler.postDelayed(this, 300000L);
                        return;
                    }
                    return;
                }
                z.b(contextC, "heartbeat");
                z.c(contextC);
            }
            if (z.b.get()) {
                z.a.postDelayed(this, 300000L);
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
                int i = g5.a;
            } finally {
                if (z.b.get()) {
                    z.a.postDelayed(this, 300000L);
                }
            }
        }
    }
}
