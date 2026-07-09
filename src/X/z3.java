package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class z3 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(i4.a((List) hookMethodParam.getResult()));
    }
}
