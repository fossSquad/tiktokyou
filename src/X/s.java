package X;

import com.windukk.hook.HookMethod;

class s extends HookMethod {
    final  p0 a;
    final  String b;

    public s(p0 p0Var, String str) {
        this.a = p0Var;
        this.b = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (hookMethodParam.getResult() instanceof String) {
            try {
                hookMethodParam.setResult(t0.a(this.a.b(hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
            } catch (Exception e) {
                e.getMessage();
                int i = v3.a;
            }
        }
    }
}
