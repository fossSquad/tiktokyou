package Z;

import com.windukk.hook.HookMethod;
import Z.FeedHooks;
import java.util.List;

class xg extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        Object obj = objArr[0];
        if (obj instanceof List) {
            objArr[0] = FeedHooks.a((List) obj);
        }
    }
}
