package Z;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
public final class zb {
    public String b;
    public String c;
    public String d;
    public Runnable e;
    public String f;
    public Runnable g;
    public String a = "ic_mod_update";
    public long h = 0;

    public final void a(int i) {
        Activity activity = (Activity) f3.f.get();
        if (activity == null || activity.isFinishing()) {
            if (i < 20) {
                b(i + 1);
                return;
            }
            return;
        }
        try {
            fc fcVarA = new fc(activity).b(this.a).b((CharSequence) this.b).a((CharSequence) this.c);
            fcVarA.b(this.d, this.e);
            String str = this.f;
            if (str != null && !str.isEmpty()) {
                fcVarA.d(this.f, this.g);
            }
            if (fcVarA.g()) {
                String strDecrypt = "Shown";
                Object obj = g7.a;
                g7.a(4, String.valueOf(strDecrypt), (Throwable) null);
            }
        } catch (Throwable th) {
            String strDecrypt2 = "Show failed";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th);
        }
    }

    public final void b(final int i) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                this.f$0.a(i);
            }
        }, i == 0 ? this.h : 1000L);
    }
}
