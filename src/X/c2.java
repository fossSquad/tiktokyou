package X;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

class c2 extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        return h2.b;
    }
}
