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
import com.windukk.hook.HookBridge;

public abstract class hd {
    public static volatile int a = 0;
    public static volatile int b = 0;
    public static boolean c = true;
    public static volatile boolean d;

    public static int a() {
        int i;
        l8 l8VarA = l8.a();
        if (l8VarA != null && (i = l8VarA.l) != 0) {
            a = i;
            return a;
        }
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        Context contextC = g5.c();
        if (contextC == null) {
            return -16524603;
        }
        int iA = a(contextC);
        b = iA;
        return iA;
    }

    public static void b() {
        try {
            HookBridge.hookAllMethods(Color.class, "parseColor", new mc());
            HookBridge.hookAllMethods(Paint.class, "setColor", new xc());
            HookBridge.hookAllMethods(TextView.class, "setTextColor", new ad());
            HookBridge.hookAllMethods(GradientDrawable.class, "setColor", new bd());
            HookBridge.hookAllMethods(GradientDrawable.class, "setStroke", new cd());
            HookBridge.hookAllMethods(View.class, "setBackgroundColor", new dd());
            HookBridge.hookAllMethods(Drawable.class, "setTint", new ed());
            HookBridge.hookAllMethods(Drawable.class, "setTintList", new fd());
            HookBridge.hookAllMethods(ImageView.class, "setColorFilter", new gd());
            HookBridge.hookAllMethods(ColorStateList.class, "valueOf", new cc());
            try {
                HookBridge.hookAllMethods(TuxIconView.class, "setTintColor", new dc());
                HookBridge.hookAllMethods(TuxIconView.class, "setColor", new ec());
                int i = g5.a;
            } catch (Exception e) {
                int i2 = g5.a;
            }
            HookBridge.hookAllConstructors(ForegroundColorSpan.class, new fc());
            HookBridge.hookAllMethods(ImageView.class, "setImageTintList", new gc());
            HookBridge.hookAllMethods(View.class, "setBackgroundTintList", new hc());
            HookBridge.hookAllConstructors(PorterDuffColorFilter.class, new ic());
            try {
                HookBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new jc());
            } catch (NoSuchMethodException e2) {
            }
            try {
                HookBridge.hookAllMethods(ImageViewCompat.class, "setImageTintList", new kc());
                int i3 = g5.a;
            } catch (NoClassDefFoundError e3) {
                int i4 = g5.a;
            }
            try {
                HookBridge.hookAllMethods(DrawableCompat.class, "setTint", new lc());
                HookBridge.hookAllMethods(DrawableCompat.class, "setTintList", new nc());
            } catch (NoClassDefFoundError e4) {
                int i5 = g5.a;
            }
            HookBridge.hookAllMethods(TypedArray.class, "getColor", new oc());
            HookBridge.hookAllMethods(TypedArray.class, "getColorStateList", new pc());
            HookBridge.hookAllMethods(Resources.class, "getColor", new qc());
            HookBridge.hookAllMethods(Resources.class, "getColorStateList", new rc());
            HookBridge.hookAllMethods(Context.class, "getColor", new sc());
            HookBridge.hookAllMethods(Context.class, "getColorStateList", new tc());
            try {
                HookBridge.hookAllMethods(ContextCompat.class, "getColor", new uc());
                HookBridge.hookAllMethods(ContextCompat.class, "getColorStateList", new vc());
            } catch (NoClassDefFoundError e5) {
                int i6 = g5.a;
            }
            try {
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColor", new wc());
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColorStateList", new yc());
            } catch (NoClassDefFoundError e6) {
                int i7 = g5.a;
            }
            try {
                t6 t6Var = q6.a;
                Class<?> cls = Class.forName("X.1Ddb");
                k6 k6Var = r6.a;
                Class<?> cls2 = Class.forName("X.1DfB");
                zc zcVar = new zc(Class.forName("X.17x8"), cls2, r6.a.c[0], true, Class.forName("X.0so8"), Class.forName("X.1DeK"));
                HookBridge.hookAllMethods(cls, q6.a.c[0], zcVar);
                HookBridge.hookAllMethods(cls, q6.b.c[0], zcVar);
            } catch (ClassNotFoundException e7) {
                e7.getMessage();
                int i8 = g5.a;
            }
        } catch (Exception e8) {
            e8.getMessage();
            int i9 = g5.a;
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
            int i2 = g5.a;
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
