package Z;

import android.content.Context;
import android.os.Handler;
import com.windukk.mod.Main;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;

public final class s implements Runnable {
    @Override
    public final void run() {
        Object obj;
        try {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Main.a());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Context context = (Context) obj;
            if (context == null) {
                if (t.c.get()) {
                    t.b.postDelayed(this, 300000L);
                    return;
                }
                return;
            }
            t.a.getClass();
            if (ta.b == null) {
                Context applicationContext = context.getApplicationContext();
                ta.a(applicationContext);
            }
            ta.a.getClass();
            if (ta.d().o) {
                t.a(context, "heartbeat");
                t.b(context);
                if (t.c.get()) {
                    t.b.postDelayed(this, 300000L);
                    return;
                }
                return;
            }
            t.a(context);
            AtomicBoolean atomicBoolean = t.c;
            atomicBoolean.set(false);
            Handler handler = t.b;
            handler.removeCallbacks(t.g);
            if (atomicBoolean.get()) {
                handler.postDelayed(this, 300000L);
            }
        } catch (Throwable th2) {
            try {
                h6.a(6, h6.a("Heartbeat failed", new Object[0]), th2);
            } finally {
                if (t.c.get()) {
                    t.b.postDelayed(this, 300000L);
                }
            }
        }
    }
}
