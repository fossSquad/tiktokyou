package Z;

import android.app.Dialog;
import android.widget.TextView;
import ni.shikatu.kotlin.jvm.internal.Ref;

public final class oe implements Runnable {
    public final  Dialog a;
    public final  Ref.IntRef b;
    public final  TextView c;
    public final  qe d;
    public final  int e;

    public oe(Dialog dialog, Ref.IntRef intRef, TextView textView, qe qeVar, int i) {
        this.a = dialog;
        this.b = intRef;
        this.c = textView;
        this.d = qeVar;
        this.e = i;
    }

    @Override
    public final void run() {
        Ref.IntRef intRef;
        int i;
        if (this.a.isShowing() && (i = (intRef = this.b).element) > 0) {
            intRef.element = i - 1;
            qe.a(intRef, this.c, this.d, this.e);
            if (this.b.element > 0) {
                qe.b.postDelayed(this, 1000L);
            }
        }
    }
}
