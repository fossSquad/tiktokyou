package X;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h implements Runnable {
    @Override
    public final void run() {
        try {
            Context contextB = r1.b();
            if (contextB != null) {
                if (t1.m == null || t1.a() == null) {
                    if (t1.m == null) {
                        t1.m = contextB.getSharedPreferences("ttmod_settings", 0);
                    }
                    if (t1.n == null) {
                        t1.n = new t1();
                    }
                }
                if (!t1.a().k) {
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
                ArrayList arrayList = r1.a;
            } finally {
                if (m.b.get()) {
                    m.a.postDelayed(this, 300000L);
                }
            }
        }
    }
}
