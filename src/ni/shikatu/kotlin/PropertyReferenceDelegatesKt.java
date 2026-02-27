package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KMutableProperty0;
import ni.shikatu.kotlin.reflect.KMutableProperty1;
import ni.shikatu.kotlin.reflect.KProperty;
import ni.shikatu.kotlin.reflect.KProperty0;
import ni.shikatu.kotlin.reflect.KProperty1;

@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0087\n¢\u0006\u0002\u0010\u0007\u001a<\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000b\u001a\u0002H\u0001H\u0087\n¢\u0006\u0002\u0010\f\u001a>\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00010\u000e2\u0006\u0010\u0003\u001a\u0002H\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0087\n¢\u0006\u0002\u0010\u000f\u001aF\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00010\u00102\u0006\u0010\u0003\u001a\u0002H\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000b\u001a\u0002H\u0001H\u0087\n¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"getValue", "V", "Lni/shikatu/kotlin/reflect/KProperty0;", "thisRef", "", "property", "Lni/shikatu/kotlin/reflect/KProperty;", "(Lkotlin/reflect/KProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "Lni/shikatu/kotlin/reflect/KMutableProperty0;", "value", "(Lkotlin/reflect/KMutableProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "T", "Lni/shikatu/kotlin/reflect/KProperty1;", "(Lkotlin/reflect/KProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lni/shikatu/kotlin/reflect/KMutableProperty1;", "(Lkotlin/reflect/KMutableProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PropertyReferenceDelegatesKt {
    private static final <V> V getValue(KProperty0<? extends V> kProperty0, Object thisRef, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty0, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return kProperty0.get();
    }

    private static final <V> void setValue(KMutableProperty0<V> kMutableProperty0, Object thisRef, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(kMutableProperty0, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        kMutableProperty0.set(v);
    }

    private static final <T, V> V getValue(KProperty1<T, ? extends V> kProperty1, T t, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty1, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return kProperty1.get(t);
    }

    private static final <T, V> void setValue(KMutableProperty1<T, V> kMutableProperty1, T t, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(kMutableProperty1, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        kMutableProperty1.set(t, v);
    }
}
