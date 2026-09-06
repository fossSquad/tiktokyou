package Z;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class u4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d5.a().d) {
            hookMethodParam.args[0] = Collections.EMPTY_LIST;
        }
    }
}
