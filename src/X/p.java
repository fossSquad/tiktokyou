package X;

import android.view.View;
import android.view.ViewGroup;
import com.windukk.hook.HookMethod;

class p extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        View view = (View) hookMethodParam.thisObject;
        x.a(view.getContext());
        int id = view.getId();
        int i = x.j;
        if (i != -1 && id == i) {
            x.b(view);
            return;
        }
        if (id == -1 || id == 0) {
            return;
        }
        for (int i2 = 0; i2 < x.g; i2++) {
            if (x.f[i2] == id) {
                w wVarD = x.d(view);
                if (wVarD == null) {
                    return;
                }
                if ((id == -1 || id == 0 || !(id == x.h || id == x.i)) && !x.c(view)) {
                    x.a(wVarD, view);
                    if (wVarD.h) {
                        x.a(view, wVarD, false);
                        return;
                    }
                    return;
                }
                wVarD.g = true;
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        x.b(wVarD, viewGroup.getChildAt(i3));
                    }
                    return;
                }
                return;
            }
        }
    }
}
