package ni.shikatu.kotlin.collections;

import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\bb\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003J\u0017\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\tR\u001f\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lni/shikatu/kotlin/collections/MapWithDefault;", "K", "V", _UrlKt.FRAGMENT_ENCODE_SET, "map", "getMap", "()Ljava/util/Map;", "getOrImplicitDefault", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
interface MapWithDefault<K, V> extends Map<K, V>, KMappedMarker {
    Map<K, V> getMap();

    V getOrImplicitDefault(K k);
}
