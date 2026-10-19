package Z;

import android.content.Context;
import android.os.Handler;
import com.windukk.mod.Main;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;

public final class a0 implements Runnable {
    @Override
    public final void run() {
        Object obj;
        try {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Main.getApplicationContext());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Context context = (Context) obj;
            if (context == null) {
                if (b0.c.get()) {
                    b0.b.postDelayed(this, 300000L);
                    return;
                }
                return;
            }
            b0.a.getClass();
            if (ac.b == null) {
                Context applicationContext = context.getApplicationContext();
                ac.a(applicationContext);
            }
            ac.a.getClass();
            if (ac.e().t) {
                b0.a(context, "heartbeat");
                b0.b(context);
                if (b0.c.get()) {
                    b0.b.postDelayed(this, 300000L);
                    return;
                }
                return;
            }
            b0.a(context);
            AtomicBoolean atomicBoolean = b0.c;
            atomicBoolean.set(false);
            Handler handler = b0.b;
            handler.removeCallbacks(b0.g);
            if (atomicBoolean.get()) {
                handler.postDelayed(this, 300000L);
            }
        } catch (Throwable th2) {
            try {
                g7.a(6, g7.a("Heartbeat failed", new Object[0]), th2);
            } finally {
                if (b0.c.get()) {
                    b0.b.postDelayed(this, 300000L);
                }
            }
        }
    }
}
