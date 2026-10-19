package Z;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
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

public final class o0 {
    public final i0 a;
    public final LinearLayout b;
    public final ArrayList c;
    public final int d;
    public final int e;
    public final int f;
    public final Runnable g;
    public List h;
    public ValueAnimator i;
    public boolean j;

    public o0(i0 i0Var, LinearLayout linearLayout, ArrayList arrayList, int i, int i2, int i3, Runnable runnable) {
        this.a = i0Var;
        this.b = linearLayout;
        this.c = arrayList;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = runnable;
    }

    public final void a(List list, boolean z) {
        int height;
        Object parent = this.b.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            height = 0;
        } else {
            View view2 = view.isLaidOut() ? view : null;
            if (view2 != null) {
                height = view2.getHeight();
            } else {
                height = 0;
            }
        }
        this.h = list;
        this.j = z;
        b(list, z);
        if (view == null || height <= 0) {
            return;
        }
        a(height, view);
    }

    public final void b(List list, boolean z) {
        String string;
        this.b.removeAllViews();
        this.c.clear();
        if (list.isEmpty() && !z) {
            LinearLayout linearLayout = this.b;
            TextView textView = new TextView(this.a);
            textView.setText(k7.a("auto_streak_sticker_empty"));
            textView.setTextSize(14.0f);
            textView.setTextColor(this.f);
            textView.setGravity(17);
            d2 d2Var = r0.a;
            textView.setPadding(r0.a((Context) this.a, 8), r0.a((Context) this.a, 20), r0.a((Context) this.a, 8), r0.a((Context) this.a, 12));
            linearLayout.addView(textView);
            return;
        }
        d2 d2Var2 = r0.a;
        i0 i0Var = this.a;
        LinearLayout linearLayout2 = this.b;
        u0.a.getClass();
        ac.a.getClass();
        SharedPreferences sharedPreferences = ac.b;
        String strDecrypt = "";
        if (sharedPreferences != null && (string = sharedPreferences.getString("auto_streak_sticker", "")) != null) {
            strDecrypt = string;
        }
        if (StringsKt.isBlank(strDecrypt)) {
            strDecrypt = "spark_v1";
        }
        r0.a(i0Var, linearLayout2, list, strDecrypt, this.d, this.e, new Function2() {
            public final Object invoke(Object obj, Object obj2) {
                return o0.a(this.f$0, (View) obj, (m0) obj2);
            }
        });
        if (z) {
            this.b.addView(r0.a(this.a, this.e, this.f));
        }
    }

    public static final Unit a(final o0 o0Var, View view, final m0 m0Var) {
        o0Var.c.add(TuplesKt.to(view, m0Var));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                o0.a(m0Var, o0Var, view2);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void a(m0 m0Var, o0 o0Var, View view) {
        int i;
        String strDecrypt;
        u0.a.getClass();
        ac acVar = ac.a;
        String str = m0Var.a;
        acVar.getClass();
        ac.b(str);
        String str2 = m0Var.b;
        if (str2 == null) {
            str2 = "";
        }
        ac.a(str2);
        String str3 = m0Var.d;
        if (str3 == null) {
            str3 = "";
        }
        ac.c(str3);
        synchronized (u0.c) {
            i = 0;
            u0.d = false;
            u0.e = null;
            Unit unit = Unit.INSTANCE;
        }
        acVar.getClass();
        SharedPreferences sharedPreferences = ac.b;
        if (sharedPreferences == null || (strDecrypt = sharedPreferences.getString("auto_streak_sticker", "")) == null) {
            strDecrypt = "";
        }
        if (StringsKt.isBlank(strDecrypt)) {
            strDecrypt = "spark_v1";
        }
        ArrayList arrayList = o0Var.c;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Pair pair = (Pair) obj;
            View view2 = (View) pair.component1();
            m0 m0Var2 = (m0) pair.component2();
            d2 d2Var = r0.a;
            r0.a(view2, o0Var.d, o0Var.e, Intrinsics.areEqual(m0Var2.a, strDecrypt));
        }
        o0Var.g.run();
    }

    public final void a(int i, final View view) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        layoutParams.height = -2;
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight == i) {
            view.requestLayout();
            return;
        }
        layoutParams.height = i;
        view.requestLayout();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, measuredHeight);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator(1.6f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                o0.a(layoutParams, view, valueAnimator2);
            }
        });
        valueAnimatorOfInt.addListener(new n0(this, layoutParams, view));
        this.i = valueAnimatorOfInt;
        valueAnimatorOfInt.start();
    }

    public static final void a(ViewGroup.LayoutParams layoutParams, View view, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        layoutParams.height = ((Integer) animatedValue).intValue();
        view.requestLayout();
    }
}
