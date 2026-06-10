package X;

import com.windukk.hook.HookMethod;

class t2 extends HookMethod {
    final  String a;

    public t2(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        v2.a(hookMethodParam.getResult(), this.a);
    }
}
