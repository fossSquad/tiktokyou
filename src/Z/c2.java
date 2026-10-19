package Z;

import android.app.Activity;
public abstract class c2 {
    public static int a(Activity activity) {
        int identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean b(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
