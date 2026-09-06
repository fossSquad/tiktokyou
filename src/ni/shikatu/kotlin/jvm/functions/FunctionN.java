package ni.shikatu.kotlin.jvm.functions;

import ni.shikatu.kotlin.Function;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.FunctionBase;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J'\u0010\u0004\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H¦\u0082\u0004¢\u0006\u0002\u0010\bR\u0013\u0010\t\u001a\u00020\nX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/jvm/functions/FunctionN;", "R", "Lni/shikatu/kotlin/Function;", "Lni/shikatu/kotlin/jvm/internal/FunctionBase;", "invoke", "args", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "arity", _UrlKt.FRAGMENT_ENCODE_SET, "getArity", "()I", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface FunctionN<R> extends Function<R>, FunctionBase<R> {
    @Override
    int getArity();

    R invoke(Object... objArr);
}
