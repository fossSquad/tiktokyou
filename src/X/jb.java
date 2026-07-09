package X;

import com.windukk.hook.HookMethod;

class jb extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (l8.a().c) {
            hookMethodParam.setResult(null);
        }
    }
}
