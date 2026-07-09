package X;

import android.view.View;
import com.windukk.hook.HookMethod;

class a2 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        c2 c2Var = (c2) d2.a.get();
        if (c2Var == null) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        try {
            d2.a((View) hookMethodParam.thisObject, (objArr == null || objArr.length <= 0) ? null : objArr[0], c2Var);
        } catch (Throwable th) {
            String.valueOf(th);
            int i = g5.a;
        }
    }
}
