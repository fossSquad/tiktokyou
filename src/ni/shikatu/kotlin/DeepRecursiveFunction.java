package ni.shikatu.kotlin;

import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BD\bF\u00129\u0010\u0004\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nRJ\u0010\u0004\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\b\bX\u0080\u0084\b¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/DeepRecursiveFunction;", "T", "R", _UrlKt.FRAGMENT_ENCODE_SET, "block", "Lni/shikatu/kotlin/Function3;", "Lni/shikatu/kotlin/DeepRecursiveScope;", "Lni/shikatu/kotlin/coroutines/Continuation;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "getBlock$kotlin_stdlib", "()Lkotlin/jvm/functions/Function3;", "Lni/shikatu/kotlin/jvm/functions/Function3;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.7"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class DeepRecursiveFunction<T, R> {
    private final Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> block;

    public DeepRecursiveFunction(Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        this.block = function3;
    }

    public final Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> getBlock$kotlin_stdlib() {
        return this.block;
    }
}
