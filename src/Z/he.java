package Z;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;

public final  class he extends FunctionReferenceImpl implements Function0 {
    public he(t3 t3Var) {
        super(0, t3Var, t3.class, "onSuccess", "onSuccess()V", 0);
    }

    public final Object invoke() {
        t3 t3Var = (t3) this.receiver;
        t3Var.getClass();
        AtomicLong atomicLong = r4.a;
        r4.a(t3Var.a);
        return Unit.INSTANCE;
    }
}
