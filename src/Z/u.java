package Z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class u extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Context applicationContext;
        t tVar = t.a;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        t tVar2 = t.a;
        String strDecrypt = "alarm";
        tVar2.getClass();
        t.a(applicationContext, strDecrypt, 20000L);
    }
}
