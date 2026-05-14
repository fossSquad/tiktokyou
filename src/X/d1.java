package X;

import com.windukk.hook.HookMethod;

class d1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (Boolean.TRUE.equals(hookMethodParam.getResult())) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        boolean zA = false;
        Object obj = (objArr == null || objArr.length <= 0) ? null : objArr[0];
        if (obj != null) {
            try {
                zA = h1.a(e4.a(obj.getClass(), "getCommonModel", new Class[0]).invoke(obj, null));
            } catch (Throwable th) {
            }
        }
        if (zA) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
