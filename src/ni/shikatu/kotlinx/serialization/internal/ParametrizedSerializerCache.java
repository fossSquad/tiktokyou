package ni.shikatu.kotlinx.serialization.internal;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J=\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH¦\u0080\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ParametrizedSerializerCache;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "get", "Lni/shikatu/kotlin/Result;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "key", "Lni/shikatu/kotlin/reflect/KClass;", "types", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KType;", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ParametrizedSerializerCache<T> {

    Object mo1535getgIAlus(KClass<Object> kClass, List<? extends KType> list);

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static  Object m1542getgIAlus$default(ParametrizedSerializerCache parametrizedSerializerCache, KClass kClass, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get-gIAlu-s");
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return parametrizedSerializerCache.mo1535getgIAlus(kClass, list);
    }
}
