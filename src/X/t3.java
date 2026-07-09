package X;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

class t3 extends ReplaceMethod {
    @Override
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        return 2;
    }
}
