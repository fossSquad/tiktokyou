package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class r3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        objArr[0] = z3.a((List) objArr[0]);
    }
}
