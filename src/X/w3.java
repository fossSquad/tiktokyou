package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class w3 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (i4.a()) {
            Object result = hookMethodParam.getResult();
            if (result instanceof List) {
                try {
                    hookMethodParam.setResult(i4.a((List) result));
                } catch (Throwable th) {
                }
            }
        }
    }
}
