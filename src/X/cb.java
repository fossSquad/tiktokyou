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

public abstract class cb {
    public static volatile int a = 0;
    public static volatile int b = 0;
    public static boolean c = true;
    public static volatile boolean d;

    public static int a() {
        int i;
        d7 d7VarA = d7.a();
        if (d7VarA != null && (i = d7VarA.k) != 0) {
            a = i;
            return a;
        }
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        Context contextC = p4.c();
        if (contextC == null) {
            return -16524603;
        }
        int iA = a(contextC);
        b = iA;
        return iA;
    }

    public static void b() {
        try {
            HookBridge.hookAllMethods(Color.class, "parseColor", new ha());
            HookBridge.hookAllMethods(Paint.class, "setColor", new sa());
            HookBridge.hookAllMethods(TextView.class, "setTextColor", new va());
            HookBridge.hookAllMethods(GradientDrawable.class, "setColor", new wa());
            HookBridge.hookAllMethods(GradientDrawable.class, "setStroke", new xa());
            HookBridge.hookAllMethods(View.class, "setBackgroundColor", new ya());
            HookBridge.hookAllMethods(Drawable.class, "setTint", new za());
            HookBridge.hookAllMethods(Drawable.class, "setTintList", new ab());
            HookBridge.hookAllMethods(ImageView.class, "setColorFilter", new bb());
            HookBridge.hookAllMethods(ColorStateList.class, "valueOf", new x9());
            try {
                HookBridge.hookAllMethods(TuxIconView.class, "setTintColor", new y9());
                HookBridge.hookAllMethods(TuxIconView.class, "setColor", new z9());
                int i = p4.a;
            } catch (Exception e) {
                int i2 = p4.a;
            }
            HookBridge.hookAllConstructors(ForegroundColorSpan.class, new aa());
            HookBridge.hookAllMethods(ImageView.class, "setImageTintList", new ba());
            HookBridge.hookAllMethods(View.class, "setBackgroundTintList", new ca());
            HookBridge.hookAllConstructors(PorterDuffColorFilter.class, new da());
            try {
                HookBridge.hookMethod(Drawable.class.getMethod("setColorFilter", Integer.TYPE, PorterDuff.Mode.class), new ea());
            } catch (NoSuchMethodException e2) {
            }
            try {
                HookBridge.hookAllMethods(ImageViewCompat.class, "setImageTintList", new fa());
                int i3 = p4.a;
            } catch (NoClassDefFoundError e3) {
                int i4 = p4.a;
            }
            try {
                HookBridge.hookAllMethods(DrawableCompat.class, "setTint", new ga());
                HookBridge.hookAllMethods(DrawableCompat.class, "setTintList", new ia());
            } catch (NoClassDefFoundError e4) {
                int i5 = p4.a;
            }
            HookBridge.hookAllMethods(TypedArray.class, "getColor", new ja());
            HookBridge.hookAllMethods(TypedArray.class, "getColorStateList", new ka());
            HookBridge.hookAllMethods(Resources.class, "getColor", new la());
            HookBridge.hookAllMethods(Resources.class, "getColorStateList", new ma());
            HookBridge.hookAllMethods(Context.class, "getColor", new na());
            HookBridge.hookAllMethods(Context.class, "getColorStateList", new oa());
            try {
                HookBridge.hookAllMethods(ContextCompat.class, "getColor", new pa());
                HookBridge.hookAllMethods(ContextCompat.class, "getColorStateList", new qa());
            } catch (NoClassDefFoundError e5) {
                int i6 = p4.a;
            }
            try {
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColor", new ra());
                HookBridge.hookAllMethods(ResourcesCompat.class, "getColorStateList", new ta());
            } catch (NoClassDefFoundError e6) {
                int i7 = p4.a;
            }
            try {
                x5 x5Var = v5.a;
                Class<?> cls = Class.forName("X.1AJZ");
                p5 p5Var = w5.a;
                Class<?> cls2 = Class.forName("X.1AJq");
                ua uaVar = new ua(Class.forName("X.1AK0"), cls2, w5.a.c[0], true, Class.forName("X.0iuD"), Class.forName("X.1AKP"));
                HookBridge.hookAllMethods(cls, v5.a.c[0], uaVar);
                HookBridge.hookAllMethods(cls, v5.b.c[0], uaVar);
            } catch (ClassNotFoundException e7) {
                e7.getMessage();
                int i8 = p4.a;
            }
        } catch (Exception e8) {
            e8.getMessage();
            int i9 = p4.a;
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
            int i2 = p4.a;
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
