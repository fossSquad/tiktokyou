package X;

import com.windukk.hook.HookMethod;

class g0 extends HookMethod {
    final  int a;

    public g0(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        t0.a(hookMethodParam, this.a);
    }
}
