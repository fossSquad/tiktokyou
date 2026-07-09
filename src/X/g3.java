package X;

import com.windukk.hook.HookMethod;

class g3 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Class cls;
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr != null && objArr.length == 1 && (cls = h3.s) != null && cls.isInstance(objArr[0])) {
                Object[] objArr2 = hookMethodParam.args;
                if (h3.a(hookMethodParam.method, objArr2[0], objArr2)) {
                    hookMethodParam.setResult(null);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = g5.a;
        }
    }
}
