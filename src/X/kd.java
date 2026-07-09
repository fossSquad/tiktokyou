package X;

import com.windukk.hook.HookMethod;

class kd extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length <= 0 || !nd.a(objArr[0])) {
            return;
        }
        hookMethodParam.setResult(-100);
    }
}
