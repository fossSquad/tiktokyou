package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class k0 extends XC_MethodHook {

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int style;
        Typeface typefaceA;
        ThreadLocal threadLocal = m0.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = r0.a().g;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Object[] objArr = methodHookParam.args;
            Typeface typeface = (Typeface) objArr[0];
            if (objArr.length < 2) {
                if (typeface != null) {
                    style = typeface.getStyle();
                } else {
                    style = 0;
                }
                typefaceA = m0.a(str, style);
                if (typefaceA != null) {
                    methodHookParam.args[0] = typefaceA;
                }
            }
            style = ((Integer) objArr[1]).intValue();
            typefaceA = m0.a(str, style);
            if (typefaceA != null) {
                methodHookParam.args[0] = typefaceA;
            }
        } finally {
            m0.d.set(Boolean.FALSE);
        }
    }
}
