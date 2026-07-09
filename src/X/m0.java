package X;

import com.windukk.hook.HookMethod;

class m0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (hookMethodParam.args.length >= 2) {
            Object result = hookMethodParam.getResult();
            if (result instanceof String) {
                String str = (String) result;
                Object obj = hookMethodParam.args[0];
                hookMethodParam.setResult(d1.a(obj instanceof String ? (String) obj : null, str));
            }
        }
    }
}
