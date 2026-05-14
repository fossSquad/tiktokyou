package X;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Environment;
import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class k2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = o2.b;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            threadLocal.set(Boolean.FALSE);
            Uri uri = (Uri) hookMethodParam.getResult();
            if (uri != null) {
                ((ConcurrentHashMap.KeySetView) o2.a).add(uri.toString());
                int i = v3.a;
            }
        }
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            ContentValues contentValues = (ContentValues) hookMethodParam.args[1];
            if (contentValues == null) {
                return;
            }
            String asString = contentValues.getAsString("_display_name");
            String asString2 = contentValues.getAsString("mime_type");
            String asString3 = contentValues.getAsString("relative_path");
            if (asString2 == null || asString3 == null) {
                return;
            }
            if (asString != null && asString.endsWith(".png") && "image/png".equals(asString2) && asString3.contains("DCIM")) {
                contentValues.put("_display_name", asString.replace(".png", ".jpg"));
                contentValues.put("mime_type", "image/jpeg");
                o2.b.set(Boolean.TRUE);
                int i = v3.a;
            }
            if (asString3.contains("DCIM")) {
                if (asString2.startsWith("video/")) {
                    contentValues.put("relative_path", Environment.DIRECTORY_MOVIES + "/TikTok");
                    int i2 = v3.a;
                } else if (asString2.startsWith("image/")) {
                    contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/TikTok");
                    int i3 = v3.a;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            int i4 = v3.a;
        }
    }
}
