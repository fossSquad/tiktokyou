package Z;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public final class de extends ViewOutlineProvider {
    public final  le a;

    public de(le leVar) {
        this.a = leVar;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a.a(4.0f));
    }
}
