package Z;

import android.view.View;
import android.view.ViewGroup;
import com.windukk.hook.HookMethod;

class f extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        View view = (View) hookMethodParam.thisObject;
        n.a(view.getContext());
        int id = view.getId();
        int i = n.j;
        if (i != -1 && id == i) {
            n.b(view);
            return;
        }
        if (id == -1 || id == 0) {
            return;
        }
        for (int i2 = 0; i2 < n.g; i2++) {
            if (n.f[i2] == id) {
                m mVarD = n.d(view);
                if (mVarD == null) {
                    return;
                }
                if ((id == -1 || id == 0 || !(id == n.h || id == n.i)) && !n.c(view)) {
                    n.a(view, mVarD);
                    if (mVarD.h) {
                        n.a(view, mVarD, false);
                        return;
                    }
                    return;
                }
                mVarD.g = true;
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        n.b(viewGroup.getChildAt(i3), mVarD);
                    }
                    return;
                }
                return;
            }
        }
    }
}
