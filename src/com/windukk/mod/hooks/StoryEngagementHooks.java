package Z;

import Z.ba;
import Z.h6;
import Z.p8;
import Z.te;
import Z.ue;
import Z.ve;
import Z.we;

import android.graphics.Typeface;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.tux.icon.TuxIconView;
import com.ss.android.ugc.aweme.story.feed.immersive.component.StoryShareComponent;
import com.ss.android.ugc.aweme.story.feed.immersive.digg.ImmersiveStoryDiggAssem;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class StoryEngagementHooks {
    public static final Map a = Collections.synchronizedMap(new WeakHashMap());
    public static final Map b = Collections.synchronizedMap(new WeakHashMap());
    public static final Map c = Collections.synchronizedMap(new WeakHashMap());
    public static final Map d = Collections.synchronizedMap(new WeakHashMap());
    public static volatile Field e;

    public static void a() {
        try {
            HookBridge.hookMethod(ImmersiveStoryDiggAssem.class.getDeclaredMethod("onViewCreated", View.class), new te());
            p8 p8Var = ba.a;
            Class<?> cls = Class.forName("kotlin.jvm.internal.AFwS242S0000000_23_I1");
            HookBridge.hookMethod(ba.a.a(cls, cls, Object.class, Object.class), new ue());
            HookBridge.hookMethod(StoryShareComponent.class.getDeclaredMethod("onViewCreated", View.class), new ve());
            HookBridge.hookMethod(ca.a.a(StoryShareComponent.class, Object.class), new we());
            String strDecrypt = "Story viewer engagement counts initialized";
            Object obj = h6.a;
            h6.a(4, String.valueOf(strDecrypt), (Throwable) null);
        } catch (Throwable th) {
            String strDecrypt2 = "Story viewer engagement count init failed";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th);
        }
    }

    public static void b(final Object obj, final View view) {
        Map map = b;
        TextView textView = (TextView) map.get(obj);
        if (textView != null && textView.isAttachedToWindow()) {
            b(textView, (String) d.get(obj));
            return;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            view.post(new Runnable() {
                @Override
                public final void run() {
                    StoryEngagementHooks.b(obj, view);
                }
            });
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = layoutParams != null ? layoutParams.width : 0;
        float f = 44;
        int iA = Main.dp(f);
        if (i <= 0) {
            i = iA;
        }
        int i2 = layoutParams != null ? layoutParams.height : 0;
        int iA2 = Main.dp(f);
        if (i2 <= 0) {
            i2 = iA2;
        }
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(Main.dp(f), Main.dp(f));
        }
        viewGroup.removeViewAt(iIndexOfChild);
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(view, new FrameLayout.LayoutParams(i, i2, 17));
        view.setTranslationY(Main.dp(-8));
        TextView textViewA = a(view);
        frameLayout.addView(textViewA, new FrameLayout.LayoutParams(-1, Main.dp(16), 81));
        viewGroup.addView(frameLayout, iIndexOfChild);
        map.put(obj, textViewA);
        b(textViewA, (String) d.get(obj));
    }

    public static void b(View view) {
        if (view instanceof TuxIconView) {
            TuxIconView tuxIconView = (TuxIconView) view;
            float f = 24;
            tuxIconView.setIconWidth(Main.dp(f));
            tuxIconView.setIconHeight(Main.dp(f));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                b(viewGroup.getChildAt(i));
            }
        }
    }

    public static void b(final TextView textView, final String str) {
        if (textView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (textView.getHandler() != null && Looper.myLooper() != textView.getHandler().getLooper()) {
            textView.post(new Runnable() {
                @Override
                public final void run() {
                    textView.setText(str);
                }
            });
        } else {
            textView.setText(str);
        }
    }

    public static void a(Object obj, View view) {
        if (!(view instanceof LinearLayout)) {
            String str = "Story digg root is not LinearLayout: " + view.getClass().getName();
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(str), (Throwable) null);
            return;
        }
        Map map = a;
        TextView textView = (TextView) map.get(obj);
        if (textView == null || textView.getParent() == null) {
            LinearLayout linearLayout = (LinearLayout) view;
            if (linearLayout.getChildCount() != 0 && (linearLayout.getChildAt(0) instanceof FrameLayout)) {
                FrameLayout frameLayout = (FrameLayout) linearLayout.getChildAt(0);
                if (frameLayout.getChildCount() > 0) {
                    View childAt = frameLayout.getChildAt(0);
                    b(childAt);
                    childAt.setTranslationY(Main.dp(-8));
                }
                TextView textViewA = a(view);
                frameLayout.addView(textViewA, new FrameLayout.LayoutParams(-1, Main.dp(16), 81));
                map.put(obj, textViewA);
                b(textViewA, (String) c.get(obj));
                return;
            }
            String strDecrypt = "Story digg icon container was not found";
            Object obj3 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), (Throwable) null);
        }
    }

    public static void a(ImmersiveStoryDiggAssem immersiveStoryDiggAssem, Object obj) throws IllegalAccessException, NoSuchFieldException {
        if (obj == null) {
            return;
        }
        Field fieldA = e;
        if (fieldA == null || !fieldA.getDeclaringClass().isInstance(obj)) {
            fieldA = ka.a.a(obj.getClass());
            e = fieldA;
        }
        Object obj2 = fieldA.get(obj);
        String string = obj2 != null ? obj2.toString() : "0";
        c.put(immersiveStoryDiggAssem, string);
        b((TextView) a.get(immersiveStoryDiggAssem), string);
    }

    public static TextView a(View view) {
        TextView textView = new TextView(view.getContext());
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(2, 11.0f);
        textView.setTypeface(Typeface.DEFAULT, 1);
        textView.setSingleLine(true);
        textView.setIncludeFontPadding(false);
        float f = 1;
        textView.setShadowLayer(Main.dp(f), 0.0f, Main.dp(f), -1728053248);
        textView.setImportantForAccessibility(2);
        textView.setClickable(false);
        textView.setFocusable(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, Main.dp(16));
        layoutParams.gravity = 1;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public static String a(long j, long j2, String str) {
        double d2 = j / j2;
        if (d2 < 100.0d && d2 != Math.rint(d2)) {
            return String.format(Locale.US, "%.1f%s", Double.valueOf(d2), str);
        }
        return String.format(Locale.US, "%.0f%s", Double.valueOf(d2), str);
    }
}
