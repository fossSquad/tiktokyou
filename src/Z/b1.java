package Z;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMConversation;
import com.windukk.hook.HookMethod;

class b1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(v1.a(v1.a((IMConversation) hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
    }
}
