package X;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class e9 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            hookMethodParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
