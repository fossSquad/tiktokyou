package Z;

import android.widget.TextView;
import ni.shikatu.kotlin.jvm.internal.Ref;

public final class cg implements Runnable {
    public final  fc a;
    public final  Ref.IntRef b;
    public final  TextView c;

    public cg(fc fcVar, Ref.IntRef intRef, TextView textView) {
        this.a = fcVar;
        this.b = intRef;
        this.c = textView;
    }

    @Override
    public final void run() {
        Ref.IntRef intRef;
        int i;
        if (this.a.b.isShowing() && (i = (intRef = this.b).element) > 0) {
            intRef.element = i - 1;
            dg.a(intRef, this.c);
            if (this.b.element > 0) {
                dg.b.postDelayed(this, 1000L);
            }
        }
    }
}
