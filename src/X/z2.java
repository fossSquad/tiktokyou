package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class z2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(g3.a((List) hookMethodParam.getResult()));
    }
}
