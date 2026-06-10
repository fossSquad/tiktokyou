package X;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

class l3 extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        return 2;
    }
}
