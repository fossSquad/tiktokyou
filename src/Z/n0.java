package Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
public final class n0 extends AnimatorListenerAdapter {
    public final  o0 a;
    public final  ViewGroup.LayoutParams b;
    public final  View c;

    public n0(o0 o0Var, ViewGroup.LayoutParams layoutParams, View view) {
        this.a = o0Var;
        this.b = layoutParams;
        this.c = view;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        if (this.a.i == animator) {
            this.b.height = -2;
            this.c.requestLayout();
            this.a.i = null;
        }
    }
}
