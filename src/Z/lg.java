package Z;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public final class lg extends ViewOutlineProvider {
    @Override
    public final void getOutline(View view, Outline outline) {
        outline.setOval(0, 0, view.getWidth(), view.getHeight());
    }
}
