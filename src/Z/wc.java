package Z;

import com.windukk.hook.HookMethod;

abstract class wc extends HookMethod {
    private wc() {
    }

    public abstract int a(xc xcVar);

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        xc xcVar;
        Object obj = hookMethodParam.thisObject;
        if ((obj instanceof Enum) && (xcVar = (xc) yc.a.get(((Enum) obj).name())) != null) {
            hookMethodParam.setResult(Integer.valueOf(a(xcVar)));
        }
    }
}
