package Z;

import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class y0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(BadgeHooks.a(((User) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
