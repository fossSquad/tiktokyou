package X;

import com.ss.android.ugc.aweme.feed.model.Video;
import com.ss.android.ugc.aweme.feed.model.VideoUrlModel;
import de.robv.android.xposed.XC_MethodHook;

class t extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        VideoUrlModel playAddr = ((Video) methodHookParam.thisObject).getPlayAddr();
        if (playAddr == null || playAddr.getUrlList() == null || playAddr.getUrlList().isEmpty()) {
            return;
        }
        methodHookParam.setResult(playAddr);
    }
}
