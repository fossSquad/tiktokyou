package Z;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class e0 {
    public final le a;
    public final LinearLayout b;
    public final ArrayList c;
    public final int d;
    public final int e;
    public final int f;
    public final Runnable g;

    public e0(le leVar, LinearLayout linearLayout, ArrayList arrayList, int i, int i2, int i3, Runnable runnable) {
        this.a = leVar;
        this.b = linearLayout;
        this.c = arrayList;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = runnable;
    }

    public final void a(List list, boolean z) {
        String string;
        this.b.removeAllViews();
        this.c.clear();
        if (list.isEmpty() && !z) {
            LinearLayout linearLayout = this.b;
            TextView textView = new TextView(this.a);
            textView.setText(l6.a("auto_streak_sticker_empty"));
            textView.setTextSize(14.0f);
            textView.setTextColor(this.f);
            textView.setGravity(17);
            t1 t1Var = h0.a;
            textView.setPadding(h0.a((Context) this.a, 8), h0.a((Context) this.a, 20), h0.a((Context) this.a, 8), h0.a((Context) this.a, 12));
            linearLayout.addView(textView);
            return;
        }
        t1 t1Var2 = h0.a;
        le leVar = this.a;
        LinearLayout linearLayout2 = this.b;
        k0.a.getClass();
        ta.a.getClass();
        SharedPreferences sharedPreferences = ta.b;
        String strDecrypt = "";
        if (sharedPreferences != null && (string = sharedPreferences.getString("auto_streak_sticker", "")) != null) {
            strDecrypt = string;
        }
        if (StringsKt.isBlank(strDecrypt)) {
            strDecrypt = "spark_v1";
        }
        h0.a(leVar, linearLayout2, list, strDecrypt, this.d, this.e, new Function2() {
            public final Object invoke(Object obj, Object obj2) {
                return e0.a(this.f$0, (View) obj, (d0) obj2);
            }
        });
        if (z) {
            this.b.addView(h0.a(this.a, this.e, this.f));
        }
    }

    public static final Unit a(final e0 e0Var, View view, final d0 d0Var) {
        e0Var.c.add(TuplesKt.to(view, d0Var));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                e0.a(d0Var, e0Var, view2);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void a(d0 d0Var, e0 e0Var, View view) {
        int i;
        String strDecrypt;
        k0.a.getClass();
        ta taVar = ta.a;
        String str = d0Var.a;
        taVar.getClass();
        ta.b(str);
        String str2 = d0Var.b;
        if (str2 == null) {
            str2 = "";
        }
        ta.a(str2);
        String str3 = d0Var.d;
        if (str3 == null) {
            str3 = "";
        }
        ta.c(str3);
        synchronized (k0.c) {
            i = 0;
            k0.d = false;
            k0.e = null;
            Unit unit = Unit.INSTANCE;
        }
        taVar.getClass();
        SharedPreferences sharedPreferences = ta.b;
        if (sharedPreferences == null || (strDecrypt = sharedPreferences.getString("auto_streak_sticker", "")) == null) {
            strDecrypt = "";
        }
        if (StringsKt.isBlank(strDecrypt)) {
            strDecrypt = "spark_v1";
        }
        ArrayList arrayList = e0Var.c;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Pair pair = (Pair) obj;
            View view2 = (View) pair.component1();
            d0 d0Var2 = (d0) pair.component2();
            t1 t1Var = h0.a;
            h0.a(view2, e0Var.d, e0Var.e, Intrinsics.areEqual(d0Var2.a, strDecrypt));
        }
        e0Var.g.run();
    }
}
