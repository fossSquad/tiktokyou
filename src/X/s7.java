package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class s7 extends HookMethod {

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        if (Boolean.TRUE.equals(y7.l.get())) {
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
        if (!"swipe_up_lock_persist".equals(str)) {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!"com.ss.android.ugc.aweme.feed.longvideo.edgespeedup.EdgeSpeedupAssem".equals(stackTraceElement.getClassName())) {
                }
            }
            if ((!"long_press".equals(str) && !"click_share_button".equals(str) && !"swipe_up_lock_persist".equals(str)) || "long_press".equals(str) || "click_share_button".equals(str)) {
                return;
            }
            y7.b(y7.f);
            int i = p4.a;
            return;
        }
        int i2 = p4.a;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        String str;
        Aweme aweme;
        if (Boolean.TRUE.equals(y7.l.get()) || (objArr = hookMethodParam.args) == null || objArr.length < 4) {
            return;
        }
        int i = 0;
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
            if (!"swipe_up_lock_persist".equals(str)) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        if ("long_press".equals(str) || "click_share_button".equals(str)) {
                            if (y7.h != null || y7.j != 0) {
                                y7.h = null;
                                y7.i = 1.0f;
                                y7.j = 0L;
                                int i2 = p4.a;
                            }
                            y7.f = fFloatValue;
                            y7.b(fFloatValue);
                            int i3 = p4.a;
                            return;
                        }
                        return;
                    }
                    if ("com.ss.android.ugc.aweme.feed.longvideo.edgespeedup.EdgeSpeedupAssem".equals(stackTrace[i].getClassName())) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
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
            y7.h = aid;
            y7.i = fFloatValue;
            y7.j = System.currentTimeMillis();
            int i4 = p4.a;
        }
    }
}
