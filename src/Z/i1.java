package Z;

import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class i1 extends HookMethod {
    final  int a;

    public i1(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        BadgeHooks.a(hookMethodParam, this.a);
    }
}
