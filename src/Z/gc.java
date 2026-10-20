package Z;

import android.app.Dialog;
import android.view.View;
import com.windukk.mod.hooks.EdgeSpeedupHooks;

public final class gc implements View.OnAttachStateChangeListener {
    public final  Dialog a;
    public final  int b;
    public final  float c;

    public gc(Dialog dialog, int i, float f) {
        this.a = dialog;
        this.b = i;
        this.c = f;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        EdgeSpeedupHooks.a(this.a.getWindow(), this.b, this.c);
        view.requestApplyInsets();
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
    }
}
