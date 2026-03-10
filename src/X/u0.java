package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class u0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = w0.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = i1.a().g;
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
            Typeface typefaceA = w0.a(str, i);
            if (typefaceA != null) {
                methodHookParam.setResult(typefaceA);
            }
        } finally {
            w0.d.set(Boolean.FALSE);
        }
    }
}
