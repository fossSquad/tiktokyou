package Z;

import Z.h6;

import com.ss.android.ugc.aweme.services.MandatoryLoginService;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.reflect.Method;

public abstract class MandatoryLoginHooks {
    public static void a() {
        try {
            String strDecrypt = "checkDynamicMandatoryLoginRegionSettings";
            Class cls = Long.TYPE;
            Method declaredMethod = MandatoryLoginService.class.getDeclaredMethod(strDecrypt, String.class, String.class, cls);
            Boolean bool = Boolean.FALSE;
            HookBridge.hookMethod(declaredMethod, ReplaceMethod.returnConstant(bool));
            HookBridge.hookMethod(MandatoryLoginService.class.getDeclaredMethod("checkForceLoginForBR", String.class, cls), ReplaceMethod.returnConstant(bool));
            String strDecrypt2 = "enableForcedLogin";
            Class cls2 = Boolean.TYPE;
            HookBridge.hookMethod(MandatoryLoginService.class.getDeclaredMethod(strDecrypt2, cls2), ReplaceMethod.returnConstant(bool));
            HookBridge.hookMethod(MandatoryLoginService.class.getDeclaredMethod("shouldShowForcedLogin", cls2), ReplaceMethod.returnConstant(bool));
            HookBridge.hookMethod(MandatoryLoginService.class.getDeclaredMethod("shouldShowLoginTabFirst", null), ReplaceMethod.returnConstant(bool));
        } catch (Exception e) {
            String strDecrypt3 = "MandatoryHooks init exception";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt3), e);
        }
    }
}
