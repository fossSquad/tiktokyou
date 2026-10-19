package Z;

import com.windukk.hook.HookMethod;

class th extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (ac.a().g()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer) || (iA = zh.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                return;
            }
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
