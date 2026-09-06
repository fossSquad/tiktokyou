package Z;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import com.windukk.mod.Main;

public abstract class rg {
    public static volatile boolean a;
    public static volatile boolean b;

    static {
        a = false;
        b = false;
    }

    public static void a(boolean z) {
        if ((z || !b) && d5.a().B) {
            if (!z) {
                b = true;
            }
            sa saVar = new sa();
            saVar.a = "ic_mod_update_bottomsheet";
            m6 m6Var = l6.a;
            saVar.b = l6.a("ota_ready_title");
            saVar.c = l6.a("ota_ready_subtitle");
            String strA = l6.a("ota_ready_button");
            Runnable runnable = new Runnable() {
                @Override
                public final void run() {
                    rg.b();
                }
            };
            saVar.d = strA;
            saVar.e = runnable;
            saVar.f = z ? 0L : 1500L;
            saVar.b(0);
        }
    }

    public static void b(boolean z) {
        if ((z || !(a || b)) && d5.a().B) {
            if (!z) {
                a = true;
            }
            sa saVar = new sa();
            saVar.a = "ic_mod_update_bottomsheet";
            m6 m6Var = l6.a;
            saVar.b = l6.a("update_available_title");
            saVar.c = l6.a("update_available_subtitle");
            String strA = l6.a("update_available_button");
            Runnable runnable = new Runnable() {
                @Override
                public final void run() {
                    rg.a();
                }
            };
            saVar.d = strA;
            saVar.e = runnable;
            saVar.f = z ? 0L : 4000L;
            saVar.b(0);
        }
    }

    public static void a() {
        try {
            Context contextA = Main.a();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/tikyoutok"));
            intent.addFlags(268435456);
            contextA.startActivity(intent);
        } catch (Throwable th) {
            String strDecrypt = "openTelegram failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void b() {
        try {
            Context contextA = Main.a();
            Intent launchIntentForPackage = contextA.getPackageManager().getLaunchIntentForPackage(contextA.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268468224);
                PendingIntent activity = PendingIntent.getActivity(contextA, 5198913, launchIntentForPackage, 335544320);
                AlarmManager alarmManager = (AlarmManager) contextA.getSystemService("alarm");
                if (alarmManager != null) {
                    alarmManager.set(3, SystemClock.elapsedRealtime() + 300, activity);
                }
            }
        } catch (Throwable th) {
            String strDecrypt = "OTA restart schedule failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
        Process.killProcess(Process.myPid());
    }
}
