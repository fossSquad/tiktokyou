package X;

import android.view.View;
import com.windukk.hook.HookMethod;

class m extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        v vVarD;
        View view = (View) hookMethodParam.args[0];
        w.a(view.getContext());
        if (w.g == 0 || (vVarD = w.d(view)) == null) {
            return;
        }
        w.b(vVarD, true);
        w.a(vVarD, 300L, false);
        w.a(vVarD, 1000L, false);
    }
}
