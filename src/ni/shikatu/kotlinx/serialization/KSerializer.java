package ni.shikatu.kotlinx.serialization;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/KSerializer;", "T", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface KSerializer<T> extends SerializationStrategy<T>, DeserializationStrategy<T> {
    @Override
    SerialDescriptor getDescriptor();
}
