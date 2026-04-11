package X;

import de.robv.android.xposed.XC_MethodHook;

class q0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object result = methodHookParam.getResult();
        Boolean bool = Boolean.TRUE;
        if (bool.equals(result)) {
            return;
        }
        Object[] objArr = methodHookParam.args;
        if (v0.a((objArr == null || objArr.length <= 0) ? null : objArr[0])) {
            methodHookParam.setResult(bool);
        }
    }
}
