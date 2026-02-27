package ni.shikatu.kotlin.coroutines.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.jvm.internal.FunctionBase;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/RestrictedSuspendLambda;", "Lni/shikatu/kotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lni/shikatu/kotlin/jvm/internal/FunctionBase;", "", "Lni/shikatu/kotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "completion", "Lni/shikatu/kotlin/coroutines/Continuation;", "<init>", "(ILkotlin/coroutines/Continuation;)V", "(I)V", "getArity", "()I", "toString", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements FunctionBase<Object>, SuspendFunction {
    private final int arity;

    @Override
    public int getArity() {
        return this.arity;
    }

    public RestrictedSuspendLambda(int arity, Continuation<Object> continuation) {
        super(continuation);
        this.arity = arity;
    }

    public RestrictedSuspendLambda(int arity) {
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
