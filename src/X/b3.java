package X;

import android.net.Uri;
import com.windukk.hook.HookMethod;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;

class b3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        OutputStream outputStream;
        try {
            Uri uri = (Uri) hookMethodParam.args[0];
            if (uri != null) {
                if (((ConcurrentHashMap.KeySetView) d3.a).remove(uri.toString()) && (outputStream = (OutputStream) hookMethodParam.getResult()) != null) {
                    hookMethodParam.setResult(new c3(outputStream));
                    int i = p4.a;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            int i2 = p4.a;
        }
    }
}
