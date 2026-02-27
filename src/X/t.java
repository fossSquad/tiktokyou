package X;

import android.content.ContentValues;
import android.net.Uri;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class t extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = w.b;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            threadLocal.set(Boolean.FALSE);
            Uri uri = (Uri) methodHookParam.getResult();
            if (uri != null) {
                ((ConcurrentHashMap.KeySetView) w.a).add(uri.toString());
                ArrayList arrayList = q0.a;
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
            if (asString != null && asString.endsWith(".png") && "image/png".equals(asString2) && asString3 != null && asString3.contains("DCIM")) {
                contentValues.put("_display_name", asString.replace(".png", ".jpg"));
                contentValues.put("mime_type", "image/jpeg");
                w.b.set(Boolean.TRUE);
                ArrayList arrayList = q0.a;
            }
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = q0.a;
        }
    }
}
