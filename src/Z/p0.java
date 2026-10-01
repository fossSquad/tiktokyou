package Z;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class p0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(BadgeHooks.a(((IMUser) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
