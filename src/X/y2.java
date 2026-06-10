package X;

import com.windukk.hook.HookMethod;

class y2 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Class cls;
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr != null && objArr.length == 1 && (cls = z2.s) != null && cls.isInstance(objArr[0])) {
                Object[] objArr2 = hookMethodParam.args;
                if (z2.a(hookMethodParam.method, objArr2[0], objArr2)) {
                    hookMethodParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = p4.a;
        }
    }
}
