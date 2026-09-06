package Z;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

class l4 extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) throws Throwable {
        return 2;
    }
}
