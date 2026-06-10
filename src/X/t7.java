package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class t7 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        String aid;
        if (Boolean.TRUE.equals(y7.l.get())) {
            return;
        }
        Object result = hookMethodParam.getResult();
        if (!(result instanceof Number) || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            y7.b(aweme);
            String str = y7.h;
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
            if (str == null || !str.equals(aid)) {
                float fFloatValue = ((Number) result).floatValue();
                float f = y7.f;
                if (!y7.a(f) && y7.a(fFloatValue) && y7.a(aweme)) {
                    hookMethodParam.setResult(Float.valueOf(f));
                }
            }
        }
    }
}
