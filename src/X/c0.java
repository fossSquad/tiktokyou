package X;

import com.windukk.hook.HookMethod;

class c0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = t0.p;
        int iMax = Math.max(0, ((Integer) threadLocal.get()).intValue() - 1);
        if (iMax != 0) {
            threadLocal.set(Integer.valueOf(iMax));
        } else {
            t0.o.remove();
            threadLocal.remove();
        }
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = t0.p;
        threadLocal.set(Integer.valueOf(((Integer) threadLocal.get()).intValue() + 1));
        q0 q0VarC = t0.c(hookMethodParam.thisObject);
        if (q0VarC != null) {
            t0.o.set(q0VarC);
        }
    }
}
