package Z;

import android.view.View;
import com.windukk.hook.HookMethod;

class d extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        if (n.j == -1 || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
            return;
        }
        Object obj = hookMethodParam.thisObject;
        if ((obj instanceof View) && ((View) obj).getId() == n.j) {
            if (ta.a() == null || ta.d().g) {
                Object obj2 = hookMethodParam.args[0];
                if (!(obj2 instanceof Integer) || ((Integer) obj2).intValue() == 0) {
                    return;
                }
                hookMethodParam.args[0] = 0;
            }
        }
    }
}
