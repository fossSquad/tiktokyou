package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class w4 extends HookMethod {

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int style;
        Typeface typefaceA;
        ThreadLocal threadLocal = x4.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = l8.a().i;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Object[] objArr = hookMethodParam.args;
            Typeface typeface = (Typeface) objArr[0];
            if (objArr.length < 2) {
                if (typeface != null) {
                    style = typeface.getStyle();
                } else {
                    style = 0;
                }
                typefaceA = x4.a(str, style);
                if (typefaceA != null) {
                    hookMethodParam.args[0] = typefaceA;
                }
            }
            style = ((Integer) objArr[1]).intValue();
            typefaceA = x4.a(str, style);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            x4.d.set(Boolean.FALSE);
        }
    }
}
