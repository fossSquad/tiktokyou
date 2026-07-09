package X;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public abstract class od {
    public static volatile boolean a;

    public static void a() {
        if (a) {
            return;
        }
        a = true;
        k8 k8Var = new k8();
        k8Var.a = "ic_mod_update_bottomsheet";
        k8Var.b = f5.a().a("update_available_title");
        k8Var.c = f5.a().a("update_available_subtitle");
        String strA = f5.a().a("update_available_button");
        Runnable runnable = new Runnable() {
            @Override
            public final void run() {
                od.b();
            }
        };
        k8Var.d = strA;
        k8Var.e = runnable;
        k8Var.f = 4000L;
        k8Var.b(0);
    }

    public static void b() {
        try {
            Context contextC = g5.c();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/tikyoutok"));
            intent.addFlags(268435456);
            contextC.startActivity(intent);
        } catch (Throwable th) {
            int i = g5.a;
        }
    }
}
