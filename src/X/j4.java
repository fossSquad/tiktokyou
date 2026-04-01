package X;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.ImageViewCompat;
import com.bytedance.tux.icon.TuxIconView;
import com.ss.android.ugc.aweme.utils.CommonUtils;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class j4 {
    public static volatile int a = 0;
    public static volatile int b = 0;
    public static boolean c = true;
    public static volatile boolean d;

    public static int a() {
        int i;
        t1 t1VarA = t1.a();
        if (t1VarA != null && (i = t1VarA.j) != 0) {
            a = i;
            return a;
        }
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        Context contextB = r1.b();
        if (contextB == null) {
            return -16524603;
        }
        int iA = a(contextB);
        b = iA;
        return iA;
    }

    public static void b() {
        try {
            XposedBridge.hookAllMethods(Color.class, "parseColor", new o3());
            XposedBridge.hookAllMethods(Paint.class, "setColor", new z3());
            XposedBridge.hookAllMethods(TextView.class, "setTextColor", new c4());
            XposedBridge.hookAllMethods(GradientDrawable.class, "setColor", new d4());
            XposedBridge.hookAllMethods(GradientDrawable.class, "setStroke", new e4());
            XposedBridge.hookAllMethods(View.class, "setBackgroundColor", new f4());
            XposedBridge.hookAllMethods(Drawable.class, "setTint", new g4());
            XposedBridge.hookAllMethods(Drawable.class, "setTintList", new h4());
            XposedBridge.hookAllMethods(ImageView.class, "setColorFilter", new i4());
            XposedBridge.hookAllMethods(ColorStateList.class, "valueOf", new e3());
            try {
                XposedBridge.hookAllMethods(TuxIconView.class, "setTintColor", new f3());
                XposedBridge.hookAllMethods(TuxIconView.class, "setColor", new g3());
                ArrayList arrayList = r1.a;
            } catch (Exception e) {
                ArrayList arrayList2 = r1.a;
            }
            XposedBridge.hookAllConstructors(ForegroundColorSpan.class, new h3());
            XposedBridge.hookAllMethods(ImageView.class, "setImageTintList", new i3());
            XposedBridge.hookAllMethods(View.class, "setBackgroundTintList", new j3());
            XposedBridge.hookAllConstructors(PorterDuffColorFilter.class, new k3());
            try {
                XposedBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new l3());
            } catch (NoSuchMethodException e2) {
            }
            try {
                XposedBridge.hookAllMethods(ImageViewCompat.class, "setImageTintList", new m3());
                ArrayList arrayList3 = r1.a;
            } catch (NoClassDefFoundError e3) {
                ArrayList arrayList4 = r1.a;
            }
            try {
                XposedBridge.hookAllMethods(DrawableCompat.class, "setTint", new n3());
                XposedBridge.hookAllMethods(DrawableCompat.class, "setTintList", new p3());
            } catch (NoClassDefFoundError e4) {
                ArrayList arrayList5 = r1.a;
            }
            XposedBridge.hookAllMethods(TypedArray.class, "getColor", new q3());
            XposedBridge.hookAllMethods(TypedArray.class, "getColorStateList", new r3());
            XposedBridge.hookAllMethods(Resources.class, "getColor", new s3());
            XposedBridge.hookAllMethods(Resources.class, "getColorStateList", new t3());
            XposedBridge.hookAllMethods(Context.class, "getColor", new u3());
            XposedBridge.hookAllMethods(Context.class, "getColorStateList", new v3());
            try {
                XposedBridge.hookAllMethods(ContextCompat.class, "getColor", new w3());
                XposedBridge.hookAllMethods(ContextCompat.class, "getColorStateList", new x3());
            } catch (NoClassDefFoundError e5) {
                ArrayList arrayList6 = r1.a;
            }
            try {
                XposedBridge.hookAllMethods(ResourcesCompat.class, "getColor", new y3());
                XposedBridge.hookAllMethods(ResourcesCompat.class, "getColorStateList", new a4());
            } catch (NoClassDefFoundError e6) {
                ArrayList arrayList7 = r1.a;
            }
            try {
                Class<?> cls = Class.forName("X.13Wp");
                b4 b4Var = new b4(Class.forName("X.13Wn"), Class.forName("X.13Wi"), "LJJIJL", true, Class.forName("X.0Ros"), Class.forName("X.13Wz"));
                XposedBridge.hookAllMethods(cls, "playAnimation", b4Var);
                XposedBridge.hookAllMethods(cls, "setComposition", b4Var);
            } catch (ClassNotFoundException e7) {
                e7.getMessage();
                ArrayList arrayList8 = r1.a;
            }
        } catch (Exception e8) {
            e8.getMessage();
            ArrayList arrayList9 = r1.a;
        }
    }

    public static int a(Context context) {
        if (d) {
            return -16524603;
        }
        d = true;
        boolean z = c;
        c = false;
        try {
            Resources resources = context.getResources();
            String[] strArr = {"system_accent1_500", "system_accent1_600", "system_accent2_500", "system_accent3_500"};
            for (int i = 0; i < 4; i++) {
                int identifier = resources.getIdentifier(strArr[i], "color", "android");
                if (identifier != 0) {
                    return resources.getColor(identifier, null);
                }
            }
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = r1.a;
        } finally {
            c = z;
            d = false;
        }
        return -16524603;
    }

    public static int a(int i) {
        return !c ? i : CommonUtils.fixColorNative(i, a());
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (!c) {
            return colorStateList;
        }
        if (colorStateList == null) {
            return null;
        }
        try {
            int defaultColor = colorStateList.getDefaultColor();
            int iA = a(defaultColor);
            if (iA != defaultColor) {
                return ColorStateList.valueOf(iA);
            }
        } catch (Exception e) {
        }
        return colorStateList;
    }
}
