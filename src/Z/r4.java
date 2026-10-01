package Z;

import com.windukk.hook.HookMethod;
import Z.FeedHooks;
import java.util.List;

class r4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(FeedHooks.a((List) hookMethodParam.getResult()));
    }
}
