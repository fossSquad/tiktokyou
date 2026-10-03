package ni.shikatu.kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0081\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005b\u0002\b\t¢\u0006\u0004\b\u0005\u0010\u0006\u001aU\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\r\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\fH\u0086\u0080\u0004\u001ah\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u000e2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\r\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\fH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"getOrImplicitDefault", "V", "K", _UrlKt.FRAGMENT_ENCODE_SET, "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "Lni/shikatu/kotlin/PublishedApi;", "withDefault", "defaultValue", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", _UrlKt.FRAGMENT_ENCODE_SET, "withDefaultMutable", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/MapsKt")
class MapsKt__MapWithDefaultKt {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).getOrImplicitDefault(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        return map instanceof MapWithDefault ? MapsKt.withDefault(((MapWithDefault) map).getMap(), function1) : new MapWithDefaultImpl(map, function1);
    }

    public static final <K, V> Map<K, V> withDefaultMutable(Map<K, V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        return map instanceof MutableMapWithDefault ? MapsKt.withDefaultMutable(((MutableMapWithDefault) map).getMap(), function1) : new MutableMapWithDefaultImpl(map, function1);
    }
}
