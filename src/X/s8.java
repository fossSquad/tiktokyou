package X;

import com.windukk.hook.HookMethod;

class s8 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        objArr[0] = Boolean.FALSE;
    }
}
