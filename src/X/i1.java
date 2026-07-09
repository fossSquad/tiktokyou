package X;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;

public abstract class i1 {
    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static boolean a(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
