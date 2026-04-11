package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class t2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        String str = (String) methodHookParam.args[0];
        if (str == null || !str.contains("watermark")) {
            return;
        }
        methodHookParam.args[0] = str.replace("watermark", "origin").replaceAll("q[0-9]{1,3}", "q100").replaceAll("shrink:[0-9]+:[0-9]+", "shrink:0:0");
        ArrayList arrayList = p2.a;
    }
}
