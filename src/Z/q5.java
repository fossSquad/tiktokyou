package Z;

import com.windukk.hook.HookMethod;
import java.util.List;

public class q5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 2) {
            Object obj = objArr[1];
            if (obj instanceof List) {
                objArr[1] = m5.a((List) obj, true);
            }
        }
    }
}
