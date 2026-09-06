package Z;

import android.widget.TextView;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeStatistics;
import com.ss.android.ugc.aweme.feed.model.VideoItemParams;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.StoryEngagementHooks;
import java.util.Map;

class we extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        AwemeStatistics statistics;
        String strA;
        try {
            VideoItemParams videoItemParams = (VideoItemParams) hookMethodParam.args[0];
            if (videoItemParams == null) {
                return;
            }
            Map map = StoryEngagementHooks.a;
            Aweme aweme = videoItemParams.getAweme();
            long shareCount = (aweme == null || (statistics = aweme.getStatistics()) == null) ? 0L : statistics.getShareCount();
            if (shareCount < 1000) {
                strA = Long.toString(Math.max(0L, shareCount));
            } else if (shareCount < 1000000) {
                strA = StoryEngagementHooks.a(shareCount, 1000L, "K");
            } else {
                strA = shareCount < 1000000000 ? StoryEngagementHooks.a(shareCount, 1000000L, "M") : StoryEngagementHooks.a(shareCount, 1000000000L, "B");
            }
            StoryEngagementHooks.d.put(hookMethodParam.thisObject, strA);
            StoryEngagementHooks.b((TextView) StoryEngagementHooks.b.get(hookMethodParam.thisObject), strA);
        } catch (Throwable th) {
            String strDecrypt = "Story share count update failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
