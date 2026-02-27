package ni.shikatu.kotlin.coroutines.cancellation;

import java.util.concurrent.CancellationException;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a!\u0010\u0000\u001a\u00060\u0001j\u0002`\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0087\b\u001a\u0017\u0010\u0000\u001a\u00060\u0001j\u0002`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0087\b*\u001a\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004¨\u0006\n"}, d2 = {"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4", "Lni/shikatu/kotlin/coroutines/cancellation/CancellationException;", "message", "", "cause", "", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CancellationExceptionKt {
    public static  void CancellationException$annotations() {
    }

    private static final CancellationException CancellationException(String message, Throwable cause) {
        CancellationException it = new CancellationException(message);
        it.initCause(cause);
        return it;
    }

    private static final CancellationException CancellationException(Throwable cause) {
        CancellationException it = new CancellationException(cause != null ? cause.toString() : null);
        it.initCause(cause);
        return it;
    }
}
