package ni.shikatu.kotlin.coroutines.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H¦\u0080\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/CoroutineStackFrame;", _UrlKt.FRAGMENT_ENCODE_SET, "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface CoroutineStackFrame {
    CoroutineStackFrame getCallerFrame();

    StackTraceElement getStackTraceElement();
}
