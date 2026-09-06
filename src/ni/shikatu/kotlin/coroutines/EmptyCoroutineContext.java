package ni.shikatu.kotlin.coroutines;

import java.io.Serializable;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\bB¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH\u0082\u0080\u0004J)\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0096\u0082\u0004¢\u0006\u0002\u0010\u000fJ7\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u0002H\u00112\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00110\u0014H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0082\u0004J\u0016\u0010\u0018\u001a\u00020\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082Ô\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( ¨\u0006\u001d"}, d2 = {"Lni/shikatu/kotlin/coroutines/EmptyCoroutineContext;", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "readResolve", _UrlKt.FRAGMENT_ENCODE_SET, "get", "E", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Element;", "key", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lni/shikatu/kotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "plus", "context", "minusKey", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return r;
    }

    @Override
    public CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context;
    }

    @Override
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
