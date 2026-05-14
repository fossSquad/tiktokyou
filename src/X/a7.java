package X;

import android.app.Notification;
import android.graphics.drawable.Icon;
import com.ss.android.ugc.aweme.setting.ui.SettingContainerActivity;
import com.windukk.hook.HookBridge;

public abstract class a7 {
    public static void a() {
        try {
            HookBridge.hookMethod(Notification.Builder.class.getMethod("setSmallIcon", Icon.class), new y6());
            HookBridge.hookAllMethods(SettingContainerActivity.class, "onCreate", new z6());
        } catch (Exception e) {
            e.getMessage();
            int i = v3.a;
        }
    }
}
