package X;

import com.windukk.hook.HookMethod;

class oa extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        l8.a().getClass();
        hookMethodParam.setResult(Boolean.TRUE);
    }
}
