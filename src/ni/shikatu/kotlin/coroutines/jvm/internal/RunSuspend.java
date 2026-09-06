package ni.shikatu.kotlin.coroutines.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.CoroutineContext;
import ni.shikatu.kotlin.coroutines.EmptyCoroutineContext;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0096\u0080\u0004¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u00020\u0002H\u0086\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nX\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/RunSuspend;", "Lni/shikatu/kotlin/coroutines/Continuation;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "context", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "Lni/shikatu/kotlin/Result;", "getResult-xLWZpok", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "resumeWith", "(Ljava/lang/Object;)V", "await", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class RunSuspend implements Continuation<Unit> {
    private Result<Unit> result;

    @Override
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final Result<Unit> m1239getResultxLWZpok() {
        return this.result;
    }

    public final void setResult(Result<Unit> result) {
        this.result = result;
    }

    @Override
    public void resumeWith(Object result) {
        synchronized (this) {
            this.result = Result.m5boximpl(result);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void await() {
        synchronized (this) {
            while (true) {
                Result<Unit> result = this.result;
                if (result == null) {
                    Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                    wait();
                } else {
                    ResultKt.throwOnFailure(result.m15unboximpl());
                }
            }
        }
    }
}
