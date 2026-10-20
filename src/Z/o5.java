package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.FontHooks;
import java.util.List;
import java.util.Map;

public class o5 extends HookMethod {
    final  boolean a;

    public o5(boolean z) {
        this.a = z;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        boolean zA;
        if (hookMethodParam.args[0] instanceof List) {
            if (this.a) {
                FontHooks.b(hookMethodParam.thisObject);
            }
            if (this.a) {
                zA = FontHooks.a(hookMethodParam.thisObject);
            } else {
                Object obj = hookMethodParam.thisObject;
                if (obj == null) {
                    Map map = FontHooks.a;
                    zA = false;
                } else {
                    Boolean bool = (Boolean) FontHooks.a.get(obj);
                    zA = bool != null && bool.booleanValue();
                }
            }
            Object[] objArr = hookMethodParam.args;
            objArr[0] = m5.a((List) objArr[0], zA);
        }
    }
}
