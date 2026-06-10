package X;

import android.view.View;

public final class o implements View.OnLayoutChangeListener {
    public final  v a;

    public o(v vVar) {
        this.a = vVar;
    }

    @Override
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        v vVar = this.a;
        vVar.g = true;
        w.a(vVar, 80L, true);
    }
}
