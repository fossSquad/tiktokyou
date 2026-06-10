package X;

import android.app.Activity;
import android.util.TypedValue;

public abstract  class y1 {
    public static float a(Activity activity, int i, float f) {
        return TypedValue.applyDimension(i, f, activity.getResources().getDisplayMetrics());
    }
}
