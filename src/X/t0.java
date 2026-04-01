package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.Collections;

class t0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (t1.a().d) {
            methodHookParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
