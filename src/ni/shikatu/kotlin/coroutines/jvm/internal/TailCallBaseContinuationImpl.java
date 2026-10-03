package ni.shikatu.kotlin.coroutines.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.CoroutineContext;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0001\u0018\u00002\u00020\u0001BI\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0018\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001aH\u0094\u0080\u0004¢\u0006\u0002\u0010\u001bJ\n\u0010\u001c\u001a\u00020\u001dH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0005\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0006\u001a\u00020\u0007X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b \u0010!Ê\u0001\u0002\b#¨\u0006\""}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/TailCallBaseContinuationImpl;", "Lni/shikatu/kotlin/coroutines/jvm/internal/BaseContinuationImpl;", "declaringClass", _UrlKt.FRAGMENT_ENCODE_SET, "methodName", "fileName", "lineNumber", _UrlKt.FRAGMENT_ENCODE_SET, "spilledVariables", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "continuation", "Lni/shikatu/kotlin/coroutines/Continuation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "getDeclaringClass", "()Ljava/lang/String;", "getMethodName", "getFileName", "getLineNumber", "()I", "getSpilledVariables", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "invokeSuspend", "result", "Lni/shikatu/kotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "context", "Lni/shikatu/kotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/PublishedApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class TailCallBaseContinuationImpl extends BaseContinuationImpl {
    private final Continuation<Object> continuation;
    private final String declaringClass;
    private final String fileName;
    private final int lineNumber;
    private final String methodName;
    private final Object[] spilledVariables;

    public TailCallBaseContinuationImpl(String declaringClass, String methodName, String fileName, int lineNumber, Object[] spilledVariables, Continuation<Object> continuation) {
        super(continuation);
        Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(spilledVariables, "spilledVariables");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.declaringClass = declaringClass;
        this.methodName = methodName;
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.spilledVariables = spilledVariables;
        this.continuation = continuation;
    }

    public final String getDeclaringClass() {
        return this.declaringClass;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final Object[] getSpilledVariables() {
        return this.spilledVariables;
    }

    @Override
    protected Object invokeSuspend(Object result) throws Throwable {
        ResultKt.throwOnFailure(result);
        return result;
    }

    @Override
    public StackTraceElement getStackTraceElement() {
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(this);
        String moduleAndClass = moduleName == null ? this.declaringClass : moduleName + '/' + this.declaringClass;
        return new StackTraceElement(moduleAndClass, this.methodName, this.fileName, this.lineNumber);
    }

    @Override
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }
}
