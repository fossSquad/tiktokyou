package ni.shikatu.kotlin.coroutines;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Deprecated(message = "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.")
@DeprecatedSinceKotlin(warningSince = "2.4")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u0002H\u00012\b\u0012\u0004\u0012\u0002H\u00030\u0004B<\bF\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00020\u0002H\u0080\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0080\u0080\u0004¢\u0006\u0002\b\u0016R,\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001aÊ\u0001\u0002\b\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001eÊ\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¨\u0006\u0017"}, d2 = {"Lni/shikatu/kotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Element;", "E", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", "name", "element", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "getTopmostKey$annotations", "()V", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "isSubKey", _UrlKt.FRAGMENT_ENCODE_SET, "key", "isSubKey$kotlin_stdlib", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "Lni/shikatu/kotlin/Deprecated;", "message", "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "2.4"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    private final Function1<CoroutineContext.Element, E> safeCast;
    private final CoroutineContext.Key<?> topmostKey;

    private static  void getTopmostKey$annotations() {
    }

    public AbstractCoroutineContextKey(CoroutineContext.Key<B> key, Function1<? super CoroutineContext.Element, ? extends E> function1) {
        Intrinsics.checkNotNullParameter(key, "baseKey");
        Intrinsics.checkNotNullParameter(function1, "safeCast");
        this.safeCast = function1;
        this.topmostKey = key instanceof AbstractCoroutineContextKey ? ((AbstractCoroutineContextKey) key).topmostKey : key;
    }

    public final CoroutineContext.Element tryCast$kotlin_stdlib(CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return (CoroutineContext.Element) this.safeCast.invoke(element);
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key == this || this.topmostKey == key;
    }
}
