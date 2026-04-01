package X;

import de.robv.android.xposed.XC_MethodHook;

class l3 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (t1.a().d()) {
            Object[] objArr = methodHookParam.args;
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (!(obj instanceof Integer) || (iA = j4.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                methodHookParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
