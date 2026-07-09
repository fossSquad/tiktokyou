package X;

import com.windukk.hook.HookMethod;

class jd extends HookMethod {
    final  Class a;
    final  Class b;

    public jd(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length < 2 || !this.a.isInstance(objArr[1])) {
            return;
        }
        try {
            nd.a(hookMethodParam, this.b);
        } catch (Throwable th) {
            if (nd.c) {
                return;
            }
            nd.c = true;
            th.getMessage();
            int i = g5.a;
        }
    }
}
