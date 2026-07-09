package X;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

class z4 extends ReplaceMethod {
    @Override
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        return l8.a().h ? Boolean.FALSE : Boolean.TRUE;
    }
}
