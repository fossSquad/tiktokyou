package Z;

import com.ss.android.ugc.aweme.im.common.model.BaseContact;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class o0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(BadgeHooks.a(((BaseContact) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
