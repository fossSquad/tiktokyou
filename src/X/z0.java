package X;

import com.windukk.hook.HookMethod;

class z0 extends HookMethod {
    final  int a;

    public z0(int i) {
        this.a = i;
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d1.a(hookMethodParam, this.a);
    }
}
