package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import de.robv.android.xposed.XC_MethodHook;

class u extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.setResult(k0.a(((IMUser) methodHookParam.thisObject).getUid(), (String) methodHookParam.getResult()));
    }
}
