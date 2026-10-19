package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class j6 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = n6.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        ac.a().getClass();
        String strF = ac.f();
        if ("default".equals(strF)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typefaceA = n6.a(((Integer) hookMethodParam.args[1]).intValue(), strF);
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            n6.d.set(Boolean.FALSE);
        }
    }
}
