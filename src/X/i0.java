package X;

import com.windukk.hook.HookMethod;

class i0 extends HookMethod {
    final  l1 a;
    final  x4 b;

    public i0(l1 l1Var, x4 x4Var) {
        this.a = l1Var;
        this.b = x4Var;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (hookMethodParam.getResult() instanceof String) {
            try {
                hookMethodParam.setResult(a1.a(this.a.b(hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
            } catch (Exception e) {
                String str = this.b.b;
                e.getMessage();
                int i = p4.a;
            }
        }
    }
}
