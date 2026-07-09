package X;

import com.windukk.hook.HookMethod;

class b5 extends HookMethod {
    final  String a;

    public b5(String str) {
        this.a = str;
    }

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.thisObject;
    }
}
