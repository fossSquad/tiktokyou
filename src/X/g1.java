package X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

public class g1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Handler handler = y.a;
            if (context == null) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            y.b(applicationContext);
            if (!d7.a().m) {
                y.a(applicationContext);
                y.b.set(false);
                y.a.removeCallbacks(y.e);
                return;
            }
            y.c(applicationContext);
            if (y.b.compareAndSet(false, true)) {
                Handler handler2 = y.a;
                x xVar = y.e;
                handler2.removeCallbacks(xVar);
                handler2.postDelayed(xVar, 300000L);
            }
            y.c(applicationContext, "boot");
        }
    }
}
