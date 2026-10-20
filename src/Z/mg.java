package Z;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public final class mg extends ViewOutlineProvider {
    public final  ng a;

    public mg(ng ngVar) {
        this.a = ngVar;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a.b.a(2.0f));
    }
}
