package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/HashSetClassDesc;", "Lni/shikatu/kotlinx/serialization/internal/ListLikeDescriptor;", "elementDesc", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialName", "()Ljava/lang/String;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HashSetClassDesc extends ListLikeDescriptor {

    public HashSetClassDesc(SerialDescriptor elementDesc) {
        super(elementDesc, null);
        Intrinsics.checkNotNullParameter(elementDesc, "elementDesc");
    }

    @Override
    public String getSerialName() {
        return CollectionDescriptorsKt.HASH_SET_NAME;
    }
}
