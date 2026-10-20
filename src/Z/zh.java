package Z;

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
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;

public abstract class zh {
    public static volatile int a;
    public static volatile int b;
    public static final int[] c = {-119723, -185258, -65456, -14625300, -185259, -115876, -14707291, -10769679, -14625557, -10439938, -775342, -50340, -106644, -111558, -10540250, -46022, -16733196, -15814409, -15615276, -15482907, -14826819, -14821531, -8128513, -119723, -50314, -54187, -10087902, -181158, -1431475, -119980};
    public static volatile boolean d = true;
    public static volatile boolean e = false;

    public static int a() {
        int i;
        if (ac.a() != null && (i = ac.e().r) != 0) {
            a = i;
            return a;
        }
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        Context contextA = Main.getApplicationContext();
        if (contextA == null) {
            return -16524603;
        }
        int iA = a(contextA);
        b = iA;
        return iA;
    }

    public static void b() {
        try {
            HookBridge.hookAllMethods(Color.class, "parseColor", new eh());
            HookBridge.hookAllMethods(Paint.class, "setColor", new ph());
            HookBridge.hookAllMethods(TextView.class, "setTextColor", new sh());
            HookBridge.hookAllMethods(GradientDrawable.class, "setColor", new th());
            HookBridge.hookAllMethods(GradientDrawable.class, "setStroke", new uh());
            HookBridge.hookAllMethods(View.class, "setBackgroundColor", new vh());
            HookBridge.hookAllMethods(Drawable.class, "setTint", new wh());
            HookBridge.hookAllMethods(Drawable.class, "setTintList", new xh());
            HookBridge.hookAllMethods(ImageView.class, "setColorFilter", new yh());
            HookBridge.hookAllMethods(ColorStateList.class, "valueOf", new ug());
            try {
                HookBridge.hookAllMethods(TuxIconView.class, "setTintColor", new vg());
                HookBridge.hookAllMethods(TuxIconView.class, "setColor", new wg());
            } catch (Exception e2) {
                String strDecrypt = "TuxIconView not found";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), e2);
            }
            HookBridge.hookAllConstructors(ForegroundColorSpan.class, new xg());
            HookBridge.hookAllMethods(ImageView.class, "setImageTintList", new yg());
            HookBridge.hookAllMethods(View.class, "setBackgroundTintList", new zg());
            HookBridge.hookAllConstructors(PorterDuffColorFilter.class, new ah());
            try {
                HookBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new bh());
            } catch (NoSuchMethodException e3) {
            }
            try {
                HookBridge.hookAllMethods(ImageViewCompat.class, "setImageTintList", new ch());
            } catch (NoClassDefFoundError e4) {
                String strDecrypt2 = "ImageViewCompat not found";
                Object obj2 = g7.a;
                g7.a(6, String.valueOf(strDecrypt2), e4);
            }
            try {
                HookBridge.hookAllMethods(DrawableCompat.class, "setTint", new dh());
                HookBridge.hookAllMethods(DrawableCompat.class, "setTintList", new fh());
            } catch (NoClassDefFoundError e5) {
                String strDecrypt3 = "DrawableCompat not found";
                Object obj3 = g7.a;
                g7.a(6, String.valueOf(strDecrypt3), e5);
            }
            HookBridge.hookAllMethods(TypedArray.class, "getColor", new gh());
            HookBridge.hookAllMethods(TypedArray.class, "getColorStateList", new hh());
            HookBridge.hookAllMethods(Resources.class, "getColor", new ih());
            HookBridge.hookAllMethods(Resources.class, "getColorStateList", new jh());
            HookBridge.hookAllMethods(Context.class, "getColor", new kh());
            HookBridge.hookAllMethods(Context.class, "getColorStateList", new lh());
            try {
                HookBridge.hookAllMethods(ContextCompat.class, "getColor", new mh());
                HookBridge.hookAllMethods(ContextCompat.class, "getColorStateList", new nh());
            } catch (NoClassDefFoundError e6) {
                String strDecrypt4 = "ContextCompat not found";
                Object obj4 = g7.a;
                g7.a(6, String.valueOf(strDecrypt4), e6);
            }
            try {
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColor", new oh());
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColorStateList", new qh());
            } catch (NoClassDefFoundError e7) {
                String strDecrypt5 = "ResourcesCompat not found";
                Object obj5 = g7.a;
                g7.a(6, String.valueOf(strDecrypt5), e7);
            }
            try {
                v9 v9Var = r9.a;
                Class<?> cls = Class.forName("X.01ea");
                e9 e9Var = s9.a;
                Class<?> cls2 = Class.forName("X.00RN");
                rh rhVar = new rh(Class.forName("X.1OvV"), cls2, s9.a.c[0], true, Class.forName("X.00R1"), Class.forName("X.01Pv"));
                HookBridge.hookAllMethods(cls, r9.a.c[0], rhVar);
                HookBridge.hookAllMethods(cls, r9.b.c[0], rhVar);
            } catch (ClassNotFoundException e8) {
                String strDecrypt6 = "Lottie classes not found";
                Object obj6 = g7.a;
                g7.a(6, String.valueOf(strDecrypt6), e8);
            }
        } catch (Exception e9) {
            String strDecrypt7 = "ThemeHelper init error";
            Object obj7 = g7.a;
            g7.a(6, String.valueOf(strDecrypt7), e9);
        }
    }

    public static int a(Context context) {
        if (e) {
            return -16524603;
        }
        e = true;
        boolean z = d;
        d = false;
        try {
            Resources resources = context.getResources();
            String[] strArr = {"system_accent1_500", "system_accent1_600", "system_accent2_500", "system_accent3_500"};
            for (int i = 0; i < 4; i++) {
                int identifier = resources.getIdentifier(strArr[i], "color", "android");
                if (identifier != 0) {
                    return resources.getColor(identifier, null);
                }
            }
        } catch (Exception e2) {
            String strDecrypt = "getMonetAccentColor error";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), e2);
        } finally {
            d = z;
            e = false;
        }
        return -16524603;
    }

    public static int a(int i) {
        int i2;
        if (!d || i == 0 || i == -16777216 || (i2 = (i >>> 24) & 255) == 0) {
            return i;
        }
        int i3 = (-16777216) | i;
        int[] iArr = c;
        for (int i4 = 0; i4 < 30; i4++) {
            if (i3 == iArr[i4]) {
                return (i2 << 24) | (a() & 16777215);
            }
        }
        int i5 = (i >> 16) & 255;
        return (i5 < 160 || i5 - Math.max((i >> 8) & 255, i & 255) < 48) ? i : (i2 << 24) | (a() & 16777215);
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (!d) {
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
        } catch (Exception e2) {
        }
        return colorStateList;
    }
}
