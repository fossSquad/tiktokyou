package X;

import android.app.Notification;
import android.graphics.drawable.Icon;
import com.ss.android.ugc.aweme.setting.ui.SettingContainerActivity;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class b3 {
    public static void a() {
        try {
            XposedBridge.hookMethod(Notification.Builder.class.getMethod("setSmallIcon", Icon.class), new z2());
            XposedBridge.hookAllMethods(SettingContainerActivity.class, "onCreate", new a3());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = q0.a;
        }
    }
}
