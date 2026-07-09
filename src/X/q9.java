package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class q9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        String aid;
        if (Boolean.TRUE.equals(v9.l.get())) {
            return;
        }
        Object result = hookMethodParam.getResult();
        if (!(result instanceof Number) || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            v9.b(aweme);
            String str = v9.h;
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
            if (str == null || !str.equals(aid)) {
                float fFloatValue = ((Number) result).floatValue();
                float f = v9.f;
                if (!v9.a(f) && v9.a(fFloatValue) && v9.a(aweme)) {
                    hookMethodParam.setResult(Float.valueOf(f));
                }
            }
        }
    }
}
