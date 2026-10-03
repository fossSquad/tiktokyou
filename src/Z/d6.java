package Z;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

class d6 extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        return d5.a().i ? Boolean.FALSE : Boolean.TRUE;
    }
}
