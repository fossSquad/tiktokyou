package Z;

import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class d1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = BadgeHooks.v;
        int iMax = Math.max(0, ((Integer) threadLocal.get()).intValue() - 1);
        if (iMax != 0) {
            threadLocal.set(Integer.valueOf(iMax));
        } else {
            BadgeHooks.u.remove();
            threadLocal.remove();
        }
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = BadgeHooks.v;
        threadLocal.set(Integer.valueOf(((Integer) threadLocal.get()).intValue() + 1));
        lc lcVarA = BadgeHooks.a(hookMethodParam.thisObject);
        if (lcVarA != null) {
            BadgeHooks.u.set(lcVarA);
        }
    }
}
