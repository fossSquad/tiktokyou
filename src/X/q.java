package X;

import android.view.View;

public final class q implements View.OnLayoutChangeListener {
    public final  w a;

    public q(w wVar) {
        this.a = wVar;
    }

    @Override
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        w wVar = this.a;
        wVar.g = true;
        x.a(wVar, 80L, true);
    }
}
