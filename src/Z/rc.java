package Z;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;

public final  class rc extends FunctionReferenceImpl implements Function1 {
    public rc(se seVar) {
        super(1, seVar, se.class, "update", "update(I)V", 0);
    }

    public final Object invoke(Object obj) {
        ((se) this.receiver).a(((Number) obj).intValue());
        return Unit.INSTANCE;
    }
}
