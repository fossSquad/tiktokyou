package X;

import android.view.View;

public final class t implements View.OnAttachStateChangeListener {
    @Override
    public final void onViewAttachedToWindow(View view) {
        x.g(view);
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        x.a(view);
        x.c.remove(view);
    }
}
