package ni.shikatu.kotlin.reflect;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u0010J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\tR$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bX¦\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlin/reflect/KMutableProperty1;", "T", "V", "Lni/shikatu/kotlin/reflect/KProperty1;", "Lni/shikatu/kotlin/reflect/KMutableProperty;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "setter", "Lni/shikatu/kotlin/reflect/KMutableProperty1$Setter;", "getSetter$annotations", "()V", "getSetter", "()Lkotlin/reflect/KMutableProperty1$Setter;", "Setter", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface KMutableProperty1<T, V> extends KProperty1<T, V>, KMutableProperty<V> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static  void getSetter$annotations() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/reflect/KMutableProperty1$Setter;", "T", "V", "Lni/shikatu/kotlin/reflect/KMutableProperty$Setter;", "Lni/shikatu/kotlin/Function2;", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Setter<T, V> extends KMutableProperty.Setter<V>, Function2<T, V, Unit> {
    }

    @Override
    Setter<T, V> getSetter();

    void set(T t, V v);
}
