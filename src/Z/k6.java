package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.MandatoryLoginHooks;

public class k6 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = MandatoryLoginHooks.d;
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
            Typeface typefaceA = MandatoryLoginHooks.a(((Integer) hookMethodParam.args[1]).intValue(), strF);
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            MandatoryLoginHooks.d.set(Boolean.FALSE);
        }
    }
}
