package X;

import android.view.View;

public final class r implements View.OnAttachStateChangeListener {
    @Override
    public final void onViewAttachedToWindow(View view) {
        w.g(view);
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        w.a(view);
        w.c.remove(view);
    }
}
