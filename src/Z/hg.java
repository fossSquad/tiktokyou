package Z;

import com.ss.android.ugc.aweme.story.feed.immersive.digg.ImmersiveStoryDiggAssem;
import com.windukk.hook.HookMethod;

class hg extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr != null && objArr.length >= 3) {
                Object obj = objArr[1];
                if (obj instanceof ImmersiveStoryDiggAssem) {
                    kg.a((ImmersiveStoryDiggAssem) obj, objArr[2]);
                }
            }
        } catch (Throwable th) {
            String strDecrypt = "Story digg count update failed";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
