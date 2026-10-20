package Z;
import com.windukk.hook.HookMethod;

class qc extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object objInvoke = yc.b.invoke(null, null);
            if (objInvoke == null) {
                return;
            }
            if (yc.c == null) {
                yc.c = se.a(objInvoke.getClass(), "getInt", String.class, Integer.TYPE);
            }
            Integer num = (Integer) yc.d.invoke(null, null);
            num.intValue();
            Integer num2 = (Integer) yc.c.invoke(objInvoke, "keva_cache_count", num);
            num2.intValue();
            hookMethodParam.setResult(num2);
        } catch (Throwable th) {
            String strDecrypt = "Cache-count restore (runtime) error: ";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
