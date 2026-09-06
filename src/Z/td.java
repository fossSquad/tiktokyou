package Z;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class td extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d5.a().d) {
            hookMethodParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
