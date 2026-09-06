package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.FeedHooks;
import java.util.List;

class s4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        objArr[0] = FeedHooks.a((List) objArr[0]);
    }
}
