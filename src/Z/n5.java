package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.FontHooks;

public class n5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        FontHooks.b(hookMethodParam.thisObject);
    }
}
