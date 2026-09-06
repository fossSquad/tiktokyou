package Z;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;

public final  class x2 extends FunctionReferenceImpl implements Function0 {
    public x2(h3 h3Var) {
        super(0, h3Var, h3.class, "onSuccess", "onSuccess()V", 0);
    }

    public final Object invoke() {
        h3 h3Var = (h3) ((FunctionReferenceImpl) this).receiver;
        h3Var.getClass();
        AtomicLong atomicLong = c4.a;
        c4.a(h3Var.a);
        return Unit.INSTANCE;
    }
}
