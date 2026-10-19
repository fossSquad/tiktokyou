package Z;

import android.widget.TextView;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeStatistics;
import com.ss.android.ugc.aweme.feed.model.VideoItemParams;
import com.windukk.hook.HookMethod;
import java.util.Map;

class jg extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        AwemeStatistics statistics;
        String strA;
        try {
            VideoItemParams videoItemParams = (VideoItemParams) hookMethodParam.args[0];
            if (videoItemParams == null) {
                return;
            }
            Map map = kg.a;
            Aweme aweme = videoItemParams.getAweme();
            long shareCount = (aweme == null || (statistics = aweme.getStatistics()) == null) ? 0L : statistics.getShareCount();
            if (shareCount < 1000) {
                strA = Long.toString(Math.max(0L, shareCount));
            } else if (shareCount < 1000000) {
                strA = kg.a(shareCount, 1000L, "K");
            } else {
                strA = shareCount < 1000000000 ? kg.a(shareCount, 1000000L, "M") : kg.a(shareCount, 1000000000L, "B");
            }
            kg.d.put(hookMethodParam.thisObject, strA);
            kg.b((TextView) kg.b.get(hookMethodParam.thisObject), strA);
        } catch (Throwable th) {
            String strDecrypt = "Story share count update failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
