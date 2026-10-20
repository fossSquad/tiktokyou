package Z;

import android.os.Handler;
import android.widget.TextView;
import java.util.Arrays;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;

public final class xi implements Runnable {
    public final  Ref.IntRef a;
    public final  TextView b;
    public final  String c;
    public final  fc d;
    public final  String e;
    public final  Handler f;

    public xi(Ref.IntRef intRef, TextView textView, String str, fc fcVar, String str2, Handler handler) {
        this.a = intRef;
        this.b = textView;
        this.c = str;
        this.d = fcVar;
        this.e = str2;
        this.f = handler;
    }

    @Override
    public final void run() {
        int i = this.a.element;
        if (i <= 0) {
            this.b.setText(this.c);
            this.b.setEnabled(true);
            this.b.animate().alpha(1.0f).setDuration(200L).start();
            fc fcVar = this.d;
            fcVar.v = true;
            fcVar.b.setCancelable(true);
            return;
        }
        TextView textView = this.b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        textView.setText(String.format(this.e, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1)));
        TextView textView2 = this.b;
        textView2.setEnabled(false);
        textView2.setAlpha(0.5f);
        this.a.element--;
        this.f.postDelayed(this, 1000L);
    }
}
