package Z;

import android.view.View;

public final class g implements View.OnLayoutChangeListener {
    public final  m a;

    public g(m mVar) {
        this.a = mVar;
    }

    @Override
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m mVar = this.a;
        mVar.g = true;
        n.a(mVar, 80L, true);
    }
}
