package X;

import com.ss.android.ugc.aweme.im.common.model.BaseContact;
import de.robv.android.xposed.XC_MethodHook;

class t extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.setResult(k0.a(((BaseContact) methodHookParam.thisObject).getUid(), (String) methodHookParam.getResult()));
    }
}
