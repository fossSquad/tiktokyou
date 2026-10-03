package Z;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
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
            if (z || System.currentTimeMillis() >= d5.a().E) {
                if (!z) {
                    a = true;
                }
                sa saVar = new sa();
                saVar.a = "ic_mod_update_bottomsheet";
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
                String strA2 = l6.a("update_remind_in_three_days");
                Runnable runnable2 = new Runnable() {
                    @Override
                    public final void run() {
                        rg.c();
                    }
                };
                saVar.g = strA2;
                saVar.h = runnable2;
                saVar.f = z ? 0L : 4000L;
                saVar.b(0);
            }
        }
    }

    public static void c() {
        ta taVarA = ta.a();
        long jCurrentTimeMillis = System.currentTimeMillis() + 259200000;
        taVarA.getClass();
        ta.d().d(jCurrentTimeMillis);
    }

    public static void a() {
        try {
            Context contextA = Main.getApplicationContext();
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
            Activity activity = (Activity) u2.f.get();
            if (activity != null) {
                activity.finishAffinity();
            }
        } catch (Throwable th) {
            String strDecrypt = "OTA close failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
        Process.killProcess(Process.myPid());
    }
}
