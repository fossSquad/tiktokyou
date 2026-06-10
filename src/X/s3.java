package X;

import com.windukk.hook.HookMethod;
import java.util.List;

class s3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(z3.a((List) hookMethodParam.getResult()));
    }
}
