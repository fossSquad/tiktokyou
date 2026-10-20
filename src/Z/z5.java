package Z;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ScrollView;

public final class z5 implements ViewTreeObserver.OnGlobalLayoutListener {
    public int a = -1;
    public final  FrameLayout b;
    public final  c6 c;

    public z5(c6 c6Var, FrameLayout frameLayout) {
        this.c = c6Var;
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
        c6 c6Var = this.c;
        ScrollView scrollView = c6Var.i;
        int iA = c6Var.a(16.0f);
        int iA2 = this.c.a(56.0f);
        c6 c6Var2 = this.c;
        scrollView.setPadding(iA, iA2 + c6Var2.b, c6Var2.a(16.0f), this.c.a(96.0f) + this.c.c + iMax);
    }
}
