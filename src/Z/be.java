package Z;

import android.view.View;
import com.ss.android.ugc.profile.platform.business.header.assemble.ProfileHeaderBaseComponent;
import com.windukk.hook.HookMethod;

class be extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        try {
            if (!(hookMethodParam.thisObject instanceof ProfileHeaderBaseComponent) || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
                return;
            }
            Object obj = objArr[0];
            if (obj instanceof View) {
                fe.b((View) obj);
            }
        } catch (Throwable th) {
            String strDecrypt = "Attach failed";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
