package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.List;

class q0 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object[] objArr = methodHookParam.args;
        objArr[0] = y0.a((List) objArr[0]);
    }
}
