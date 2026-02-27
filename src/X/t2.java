package X;

import de.robv.android.xposed.XC_MethodHook;

class t2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (r0.a().c()) {
            Object[] objArr = methodHookParam.args;
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (!(obj instanceof Integer) || (iA = y2.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                methodHookParam.args[1] = Integer.valueOf(iA);
            }
        }
    }
}
