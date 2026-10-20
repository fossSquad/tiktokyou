package Z;

import com.windukk.hook.HookMethod;

class o1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ae aeVar = (ae) v1.u.get();
        if (aeVar != null) {
            Object result = hookMethodParam.getResult();
            if (result instanceof String) {
                String str = (String) result;
                if (v1.a(aeVar, str)) {
                    hookMethodParam.setResult(v1.a(aeVar.a, str));
                }
            }
        }
    }
}
