package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class y extends XC_MethodHook {
    final  g0 a;
    final  String b;

    public y(g0 g0Var, String str) {
        this.a = g0Var;
        this.b = str;
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (methodHookParam.getResult() instanceof String) {
            try {
                methodHookParam.setResult(k0.a(this.a.b(methodHookParam.thisObject), (String) methodHookParam.getResult()));
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList = q2.a;
            }
        }
    }
}
