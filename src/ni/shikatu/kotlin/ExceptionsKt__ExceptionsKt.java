package ni.shikatu.kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import ni.shikatu.kotlin.internal.PlatformImplementationsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u001a(\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0087\u0080\u0004b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016b\u0002\b\u0017\"%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u00028FX\u0086\u0084\b¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"3\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019*\u00020\u00028FX\u0087\u0084\br\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\f\u0012\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"printStackTrace", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", "writer", "Ljava/io/PrintWriter;", "stream", "Ljava/io/PrintStream;", "stackTrace", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "stackTraceToString", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4", "addSuppressed", "exception", "1.1", "Lni/shikatu/kotlin/internal/HidesMembers;", "suppressedExceptions", _UrlKt.FRAGMENT_ENCODE_SET, "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/ExceptionsKt")
public class ExceptionsKt__ExceptionsKt {
    public static  void getStackTrace$annotations(Throwable th) {
    }

    public static  void getSuppressedExceptions$annotations(Throwable th) {
    }

    private static final void printStackTrace(Throwable $this$printStackTrace) {
        Intrinsics.checkNotNullParameter($this$printStackTrace, "<this>");
        $this$printStackTrace.printStackTrace();
    }

    private static final void printStackTrace(Throwable $this$printStackTrace, PrintWriter writer) {
        Intrinsics.checkNotNullParameter($this$printStackTrace, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        $this$printStackTrace.printStackTrace(writer);
    }

    private static final void printStackTrace(Throwable $this$printStackTrace, PrintStream stream) {
        Intrinsics.checkNotNullParameter($this$printStackTrace, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        $this$printStackTrace.printStackTrace(stream);
    }

    public static final StackTraceElement[] getStackTrace(Throwable $this$stackTrace) {
        Intrinsics.checkNotNullParameter($this$stackTrace, "<this>");
        StackTraceElement[] stackTrace = $this$stackTrace.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }

    public static final String stackTraceToString(Throwable $this$stackTraceToString) {
        Intrinsics.checkNotNullParameter($this$stackTraceToString, "<this>");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        $this$stackTraceToString.printStackTrace(pw);
        pw.flush();
        String string = sw.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final void addSuppressed(Throwable $this$addSuppressed, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter($this$addSuppressed, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ($this$addSuppressed != exception) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed($this$addSuppressed, exception);
        }
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable $this$suppressedExceptions) {
        Intrinsics.checkNotNullParameter($this$suppressedExceptions, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed($this$suppressedExceptions);
    }
}
