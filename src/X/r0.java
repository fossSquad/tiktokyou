package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.List;

class r0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.setResult(y0.a((List) methodHookParam.getResult()));
    }
}
