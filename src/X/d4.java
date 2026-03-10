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
import com.bytedance.tux.icon.TuxIconView;
import com.ss.android.ugc.aweme.utils.CommonUtils;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class d4 {
    public static volatile int a = 0;
    public static volatile int b = 0;
    public static boolean c = true;
    public static volatile boolean d;

    public static int a() {
        int i;
        i1 i1VarA = i1.a();
        if (i1VarA != null && (i = i1VarA.j) != 0) {
            a = i;
            return a;
        }
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        Context contextB = g1.b();
        if (contextB == null) {
            return -16524603;
        }
        int iA = a(contextB);
        b = iA;
        return iA;
    }

    public static void b() {
        Class<?> cls;
        Class<?> cls2;
        String str;
        Class<?> cls3;
        boolean z;
        Class<?> cls4;
        Class<?> cls5;
        try {
            XposedBridge.hookAllMethods(Color.class, "parseColor", new i3());
            XposedBridge.hookAllMethods(Paint.class, "setColor", new t3());
            XposedBridge.hookAllMethods(TextView.class, "setTextColor", new w3());
            XposedBridge.hookAllMethods(GradientDrawable.class, "setColor", new x3());
            XposedBridge.hookAllMethods(GradientDrawable.class, "setStroke", new y3());
            XposedBridge.hookAllMethods(View.class, "setBackgroundColor", new z3());
            XposedBridge.hookAllMethods(Drawable.class, "setTint", new a4());
            XposedBridge.hookAllMethods(Drawable.class, "setTintList", new b4());
            XposedBridge.hookAllMethods(ImageView.class, "setColorFilter", new c4());
            XposedBridge.hookAllMethods(ColorStateList.class, "valueOf", new y2());
            try {
                XposedBridge.hookAllMethods(TuxIconView.class, "setTintColor", new z2());
                XposedBridge.hookAllMethods(TuxIconView.class, "setColor", new a3());
                ArrayList arrayList = g1.a;
            } catch (Exception e) {
                ArrayList arrayList2 = g1.a;
            }
            XposedBridge.hookAllConstructors(ForegroundColorSpan.class, new b3());
            XposedBridge.hookAllMethods(ImageView.class, "setImageTintList", new c3());
            XposedBridge.hookAllMethods(View.class, "setBackgroundTintList", new d3());
            XposedBridge.hookAllConstructors(PorterDuffColorFilter.class, new e3());
            try {
                XposedBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new f3());
            } catch (NoSuchMethodException e2) {
            }
            try {
                XposedBridge.hookAllMethods(Class.forName("androidx.core.widget.ImageViewCompat"), "setImageTintList", new g3());
                ArrayList arrayList3 = g1.a;
            } catch (ClassNotFoundException e3) {
                ArrayList arrayList4 = g1.a;
            }
            try {
                Class<?> cls6 = Class.forName("androidx.core.graphics.drawable.DrawableCompat");
                XposedBridge.hookAllMethods(cls6, "setTint", new h3());
                XposedBridge.hookAllMethods(cls6, "setTintList", new j3());
            } catch (ClassNotFoundException e4) {
                ArrayList arrayList5 = g1.a;
            }
            XposedBridge.hookAllMethods(TypedArray.class, "getColor", new k3());
            XposedBridge.hookAllMethods(TypedArray.class, "getColorStateList", new l3());
            XposedBridge.hookAllMethods(Resources.class, "getColor", new m3());
            XposedBridge.hookAllMethods(Resources.class, "getColorStateList", new n3());
            XposedBridge.hookAllMethods(Context.class, "getColor", new o3());
            XposedBridge.hookAllMethods(Context.class, "getColorStateList", new p3());
            try {
                Class<?> cls7 = Class.forName("androidx.core.content.ContextCompat");
                XposedBridge.hookAllMethods(cls7, "getColor", new q3());
                XposedBridge.hookAllMethods(cls7, "getColorStateList", new r3());
            } catch (ClassNotFoundException e5) {
                ArrayList arrayList6 = g1.a;
            }
            try {
                Class<?> cls8 = Class.forName("androidx.core.content.res.ResourcesCompat");
                XposedBridge.hookAllMethods(cls8, "getColor", new s3());
                XposedBridge.hookAllMethods(cls8, "getColorStateList", new u3());
            } catch (ClassNotFoundException e6) {
                ArrayList arrayList7 = g1.a;
            }
            try {
                cls = Class.forName("com.airbnb.lottie.LottieAnimationView");
                Class<?> cls9 = Class.forName("com.airbnb.lottie.LottieProperty");
                cls2 = Class.forName("com.airbnb.lottie.model.KeyPath");
                str = "COLOR_FILTER";
                cls3 = null;
                z = false;
                cls4 = Class.forName("com.airbnb.lottie.value.LottieValueCallback");
                cls5 = cls9;
            } catch (ClassNotFoundException e7) {
                try {
                    cls = Class.forName("X.1561");
                    Class<?> cls10 = Class.forName("X.157Q");
                    cls2 = Class.forName("X.156X");
                    Class<?> cls11 = Class.forName("X.152v");
                    str = "LJJIJL";
                    cls3 = Class.forName("X.0Gqw");
                    z = true;
                    cls4 = cls11;
                    cls5 = cls10;
                } catch (ClassNotFoundException e8) {
                    e8.getMessage();
                    ArrayList arrayList8 = g1.a;
                    return;
                }
            }
            v3 v3Var = new v3(cls2, cls5, str, z, cls3, cls4);
            XposedBridge.hookAllMethods(cls, "playAnimation", v3Var);
            XposedBridge.hookAllMethods(cls, "setComposition", v3Var);
            ArrayList arrayList9 = g1.a;
        } catch (Exception e9) {
            e9.getMessage();
            ArrayList arrayList10 = g1.a;
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
            ArrayList arrayList = g1.a;
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
