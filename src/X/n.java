package X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

public class n extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Handler handler = m.a;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        m.b(applicationContext);
        if (!y3.a().k) {
            m.a(applicationContext);
            m.b.set(false);
            m.a.removeCallbacks(m.d);
            return;
        }
        m.c(applicationContext);
        if (m.b.compareAndSet(false, true)) {
            Handler handler2 = m.a;
            h hVar = m.d;
            handler2.removeCallbacks(hVar);
            handler2.postDelayed(hVar, 300000L);
        }
        m.d(applicationContext, "alarm");
    }
}
