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

public abstract class x6 {
    public static volatile int a = 0;
    public static volatile int b = 0;
    public static boolean c = true;
    public static volatile boolean d;

    public static int a() {
        int i;
        y3 y3VarA = y3.a();
        if (y3VarA != null && (i = y3VarA.j) != 0) {
            a = i;
            return a;
        }
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        Context contextC = v3.c();
        if (contextC == null) {
            return -16524603;
        }
        int iA = a(contextC);
        b = iA;
        return iA;
    }

    public static void b() {
        try {
            HookBridge.hookAllMethods(Color.class, "parseColor", new c6());
            HookBridge.hookAllMethods(Paint.class, "setColor", new n6());
            HookBridge.hookAllMethods(TextView.class, "setTextColor", new q6());
            HookBridge.hookAllMethods(GradientDrawable.class, "setColor", new r6());
            HookBridge.hookAllMethods(GradientDrawable.class, "setStroke", new s6());
            HookBridge.hookAllMethods(View.class, "setBackgroundColor", new t6());
            HookBridge.hookAllMethods(Drawable.class, "setTint", new u6());
            HookBridge.hookAllMethods(Drawable.class, "setTintList", new v6());
            HookBridge.hookAllMethods(ImageView.class, "setColorFilter", new w6());
            HookBridge.hookAllMethods(ColorStateList.class, "valueOf", new s5());
            try {
                HookBridge.hookAllMethods(TuxIconView.class, "setTintColor", new t5());
                HookBridge.hookAllMethods(TuxIconView.class, "setColor", new u5());
                int i = v3.a;
            } catch (Exception e) {
                int i2 = v3.a;
            }
            HookBridge.hookAllConstructors(ForegroundColorSpan.class, new v5());
            HookBridge.hookAllMethods(ImageView.class, "setImageTintList", new w5());
            HookBridge.hookAllMethods(View.class, "setBackgroundTintList", new x5());
            HookBridge.hookAllConstructors(PorterDuffColorFilter.class, new y5());
            try {
                HookBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new z5());
            } catch (NoSuchMethodException e2) {
            }
            try {
                HookBridge.hookAllMethods(ImageViewCompat.class, "setImageTintList", new a6());
                int i3 = v3.a;
            } catch (NoClassDefFoundError e3) {
                int i4 = v3.a;
            }
            try {
                HookBridge.hookAllMethods(DrawableCompat.class, "setTint", new b6());
                HookBridge.hookAllMethods(DrawableCompat.class, "setTintList", new d6());
            } catch (NoClassDefFoundError e4) {
                int i5 = v3.a;
            }
            HookBridge.hookAllMethods(TypedArray.class, "getColor", new e6());
            HookBridge.hookAllMethods(TypedArray.class, "getColorStateList", new f6());
            HookBridge.hookAllMethods(Resources.class, "getColor", new g6());
            HookBridge.hookAllMethods(Resources.class, "getColorStateList", new h6());
            HookBridge.hookAllMethods(Context.class, "getColor", new i6());
            HookBridge.hookAllMethods(Context.class, "getColorStateList", new j6());
            try {
                HookBridge.hookAllMethods(ContextCompat.class, "getColor", new k6());
                HookBridge.hookAllMethods(ContextCompat.class, "getColorStateList", new l6());
            } catch (NoClassDefFoundError e5) {
                int i6 = v3.a;
            }
            try {
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColor", new m6());
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColorStateList", new o6());
            } catch (NoClassDefFoundError e6) {
                int i7 = v3.a;
            }
            try {
                Class<?> cls = Class.forName("X.15gG");
                p6 p6Var = new p6(Class.forName("X.15gy"), Class.forName("X.15hx"), "LJJIJL", true, Class.forName("X.0tip"), Class.forName("X.15hI"));
                HookBridge.hookAllMethods(cls, "playAnimation", p6Var);
                HookBridge.hookAllMethods(cls, "setComposition", p6Var);
            } catch (ClassNotFoundException e7) {
                e7.getMessage();
                int i8 = v3.a;
            }
        } catch (Exception e8) {
            e8.getMessage();
            int i9 = v3.a;
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
            int i2 = v3.a;
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
