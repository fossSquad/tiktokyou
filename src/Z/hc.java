package Z;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.OvershootInterpolator;
import com.windukk.mod.hooks.EdgeSpeedupHooks;

public final class hc implements ViewTreeObserver.OnPreDrawListener {
    public final  View a;
    public final  jc b;

    public hc(View view, jc jcVar) {
        this.a = view;
        this.b = jcVar;
    }

    @Override
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.a.getParent() instanceof View) {
            this.b.b = new ColorDrawable(-16777216);
            ((View) this.a.getParent()).setBackground(this.b.b);
        }
        EdgeSpeedupHooks.a(this.b, this.a.getHeight());
        EdgeSpeedupHooks.a(this.b, 0.0f, 380L, new OvershootInterpolator(0.7f), null);
        return true;
    }
}
