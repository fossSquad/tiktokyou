package Z;

import com.windukk.hook.HookMethod;

class n1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = v1.v;
        int iMax = Math.max(0, ((Integer) threadLocal.get()).intValue() - 1);
        if (iMax != 0) {
            threadLocal.set(Integer.valueOf(iMax));
        } else {
            v1.u.remove();
            threadLocal.remove();
        }
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = v1.v;
        threadLocal.set(Integer.valueOf(((Integer) threadLocal.get()).intValue() + 1));
        ae aeVarA = v1.a(hookMethodParam.thisObject);
        if (aeVarA != null) {
            v1.u.set(aeVarA);
        }
    }
}
