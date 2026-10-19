package Z;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import com.windukk.mod.Main;

public abstract class ck {
    public static volatile boolean a;
    public static volatile boolean b;

    static {
        a = false;
        b = false;
    }

    public static void a(boolean z) {
        if ((z || !b) && y5.a().H) {
            if (!z) {
                b = true;
            }
            zb zbVar = new zb();
            zbVar.a = "ic_mod_update_bottomsheet";
            zbVar.b = k7.a("ota_ready_title");
            zbVar.c = k7.a("ota_ready_subtitle");
            String strA = k7.a("ota_ready_button");
            Runnable runnable = new Runnable() {
                @Override
                public final void run() {
                    ck.a();
                }
            };
            zbVar.d = strA;
            zbVar.e = runnable;
            zbVar.h = z ? 0L : 1500L;
            zbVar.b(0);
        }
    }

    public static void b(boolean z) {
        if ((z || !(a || b)) && y5.a().H) {
            if (z || System.currentTimeMillis() >= y5.a().G) {
                if (!z) {
                    a = true;
                }
                zb zbVar = new zb();
                zbVar.a = "ic_mod_update_bottomsheet";
                zbVar.b = k7.a("update_available_title");
                zbVar.c = k7.a("update_available_subtitle");
                String strA = k7.a("update_available_button");
                Runnable runnable = new Runnable() {
                    @Override
                    public final void run() {
                        ck.b();
                    }
                };
                zbVar.d = strA;
                zbVar.e = runnable;
                String strA2 = k7.a("update_remind_in_three_days");
                Runnable runnable2 = new Runnable() {
                    @Override
                    public final void run() {
                        ck.c();
                    }
                };
                zbVar.f = strA2;
                zbVar.g = runnable2;
                zbVar.h = z ? 0L : 4000L;
                zbVar.b(0);
            }
        }
    }

    public static void c() {
        ac acVarA = ac.a();
        long jCurrentTimeMillis = System.currentTimeMillis() + 259200000;
        acVarA.getClass();
        ac.e().d(jCurrentTimeMillis);
    }

    public static void a() {
        try {
            Activity activity = (Activity) f3.f.get();
            if (activity != null) {
                activity.finishAffinity();
            }
        } catch (Throwable th) {
            String strDecrypt = "OTA close failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
        Process.killProcess(Process.myPid());
    }

    public static void b() {
        try {
            Context contextA = Main.getApplicationContext();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/tikyoutok"));
            intent.addFlags(268435456);
            contextA.startActivity(intent);
        } catch (Throwable th) {
            String strDecrypt = "openTelegram failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
