package ni.shikatu.kotlin.reflect;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\fJ\u0017\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\u0007R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/reflect/KMutableProperty0;", "V", "Lni/shikatu/kotlin/reflect/KProperty0;", "Lni/shikatu/kotlin/reflect/KMutableProperty;", "set", _UrlKt.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Object;)V", "setter", "Lni/shikatu/kotlin/reflect/KMutableProperty0$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty0$Setter;", "Setter", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface KMutableProperty0<V> extends KProperty0<V>, KMutableProperty<V> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lni/shikatu/kotlin/reflect/KMutableProperty0$Setter;", "V", "Lni/shikatu/kotlin/reflect/KMutableProperty$Setter;", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public interface Setter<V> extends KMutableProperty.Setter<V>, Function1<V, Unit> {
    }

    @Override
    Setter<V> getSetter();

    void set(V v);
}
