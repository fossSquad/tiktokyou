package ni.shikatu.kotlin.collections;

import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KProperty;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aP\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0087\u008a\u0004b\u0002\b\u000b¢\u0006\u0002\u0010\n\u001ab\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u000b\b\u0001\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0087\u008a\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\rb\u0002\b\u000b¢\u0006\u0004\b\r\u0010\n\u001aK\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\u008a\u0004b\u0002\b\u000b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"getValue", "V1", "V", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/Exact;", "thisRef", _UrlKt.FRAGMENT_ENCODE_SET, "property", "Lni/shikatu/kotlin/reflect/KProperty;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lni/shikatu/kotlin/internal/InlineOnly;", _UrlKt.FRAGMENT_ENCODE_SET, "getVar", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "setValue", _UrlKt.FRAGMENT_ENCODE_SET, "value", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class MapAccessorsKt {
    private static final <V, V1 extends V> V1 getValue(Map<? super String, ? extends V> map, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return (V1) MapsKt.getOrImplicitDefaultNullable(map, kProperty.getName());
    }

    private static final <V, V1 extends V> V1 getVar(Map<? super String, ? extends V> map, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return (V1) MapsKt.getOrImplicitDefaultNullable(map, kProperty.getName());
    }

    private static final <V> void setValue(Map<? super String, ? super V> map, Object thisRef, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        map.put(kProperty.getName(), v);
    }
}
