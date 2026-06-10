package X;

import com.windukk.hook.HookMethod;

class t0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = a1.s;
        int iMax = Math.max(0, ((Integer) threadLocal.get()).intValue() - 1);
        if (iMax != 0) {
            threadLocal.set(Integer.valueOf(iMax));
        } else {
            a1.r.remove();
            threadLocal.remove();
        }
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = a1.s;
        threadLocal.set(Integer.valueOf(((Integer) threadLocal.get()).intValue() + 1));
        z7 z7VarA = a1.a(hookMethodParam.thisObject);
        if (z7VarA != null) {
            a1.r.set(z7VarA);
        }
    }
}
