package X;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

class x2 extends ReplaceMethod {
    @Override
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        return d3.d;
    }
}
