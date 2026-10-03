package Z;

import android.app.Dialog;
import android.view.View;

public final class va implements View.OnAttachStateChangeListener {
    public final  Dialog a;
    public final  int b;
    public final  float c;

    public va(Dialog dialog, int i, float f) {
        this.a = dialog;
        this.b = i;
        this.c = f;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        wa.a(this.a.getWindow(), this.b, this.c);
        view.requestApplyInsets();
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
    }
}
