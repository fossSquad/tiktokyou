package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b!\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b@¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H \u0080\u0004¢\u0006\u0002\b\fJ\u0011\u0010\r\u001a\u00028\u0000H \u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u0006X \u0084\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/PrimitiveArrayBuilder;", "Array", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "position", _UrlKt.FRAGMENT_ENCODE_SET, "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "()Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PrimitiveArrayBuilder<Array> {
    public abstract Array build$kotlinx_serialization_core();

    public abstract void ensureCapacity$kotlinx_serialization_core(int i);

    public abstract int getPosition$kotlinx_serialization_core();

    public static  void ensureCapacity$kotlinx_serialization_core$default(PrimitiveArrayBuilder primitiveArrayBuilder, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i2 & 1) != 0) {
            i = primitiveArrayBuilder.getPosition$kotlinx_serialization_core() + 1;
        }
        primitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core(i);
    }
}
