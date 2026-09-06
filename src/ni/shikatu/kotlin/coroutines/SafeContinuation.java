package ni.shikatu.kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.SafePublicationLazyImpl$$ExternalSyntheticBackportWithForwarding0;
import ni.shikatu.kotlin.coroutines.intrinsics.CoroutineSingletons;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001cB!\b@\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\bQ\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u0002\b\n¢\u0006\u0004\b\u0007\u0010\tJ\u001d\u0010\u0010\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0081\u0080\u0004b\u0002\b\nJ\f\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0080\u0004R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017Ê\u0001\u0002\b\nÊ\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( ¨\u0006\u001d"}, d2 = {"Lni/shikatu/kotlin/coroutines/SafeContinuation;", "T", "Lni/shikatu/kotlin/coroutines/Continuation;", "Lni/shikatu/kotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "initialResult", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "(Lkotlin/coroutines/Continuation;)V", "Lni/shikatu/kotlin/PublishedApi;", "context", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "resumeWith", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Result;", "(Ljava/lang/Object;)V", "getOrThrow", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    private static final Companion Companion = new Companion(null);
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    private final Continuation<T> delegate;
    private volatile Object result;

    public SafeContinuation(Continuation<? super T> continuation, Object initialResult) {
        Intrinsics.checkNotNullParameter(continuation, "delegate");
        this.delegate = continuation;
        this.result = initialResult;
    }

    public SafeContinuation(Continuation<? super T> continuation) {
        this(continuation, CoroutineSingletons.UNDECIDED);
        Intrinsics.checkNotNullParameter(continuation, "delegate");
    }

    @Override
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003RY\u0010\u0004\u001aF\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001 \u0007*\"\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00050\u0005X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/coroutines/SafeContinuation$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lni/shikatu/kotlin/coroutines/SafeContinuation;", "ni.shikatu.kotlin.jvm.PlatformType", "getRESULT$annotations", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static  void getRESULT$annotations() {
        }

        private Companion() {
        }
    }

    @Override
    public void resumeWith(Object result) {
        while (true) {
            Object cur = this.result;
            if (cur == CoroutineSingletons.UNDECIDED) {
                if (SafePublicationLazyImpl$$ExternalSyntheticBackportWithForwarding0.m(RESULT, this, CoroutineSingletons.UNDECIDED, result)) {
                    return;
                }
            } else {
                if (cur != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (SafePublicationLazyImpl$$ExternalSyntheticBackportWithForwarding0.m(RESULT, this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED)) {
                    this.delegate.resumeWith(result);
                    return;
                }
            }
        }
    }

    public final Object getOrThrow() throws Throwable {
        Object result = this.result;
        if (result == CoroutineSingletons.UNDECIDED) {
            if (SafePublicationLazyImpl$$ExternalSyntheticBackportWithForwarding0.m(RESULT, this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            result = this.result;
        }
        if (result == CoroutineSingletons.RESUMED) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (result instanceof Result.Failure) {
            throw ((Result.Failure) result).exception;
        }
        return result;
    }

    @Override
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }
}
