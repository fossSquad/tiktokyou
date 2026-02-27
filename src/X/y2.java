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

public abstract class y2 {
    public static volatile int a = 0;
    public static volatile int b = 0;
    public static boolean c = true;
    public static volatile boolean d;

    public static int a() {
        int i;
        r0 r0VarA = r0.a();
        if (r0VarA != null && (i = r0VarA.j) != 0) {
            a = i;
            return a;
        }
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        Context contextB = q0.b();
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
            XposedBridge.hookAllMethods(Color.class, "parseColor", new d2());
            XposedBridge.hookAllMethods(Paint.class, "setColor", new o2());
            XposedBridge.hookAllMethods(TextView.class, "setTextColor", new r2());
            XposedBridge.hookAllMethods(GradientDrawable.class, "setColor", new s2());
            XposedBridge.hookAllMethods(GradientDrawable.class, "setStroke", new t2());
            XposedBridge.hookAllMethods(View.class, "setBackgroundColor", new u2());
            XposedBridge.hookAllMethods(Drawable.class, "setTint", new v2());
            XposedBridge.hookAllMethods(Drawable.class, "setTintList", new w2());
            XposedBridge.hookAllMethods(ImageView.class, "setColorFilter", new x2());
            XposedBridge.hookAllMethods(ColorStateList.class, "valueOf", new t1());
            try {
                XposedBridge.hookAllMethods(TuxIconView.class, "setTintColor", new u1());
                XposedBridge.hookAllMethods(TuxIconView.class, "setColor", new v1());
                ArrayList arrayList = q0.a;
            } catch (Exception e) {
                ArrayList arrayList2 = q0.a;
            }
            XposedBridge.hookAllConstructors(ForegroundColorSpan.class, new w1());
            XposedBridge.hookAllMethods(ImageView.class, "setImageTintList", new x1());
            XposedBridge.hookAllMethods(View.class, "setBackgroundTintList", new y1());
            XposedBridge.hookAllConstructors(PorterDuffColorFilter.class, new z1());
            try {
                XposedBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new a2());
            } catch (NoSuchMethodException e2) {
            }
            try {
                XposedBridge.hookAllMethods(Class.forName("androidx.core.widget.ImageViewCompat"), "setImageTintList", new b2());
                ArrayList arrayList3 = q0.a;
            } catch (ClassNotFoundException e3) {
                ArrayList arrayList4 = q0.a;
            }
            try {
                Class<?> cls6 = Class.forName("androidx.core.graphics.drawable.DrawableCompat");
                XposedBridge.hookAllMethods(cls6, "setTint", new c2());
                XposedBridge.hookAllMethods(cls6, "setTintList", new e2());
            } catch (ClassNotFoundException e4) {
                ArrayList arrayList5 = q0.a;
            }
            XposedBridge.hookAllMethods(TypedArray.class, "getColor", new f2());
            XposedBridge.hookAllMethods(TypedArray.class, "getColorStateList", new g2());
            XposedBridge.hookAllMethods(Resources.class, "getColor", new h2());
            XposedBridge.hookAllMethods(Resources.class, "getColorStateList", new i2());
            XposedBridge.hookAllMethods(Context.class, "getColor", new j2());
            XposedBridge.hookAllMethods(Context.class, "getColorStateList", new k2());
            try {
                Class<?> cls7 = Class.forName("androidx.core.content.ContextCompat");
                XposedBridge.hookAllMethods(cls7, "getColor", new l2());
                XposedBridge.hookAllMethods(cls7, "getColorStateList", new m2());
            } catch (ClassNotFoundException e5) {
                ArrayList arrayList6 = q0.a;
            }
            try {
                Class<?> cls8 = Class.forName("androidx.core.content.res.ResourcesCompat");
                XposedBridge.hookAllMethods(cls8, "getColor", new n2());
                XposedBridge.hookAllMethods(cls8, "getColorStateList", new p2());
            } catch (ClassNotFoundException e6) {
                ArrayList arrayList7 = q0.a;
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
                    ArrayList arrayList8 = q0.a;
                    return;
                }
            }
            q2 q2Var = new q2(cls2, cls5, str, z, cls3, cls4);
            XposedBridge.hookAllMethods(cls, "playAnimation", q2Var);
            XposedBridge.hookAllMethods(cls, "setComposition", q2Var);
            ArrayList arrayList9 = q0.a;
        } catch (Exception e9) {
            e9.getMessage();
            ArrayList arrayList10 = q0.a;
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
            ArrayList arrayList = q0.a;
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
