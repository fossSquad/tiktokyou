package Z;

import com.windukk.hook.HookMethod;
import java.util.List;

class e5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        objArr[0] = a.a((List) objArr[0]);
    }
}
