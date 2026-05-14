package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMConversation;
import com.windukk.hook.HookMethod;

class p extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(t0.a(t0.a((IMConversation) hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
    }
}
