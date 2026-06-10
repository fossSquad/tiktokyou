package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class n3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (z3.a()) {
            Object result = hookMethodParam.getResult();
            if (result instanceof List) {
                try {
                    hookMethodParam.setResult(z3.a((List) result));
                } catch (Throwable th) {
                }
            }
        }
    }
}
