package Z;

import com.windukk.hook.HookMethod;
import java.util.List;
import java.util.Map;

class o5 extends HookMethod {
    final  boolean a;

    public o5(boolean z) {
        this.a = z;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        boolean zA;
        if (hookMethodParam.args[0] instanceof List) {
            if (this.a) {
                s5.b(hookMethodParam.thisObject);
            }
            if (this.a) {
                zA = s5.a(hookMethodParam.thisObject);
            } else {
                Object obj = hookMethodParam.thisObject;
                if (obj == null) {
                    Map map = s5.a;
                    zA = false;
                } else {
                    Boolean bool = (Boolean) s5.a.get(obj);
                    zA = bool != null && bool.booleanValue();
                }
            }
            Object[] objArr = hookMethodParam.args;
            objArr[0] = m5.a((List) objArr[0], zA);
        }
    }
}
