package X;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h implements Runnable {
    @Override
    public final void run() {
        try {
            Context contextB = p2.b();
            if (contextB != null) {
                if (r2.o == null || r2.a() == null) {
                    r2.a(contextB);
                }
                if (!r2.a().k) {
                    m.a(contextB);
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
                m.c(contextB, "heartbeat");
                m.b(contextB);
            }
            if (m.b.get()) {
                m.a.postDelayed(this, 300000L);
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
                ArrayList arrayList = p2.a;
            } finally {
                if (m.b.get()) {
                    m.a.postDelayed(this, 300000L);
                }
            }
        }
    }
}
