package Z;

import android.app.Activity;
import android.view.View;
import android.widget.ScrollView;

public final class v1 extends ScrollView {
    public int a;

    public v1(Activity activity) {
        super(activity);
    }

    @Override
    public final void onMeasure(int i, int i2) {
        int i3 = this.a;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
