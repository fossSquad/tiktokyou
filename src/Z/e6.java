package Z;

import com.ss.android.ugc.aweme.inbox.skylight.InboxSkylightWidgetV2Injector;
import com.windukk.hook.HookBridge;

public abstract class e6 {
    public static void a() {
        try {
            HookBridge.hookAllMethods(InboxSkylightWidgetV2Injector.class, "enable", new d6());
        } catch (Exception e) {
            String str = "InboxHooks error" + e;
            Object obj = h6.a;
            h6.a(6, String.valueOf(str), (Throwable) null);
        }
    }
}
