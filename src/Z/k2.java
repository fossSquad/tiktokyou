package Z;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.CommentStickerHooks;
import java.lang.reflect.Method;

class k2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        CommentStickerHooks.a.remove();
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        Object obj = (objArr == null || objArr.length <= 1) ? null : objArr[1];
        ThreadLocal threadLocal = CommentStickerHooks.a;
        n2 n2Var = new n2();
        if (obj != null) {
            try {
                Object objB = CommentStickerHooks.b(obj);
                if (objB != null) {
                    Method method = objB.getClass().getMethod("getName", null);
                    method.setAccessible(true);
                    Object objInvoke = method.invoke(objB, null);
                    n2Var.b = objInvoke == null ? null : objInvoke.toString();
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
                        if (CommentStickerHooks.a(objInvoke3) == null) {
                            Method method5 = objInvoke2.getClass().getMethod("getMidResolutionUrl", null);
                            method5.setAccessible(true);
                            objInvoke3 = method5.invoke(objInvoke2, null);
                        }
                        if (CommentStickerHooks.a(objInvoke3) == null) {
                            Method method6 = objInvoke2.getClass().getMethod("getLowResolutionUrl", null);
                            method6.setAccessible(true);
                            objInvoke3 = method6.invoke(objInvoke2, null);
                        }
                        n2Var.a = objInvoke3;
                    }
                }
            } catch (Throwable th) {
                String strDecrypt = "buildRef error";
                Object obj2 = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th);
            }
        }
        threadLocal.set(n2Var);
    }
}
