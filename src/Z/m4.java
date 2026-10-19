package Z;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.windukk.mod.Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.text.StringsKt;

public final class m4 {
    public static final m4 a = new m4();

    public static String a(o3 o3Var) {
        String strA;
        String str = o3Var.p;
        String upperCase = null;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null && (strA = a(str)) != null) {
                return strA;
            }
        }
        String str2 = o3Var.q;
        if (str2 != null) {
            if (StringsKt.isBlank(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                upperCase = str2.toUpperCase(Locale.US);
            }
        }
        return upperCase == null ? "" : upperCase;
    }

    public static String c(o3 o3Var) {
        if (o3Var.b()) {
            return k7.a("download_quality_audio_only", "Только звук");
        }
        int i = o3Var.l;
        return i > 0 ? i + "p" : k7.a("download_quality_unknown", "Неизвестно");
    }

    public final boolean b(final Activity activity, j4 j4Var, final p3 p3Var) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            i4 i4Var = j4Var instanceof i4 ? (i4) j4Var : null;
            List listEmptyList = i4Var != null ? i4Var.a : null;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final fc fcVarB = new fc(activity).b((CharSequence) k7.a("download_quality_title", "Качество загрузки"));
            jc jcVar = fcVarB.b;
            final LinearLayout linearLayoutA = fcVarB.a(4);
            fcVarB.a().addView(fcVarB.a(linearLayoutA, 0.58f));
            fcVarB.c(k7.a("download_quality_cancel", "Отмена"), new Runnable() {
                @Override
                public final void run() {
                    m4.a(fcVarB);
                }
            });
            List list = listEmptyList;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = a(list);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = CollectionsKt.firstOrNull(list);
            final Function0 function0 = new Function0() {
                public final Object invoke() {
                    return m4.a(linearLayoutA, objectRef, this, fcVarB, objectRef2, atomicBoolean, p3Var, activity);
                }
            };
            Function0 function1 = new Function0() {
                public final Object invoke() {
                    return m4.a(linearLayoutA, activity, this, fcVarB);
                }
            };
            if (j4Var instanceof h4) {
                function1.invoke();
            } else {
                if (!(j4Var instanceof i4)) {
                    throw new NoWhenBranchMatchedException();
                }
                function0.invoke();
            }
            fcVarB.x = new Runnable() {
                @Override
                public final void run() {
                    m4.a(atomicBoolean, p3Var);
                }
            };
            if (!fcVarB.g()) {
                throw new IllegalStateException("sheet not shown".toString());
            }
            if (j4Var instanceof h4) {
                a(activity, jcVar, atomicBoolean, ((h4) j4Var).a, new Function1() {
                    public final Object invoke(Object obj2) {
                        return m4.a(objectRef, this, objectRef2, function0, (List) obj2);
                    }
                }, new l4(atomicBoolean, fcVarB, p3Var));
            }
            obj = Result.constructor-impl(Boolean.TRUE);
            Throwable th = Result.exceptionOrNull-impl(obj);
            if (th != null) {
                g7.a(6, g7.a("Download quality bottom sheet unavailable", new Object[0]), th);
            }
            Boolean bool = Boolean.FALSE;
            if (Result.isFailure-impl(obj)) {
                obj = bool;
            }
            return ((Boolean) obj).booleanValue();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th2));
        }
    }

    public static final void a(Activity activity, j4 j4Var, p3 p3Var) {
        if (a.b(activity, j4Var, p3Var)) {
            return;
        }
        p3Var.a();
    }

    public static final void a(p3 p3Var, o3 o3Var) {
        p3Var.getClass();
        if (p3Var.a.compareAndSet(false, true)) {
            ThreadLocal threadLocal = v3.a;
            v3.a(p3Var.b, o3Var, (List) p3Var.c.invoke(), p3Var.d, p3Var.e);
        }
    }

    public static final void a(AtomicBoolean atomicBoolean, fc fcVar, final p3 p3Var) {
        if (atomicBoolean.compareAndSet(false, true)) {
            fcVar.c(new Runnable() {
                @Override
                public final void run() {
                    m4.a(p3Var);
                }
            });
        }
    }

    public static final void a(p3 p3Var) {
        p3Var.a();
    }

    public static final void a(AtomicBoolean atomicBoolean, fc fcVar, fc fcVar2, final p3 p3Var, final o3 o3Var) {
        if (atomicBoolean.compareAndSet(false, true)) {
            fcVar.c((Runnable) null);
            fcVar2.c(new Runnable() {
                @Override
                public final void run() {
                    m4.b(p3Var, o3Var);
                }
            });
        }
    }

    public static final Unit a(LinearLayout linearLayout, Ref.ObjectRef objectRef, final m4 m4Var, final fc fcVar, Ref.ObjectRef objectRef2, final AtomicBoolean atomicBoolean, final p3 p3Var, final Activity activity) {
        String strDecrypt;
        String str;
        String str2;
        LinearLayout linearLayoutA;
        linearLayout.removeAllViews();
        for (final e4 e4Var : (Iterable) objectRef.element) {
            final o3 o3Var = (o3) CollectionsKt.singleOrNull(e4Var.b);
            if (o3Var != null) {
                m4Var.getClass();
                linearLayoutA = a(fcVar, c(o3Var), a(o3Var), b(o3Var), false, Intrinsics.areEqual(o3Var, objectRef2.element), o3Var.b());
                fcVar.a(linearLayoutA, new Runnable() {
                    @Override
                    public final void run() {
                        m4.a(o3Var, atomicBoolean, fcVar, p3Var);
                    }
                });
            } else {
                String str3 = e4Var.a;
                List list = e4Var.b;
                m4Var.getClass();
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str4 = ((o3) it.next()).p;
                    if (str4 != null) {
                        arrayList.add(str4);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    arrayList2.add(a((String) obj));
                }
                String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.distinct(arrayList2), "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                int size2 = e4Var.b.size();
                boolean z = true;
                if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), "ru")) {
                    int i2 = size2 % 100;
                    int i3 = size2 % 10;
                    if (11 <= i2 && i2 < 15) {
                        strDecrypt = "download_quality_option_many";
                    } else if (i3 == 1) {
                        strDecrypt = "download_quality_option_one";
                    } else if (2 <= i3 && i3 < 5) {
                        strDecrypt = "download_quality_option_few";
                    } else {
                        strDecrypt = "download_quality_option_many";
                    }
                } else if (size2 == 1) {
                    strDecrypt = "download_quality_option_one";
                } else {
                    strDecrypt = "download_quality_option_many";
                }
                String strDecrypt2 = (size2 == 1 ? "%d вариант" : "%d вариантов");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str5 = String.format(Locale.getDefault(), k7.a(strDecrypt, strDecrypt2), Arrays.copyOf(new Object[]{Integer.valueOf(size2)}, 1));
                boolean zContains = CollectionsKt.contains(e4Var.b, objectRef2.element);
                List list2 = e4Var.b;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (!((o3) it2.next()).b()) {
                            z = false;
                            break;
                        }
                    }
                }
                LinearLayout linearLayoutA2 = a(fcVar, str3, strJoinToString$default, str5, true, zContains, z);
                fcVar.a(linearLayoutA2, new Runnable() {
                    @Override
                    public final void run() {
                        m4.a(e4Var, m4Var, activity, atomicBoolean, fcVar, p3Var);
                    }
                });
                linearLayoutA = linearLayoutA2;
            }
            linearLayout.addView(linearLayoutA);
        }
        return Unit.INSTANCE;
    }

    public static final void b(final o3 o3Var, AtomicBoolean atomicBoolean, fc fcVar, final p3 p3Var) {
        if (atomicBoolean.compareAndSet(false, true)) {
            fcVar.c(new Runnable() {
                @Override
                public final void run() {
                    m4.a(p3Var, o3Var);
                }
            });
        }
    }

    public static final void b(e4 e4Var, m4 m4Var, Activity activity, AtomicBoolean atomicBoolean, fc fcVar, p3 p3Var) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            final fc fcVarB = new fc(activity).b((CharSequence) k7.a("download_quality_variants_title", "Варианты загрузки"));
            fcVarB.u = 0.0f;
            LinearLayout linearLayoutA = fcVarB.a(4);
            for (final o3 o3Var : e4Var.b) {
                m4Var.getClass();
                LinearLayout linearLayoutA2 = a(fcVarB, c(o3Var), a(o3Var), b(o3Var), false, Intrinsics.areEqual(o3Var, CollectionsKt.firstOrNull(e4Var.b)), o3Var.b());
                final fc fcVar2 = fcVarB;
                final AtomicBoolean atomicBoolean2 = atomicBoolean;
                final fc fcVar3 = fcVar;
                final p3 p3Var2 = p3Var;
                fcVarB = fcVar2;
                fcVarB.a(linearLayoutA2, new Runnable() {
                    @Override
                    public final void run() {
                        m4.a(atomicBoolean2, fcVar2, fcVar3, p3Var2, o3Var);
                    }
                });
                linearLayoutA.addView(linearLayoutA2);
                atomicBoolean = atomicBoolean2;
                fcVar = fcVar3;
                p3Var = p3Var2;
            }
            final fc fcVar4 = fcVar;
            fcVarB.a().addView(fcVarB.a(linearLayoutA, 0.58f));
            fcVarB.c(k7.a("download_quality_cancel", "Отмена"), new Runnable() {
                @Override
                public final void run() {
                    m4.a(fcVarB, fcVar4);
                }
            });
            obj = Result.constructor-impl(Boolean.valueOf(fcVarB.g()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Download quality variants sheet unavailable", new Object[0]), th2);
        }
    }

    public static final void b(p3 p3Var, o3 o3Var) {
        p3Var.getClass();
        if (p3Var.a.compareAndSet(false, true)) {
            ThreadLocal threadLocal = v3.a;
            v3.a(p3Var.b, o3Var, (List) p3Var.c.invoke(), p3Var.d, p3Var.e);
        }
    }

    public static String b(o3 o3Var) {
        String strA;
        ArrayList arrayList = new ArrayList();
        long j = o3Var.g;
        if (j > 0) {
            arrayList.add(a(j));
        }
        int i = o3Var.h;
        if (i > 0) {
            if (i >= 1000000) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                strA = String.format(Locale.US, "%.1f Mbps", Arrays.copyOf(new Object[]{Float.valueOf(i / 1000000.0f)}, 1));
            } else {
                strA = d3.a("vvRK+ZOnGrQyu/zPydDGf/Ymo6ngorzLqTeQ5idsaTE=", "iXpTGYrkvfnJqPN4", "aes", new StringBuilder().append(Math.max(1, i / 1000)));
            }
            arrayList.add(strA);
        }
        if (o3Var.b()) {
            return CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return strJoinToString$default.length() == 0 ? v4.a(o3Var) : strJoinToString$default;
    }

    public static final void a(o3 o3Var, AtomicBoolean atomicBoolean, fc fcVar, p3 p3Var) {
        b(o3Var, atomicBoolean, fcVar, p3Var);
    }

    public static final void a(e4 e4Var, m4 m4Var, Activity activity, AtomicBoolean atomicBoolean, fc fcVar, p3 p3Var) {
        b(e4Var, m4Var, activity, atomicBoolean, fcVar, p3Var);
    }

    public static final Unit a(LinearLayout linearLayout, Activity activity, m4 m4Var, fc fcVar) {
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        m4Var.getClass();
        linearLayout2.setMinimumHeight(Main.dp(64.0f));
        ProgressBar progressBar = new ProgressBar(activity);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(fcVar.e));
        linearLayout2.addView(progressBar, new LinearLayout.LayoutParams(Main.dp(30.0f), Main.dp(30.0f)));
        String strA = k7.a("download_quality_loading", "Загрузка…");
        TextView textViewA = fcVar.a(14.0f, false, fcVar.i);
        textViewA.setLineSpacing(Main.dp(2.0f), 1.0f);
        textViewA.setText(strA);
        textViewA.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = Main.dp(8.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(textViewA, layoutParams);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        return unit;
    }

    public static final void a(AtomicBoolean atomicBoolean, p3 p3Var) {
        if (atomicBoolean.compareAndSet(false, true) && p3Var.a.compareAndSet(false, true)) {
            AtomicLong atomicLong = r4.a;
            r4.a(Long.valueOf(p3Var.b.a));
            r4.a(p3Var.b);
        }
    }

    public static final Unit a(Ref.ObjectRef objectRef, m4 m4Var, Ref.ObjectRef objectRef2, Function0 function0, List list) {
        m4Var.getClass();
        objectRef.element = a(list);
        objectRef2.element = CollectionsKt.firstOrNull(list);
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static void a(final Activity activity, final Dialog dialog, final AtomicBoolean atomicBoolean, g4 g4Var, final Function1 function1, l4 l4Var) {
        final l4 l4Var2;
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            l4Var2 = l4Var;
            try {
                g4Var.a(new f4() {
                    @Override
                    public final void a(List list) {
                        m4.a(activity, atomicBoolean, dialog, l4Var2, function1, list);
                    }
                });
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                th = th;
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
            l4Var2 = l4Var;
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            g7.a(6, g7.a("Download quality loading failed", new Object[0]), th3);
            l4Var2.invoke();
        }
    }

    public static final void a(Activity activity, final AtomicBoolean atomicBoolean, final Dialog dialog, final Function0 function0, final Function1 function1, final List list) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                m4.a(atomicBoolean, dialog, list, function0, function1);
            }
        });
    }

    public static final void a(AtomicBoolean atomicBoolean, Dialog dialog, List list, Function0 function0, Function1 function1) {
        if (atomicBoolean.get() || !dialog.isShowing()) {
            return;
        }
        if ((dialog instanceof jc) && ((jc) dialog).f) {
            return;
        }
        if (list.isEmpty()) {
            function0.invoke();
        } else {
            function1.invoke(list);
        }
    }

    public static ArrayList a(List list) {
        String strA;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!((o3) obj).b()) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList2.get(i);
            i++;
            o3 o3Var = (o3) obj2;
            Integer numValueOf = Integer.valueOf(o3Var.l);
            Object arrayList3 = linkedHashMap.get(numValueOf);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList3);
            }
            ((Collection) arrayList3).add(o3Var);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            List list2 = (List) entry.getValue();
            if (iIntValue > 0) {
                strA = iIntValue + "p";
            } else {
                strA = k7.a("download_quality_unknown", "Неизвестно");
            }
            arrayList.add(new e4(strA, list2));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            if (((o3) obj3).b()) {
                arrayList4.add(obj3);
            }
        }
        if (!arrayList4.isEmpty()) {
            arrayList.add(new e4(k7.a("download_quality_audio_only", "Только звук"), arrayList4));
        }
        return arrayList;
    }

    public static final void a(fc fcVar) {
        fcVar.c((Runnable) null);
    }

    public static final void a(fc fcVar, fc fcVar2) {
        fcVar.c((Runnable) null);
        fcVar2.c((Runnable) null);
    }

    public static LinearLayout a(fc fcVar, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        String str4;
        String str5;
        Activity activity = fcVar.a;
        LinearLayout linearLayoutE = fcVar.e();
        linearLayoutE.setPadding(Main.dp(16.0f), Main.dp(14.0f), Main.dp(16.0f), Main.dp(14.0f));
        linearLayoutE.addView(fcVar.a(z2 ? fcVar.e : fcVar.k, (z3 ? "ic_music" : "ic_play")));
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textViewA = fcVar.a(14.0f, true, fcVar.h);
        textViewA.setText(str);
        if (z2) {
            textViewA.setTextColor(fcVar.e);
        }
        textViewA.setMaxLines(1);
        linearLayout2.addView(textViewA);
        if (!StringsKt.isBlank(str2)) {
            TextView textViewA2 = fcVar.a(14.0f, false, fcVar.i);
            textViewA2.setText(str2);
            textViewA2.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart(Main.dp(8.0f));
            Unit unit = Unit.INSTANCE;
            linearLayout2.addView(textViewA2, layoutParams);
        }
        linearLayout.addView(linearLayout2);
        if (!StringsKt.isBlank(str3)) {
            TextView textViewA3 = fcVar.a(14.0f, false, fcVar.i);
            textViewA3.setText(str3);
            textViewA3.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = Main.dp(5.0f);
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(textViewA3, layoutParams2);
        }
        if (!StringsKt.isBlank("")) {
            TextView textViewA4 = fcVar.a(11.0f, false, fcVar.i);
            textViewA4.setText("");
            textViewA4.setMaxLines(1);
            textViewA4.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = Main.dp(3.0f);
            Unit unit3 = Unit.INSTANCE;
            linearLayout.addView(textViewA4, layoutParams3);
        }
        linearLayoutE.addView(linearLayout, fc.h());
        if (z2) {
            String strA = k7.a("download_quality_best", "Лучшее");
            TextView textViewA5 = fcVar.a(12.0f, false, -1);
            textViewA5.setText(strA);
            textViewA5.setGravity(17);
            textViewA5.setSingleLine(true);
            textViewA5.setPadding(Main.dp(12.0f), Main.dp(8.0f), Main.dp(12.0f), Main.dp(8.0f));
            int i = fcVar.e;
            float fA = Main.dp(60.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius(fA);
            textViewA5.setBackground(gradientDrawable);
            linearLayoutE.addView(textViewA5);
        }
        if (z) {
            View viewA = fcVar.a(fcVar.k, "ic_startup_chevron");
            viewA.setLayoutParams(new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
            linearLayoutE.addView(viewA);
        }
        return linearLayoutE;
    }

    public final k4 a(Context context, final j4 j4Var, final p3 p3Var) {
        final Activity activity;
        List list;
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                if (!(context instanceof Activity)) {
                    activity = (Activity) f3.f.get();
                    if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                        break;
                    }
                    activity = null;
                    break;
                }
                activity = (Activity) context;
                break;
            }
        }
        i4 i4Var = j4Var instanceof i4 ? (i4) j4Var : null;
        Integer numValueOf = (i4Var == null || (list = i4Var.a) == null) ? null : Integer.valueOf(list.size());
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && (numValueOf == null || numValueOf.intValue() != 0)) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                if (b(activity, j4Var, p3Var)) {
                    return k4.a;
                }
                p3Var.a();
                return k4.c;
            }
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    m4.a(activity, j4Var, p3Var);
                }
            });
            return k4.b;
        }
        g7.a(6, g7.a("Quality sheet unavailable: activity=%s choices=%d", new Object[]{activity != null ? activity.getClass().getName() : "null", Integer.valueOf(numValueOf != null ? numValueOf.intValue() : -1)}), (Throwable) null);
        p3Var.a();
        return k4.c;
    }

    public static String a(long j) {
        if (j >= 1048576) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(j / 1048576.0f)}, 1));
            return str;
        }
        if (j >= 1024) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(j / 1024.0f)}, 1));
            return str2;
        }
        return j + " B";
    }

    public static String a(String str) {
        switch (str.toLowerCase(Locale.US)) {
            case "bytevc1":
            case "hvc1":
            case "hevc":
            case "hev1":
            case "h265":
                return "HEVC";
            case "mp4a":
            case "aac":
                return "AAC";
            case "h264":
            case "avc1":
            case "avc":
                return "H264";
            default:
                return str.toUpperCase(Locale.US);
        }
    }
}
