package Z;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.OfflineModeHooks;

class cb extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object objInvoke = OfflineModeHooks.b.invoke(null, null);
            if (objInvoke == null) {
                return;
            }
            if (OfflineModeHooks.c == null) {
                OfflineModeHooks.c = dd.a(objInvoke.getClass(), "getInt", String.class, Integer.TYPE);
            }
            Integer num = (Integer) OfflineModeHooks.d.invoke(null, null);
            num.intValue();
            Integer num2 = (Integer) OfflineModeHooks.c.invoke(objInvoke, "keva_cache_count", num);
            num2.intValue();
            hookMethodParam.setResult(num2);
        } catch (Throwable th) {
            String strDecrypt = "Cache-count restore (runtime) error: ";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
