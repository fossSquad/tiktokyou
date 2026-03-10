package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class e0 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (i1.a().d) {
            methodHookParam.args[0] = new ArrayList();
        }
    }
}
