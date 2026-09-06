package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.ThemeHooks;

class nf extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Integer num;
        int iA;
        if (!ta.a().f() || (num = (Integer) hookMethodParam.getResult()) == null || (iA = ThemeHooks.a(num.intValue())) == num.intValue()) {
            return;
        }
        hookMethodParam.setResult(Integer.valueOf(iA));
    }
}
