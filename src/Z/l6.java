package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.MandatoryLoginHooks;

public class l6 extends HookMethod {
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
            int i = 1;
            int iIntValue = ((Integer) hookMethodParam.args[1]).intValue();
            boolean zBooleanValue = ((Boolean) hookMethodParam.args[2]).booleanValue();
            if (iIntValue >= 600 && zBooleanValue) {
                i = 3;
            } else if (iIntValue < 600) {
                i = zBooleanValue ? 2 : 0;
            }
            Typeface typefaceA = MandatoryLoginHooks.a(i, strF);
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            MandatoryLoginHooks.d.set(Boolean.FALSE);
        }
    }
}
