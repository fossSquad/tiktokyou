package X;

import com.windukk.hook.HookMethod;

class p7 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        if (!Boolean.TRUE.equals(q7.b.get()) || (objArr = hookMethodParam.args) == null || objArr.length == 0 || !q7.a(objArr[0])) {
            return;
        }
        hookMethodParam.setResult((Object) null);
        int i = p4.a;
    }
}
