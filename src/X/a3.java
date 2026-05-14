package X;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class a3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().d) {
            hookMethodParam.args[0] = Collections.EMPTY_LIST;
        }
    }
}
