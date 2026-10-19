package Z;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;

public abstract class o6 {
    public static void a() {
        try {
            HookBridge.hookAllMethods(Class.forName("X.05sT"), "onFrameMetricsAvailable", ReplaceMethod.DO_NOTHING);
            String strDecrypt = "Disabled TikTok MainThreadMonitor FrameMetrics leak";
            Object obj = g7.a;
            g7.a(4, String.valueOf(strDecrypt), (Throwable) null);
        } catch (Throwable th) {
            String strDecrypt2 = "FrameMetricsLeakHooks init failed";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th);
        }
    }
}
