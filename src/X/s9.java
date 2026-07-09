package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class s9 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String aid;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            String str = w7.a.c[0];
            v9.b(aweme);
            String str2 = v9.h;
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
            if (str2 == null || !str2.equals(aid)) {
                float f = v9.f;
                if (v9.a(f) || !v9.a(aweme)) {
                    return;
                }
                Boolean bool = Boolean.TRUE;
                o9 o9Var = v9.l;
                if (bool.equals(o9Var.get())) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - v9.g < 150) {
                    return;
                }
                o9Var.set(bool);
                try {
                    v9.b.invoke(null, Float.valueOf(f), aweme, "ttmod_restore_" + str, "swipe_up_lock_persist");
                    v9.g = jCurrentTimeMillis;
                    int i = g5.a;
                    o9Var.set(Boolean.FALSE);
                } catch (Throwable th2) {
                    try {
                        int i2 = g5.a;
                    } finally {
                        v9.l.set(Boolean.FALSE);
                    }
                }
            }
        }
    }
}
