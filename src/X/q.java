package X;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public final class q implements View.OnAttachStateChangeListener {
    public final  ViewGroup a;
    public final  v b;

    public q(ViewGroup viewGroup, v vVar) {
        this.a = viewGroup;
        this.b = vVar;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        p pVar;
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (pVar = this.b.d) != null) {
            viewTreeObserver.removeOnPreDrawListener(pVar);
        }
        w.b.remove(this.a);
        w.c();
    }
}
