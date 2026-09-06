package Z;

import com.ss.android.ugc.aweme.story.feed.immersive.digg.ImmersiveStoryDiggAssem;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.StoryEngagementHooks;

class ue extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr != null && objArr.length >= 3) {
                Object obj = objArr[1];
                if (obj instanceof ImmersiveStoryDiggAssem) {
                    StoryEngagementHooks.a((ImmersiveStoryDiggAssem) obj, objArr[2]);
                }
            }
        } catch (Throwable th) {
            String strDecrypt = "Story digg count update failed";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
