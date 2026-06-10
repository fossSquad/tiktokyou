package X;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class t3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            hookMethodParam.args[0] = Collections.EMPTY_LIST;
        }
    }
}
