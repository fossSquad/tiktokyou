package Z;

import com.windukk.hook.HookMethod;
import Z.FeedHooks;
import java.util.List;

class o4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (FeedHooks.a()) {
            Object result = hookMethodParam.getResult();
            if (result instanceof List) {
                try {
                    hookMethodParam.setResult(FeedHooks.a((List) result));
                } catch (Throwable th) {
                }
            }
        }
    }
}
