package Z;

import Z.h6;
import Z.m5;
import Z.n5;
import Z.o5;
import Z.p5;
import Z.q5;
import Z.r5;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.io.File;
import java.util.HashMap;
import java.util.function.Supplier;

public abstract class FontHooks {
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
            HookBridge.hookAllMethods(Paint.class, "setTypeface", new m5());
            HookBridge.hookAllMethods(Typeface.class, "createFromAsset", new n5());
            String strDecrypt = "create";
            Class cls = Integer.TYPE;
            HookBridge.hookMethod(Typeface.class.getMethod(strDecrypt, String.class, cls), new o5());
            HookBridge.hookMethod(Typeface.class.getMethod("create", Typeface.class, cls), new p5());
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    HookBridge.hookMethod(Typeface.class.getMethod("create", Typeface.class, cls, Boolean.TYPE), new q5());
                } catch (NoSuchMethodException e) {
                }
            }
            HookBridge.hookAllMethods(TextView.class, "setTypeface", new r5());
        } catch (Exception e2) {
            String str = "FontHooks init exception: " + e2;
            Object obj = h6.a;
            h6.a(6, String.valueOf(str), (Throwable) null);
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
            h6.a(6, h6.a("FontHooks: failed to load font '%s'", new Object[]{str}), e);
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
