package Z;

import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class g1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        BadgeHooks.a(hookMethodParam, 0);
    }
}
