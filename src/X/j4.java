package X;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ScrollView;

public final class j4 implements ViewTreeObserver.OnGlobalLayoutListener {
    public int a = -1;
    public final  FrameLayout b;
    public final  m4 c;

    public j4(m4 m4Var, FrameLayout frameLayout) {
        this.c = m4Var;
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
        m4 m4Var = this.c;
        ScrollView scrollView = m4Var.i;
        int iA = m4Var.a(16.0f);
        int iA2 = this.c.a(56.0f);
        m4 m4Var2 = this.c;
        scrollView.setPadding(iA, iA2 + m4Var2.b, m4Var2.a(16.0f), this.c.a(96.0f) + this.c.c + iMax);
    }
}
