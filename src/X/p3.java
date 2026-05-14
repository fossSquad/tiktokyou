package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class p3 extends HookMethod {
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
            int i = 1;
            int iIntValue = ((Integer) hookMethodParam.args[1]).intValue();
            boolean zBooleanValue = ((Boolean) hookMethodParam.args[2]).booleanValue();
            if (iIntValue >= 600 && zBooleanValue) {
                i = 3;
            } else if (iIntValue < 600) {
                i = zBooleanValue ? 2 : 0;
            }
            Typeface typefaceA = r3.a(str, i);
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            r3.d.set(Boolean.FALSE);
        }
    }
}
