package X;

import com.windukk.hook.HookMethod;

class ta extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        l8.a().getClass();
        hookMethodParam.setResult(l8.a().b().e);
    }
}
