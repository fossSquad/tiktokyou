package X;

import com.windukk.hook.HookMethod;

class n4 extends HookMethod {
    final  String a;

    public n4(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.thisObject;
    }
}
