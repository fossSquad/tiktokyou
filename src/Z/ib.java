package Z;

import com.windukk.hook.HookMethod;
import Z.OfflineModeHooks;

abstract class ib extends HookMethod {
    ib() {
    }

    public abstract int a(jb jbVar);

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        jb jbVar;
        Object obj = hookMethodParam.thisObject;
        if ((obj instanceof Enum) && (jbVar = (jb) OfflineModeHooks.a.get(((Enum) obj).name())) != null) {
            hookMethodParam.setResult(Integer.valueOf(a(jbVar)));
        }
    }
}
