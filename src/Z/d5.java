package Z;

import com.windukk.hook.HookMethod;
import java.util.List;

class d5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(a.a((List) hookMethodParam.getResult()));
    }
}
