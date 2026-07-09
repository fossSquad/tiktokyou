package X;

import com.windukk.hook.HookMethod;

class mb extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        l8 l8VarA = l8.a();
        if (l8VarA == null || !l8VarA.j || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
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
