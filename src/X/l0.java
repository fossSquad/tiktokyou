package X;

import com.windukk.hook.HookMethod;

class l0 extends HookMethod {
    final  o1 a;
    final  o5 b;

    public l0(o1 o1Var, o5 o5Var) {
        this.a = o1Var;
        this.b = o5Var;
    }

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (hookMethodParam.getResult() instanceof String) {
            try {
                hookMethodParam.setResult(d1.a(this.a.b(hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
            } catch (Exception e) {
                String str = this.b.b;
                e.getMessage();
                int i = g5.a;
            }
        }
    }
}
