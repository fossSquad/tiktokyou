package X;

import android.app.Notification;
import android.graphics.drawable.Icon;
import com.ss.android.ugc.aweme.setting.ui.SettingContainerActivity;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class o5 {
    public static void a() {
        try {
            XposedBridge.hookMethod(Notification.Builder.class.getMethod("setSmallIcon", Icon.class), new m5());
            XposedBridge.hookAllMethods(SettingContainerActivity.class, "onCreate", new n5());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = q2.a;
        }
    }
}
