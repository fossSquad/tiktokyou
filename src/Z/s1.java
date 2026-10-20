package Z;

import com.windukk.hook.HookMethod;

class s1 extends HookMethod {
    final  int a;

    public s1(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        v1.a(hookMethodParam, this.a);
    }
}
