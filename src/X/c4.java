package X;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class c4 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (l8.a().c) {
            hookMethodParam.args[0] = Collections.EMPTY_LIST;
        }
    }
}
