package Z;

import Z.h6;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;

public abstract class FrameMetricsLeakHooks {
    public static void a() {
        try {
            HookBridge.hookAllMethods(Class.forName("X.05m8"), "onFrameMetricsAvailable", ReplaceMethod.DO_NOTHING);
            String strDecrypt = "Disabled TikTok MainThreadMonitor FrameMetrics leak";
            Object obj = h6.a;
            h6.a(4, String.valueOf(strDecrypt), (Throwable) null);
        } catch (Throwable th) {
            String strDecrypt2 = "FrameMetricsLeakHooks init failed";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th);
        }
    }
}
