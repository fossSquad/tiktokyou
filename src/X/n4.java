package X;

import com.windukk.hook.HookMethod;

class n4 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue = ((Integer) hookMethodParam.args[0]).intValue();
        int iIntValue2 = ((Integer) hookMethodParam.args[1]).intValue() & (-8193);
        hookMethodParam.args[0] = Integer.valueOf(iIntValue & (-8193));
        hookMethodParam.args[1] = Integer.valueOf(iIntValue2);
    }
}
