package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.SearchHooks;

public class sd extends HookMethod {

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        if (Boolean.TRUE.equals(SearchHooks.l.get())) {
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
        if (SearchHooks.a(str)) {
            return;
        }
        if ((!"long_press".equals(str) && !"click_share_button".equals(str) && !"swipe_up_lock_persist".equals(str)) || "long_press".equals(str) || "click_share_button".equals(str)) {
            return;
        }
        float f = SearchHooks.f;
        SearchHooks.b(f);
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        String str;
        Aweme aweme;
        if (Boolean.TRUE.equals(SearchHooks.l.get()) || (objArr = hookMethodParam.args) == null || objArr.length < 4) {
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
            if (SearchHooks.a(str)) {
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
                SearchHooks.h = aid;
                SearchHooks.i = fFloatValue;
                SearchHooks.j = System.currentTimeMillis();
                return;
            }
            if ("long_press".equals(str) || "click_share_button".equals(str)) {
                if (SearchHooks.h != null || SearchHooks.j != 0) {
                    SearchHooks.h = null;
                    SearchHooks.i = 1.0f;
                    SearchHooks.j = 0L;
                }
                SearchHooks.f = fFloatValue;
                SearchHooks.b(fFloatValue);
            }
        }
    }
}
