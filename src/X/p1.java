package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.List;

class p1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object[] objArr = methodHookParam.args;
        objArr[0] = x1.a((List) objArr[0]);
    }
}
