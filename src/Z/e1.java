package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class e1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        lc lcVar = (lc) BadgeHooks.u.get();
        if (lcVar != null) {
            Object result = hookMethodParam.getResult();
            if (result instanceof String) {
                String str = (String) result;
                if (BadgeHooks.a(lcVar, str)) {
                    hookMethodParam.setResult(BadgeHooks.a(lcVar.a, str));
                }
            }
        }
    }
}
