package X;

import android.view.View;
import com.ss.android.ugc.profile.platform.business.header.assemble.ProfileHeaderBaseComponent;
import com.windukk.hook.HookMethod;

class x9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        try {
            if (!(hookMethodParam.thisObject instanceof ProfileHeaderBaseComponent) || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
                return;
            }
            Object obj = objArr[0];
            if (obj instanceof View) {
                aa.b((View) obj);
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = g5.a;
        }
    }
}
