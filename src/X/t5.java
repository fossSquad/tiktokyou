package X;

import com.windukk.hook.HookMethod;

class t5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (y3.a().d()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (!(obj instanceof Integer) || (iA = x6.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                int i = v3.a;
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
