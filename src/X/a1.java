package X;

import com.windukk.hook.HookMethod;

class a1 extends HookMethod {
    final  int a;

    public a1(int i) {
        this.a = i;
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d1.a(hookMethodParam, this.a);
    }
}
