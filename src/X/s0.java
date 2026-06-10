package X;

import com.ss.android.ugc.profile.platform.base.data.UserProfileInfo;
import com.windukk.hook.HookMethod;

class s0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(a1.a(((UserProfileInfo) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
