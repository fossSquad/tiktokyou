package Z;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;

public final  class u4 extends FunctionReferenceImpl implements Function2 {
    public u4(v4 v4Var) {
        super(2, v4Var, v4.class, "compareQuality", "compareQuality(Lcom/windukk/mod/hooks/download/DownloadChoice;Lcom/windukk/mod/hooks/download/DownloadChoice;)I", 0);
    }

    public final Object invoke(Object obj, Object obj2) {
        ((v4) ((FunctionReferenceImpl) this).receiver).getClass();
        return Integer.valueOf(v4.a((o3) obj, (o3) obj2));
    }
}
