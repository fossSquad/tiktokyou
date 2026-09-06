package ni.shikatu.kotlin.coroutines.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a$\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a$\u0010\n\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¨\u0006\u000b"}, d2 = {"probeCoroutineCreated", "Lni/shikatu/kotlin/coroutines/Continuation;", "T", "completion", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "probeCoroutineResumed", _UrlKt.FRAGMENT_ENCODE_SET, "frame", "probeCoroutineSuspended", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DebugProbesKt {

    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return continuation;
    }

    public static final void probeCoroutineResumed(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "frame");
    }

    public static final void probeCoroutineSuspended(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "frame");
    }
}
