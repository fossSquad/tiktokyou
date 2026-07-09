package X;

import com.windukk.hook.HookMethod;

class lb extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        l8 l8VarA = l8.a();
        if (l8VarA == null || !l8VarA.j) {
            return;
        }
        hookMethodParam.setResult(Boolean.TRUE);
    }
}
