package Z;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.ies.foundation.activity.BaseActivity;
public abstract class n3 extends BaseActivity {
    static {
        Color.parseColor("#F5F5F5");
        Color.parseColor("#777778");
    }

    public static void a(Activity activity) {
        Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
        if (launchIntentForPackage == null) {
            activity.finishAffinity();
            Process.killProcess(Process.myPid());
            return;
        }
        launchIntentForPackage.addFlags(268468224);
        ((AlarmManager) activity.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + 300, PendingIntent.getActivity(activity, 21593, launchIntentForPackage, 335544320));
        activity.finishAffinity();
        Process.killProcess(Process.myPid());
    }
}
