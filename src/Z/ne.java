package Z;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.windukk.mod.Main;
import ni.shikatu.kotlin.ranges.RangesKt;

public final class ne implements ViewTreeObserver.OnGlobalLayoutListener {
    public final  LinearLayout a;
    public final  Activity b;
    public final  LinearLayout c;
    public final  ScrollView d;

    public ne(LinearLayout linearLayout, Activity activity, LinearLayout linearLayout2, ScrollView scrollView) {
        this.a = linearLayout;
        this.b = activity;
        this.c = linearLayout2;
        this.d = scrollView;
    }

    @Override
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = (int) (this.b.getResources().getDisplayMetrics().heightPixels * 0.92f);
        qe.a.getClass();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i - (Main.dp(16.0f) + (Main.dp(4.0f) + Main.dp(12.0f))), Main.dp(200.0f));
        if (this.c.getHeight() > iCoerceAtLeast) {
            ScrollView scrollView = this.d;
            ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = iCoerceAtLeast;
            scrollView.setLayoutParams(layoutParams2);
            this.d.requestLayout();
        }
    }
}
