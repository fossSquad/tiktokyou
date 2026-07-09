package X;

import android.net.Uri;
import com.windukk.hook.HookMethod;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;

class j3 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        OutputStream outputStream;
        try {
            Uri uri = (Uri) hookMethodParam.args[0];
            if (uri != null) {
                if (((ConcurrentHashMap.KeySetView) l3.a).remove(uri.toString()) && (outputStream = (OutputStream) hookMethodParam.getResult()) != null) {
                    hookMethodParam.setResult(new k3(outputStream));
                    int i = g5.a;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            int i2 = g5.a;
        }
    }
}
