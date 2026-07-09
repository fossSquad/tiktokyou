package X;

import com.windukk.hook.HookMethod;

class cd extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (l8.a().d()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (!(obj instanceof Integer) || (iA = hd.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                hookMethodParam.args[1] = Integer.valueOf(iA);
            }
        }
    }
}
