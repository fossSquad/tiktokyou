package X;

import com.windukk.hook.HookMethod;

class k9 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d7 d7VarA = d7.a();
        if (d7VarA == null || !d7VarA.i) {
            return;
        }
        hookMethodParam.setResult(Boolean.TRUE);
    }
}
