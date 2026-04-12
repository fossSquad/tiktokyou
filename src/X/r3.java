package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.Collections;

class r3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (s2.a().d) {
            methodHookParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
