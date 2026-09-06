package ni.shikatu.kotlin.reflect;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u000eJ\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H¦\u0080\u0004¢\u0006\u0002\u0010\tR\u001f\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/reflect/KMutableProperty1;", "T", "V", "Lni/shikatu/kotlin/reflect/KProperty1;", "Lni/shikatu/kotlin/reflect/KMutableProperty;", "set", _UrlKt.FRAGMENT_ENCODE_SET, "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "setter", "Lni/shikatu/kotlin/reflect/KMutableProperty1$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty1$Setter;", "Setter", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface KMutableProperty1<T, V> extends KProperty1<T, V>, KMutableProperty<V> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/reflect/KMutableProperty1$Setter;", "T", "V", "Lni/shikatu/kotlin/reflect/KMutableProperty$Setter;", "Lni/shikatu/kotlin/Function2;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public interface Setter<T, V> extends KMutableProperty.Setter<V>, Function2<T, V, Unit> {
    }

    @Override
    Setter<T, V> getSetter();

    void set(T t, V v);
}
