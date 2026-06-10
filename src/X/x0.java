package X;

import com.windukk.hook.HookMethod;

class x0 extends HookMethod {
    final  int a;

    public x0(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        a1.a(hookMethodParam, this.a);
    }
}
