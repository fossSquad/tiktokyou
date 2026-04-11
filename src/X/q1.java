package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.Collections;

class q1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            methodHookParam.args[0] = Collections.EMPTY_LIST;
        }
    }
}
