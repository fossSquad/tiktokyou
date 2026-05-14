package X;

import com.ss.android.ugc.profile.platform.base.data.UserProfileInfo;
import com.windukk.hook.HookMethod;

class b0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(t0.a(((UserProfileInfo) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
