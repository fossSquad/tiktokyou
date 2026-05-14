package X;

import com.windukk.hook.HookMethod;

class n1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                if (h2.c(str)) {
                    h2.a(hookMethodParam.getResult(), "AppLog.headerValue.".concat(str));
                }
            }
        }
    }
}
