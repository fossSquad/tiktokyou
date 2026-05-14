package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class m3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = r3.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = y3.a().g;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typefaceA = r3.a(str);
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            r3.d.set(Boolean.FALSE);
        }
    }
}
