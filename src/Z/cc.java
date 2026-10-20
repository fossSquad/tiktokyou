package Z;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

public final class cc extends ScrollView {
    public final  int a;

    public cc(Context context, int i) {
        super(context);
        this.a = i;
    }

    @Override
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.getMode(i2) == 1073741824 ? View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.a), 1073741824) : View.MeasureSpec.makeMeasureSpec(this.a, Integer.MIN_VALUE));
    }
}
