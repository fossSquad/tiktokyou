package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.FeedHooks;
import java.util.List;

class t4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(FeedHooks.a((List) hookMethodParam.getResult()));
    }
}
