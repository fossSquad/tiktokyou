package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class u2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (g3.a()) {
            Object result = hookMethodParam.getResult();
            if (result instanceof List) {
                try {
                    hookMethodParam.setResult(g3.a((List) result));
                } catch (Throwable th) {
                }
            }
        }
    }
}
