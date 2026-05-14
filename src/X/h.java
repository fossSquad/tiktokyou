package X;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h implements Runnable {
    @Override
    public final void run() {
        try {
            Context contextC = v3.c();
            if (contextC != null) {
                m.b(contextC);
                if (!y3.a().k) {
                    m.a(contextC);
                    AtomicBoolean atomicBoolean = m.b;
                    atomicBoolean.set(false);
                    Handler handler = m.a;
                    handler.removeCallbacks(m.d);
                    if (atomicBoolean.get()) {
                        handler.postDelayed(this, 300000L);
                        return;
                    }
                    return;
                }
                m.c(contextC, "heartbeat");
                m.c(contextC);
            }
            if (m.b.get()) {
                m.a.postDelayed(this, 300000L);
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
                int i = v3.a;
            } finally {
                if (m.b.get()) {
                    m.a.postDelayed(this, 300000L);
                }
            }
        }
    }
}
