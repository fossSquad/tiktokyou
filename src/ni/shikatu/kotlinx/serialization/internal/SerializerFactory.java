package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Deprecated(level = DeprecationLevel.HIDDEN, message = "Inserted into generated code and should not be used directly")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0005\"\u0006\u0012\u0002\b\u00030\u0003H¦\u0080\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/SerializerFactory;", _UrlKt.FRAGMENT_ENCODE_SET, "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "typeParamsSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "([Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SerializerFactory {
    KSerializer<?> serializer(KSerializer<?>... kSerializerArr);
}
