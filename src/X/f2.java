package X;

import com.windukk.hook.HookMethod;

class f2 extends HookMethod {
    final  String a;

    public f2(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        h2.a(hookMethodParam.getResult(), this.a);
    }
}
