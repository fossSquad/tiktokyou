package X;

import android.view.View;
import android.view.ViewGroup;
import com.windukk.hook.HookMethod;

class n extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        View view = (View) hookMethodParam.thisObject;
        w.a(view.getContext());
        int id = view.getId();
        int i = w.j;
        if (i != -1 && id == i) {
            w.b(view);
            return;
        }
        if (id == -1 || id == 0) {
            return;
        }
        for (int i2 = 0; i2 < w.g; i2++) {
            if (w.f[i2] == id) {
                v vVarD = w.d(view);
                if (vVarD == null) {
                    return;
                }
                if ((id == -1 || id == 0 || !(id == w.h || id == w.i)) && !w.c(view)) {
                    w.a(vVarD, view);
                    if (vVarD.h) {
                        w.a(view, vVarD, false);
                        return;
                    }
                    return;
                }
                vVarD.g = true;
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        w.b(vVarD, viewGroup.getChildAt(i3));
                    }
                    return;
                }
                return;
            }
        }
    }
}
