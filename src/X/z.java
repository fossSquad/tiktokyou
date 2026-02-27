package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class z extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r0.a().d) {
            methodHookParam.args[0] = new ArrayList();
        }
    }
}
