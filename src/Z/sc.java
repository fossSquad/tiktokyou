package Z;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;

public final  class sc extends FunctionReferenceImpl implements Function0 {
    public sc(g3 g3Var) {
        super(0, g3Var, g3.class, "onSuccess", "onSuccess()V", 0);
    }

    public final Object invoke() {
        g3 g3Var = (g3) this.receiver;
        g3Var.getClass();
        AtomicLong atomicLong = c4.a;
        c4.a(g3Var.a);
        return Unit.INSTANCE;
    }
}
