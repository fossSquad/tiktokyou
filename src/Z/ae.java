package Z;

import com.windukk.hook.HookMethod;

class ae extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        if (ta.a() == null || !ta.d().k || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
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
