package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.CoroutineContext;
import ni.shikatu.kotlin.coroutines.EmptyCoroutineContext;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugProbesKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\t\bF¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0082\u0004J\u000f\u0010\u0015\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0016J\u000f\u0010\u0017\u001a\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0016J\n\u0010\u0018\u001a\u00020\u0019H\u0082\u0080\u0004J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00028\u0000H\u0096À\u0004¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096À\u0004¢\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"H\u0096\u0080\u0004¢\u0006\u0002\u0010#R\u0013\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\fR\u0017\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u008e\b¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0015\u0010$\u001a\u00020%8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lni/shikatu/kotlin/sequences/SequenceBuilderIterator;", "T", "Lni/shikatu/kotlin/sequences/SequenceScope;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/coroutines/Continuation;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "state", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/sequences/State;", "nextValue", "Ljava/lang/Object;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", "nextNotReady", "exceptionalState", _UrlKt.FRAGMENT_ENCODE_SET, "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeWith", "result", "Lni/shikatu/kotlin/Result;", "(Ljava/lang/Object;)V", "context", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    private Iterator<? extends T> nextIterator;
    private Continuation<? super Unit> nextStep;
    private T nextValue;
    private int state;

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Continuation<Unit> getNextStep() {
        return this.nextStep;
    }

    public final void setNextStep(Continuation<? super Unit> continuation) {
        this.nextStep = continuation;
    }

    @Override
    public boolean hasNext() throws Throwable {
        while (true) {
            switch (this.state) {
                case 0:
                    break;
                case 1:
                    Iterator<? extends T> it = this.nextIterator;
                    Intrinsics.checkNotNull(it);
                    if (it.hasNext()) {
                        this.state = 2;
                        return true;
                    }
                    this.nextIterator = null;
                    break;
                    break;
                case 2:
                case 3:
                    return true;
                case 4:
                    return false;
                default:
                    throw exceptionalState();
            }
            this.state = 5;
            Continuation<? super Unit> continuation = this.nextStep;
            Intrinsics.checkNotNull(continuation);
            this.nextStep = null;
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(ni.shikatu.kotlin.Result.m6constructorimpl(unit));
        }
    }

    @Override
    public T next() throws Throwable {
        switch (this.state) {
            case 0:
            case 1:
                return nextNotReady();
            case 2:
                this.state = 1;
                Iterator<? extends T> it = this.nextIterator;
                Intrinsics.checkNotNull(it);
                return it.next();
            case 3:
                this.state = 0;
                T t = this.nextValue;
                this.nextValue = null;
                return t;
            default:
                throw exceptionalState();
        }
    }

    private final T nextNotReady() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    private final Throwable exceptionalState() {
        switch (this.state) {
            case 4:
                return new NoSuchElementException();
            case 5:
                return new IllegalStateException("Iterator has failed.");
            default:
                return new IllegalStateException("Unexpected state of the iterator: " + this.state);
        }
    }

    @Override
    public Object yield(T t, Continuation<? super Unit> continuation) {
        this.nextValue = t;
        this.state = 3;
        this.nextStep = continuation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }

    @Override
    public Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation) {
        if (!it.hasNext()) {
            return Unit.INSTANCE;
        }
        this.nextIterator = it;
        this.state = 2;
        this.nextStep = continuation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }

    @Override
    public void resumeWith(Object result) throws Throwable {
        ResultKt.throwOnFailure(result);
        this.state = 4;
    }

    @Override
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
