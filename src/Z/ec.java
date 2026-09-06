package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.EdgeSpeedupHooks;

class ec extends HookMethod {

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        if (Boolean.TRUE.equals(EdgeSpeedupHooks.l.get())) {
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
        if (EdgeSpeedupHooks.a(str)) {
            return;
        }
        if ((!"long_press".equals(str) && !"click_share_button".equals(str) && !"swipe_up_lock_persist".equals(str)) || "long_press".equals(str) || "click_share_button".equals(str)) {
            return;
        }
        float f = EdgeSpeedupHooks.f;
        EdgeSpeedupHooks.b(f);
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        String str;
        Aweme aweme;
        if (Boolean.TRUE.equals(EdgeSpeedupHooks.l.get()) || (objArr = hookMethodParam.args) == null || objArr.length < 4) {
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
            if (EdgeSpeedupHooks.a(str)) {
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
                EdgeSpeedupHooks.h = aid;
                EdgeSpeedupHooks.i = fFloatValue;
                EdgeSpeedupHooks.j = System.currentTimeMillis();
                return;
            }
            if ("long_press".equals(str) || "click_share_button".equals(str)) {
                if (EdgeSpeedupHooks.h != null || EdgeSpeedupHooks.j != 0) {
                    EdgeSpeedupHooks.h = null;
                    EdgeSpeedupHooks.i = 1.0f;
                    EdgeSpeedupHooks.j = 0L;
                }
                EdgeSpeedupHooks.f = fFloatValue;
                EdgeSpeedupHooks.b(fFloatValue);
            }
        }
    }
}
