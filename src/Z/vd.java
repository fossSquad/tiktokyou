package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.SearchHooks;

public class vd extends HookMethod {
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
            SearchHooks.b(aweme);
            String str2 = SearchHooks.h;
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
            if (str2 == null || !str2.equals(aid)) {
                float f = SearchHooks.f;
                if (SearchHooks.a(f) || !SearchHooks.a(aweme)) {
                    return;
                }
                Boolean bool = Boolean.TRUE;
                rd rdVar = SearchHooks.l;
                if (bool.equals(rdVar.get())) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - SearchHooks.g < 150) {
                    return;
                }
                rdVar.set(bool);
                try {
                    SearchHooks.b.invoke(null, Float.valueOf(f), aweme, "ttmod_restore_" + str, "swipe_up_lock_persist");
                    SearchHooks.g = jCurrentTimeMillis;
                    rdVar.set(Boolean.FALSE);
                } catch (Throwable th2) {
                    try {
                        String strDecrypt = "Restore failed";
                        Object obj2 = g7.a;
                        g7.a(6, String.valueOf(strDecrypt), th2);
                    } finally {
                        SearchHooks.l.set(Boolean.FALSE);
                    }
                }
            }
        }
    }
}
