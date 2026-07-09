package X;

import android.os.SystemClock;
import android.view.ViewTreeObserver;

public final class r implements ViewTreeObserver.OnPreDrawListener {
    public final  w a;

    public r(w wVar) {
        this.a = wVar;
    }

    @Override
    public final boolean onPreDraw() {
        w wVar = this.a;
        boolean zB = x.b();
        if (zB != wVar.h) {
            if (zB) {
                x.b(wVar);
            }
            wVar.h = zB;
            wVar.e = false;
            x.b(wVar, true);
            x.a(wVar, true);
            x.c();
        }
        if (zB) {
            if (wVar.g) {
                wVar.g = false;
                x.b(wVar, true);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (!wVar.e || jUptimeMillis < wVar.i) {
                x.a(wVar, false);
            } else {
                wVar.e = false;
                x.a(wVar, true);
            }
        }
        return true;
    }
}
