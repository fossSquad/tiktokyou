package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class f2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = h2.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = r2.a().g;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            int i = 1;
            int iIntValue = ((Integer) methodHookParam.args[1]).intValue();
            boolean zBooleanValue = ((Boolean) methodHookParam.args[2]).booleanValue();
            if (iIntValue >= 600 && zBooleanValue) {
                i = 3;
            } else if (iIntValue < 600) {
                i = zBooleanValue ? 2 : 0;
            }
            Typeface typefaceA = h2.a(str, i);
            if (typefaceA != null) {
                methodHookParam.setResult(typefaceA);
            }
        } finally {
            h2.d.set(Boolean.FALSE);
        }
    }
}
