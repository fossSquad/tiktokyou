package X;

import com.windukk.hook.HookMethod;

class u0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        z7 z7Var = (z7) a1.r.get();
        if (z7Var != null) {
            Object result = hookMethodParam.getResult();
            if (result instanceof String) {
                hookMethodParam.setResult(a1.a(z7Var.a, (String) result));
            }
        }
    }
}
