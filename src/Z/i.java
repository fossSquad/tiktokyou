package Z;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public final class i implements View.OnAttachStateChangeListener {
    public final  ViewGroup a;
    public final  m b;

    public i(ViewGroup viewGroup, m mVar) {
        this.a = viewGroup;
        this.b = mVar;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        h hVar;
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (hVar = this.b.d) != null) {
            viewTreeObserver.removeOnPreDrawListener(hVar);
        }
        n.b.remove(this.a);
        n.c();
    }
}
