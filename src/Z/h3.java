package Z;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;

public final  class h3 extends FunctionReferenceImpl implements Function1 {
    public h3(fg fgVar) {
        super(1, fgVar, fg.class, "update", "update(I)V", 0);
    }

    public final Object invoke(Object obj) {
        ((fg) this.receiver).a(((Number) obj).intValue());
        return Unit.INSTANCE;
    }
}
