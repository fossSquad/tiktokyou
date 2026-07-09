package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class a4 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        objArr[0] = i4.a((List) objArr[0]);
    }
}
