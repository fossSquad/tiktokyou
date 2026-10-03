package Z;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

public final class pe implements ViewTreeObserver.OnPreDrawListener {
    public final  LinearLayout a;

    public pe(LinearLayout linearLayout) {
        this.a = linearLayout;
    }

    @Override
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        LinearLayout linearLayout = this.a;
        linearLayout.setTranslationY(linearLayout.getHeight());
        this.a.animate().translationY(0.0f).setDuration(280L).start();
        return true;
    }
}
