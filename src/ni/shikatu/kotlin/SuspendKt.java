package ni.shikatu.kotlin;

import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a`\u0010\u0000\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\"\u0004\b\u0000\u0010\u00032\u001e\b\b\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0087\u0088\u0004b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"suspend", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/coroutines/Continuation;", "R", _UrlKt.FRAGMENT_ENCODE_SET, "block", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class SuspendKt {

    private static final <R> Function1<Continuation<? super R>, Object> suspend(Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return (Function1<Continuation<? super R>,Object>) (function1);
    }
}
