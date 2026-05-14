package X;

import com.windukk.hook.HookMethod;

class i5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().h) {
            int iIntValue = ((Integer) hookMethodParam.args[0]).intValue();
            if (iIntValue == 3 || iIntValue == 4) {
                hookMethodParam.args[0] = 0;
            }
        }
    }
}
