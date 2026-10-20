package Z;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class g5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            hookMethodParam.args[0] = Collections.EMPTY_LIST;
        }
    }
}
