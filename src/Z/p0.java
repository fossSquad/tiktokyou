package Z;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
public final class p0 extends ViewOutlineProvider {
    public final  float a;

    public p0(float f) {
        this.a = f;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
    }
}
