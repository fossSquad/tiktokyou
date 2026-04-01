package X;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import de.robv.android.xposed.XposedBridge;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public abstract class j1 {
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
            XposedBridge.hookAllMethods(Paint.class, "setTypeface", new d1());
            XposedBridge.hookAllMethods(Typeface.class, "createFromAsset", new e1());
            Class cls = Integer.TYPE;
            XposedBridge.hookMethod(Typeface.class.getMethod("create", String.class, cls), new f1());
            XposedBridge.hookMethod(Typeface.class.getMethod("create", Typeface.class, cls), new g1());
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    XposedBridge.hookMethod(Typeface.class.getMethod("create", Typeface.class, cls, Boolean.TYPE), new h1());
                } catch (NoSuchMethodException e) {
                }
            }
            XposedBridge.hookAllMethods(TextView.class, "setTypeface", new i1());
        } catch (Exception e2) {
            e2.getMessage();
            ArrayList arrayList = r1.a;
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
                    File file = new File(r1.b().getFilesDir(), "fonts/" + str.substring(5));
                    if (file.exists()) {
                        typefaceCreateFromFile = Typeface.createFromFile(file);
                    }
                } else if (str.startsWith("asset:")) {
                    String strSubstring = str.substring(6);
                    ThreadLocal threadLocal = d;
                    threadLocal.set(Boolean.TRUE);
                    try {
                        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(r1.b().getAssets(), "mod_fonts/" + strSubstring);
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
            ArrayList arrayList = r1.a;
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
