package ni.shikatu.kotlin.math;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lni/shikatu/kotlin/math/Constants;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "LN2", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/jvm/JvmField;", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class Constants {
    public static final Constants INSTANCE = new Constants();
    public static final double LN2 = Math.log(2.0d);
    public static final double epsilon = Math.ulp(1.0d);
    public static final double taylor_2_bound = Math.sqrt(epsilon);
    public static final double taylor_n_bound = Math.sqrt(taylor_2_bound);
    public static final double upper_taylor_2_bound;
    public static final double upper_taylor_n_bound;

    private Constants() {
    }

    static {
        double d = 1;
        upper_taylor_2_bound = d / taylor_2_bound;
        upper_taylor_n_bound = d / taylor_n_bound;
    }
}
