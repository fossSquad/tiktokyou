package X;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.os.Environment;
import com.windukk.hook.HookBridge;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public abstract class d3 {
    public static final Set a = ConcurrentHashMap.newKeySet();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });

    public static void a() {
        try {
            HookBridge.hookAllMethods(ContentResolver.class, "insert", new a3());
            int i = p4.a;
        } catch (Exception e) {
            e.getMessage();
            int i2 = p4.a;
        }
        try {
            HookBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new b3());
        } catch (Exception e2) {
            e2.getMessage();
            int i3 = p4.a;
        }
    }

    public static void b(ContentValues contentValues) {
        String asString = contentValues.getAsString("_display_name");
        String asString2 = contentValues.getAsString("mime_type");
        String asString3 = contentValues.getAsString("relative_path");
        if (asString2 == null || asString3 == null || asString == null || !asString.endsWith(".png") || !"image/png".equals(asString2) || !asString3.contains("DCIM")) {
            return;
        }
        contentValues.put("_display_name", asString.replace(".png", ".jpg"));
        contentValues.put("mime_type", "image/jpeg");
        b.set(Boolean.TRUE);
        int i = p4.a;
    }

    public static boolean a(ContentValues contentValues) {
        String asString = contentValues.getAsString("_display_name");
        String asString2 = contentValues.getAsString("mime_type");
        String asString3 = contentValues.getAsString("relative_path");
        if ((asString != null && asString.toLowerCase(Locale.US).endsWith(".mp3")) || (asString2 != null && asString2.startsWith("audio/") && asString3 != null && asString3.contains("DCIM"))) {
            contentValues.put("mime_type", "audio/mpeg");
            contentValues.put("relative_path", Environment.DIRECTORY_MUSIC + "/TikTok");
            int i = p4.a;
            return true;
        }
        if (asString2 != null && asString3 != null && asString3.contains("DCIM")) {
            if (asString2.startsWith("video/")) {
                contentValues.put("relative_path", Environment.DIRECTORY_MOVIES + "/TikTok");
                int i2 = p4.a;
            } else if (asString2.startsWith("image/")) {
                contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/TikTok");
                int i3 = p4.a;
            }
        }
        return false;
    }
}
