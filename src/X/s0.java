package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.Collections;

class s0 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (t1.a().d) {
            methodHookParam.args[0] = Collections.EMPTY_LIST;
        }
    }
}
