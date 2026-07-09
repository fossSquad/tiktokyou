package X;

import android.text.TextUtils;

public abstract class g1 {
    public static boolean a(String str) {
        if (str != null) {
            return str.startsWith("https://") || str.startsWith("http://");
        }
        return false;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "asset:supporter.png";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "asset:supporter.png";
        }
        return (a(strTrim) || strTrim.startsWith("asset:")) ? strTrim : "asset:".concat(strTrim);
    }
}
