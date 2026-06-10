package X;

import com.windukk.hook.HookMethod;

class c2 extends HookMethod {
    final  String a;

    public c2(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        v2.a(hookMethodParam.getResult(), this.a);
    }
}
