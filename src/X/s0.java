package X;

import de.robv.android.xposed.XC_MethodHook;

class s0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (Boolean.TRUE.equals(methodHookParam.getResult())) {
            return;
        }
        Object[] objArr = methodHookParam.args;
        boolean zA = false;
        Object obj = (objArr == null || objArr.length <= 0) ? null : objArr[0];
        if (obj != null) {
            try {
                zA = w0.a(obj.getClass().getMethod("getCommonModel", null).invoke(obj, null));
            } catch (Throwable th) {
            }
        }
        if (zA) {
            methodHookParam.setResult(Boolean.TRUE);
        }
    }
}
