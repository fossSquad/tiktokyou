package X;

import android.os.SystemClock;
import android.view.ViewTreeObserver;

public final class p implements ViewTreeObserver.OnPreDrawListener {
    public final  v a;

    public p(v vVar) {
        this.a = vVar;
    }

    @Override
    public final boolean onPreDraw() {
        v vVar = this.a;
        boolean zB = w.b();
        if (zB != vVar.h) {
            if (zB) {
                w.b(vVar);
            }
            vVar.h = zB;
            vVar.e = false;
            w.b(vVar, true);
            w.a(vVar, true);
            w.c();
        }
        if (zB) {
            if (vVar.g) {
                vVar.g = false;
                w.b(vVar, true);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (!vVar.e || jUptimeMillis < vVar.i) {
                w.a(vVar, false);
            } else {
                vVar.e = false;
                w.a(vVar, true);
            }
        }
        return true;
    }
}
