package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.Collections;

class q3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            methodHookParam.setResult(Collections.EMPTY_LIST);
        }
    }
}
