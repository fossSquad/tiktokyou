package Z;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public final class ri extends ViewOutlineProvider {
    public final  LinearLayout a;
    public final  int b;
    public final  int c;

    public ri(LinearLayout linearLayout, int i, int i2) {
        this.a = linearLayout;
        this.b = i;
        this.c = i2;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        int i = ((FrameLayout.LayoutParams) this.a.getLayoutParams()).topMargin;
        int i2 = this.b;
        int i3 = this.c;
        outline.setRoundRect(0, i, i2, i + i3, i3 / 2.0f);
    }
}
