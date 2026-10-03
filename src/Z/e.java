package Z;

import android.view.View;
import com.windukk.hook.HookMethod;

class e extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        m mVarD;
        View view = (View) hookMethodParam.args[0];
        n.a(view.getContext());
        if (n.g == 0 || (mVarD = n.d(view)) == null) {
            return;
        }
        n.b(mVarD, true);
        n.a(mVarD, 300L, false);
        n.a(mVarD, 1000L, false);
    }
}
