package ni.shikatu.kotlin.coroutines;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001d\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0080\u0004¢\u0006\u0002\u0010\u000bR\u0013\u0010\u0003\u001a\u00020\u0004X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¨\u0006\f"}, d2 = {"Lni/shikatu/kotlin/coroutines/Continuation;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "context", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", _UrlKt.FRAGMENT_ENCODE_SET, "result", "Lni/shikatu/kotlin/Result;", "(Ljava/lang/Object;)V", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface Continuation<T> {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
