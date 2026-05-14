package X;

import android.net.Uri;
import com.windukk.hook.HookMethod;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;

class l2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        OutputStream outputStream;
        try {
            Uri uri = (Uri) hookMethodParam.args[0];
            if (uri != null) {
                if (!((ConcurrentHashMap.KeySetView) o2.a).remove(uri.toString()) || (outputStream = (OutputStream) hookMethodParam.getResult()) == null) {
                    return;
                }
                hookMethodParam.setResult(new n2(outputStream));
                int i = v3.a;
            }
        } catch (Exception e) {
            e.getMessage();
            int i2 = v3.a;
        }
    }
}
