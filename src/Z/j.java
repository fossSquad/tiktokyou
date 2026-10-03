package Z;

import android.view.View;

public final class j implements View.OnAttachStateChangeListener {
    @Override
    public final void onViewAttachedToWindow(View view) {
        n.g(view);
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        n.a(view);
        n.c.remove(view);
    }
}
