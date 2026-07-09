package X;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public final class s implements View.OnAttachStateChangeListener {
    public final  ViewGroup a;
    public final  w b;

    public s(ViewGroup viewGroup, w wVar) {
        this.a = viewGroup;
        this.b = wVar;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        r rVar;
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (rVar = this.b.d) != null) {
            viewTreeObserver.removeOnPreDrawListener(rVar);
        }
        x.b.remove(this.a);
        x.c();
    }
}
