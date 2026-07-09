package X;

import com.windukk.hook.HookMethod;

class w0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        w9 w9Var = (w9) d1.t.get();
        if (w9Var != null) {
            Object result = hookMethodParam.getResult();
            if (result instanceof String) {
                hookMethodParam.setResult(d1.a(w9Var.a, (String) result));
            }
        }
    }
}
