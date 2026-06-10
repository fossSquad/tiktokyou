package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMConversation;
import com.windukk.hook.HookMethod;

class f0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(a1.a(a1.a((IMConversation) hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
    }
}
