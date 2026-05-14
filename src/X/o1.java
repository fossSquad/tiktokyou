package X;

import com.windukk.hook.HookMethod;

class o1 extends HookMethod {
    final  String a;

    public o1(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        h2.a(hookMethodParam.getResult(), this.a);
    }
}
