package Z;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public final class v extends ViewOutlineProvider {
    public final  int a;

    public v(int i) {
        this.a = i;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
    }
}
