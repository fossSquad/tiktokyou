package Z;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class h5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            hookMethodParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
