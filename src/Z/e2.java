package Z;

import com.windukk.hook.HookMethod;

class e2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        Boolean bool = Boolean.TRUE;
        if (bool.equals(result)) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        if (j2.a((objArr == null || objArr.length <= 0) ? null : objArr[0])) {
            hookMethodParam.setResult(bool);
        }
    }
}
