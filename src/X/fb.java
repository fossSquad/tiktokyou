package X;

import com.windukk.hook.HookMethod;
import java.util.Collections;

class fb extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (l8.a().c) {
            hookMethodParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
