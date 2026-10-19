package Z;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final  class l4 extends FunctionReferenceImpl implements Function0 {
    public final  AtomicBoolean a;
    public final  fc b;
    public final  p3 c;

    public l4(AtomicBoolean atomicBoolean, fc fcVar, p3 p3Var) {
        super(0, Intrinsics.Kotlin.class, "unavailable", "showNow$lambda$0$unavailable(Ljava/util/concurrent/atomic/AtomicBoolean;Lcom/windukk/mod/utils/ModSheet;Lcom/windukk/mod/hooks/download/DownloadQualityBottomSheet$Callback;)V", 0);
        this.a = atomicBoolean;
        this.b = fcVar;
        this.c = p3Var;
    }

    public final Object invoke() {
        m4.a(this.a, this.b, this.c);
        return Unit.INSTANCE;
    }
}
