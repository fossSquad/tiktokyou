package X;

import android.view.View;
import com.windukk.hook.HookMethod;

class o extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        w wVarD;
        View view = (View) hookMethodParam.args[0];
        x.a(view.getContext());
        if (x.g == 0 || (wVarD = x.d(view)) == null) {
            return;
        }
        x.b(wVarD, true);
        x.a(wVarD, 300L, false);
        x.a(wVarD, 1000L, false);
    }
}
