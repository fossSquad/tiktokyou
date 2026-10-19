package Z;

import com.ss.android.ugc.aweme.inbox.skylight.InboxSkylightWidgetV2Injector;
import com.windukk.hook.HookBridge;

public abstract class d7 {
    public static void a() {
        try {
            HookBridge.hookAllMethods(InboxSkylightWidgetV2Injector.class, "enable", new c7());
        } catch (Exception e) {
            String str = "InboxHooks error" + e;
            Object obj = g7.a;
            g7.a(6, String.valueOf(str), (Throwable) null);
        }
    }
}
