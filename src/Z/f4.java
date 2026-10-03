package Z;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;

public final  class f4 extends FunctionReferenceImpl implements Function2 {
    public f4(g4 g4Var) {
        super(2, g4Var, g4.class, "compareQuality", "compareQuality(Lcom/windukk/mod/hooks/download/DownloadChoice;Lcom/windukk/mod/hooks/download/DownloadChoice;)I", 0);
    }

    public final Object invoke(Object obj, Object obj2) {
        ((g4) this.receiver).getClass();
        return Integer.valueOf(g4.a((b3) obj, (b3) obj2));
    }
}
