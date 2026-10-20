package Z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class e2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Context applicationContext;
        if (intent != null && "android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            b0 b0Var = b0.a;
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                return;
            }
            b0 b0Var2 = b0.a;
            String strDecrypt = "boot";
            b0Var2.getClass();
            b0.a(applicationContext, strDecrypt, 20000L);
        }
    }
}
