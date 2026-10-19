package Z;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class jf extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            hookMethodParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
