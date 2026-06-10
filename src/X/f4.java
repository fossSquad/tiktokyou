package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class f4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = k4.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = d7.a().h;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typefaceA = k4.a(str);
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            k4.d.set(Boolean.FALSE);
        }
    }
}
