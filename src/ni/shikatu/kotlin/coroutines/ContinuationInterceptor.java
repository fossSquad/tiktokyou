package ni.shikatu.kotlin.coroutines;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H&J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J(\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0096\u0002¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/coroutines/ContinuationInterceptor;", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lni/shikatu/kotlin/coroutines/Continuation;", "T", "continuation", "releaseInterceptedContinuation", "", "get", "E", "key", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "Key", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    @Override
    <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key);

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    @Override
    CoroutineContext minusKey(CoroutineContext.Key<?> key);

    void releaseInterceptedContinuation(Continuation<?> continuation);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(ContinuationInterceptor continuationInterceptor, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(continuationInterceptor, r, function2);
        }

        public static CoroutineContext plus(ContinuationInterceptor $this, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return CoroutineContext.Element.DefaultImpls.plus($this, context);
        }

        public static void releaseInterceptedContinuation(ContinuationInterceptor $this, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
        }

        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                if (!((AbstractCoroutineContextKey) key).isSubKey$kotlin_stdlib(continuationInterceptor.getKey())) {
                    return null;
                }
                E e = (E) ((AbstractCoroutineContextKey) key).tryCast$kotlin_stdlib(continuationInterceptor);
                if (e instanceof CoroutineContext.Element) {
                    return e;
                }
                return null;
            }
            if (ContinuationInterceptor.Key != key) {
                return null;
            }
            Intrinsics.checkNotNull(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return continuationInterceptor;
        }

        public static CoroutineContext minusKey(ContinuationInterceptor $this, CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                return (!((AbstractCoroutineContextKey) key).isSubKey$kotlin_stdlib($this.getKey()) || ((AbstractCoroutineContextKey) key).tryCast$kotlin_stdlib($this) == null) ? $this : EmptyCoroutineContext.INSTANCE;
            }
            return ContinuationInterceptor.Key == key ? EmptyCoroutineContext.INSTANCE : $this;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lni/shikatu/kotlin/coroutines/ContinuationInterceptor$Key;", "Lni/shikatu/kotlin/coroutines/CoroutineContext$Key;", "Lni/shikatu/kotlin/coroutines/ContinuationInterceptor;", "<init>", "()V", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        static final  Key $$INSTANCE = new Key();

        private Key() {
        }
    }
}
