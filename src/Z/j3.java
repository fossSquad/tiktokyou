package Z;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;

public final  class j3 extends FunctionReferenceImpl implements Function0 {
    public j3(u3 u3Var) {
        super(0, u3Var, u3.class, "onSuccess", "onSuccess()V", 0);
    }

    public final Object invoke() {
        u3 u3Var = (u3) this.receiver;
        u3Var.getClass();
        AtomicLong atomicLong = r4.a;
        r4.a(u3Var.a);
        return Unit.INSTANCE;
    }
}
