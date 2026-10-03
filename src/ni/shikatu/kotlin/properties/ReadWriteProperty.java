package ni.shikatu.kotlin.properties;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.reflect.KProperty;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003J#\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H¦\u0082\u0004¢\u0006\u0002\u0010\bJ+\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000b\u001a\u00028\u0001H¦\u0082\u0004¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/properties/ReadWriteProperty;", "T", "V", "Lni/shikatu/kotlin/properties/ReadOnlyProperty;", "getValue", "thisRef", "property", "Lni/shikatu/kotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", _UrlKt.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface ReadWriteProperty<T, V> extends ReadOnlyProperty<T, V> {
    @Override
    V getValue(T t, KProperty<?> kProperty);

    void setValue(T t, KProperty<?> kProperty, V v);
}
