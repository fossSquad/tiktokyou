package Z;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class re {
    public static final int[] a = {-50340, -20480, -13707917, -15147777, -8560641, -50340};
    public static final Map b = Collections.synchronizedMap(new WeakHashMap());
    public static final Map c = Collections.synchronizedMap(new WeakHashMap());

    public static boolean a(ImageView imageView) {
        String resourceEntryName;
        String resourceEntryName2;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && imageView.getScaleType() != ImageView.ScaleType.CENTER_CROP) {
            View view = imageView;
            for (int i = 0; view != null && i < 4; i++) {
                if (!a(view.getClass().getName()) && !a(String.valueOf(view.getTag())) && !a(String.valueOf(view.getContentDescription()))) {
                    int id = view.getId();
                    if (id == -1) {
                        resourceEntryName2 = null;
                    } else {
                        try {
                            resourceEntryName2 = view.getResources().getResourceEntryName(id);
                        } catch (Throwable th) {
                            resourceEntryName2 = null;
                        }
                    }
                    if (!a(resourceEntryName2)) {
                        Object parent = view.getParent();
                        view = parent instanceof View ? (View) parent : null;
                    }
                }
            }
            View view2 = imageView;
            for (int i2 = 0; view2 != null && i2 < 4; i2++) {
                if (!b(view2.getClass().getName()) && !b(String.valueOf(view2.getTag())) && !b(String.valueOf(view2.getContentDescription()))) {
                    int id2 = view2.getId();
                    if (id2 == -1) {
                        resourceEntryName = null;
                    } else {
                        try {
                            resourceEntryName = view2.getResources().getResourceEntryName(id2);
                        } catch (Throwable th2) {
                            resourceEntryName = null;
                        }
                    }
                    if (!b(resourceEntryName)) {
                        Object parent2 = view2.getParent();
                        view2 = parent2 instanceof View ? (View) parent2 : null;
                    }
                }
                return false;
            }
            int iRound = Math.round(72 * imageView.getResources().getDisplayMetrics().density);
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (width <= 0) {
                width = intrinsicWidth;
            }
            if (height <= 0) {
                height = intrinsicHeight;
            }
            if ((width > 0 && width > iRound) || (height > 0 && height > iRound)) {
                return false;
            }
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                return true;
            }
            return intrinsicWidth <= iRound && intrinsicHeight <= iRound;
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return false;
        }
        String strReplace = str.toLowerCase().replace("musically", "");
        return strReplace.contains("music") || strReplace.contains("sound") || strReplace.contains("song") || strReplace.contains("audio") || strReplace.contains("track") || strReplace.contains("record") || strReplace.contains("disc");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("avatar") || lowerCase.contains("profile") || lowerCase.contains("user") || lowerCase.contains("head") || lowerCase.contains("photo") || lowerCase.contains("author");
    }
}
