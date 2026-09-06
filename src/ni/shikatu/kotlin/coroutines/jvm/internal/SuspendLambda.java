package ni.shikatu.kotlin.coroutines.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.jvm.internal.FunctionBase;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004B#\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\bV\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rÊ\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/SuspendLambda;", "Lni/shikatu/kotlin/coroutines/jvm/internal/ContinuationImpl;", "Lni/shikatu/kotlin/jvm/internal/FunctionBase;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/coroutines/jvm/internal/SuspendFunction;", "arity", _UrlKt.FRAGMENT_ENCODE_SET, "completion", "Lni/shikatu/kotlin/coroutines/Continuation;", "<init>", "(ILkotlin/coroutines/Continuation;)V", "(I)V", "getArity", "()I", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class SuspendLambda extends ContinuationImpl implements FunctionBase<Object>, SuspendFunction {
    private final int arity;

    public SuspendLambda(int arity, Continuation<Object> continuation) {
        super(continuation);
        this.arity = arity;
    }

    @Override
    public int getArity() {
        return this.arity;
    }

    public SuspendLambda(int arity) {
        this(arity, null);
    }

    @Override
    public String toString() {
        if (getCompletion() == null) {
            String strRenderLambdaToString = Reflection.renderLambdaToString(this);
            Intrinsics.checkNotNullExpressionValue(strRenderLambdaToString, "renderLambdaToString(...)");
            return strRenderLambdaToString;
        }
        return super.toString();
    }
}
