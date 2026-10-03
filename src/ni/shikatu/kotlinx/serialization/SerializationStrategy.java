package ni.shikatu.kotlinx.serialization;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\fR\u0013\u0010\u0003\u001a\u00020\u0004X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SerializationStrategy<T> {
    SerialDescriptor getDescriptor();

    void serialize(Encoder encoder, T t);
}
