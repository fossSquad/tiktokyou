package Z;

import com.windukk.hook.HookMethod;

class d6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue = ((Integer) hookMethodParam.args[0]).intValue();
        int iIntValue2 = ((Integer) hookMethodParam.args[1]).intValue() & (-8193);
        hookMethodParam.args[0] = Integer.valueOf(iIntValue & (-8193));
        hookMethodParam.args[1] = Integer.valueOf(iIntValue2);
    }
}
