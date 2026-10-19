package Z;

import android.view.View;
import com.windukk.hook.HookMethod;

class w2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        y2 y2Var = (y2) z2.a.get();
        if (y2Var == null) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        try {
            z2.a((View) hookMethodParam.thisObject, (objArr == null || objArr.length <= 0) ? null : objArr[0], y2Var);
        } catch (Throwable th) {
            String strDecrypt = "Exception during addButton";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
