package X;

import com.windukk.hook.HookMethod;

class ua extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        l8.a().getClass();
        hookMethodParam.setResult(l8.a().b().e);
    }
}
