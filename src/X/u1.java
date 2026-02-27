package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class u1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (r0.a().c()) {
            Object[] objArr = methodHookParam.args;
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (!(obj instanceof Integer) || (iA = y2.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                ArrayList arrayList = q0.a;
                methodHookParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
