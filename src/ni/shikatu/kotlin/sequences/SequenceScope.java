package ni.shikatu.kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b@¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H¦À\u0004¢\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH¦À\u0004¢\u0006\u0002\u0010\fJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086À\u0004¢\u0006\u0002\u0010\u000fJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086À\u0004¢\u0006\u0002\u0010\u0012Ê\u0001\u0002\b\u0014Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlin/sequences/SequenceScope;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "yield", _UrlKt.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sequence", "Lni/shikatu/kotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/coroutines/RestrictsSuspension;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class SequenceScope<T> {
    public abstract Object yield(T t, Continuation<? super Unit> continuation);

    public abstract Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation);

    public final Object yieldAll(Iterable<? extends T> iterable, Continuation<? super Unit> continuation) {
        return ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) ? Unit.INSTANCE : yieldAll(iterable.iterator(), continuation);
    }

    public final Object yieldAll(Sequence<? extends T> sequence, Continuation<? super Unit> continuation) {
        return yieldAll(sequence.iterator(), continuation);
    }
}
