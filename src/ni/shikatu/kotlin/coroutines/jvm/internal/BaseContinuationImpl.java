package ni.shikatu.kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u001b\bF\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rH\u0086\u0080\u0004¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rH¤\u0080\u0004¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u00020\u000bH\u0094\u0080\u0004J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0096\u0080\u0004J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\f\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0080\u0004R\u001f\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001eÊ\u0001\u0002\b\u001f¨\u0006\u001b"}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lni/shikatu/kotlin/coroutines/Continuation;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "<init>", "(Lkotlin/coroutines/Continuation;)V", "getCompletion", "()Lkotlin/coroutines/Continuation;", "resumeWith", _UrlKt.FRAGMENT_ENCODE_SET, "result", "Lni/shikatu/kotlin/Result;", "(Ljava/lang/Object;)V", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "create", "value", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/PublishedApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    protected abstract Object invokeSuspend(Object obj);

    public BaseContinuationImpl(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override
    public final void resumeWith(Object result) {
        Object outcome;
        Object current = this;
        Object param = result;
        while (true) {
            DebugProbesKt.probeCoroutineResumed((Continuation) current);
            BaseContinuationImpl $this$resumeWith_u24lambda_u240 = (BaseContinuationImpl) current;
            Continuation<Object> continuation = $this$resumeWith_u24lambda_u240.completion;
            Intrinsics.checkNotNull(continuation);
            try {
                Object outcome2 = $this$resumeWith_u24lambda_u240.invokeSuspend(param);
                if (outcome2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return;
                }
                Result.Companion companion = Result.Companion;
                outcome = ni.shikatu.kotlin.Result.m6constructorimpl(outcome2);
            } catch (Throwable exception) {
                Result.Companion companion2 = Result.Companion;
                outcome = ni.shikatu.kotlin.Result.m6constructorimpl(ResultKt.createFailure(exception));
            }
            $this$resumeWith_u24lambda_u240.releaseIntercepted();
            if (continuation instanceof BaseContinuationImpl) {
                current = continuation;
                param = outcome;
            } else {
                continuation.resumeWith(outcome);
                return;
            }
        }
    }

    protected void releaseIntercepted() {
    }

    public Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public Continuation<Unit> create(Object value, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        return sbAppend.append(stackTraceElement).toString();
    }

    @Override
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override
    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement(this);
    }
}
