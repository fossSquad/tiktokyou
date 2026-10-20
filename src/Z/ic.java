package Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class ic extends AnimatorListenerAdapter {
    public boolean a;
    public final  jc b;
    public final  Runnable c;

    public ic(jc jcVar, Runnable runnable) {
        this.b = jcVar;
        this.c = runnable;
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        jc jcVar = this.b;
        if (jcVar.g == animator) {
            jcVar.g = null;
        }
        Runnable runnable = this.c;
        if (runnable == null || this.a) {
            return;
        }
        runnable.run();
    }
}
