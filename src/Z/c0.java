package Z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class c0 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Context applicationContext;
        b0 b0Var = b0.a;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        b0 b0Var2 = b0.a;
        String strDecrypt = "alarm";
        b0Var2.getClass();
        b0.a(applicationContext, strDecrypt, 20000L);
    }
}
