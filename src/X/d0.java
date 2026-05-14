package X;

import com.windukk.hook.HookMethod;

class d0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        q0 q0Var = (q0) t0.o.get();
        if (q0Var != null) {
            Object result = hookMethodParam.getResult();
            if (result instanceof String) {
                hookMethodParam.setResult(t0.a(q0Var.a, (String) result));
            }
        }
    }
}
