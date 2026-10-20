package Z;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.Supplier;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.Json;

public final class pj {
    public static volatile boolean f;
    public static volatile boolean g;
    public static int m;
    public static WeakReference n;
    public static int o;
    public static ValueAnimator p;
    public static WeakReference q;
    public static ViewTreeObserver.OnPreDrawListener r;
    public static Rect s;
    public static boolean u;
    public static boolean v;
    public static WeakReference w;
    public static final pj a = new pj();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return pj.c();
        }
    });
    public static final WeakHashMap c = new WeakHashMap();
    public static final Handler d = new Handler(Looper.getMainLooper());
    public static final Rect e = new Rect();
    public static final ArrayList h = new ArrayList();
    public static volatile Map i = MapsKt.emptyMap();
    public static final List j = CollectionsKt.listOf(new String[]{"uwq|0:06zx/0:05Rs/0:e|gone", "ljn|0:061b:exj|gone", "onp|2:066l:ond|gone", "onp|1:066l:ong|gone"});
    public static final Lazy k = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return pj.m();
        }
    });
    public static List l = CollectionsKt.emptyList();
    public static final int[] t = new int[2];
    public static long x = -1;
    public static long y = -1;
    public static int z = -1;
    public static final Set A = SetsKt.setOf(new String[]{"content", "action_bar_root", "statusBarBackground", "navigationBarBackground", "navigationBarBackgroundView", "player_view", "view_rootview", "video_visible_area_container", "viewpager"});

    public static final void a(pj pjVar, ViewGroup viewGroup, MotionEvent motionEvent, HookMethod.HookMethodParam hookMethodParam) {
        Activity activityA;
        boolean zContains;
        boolean z2;
        boolean zContains2;
        boolean z3;
        boolean zContains3;
        pjVar.getClass();
        if (viewGroup.findViewWithTag("UiHideSheet") != null) {
            return;
        }
        Context context = viewGroup.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activityA = a();
                break;
            } else {
                if (context instanceof Activity) {
                    activityA = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activityA == null || StringsKt.startsWith$default(activityA.getClass().getName(), "com.windukk.mod", false, 2, (Object) null)) {
            return;
        }
        if (motionEvent.getActionMasked() == 0) {
            u = false;
            v = false;
            w = null;
            WeakReference weakReference = wi.b;
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            View viewFindViewWithTag = viewGroup.findViewWithTag("UiHideFloatingButton");
            if (viewFindViewWithTag != null && viewFindViewWithTag.isShown()) {
                Rect rect = wi.f;
                viewFindViewWithTag.getGlobalVisibleRect(rect);
                zContains = rect.contains((int) rawX, (int) rawY);
            } else {
                zContains = false;
            }
            if (zContains) {
                z2 = true;
            } else {
                float[] fArr = si.b;
                float rawX2 = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                View viewFindViewWithTag2 = viewGroup.findViewWithTag("UiHideDepthControl");
                if (viewFindViewWithTag2 == null || !viewFindViewWithTag2.isShown()) {
                    zContains2 = false;
                } else {
                    Rect rect2 = si.e;
                    viewFindViewWithTag2.getGlobalVisibleRect(rect2);
                    zContains2 = rect2.contains((int) rawX2, (int) rawY2);
                }
                if (zContains2) {
                    z3 = true;
                } else {
                    View viewFindViewWithTag3 = viewGroup.findViewWithTag("UiHideDepthHide");
                    if (viewFindViewWithTag3 == null || !viewFindViewWithTag3.isShown()) {
                        zContains3 = false;
                    } else {
                        Rect rect3 = si.e;
                        viewFindViewWithTag3.getGlobalVisibleRect(rect3);
                        zContains3 = rect3.contains((int) rawX2, (int) rawY2);
                    }
                    if (zContains3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            u = z2;
        }
        if (u) {
            return;
        }
        hookMethodParam.setResult(Boolean.TRUE);
        switch (motionEvent.getActionMasked()) {
            case 0:
                a(viewGroup, motionEvent.getRawX(), motionEvent.getRawY(), false);
                break;
            case 1:
            case 3:
                u = false;
                v = false;
                w = null;
                break;
            case 2:
                a(viewGroup, motionEvent.getRawX(), motionEvent.getRawY(), true);
                break;
        }
    }

    public static final wj b(pj pjVar, View view) {
        wj wjVar;
        pjVar.getClass();
        WeakHashMap weakHashMap = c;
        synchronized (weakHashMap) {
            zi ziVar = (zi) weakHashMap.get(view);
            wjVar = ziVar != null ? ziVar.a : null;
        }
        return wjVar != null ? wjVar : d(view);
    }

    public static final Boolean c() {
        return Boolean.FALSE;
    }

    public static boolean d() {
        cj cjVar = (cj) CollectionsKt.getOrNull(l, m);
        return (cjVar != null ? (View) cjVar.a.get() : null) != null;
    }

    public static Rect e() {
        GradientDrawable gradientDrawable;
        WeakReference weakReference;
        ViewGroup viewGroup;
        cj cjVar = (cj) CollectionsKt.getOrNull(l, m);
        if (cjVar == null || (gradientDrawable = cjVar.d) == null) {
            return null;
        }
        WeakReference weakReference2 = q;
        if ((weakReference2 != null ? (ViewGroup) weakReference2.get() : null) != null && !gradientDrawable.getBounds().isEmpty()) {
            return new Rect(gradientDrawable.getBounds());
        }
        View view = (View) cjVar.a.get();
        if (view == null || (weakReference = n) == null || (viewGroup = (ViewGroup) weakReference.get()) == null) {
            return null;
        }
        return a(viewGroup, view);
    }

    public static final void g() {
        Object obj;
        pj pjVar = a;
        try {
            Result.Companion companion = Result.Companion;
            h();
            pjVar.f();
            wi.e();
            ac.a().getClass();
            if (ac.e().m) {
                b(true);
            }
            obj = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("UI hide initialization error", new Object[0]), th2);
        }
    }

    public static void h() {
        int identifier;
        Context contextA = Main.getApplicationContext();
        String strB = xj.b();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (y5.a().k) {
            CollectionsKt.addAll(arrayList, (List) k.getValue());
        }
        if (y5.a().l) {
            for (Object obj : xj.a()) {
                wj wjVar = (wj) obj;
                if (wjVar.f && Intrinsics.areEqual(wjVar.d, strB)) {
                    arrayList.add(obj);
                }
            }
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            wj wjVar2 = (wj) obj2;
            if (wjVar2.e.length() != 0 && (identifier = contextA.getResources().getIdentifier(wjVar2.a, "id", contextA.getPackageName())) != 0) {
                Integer numValueOf = Integer.valueOf(identifier);
                Object arrayList2 = map.get(numValueOf);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(numValueOf, arrayList2);
                }
                ((List) arrayList2).add(wjVar2);
            }
        }
        i = map;
    }

    public static final void i() {
        List<Map.Entry> list;
        h();
        WeakHashMap weakHashMap = c;
        synchronized (weakHashMap) {
            list = CollectionsKt.toList(weakHashMap.entrySet());
        }
        for (Map.Entry entry : list) {
            View view = (View) entry.getKey();
            zi ziVar = (zi) entry.getValue();
            wj wjVarD = d(view);
            if (wjVarD == null) {
                c(view);
            } else if (!Intrinsics.areEqual(wjVarD, ziVar.a)) {
                a(wjVarD, view);
            }
        }
        b();
    }

    public static final Unit j() {
        a(m + 1);
        return Unit.INSTANCE;
    }

    public static final Unit k() {
        a(m - 1);
        return Unit.INSTANCE;
    }

    public static final Unit l() {
        ImageView imageView;
        WeakReference weakReference = wi.b;
        if (weakReference != null && (imageView = (ImageView) weakReference.get()) != null) {
            Context context = imageView.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                wi.a(activity);
            }
        }
        return Unit.INSTANCE;
    }

    public static final List m() {
        List list = j;
        Json json = xj.a;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            wj wjVarA = xj.a((String) it.next());
            if (wjVarA != null) {
                arrayList.add(wjVarA);
            }
        }
        return arrayList;
    }

    public static void o() {
        Object obj;
        g = false;
        ArrayList arrayList = h;
        synchronized (arrayList) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                HookMethod.Unhook unhook = (HookMethod.Unhook) obj2;
                try {
                    Result.Companion companion = Result.Companion;
                    unhook.unhook();
                    obj = ResultCompat.constructor(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = ResultCompat.constructor(ResultKt.createFailure(th));
                }
                Throwable th2 = ResultCompat.exceptionOrNull(obj);
                if (th2 != null) {
                    g7.a(6, g7.a("Failed to unhook UI hide touch", new Object[0]), th2);
                }
            }
            h.clear();
            Unit unit = Unit.INSTANCE;
        }
        a(false);
        u = false;
        v = false;
        w = null;
    }

    public final void f() throws NoSuchMethodException {
        HookBridge.hookMethod(View.class.getDeclaredMethod("onAttachedToWindow", null), new pj$after$1());
        Class cls = Integer.TYPE;
        HookBridge.hookMethod(View.class.getDeclaredMethod("setVisibility", cls), new pj$before$1());
        HookBridge.hookMethod(View.class.getDeclaredMethod("setAlpha", Float.TYPE), new pj$before$2());
        try {
            Result.Companion companion = Result.Companion;
            ResultCompat.constructor(HookBridge.hookMethod(View.class.getDeclaredMethod("setFlags", cls, cls), new pj$before$3(this)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            ResultCompat.constructor(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.Companion;
            ResultCompat.constructor(HookBridge.hookMethod(View.class.getDeclaredMethod("setTransitionVisibility", Integer.TYPE), new pj$before$4(this)));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            ResultCompat.constructor(ResultKt.createFailure(th2));
        }
    }

    public static void c(View view) {
        zi ziVar;
        WeakHashMap weakHashMap = c;
        synchronized (weakHashMap) {
            ziVar = (zi) weakHashMap.remove(view);
        }
        if (ziVar == null) {
            return;
        }
        ThreadLocal threadLocal = b;
        threadLocal.set(Boolean.TRUE);
        try {
            view.setVisibility(ziVar.b);
            view.setAlpha(ziVar.c);
            threadLocal.set(Boolean.FALSE);
        } catch (Throwable th) {
            try {
                g7.a(6, g7.a("UI hide restore failed", new Object[0]), th);
            } finally {
                b.set(Boolean.FALSE);
            }
        }
    }

    public static wj d(View view) {
        int iIndexOfChild;
        Object next;
        Map map = i;
        if (map.isEmpty()) {
            return null;
        }
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        ArrayList arrayList = new ArrayList(4);
        View view3 = view2;
        View view4 = view;
        View view5 = view3;
        while (view5 != null) {
            ViewGroup viewGroup = view5 instanceof ViewGroup ? (ViewGroup) view5 : null;
            if (viewGroup == null || (iIndexOfChild = viewGroup.indexOfChild(view4)) < 0) {
                break;
            }
            arrayList.add(0, b(iIndexOfChild, view4));
            ViewGroup viewGroup2 = (ViewGroup) view5;
            int id = viewGroup2.getId();
            if (id != -1 && id != 0) {
                String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                List list = (List) map.get(Integer.valueOf(id));
                if (list != null) {
                    Iterator it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(((wj) next).e, strJoinToString$default));
                    wj wjVar = (wj) next;
                    if (wjVar != null) {
                        return wjVar;
                    }
                }
            }
            Object parent2 = viewGroup2.getParent();
            View view6 = parent2 instanceof View ? (View) parent2 : null;
            view4 = view5;
            view5 = view6;
        }
        return null;
    }

    public static void e(View view) {
        wj wjVarD = d(view);
        if (wjVarD != null) {
            a(wjVarD, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                e(viewGroup.getChildAt(i2));
            }
        }
    }

    public static final void b(boolean z2) {
        if (z2) {
            f = true;
            ac.a().getClass();
            ac.e().n(true);
            Activity activityA = a();
            if (activityA != null) {
                wi.f(activityA);
                return;
            }
            return;
        }
        f = false;
        ac.a().getClass();
        ac.e().n(false);
        o();
        wi.d();
    }

    public static String b(int i2, View view) {
        String simpleName = view.getClass().getSimpleName();
        String strA = a(view.getId(), view);
        return (strA != null ? new StringBuilder().append(i2).append(":").append(simpleName).append(":").append(strA) : new StringBuilder().append(i2).append(":").append(simpleName)).toString();
    }

    public static boolean b(View view) {
        View rootView;
        if (view.getId() == 16908290 || view == (rootView = view.getRootView())) {
            return true;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (view2 != null && layoutParams != null) {
                width = layoutParams.width;
                if (width <= 0) {
                    width = width == -1 ? view2.getWidth() : 0;
                }
                int i2 = layoutParams.height;
                if (i2 > 0) {
                    height = i2;
                } else {
                    height = i2 == -1 ? view2.getHeight() : 0;
                }
            }
        }
        int width2 = rootView != null ? rootView.getWidth() : 0;
        int height2 = rootView != null ? rootView.getHeight() : 0;
        return width > 0 && height > 0 && width2 > 0 && height2 > 0 && (((long) width) * ((long) height)) * 2 >= ((long) width2) * ((long) height2);
    }

    public static final void f(View view) {
        List<wj> list;
        List listEmptyList;
        aj ajVar;
        int i2;
        int id = view.getId();
        if (id == -1 || id == 0 || (list = (List) i.get(Integer.valueOf(id))) == null) {
            return;
        }
        for (wj wjVar : list) {
            if (wjVar.e.length() != 0) {
                String str = wjVar.e;
                View view2 = null;
                if (str.length() != 0) {
                    if (str.length() == 0) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        try {
                            List<String> listSplit$default = StringsKt.split$default(str, new char[]{'/'}, false, 0, 6, (Object) null);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                            for (String str2 : listSplit$default) {
                                int iIndexOf$default = StringsKt.indexOf$default(str2, ':', 0, false, 6, (Object) null);
                                if (iIndexOf$default < 0) {
                                    ajVar = new aj(Integer.parseInt(str2), null, null);
                                } else {
                                    String strSubstring = str2.substring(iIndexOf$default + 1);
                                    int iIndexOf$default2 = StringsKt.indexOf$default(strSubstring, ':', 0, false, 6, (Object) null);
                                    if (iIndexOf$default2 < 0) {
                                        int i3 = Integer.parseInt(str2.substring(0, iIndexOf$default));
                                        if (strSubstring.length() == 0) {
                                            strSubstring = null;
                                        }
                                        ajVar = new aj(i3, strSubstring, null);
                                    } else {
                                        int i4 = Integer.parseInt(str2.substring(0, iIndexOf$default));
                                        String strSubstring2 = strSubstring.substring(0, iIndexOf$default2);
                                        if (strSubstring2.length() == 0) {
                                            strSubstring2 = null;
                                        }
                                        String strSubstring3 = strSubstring.substring(iIndexOf$default2 + 1);
                                        if (strSubstring3.length() == 0) {
                                            strSubstring3 = null;
                                        }
                                        ajVar = new aj(i4, strSubstring2, strSubstring3);
                                    }
                                }
                                arrayList.add(ajVar);
                            }
                            listEmptyList = arrayList;
                        } catch (Throwable th) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                    }
                    if (!listEmptyList.isEmpty()) {
                        Iterator it = listEmptyList.iterator();
                        View childAt = view;
                        while (true) {
                            if (it.hasNext()) {
                                aj ajVar2 = (aj) it.next();
                                ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
                                if (viewGroup == null || (i2 = ajVar2.a) < 0 || i2 >= viewGroup.getChildCount() || (childAt = viewGroup.getChildAt(ajVar2.a)) == null || ((ajVar2.b != null && !Intrinsics.areEqual(childAt.getClass().getSimpleName(), ajVar2.b)) || (ajVar2.c != null && !Intrinsics.areEqual(a(childAt.getId(), childAt), ajVar2.c)))) {
                                    break;
                                }
                            } else {
                                view2 = childAt;
                                break;
                            }
                        }
                    }
                }
                if (view2 != null) {
                    a(wjVar, view2);
                }
            }
        }
    }

    public static final boolean a(pj pjVar, MotionEvent motionEvent) {
        pjVar.getClass();
        if (motionEvent.getDownTime() == x && motionEvent.getEventTime() == y && motionEvent.getActionMasked() == z) {
            return false;
        }
        x = motionEvent.getDownTime();
        y = motionEvent.getEventTime();
        z = motionEvent.getActionMasked();
        return true;
    }

    public static void b() {
        Object obj;
        View viewPeekDecorView;
        Window window;
        View decorView;
        Object obj2;
        HashSet hashSet = new HashSet();
        WeakHashMap weakHashMap = c;
        synchronized (weakHashMap) {
            Iterator it = weakHashMap.keySet().iterator();
            while (true) {
                Object obj3 = null;
                if (!it.hasNext()) {
                    break;
                }
                View view = (View) it.next();
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = ResultCompat.constructor(view.getRootView());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = ResultCompat.constructor(ResultKt.createFailure(th));
                }
                if (!ResultCompat.isFailure(obj2)) {
                    obj3 = obj2;
                }
                View view2 = (View) obj3;
                if (view2 != null) {
                    hashSet.add(view2);
                }
            }
        }
        Activity activityA = a();
        if (activityA != null && (window = activityA.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            hashSet.add(decorView);
        }
        try {
            Result.Companion companion3 = Result.Companion;
            obj = ResultCompat.constructor(f3.a());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th2));
        }
        List list = (List) (ResultCompat.isFailure(obj) ? null : obj);
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Window window2 = ((Activity) it2.next()).getWindow();
                if (window2 != null && (viewPeekDecorView = window2.peekDecorView()) != null) {
                    hashSet.add(viewPeekDecorView);
                }
            }
        }
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            e((View) it3.next());
        }
    }

    public static void a(boolean z2) {
        ImageView imageView;
        cj cjVar = (cj) CollectionsKt.getOrNull(l, m);
        if (cjVar != null) {
            a(cjVar);
        }
        ValueAnimator valueAnimator = p;
        p = null;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        l = CollectionsKt.emptyList();
        m = 0;
        n = null;
        if (!z2) {
            s = null;
            si.a();
        }
        WeakReference weakReference = wi.b;
        if (weakReference == null || (imageView = (ImageView) weakReference.get()) == null) {
            return;
        }
        Runnable runnable = wi.k;
        imageView.removeCallbacks(runnable);
        imageView.post(runnable);
    }

    public static void a(int i2) {
        ViewGroup viewGroup;
        ImageView imageView;
        if (i2 < 0 || i2 >= l.size()) {
            return;
        }
        Rect rectE = s;
        if (rectE == null) {
            rectE = e();
        }
        s = null;
        cj cjVar = (cj) CollectionsKt.getOrNull(l, m);
        if (cjVar != null) {
            a(cjVar);
        }
        m = i2;
        cj cjVar2 = (cj) l.get(i2);
        View view = (View) cjVar2.a.get();
        if (view == null) {
            a(false);
            return;
        }
        a(view, cjVar2, rectE);
        WeakReference weakReference = wi.b;
        if (weakReference != null && (imageView = (ImageView) weakReference.get()) != null) {
            Runnable runnable = wi.k;
            imageView.removeCallbacks(runnable);
            imageView.post(runnable);
        }
        view.performHapticFeedback(4);
        WeakReference weakReference2 = n;
        if (weakReference2 == null || (viewGroup = (ViewGroup) weakReference2.get()) == null) {
            return;
        }
        float[] fArr = si.b;
        si.a(viewGroup, view, i2 + 1, l.size(), new Function0() {
            public final Object invoke() {
                return pj.j();
            }
        }, new Function0() {
            public final Object invoke() {
                return pj.k();
            }
        }, new Function0() {
            public final Object invoke() {
                return pj.l();
            }
        });
    }

    public static void a(ViewGroup viewGroup, float f2, float f3, boolean z2) {
        bj bjVar;
        int iIndexOfChild;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int scaledTouchSlop = ViewConfiguration.get(viewGroup.getContext()).getScaledTouchSlop() * 3;
        a(viewGroup, (int) f2, (int) f3, scaledTouchSlop * scaledTouchSlop, arrayList, arrayList2);
        View viewA = a(arrayList);
        if (viewA == null) {
            viewA = a(arrayList2);
        }
        if (viewA == null) {
            return;
        }
        WeakReference weakReference = w;
        if ((weakReference != null ? (View) weakReference.get() : null) == viewA) {
            return;
        }
        w = new WeakReference(viewA);
        cj cjVar = (cj) CollectionsKt.firstOrNull(l);
        View view = cjVar != null ? (View) cjVar.a.get() : null;
        if (view == viewA) {
            return;
        }
        if (z2 && view != null) {
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if (parent == viewA) {
                    return;
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        View view2 = viewA;
        while (view2 != null && (view2.getParent() instanceof View) && !b(view2)) {
            if (!a(view2)) {
                ArrayList arrayList4 = new ArrayList(4);
                Object parent2 = view2.getParent();
                View view3 = parent2 instanceof View ? (View) parent2 : null;
                View view4 = view2;
                while (true) {
                    if (view3 != null) {
                        ViewGroup viewGroup2 = view3 instanceof ViewGroup ? (ViewGroup) view3 : null;
                        if (viewGroup2 != null && (iIndexOfChild = viewGroup2.indexOfChild(view4)) >= 0) {
                            arrayList4.add(0, b(iIndexOfChild, view4));
                            ViewGroup viewGroup3 = (ViewGroup) view3;
                            String strA = a(viewGroup3.getId(), view3);
                            if (strA != null && !arrayList4.isEmpty()) {
                                bjVar = new bj(strA, CollectionsKt.joinToString$default(arrayList4, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                                break;
                            }
                            Object parent3 = viewGroup3.getParent();
                            View view5 = parent3 instanceof View ? (View) parent3 : null;
                            view4 = view3;
                            view3 = view5;
                        }
                    }
                    bjVar = null;
                    break;
                }
                if (bjVar != null) {
                    arrayList3.add(new cj(new WeakReference(view2), bjVar.a, bjVar.b));
                }
            }
            Object parent4 = view2.getParent();
            view2 = parent4 instanceof View ? (View) parent4 : null;
        }
        if (arrayList3.isEmpty()) {
            if (v) {
                return;
            }
            v = true;
            a(k7.a("ui_hide_no_id"), viewA);
            return;
        }
        if (view == null || ((cj) CollectionsKt.first(arrayList3)).a.get() != view) {
            Rect rectE = e();
            a(true);
            s = rectE;
            l = arrayList3;
            n = new WeakReference(viewGroup);
            a(0);
        }
    }

    public static void a(View view, int i2, int i3, int i4, ArrayList arrayList, ArrayList arrayList2) {
        int i5;
        int i6;
        if (view.getVisibility() != 0 || !view.isShown() || Intrinsics.areEqual(view.getTag(), "UiHideSheet") || Intrinsics.areEqual(view.getTag(), "UiHideFloatingButton") || Intrinsics.areEqual(view.getTag(), "UiHideDepthHide") || Intrinsics.areEqual(view.getTag(), "UiHideDepthControl")) {
            return;
        }
        Rect rect = e;
        view.getGlobalVisibleRect(rect);
        if (!rect.isEmpty()) {
            if (rect.contains(i2, i3)) {
                arrayList.add(view);
            } else {
                int i7 = rect.left;
                if (i2 < i7) {
                    i5 = i7 - i2;
                } else {
                    int i8 = rect.right;
                    i5 = i2 > i8 ? i2 - i8 : 0;
                }
                int i9 = rect.top;
                if (i3 < i9) {
                    i6 = i9 - i3;
                } else {
                    int i10 = rect.bottom;
                    i6 = i3 > i10 ? i3 - i10 : 0;
                }
                if ((i6 * i6) + (i5 * i5) <= i4) {
                    arrayList2.add(view);
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                a(viewGroup.getChildAt(i11), i2, i3, i4, arrayList, arrayList2);
            }
        }
    }

    public static String a(int i2, View view) {
        try {
            String resourceName = view.getResources().getResourceName(i2);
            if (!StringsKt.startsWith$default(resourceName, "android:", false, 2, (Object) null) && !StringsKt.startsWith$default(resourceName, "androidx.", false, 2, (Object) null)) {
                String strSubstringAfter = StringsKt.substringAfter(resourceName, '/', "");
                if (strSubstringAfter.length() == 0 || A.contains(strSubstringAfter)) {
                    return null;
                }
                return strSubstringAfter;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean a(View view) {
        if (Intrinsics.areEqual(view.getTag(), "UiHideFloatingButton")) {
            return true;
        }
        int id = view.getId();
        if (id != -1 && id != 0) {
            try {
                return A.contains(StringsKt.substringAfter(view.getResources().getResourceName(id), '/', ""));
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static void a(View view, cj cjVar, final Rect rect) {
        Object obj;
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        final GradientDrawable gradientDrawable = new GradientDrawable();
        int i2 = o;
        int i3 = hi.d;
        gradientDrawable.setColor((i2 & 16777215) | 1291845632);
        gradientDrawable.setStroke(Main.dp(1.5f), (16777215 & o) | (-1291845632));
        gradientDrawable.setCornerRadius(Main.dp(6.0f));
        cjVar.d = gradientDrawable;
        WeakReference weakReference = n;
        final ViewGroup viewGroup = weakReference != null ? (ViewGroup) weakReference.get() : null;
        final Rect rectA = viewGroup != null ? a(viewGroup, view) : null;
        if (viewGroup != null && rectA != null) {
            try {
                Result.Companion companion = Result.Companion;
                viewGroup.getOverlay().add(gradientDrawable);
                obj = ResultCompat.constructor(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = ResultCompat.constructor(ResultKt.createFailure(th));
            }
            if (!ResultCompat.isFailure(obj)) {
                q = new WeakReference(viewGroup);
                final WeakReference weakReference2 = new WeakReference(view);
                ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public final boolean onPreDraw() {
                        return pj.a(weakReference2, viewGroup, gradientDrawable);
                    }
                };
                r = onPreDrawListener;
                viewGroup.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
                if (rect != null && !Intrinsics.areEqual(rect, rectA)) {
                    gradientDrawable.setBounds(rect);
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.setDuration(150L);
                    valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.6f));
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            pj.a(weakReference2, rectA, gradientDrawable, rect, viewGroup, valueAnimator);
                        }
                    });
                    valueAnimatorOfFloat.addListener(new ek(weakReference2, viewGroup, gradientDrawable));
                    p = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.start();
                    return;
                }
                gradientDrawable.setBounds(rectA);
                return;
            }
        }
        gradientDrawable.setBounds(0, 0, view.getWidth(), view.getHeight());
        try {
            Result.Companion companion3 = Result.Companion;
            view.getOverlay().add(gradientDrawable);
            ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            ResultCompat.constructor(ResultKt.createFailure(th2));
        }
    }

    public static final boolean a(WeakReference weakReference, ViewGroup viewGroup, GradientDrawable gradientDrawable) {
        View view;
        if (p != null || (view = (View) weakReference.get()) == null) {
            return true;
        }
        Rect rectA = view.isShown() ? a(viewGroup, view) : null;
        if (rectA == null) {
            rectA = new Rect();
        }
        if (Intrinsics.areEqual(gradientDrawable.getBounds(), rectA)) {
            return true;
        }
        gradientDrawable.setBounds(rectA);
        gradientDrawable.invalidateSelf();
        return true;
    }

    public static final void a(WeakReference weakReference, Rect rect, GradientDrawable gradientDrawable, Rect rect2, ViewGroup viewGroup, ValueAnimator valueAnimator) {
        Rect rectA;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = (View) weakReference.get();
        if (view != null && (rectA = a(viewGroup, view)) != null) {
            rect = rectA;
        }
        int i2 = rect2.left;
        int i3 = i2 + ((int) ((rect.left - i2) * fFloatValue));
        int i4 = rect2.top;
        int i5 = i4 + ((int) ((rect.top - i4) * fFloatValue));
        int i6 = rect2.right;
        int i7 = i6 + ((int) ((rect.right - i6) * fFloatValue));
        int i8 = rect2.bottom;
        gradientDrawable.setBounds(i3, i5, i7, i8 + ((int) ((rect.bottom - i8) * fFloatValue)));
        gradientDrawable.invalidateSelf();
    }

    public static void a(cj cjVar) {
        Object obj;
        ValueAnimator valueAnimator = p;
        p = null;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        GradientDrawable gradientDrawable = cjVar.d;
        WeakReference weakReference = q;
        ViewGroup viewGroup = weakReference != null ? (ViewGroup) weakReference.get() : null;
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = r;
        q = null;
        r = null;
        if (viewGroup != null) {
            if (onPreDrawListener != null) {
                viewGroup.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
            if (gradientDrawable != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    viewGroup.getOverlay().remove(gradientDrawable);
                    obj = ResultCompat.constructor(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = ResultCompat.constructor(ResultKt.createFailure(th));
                }
                ResultCompat.box(obj);
            }
        }
        View view = (View) cjVar.a.get();
        if (view != null && gradientDrawable != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                view.getOverlay().remove(gradientDrawable);
                ResultCompat.constructor(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                ResultCompat.constructor(ResultKt.createFailure(th2));
            }
        }
        cjVar.d = null;
    }

    public static Rect a(View view, View view2) {
        if (!view2.isAttachedToWindow()) {
            return null;
        }
        int[] iArr = t;
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        view2.getLocationInWindow(iArr);
        int i4 = iArr[0] - i2;
        int i5 = iArr[1] - i3;
        return new Rect(i4, i5, view2.getWidth() + i4, view2.getHeight() + i5);
    }

    public static void a(wj wjVar, View view) {
        zi ziVar;
        if (a(view)) {
            return;
        }
        ThreadLocal threadLocal = b;
        Object obj = threadLocal.get();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(obj, bool)) {
            return;
        }
        threadLocal.set(bool);
        try {
            WeakHashMap weakHashMap = c;
            synchronized (weakHashMap) {
                zi ziVar2 = (zi) weakHashMap.get(view);
                if (ziVar2 != null) {
                    ziVar = new zi(wjVar, ziVar2.b, ziVar2.c);
                } else {
                    ziVar = new zi(wjVar, view.getVisibility(), view.getAlpha());
                }
                weakHashMap.put(view, ziVar);
            }
            if (wjVar.a()) {
                view.setAlpha(ziVar.c);
                view.setVisibility(8);
            } else {
                view.setVisibility(ziVar.b);
                view.setAlpha(0.0f);
            }
            threadLocal.set(Boolean.FALSE);
        } catch (Throwable th) {
            b.set(Boolean.FALSE);
            throw th;
        }
    }

    public static void a(View view, Integer num, Float f2, int i2) {
        int iIntValue;
        float fFloatValue;
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            f2 = null;
        }
        WeakHashMap weakHashMap = c;
        synchronized (weakHashMap) {
            zi ziVar = (zi) weakHashMap.get(view);
            if (ziVar == null) {
                return;
            }
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = ziVar.b;
            }
            if (f2 != null) {
                fFloatValue = f2.floatValue();
            } else {
                fFloatValue = ziVar.c;
            }
            weakHashMap.put(view, new zi(ziVar.a, iIntValue, fFloatValue));
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void a(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static Activity a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = ResultCompat.constructor((Activity) f3.f.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        if (ResultCompat.isFailure(obj)) {
            obj = null;
        }
        return (Activity) obj;
    }

    public static void a(final String str, View view) {
        Context contextA;
        Context context = view.getContext();
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    contextA = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                contextA = a();
                break;
            }
        }
        if (contextA == null) {
            contextA = view.getContext();
        }
        final Context contextB = contextA;
        d.post(new Runnable() {
            @Override
            public final void run() {
                pj.a(contextB, str);
            }
        });
    }

    public static View a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            View view = (View) obj;
            if ((view.getParent() instanceof View) && !b(view) && !a(view)) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return (View) CollectionsKt.minWithOrThrow(arrayList2, new oj(new nj(new mj(new lj()))));
    }
}
