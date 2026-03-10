package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class w1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (i1.a().a) {
            methodHookParam.setResult(new ArrayList());
        }
    }
}
