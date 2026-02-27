package X;

import android.app.Activity;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class q1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        try {
            ((Activity) methodHookParam.thisObject).finish();
            ArrayList arrayList = q0.a;
        } catch (Exception e) {
            new StringBuilder("Failed to finish splash activity: ").append(e.getMessage());
            ArrayList arrayList2 = q0.a;
        }
    }
}
