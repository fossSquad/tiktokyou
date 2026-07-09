package X;

import android.view.View;
import com.windukk.hook.HookMethod;

class n extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        if (x.j == -1 || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
            return;
        }
        Object obj = hookMethodParam.thisObject;
        if ((obj instanceof View) && ((View) obj).getId() == x.j) {
            l8 l8VarA = l8.a();
            if (l8VarA == null || l8VarA.f) {
                Object obj2 = hookMethodParam.args[0];
                if (!(obj2 instanceof Integer) || ((Integer) obj2).intValue() == 0) {
                    return;
                }
                hookMethodParam.args[0] = 0;
            }
        }
    }
}
