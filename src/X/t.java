package X;

import com.windukk.hook.HookMethod;

class t extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (hookMethodParam.args.length >= 2) {
            Object result = hookMethodParam.getResult();
            if (result instanceof String) {
                String str = (String) result;
                Object obj = hookMethodParam.args[0];
                hookMethodParam.setResult(t0.a(obj instanceof String ? (String) obj : null, str));
            }
        }
    }
}
