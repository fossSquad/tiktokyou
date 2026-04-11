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

public abstract class k5 {
    public static volatile int a = 0;
    public static volatile int b = 0;
    public static boolean c = true;
    public static volatile boolean d;

    public static int a() {
        int i;
        r2 r2VarA = r2.a();
        if (r2VarA != null && (i = r2VarA.j) != 0) {
            a = i;
            return a;
        }
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        Context contextB = p2.b();
        if (contextB == null) {
            return -16524603;
        }
        int iA = a(contextB);
        b = iA;
        return iA;
    }

    public static void b() {
        try {
            XposedBridge.hookAllMethods(Color.class, "parseColor", new p4());
            XposedBridge.hookAllMethods(Paint.class, "setColor", new a5());
            XposedBridge.hookAllMethods(TextView.class, "setTextColor", new d5());
            XposedBridge.hookAllMethods(GradientDrawable.class, "setColor", new e5());
            XposedBridge.hookAllMethods(GradientDrawable.class, "setStroke", new f5());
            XposedBridge.hookAllMethods(View.class, "setBackgroundColor", new g5());
            XposedBridge.hookAllMethods(Drawable.class, "setTint", new h5());
            XposedBridge.hookAllMethods(Drawable.class, "setTintList", new i5());
            XposedBridge.hookAllMethods(ImageView.class, "setColorFilter", new j5());
            XposedBridge.hookAllMethods(ColorStateList.class, "valueOf", new f4());
            try {
                XposedBridge.hookAllMethods(TuxIconView.class, "setTintColor", new g4());
                XposedBridge.hookAllMethods(TuxIconView.class, "setColor", new h4());
                ArrayList arrayList = p2.a;
            } catch (Exception e) {
                ArrayList arrayList2 = p2.a;
            }
            XposedBridge.hookAllConstructors(ForegroundColorSpan.class, new i4());
            XposedBridge.hookAllMethods(ImageView.class, "setImageTintList", new j4());
            XposedBridge.hookAllMethods(View.class, "setBackgroundTintList", new k4());
            XposedBridge.hookAllConstructors(PorterDuffColorFilter.class, new l4());
            try {
                XposedBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new m4());
            } catch (NoSuchMethodException e2) {
            }
            try {
                XposedBridge.hookAllMethods(ImageViewCompat.class, "setImageTintList", new n4());
                ArrayList arrayList3 = p2.a;
            } catch (NoClassDefFoundError e3) {
                ArrayList arrayList4 = p2.a;
            }
            try {
                XposedBridge.hookAllMethods(DrawableCompat.class, "setTint", new o4());
                XposedBridge.hookAllMethods(DrawableCompat.class, "setTintList", new q4());
            } catch (NoClassDefFoundError e4) {
                ArrayList arrayList5 = p2.a;
            }
            XposedBridge.hookAllMethods(TypedArray.class, "getColor", new r4());
            XposedBridge.hookAllMethods(TypedArray.class, "getColorStateList", new s4());
            XposedBridge.hookAllMethods(Resources.class, "getColor", new t4());
            XposedBridge.hookAllMethods(Resources.class, "getColorStateList", new u4());
            XposedBridge.hookAllMethods(Context.class, "getColor", new v4());
            XposedBridge.hookAllMethods(Context.class, "getColorStateList", new w4());
            try {
                XposedBridge.hookAllMethods(ContextCompat.class, "getColor", new x4());
                XposedBridge.hookAllMethods(ContextCompat.class, "getColorStateList", new y4());
            } catch (NoClassDefFoundError e5) {
                ArrayList arrayList6 = p2.a;
            }
            try {
                XposedBridge.hookAllMethods(ResourcesCompat.class, "getColor", new z4());
                XposedBridge.hookAllMethods(ResourcesCompat.class, "getColorStateList", new b5());
            } catch (NoClassDefFoundError e6) {
                ArrayList arrayList7 = p2.a;
            }
            try {
                Class<?> cls = Class.forName("X.123n");
                c5 c5Var = new c5(Class.forName("X.0zZs"), Class.forName("X.1236"), "LJJIJL", true, Class.forName("X.0FOE"), Class.forName("X.123U"));
                XposedBridge.hookAllMethods(cls, "playAnimation", c5Var);
                XposedBridge.hookAllMethods(cls, "setComposition", c5Var);
            } catch (ClassNotFoundException e7) {
                e7.getMessage();
                ArrayList arrayList8 = p2.a;
            }
        } catch (Exception e8) {
            e8.getMessage();
            ArrayList arrayList9 = p2.a;
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
            ArrayList arrayList = p2.a;
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
