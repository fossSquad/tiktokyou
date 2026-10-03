package Z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class u1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Context applicationContext;
        if (intent != null && "android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            t tVar = t.a;
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                return;
            }
            t tVar2 = t.a;
            String strDecrypt = "boot";
            tVar2.getClass();
            t.a(applicationContext, strDecrypt, 20000L);
        }
    }
}
