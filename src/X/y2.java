package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class y2 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        objArr[0] = g3.a((List) objArr[0]);
    }
}
