package X;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Environment;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class v extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = y.b;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            threadLocal.set(Boolean.FALSE);
            Uri uri = (Uri) methodHookParam.getResult();
            if (uri != null) {
                ((ConcurrentHashMap.KeySetView) y.a).add(uri.toString());
                ArrayList arrayList = g1.a;
            }
        }
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        try {
            ContentValues contentValues = (ContentValues) methodHookParam.args[1];
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
                y.b.set(Boolean.TRUE);
                ArrayList arrayList = g1.a;
            }
            if (asString3.contains("DCIM")) {
                if (asString2.startsWith("video/")) {
                    contentValues.put("relative_path", Environment.DIRECTORY_MOVIES + "/TikTok");
                    ArrayList arrayList2 = g1.a;
                } else if (asString2.startsWith("image/")) {
                    contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/TikTok");
                    ArrayList arrayList3 = g1.a;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList4 = g1.a;
        }
    }
}
