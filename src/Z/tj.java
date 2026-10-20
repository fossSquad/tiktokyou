package Z;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.windukk.mod.Main;
import com.windukk.mod.hooks.PhotoHooks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public abstract class tj {
    public static final void a(wj wjVar, Function0 function0, View view) {
        xj.a(wjVar.a, wjVar.e, wjVar.d);
        pj.i();
        function0.invoke();
    }

    public static final void b(Activity activity) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        fc fcVar = new fc(activity);
        fcVar.c.setTag("UiHideSheet");
        fc fcVarA = fcVar.b((CharSequence) k7.a("ui_hide_section")).a((CharSequence) k7.a("ui_hide_quick_hint"));
        LinearLayout linearLayoutA = fcVarA.a(4);
        PhotoHooks ccVarA = fcVarA.a(linearLayoutA, 0.5f);
        fcVarA.a().addView(ccVarA);
        fcVarA.d(k7.a("ui_hide_close"), null);
        a(ccVarA, linearLayoutA, fcVarA, activity);
        fcVarA.g();
    }

    public static final void a(final ScrollView scrollView, final LinearLayout linearLayout, final fc fcVar, final Activity activity) {
        Collection collectionEmptyList;
        boolean z;
        View decorView;
        Object obj;
        final int scrollY = scrollView.getScrollY();
        linearLayout.removeAllViews();
        String strB = xj.b();
        List listA = xj.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listA) {
            if (Intrinsics.areEqual(((wj) obj2).d, strB)) {
                arrayList.add(obj2);
            }
        }
        float f = 8.0f;
        float f2 = 4.0f;
        boolean z2 = false;
        boolean z3 = false;
        if (arrayList.isEmpty()) {
            String strA = k7.a("ui_hide_empty");
            TextView textViewA = fcVar.a(13.0f, false, fcVar.i);
            textViewA.setText(strA);
            textViewA.setGravity(17);
            textViewA.setPadding(Main.dp(4.0f), Main.dp(8.0f), Main.dp(4.0f), Main.dp(8.0f));
            linearLayout.addView(textViewA);
        } else {
            pj pjVar = pj.a;
            Window window = activity.getWindow();
            if (window != null && (decorView = window.getDecorView()) != null) {
                WeakHashMap weakHashMap = pj.c;
                synchronized (weakHashMap) {
                    Set setEntrySet = weakHashMap.entrySet();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : setEntrySet) {
                        f = f;
                        View view = (View) ((Map.Entry) obj3).getKey();
                        try {
                            Result.Companion companion = Result.Companion;
                            obj = ResultCompat.constructor(Boolean.valueOf(view.getRootView() == decorView));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = ResultCompat.constructor(ResultKt.createFailure(th));
                        }
                        Boolean bool = Boolean.FALSE;
                        if (ResultCompat.isFailure(obj)) {
                            obj = bool;
                        }
                        if (((Boolean) obj).booleanValue()) {
                            arrayList2.add(obj3);
                        }
                    }
                    f = f;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    int size = arrayList2.size();
                    int i = 0;
                    while (i < size) {
                        Object obj4 = arrayList2.get(i);
                        i++;
                        arrayList3.add(((zi) ((Map.Entry) obj4).getValue()).a);
                        f2 = f2;
                    }
                    f2 = f2;
                    ArrayList arrayList4 = new ArrayList();
                    int size2 = arrayList3.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj5 = arrayList3.get(i2);
                        i2++;
                        wj wjVar = (wj) obj5;
                        List list = (List) pj.k.getValue();
                        boolean z4 = z2;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator it = list.iterator();
                            do {
                                if (it.hasNext()) {
                                }
                            } while (((wj) it.next()) != wjVar);
                            z2 = z4;
                        }
                        arrayList4.add(obj5);
                        z2 = z4;
                    }
                    z3 = z2;
                    collectionEmptyList = arrayList4;
                }
            } else {
                collectionEmptyList = CollectionsKt.emptyList();
            }
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            int size3 = arrayList.size();
            int i3 = z3 ? 1 : 0;
            while (i3 < size3) {
                Object obj6 = arrayList.get(i3);
                i3++;
                wj wjVar2 = (wj) obj6;
                if (!(collectionEmptyList instanceof Collection) || !collectionEmptyList.isEmpty()) {
                    Iterator it2 = collectionEmptyList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((wj) it2.next()).a(wjVar2)) {
                                arrayList5.add(obj6);
                                break;
                            }
                        }
                    }
                }
                arrayList6.add(obj6);
            }
            Pair pair = new Pair(arrayList5, arrayList6);
            List list2 = (List) pair.component1();
            List list3 = (List) pair.component2();
            Pair pair2 = TuplesKt.to(k7.a("ui_hide_on_screen"), list2);
            Pair pair3 = TuplesKt.to(k7.a("ui_hide_other_screens"), list3);
            Pair[] pairArr = new Pair[2];
            pairArr[z3 ? 1 : 0] = pair2;
            pairArr[1] = pair3;
            List listListOf = CollectionsKt.listOf(pairArr);
            ArrayList arrayList7 = new ArrayList();
            for (Object obj7 : listListOf) {
                if (!((Collection) ((Pair) obj7).getSecond()).isEmpty()) {
                    arrayList7.add(obj7);
                }
            }
            int size4 = arrayList7.size();
            int i4 = z3 ? 1 : 0;
            while (i4 < size4) {
                Object obj8 = arrayList7.get(i4);
                i4++;
                Pair pair4 = (Pair) obj8;
                String str = (String) pair4.component1();
                List<wj> list4 = (List) pair4.component2();
                if (arrayList7.size() <= 1) {
                    z = z3;
                } else {
                    z = z3;
                    TextView textViewA2 = fcVar.a(13.0f, z, fcVar.i);
                    textViewA2.setText(str);
                    textViewA2.setGravity(17);
                    textViewA2.setPadding(Main.dp(f2), Main.dp(f), Main.dp(f2), Main.dp(f));
                    linearLayout.addView(textViewA2);
                }
                for (final wj wjVar3 : list4) {
                    linearLayout.addView(a(fcVar, wjVar3, new Function0() {
                        public final Object invoke() {
                            return tj.b(scrollView, linearLayout, fcVar, activity);
                        }
                    }, new Function0() {
                        public final Object invoke() {
                            return tj.b(fcVar, activity, wjVar3);
                        }
                    }));
                }
                z3 = z;
            }
        }
        scrollView.post(new Runnable() {
            @Override
            public final void run() {
                tj.a(scrollView, scrollY);
            }
        });
    }

    public static final Unit b(ScrollView scrollView, LinearLayout linearLayout, fc fcVar, Activity activity) {
        a(scrollView, linearLayout, fcVar, activity);
        return Unit.INSTANCE;
    }

    public static final Unit b(fc fcVar, Activity activity, wj wjVar) {
        a(fcVar, activity, wjVar);
        return Unit.INSTANCE;
    }

    public static final void a(ScrollView scrollView, int i) {
        scrollView.scrollTo(0, i);
    }

    public static void a(fc fcVar, final Activity activity, final wj wjVar) {
        fcVar.c(new Runnable() {
            @Override
            public final void run() {
                tj.a(activity, wjVar);
            }
        });
    }

    public static final void a(final Activity activity, wj wjVar) {
        activity.getWindow().getDecorView();
        zj.a(activity, wjVar.a, wjVar.e, new Runnable() {
            @Override
            public final void run() {
                tj.a(activity);
            }
        });
    }

    public static final void a(Activity activity) {
        b(activity);
    }

    public static LinearLayout a(final fc fcVar, final wj wjVar, final Function0 function0, final Function0 function1) {
        LinearLayout linearLayoutE = fcVar.e();
        fcVar.a(linearLayoutE, new Runnable() {
            @Override
            public final void run() {
                tj.a(function1);
            }
        });
        final ImageView imageViewA = fcVar.a(wjVar.f);
        imageViewA.setContentDescription(wjVar.b);
        linearLayoutE.addView(imageViewA);
        final LinearLayout linearLayout = new LinearLayout(fcVar.a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setAlpha(wjVar.f ? 1.0f : 0.5f);
        CharSequence charSequence = wjVar.b;
        TextView textViewA = fcVar.a(14.0f, true, fcVar.h);
        textViewA.setText(charSequence);
        textViewA.setSingleLine(true);
        textViewA.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(textViewA);
        ImageView imageViewA2 = fcVar.a(fcVar.k, wjVar.a() ? "ic_delete" : "ic_hideui_opacity");
        imageViewA2.setContentDescription(k7.a(wjVar.a() ? "ui_hide_type_gone_short" : "ui_hide_type_alpha_short"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Main.dp(12.0f), Main.dp(12.0f));
        layoutParams.setMarginStart(Main.dp(4.0f));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageViewA2, layoutParams);
        linearLayoutE.addView(linearLayout, fc.h());
        imageViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                tj.a(imageViewA, wjVar, fcVar, linearLayout, view);
            }
        });
        ImageView imageViewA3 = fcVar.a(fcVar.k, "ic_close");
        imageViewA3.setContentDescription(k7.a("ui_hide_restore"));
        imageViewA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                tj.a(wjVar, function0, view);
            }
        });
        linearLayoutE.addView(imageViewA3);
        return linearLayoutE;
    }

    public static final void a(Function0 function0) {
        function0.invoke();
    }

    public static final void a(ImageView imageView, wj wjVar, fc fcVar, LinearLayout linearLayout, View view) {
        boolean zIsSelected = imageView.isSelected();
        boolean z = !zIsSelected;
        List<wj> listA = xj.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        for (wj wjVar2 : listA) {
            if (wjVar2.a(wjVar)) {
                wjVar2 = new wj(wjVar2.a, wjVar2.b, wjVar2.c, wjVar2.d, wjVar2.e, z);
            }
            arrayList.add(wjVar2);
        }
        xj.a(arrayList);
        pj.i();
        fcVar.a(imageView, z);
        linearLayout.setAlpha(!zIsSelected ? 1.0f : 0.5f);
    }
}
