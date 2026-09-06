package ni.shikatu.kotlin.coroutines.intrinsics;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NotImplementedError;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aR\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001c\b\u0004\u0010\u0002\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0087È\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0006\")\u0010\u000b\u001a\u00020\u00058FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"suspendCoroutineUninterceptedOrReturn", "T", "block", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/coroutines/Continuation;", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/internal/InlineOnly;", "COROUTINE_SUSPENDED", "getCOROUTINE_SUSPENDED$annotations", "()V", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/coroutines/intrinsics/IntrinsicsKt")
public class IntrinsicsKt__IntrinsicsKt extends IntrinsicsKt__IntrinsicsJvmKt {
    public static  void getCOROUTINE_SUSPENDED$annotations() {
    }

    private static final <T> Object suspendCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        throw new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }

    public static final Object getCOROUTINE_SUSPENDED() {
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }
}
