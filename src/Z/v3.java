package Z;

import android.app.Dialog;
import android.widget.LinearLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final  class v3 extends FunctionReferenceImpl implements Function0 {
    public final  AtomicBoolean a;
    public final  x3 b;
    public final  LinearLayout c;
    public final  Dialog d;
    public final  c3 e;

    public v3(AtomicBoolean atomicBoolean, x3 x3Var, LinearLayout linearLayout, Dialog dialog, c3 c3Var) {
        super(0, Intrinsics.Kotlin.class, "unavailable", "showNow$lambda$0$unavailable(Ljava/util/concurrent/atomic/AtomicBoolean;Lcom/windukk/mod/hooks/download/DownloadQualityBottomSheet;Landroid/widget/LinearLayout;Landroid/app/Dialog;Lcom/windukk/mod/hooks/download/DownloadQualityBottomSheet$Callback;)V", 0);
        this.a = atomicBoolean;
        this.b = x3Var;
        this.c = linearLayout;
        this.d = dialog;
        this.e = c3Var;
    }

    public final Object invoke() {
        x3.a(this.a, this.b, this.c, this.d, this.e);
        return Unit.INSTANCE;
    }
}
