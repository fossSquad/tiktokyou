package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class i4 extends HookMethod {
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
            int i = 1;
            int iIntValue = ((Integer) hookMethodParam.args[1]).intValue();
            boolean zBooleanValue = ((Boolean) hookMethodParam.args[2]).booleanValue();
            if (iIntValue >= 600 && zBooleanValue) {
                i = 3;
            } else if (iIntValue < 600) {
                i = zBooleanValue ? 2 : 0;
            }
            Typeface typefaceA = k4.a(str, i);
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            k4.d.set(Boolean.FALSE);
        }
    }
}
