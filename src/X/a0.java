package X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

public class a0 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Handler handler = z.a;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        z.b(applicationContext);
        if (!l8.a().n) {
            z.a(applicationContext);
            z.b.set(false);
            z.a.removeCallbacks(z.e);
            return;
        }
        z.c(applicationContext);
        if (z.b.compareAndSet(false, true)) {
            Handler handler2 = z.a;
            y yVar = z.e;
            handler2.removeCallbacks(yVar);
            handler2.postDelayed(yVar, 300000L);
        }
        z.c(applicationContext, "alarm");
    }
}
