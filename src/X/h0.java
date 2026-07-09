package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMConversation;
import com.windukk.hook.HookMethod;

class h0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(d1.a(d1.a((IMConversation) hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
    }
}
