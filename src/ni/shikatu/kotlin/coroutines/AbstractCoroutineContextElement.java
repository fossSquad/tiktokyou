package ni.shikatu.kotlin.coroutines;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/coroutines/AbstractCoroutineContextElement;", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Element;", "key", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Key;", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractCoroutineContextElement implements CoroutineContext.Element {
    private final CoroutineContext.Key<?> key;

    @Override
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Override
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override
    public CoroutineContext plus(CoroutineContext context) {
        return CoroutineContext.Element.DefaultImpls.plus(this, context);
    }

    public AbstractCoroutineContextElement(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    @Override
    public CoroutineContext.Key<?> getKey() {
        return this.key;
    }
}
