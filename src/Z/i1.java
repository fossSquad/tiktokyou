package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class i1 extends HookMethod {
    final  int a;

    public i1(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        BadgeHooks.a(hookMethodParam, this.a);
    }
}
