package Z;

import com.ss.android.ugc.profile.platform.base.data.UserProfileInfo;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class c1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(BadgeHooks.a(((UserProfileInfo) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
