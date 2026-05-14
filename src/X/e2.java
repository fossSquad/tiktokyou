package X;

import com.windukk.hook.HookMethod;

class e2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 2) {
            Object obj = objArr[1];
            if ((obj instanceof String) && "android_id".equals((String) obj)) {
                h2.a(hookMethodParam.getResult(), "Settings.Secure.android_id");
            }
        }
    }
}
