package X;

import com.windukk.hook.HookMethod;

class v0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = d1.u;
        int iMax = Math.max(0, ((Integer) threadLocal.get()).intValue() - 1);
        if (iMax != 0) {
            threadLocal.set(Integer.valueOf(iMax));
        } else {
            d1.t.remove();
            threadLocal.remove();
        }
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = d1.u;
        threadLocal.set(Integer.valueOf(((Integer) threadLocal.get()).intValue() + 1));
        w9 w9VarA = d1.a(hookMethodParam.thisObject);
        if (w9VarA != null) {
            d1.t.set(w9VarA);
        }
    }
}
