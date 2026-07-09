package X;

import com.windukk.hook.HookMethod;

class j2 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                if (d3.c(str)) {
                    d3.a(hookMethodParam.getResult(), "AppLog.headerValue.".concat(str));
                }
            }
        }
    }
}
