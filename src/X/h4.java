package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class h4 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (s2.a().d()) {
            Object[] objArr = methodHookParam.args;
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (!(obj instanceof Integer) || (iA = l5.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                ArrayList arrayList = q2.a;
                methodHookParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
