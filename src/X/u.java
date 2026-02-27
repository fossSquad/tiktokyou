package X;

import android.net.Uri;
import de.robv.android.xposed.XC_MethodHook;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class u extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        OutputStream outputStream;
        try {
            Uri uri = (Uri) methodHookParam.args[0];
            if (uri != null) {
                if (!((ConcurrentHashMap.KeySetView) w.a).remove(uri.toString()) || (outputStream = (OutputStream) methodHookParam.getResult()) == null) {
                    return;
                }
                methodHookParam.setResult(new v(outputStream));
                ArrayList arrayList = q0.a;
            }
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = q0.a;
        }
    }
}
