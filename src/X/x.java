package X;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.ss.android.ugc.aweme.feed.ui.FeedFragment;
import com.windukk.hook.HookBridge;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public abstract class x {
    public static final String[] a = {"widget_container", "xyh", "nvk", "gradual_bottom", "title_shadow", "video_sticker_container_area", "video_seek_bar", "cey"};
    public static final WeakHashMap b = new WeakHashMap();
    public static final WeakHashMap c = new WeakHashMap();
    public static final WeakHashMap d = new WeakHashMap();
    public static boolean e = false;
    public static int[] f = new int[16];
    public static int g = 0;
    public static int h = -1;
    public static int i = -1;
    public static int j = -1;
    public static Bitmap k;
    public static Bitmap l;

    public static void a() {
        try {
            l8 l8VarA = l8.a();
            if (l8VarA != null && l8VarA.f && l8VarA.g) {
                l8VarA.c(true);
            }
            HookBridge.hookMethod(View.class.getDeclaredMethod("onAttachedToWindow", null), new p());
            HookBridge.hookMethod(FeedFragment.class.getMethod("onViewCreated", View.class, Bundle.class), new o());
            HookBridge.hookMethod(View.class.getDeclaredMethod("setVisibility", Integer.TYPE), new n());
        } catch (Throwable th) {
            int i2 = g5.a;
        }
    }

    public static void b(View view) {
        if (j == -1 || view == null) {
            return;
        }
        l8 l8VarA = l8.a();
        if (l8VarA == null || l8VarA.f) {
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
            view.addOnAttachStateChangeListener(new t());
            view.setOnClickListener(new u());
            view.setOnLongClickListener(new v());
            g(view);
            f(view);
        }
    }

    public static void c(w wVar, View view) {
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
                        a(wVar, view);
                        return;
                    } else {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            while (i3 < viewGroup.getChildCount()) {
                                b(wVar, viewGroup.getChildAt(i3));
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
                c(wVar, viewGroup2.getChildAt(i3));
                i3++;
            }
        }
    }

    public static w d(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        if ((rootView instanceof ViewGroup) || !(view instanceof ViewGroup)) {
            view = rootView;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        WeakHashMap weakHashMap = b;
        w wVar = (w) weakHashMap.get(viewGroup);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(viewGroup);
        weakHashMap.put(viewGroup, wVar2);
        viewGroup.addOnLayoutChangeListener(new q(wVar2));
        wVar2.d = new r(wVar2);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(wVar2.d);
        viewGroup.addOnAttachStateChangeListener(new s(viewGroup, wVar2));
        return wVar2;
    }

    public static void e(View view) {
        ArrayList arrayList = new ArrayList(b.values());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            w wVar = (w) obj;
            Iterator it = wVar.b.iterator();
            boolean z = false;
            while (it.hasNext()) {
                View view2 = (View) ((WeakReference) it.next()).get();
                if (view2 != null && view2 != view) {
                    for (Object parent = view.getParent(); parent instanceof View; parent = ((View) parent).getParent()) {
                        if (parent == view2) {
                            Float f2 = (Float) wVar.c.get(view2);
                            view2.animate().cancel();
                            view2.setAlpha(f2 != null ? f2.floatValue() : 1.0f);
                            wVar.c.remove(view2);
                            it.remove();
                            z = true;
                            break;
                        }
                    }
                }
            }
            if (z) {
                wVar.g = true;
                Object parent2 = view.getParent();
                if (parent2 instanceof View) {
                    b(wVar, (View) parent2);
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
                    k = vb.a(context, "ic_settings_burn-in-on");
                }
                bitmap = k;
            } else {
                if (l == null) {
                    l = vb.a(context, "ic_settings_burn-in-off");
                }
                bitmap = l;
            }
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                int iA = g5.a(14.0f);
                imageView.setPadding(iA, iA, iA, iA);
            }
        }
        float fMax = 1.0f;
        if (zB) {
            l8 l8VarA = l8.a();
            if (l8VarA == null || (i2 = l8VarA.m) >= 100) {
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
                    float fA = g5.a(5.0f);
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
        String[] strArr = a;
        for (int i2 = 0; i2 < 8; i2++) {
            int identifier = context.getResources().getIdentifier(strArr[i2], "id", context.getPackageName());
            if (identifier != -1 && identifier != 0) {
                int i3 = 0;
                while (true) {
                    int i4 = g;
                    if (i3 < i4) {
                        if (f[i3] == identifier) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        int[] iArr = f;
                        if (i4 == iArr.length) {
                            int[] iArr2 = new int[iArr.length * 2];
                            System.arraycopy(iArr, 0, iArr2, 0, i4);
                            f = iArr2;
                        }
                        int[] iArr3 = f;
                        int i5 = g;
                        iArr3[i5] = identifier;
                        g = i5 + 1;
                        break;
                    }
                }
            }
        }
        h = context.getResources().getIdentifier("widget_container", "id", context.getPackageName());
        i = context.getResources().getIdentifier("xyh", "id", context.getPackageName());
        j = context.getResources().getIdentifier("jph", "id", context.getPackageName());
        e = true;
        int i6 = g5.a;
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

    public static void a(w wVar, long j2, boolean z) {
        ViewGroup viewGroup = (ViewGroup) wVar.a.get();
        if (viewGroup == null) {
            return;
        }
        if (z && wVar.f) {
            return;
        }
        if (z) {
            wVar.f = true;
        }
        viewGroup.postDelayed(new m(wVar), j2);
    }

    public static void a(w wVar, View view) {
        if (view != null) {
            int id = view.getId();
            int i2 = j;
            if (i2 == -1 || id != i2) {
                if (c(view)) {
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                            b(wVar, viewGroup.getChildAt(i3));
                        }
                        return;
                    }
                    return;
                }
                ArrayList arrayList = wVar.b;
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    if (((WeakReference) obj).get() == view) {
                        return;
                    }
                }
                wVar.b.add(new WeakReference(view));
                WeakHashMap weakHashMap = wVar.c;
                float alpha = view.getAlpha();
                if (alpha < 0.01f || alpha > 1.0f) {
                    alpha = 1.0f;
                }
                weakHashMap.put(view, Float.valueOf(alpha));
                if (b()) {
                    a(view, wVar, false);
                }
            }
        }
    }

    public static void b(w wVar, boolean z) {
        ViewGroup viewGroup = (ViewGroup) wVar.a.get();
        if (viewGroup == null || g == 0) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (z || jUptimeMillis - wVar.j >= 60) {
            wVar.j = jUptimeMillis;
            a(wVar);
            c(wVar, viewGroup);
            if (wVar.h) {
                a(wVar, false);
            }
        }
    }

    public static void a(w wVar, boolean z) {
        a(wVar);
        ArrayList arrayList = wVar.b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            View view = (View) ((WeakReference) obj).get();
            if (view != null) {
                a(view, wVar, z);
            }
        }
    }

    public static void b(w wVar, View view) {
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
            a(wVar, view);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                b(wVar, viewGroup.getChildAt(i3));
            }
        }
    }

    public static void a(View view, w wVar, boolean z) {
        float fFloatValue;
        l8 l8VarA = l8.a();
        if (l8VarA != null && l8VarA.e) {
            if (wVar.e) {
                fFloatValue = 1.0f;
            } else {
                int i2 = l8VarA.m;
                if (i2 >= 100) {
                    fFloatValue = 0.0f;
                } else if (i2 <= 0) {
                    fFloatValue = 1.0f;
                } else {
                    fFloatValue = (100 - i2) / 100.0f;
                }
            }
        } else {
            Float f2 = (Float) wVar.c.get(view);
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

    public static boolean b() {
        l8 l8VarA = l8.a();
        return l8VarA != null && l8VarA.e;
    }

    public static void b(w wVar) {
        a(wVar);
        ArrayList arrayList = wVar.b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            View view = (View) ((WeakReference) obj).get();
            if (view != null) {
                WeakHashMap weakHashMap = wVar.c;
                float alpha = view.getAlpha();
                if (alpha < 0.01f || alpha > 1.0f) {
                    alpha = 1.0f;
                }
                weakHashMap.put(view, Float.valueOf(alpha));
            }
        }
    }

    public static void a(View view) {
        ObjectAnimator objectAnimator = (ObjectAnimator) d.remove(view);
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public static void a(w wVar) {
        Iterator it = wVar.b.iterator();
        while (it.hasNext()) {
            View view = (View) ((WeakReference) it.next()).get();
            if (view == null || (view.getParent() == null && !view.isAttachedToWindow())) {
                it.remove();
                if (view != null) {
                    wVar.c.remove(view);
                }
            }
        }
    }
}
