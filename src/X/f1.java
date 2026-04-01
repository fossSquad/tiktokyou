package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class f1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = j1.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = t1.a().g;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typefaceA = j1.a(str, ((Integer) methodHookParam.args[1]).intValue());
            if (typefaceA != null) {
                methodHookParam.setResult(typefaceA);
            }
        } finally {
            j1.d.set(Boolean.FALSE);
        }
    }
}
