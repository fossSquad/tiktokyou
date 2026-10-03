package Z;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ScrollView;

public final class e5 implements ViewTreeObserver.OnGlobalLayoutListener {
    public int a = -1;
    public final  FrameLayout b;
    public final  h5 c;

    public e5(h5 h5Var, FrameLayout frameLayout) {
        this.c = h5Var;
        this.b = frameLayout;
    }

    @Override
    public final void onGlobalLayout() {
        Rect rect = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect);
        int height = this.b.getRootView().getHeight() - rect.bottom;
        if (height < this.c.a(100.0f)) {
            height = 0;
        }
        if (height == this.a) {
            return;
        }
        this.a = height;
        int iMax = height > 0 ? Math.max(0, height - this.c.c) : 0;
        this.c.h.setTranslationY(-iMax);
        h5 h5Var = this.c;
        ScrollView scrollView = h5Var.i;
        int iA = h5Var.a(16.0f);
        int iA2 = this.c.a(56.0f);
        h5 h5Var2 = this.c;
        scrollView.setPadding(iA, iA2 + h5Var2.b, h5Var2.a(16.0f), this.c.a(96.0f) + this.c.c + iMax);
    }
}
