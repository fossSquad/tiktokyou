package Z;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMConversation;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class q0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(BadgeHooks.a(BadgeHooks.a((IMConversation) hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
    }
}
