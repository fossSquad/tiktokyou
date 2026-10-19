package Z;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.io.File;
import java.util.HashMap;
import java.util.function.Supplier;

public abstract class n6 {
    public static volatile Typeface a;
    public static volatile String b;
    public static final HashMap c;
    public static final ThreadLocal d;

    static {
        c = new HashMap();
        d = ThreadLocal.withInitial(new Supplier() {
            @Override
            public final Object get() {
                return Boolean.FALSE;
            }
        });
    }

    public static void a() {
        try {
            HookBridge.hookAllMethods(Paint.class, "setTypeface", new h6());
            HookBridge.hookAllMethods(Typeface.class, "createFromAsset", new i6());
            String strDecrypt = "create";
            Class cls = Integer.TYPE;
            HookBridge.hookMethod(Typeface.class.getMethod(strDecrypt, String.class, cls), new j6());
            HookBridge.hookMethod(Typeface.class.getMethod("create", Typeface.class, cls), new k6());
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    HookBridge.hookMethod(Typeface.class.getMethod("create", Typeface.class, cls, Boolean.TYPE), new l6());
                } catch (NoSuchMethodException e) {
                }
            }
            HookBridge.hookAllMethods(TextView.class, "setTypeface", new m6());
        } catch (Exception e2) {
            String str = "FontHooks init exception: " + e2;
            Object obj = g7.a;
            g7.a(6, String.valueOf(str), (Throwable) null);
        }
    }

    public static Typeface a(String str) {
        if (str.equals(b) && a != null) {
            return a;
        }
        Typeface typefaceCreateFromFile = null;
        try {
            if ("system".equals(str)) {
                typefaceCreateFromFile = Typeface.DEFAULT;
            } else {
                if (str.startsWith("file:")) {
                    File file = new File(Main.getApplicationContext().getFilesDir(), "fonts/" + str.substring("file:".length()));
                    if (file.exists()) {
                        typefaceCreateFromFile = Typeface.createFromFile(file);
                    }
                } else if (str.startsWith("asset:")) {
                    String strSubstring = str.substring("asset:".length());
                    ThreadLocal threadLocal = d;
                    threadLocal.set(Boolean.TRUE);
                    try {
                        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(Main.getApplicationContext().getAssets(), "mod_fonts/" + strSubstring);
                        threadLocal.set(Boolean.FALSE);
                        typefaceCreateFromFile = typefaceCreateFromAsset;
                    } catch (Throwable th) {
                        d.set(Boolean.FALSE);
                        throw th;
                    }
                }
                if (typefaceCreateFromFile != null) {
                    b = str;
                    a = typefaceCreateFromFile;
                }
                return typefaceCreateFromFile;
            }
            if (typefaceCreateFromFile != null) {
                b = str;
                a = typefaceCreateFromFile;
            }
            return typefaceCreateFromFile;
        } catch (Exception e) {
            g7.a(6, g7.a("FontHooks: failed to load font '%s'", new Object[]{str}), e);
            return null;
        }
    }

    public static Typeface a(int i, String str) {
        Typeface typefaceA = a(str);
        if (typefaceA == null) {
            return null;
        }
        if (i == 0) {
            return typefaceA;
        }
        HashMap map = c;
        Typeface typeface = (Typeface) map.get(Integer.valueOf(i));
        if (typeface != null) {
            return typeface;
        }
        d.set(Boolean.TRUE);
        try {
            Typeface typefaceCreate = Typeface.create(typefaceA, i);
            map.put(Integer.valueOf(i), typefaceCreate);
            return typefaceCreate;
        } finally {
            d.set(Boolean.FALSE);
        }
    }
}
