package X;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class b5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().d) {
            hookMethodParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
