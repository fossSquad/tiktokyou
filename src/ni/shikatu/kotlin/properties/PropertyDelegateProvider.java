package ni.shikatu.kotlin.properties;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\"\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H¦\u0002¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/properties/PropertyDelegateProvider;", "T", "D", "", "provideDelegate", "thisRef", "property", "Lni/shikatu/kotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PropertyDelegateProvider<T, D> {
    D provideDelegate(T t, KProperty<?> kProperty);
}
