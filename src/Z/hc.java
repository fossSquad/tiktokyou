package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.EdgeSpeedupHooks;

class hc extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String aid;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            String str = ga.a.c[0];
            EdgeSpeedupHooks.b(aweme);
            String str2 = EdgeSpeedupHooks.h;
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
            if (str2 == null || !str2.equals(aid)) {
                float f = EdgeSpeedupHooks.f;
                if (EdgeSpeedupHooks.a(f) || !EdgeSpeedupHooks.a(aweme)) {
                    return;
                }
                Boolean bool = Boolean.TRUE;
                dc dcVar = EdgeSpeedupHooks.l;
                if (bool.equals(dcVar.get())) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - EdgeSpeedupHooks.g < 150) {
                    return;
                }
                dcVar.set(bool);
                try {
                    EdgeSpeedupHooks.b.invoke(null, Float.valueOf(f), aweme, "ttmod_restore_" + str, "swipe_up_lock_persist");
                    EdgeSpeedupHooks.g = jCurrentTimeMillis;
                    dcVar.set(Boolean.FALSE);
                } catch (Throwable th2) {
                    try {
                        String strDecrypt = "Restore failed";
                        Object obj2 = h6.a;
                        h6.a(6, String.valueOf(strDecrypt), th2);
                    } finally {
                        EdgeSpeedupHooks.l.set(Boolean.FALSE);
                    }
                }
            }
        }
    }
}
