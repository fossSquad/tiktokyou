package X;

import com.windukk.hook.HookMethod;

class b3 extends HookMethod {
    final  String a;

    public b3(String str) {
        this.a = str;
    }

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d3.a(hookMethodParam.getResult(), this.a);
    }
}
