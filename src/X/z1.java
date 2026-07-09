package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Method;

class z1 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d2.a.remove();
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        Object obj = (objArr == null || objArr.length <= 1) ? null : objArr[1];
        ThreadLocal threadLocal = d2.a;
        c2 c2Var = new c2();
        if (obj != null) {
            try {
                Object objB = d2.b(obj);
                if (objB != null) {
                    Method method = objB.getClass().getMethod("getName", null);
                    method.setAccessible(true);
                    Object objInvoke = method.invoke(objB, null);
                    c2Var.b = objInvoke == null ? null : objInvoke.toString();
                    Method method2 = objB.getClass().getMethod("getAnimateUrl", null);
                    method2.setAccessible(true);
                    Object objInvoke2 = method2.invoke(objB, null);
                    if (objInvoke2 == null) {
                        Method method3 = objB.getClass().getMethod("getStaticUrl", null);
                        method3.setAccessible(true);
                        objInvoke2 = method3.invoke(objB, null);
                    }
                    if (objInvoke2 != null) {
                        Method method4 = objInvoke2.getClass().getMethod("getHighResolutionUrl", null);
                        method4.setAccessible(true);
                        Object objInvoke3 = method4.invoke(objInvoke2, null);
                        if (d2.a(objInvoke3) == null) {
                            Method method5 = objInvoke2.getClass().getMethod("getMidResolutionUrl", null);
                            method5.setAccessible(true);
                            objInvoke3 = method5.invoke(objInvoke2, null);
                        }
                        if (d2.a(objInvoke3) == null) {
                            Method method6 = objInvoke2.getClass().getMethod("getLowResolutionUrl", null);
                            method6.setAccessible(true);
                            objInvoke3 = method6.invoke(objInvoke2, null);
                        }
                        c2Var.a = objInvoke3;
                    }
                }
            } catch (Throwable th) {
                String.valueOf(th);
                int i = g5.a;
            }
        }
        threadLocal.set(c2Var);
    }
}
