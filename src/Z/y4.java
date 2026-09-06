package Z;

import com.windukk.hook.HookMethod;

class y4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d5.a().d) {
            hookMethodParam.setResult(0);
        }
    }
}
