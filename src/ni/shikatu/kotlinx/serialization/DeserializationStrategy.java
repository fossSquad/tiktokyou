package ni.shikatu.kotlinx.serialization;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0017\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH¦\u0080\u0004¢\u0006\u0002\u0010\nR\u0013\u0010\u0003\u001a\u00020\u0004X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface DeserializationStrategy<T> {
    T deserialize(Decoder decoder);

    SerialDescriptor getDescriptor();
}
