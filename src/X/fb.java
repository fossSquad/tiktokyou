package X;

import com.windukk.hook.HookMethod;

class fb extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length <= 0 || !ib.a(objArr[0])) {
            return;
        }
        hookMethodParam.setResult(-100);
    }
}
