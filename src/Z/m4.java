package Z;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

class m4 extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        return 3;
    }
}
