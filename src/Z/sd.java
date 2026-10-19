package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class sd extends HookMethod {

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        if (Boolean.TRUE.equals(yd.l.get())) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length <= 3) {
            str = null;
        } else {
            Object obj = objArr[3];
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = null;
            }
        }
        if (yd.a(str)) {
            return;
        }
        if ((!"long_press".equals(str) && !"click_share_button".equals(str) && !"swipe_up_lock_persist".equals(str)) || "long_press".equals(str) || "click_share_button".equals(str)) {
            return;
        }
        float f = yd.f;
        yd.b(f);
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        String str;
        Aweme aweme;
        if (Boolean.TRUE.equals(yd.l.get()) || (objArr = hookMethodParam.args) == null || objArr.length < 4) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Number) {
            float fFloatValue = ((Number) obj).floatValue();
            if (Float.isNaN(fFloatValue) || fFloatValue < 0.1f || fFloatValue > 8.0f) {
                return;
            }
            Object[] objArr2 = hookMethodParam.args;
            String aid = null;
            if (objArr2 == null || objArr2.length <= 3) {
                str = null;
            } else {
                Object obj2 = objArr2[3];
                if (obj2 instanceof String) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
            }
            if (yd.a(str)) {
                Object[] objArr3 = hookMethodParam.args;
                if (objArr3 == null || objArr3.length <= 1) {
                    aweme = null;
                } else {
                    Object obj3 = objArr3[1];
                    if (obj3 instanceof Aweme) {
                        aweme = (Aweme) obj3;
                    } else {
                        aweme = null;
                    }
                }
                if (aweme != null) {
                    try {
                        aid = aweme.getAid();
                    } catch (Throwable th) {
                    }
                }
                yd.h = aid;
                yd.i = fFloatValue;
                yd.j = System.currentTimeMillis();
                return;
            }
            if ("long_press".equals(str) || "click_share_button".equals(str)) {
                if (yd.h != null || yd.j != 0) {
                    yd.h = null;
                    yd.i = 1.0f;
                    yd.j = 0L;
                }
                yd.f = fFloatValue;
                yd.b(fFloatValue);
            }
        }
    }
}
