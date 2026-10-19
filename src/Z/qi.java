package Z;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public final class qi extends ViewOutlineProvider {
    public final  LinearLayout a;
    public final  int b;
    public final  int c;

    public qi(LinearLayout linearLayout, int i, int i2) {
        this.a = linearLayout;
        this.b = i;
        this.c = i2;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        int i = ((FrameLayout.LayoutParams) this.a.getLayoutParams()).leftMargin;
        int i2 = this.b;
        outline.setRoundRect(i, 0, i + i2, this.c, i2 / 2.0f);
    }
}
