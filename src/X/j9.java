package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class j9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr != null && objArr.length >= 4 && (objArr[0] instanceof Aweme) && (objArr[1] instanceof Integer) && !Boolean.TRUE.equals(objArr[3])) {
                Object[] objArr2 = hookMethodParam.args;
                String strA = n9.a((Aweme) objArr2[0], ((Integer) objArr2[1]).intValue());
                if (strA == null || strA.isEmpty() || strA.equals(hookMethodParam.getResult())) {
                    return;
                }
                int i = g5.a;
                hookMethodParam.setResult(strA);
            }
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }
}
