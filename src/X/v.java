package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMConversation;
import de.robv.android.xposed.XC_MethodHook;

class v extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.setResult(k0.a(k0.a((IMConversation) methodHookParam.thisObject), (String) methodHookParam.getResult()));
    }
}
