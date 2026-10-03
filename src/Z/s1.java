package Z;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;

public abstract class s1 {
    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static boolean b(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static int a(Activity activity) {
        int identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
