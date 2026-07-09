package X;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import com.windukk.hook.HookBridge;
import java.io.File;
import java.util.HashMap;
import java.util.function.Supplier;

public abstract class x4 {
    public static volatile Typeface a;
    public static volatile String b;
    public static final HashMap c = new HashMap();
    public static final ThreadLocal d = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });

    public static void a() {
        try {
            HookBridge.hookAllMethods(Paint.class, "setTypeface", new r4());
            HookBridge.hookAllMethods(Typeface.class, "createFromAsset", new s4());
            Class cls = Integer.TYPE;
            HookBridge.hookMethod(Typeface.class.getMethod("create", String.class, cls), new t4());
            HookBridge.hookMethod(Typeface.class.getMethod("create", Typeface.class, cls), new u4());
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    HookBridge.hookMethod(Typeface.class.getMethod("create", Typeface.class, cls, Boolean.TYPE), new v4());
                } catch (NoSuchMethodException e) {
                }
            }
            HookBridge.hookAllMethods(TextView.class, "setTypeface", new w4());
        } catch (Exception e2) {
            e2.getMessage();
            int i = g5.a;
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
                    File file = new File(g5.c().getFilesDir(), "fonts/" + str.substring(5));
                    if (file.exists()) {
                        typefaceCreateFromFile = Typeface.createFromFile(file);
                    }
                } else if (str.startsWith("asset:")) {
                    String strSubstring = str.substring(6);
                    ThreadLocal threadLocal = d;
                    threadLocal.set(Boolean.TRUE);
                    try {
                        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(g5.c().getAssets(), "mod_fonts/" + strSubstring);
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
            e.getMessage();
            int i = g5.a;
            return null;
        }
    }

    public static Typeface a(String str, int i) {
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
