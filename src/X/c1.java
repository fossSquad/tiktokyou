package X;

import com.windukk.hook.HookMethod;

class c1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        Boolean bool = Boolean.TRUE;
        if (bool.equals(result)) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        if (h1.a((objArr == null || objArr.length <= 0) ? null : objArr[0])) {
            hookMethodParam.setResult(bool);
        }
    }
}
