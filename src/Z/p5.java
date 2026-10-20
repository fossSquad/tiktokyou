package Z;

import com.windukk.hook.HookMethod;
import java.util.List;

class p5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        Object obj = objArr[0];
        if (obj instanceof List) {
            objArr[0] = m5.a((List) obj, true);
        }
    }
}
