package X;

import com.windukk.hook.HookMethod;

class r1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (Boolean.TRUE.equals(hookMethodParam.getResult())) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        boolean zA = false;
        Object obj = (objArr == null || objArr.length <= 0) ? null : objArr[0];
        if (obj != null) {
            try {
                zA = v1.a(g8.a(obj.getClass(), "getCommonModel", new Class[0]).invoke(obj, null));
            } catch (Throwable th) {
            }
        }
        if (zA) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
