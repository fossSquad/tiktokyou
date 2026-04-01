package X;

import de.robv.android.xposed.XC_MethodHook;

class t extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object result = methodHookParam.getResult();
        Boolean bool = Boolean.TRUE;
        if (bool.equals(result)) {
            return;
        }
        Object[] objArr = methodHookParam.args;
        if (y.a((objArr == null || objArr.length <= 0) ? null : objArr[0])) {
            methodHookParam.setResult(bool);
        }
    }
}
