package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0019\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004H¦\u0080\u0004¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/GeneratedSerializer;", "T", "Lni/shikatu/kotlinx/serialization/KSerializer;", "childSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "()[Lkotlinx/serialization/KSerializer;", "typeParametersSerializers", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
public interface GeneratedSerializer<T> extends KSerializer<T> {
    KSerializer<?>[] childSerializers();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> KSerializer<?>[] typeParametersSerializers(GeneratedSerializer<T> generatedSerializer) {
            return $this.typeParametersSerializers();
        }
    }

    default KSerializer<?>[] typeParametersSerializers() {
        return PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY;
    }
}
