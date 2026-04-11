package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.List;

class p1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.setResult(w1.a((List) methodHookParam.getResult()));
    }
}
