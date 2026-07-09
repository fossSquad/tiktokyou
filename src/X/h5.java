package X;

import com.ss.android.ugc.aweme.services.MandatoryLoginService;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.reflect.Method;

public abstract class h5 {
    public static void a() {
        try {
            Class cls = Long.TYPE;
            Method declaredMethod = MandatoryLoginService.class.getDeclaredMethod("checkDynamicMandatoryLoginRegionSettings", String.class, String.class, cls);
            Boolean bool = Boolean.FALSE;
            HookBridge.hookMethod(declaredMethod, ReplaceMethod.returnConstant(bool));
            HookBridge.hookMethod(MandatoryLoginService.class.getDeclaredMethod("checkForceLoginForBR", String.class, cls), ReplaceMethod.returnConstant(bool));
            Class cls2 = Boolean.TYPE;
            HookBridge.hookMethod(MandatoryLoginService.class.getDeclaredMethod("enableForcedLogin", cls2), ReplaceMethod.returnConstant(bool));
            HookBridge.hookMethod(MandatoryLoginService.class.getDeclaredMethod("shouldShowForcedLogin", cls2), ReplaceMethod.returnConstant(bool));
            HookBridge.hookMethod(MandatoryLoginService.class.getDeclaredMethod("shouldShowLoginTabFirst", null), ReplaceMethod.returnConstant(bool));
        } catch (Exception e) {
            int i = g5.a;
        }
    }
}
