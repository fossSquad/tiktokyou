package Z;

import com.windukk.hook.HookMethod;

class p2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        Boolean bool = Boolean.TRUE;
        if (bool.equals(result)) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        if (u2.a((objArr == null || objArr.length <= 0) ? null : objArr[0])) {
            hookMethodParam.setResult(bool);
        }
    }
}
