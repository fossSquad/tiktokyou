package X;

import com.windukk.hook.HookMethod;

class y9 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (d7.a().d()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (!(obj instanceof Integer) || (iA = cb.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                int i = p4.a;
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
