package Z;

import android.os.SystemClock;
import android.view.ViewTreeObserver;

public final class h implements ViewTreeObserver.OnPreDrawListener {
    public final  m a;

    public h(m mVar) {
        this.a = mVar;
    }

    @Override
    public final boolean onPreDraw() {
        m mVar = this.a;
        boolean zB = n.b();
        if (zB != mVar.h) {
            if (zB) {
                n.b(mVar);
            }
            mVar.h = zB;
            mVar.e = false;
            n.b(mVar, true);
            n.a(mVar, true);
            n.c();
        }
        if (zB) {
            if (mVar.g) {
                mVar.g = false;
                n.b(mVar, true);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (!mVar.e || jUptimeMillis < mVar.i) {
                n.a(mVar, false);
            } else {
                mVar.e = false;
                n.a(mVar, true);
            }
        }
        return true;
    }
}
