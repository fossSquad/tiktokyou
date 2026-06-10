package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class v7 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String aid;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            String str = t6.a.c[0];
            y7.b(aweme);
            String str2 = y7.h;
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
            if (str2 == null || !str2.equals(aid)) {
                float f = y7.f;
                if (y7.a(f) || !y7.a(aweme)) {
                    return;
                }
                Boolean bool = Boolean.TRUE;
                r7 r7Var = y7.l;
                if (bool.equals(r7Var.get())) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - y7.g < 150) {
                    return;
                }
                r7Var.set(bool);
                try {
                    y7.b.invoke(null, Float.valueOf(f), aweme, "ttmod_restore_" + str, "swipe_up_lock_persist");
                    y7.g = jCurrentTimeMillis;
                    int i = p4.a;
                    r7Var.set(Boolean.FALSE);
                } catch (Throwable th2) {
                    try {
                        int i2 = p4.a;
                    } finally {
                        y7.l.set(Boolean.FALSE);
                    }
                }
            }
        }
    }
}
