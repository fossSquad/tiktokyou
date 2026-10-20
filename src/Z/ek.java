package Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class ek extends AnimatorListenerAdapter {
    public final  WeakReference a;
    public final  ViewGroup b;
    public final  GradientDrawable c;

    public ek(WeakReference weakReference, ViewGroup viewGroup, GradientDrawable gradientDrawable) {
        this.a = weakReference;
        this.b = viewGroup;
        this.c = gradientDrawable;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        if (pj.p != animator) {
            return;
        }
        pj.p = null;
        View view = (View) this.a.get();
        if (view != null) {
            ViewGroup viewGroup = this.b;
            GradientDrawable gradientDrawable = this.c;
            pj pjVar = pj.a;
            Rect rectA = view.isShown() ? pj.a(viewGroup, view) : null;
            if (rectA == null) {
                rectA = new Rect();
            }
            if (Intrinsics.areEqual(gradientDrawable.getBounds(), rectA)) {
                return;
            }
            gradientDrawable.setBounds(rectA);
            gradientDrawable.invalidateSelf();
        }
    }
}
