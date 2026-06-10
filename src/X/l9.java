package X;

import com.windukk.hook.HookMethod;

class l9 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        d7 d7VarA = d7.a();
        if (d7VarA == null || !d7VarA.i || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Number) {
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue == 3 || iIntValue == 4) {
                hookMethodParam.args[0] = 0;
            }
        }
    }
}
