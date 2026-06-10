package X;

import com.windukk.hook.HookMethod;

class eb extends HookMethod {
    final  Class a;
    final  Class b;

    public eb(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length < 2 || !this.a.isInstance(objArr[1])) {
            return;
        }
        try {
            ib.a(hookMethodParam, this.b);
        } catch (Throwable th) {
            if (ib.c) {
                return;
            }
            ib.c = true;
            th.getMessage();
            int i = p4.a;
        }
    }
}
