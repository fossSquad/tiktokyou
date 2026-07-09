package X;

import com.windukk.hook.HookMethod;

class r8 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object objInvoke = z8.b.invoke(null, null);
            if (objInvoke == null) {
                return;
            }
            if (z8.c == null) {
                z8.c = ha.a(objInvoke.getClass(), "getInt", String.class, Integer.TYPE);
            }
            Integer num = (Integer) z8.d.invoke(null, null);
            num.intValue();
            Integer num2 = (Integer) z8.c.invoke(objInvoke, "keva_cache_count", num);
            num2.intValue();
            hookMethodParam.setResult(num2);
        } catch (Throwable th) {
            th.toString();
            int i = g5.a;
        }
    }
}
