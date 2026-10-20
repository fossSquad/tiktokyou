package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class vd extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String aid;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            String str = ob.a.c[0];
            yd.b(aweme);
            String str2 = yd.h;
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
            if (str2 == null || !str2.equals(aid)) {
                float f = yd.f;
                if (yd.a(f) || !yd.a(aweme)) {
                    return;
                }
                Boolean bool = Boolean.TRUE;
                rd rdVar = yd.l;
                if (bool.equals(rdVar.get())) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - yd.g < 150) {
                    return;
                }
                rdVar.set(bool);
                try {
                    yd.b.invoke(null, Float.valueOf(f), aweme, "ttmod_restore_" + str, "swipe_up_lock_persist");
                    yd.g = jCurrentTimeMillis;
                    rdVar.set(Boolean.FALSE);
                } catch (Throwable th2) {
                    try {
                        String strDecrypt = "Restore failed";
                        Object obj2 = g7.a;
                        g7.a(6, String.valueOf(strDecrypt), th2);
                    } finally {
                        yd.l.set(Boolean.FALSE);
                    }
                }
            }
        }
    }
}
