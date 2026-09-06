package Z;
import com.windukk.hook.HookMethod;

class f2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (Boolean.TRUE.equals(hookMethodParam.getResult())) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        boolean zA = false;
        Object obj = (objArr == null || objArr.length <= 0) ? null : objArr[0];
        if (obj != null) {
            try {
                zA = j2.a(dd.a(obj.getClass(), "getCommonModel", new Class[0]).invoke(obj, null));
            } catch (Throwable th) {
            }
        }
        if (zA) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
