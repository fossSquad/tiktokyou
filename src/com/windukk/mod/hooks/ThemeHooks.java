package Z;

import Z.ag;
import Z.bg;
import Z.cf;
import Z.cg;
import Z.df;
import Z.dg;
import Z.ef;
import Z.eg;
import Z.ff;
import Z.fg;
import Z.gf;
import Z.gg;
import Z.h6;
import Z.hf;
import Z.hg;
import Z.jf;
import Z.kf;
import Z.lf;
import Z.m8;
import Z.mf;
import Z.n8;
import Z.nf;
import Z.of;
import Z.p8;
import Z.pf;
import Z.qf;
import Z.rf;
import Z.sf;
import Z.ta;
import Z.tf;
import Z.uf;
import Z.vf;
import Z.wf;
import Z.xf;
import Z.yf;
import Z.z7;
import Z.zf;

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

public abstract class ThemeHooks {
    public static volatile int a;
    public static volatile int b;
    public static final int[] c = {-119723, -185258, -65456, -14625300, -185259, -115876, -14707291, -10769679, -14625557, -10439938, -775342, -50340, -106644, -111558, -10540250, -46022, -16733196, -15814409, -15615276, -15482907, -14826819, -14821531, -8128513, -119723, -50314, -54187, -10087902, -181158, -1431475, -119980};
    public static volatile boolean d = true;
    public static volatile boolean e = false;

    public static int a() {
        int i;
        if (ta.a() != null && (i = ta.d().m) != 0) {
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
            HookBridge.hookAllMethods(Color.class, "parseColor", new nf());
            HookBridge.hookAllMethods(Paint.class, "setColor", new yf());
            HookBridge.hookAllMethods(TextView.class, "setTextColor", new bg());
            HookBridge.hookAllMethods(GradientDrawable.class, "setColor", new cg());
            HookBridge.hookAllMethods(GradientDrawable.class, "setStroke", new dg());
            HookBridge.hookAllMethods(View.class, "setBackgroundColor", new eg());
            HookBridge.hookAllMethods(Drawable.class, "setTint", new fg());
            HookBridge.hookAllMethods(Drawable.class, "setTintList", new gg());
            HookBridge.hookAllMethods(ImageView.class, "setColorFilter", new hg());
            HookBridge.hookAllMethods(ColorStateList.class, "valueOf", new cf());
            try {
                HookBridge.hookAllMethods(TuxIconView.class, "setTintColor", new df());
                HookBridge.hookAllMethods(TuxIconView.class, "setColor", new ef());
            } catch (Exception e2) {
                String strDecrypt = "TuxIconView not found";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), e2);
            }
            HookBridge.hookAllConstructors(ForegroundColorSpan.class, new ff());
            HookBridge.hookAllMethods(ImageView.class, "setImageTintList", new gf());
            HookBridge.hookAllMethods(View.class, "setBackgroundTintList", new hf());
            HookBridge.hookAllConstructors(PorterDuffColorFilter.class, new jf());
            try {
                HookBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new kf());
            } catch (NoSuchMethodException e3) {
            }
            try {
                HookBridge.hookAllMethods(ImageViewCompat.class, "setImageTintList", new lf());
            } catch (NoClassDefFoundError e4) {
                String strDecrypt2 = "ImageViewCompat not found";
                Object obj2 = h6.a;
                h6.a(6, String.valueOf(strDecrypt2), e4);
            }
            try {
                HookBridge.hookAllMethods(DrawableCompat.class, "setTint", new mf());
                HookBridge.hookAllMethods(DrawableCompat.class, "setTintList", new of());
            } catch (NoClassDefFoundError e5) {
                String strDecrypt3 = "DrawableCompat not found";
                Object obj3 = h6.a;
                h6.a(6, String.valueOf(strDecrypt3), e5);
            }
            HookBridge.hookAllMethods(TypedArray.class, "getColor", new pf());
            HookBridge.hookAllMethods(TypedArray.class, "getColorStateList", new qf());
            HookBridge.hookAllMethods(Resources.class, "getColor", new rf());
            HookBridge.hookAllMethods(Resources.class, "getColorStateList", new sf());
            HookBridge.hookAllMethods(Context.class, "getColor", new tf());
            HookBridge.hookAllMethods(Context.class, "getColorStateList", new uf());
            try {
                HookBridge.hookAllMethods(ContextCompat.class, "getColor", new vf());
                HookBridge.hookAllMethods(ContextCompat.class, "getColorStateList", new wf());
            } catch (NoClassDefFoundError e6) {
                String strDecrypt4 = "ContextCompat not found";
                Object obj4 = h6.a;
                h6.a(6, String.valueOf(strDecrypt4), e6);
            }
            try {
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColor", new xf());
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColorStateList", new zf());
            } catch (NoClassDefFoundError e7) {
                String strDecrypt5 = "ResourcesCompat not found";
                Object obj5 = h6.a;
                h6.a(6, String.valueOf(strDecrypt5), e7);
            }
            try {
                p8 p8Var = m8.a;
                Class<?> cls = Class.forName("X.01gi");
                z7 z7Var = n8.a;
                Class<?> cls2 = Class.forName("X.00Qz");
                ag agVar = new ag(Class.forName("X.1OsN"), cls2, n8.a.c[0], true, Class.forName("X.00Qd"), Class.forName("X.01QR"));
                HookBridge.hookAllMethods(cls, m8.a.c[0], agVar);
                HookBridge.hookAllMethods(cls, m8.b.c[0], agVar);
            } catch (ClassNotFoundException e8) {
                String strDecrypt6 = "Lottie classes not found";
                Object obj6 = h6.a;
                h6.a(6, String.valueOf(strDecrypt6), e8);
            }
        } catch (Exception e9) {
            String strDecrypt7 = "ThemeHelper init error";
            Object obj7 = h6.a;
            h6.a(6, String.valueOf(strDecrypt7), e9);
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
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), e2);
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
