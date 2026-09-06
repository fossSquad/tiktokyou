package ni.shikatu.kotlin.coroutines.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aa\u0010\u0000\u001a\u0002H\u0001\"\u0014\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\r\u001a\u0002H\u0001H\u0081\u0080\u0004b\u0002\b\u000f¢\u0006\u0002\u0010\u000e\u001a]\u0010\u0010\u001a\u0002H\u0001\"\u0014\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\r\u001a\u0002H\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010\u000e¨\u0006\u0011"}, d2 = {"wrapContinuation", "T", "Lni/shikatu/kotlin/coroutines/Continuation;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/coroutines/jvm/internal/CoroutineStackFrame;", "declaringClass", _UrlKt.FRAGMENT_ENCODE_SET, "methodName", "fileName", "lineNumber", _UrlKt.FRAGMENT_ENCODE_SET, "spilledVariables", _UrlKt.FRAGMENT_ENCODE_SET, "continuation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "Lni/shikatu/kotlin/PublishedApi;", "wrapContinuationReal", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class TailCallAsyncStackTraceEntryKt {

    public static final Continuation wrapContinuation(String declaringClass, String methodName, String fileName, int lineNumber, Object[] spilledVariables, Continuation continuation) {
        Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(spilledVariables, "spilledVariables");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continuation;
    }

    public static final Continuation wrapContinuationReal(String declaringClass, String methodName, String fileName, int lineNumber, Object[] spilledVariables, Continuation continuation) {
        Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(spilledVariables, "spilledVariables");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return new TailCallBaseContinuationImpl(declaringClass, methodName, fileName, lineNumber, spilledVariables, continuation);
    }
}
