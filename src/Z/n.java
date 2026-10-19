package Z;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.ss.android.ugc.aweme.feed.ui.FeedFragment;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public abstract class n {
    public static final String[] a;
    public static final WeakHashMap b;
    public static final WeakHashMap c;
    public static final WeakHashMap d;
    public static boolean e;
    public static int[] f;
    public static int g;
    public static int h;
    public static int i;
    public static int j;
    public static Bitmap k;
    public static Bitmap l;

    static {
        a = new String[]{"widget_container", "zej", "onp", "gradual_bottom", "title_shadow", "video_sticker_container_area", "video_seek_bar", "cnj"};
        b = new WeakHashMap();
        c = new WeakHashMap();
        d = new WeakHashMap();
        e = false;
        f = new int[16];
        g = 0;
        h = -1;
        i = -1;
        j = -1;
    }

    public static void a() {
        try {
            if (ac.a() != null && ac.e().g && ac.e().h) {
                ac.e().c(true);
            }
            HookBridge.hookMethod(View.class.getDeclaredMethod("onAttachedToWindow", null), new f());
            HookBridge.hookMethod(FeedFragment.class.getMethod("onViewCreated", View.class, Bundle.class), new e());
            HookBridge.hookMethod(View.class.getDeclaredMethod("setVisibility", Integer.TYPE), new d());
        } catch (Throwable th) {
            String strDecrypt = "Initialization error";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void b(View view) {
        if (j == -1 || view == null || !y5.a().g) {
            return;
        }
        WeakHashMap weakHashMap = c;
        if (weakHashMap.containsKey(view)) {
            e(view);
            g(view);
            f(view);
            return;
        }
        weakHashMap.put(view, Boolean.TRUE);
        e(view);
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.setClickable(true);
        view.setLongClickable(true);
        view.setContentDescription("Anti-burnout");
        view.addOnAttachStateChangeListener(new j());
        view.setOnClickListener(new k());
        view.setOnLongClickListener(new l());
        g(view);
        f(view);
    }

    public static void c(View view, m mVar) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        int i2 = j;
        if (i2 != -1 && id == i2) {
            b(view);
            return;
        }
        int i3 = 0;
        if (id != -1 && id != 0) {
            for (int i4 = 0; i4 < g; i4++) {
                if (f[i4] == id) {
                    if ((id == -1 || id == 0 || !(id == h || id == i)) && !c(view)) {
                        a(view, mVar);
                        return;
                    } else {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            while (i3 < viewGroup.getChildCount()) {
                                b(viewGroup.getChildAt(i3), mVar);
                                i3++;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            while (i3 < viewGroup2.getChildCount()) {
                c(viewGroup2.getChildAt(i3), mVar);
                i3++;
            }
        }
    }

    public static m d(View view) {
        View rootView = view.getRootView();
        if ((rootView instanceof ViewGroup) || !(view instanceof ViewGroup)) {
            view = rootView;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        WeakHashMap weakHashMap = b;
        m mVar = (m) weakHashMap.get(viewGroup);
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(viewGroup);
        weakHashMap.put(viewGroup, mVar2);
        viewGroup.addOnLayoutChangeListener(new g(mVar2));
        mVar2.d = new h(mVar2);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(mVar2.d);
        viewGroup.addOnAttachStateChangeListener(new i(viewGroup, mVar2));
        return mVar2;
    }

    public static void e(View view) {
        ArrayList arrayList = new ArrayList(b.values());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            m mVar = (m) obj;
            Iterator it = mVar.b.iterator();
            boolean z = false;
            while (it.hasNext()) {
                View view2 = (View) ((WeakReference) it.next()).get();
                if (view2 != null && view2 != view) {
                    for (Object parent = view.getParent(); parent instanceof View; parent = ((View) parent).getParent()) {
                        if (parent == view2) {
                            Float f2 = (Float) mVar.c.get(view2);
                            view2.animate().cancel();
                            view2.setAlpha(f2 != null ? f2.floatValue() : 1.0f);
                            mVar.c.remove(view2);
                            it.remove();
                            z = true;
                            break;
                        }
                    }
                }
            }
            if (z) {
                mVar.g = true;
                Object parent2 = view.getParent();
                if (parent2 instanceof View) {
                    b((View) parent2, mVar);
                }
            }
        }
    }

    public static void f(View view) {
        int i2;
        Bitmap bitmap;
        boolean zB = b();
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Context context = view.getContext();
            if (context == null) {
                bitmap = null;
            } else if (zB) {
                if (k == null) {
                    String strDecrypt = "ic_settings_burn-in-on";
                    int i3 = sf.h;
                    k = hi.a(context, strDecrypt);
                }
                bitmap = k;
            } else {
                if (l == null) {
                    String strDecrypt2 = "ic_settings_burn-in-off";
                    int i4 = sf.h;
                    l = hi.a(context, strDecrypt2);
                }
                bitmap = l;
            }
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                int iA = Main.dp(14.0f);
                imageView.setPadding(iA, iA, iA, iA);
            }
        }
        float fMax = 1.0f;
        if (zB) {
            if (ac.a() == null || (i2 = ac.e().s) >= 100) {
                fMax = 0.0f;
            } else if (i2 > 0) {
                fMax = (100 - i2) / 100.0f;
            }
            fMax = Float.max(0.2f, fMax);
        }
        view.setAlpha(fMax);
        view.setActivated(zB);
        view.setSelected(zB);
    }

    public static void g(View view) {
        if (view != null) {
            if (view.getParent() != null || view.isAttachedToWindow()) {
                WeakHashMap weakHashMap = d;
                ObjectAnimator objectAnimator = (ObjectAnimator) weakHashMap.get(view);
                if (objectAnimator == null || !objectAnimator.isStarted()) {
                    float fA = Main.dp(5.0f);
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", -fA, fA);
                    objectAnimatorOfFloat.setDuration(40000L);
                    objectAnimatorOfFloat.setRepeatCount(-1);
                    objectAnimatorOfFloat.setRepeatMode(2);
                    objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                    objectAnimatorOfFloat.start();
                    weakHashMap.put(view, objectAnimatorOfFloat);
                }
            }
        }
    }

    public static void a(Context context) {
        if (e || context == null) {
            return;
        }
        for (String str : a) {
            int identifier = context.getResources().getIdentifier(str, "id", context.getPackageName());
            if (identifier != -1 && identifier != 0) {
                int i2 = 0;
                while (true) {
                    int i3 = g;
                    if (i2 < i3) {
                        if (f[i2] == identifier) {
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        int[] iArr = f;
                        if (i3 == iArr.length) {
                            int[] iArr2 = new int[iArr.length * 2];
                            System.arraycopy(iArr, 0, iArr2, 0, i3);
                            f = iArr2;
                        }
                        int[] iArr3 = f;
                        int i4 = g;
                        iArr3[i4] = identifier;
                        g = i4 + 1;
                        break;
                    }
                }
            }
        }
        h = context.getResources().getIdentifier("widget_container", "id", context.getPackageName());
        i = context.getResources().getIdentifier("zej", "id", context.getPackageName());
        j = context.getResources().getIdentifier("k_d", "id", context.getPackageName());
        e = true;
    }

    public static boolean c(View view) {
        if (view != null && j != -1) {
            int id = view.getId();
            int i2 = j;
            if (i2 != -1 && id == i2) {
                return true;
            }
            if (!(view instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                if (c(viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void c() {
        Iterator it = c.keySet().iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view != null && (view.getParent() != null || view.isAttachedToWindow())) {
                g(view);
                f(view);
            } else {
                a(view);
                it.remove();
            }
        }
    }

    public static void a(m mVar, long j2, boolean z) {
        ViewGroup viewGroup = (ViewGroup) mVar.a.get();
        if (viewGroup == null) {
            return;
        }
        if (z && mVar.f) {
            return;
        }
        if (z) {
            mVar.f = true;
        }
        viewGroup.postDelayed(new c(mVar), j2);
    }

    public static void a(View view, m mVar) {
        if (view != null) {
            int id = view.getId();
            int i2 = j;
            if (i2 == -1 || id != i2) {
                if (c(view)) {
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                            b(viewGroup.getChildAt(i3), mVar);
                        }
                        return;
                    }
                    return;
                }
                ArrayList arrayList = mVar.b;
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    if (((WeakReference) obj).get() == view) {
                        return;
                    }
                }
                mVar.b.add(new WeakReference(view));
                WeakHashMap weakHashMap = mVar.c;
                float alpha = view.getAlpha();
                if (alpha < 0.01f || alpha > 1.0f) {
                    alpha = 1.0f;
                }
                weakHashMap.put(view, Float.valueOf(alpha));
                if (b()) {
                    a(view, mVar, false);
                }
            }
        }
    }

    public static void b(m mVar, boolean z) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = (ViewGroup) mVar.a.get();
        if (viewGroup2 == null || g == 0) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (z || jUptimeMillis - mVar.l >= 60) {
            mVar.l = jUptimeMillis;
            a(mVar);
            c(viewGroup2, mVar);
            boolean z2 = false;
            if (mVar.h) {
                a(mVar, false);
            }
            if (mVar.i && (viewGroup = (ViewGroup) mVar.a.get()) != null) {
                ac acVarA = ac.a();
                if (mVar.h && acVarA != null && ac.e().i) {
                    z2 = true;
                }
                if (z2 || mVar.j) {
                    mVar.j = z2;
                    if (Build.VERSION.SDK_INT >= 30) {
                        WindowInsetsController windowInsetsController = viewGroup.getWindowInsetsController();
                        if (windowInsetsController == null) {
                            return;
                        }
                        if (z2) {
                            windowInsetsController.setSystemBarsBehavior(2);
                            windowInsetsController.hide(WindowInsets.Type.systemBars());
                            return;
                        } else {
                            windowInsetsController.show(WindowInsets.Type.systemBars());
                            return;
                        }
                    }
                    int systemUiVisibility = viewGroup.getSystemUiVisibility();
                    viewGroup.setSystemUiVisibility(z2 ? systemUiVisibility | 4102 : systemUiVisibility & (-4103));
                }
            }
        }
    }

    public static void a(m mVar, boolean z) {
        a(mVar);
        ArrayList arrayList = mVar.b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            View view = (View) ((WeakReference) obj).get();
            if (view != null) {
                a(view, mVar, z);
            }
        }
    }

    public static void a(View view, m mVar, boolean z) {
        float fFloatValue;
        if (ac.a() != null && ac.e().f) {
            if (mVar.e) {
                fFloatValue = 1.0f;
            } else {
                int i2 = ac.e().s;
                if (i2 >= 100) {
                    fFloatValue = 0.0f;
                } else if (i2 <= 0) {
                    fFloatValue = 1.0f;
                } else {
                    fFloatValue = (100 - i2) / 100.0f;
                }
            }
        } else {
            Float f2 = (Float) mVar.c.get(view);
            if (f2 == null) {
                fFloatValue = 1.0f;
            } else {
                fFloatValue = f2.floatValue();
            }
        }
        if (Math.abs(view.getAlpha() - fFloatValue) < 0.01f) {
            return;
        }
        view.animate().cancel();
        if (z) {
            view.animate().alpha(fFloatValue).setDuration(fFloatValue > view.getAlpha() ? 120L : 220L).start();
        } else {
            view.setAlpha(fFloatValue);
        }
    }

    public static void a(View view) {
        ObjectAnimator objectAnimator = (ObjectAnimator) d.remove(view);
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public static void a(m mVar) {
        Iterator it = mVar.b.iterator();
        while (it.hasNext()) {
            View view = (View) ((WeakReference) it.next()).get();
            if (view == null || (view.getParent() == null && !view.isAttachedToWindow())) {
                it.remove();
                if (view != null) {
                    mVar.c.remove(view);
                }
            }
        }
    }

    public static void b(View view, m mVar) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        int i2 = j;
        if (i2 != -1 && id == i2) {
            b(view);
            return;
        }
        if (!c(view)) {
            a(view, mVar);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                b(viewGroup.getChildAt(i3), mVar);
            }
        }
    }

    public static boolean b() {
        return ac.a() != null && ac.e().f;
    }

    public static void b(m mVar) {
        a(mVar);
        ArrayList arrayList = mVar.b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            View view = (View) ((WeakReference) obj).get();
            if (view != null) {
                WeakHashMap weakHashMap = mVar.c;
                float alpha = view.getAlpha();
                if (alpha < 0.01f || alpha > 1.0f) {
                    alpha = 1.0f;
                }
                weakHashMap.put(view, Float.valueOf(alpha));
            }
        }
    }
}
