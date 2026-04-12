package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class e2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = i2.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = s2.a().g;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typefaceA = i2.a(str, ((Integer) methodHookParam.args[1]).intValue());
            if (typefaceA != null) {
                methodHookParam.setResult(typefaceA);
            }
        } finally {
            i2.d.set(Boolean.FALSE);
        }
    }
}
