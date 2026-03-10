package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class r0 extends XC_MethodHook {
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
            Typeface typefaceA = w0.a(str);
            if (typefaceA != null) {
                methodHookParam.setResult(typefaceA);
            }
        } finally {
            w0.d.set(Boolean.FALSE);
        }
    }
}
