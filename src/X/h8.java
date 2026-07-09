package X;

import com.windukk.hook.HookMethod;

class h8 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d1.g();
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d1.x.getAndIncrement() == 0) {
            int i = g5.a;
        }
    }
}
