package ni.shikatu.kotlin.collections.jdk8;

import java.util.Map;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.TypeIntrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aT\u0010\u0000\u001a\u0002H\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0001H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000b¢\u0006\u0002\u0010\u0007\u001a_\u0010\f\u001a\u00020\r\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003\"\t\b\u0001\u0010\u0001¢\u0006\u0002\b\u0003*\u0012\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000e2\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u000f\u001a\u0002H\u0001H\u0087\u0088\bb\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000bb\u0002\b\u0011¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"getOrDefault", "V", "K", "Lni/shikatu/kotlin/internal/OnlyInputTypes;", _UrlKt.FRAGMENT_ENCODE_SET, "key", "defaultValue", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", "Lni/shikatu/kotlin/internal/InlineOnly;", "remove", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "Lni/shikatu/kotlin/IgnorableReturnValue;", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 2, mv = {2, 4, 0}, pn = "ni.shikatu.kotlin.collections", xi = 48)
public final class CollectionsJDK8Kt {

    private static final <K, V> V getOrDefault(Map<? extends K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.getOrDefault(k, v);
    }

    @IgnorableReturnValue
    private static final <K, V> boolean remove(Map<? extends K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return TypeIntrinsics.asMutableMap(map).remove(k, v);
    }
}
