package ni.shikatu.kotlin.coroutines;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a[\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010\u0005\u001aH\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¨\u0006\u0012"}, d2 = {"getPolymorphicElement", "E", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Element;", "key", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "Lni/shikatu/kotlin/Deprecated;", "message", "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "2.4", "minusPolymorphicKey", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class CoroutineContextImplKt {

    @Deprecated(message = "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.")
    @DeprecatedSinceKotlin(warningSince = "2.4")
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element element, CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            if (!((AbstractCoroutineContextKey) key).isSubKey$kotlin_stdlib(element.getKey())) {
                return null;
            }
            E e = (E) ((AbstractCoroutineContextKey) key).tryCast$kotlin_stdlib(element);
            if (e instanceof CoroutineContext.Element) {
                return e;
            }
            return null;
        }
        if (element.getKey() == key) {
            return element;
        }
        return null;
    }

    @Deprecated(message = "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.")
    @DeprecatedSinceKotlin(warningSince = "2.4")
    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element $this$minusPolymorphicKey, CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter($this$minusPolymorphicKey, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            return (!((AbstractCoroutineContextKey) key).isSubKey$kotlin_stdlib($this$minusPolymorphicKey.getKey()) || ((AbstractCoroutineContextKey) key).tryCast$kotlin_stdlib($this$minusPolymorphicKey) == null) ? $this$minusPolymorphicKey : EmptyCoroutineContext.INSTANCE;
        }
        return $this$minusPolymorphicKey.getKey() == key ? EmptyCoroutineContext.INSTANCE : $this$minusPolymorphicKey;
    }
}
