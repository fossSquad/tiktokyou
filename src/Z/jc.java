package Z;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.windukk.mod.hooks.EdgeSpeedupHooks;
import java.util.ArrayList;

public final class jc extends Dialog {
    public View a;
    public ColorDrawable b;
    public float c;
    public float d;
    public boolean e;
    public boolean f;
    public ValueAnimator g;
    public final ArrayList h;

    public jc(Activity activity) {
        super(activity, R.style.Theme_Translucent_NoTitleBar);
        this.e = true;
        this.h = new ArrayList();
    }

    public final void a() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            this.g = null;
            valueAnimator.removeAllListeners();
            valueAnimator.cancel();
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
        }
        int i = 0;
        this.f = false;
        View view = this.a;
        if (view != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new hc(view, this));
        }
        ArrayList arrayList = new ArrayList(this.h);
        this.h.clear();
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                ((Runnable) obj).run();
            } catch (Throwable th2) {
                String strDecrypt = "Sheet dismiss action failed";
                Object obj2 = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th2);
            }
        }
    }

    @Override
    public final void dismiss() {
        Activity ownerActivity;
        if (this.f) {
            return;
        }
        View view = this.a;
        if (view == null || !isShowing() || !view.isAttachedToWindow() || view.getHeight() == 0 || ((ownerActivity = getOwnerActivity()) != null && (ownerActivity.isFinishing() || ownerActivity.isDestroyed()))) {
            a();
        } else {
            this.f = true;
            EdgeSpeedupHooks.a(this, view.getHeight(), Math.max(120L, (long) ((1.0f - Math.max(0.0f, Math.min(1.0f, this.d / view.getHeight()))) * 240.0f)), new AccelerateInterpolator(1.4f), new Runnable() {
                @Override
                public final void run() {
                    jc.this.a();
                }
            });
        }
    }

    @Override
    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.e = z;
    }
}
