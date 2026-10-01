package Z;

import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class h1 extends HookMethod {
    final  int a;

    public h1(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        BadgeHooks.a(hookMethodParam, this.a);
    }
}
