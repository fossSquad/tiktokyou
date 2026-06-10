package X;

import com.windukk.hook.HookMethod;

class g2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                if (v2.a(str)) {
                    v2.a(hookMethodParam.getResult(), "prefs.".concat(str));
                }
            }
        }
    }
}
