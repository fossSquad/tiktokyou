package X;

import com.windukk.hook.HookMethod;

class k2 extends HookMethod {
    final  String a;

    public k2(String str) {
        this.a = str;
    }

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d3.a(hookMethodParam.getResult(), this.a);
    }
}
