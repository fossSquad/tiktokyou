package X;

import de.robv.android.xposed.XC_MethodHook;

class z extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (methodHookParam.args.length >= 2) {
            Object result = methodHookParam.getResult();
            if (result instanceof String) {
                String str = (String) result;
                Object obj = methodHookParam.args[0];
                methodHookParam.setResult(k0.a(obj instanceof String ? (String) obj : null, str));
            }
        }
    }
}
