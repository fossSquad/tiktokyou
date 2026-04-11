package X;

import com.ss.android.ugc.aweme.profile.model.User;
import de.robv.android.xposed.XC_MethodHook;

class s extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.setResult(k0.a(((User) methodHookParam.thisObject).getUid(), (String) methodHookParam.getResult()));
    }
}
