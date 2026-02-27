package ni.shikatu.kotlin.coroutines;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NotImplementedError;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugProbesKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0087\b\u001a<\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001a\u00020\u000b2\u001a\b\u0004\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rH\u0087\bø\u0001\u0000\u001aA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u0002H\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0017\u001a;\u0010\u0018\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0019\u001aT\u0010\u0018\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u0002H\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a=\u0010\u001b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0004\u0012\u00020\u00010\rH\u0087H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001d\"\u001b\u0010\u001e\u001a\u00020\u000b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"resume", "", "T", "Lni/shikatu/kotlin/coroutines/Continuation;", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "Continuation", "context", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "resumeWith", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/Result;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineContext", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ContinuationKt {
    public static  void getCoroutineContext$annotations() {
    }

    private static final <T> void resume(Continuation<? super T> continuation, T t) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m4constructorimpl(t));
    }

    private static final <T> void resumeWithException(Continuation<? super T> continuation, Throwable exception) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m4constructorimpl(ResultKt.createFailure(exception)));
    }

    private static final <T> Continuation<T> Continuation(final CoroutineContext context, final Function1<? super Result<? extends T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "resumeWith");
        return new Continuation<T>() {
            @Override
            public CoroutineContext getContext() {
                return context;
            }

            @Override
            public void resumeWith(Object result) {
                function1.invoke(Result.m3boximpl(result));
            }
        };
    }

    public static final <T> Continuation<Unit> createCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, continuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final <R, T> Continuation<Unit> createCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, continuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final <T> void startCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Continuation continuationIntercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, continuation));
        Result.Companion companion = Result.Companion;
        continuationIntercepted.resumeWith(Result.m4constructorimpl(Unit.INSTANCE));
    }

    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Continuation continuationIntercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, continuation));
        Result.Companion companion = Result.Companion;
        continuationIntercepted.resumeWith(Result.m4constructorimpl(Unit.INSTANCE));
    }

    private static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) throws Throwable {
        InlineMarker.mark(0);
        SafeContinuation safe = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function1.invoke(safe);
        Object orThrow = safe.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return orThrow;
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }
}
