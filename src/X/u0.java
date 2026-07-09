package X;

import com.ss.android.ugc.profile.platform.base.data.UserProfileInfo;
import com.windukk.hook.HookMethod;

class u0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(d1.a(((UserProfileInfo) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
